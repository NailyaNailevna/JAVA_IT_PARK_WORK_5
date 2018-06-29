package ru.itpark.milkyKitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.milkyKitchen.dto.IssueProductDto;
import ru.itpark.milkyKitchen.models.IssueProductEntity;
import ru.itpark.milkyKitchen.models.ReceiptEntity;
import ru.itpark.milkyKitchen.repositories.IssueProductRepository;
import ru.itpark.milkyKitchen.repositories.ReceiptRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

@Component
public class IssueProductServiceImpl implements IssueProductService{

    @Autowired
    private IssueProductRepository issueProductRepository;


    public List<IssueProductDto> getAllIssues() {
        List<IssueProductEntity> products = issueProductRepository.getAllIssues();

        List<IssueProductDto> productDtos = new ArrayList<>();
        for (IssueProductEntity product : products) {
            productDtos.add(IssueProductDto.builder()
                    .id(product.getId())
                    .receiptId(product.getReceiptId())
                    .distributeDt(product.getDistributeDt())
                    .distributeInfo(product.getDistributeInfo())
                    .userId(product.getUserId())
                    .build()
            );
        }
        return productDtos;
    }

    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    private IssueProductService issueProductService;

    public List<IssueProductDto> getAllIssuesByReceipt(Integer receiptId) {
        ReceiptEntity receipt = receiptRepository.findOneById(receiptId);
        List<IssueProductEntity> issues = issueProductRepository.getAllIssues(receiptId);

        List<IssueProductDto> issueProductDtos = new ArrayList<>();
        for (IssueProductEntity issueProductEntity : issues) {
            issueProductDtos.add(IssueProductDto.builder()
                    .id(issueProductEntity.getId())
                    .receiptId(issueProductEntity.getReceiptId())
                    .distributeDt(issueProductEntity.getDistributeDt())
                    .distributeInfo(issueProductEntity.getDistributeInfo())
                    .build());
        }
        return issueProductDtos;
    }
/*
    public List<IssueProductEntity> findById(String id, String vol) {
        IssueProductRepository.ProductSpecification cs = new IssueProductRepository.ProductSpecification(id,vol);
        return issueProductRepository.find(cs);
    }
*/
}
