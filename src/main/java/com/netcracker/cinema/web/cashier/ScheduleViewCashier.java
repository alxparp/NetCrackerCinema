package com.netcracker.cinema.web.cashier;

import com.netcracker.cinema.model.Seance;
import com.netcracker.cinema.web.CashierUI;
import com.netcracker.cinema.web.common.ScheduleView;
import com.vaadin.spring.annotation.SpringView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringView(name = ScheduleView.VIEW_NAME, ui = CashierUI.class)
public class ScheduleViewCashier extends ScheduleView {

    @Autowired
    ScheduleTableCashier scheduleTable;

    @PostConstruct
    public void init() {
        super.init();
        scheduleTable.setSizeFull();
        addComponent(scheduleTable, 1);
    }

    @Override
    public void updateGrid(List<Seance> seances) {
        scheduleTable.updateGrid(seances);
    }
}
