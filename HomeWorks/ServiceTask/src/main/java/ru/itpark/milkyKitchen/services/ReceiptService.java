package ru.itpark.milkyKitchen.services;

import ru.itpark.milkyKitchen.dto.BabyFoodReceiptDto;

import java.util.List;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

public interface ReceiptService {
    List<BabyFoodReceiptDto> getAllReceipts();
}
