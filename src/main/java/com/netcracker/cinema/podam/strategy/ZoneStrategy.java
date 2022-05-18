package com.netcracker.cinema.podam.strategy;

import com.netcracker.cinema.model.Zone;
import uk.co.jemos.podam.api.AbstractRandomDataProviderStrategy;
import uk.co.jemos.podam.api.AttributeMetadata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ZoneStrategy extends AbstractRandomDataProviderStrategy {
    private static final Random random = new Random(System.currentTimeMillis());

    public ZoneStrategy() {
        super();
    }

    @Override
    public String getStringValue(AttributeMetadata attributeMetadata) {

        if ("name".equals(attributeMetadata.getAttributeName())) {
            if (Zone.class.equals(attributeMetadata.getPojoClass())) {
                return ZoneStrategy.ZoneName.randomHall();
            }
        }
        return super.getStringValue(attributeMetadata);
    }

    private enum ZoneName {

        AA,BB,CC,DD,EE,HH;

        private static final List<ZoneStrategy.ZoneName> values = Collections.unmodifiableList(Arrays.asList(values()));
        private static final int size = values.size();
        private static final Random random = new Random();

        public static String randomHall() {
            return values.get(random.nextInt(size)).toString();
        }
    }
}
