package com.example.showroomservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllFromShowrooms() {
        String query = "SELECT * FROM showrooms";
        return jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> getAllFromShowroom() {
        String query = "SELECT * FROM showroom";
        return jdbcTemplate.queryForList(query);
    }

    public void addDataToShowrooms(Map<String, Object> data) {
        addDataToTable("showrooms", data);
    }

    public void addDataToShowroom(Map<String, Object> data) {
        addDataToTable("showroom", data);
    }

    public void updateDataInShowrooms(String idColumn, Object idValue, Map<String, Object> data) {
        updateDataInTable("showrooms", idColumn, idValue, data);
    }

    public void updateDataInShowroom(String idColumn, Object idValue, Map<String, Object> data) {
        updateDataInTable("showroom", idColumn, idValue, data);
    }

    public void deleteDataFromShowrooms(String idColumn, Object idValue) {
        deleteDataFromTable("showrooms", idColumn, idValue);
    }

    public void deleteDataFromShowroom(String idColumn, Object idValue) {
        deleteDataFromTable("showroom", idColumn, idValue);
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

