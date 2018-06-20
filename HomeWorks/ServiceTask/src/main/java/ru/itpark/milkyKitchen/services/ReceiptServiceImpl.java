package ru.itpark.milkyKitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.milkyKitchen.dto.BabyFoodReceiptDto;
import ru.itpark.milkyKitchen.models.BabyFoodReceiptEntity;
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
                    .birthDate(bfreceipt.getReceipt().getPatient().getBirthDate())
                    .ageCategoryId(bfreceipt.getAgeCategoryId())
                    .benefitDefinitionId(bfreceipt.getBenefitDefinitionId())
                    .kitchenId(bfreceipt.getKitchen().getId())
                    .clinicId(bfreceipt.getReceipt().getClinic().getId())
                    .emplPosId(bfreceipt.getReceipt().getEmplPos().getId())
                    .build()
            );
        }
        return receiptDtos;
    }


}
