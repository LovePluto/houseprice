package com.wyh.house.houseprice.type;


/**
 * 数据来源枚举类型
 */
public enum SourceType {
    LIANJIA(1, "链家"), ANJUKE(2, "安居客");


    private Integer id;
    private String desc;

    SourceType(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static SourceType getTypeById(Integer id) {
        if (id == null) {
            return null;
        }
        for (SourceType type : SourceType.values()) {
            if (type.id.equals(id)) {
                return type;
            }
        }
        return null;
    }
}
