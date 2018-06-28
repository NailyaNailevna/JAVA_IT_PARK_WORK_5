package ru.itpark.milkyKitchen.services;

import ru.itpark.milkyKitchen.dto.*;
import ru.itpark.milkyKitchen.forms.BabyFoodReceiptForm;

import java.util.List;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

public interface ReceiptService {
    List<BabyFoodReceiptDto> getAllReceipts();

    List<DepartmentDto> getKitchens();

    List<DiagnosisDto> getDiagnosis();

    List<IndividualDto> getIndividuals();

    void addReceipt(BabyFoodReceiptForm babyFoodReceiptForm);

    ReceiptDto delete(Integer receiptId);
}
