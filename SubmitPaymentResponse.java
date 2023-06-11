package com.Tugastopikkhusus2.Tugastopikkhusus2.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class SubmitPaymentResponse {

    private String status;
    private String transactionId;
    private TbTransactions createdData;

}
