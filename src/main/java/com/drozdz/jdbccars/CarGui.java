package com.drozdz.jdbccars;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class CarGui extends VerticalLayout {

    private TextField textBrand;
    private TextField textModel;
    private TextField textColor;
    private Button button;
    private CarDao carDao;

    @Autowired
    public CarGui(CarDao carDao) {
        this.textBrand = new TextField("Marka");
        this.textModel = new TextField("Model");
        this.textColor = new TextField("Kolor");
        this.button = new Button("Dodaj");
        this.carDao = carDao;
        button.addClickListener(clickEvent ->{
            Car car = new Car( textBrand.getValue(), textModel.getValue(), textColor.getValue());
            carDao.save(car);
        });
        add(textBrand, textModel, textColor, button);
    }
}
