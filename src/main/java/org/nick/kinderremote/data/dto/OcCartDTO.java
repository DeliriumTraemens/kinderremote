package org.nick.kinderremote.data.dto;

public class OcCartDTO {
    private Long cartId;
    private Long apiId;
    private Long customerId;
    private String sessionId;
    private Long productId;
    private Long recurringId;
    private String option;
    private Integer quantity;
    private java.sql.Timestamp dateAdded;

    public Long getCartId() {
        return this.cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getApiId() {
        return this.apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getRecurringId() {
        return this.recurringId;
    }

    public void setRecurringId(Long recurringId) {
        this.recurringId = recurringId;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public java.sql.Timestamp getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(java.sql.Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }
}
