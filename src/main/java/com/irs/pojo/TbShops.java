package com.irs.pojo;

public class TbShops {
    private Integer id;

    private String shopNumber;

    private String shopName;

    private Double shopSize;

    private String shopType;

    private String shopState;

    private String shopRent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber == null ? null : shopNumber.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Double getShopSize() {
        return shopSize;
    }

    public void setShopSize(Double shopSize) {
        this.shopSize = shopSize;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType == null ? null : shopType.trim();
    }

    public String getShopState() {
        return shopState;
    }

    public void setShopState(String shopState) {
        this.shopState = shopState == null ? null : shopState.trim();
    }

    public String getShopRent() {
        return shopRent;
    }

    public void setShopRent(String shopRent) {
        this.shopRent = shopRent == null ? null : shopRent.trim();
    }
}