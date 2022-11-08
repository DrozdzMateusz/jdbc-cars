package com.drozdz.jdbccars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CarDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Car car) {
        String sql = "INSERT INTO Car VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, null,
                car.getBrand(),
                car.getModel(),
                car.getColor());
    }

    public List<Map<String, Object>> showByBrand(String brand) {
        String sql = "SELECT * FROM Car WHERE brand LIKE ?";
        return jdbcTemplate.queryForList(sql, brand);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void dbInit() {
//        save(new Car("BMW", "M6", "Shakir Orange"));
//        save(new Car("BMW", "M5", "Portimao Blue"));
//        save(new Car("Audi", "S4", "Norado Grey"));
//        save(new Car("Audi", "S7", "Sonoma Green"));
//
//        //    String sgl = "CREATE TABLE Car(car_id int, brand varchar(255), model varchar(255), color varchar(255));";
//        //    getJdbcTemplate().update(sgl);
//    }
}
