package com.netcracker.cinema.web.admin.movie;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.*;
import com.vaadin.ui.declarative.Design;

@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class MovieFormDesign extends FormLayout {
	protected TextField poster;
	protected TextField name;
	protected TextField duration;
	protected TextField imdb;
	protected TextField basePrice;
	protected TextField periodicity;
	protected PopupDateField startDate;
	protected PopupDateField endDate;
	protected TextArea description;
	protected Button save;
	protected Button close;

	public MovieFormDesign() {
		Design.read(this);
	}
}