package com.drozdz.jdbccars;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Route
public class BrandGui extends VerticalLayout {
    private Logger logger;
    private TextArea textArea;
    private TextField textBrand;
    private Button button;
    private CarDao carDao;

    @Autowired
    public BrandGui(CarDao carDao) {
        this.textArea = new TextArea();
        this.textBrand = new TextField("Marka:");
        this.button = new Button("Pokaż");
        this.carDao = carDao;
        button.addClickListener(x -> {
            List<Map<String, Object>> list = carDao.showByBrand(textBrand.getValue());
            textArea.setValue(list.toString());
        });
        add(textBrand, textArea, button);
    }
}
