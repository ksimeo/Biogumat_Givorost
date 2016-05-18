package com.ksimeo.nazaru.view.dao;

import com.ksimeo.nazaru.core.models.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @Ksimeo on 17.03.2015.
 */
public class RegDao implements IRegDao {

    @Override
    public List<Region> getAllRegions() {

        ArrayList<Region> regions = new ArrayList<Region>();
        regions.add(new Region(1, "АР Крим"));
        regions.add(new Region(2, "Віннічщина"));
        regions.add(new Region(3, "Волинщина"));
        regions.add(new Region(4, "Дніпропетровщина"));
        regions.add(new Region(5, "Донеччина"));
        regions.add(new Region(6, "Закарпаття"));
        regions.add(new Region(7, "Запоріжчщина"));
        regions.add(new Region(8, "Івано-Франківщина"));
        regions.add(new Region(9, "Київщина"));
        regions.add(new Region(10, "Кіровоградщина"));
        regions.add(new Region(11, "Луганщина"));
        regions.add(new Region(12, "Львівщина"));
        regions.add(new Region(13, "Миколаївщина"));
        regions.add(new Region(14, "Одесщина"));
        regions.add(new Region(15, "Рівненщина"));
        regions.add(new Region(16, "Сумщина"));
        regions.add(new Region(17, "Тернопільщина"));
        regions.add(new Region(18, "Харківщина"));
        regions.add(new Region(19, "Хмільниччина"));
        regions.add(new Region(20, "Херсонщина"));
        regions.add(new Region(21, "Черкасщина"));
        regions.add(new Region(22, "Чернігівщина"));
        regions.add(new Region(23, "Чернівецщина"));
        regions.add(new Region(24, "Житомірщина"));
        regions.add(new Region(25, "ЗАКОРДОНЩИНА"));
        return regions;
    }
}
