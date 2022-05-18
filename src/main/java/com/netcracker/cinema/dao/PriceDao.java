package com.netcracker.cinema.dao;

import com.netcracker.cinema.model.Price;

import java.util.List;

public interface PriceDao {

    List<Price> findAll();

    Price getById(long id);

    void save(Price price);

    void delete(Price price);

    int getPriceBySeanceColRow(long seanceId, int col, int row);

    Price getPriceBySeanceZone(long seanceId, long zoneId);
}
