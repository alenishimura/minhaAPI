package me.dio.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String name;

    @Column(name = "account_agency")
    private String accountAgency;

    @Column(name = "account_balance")
    private BigDecimal accountBalance;

    @Column(name = "account_limit")
    private BigDecimal accountLimit;

    private String pixIcon;
    private String pixDescription;

    private String payIcon;
    private String payDescription;

    private String transferIcon;
    private String transferDescription;

    private String cardNumber;

    @Column(name = "card_limit")
    private BigDecimal cardLimit;

    private String newsIcon;
    private String newsDescription;

    // Getters & Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAccountAgency() { return accountAgency; }
    public void setAccountAgency(String accountAgency) { this.accountAgency = accountAgency; }
    public BigDecimal getAccountBalance() { return accountBalance; }
    public void setAccountBalance(BigDecimal accountBalance) { this.accountBalance = accountBalance; }
    public BigDecimal getAccountLimit() { return accountLimit; }
    public void setAccountLimit(BigDecimal accountLimit) { this.accountLimit = accountLimit; }
    public String getPixIcon() { return pixIcon; }
    public void setPixIcon(String pixIcon) { this.pixIcon = pixIcon; }
    public String getPixDescription() { return pixDescription; }
    public void setPixDescription(String pixDescription) { this.pixDescription = pixDescription; }
    public String getPayIcon() { return payIcon; }
    public void setPayIcon(String payIcon) { this.payIcon = payIcon; }
    public String getPayDescription() { return payDescription; }
    public void setPayDescription(String payDescription) { this.payDescription = payDescription; }
    public String getTransferIcon() { return transferIcon; }
    public void setTransferIcon(String transferIcon) { this.transferIcon = transferIcon; }
    public String getTransferDescription() { return transferDescription; }
    public void setTransferDescription(String transferDescription) { this.transferDescription = transferDescription; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public BigDecimal getCardLimit() { return cardLimit; }
    public void setCardLimit(BigDecimal cardLimit) { this.cardLimit = cardLimit; }
    public String getNewsIcon() { return newsIcon; }
    public void setNewsIcon(String newsIcon) { this.newsIcon = newsIcon; }
    public String getNewsDescription() { return newsDescription; }
    public void setNewsDescription(String newsDescription) { this.newsDescription = newsDescription; }
}
