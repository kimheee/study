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
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent "
				+ "from mvc_board order by bGroup desc, bStep asc";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));

//		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent "
//				+ "from mvc_board order by bGroup desc, bStep asc";
//		preparedStatement = connection.prepareStatement(query);
//		resultSet = preparedStatement.executeQuery();
//		
//		while(resultSet.next()) {
//			int bId = resultSet.getInt("bId");
//			String bName = resultSet.getString("bName");
//			String bTitle = resultSet.getString("bTitle");
//			String bContent = resultSet.getString("bContent");
//			Timestamp bDate = resultSet.getTimestamp("bDate");
//			int bHit = resultSet.getInt("bHit");
//			int bGroup = resultSet.getInt("bGroup");
//			int bStep = resultSet.getInt("bStep");
//			int bIndent = resultSet.getInt("bIndent");
//			
//			dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//			dtos.add(dto);
//		}
	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		
		String query = "select * from mvc_board where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));	
	}

	public void write(final String bName, final String bTitle, final String bContent) {
		String query = "insert into mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
				 	 + "values (mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
			}
		});
	}

	public void delete(final String bId) {
		String query = "delete from mvc_board where bId = ? ";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
	
	public void modify(final String bId, final String bName, final String bTitle,final  String bContent) {
		String query = "update mvc_board set bName = ?, bTitle=?, "
				 + "bContent=? where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});
	}

	public BDto reply_view(String strId) {
		String query = "select * from mvc_board where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));	
	}
	
	public void reply(final String bId, final String bName, final String bTitle, 
			final String bContent, final String bGroup,final String bStep, final String bIndent) {
			replyShape(bGroup, bStep);

			String query ="insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
						 + "values (mvc_board_seq.nextval, ?, ?,?, ?, ?, ?)";
			
			template.update(query, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException{
					ps.setString(1, bName);
					ps.setString(2, bTitle);
					ps.setString(3, bContent);
					ps.setInt(4, Integer.parseInt(bGroup));
					ps.setInt(5, Integer.parseInt(bStep)+1);
					ps.setInt(6, Integer.parseInt(bIndent)+1);
				}
			});
	}
	
	public void upHit(final String bId) {
		String query ="update mvc_board set bHit = bHit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
	
	public void replyShape(final String bGroup, final String bStep) {
		String query = "update mvc_board set bStep = bStep +1 where bGroup = ? and bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1,Integer.parseInt(bGroup));
				ps.setInt(2,Integer.parseInt(bStep));
			}
		});
	}
}