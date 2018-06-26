package ru.itpark.milkyKitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.milkyKitchen.dto.BabyFoodReceiptDto;
import ru.itpark.milkyKitchen.dto.DepartmentDto;
import ru.itpark.milkyKitchen.dto.DiagnosisDto;
import ru.itpark.milkyKitchen.dto.IndividualDto;
import ru.itpark.milkyKitchen.forms.BabyFoodReceiptForm;
import ru.itpark.milkyKitchen.models.*;
import ru.itpark.milkyKitchen.repositories.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

@Component
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;


    public List<BabyFoodReceiptDto> getAllReceipts() {
        List<BabyFoodReceiptEntity> bfreceipts = receiptRepository.findAll();

        List<BabyFoodReceiptDto> receiptDtos = new ArrayList<>();
        for (BabyFoodReceiptEntity bfreceipt : bfreceipts) {
            receiptDtos.add(BabyFoodReceiptDto.builder()
                    .id(bfreceipt.getReceipt().getId())
                    .series(bfreceipt.getReceipt().getSeries())
                    .num(bfreceipt.getReceipt().getNum())
                    .issueDt(bfreceipt.getReceipt().getIssueDt())
                    .beginDate(bfreceipt.getBeginDate())
                    .endDate(bfreceipt.getEndDate())
                    .patientId(bfreceipt.getReceipt().getPatientId().getId())
                    .patientFio(bfreceipt.getReceipt().getPatientId().getFio())
                    .birthDate(bfreceipt.getReceipt().getPatientId().getBirthDate())
                    .ageCategoryId(bfreceipt.getAgeCategoryId())
                    .benefitDefinitionId(bfreceipt.getBenefitDefinitionId())
                    .kitchenId(bfreceipt.getKitchen().getId())
                    .kitchenName(bfreceipt.getKitchen().getName())
                    .clinicId(bfreceipt.getReceipt().getClinicId())
                    .emplPosId(bfreceipt.getReceipt().getEmplPosId().getId())
                    .emplPosName(bfreceipt.getReceipt().getEmplPosId().getEmployee().getIndiv().getFio())
                    .build()
            );
        }
        return receiptDtos;
    }

    @Autowired
    private DepartmentRepository departmentRepository;

//    @Override
    public List<DepartmentDto> getKitchens() {
        List<DepartmentEntity> kitchens = departmentRepository.findByClinicId();

        List<DepartmentDto> kitchenDtos = new ArrayList<>();
        for (DepartmentEntity kitchen : kitchens) {
            kitchenDtos.add(DepartmentDto.builder()
                       .id(kitchen.getId())
                        .name(kitchen.getName())
                    .build());
        }
        return kitchenDtos;
    }

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    //    @Override
    public List<DiagnosisDto> getDiagnosis() {
        List<DiagnosisEntity> diagnosis = diagnosisRepository.findAllMilky();

        List<DiagnosisDto> diagnosisDtos = new ArrayList<>();
        for (DiagnosisEntity diagnos : diagnosis) {
            diagnosisDtos.add(DiagnosisDto.builder()
                    .id(diagnos.getId())
                    .code(diagnos.getCode())
                    .name(diagnos.getName())
                    .build());
        }
        return diagnosisDtos;
    }

    @Autowired
    private IndividualRepository individualRepository;

    //    @Override
    public List<IndividualDto> getIndividuals() {
        List<IndividualEntity> individuals = individualRepository.findAllByFIO();

        List<IndividualDto> individualDtos = new ArrayList<>();
        for (IndividualEntity individual : individuals) {
            individualDtos.add(IndividualDto.builder()
                    .id(individual.getId())
                    .fio(individual.getFio())
                    .birthDate(individual.getBirthDate())
                    .build());
        }
        return individualDtos;
    }

    @Autowired
    private EmplPosRepository emplPosRepository;

    @Override
    public Integer addReceipt(BabyFoodReceiptForm receipt) {
/*
        BabyFoodReceiptEntity newBabyFoodReceipt = BabyFoodReceiptEntity.builder()
                .typeId(receipt.getTypeId())
                .signId(receipt.getSignId())
                .series(receipt.getSeries())
                .num(receipt.getNum())
                .issueDate(receipt.getIssueDt())
                .beginDate(receipt.getBeginDt())
                .endDate(receipt.getEndDt())
                .patientId(receipt.getPatientId())
                .ageCategoryId(receipt.getAgeCategoryId())
                .benefitDefinitionId(receipt.getBenefitDefinitionId())
                .diagnosisId(receipt.getDiagnosisId())
                .kitchenId(receipt.getKitchenId())
                .clinicId(receipt.getClinicId())
                .emplPosId(receipt.getEmployeePositionId())
                .build();

        receiptRepository.save(newBabyFoodReceipt);
*/
        IndividualEntity patientId = individualRepository.findById(receipt.getPatientId()).get();
        DiagnosisEntity diagId = diagnosisRepository.findById(receipt.getDiagnosisId()).get();
        EmployeePositionEntity emplPosId = emplPosRepository.findById(receipt.getEmployeePositionId()).get();

        ReceiptEntity newReceipt = ReceiptEntity.builder()
                .typeId(receipt.getTypeId())
                .signId(receipt.getSignId())
                .series(receipt.getSeries())
                .num(receipt.getNum())
                .issueDt(receipt.getIssueDt())
                .patientId(patientId)
                .diagnosisId(diagId)
                .clinicId(receipt.getClinicId())
                .emplPosId(emplPosId)
                .build();

        Integer rId = receiptRepository.save(newReceipt);
        ReceiptEntity breceptId = ReceiptRepository.findById(rId).get();

        DepartmentEntity depId = departmentRepository.findOne(receipt.getKitchenId()).get();

        BabyFoodReceiptEntity newFoodreceipt = BabyFoodReceiptEntity.builder()
                .receiptId(breceiptId)
                .beginDate(receipt.getBeginDt())
                .endDate(receipt.getEndDt())
                .ageCategoryId(receipt.getAgeCategoryId())
                .benefitDefinitionId(receipt.getBenefitDefinitionId())
                .kitchenId(depId)
                .build();
        /*

                .beginDate(receipt.getBeginDt())
                .endDate(receipt.getEndDt())
                .ageCategoryId(receipt.getAgeCategoryId())
                .benefitDefinitionId(receipt.getBenefitDefinitionId())
                .kitchenId(kitchenId)
         */
    }

}
