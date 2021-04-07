package com.example.demo.dao;

import java.math.BigDecimal;

/**
 * @Author: qingdong.chen
 * @Date: 2020/3/19 14:35
 * @Version 1.0
 */
public class AcLoan {
    private String batchNo;
    private String status;
    private String loanDate;
    private BigDecimal loanAmount;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "AcLoan{" +
                "batchNo='" + batchNo + '\'' +
                ", status='" + status + '\'' +
                ", loanDate='" + loanDate + '\'' +
                ", loanAmount=" + loanAmount +
                '}';
    }
}
