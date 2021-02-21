package com.crud.smogfront.view;

import com.crud.smogfront.domain.User;
import com.crud.smogfront.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("smog") // http://localhost:8080/smog
public class MainView extends VerticalLayout {
    private UserService userService = UserService.getInstance();
    private Grid grid = new Grid<>(User.class);
    private TextField filter = new TextField();
    private UserForm form = new UserForm(this);
    private Button addNewUser = new Button("Add new user");

    public MainView(){
        filter.setPlaceholder("Find...");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());
        grid.setColumns("firstName", "lastName", "addressCity","addressProvince");

        addNewUser.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setUser(new User());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filter, addNewUser );

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
        form.setUser(null);
        setSizeFull();
        refresh();
        grid.asSingleSelect().addValueChangeListener(event -> form.setUser((User) grid.asSingleSelect().getValue()));
    }
    public void refresh() {
        grid.setItems(userService.getData());
    }
    private void update() {
        grid.setItems(userService.findByFinder(filter.getValue()));
    }
}
