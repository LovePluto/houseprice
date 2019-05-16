package com.wyh.house.houseprice.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 统一的爬虫数据封装对象
 */

@Entity
@Table(name = "house_lianjia")
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "community_name")
    private String communityName;//小区名字

    private Double size;//住房大小

    private String type;//三两厅之类

    @Column(name = "total_price")
    private Double totalPrice;//总价

    @Column(name = "area_price")
    private Integer areaPrice;//每平方单价

    private String location;//大概位置

    private Integer source;//详情查看 SourceType

    private Integer district;//详情查看 DistrictType

    private String url;

    @Column(name = "create_date")
    private Date createDate;

    public House() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getAreaPrice() {
        return areaPrice;
    }

    public void setAreaPrice(Integer areaPrice) {
        this.areaPrice = areaPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
