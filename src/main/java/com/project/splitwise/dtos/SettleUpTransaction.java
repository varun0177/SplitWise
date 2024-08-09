package com.project.splitwise.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SettleUpTransaction {
    private Long from;
    private Long to;
    private Double amount;
}
