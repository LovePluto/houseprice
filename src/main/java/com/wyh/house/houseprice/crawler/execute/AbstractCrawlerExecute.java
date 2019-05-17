package com.wyh.house.houseprice.crawler.execute;

import com.wyh.house.houseprice.crawler.impl.AbstractCrawler;
import com.wyh.house.houseprice.type.DistrictType;
import com.wyh.house.houseprice.type.SourceType;

public abstract class AbstractCrawlerExecute implements CrawlerExecute{

    @Override
    public void execute() {
        int count = 1;
        getAbstractCrawler().setSourceType(getSourceType());
        getAbstractCrawler().setDistrictType(getDistrictType());
        StringBuilder url = new StringBuilder();
        while (getAbstractCrawler().isContinue() && count <= 100) {
            try {
                url.append(getUrlPrefix()).append(count).append(getUrlSuffix());
                getAbstractCrawler().start(url.toString().intern());
//                url.delete(0, url.length());
                url.setLength(0);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                count++;
            }
        }
    }

    protected abstract AbstractCrawler getAbstractCrawler();

    protected abstract SourceType getSourceType();

    protected abstract DistrictType getDistrictType();

    protected abstract String getUrlPrefix();

    protected abstract String getUrlSuffix();
}
