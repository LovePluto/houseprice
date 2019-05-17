package com.wyh.house.houseprice.crawler.impl;

import com.wyh.house.houseprice.crawler.Crawler;
import com.wyh.house.houseprice.po.House;
import com.wyh.house.houseprice.type.DistrictType;
import com.wyh.house.houseprice.type.SourceType;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.nodes.Element;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public abstract class AbstractCrawler<T> implements Crawler<T> {

    private SourceType sourceType;
    private DistrictType districtType;
    private boolean isContinueStatus = true;//是否继续执行标识


    public AbstractCrawler() {
    }

    @Override
    public void start(@NotNull String url) {
        String html = geHtml(url);
        if (StringUtils.isEmpty(html)) {
            throw new NullPointerException("response body is null!");
        }
        List<T> data = parsingHtml(html);
        saveData(data);
    }

    @Override
    public String geHtml(String url) {
        HttpGet httpget = new HttpGet(url);
        httpget.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        CloseableHttpClient httpclient = HttpClients.createDefault(); // 使用默认的HttpClient
        try (CloseableHttpResponse response = httpclient.execute(httpget)) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 返回 200 表示成功
                return EntityUtils.toString(response.getEntity(), "utf-8"); // 获取服务器响应实体的内容
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public final boolean isContinue() {
        return isContinueStatus;
    }

    @Override
    public final void setEndStatus() {
        isContinueStatus = false;
    }

    /**
     * 列表的批量解析
     */
    protected List<House> getHouseList(ListIterator<Element> iterator) {
        List<House> result = new ArrayList<>();
        Date current = new Date();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            House house = getHouseByElement(element);
            house.setCreateDate(current);
            result.add(house);
        }
        return result;
    }

    protected abstract House getHouseByElement(Element element);

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public void setDistrictType(DistrictType districtType) {
        this.districtType = districtType;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public DistrictType getDistrictType() {
        return districtType;
    }
}
