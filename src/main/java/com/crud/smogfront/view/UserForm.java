package com.crud.smogfront.view;

import com.crud.smogfront.domain.User;
import com.crud.smogfront.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class UserForm extends FormLayout {
    private TextField firstName = new TextField("First Name");
    private TextField lastName = new TextField("Last Name");
    private TextField addressCity = new TextField("Address: city");
    private TextField addressStreet = new TextField("Address: street");
    private ComboBox<String> addressProvince = new ComboBox<>("Address: province");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button air = new Button("Show air quality");
    private Binder<User> binder = new Binder<>(User.class);
    private MainView mainView;
    private UserService service = UserService.getInstance();

    public UserForm (MainView mainView){

        addressProvince.setItems("Pomorskie",
                "Dolnośląskie",
                "Kujawsko-Pomorskie",
                "Lubelskie",
                "Lubuskie",
                "Łódzkie",
                "Małopolskie",
                "Mazowieckie",
                "Opolskie",
                "Podkarpackie",
                "Podlaskie",
                "Śląskie",
                "Świętokrzyskie",
                "Warmińsko-Mazurskie",
                "Wielkopolskie",
                "Zachodniopomorskie");
        HorizontalLayout buttons = new HorizontalLayout(save, delete, air);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        air.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        air.addClickListener(event -> showMap());
        add(firstName, lastName, addressCity,addressStreet,addressProvince, buttons);

        this.mainView = mainView;

        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());

        binder.bindInstanceFields(this);

    }
    private void showMap() {
        getUI().get().getPage().open("https://maps.googleapis.com/maps/api/staticmap?key=AIzaSyDViFkSrQDUv67LUyGwWMJM0UfIkLmz6YE&center=51.609987,19.396521&zoom=8&size=1000x500&scale=2&markers=color:black%7Csize:tiny%7C%C5%81%C3%B3d%C5%BA&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF0033%7C51.699552383170115,19.507264929876694%7C51.74420106143218,19.426085514854766%7C51.74420106143218,19.311280485145236%7C51.699552383170115,19.230101070123307%7C51.63640961682988,19.230101070123307%7C51.591760938567816,19.311280485145236%7C51.591760938567816,19.426085514854766%7C51.63640961682988,19.507264929876694%7C51.699552383170115,19.507264929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF0033%7C52.08538238317012,20.568473929876692%7C52.130031061432184,20.487294514854764%7C52.130031061432184,20.372489485145234%7C52.08538238317012,20.291310070123306%7C52.022239616829886,20.291310070123306%7C51.97759093856782,20.372489485145234%7C51.97759093856782,20.487294514854764%7C52.022239616829886,20.568473929876692%7C52.08538238317012,20.568473929876692&path=color:0x999999%7Cweight:2%7Cfillcolor:0x999999%7C52.317429383170115,20.593234929876694%7C52.36207806143218,20.512055514854765%7C52.36207806143218,20.397250485145236%7C52.317429383170115,20.316071070123307%7C52.25428661682988,20.316071070123307%7C52.209637938567816,20.397250485145236%7C52.209637938567816,20.512055514854765%7C52.25428661682988,20.593234929876694%7C52.317429383170115,20.593234929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF9900%7C50.919177383170116,20.718546929876695%7C50.96382606143218,20.637367514854766%7C50.96382606143218,20.522562485145237%7C50.919177383170116,20.441383070123308%7C50.85603461682988,20.441383070123308%7C50.81138593856782,20.522562485145237%7C50.81138593856782,20.637367514854766%7C50.85603461682988,20.718546929876695%7C50.919177383170116,20.718546929876695&path=color:0x999999%7Cweight:2%7Cfillcolor:0xCCFF00%7C51.806982383170116,19.589481929876694%7C51.85163106143218,19.508302514854766%7C51.85163106143218,19.393497485145236%7C51.806982383170116,19.312318070123307%7C51.74383961682988,19.312318070123307%7C51.69919093856782,19.393497485145236%7C51.69919093856782,19.508302514854766%7C51.74383961682988,19.589481929876694%7C51.806982383170116,19.589481929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0x999999%7C51.32274638317012,19.656137929876692%7C51.367395061432184,19.574958514854764%7C51.367395061432184,19.460153485145234%7C51.32274638317012,19.378974070123306%7C51.259603616829885,19.378974070123306%7C51.21495493856782,19.460153485145234%7C51.21495493856782,19.574958514854764%7C51.259603616829885,19.656137929876692%7C51.32274638317012,19.656137929876692&path=color:0x999999%7Cweight:2%7Cfillcolor:0xCCFF00%7C50.84878838317012,19.257578929876694%7C50.89343706143218,19.176399514854765%7C50.89343706143218,19.061594485145235%7C50.84878838317012,18.980415070123307%7C50.78564561682988,18.980415070123307%7C50.74099693856782,19.061594485145235%7C50.74099693856782,19.176399514854765%7C50.78564561682988,19.257578929876694%7C50.84878838317012,19.257578929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF0033%7C51.88826338317012,19.559812929876692%7C51.932912061432184,19.478633514854764%7C51.932912061432184,19.363828485145234%7C51.88826338317012,19.282649070123306%7C51.825120616829885,19.282649070123306%7C51.78047193856782,19.363828485145234%7C51.78047193856782,19.478633514854764%7C51.825120616829885,19.559812929876692%7C51.88826338317012,19.559812929876692&path=color:0x999999%7Cweight:2%7Cfillcolor:0x6633CC%7C50.854679383170115,20.672087929876692%7C50.89932806143218,20.590908514854764%7C50.89932806143218,20.476103485145234%7C50.854679383170115,20.394924070123306%7C50.79153661682988,20.394924070123306%7C50.746887938567816,20.476103485145234%7C50.746887938567816,20.590908514854764%7C50.79153661682988,20.672087929876692%7C50.854679383170115,20.672087929876692&path=color:0x999999%7Cweight:2%7Cfillcolor:0xCCFF00%7C50.841134383170115,20.404680929876694%7C50.88578306143218,20.323501514854765%7C50.88578306143218,20.208696485145236%7C50.841134383170115,20.127517070123307%7C50.77799161682988,20.127517070123307%7C50.733342938567816,20.208696485145236%7C50.733342938567816,20.323501514854765%7C50.77799161682988,20.404680929876694%7C50.841134383170115,20.404680929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0x6633CC%7C50.91056938317012,20.772273929876693%7C50.955218061432184,20.691094514854765%7C50.955218061432184,20.576289485145235%7C50.91056938317012,20.495110070123307%7C50.847426616829885,20.495110070123307%7C50.80277793856782,20.576289485145235%7C50.80277793856782,20.691094514854765%7C50.847426616829885,20.772273929876693%7C50.91056938317012,20.772273929876693&path=color:0x999999%7Cweight:2%7Cfillcolor:0xCCFF00%7C51.78618438317012,19.573506929876693%7C51.83083306143218,19.492327514854765%7C51.83083306143218,19.377522485145235%7C51.78618438317012,19.296343070123307%7C51.72304161682988,19.296343070123307%7C51.67839293856782,19.377522485145235%7C51.67839293856782,19.492327514854765%7C51.72304161682988,19.573506929876693%7C51.78618438317012,19.573506929876693&path=color:0x999999%7Cweight:2%7Cfillcolor:0xCCFF00%7C51.77967438317012,18.18789192987669%7C51.82432306143218,18.106712514854763%7C51.82432306143218,17.991907485145234%7C51.77967438317012,17.910728070123305%7C51.71653161682988,17.910728070123305%7C51.67188293856782,17.991907485145234%7C51.67188293856782,18.106712514854763%7C51.71653161682988,18.18789192987669%7C51.77967438317012,18.18789192987669&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF0033%7C52.263299383170114,19.492323929876694%7C52.30794806143218,19.411144514854765%7C52.30794806143218,19.296339485145236%7C52.263299383170114,19.215160070123307%7C52.20015661682988,19.215160070123307%7C52.155507938567816,19.296339485145236%7C52.155507938567816,19.411144514854765%7C52.20015661682988,19.492323929876694%7C52.263299383170114,19.492323929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF9900%7C51.789621383170115,19.668367929876695%7C51.83427006143218,19.587188514854766%7C51.83427006143218,19.472383485145237%7C51.789621383170115,19.391204070123308%7C51.72647861682988,19.391204070123308%7C51.681829938567816,19.472383485145237%7C51.681829938567816,19.587188514854766%7C51.72647861682988,19.668367929876695%7C51.789621383170115,19.668367929876695&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF0033%7C51.09901038317012,19.587275929876693%7C51.14365906143218,19.506096514854764%7C51.14365906143218,19.391291485145235%7C51.09901038317012,19.310112070123306%7C51.03586761682988,19.310112070123306%7C50.99121893856782,19.391291485145235%7C50.99121893856782,19.506096514854764%7C51.03586761682988,19.587275929876693%7C51.09901038317012,19.587275929876693&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF9900%7C50.90855438317012,18.555459929876694%7C50.953203061432184,18.474280514854765%7C50.953203061432184,18.359475485145236%7C50.90855438317012,18.278296070123307%7C50.845411616829885,18.278296070123307%7C50.80076293856782,18.359475485145236%7C50.80076293856782,18.474280514854765%7C50.845411616829885,18.555459929876694%7C50.90855438317012,18.555459929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF9900%7C50.91758538317012,20.781439929876694%7C50.962234061432184,20.700260514854765%7C50.962234061432184,20.585455485145236%7C50.91758538317012,20.504276070123307%7C50.854442616829886,20.504276070123307%7C50.80979393856782,20.585455485145236%7C50.80979393856782,20.700260514854765%7C50.854442616829886,20.781439929876694%7C50.91758538317012,20.781439929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF0033%7C51.62083238317012,19.270075929876693%7C51.66548106143218,19.188896514854765%7C51.66548106143218,19.074091485145235%7C51.62083238317012,18.992912070123307%7C51.55768961682988,18.992912070123307%7C51.51304093856782,19.074091485145235%7C51.51304093856782,19.188896514854765%7C51.55768961682988,19.270075929876693%7C51.62083238317012,19.270075929876693&path=color:0x999999%7Cweight:2%7Cfillcolor:0xFF9900%7C51.43597738317012,19.835537929876693%7C51.48062606143218,19.754358514854765%7C51.48062606143218,19.639553485145235%7C51.43597738317012,19.558374070123307%7C51.372834616829884,19.558374070123307%7C51.32818593856782,19.639553485145235%7C51.32818593856782,19.754358514854765%7C51.372834616829884,19.835537929876693%7C51.43597738317012,19.835537929876693&path=color:0x999999%7Cweight:2%7Cfillcolor:0x00FF33%7C52.25720438317012,18.407617929876693%7C52.30185306143218,18.326438514854765%7C52.30185306143218,18.211633485145235%7C52.25720438317012,18.130454070123307%7C52.194061616829885,18.130454070123307%7C52.14941293856782,18.211633485145235%7C52.14941293856782,18.326438514854765%7C52.194061616829885,18.407617929876693%7C52.25720438317012,18.407617929876693&path=color:0x999999%7Cweight:2%7Cfillcolor:0x00FF33%7C52.17482138317012,19.371806929876694%7C52.21947006143218,19.290627514854766%7C52.21947006143218,19.175822485145236%7C52.17482138317012,19.094643070123308%7C52.111678616829884,19.094643070123308%7C52.06702993856782,19.175822485145236%7C52.06702993856782,19.290627514854766%7C52.111678616829884,19.371806929876694%7C52.17482138317012,19.371806929876694&path=color:0x999999%7Cweight:2%7Cfillcolor:0x00FF33%7C50.867960383170114,19.268692929876693%7C50.91260906143218,19.187513514854764%7C50.91260906143218,19.072708485145235%7C50.867960383170114,18.991529070123306%7C50.80481761682988,18.991529070123306%7C50.760168938567816,19.072708485145235%7C50.760168938567816,19.187513514854764%7C50.80481761682988,19.268692929876693%7C50.867960383170114,19.268692929876693");

    }
private void save() {
        User user = binder.getBean();
        service.postUser(user);
        mainView.refresh();
        setUser(null);
    }
    private void delete() {
        User user = binder.getBean();
        service.deleteUser(user);
        mainView.refresh();
        setUser(null);

    }

    public void setUser(User user) {
        binder.setBean(user);

        if (user == null) {
            setVisible(false);
        } else {
            setVisible(true);
            firstName.focus();
        }
    }
}
