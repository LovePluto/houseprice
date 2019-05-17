package com.wyh.house.houseprice.crawler.execute;

import com.wyh.house.houseprice.crawler.impl.AbstractCrawler;
import com.wyh.house.houseprice.po.House;
import com.wyh.house.houseprice.type.DistrictType;
import com.wyh.house.houseprice.type.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 安居客天府新区的爬虫
 */
@Component
public class AJKTFXQExecute extends AbstractCrawlerExecute {

    private final static String URL_PREFIX = "https://chengdu.anjuke.com/sale/tainfuxinqu/p";
    private final static String URL_SUFFIX = "-t21/?from_price=80&to_price=200#filtersort";

    @Autowired
    @Qualifier("anjuke")
    private AbstractCrawler<House> crawler;

    @Override
    protected AbstractCrawler getAbstractCrawler() {
        return crawler;
    }

    @Override
    protected SourceType getSourceType() {
        return SourceType.ANJUKE;
    }

    @Override
    protected DistrictType getDistrictType() {
        return DistrictType.TFXQ;
    }

    @Override
    protected String getUrlPrefix() {
        return URL_PREFIX;
    }

    @Override
    protected String getUrlSuffix() {
        return URL_SUFFIX;
    }
}
