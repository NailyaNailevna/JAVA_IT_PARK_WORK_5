package ru.itpark.milkyKitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.milkyKitchen.dto.IssueProductDto;
import ru.itpark.milkyKitchen.models.IssueProductEntity;
import ru.itpark.milkyKitchen.repositories.IssueProductRepository;

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

}
