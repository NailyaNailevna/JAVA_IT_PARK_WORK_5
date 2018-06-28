package ru.itpark.milkyKitchen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by nailya.shakirova on 20.06.2018.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReceiptDto {
    private Long id;
    private String series;
    private String num;
    private Date issueDt;
    private Boolean canceled;
}
