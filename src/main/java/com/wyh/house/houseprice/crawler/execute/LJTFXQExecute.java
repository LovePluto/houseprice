package com.wyh.house.houseprice.crawler.execute;

import com.wyh.house.houseprice.crawler.impl.AbstractCrawler;
import com.wyh.house.houseprice.po.House;
import com.wyh.house.houseprice.type.DistrictType;
import com.wyh.house.houseprice.type.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 链家天府新区的爬虫
 */
@Component
public class LJTFXQExecute extends AbstractCrawlerExecute {

    private final static String URL_PREFIX = "https://cd.lianjia.com/ershoufang/tianfuxinqu/pg";
    private final static String URL_SUFFIX = "sf1bp80ep200/";

    @Autowired
    @Qualifier("lianjia")
    private AbstractCrawler<House> crawler;

    @Override
    protected AbstractCrawler getAbstractCrawler() {
        return crawler;
    }

    @Override
    protected SourceType getSourceType() {
        return SourceType.LIANJIA;
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
