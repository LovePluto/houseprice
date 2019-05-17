package com.wyh.house.houseprice.crawler.impl;

import com.wyh.house.houseprice.po.House;
import com.wyh.house.houseprice.service.HouseService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 安居客的爬虫
 */
@Component("anjuke")
public class AJKCrawler extends AbstractCrawler<House> {


    @Autowired
    private HouseService houseService;

    @Override
    public List<House> parsingHtml(String html) {
        Document doc = Jsoup.parse(html);
        String text = doc.select("#filtersort span strong").text();
        if (!"天府新区".equals(text)) {
            setEndStatus();
            return new ArrayList<>();
        }
        ListIterator<Element> iterator = doc.select("#houselist-mod-new li").listIterator();
        return super.getHouseList(iterator);
    }


    @Override
    public House getHouseByElement(Element element) {

        String[] temp = element.select(".comm-address").text().split(" ");
        String communityName = temp[0];
        String location = temp[1];
        Elements select = element.select(".details-item span");
        String type = select.get(0).text();
        Double size = Double.valueOf(select.get(1).text().replace("m²", ""));
        Double totalPrice = Double.valueOf(element.select(".price-det strong").text());
        Integer areaPrice = Integer.valueOf(element.select(".unit-price").text().replaceAll("[^0-9]", ""));
        String url = element.select("a.houseListTitle").get(0).attr("href");
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
