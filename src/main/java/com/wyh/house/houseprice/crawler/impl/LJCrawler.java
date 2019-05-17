package com.wyh.house.houseprice.crawler.impl;

import com.wyh.house.houseprice.po.House;
import com.wyh.house.houseprice.service.HouseService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 链家的爬虫
 */
@Component("lianjia")
public class LJCrawler extends AbstractCrawler<House> {

    @Autowired
    private HouseService houseService;

    @Override
    public void start(@NotNull String url) {
        super.start(url);
    }

    @Override
    public String geHtml(String url) {
        return super.geHtml(url);
    }

    @Override
    public List<House> parsingHtml(String html) {
        Document doc = Jsoup.parse(html);
        String tag = doc.select("h2.total span").text();
        if ("0".equals(tag)) {
            System.out.println("没有数据了");
            return new ArrayList<>();
        }
        ListIterator<Element> iterator = doc.select("ul.sellListContent li").listIterator();
        return super.getHouseList(iterator);
    }

    @Override
    public House getHouseByElement(Element element) {
        String communityName = element.select(".houseInfo a").text();
        String[] temp = element.select(".houseInfo").get(0).ownText().replaceAll(" ", "").split("\\|");
        String type = temp[1];
        Double size = Double.valueOf(temp[2].replace("平米", ""));
        Double totalPrice = Double.valueOf(element.select(".priceInfo .totalPrice span").text());
        Integer areaPrice = Integer.valueOf(element.select(".unitPrice").text().replaceAll("[^1-9]", ""));
        String location = element.select(".positionInfo a").text();
        String url = element.select("a").get(0).attr("href");
        House house = new House(communityName, size, type, totalPrice, areaPrice,
                location, getSourceType().getId(), getDistrictType().getId(), url);
        return house;
    }

    @Override
    public void saveData(List<House> data) {
        if (data.size() == 0) {
            return;
        }
        houseService.saveList(data);
    }
}
