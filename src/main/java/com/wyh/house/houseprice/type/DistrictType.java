package com.wyh.house.houseprice.type;

/**
 * 区域枚举类型
 */
public enum DistrictType {
    TFXQ(1, "天府新区"),
    GXQ(2, "高新区");

    private Integer id;
    private String desc;

    DistrictType(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static DistrictType getTypeById(Integer id) {
        if (id == null) {
            return null;
        }
        for (DistrictType type : DistrictType.values()) {
            if (type.id.equals(id)) {
                return type;
            }
        }
        return null;
    }
}
