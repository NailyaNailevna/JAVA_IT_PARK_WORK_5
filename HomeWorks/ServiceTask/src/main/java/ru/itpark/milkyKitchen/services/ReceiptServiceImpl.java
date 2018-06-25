package ru.itpark.milkyKitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.milkyKitchen.dto.BabyFoodReceiptDto;
import ru.itpark.milkyKitchen.dto.DepartmentDto;
import ru.itpark.milkyKitchen.forms.BabyFoodReceiptForm;
import ru.itpark.milkyKitchen.models.BabyFoodReceiptEntity;
import ru.itpark.milkyKitchen.models.DepartmentEntity;
import ru.itpark.milkyKitchen.repositories.DepartmentRepository;
import ru.itpark.milkyKitchen.repositories.ReceiptRepository;

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
                    .id(bfreceipt.getId())
                    .series(bfreceipt.getSeries())
                    .num(bfreceipt.getNum())
                    .issueDt(bfreceipt.getIssueDt())
                    .beginDate(bfreceipt.getBeginDate())
                    .endDate(bfreceipt.getEndDate())
                    .patientId(bfreceipt.getPatient().getId())
                    .patientFio(bfreceipt.getPatient().getFio())
                    .birthDate(bfreceipt.getReceipt().getPatient().getBirthDate())
                    .ageCategoryId(bfreceipt.getAgeCategoryId())
                    .benefitDefinitionId(bfreceipt.getBenefitDefinitionId())
                    .kitchenId(bfreceipt.getKitchen().getId())
                    .kitchenName(bfreceipt.getKitchen().getName())
                    .clinicId(bfreceipt.getReceipt().getClinic().getId())
                    .emplPosId(bfreceipt.getReceipt().getEmplPos().getId())
                    .emplPosName(bfreceipt.getReceipt().getEmplPos().getEmployee().getIndiv().getFio())
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
/*
    @Override
    public Integer addReceipt(BabyFoodReceiptForm receipt) {

        BabyFoodReceiptEntity newBabyFoodReceipt = BabyFoodReceiptEntity.builder()
                .receiptTypeId(receipt.getTypeId())
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
    }
*/

}
