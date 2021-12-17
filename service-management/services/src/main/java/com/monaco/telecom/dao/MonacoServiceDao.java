package com.monaco.telecom.dao;

import com.monaco.telecom.model.MonacoServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MonacoServiceDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Transactional(readOnly = true)
    public MonacoServiceModel selectMonacoService(Integer id) {
        String query = "SELECT ID,TAG,ACTION FROM MONACO_SERVICE WHERE ID = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNumber) -> {
                MonacoServiceModel monacoServiceModel = new MonacoServiceModel();
                monacoServiceModel.setId(rs.getInt(1));
                monacoServiceModel.setTag(rs.getString(2));
                monacoServiceModel.setAction(rs.getString(3));
                return monacoServiceModel;
            });
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("This id didn't exist",1);
        }
    }

    @Transactional(readOnly = true)
    public List<MonacoServiceModel> selectMonacoServices() {
        String query = "SELECT ID,TAG,ACTION FROM MONACO_SERVICE";
        return jdbcTemplate.query(query, (rs, rowNumber) -> {
            MonacoServiceModel monacoServiceModel = new MonacoServiceModel();
            monacoServiceModel.setId(rs.getInt(1));
            monacoServiceModel.setTag(rs.getString(2));
            monacoServiceModel.setAction(rs.getString(3));
            return monacoServiceModel;
        });
    }

    @Transactional
    public Boolean addMonacoService(MonacoServiceModel monacoServiceModel) {
        Integer id = Integer.valueOf(monacoServiceModel.getTag().split("tag")[1]);
        monacoServiceModel.setId(id);
        String query = "INSERT INTO MONACO_SERVICE (ID,TAG,ACTION) values(?,?,?)";
        return jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setInt(1, monacoServiceModel.getId());
            ps.setString(2, monacoServiceModel.getTag());
            ps.setString(3, monacoServiceModel.getAction());
            return ps.execute();
        });
    }

    @Transactional
    public int updateMonacoService(MonacoServiceModel monacoServiceModel) {
        Integer id = Integer.valueOf(monacoServiceModel.getTag().split("tag")[1]);
        monacoServiceModel.setId(id);
        String query = "UPDATE MONACO_SERVICE SET ACTION = ? WHERE ID = ?";
        return jdbcTemplate.update(query,monacoServiceModel.getAction(),monacoServiceModel.getId());
    }

    @Transactional(readOnly = true)
    public Integer selectMonacoServiceMaxId() {
        String query = "SELECT MAX(ID) FROM MONACO_SERVICE";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }


}
