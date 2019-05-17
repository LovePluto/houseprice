package com.wyh.house.houseprice.crawler;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface Crawler<T> {

    /**
     * 开启一个网页爬虫
     *
     * @param url
     */
    void start(@NotNull String url);

    /**
     * 得到具体的网页
     *
     * @return
     */
    String geHtml(String url);

    /**
     * 解析对应的网页
     */
    List<T> parsingHtml(String html);

    /**
     * 保存数据
     */
    void saveData(List<T> data);

    /**
     * 是否继续执行爬虫
     */
    boolean isContinue();

    /**
     * 设置结束状态
     */
    void setEndStatus();
}
