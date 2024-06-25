package com.example.carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllFromCars() {
        String query = "SELECT * FROM cars";
        return jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> getAllFromCar() {
        String query = "SELECT * FROM car";
        return jdbcTemplate.queryForList(query);
    }

    public void addDataToCars(Map<String, Object> data) {
        addDataToTable("cars", data);
    }

    public void addDataToCar(Map<String, Object> data) {
        addDataToTable("car", data);
    }

    public void updateDataInCars(String idColumn, Object idValue, Map<String, Object> data) {
        updateDataInTable("cars", idColumn, idValue, data);
    }

    public void updateDataInCar(String idColumn, Object idValue, Map<String, Object> data) {
        updateDataInTable("car", idColumn, idValue, data);
    }

    public void deleteDataFromCars(String idColumn, Object idValue) {
        deleteDataFromTable("cars", idColumn, idValue);
    }

    public void deleteDataFromCar(String idColumn, Object idValue) {
        deleteDataFromTable("car", idColumn, idValue);
    }

    private void addDataToTable(String tableName, Map<String, Object> data) {
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        data.forEach((key, value) -> {
            columns.append(key).append(",");
            values.append("'").append(value).append("',");
        });
        columns.deleteCharAt(columns.length() - 1);
        values.deleteCharAt(values.length() - 1);
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        jdbcTemplate.update(query);
    }

    private void updateDataInTable(String tableName, String idColumn, Object idValue, Map<String, Object> data) {
        StringBuilder setClause = new StringBuilder();
        data.forEach((key, value) -> {
            setClause.append(key).append(" = '").append(value).append("',");
        });
        setClause.deleteCharAt(setClause.length() - 1);
        String query = "UPDATE " + tableName + " SET " + setClause + " WHERE " + idColumn + " = '" + idValue + "'";
        jdbcTemplate.update(query);
    }

    private void deleteDataFromTable(String tableName, String idColumn, Object idValue) {
        String query = "DELETE FROM " + tableName + " WHERE " + idColumn + " = '" + idValue + "'";
        jdbcTemplate.update(query);
    }
}

