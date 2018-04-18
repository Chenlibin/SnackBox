package com.clb.snackbox.domain;

import java.io.Serializable;

public class GoodData implements Serializable {

    private String goodName;            //商品名称
    private String saleNumber;          //销售数量
    private String productionDate;      //生产日期
    private String goodContent;         //商品说明
    private String goodPrice;           //商品价格
    private String goodPhoto;           //商品图片
    private String goodNumber;          //商品数量

    public String getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(String goodNumber) {
        this.goodNumber = goodNumber;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getGoodContent() {
        return goodContent;
    }

    public void setGoodContent(String goodContent) {
        this.goodContent = goodContent;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodPhoto() {
        return goodPhoto;
    }

    public void setGoodPhoto(String goodPhoto) {
        this.goodPhoto = goodPhoto;
    }


    @Override
    public String toString() {
        return "GoodData{" +
                "goodName='" + goodName + '\'' +
                ", saleNumber='" + saleNumber + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", goodContent='" + goodContent + '\'' +
                ", goodPrice='" + goodPrice + '\'' +
                ", goodPhoto='" + goodPhoto + '\'' +
                '}';
    }
}
