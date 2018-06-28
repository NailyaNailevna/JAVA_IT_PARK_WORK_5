package ru.itpark.milkyKitchen.services;

import ru.itpark.milkyKitchen.dto.IssueProductDto;

import java.util.List;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

public interface IssueProductService {
    List<IssueProductDto> getAllIssues();
//    (Integer receiptId)

//    Integer addReceipt(IssueProductForm issueProductForm);
//List<IssueProductEntity> findById(String id, String vol);
}
