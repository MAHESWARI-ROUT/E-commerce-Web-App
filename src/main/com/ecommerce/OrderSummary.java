package com.ecommerce;

public class OrderSummary {
    private int summaryId;
    private int orderRef;
    private String itemsText;
    private double totalAmount;
    private String createdAt;

    private String customerName;
    private String paymentMethod;

    public int getSummaryId() { return summaryId; }
    public void setSummaryId(int summaryId) { this.summaryId = summaryId; }

    public int getOrderRef() { return orderRef; }
    public void setOrderRef(int orderRef) { this.orderRef = orderRef; }

    public String getItemsText() { return itemsText; }
    public void setItemsText(String itemsText) { this.itemsText = itemsText; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String name) { this.customerName = name; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String pm) { this.paymentMethod = pm; }
}
