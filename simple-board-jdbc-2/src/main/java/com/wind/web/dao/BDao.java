package com.wind.web.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.wind.web.dto.BDto;
import com.wind.web.util.Constant;

public class BDao {
	
	DataSource dataSource;
	
	JdbcTemplate template = null;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public BDao() {
		//template = Constant.template;
	}
	
	public ArrayList<BDto> list() {
		String query = "select bId, bName, bContent from simple_board";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		
		String query = "select * from simple_board where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));	
	}
	
	public void write(final String bName, final String bContent) {
		String query = "insert into simple_board(bId, bName, bContent) "
				 	 + "values (simple_board_seq.nextval,?,?)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bName);
				ps.setString(2, bContent);
			}
		});
	}

	public void delete(final String bId) {
		String query = "delete from simple_board where bId = ? ";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
	
	public void upHit(final String bId) {
		String query ="update simple_board set bHit = bHit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
	
	public void replyShape(final String bGroup, final String bStep) {
		String query = "update simple_board set bStep = bStep +1 where bGroup = ? and bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1,Integer.parseInt(bGroup));
				ps.setInt(2,Integer.parseInt(bStep));
			}
		});
	}
}