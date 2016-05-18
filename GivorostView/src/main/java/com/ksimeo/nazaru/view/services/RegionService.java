package com.ksimeo.nazaru.view.services;

import com.ksimeo.nazaru.core.models.Region;
import com.ksimeo.nazaru.view.dao.RegDao;

import java.util.List;

/**
 * Created by @Ksimeo on 15.02.2015
 */
public enum RegionService implements IRegionService {

    INSTANCE;
    private RegDao regDao;

    private RegionService() {
        regDao = new RegDao();
    }

    @Override
    public List<Region> getAllRegions() {

        return regDao.getAllRegions();
    }


//    private List<Region> regions = new ArrayList<>();
//    {
//        regions.add(new Region(0, ""));
//        regions.add(new Region(1, "Днепропетровская обл."));
//        regions.add(new Region(2, "АР Крым"));
//        regions.add(new Region(3, "Винницкая обл."));
//        regions.add(new Region(4, "Донецкая обл."));
//        regions.add(new Region(5, "Житомирская обл."));
//        regions.add(new Region(6, "Закарпатская обл"));
//        regions.add(new Region(7, "Запорожская обл"));
//        regions.add(new Region(8,"Киевская обл"));
//        regions.add(new Region(9,"Кировоградская обл"));
//        regions.add(new Region(10,"Львовская обл"));
//        regions.add(new Region(11,"Николаевская обл"));
//        regions.add(new Region(12,"Одесская обл"));
//        regions.add(new Region(13,"Ровенская обл"));
//        regions.add(new Region(14,"Сумская обл"));
//        regions.add(new Region(15,"Тернопольская обл"));
//        regions.add(new Region(16,"Харьковская обл"));
//        regions.add(new Region(17,"Хмельницкая обл"));
//        regions.add(new Region(18,"Херсонская обл"));
//        regions.add(new Region(19,"Черкасская обл"));
//        regions.add(new Region(20,"Черниговская обл"));
//        regions.add(new Region(21,"Черновецкая обл"));
//        regions.add(new Region(22,"Житомирская обл"));
//    }
//
//    public List<Region> getAllRegions() {
//        return regions;
//    }
//
//    public String getNamebyId(int id) {
//        for(Region region : regions) {
//            if(region.getRegionId()==id) return region.getRegionName();
//        }
//        return "";
//    }
}
