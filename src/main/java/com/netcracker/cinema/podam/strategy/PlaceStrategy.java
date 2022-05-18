package com.netcracker.cinema.podam.strategy;

import com.netcracker.cinema.model.Hall;
import com.netcracker.cinema.model.Place;
import com.netcracker.cinema.model.Zone;
import uk.co.jemos.podam.api.AbstractRandomDataProviderStrategy;
import uk.co.jemos.podam.api.AttributeMetadata;

import java.util.Random;

public class PlaceStrategy extends AbstractRandomDataProviderStrategy {

    private static final Random random = new Random(System.currentTimeMillis());

    public PlaceStrategy() {
        super();
    }


    public String getStringValue(AttributeMetadata attributeMetadata) {
        HallStrategy hallStrategy = new HallStrategy();
        ZoneStrategy zoneStrategy = new ZoneStrategy();


        if ("name".equals(attributeMetadata.getAttributeName())) {
            if (Hall.class.equals(attributeMetadata.getPojoClass())) {
                return hallStrategy.getStringValue(attributeMetadata);
            } else if (Zone.class.equals(attributeMetadata.getPojoClass())) {
                return zoneStrategy.getStringValue(attributeMetadata);

            } else if (Place.class.equals(attributeMetadata.getPojoClass())) {
                return "";
            }
        }
        return super.getStringValue(attributeMetadata);
    }
}

