package com.netcracker.cinema.web.common;

import com.netcracker.cinema.model.Movie;
import com.netcracker.cinema.model.Seance;
import com.netcracker.cinema.web.cashier.HallDetailsViewCashier;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.text.SimpleDateFormat;

public class ScheduleComponent extends VerticalLayout {

    public ScheduleComponent(Seance seance, Movie movie) {
        addPoster(movie);
        addSeanceAttributes(seance, movie);
        addStyleName("selectable-seance-with-poster");
        addLayoutClickListener(event -> getUI().getNavigator().navigateTo(HallDetailsView.VIEW_NAME + "/" + seance.getId()));
    }

    private void addSeanceAttributes(Seance seance, Movie movie) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Label name = new Label(movie.getName());
        addComponent(name);
        Label date = new Label("Date: " + dateFormat.format(seance.getSeanceDate()));
        addComponent(date);
        Label time = new Label("Time: " + timeFormat.format(seance.getSeanceDate()));
        addComponent(time);
        Label hall = new Label("Hall: " + seance.getHallId());
        addComponent(hall);
    }

    private void addPoster(Movie movie) {
        ExternalResource resource = new ExternalResource(movie.getPoster());
        Image poster = new Image(null, resource);
        poster.setHeight("350px");
        poster.setWidth("230px");
        addComponent(poster);
    }
}
