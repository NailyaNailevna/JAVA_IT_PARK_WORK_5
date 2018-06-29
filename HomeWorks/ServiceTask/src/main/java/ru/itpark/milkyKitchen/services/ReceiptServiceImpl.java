package ru.itpark.milkyKitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.milkyKitchen.dto.*;
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

    @Autowired
    private BabyFoodReceiptRepository babyFoodReceiptRepository;


    public List<BabyFoodReceiptDto> getAllReceipts() {
        List<BabyFoodReceiptEntity> bfreceipts = babyFoodReceiptRepository.findAll();

        List<BabyFoodReceiptDto> receiptDtos = new ArrayList<>();
        for (BabyFoodReceiptEntity bfreceipt : bfreceipts) {
            receiptDtos.add(BabyFoodReceiptDto.builder()
                    .id(bfreceipt.getReceiptId().getId())
                    .series(bfreceipt.getReceiptId().getSeries())
                    .num(bfreceipt.getReceiptId().getNum())
                    .issueDt(bfreceipt.getReceiptId().getIssueDt())
                    .beginDate(bfreceipt.getBeginDate())
                    .endDate(bfreceipt.getEndDate())
                    .patientId(bfreceipt.getReceiptId().getPatientId().getId())
                    .patientFio(bfreceipt.getReceiptId().getPatientId().getFio())
                    .birthDate(bfreceipt.getReceiptId().getPatientId().getBirthDate())
                    .ageCategoryId(bfreceipt.getAgeCategoryId())
                    .benefitDefinitionId(bfreceipt.getBenefitDefinitionId())
                    .kitchenId(bfreceipt.getKitchenId().getId())
                    .kitchenName(bfreceipt.getKitchenId().getName())
                    .clinicId(bfreceipt.getReceiptId().getClinicId())
                    .emplPosId(bfreceipt.getReceiptId().getEmplPosId().getId())
                    .emplPosName(bfreceipt.getReceiptId().getEmplPosId().getEmployee().getIndiv().getFio())
                    .canceled(bfreceipt.getReceiptId().isCanceled())
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
        List<IndividualEntity> individuals = individualRepository.findAll();

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

    @Transactional
    @Override
    public void addReceipt(BabyFoodReceiptForm receipt) {

        IndividualEntity patientId = individualRepository.findOneById(receipt.getPatientId()).get();

        DiagnosisEntity diagId = (!receipt.getDiagnosisId().equals(-1))?diagnosisRepository.findOneById(receipt.getDiagnosisId()).get():null;

        EmployeePositionEntity emplPosId = emplPosRepository.find(receipt.getEmployeePositionId());
//        System.out.println(emplPosId.getEmployee());

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

        receiptRepository.save(newReceipt);
        ReceiptEntity breceptId = receiptRepository.findOneByIdO(newReceipt.getId()).get();

        DepartmentEntity depId = departmentRepository.findOneById(receipt.getKitchenId()).get();

        BabyFoodReceiptEntity newFoodreceipt = BabyFoodReceiptEntity.builder()
                .id(breceptId.getId())
                .beginDate(receipt.getBeginDt())
                .endDate(receipt.getEndDt())
                .ageCategoryId(receipt.getAgeCategoryId())
                .benefitDefinitionId(receipt.getBenefitDefinitionId())
                .kitchenId(depId)
                .build();

        babyFoodReceiptRepository.save(newFoodreceipt);
    }

    @Override
    public ReceiptDto delete(Integer receiptId) {
        ReceiptEntity receipt = receiptRepository.findOne(receiptId);
        receipt.setCanceled(true);
        receiptRepository.save(receipt);

        return ReceiptDto.builder()
                .canceled(receipt.isCanceled())
                .build();
    }

}
