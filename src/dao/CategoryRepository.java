package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import domain.Category;

public class CategoryRepository extends Repository {
	
	public List<Category> getCategorys() {
		return (List<Category>) jdbc.query("SELECT * FROM category", new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
			}
		});
	}
	public int add(Category obj) {
		return jdbc.update("INSERT INTO Category(CategoryId, CategoryName, ParentId) VALUES(?, ?, ?)", obj.getId(), obj.getName(), obj.getParent());
		}

}
