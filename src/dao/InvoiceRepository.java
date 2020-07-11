package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import domain.Invoice;

public class InvoiceRepository extends Repository {
	public List<Invoice> getInvoices(){
		
		
		return jdbc.query("SELECT * FROM Invoice", new RowMapper<Invoice>() {
			@Override
			public Invoice mapRow(ResultSet rs, int numRow) throws SQLException {
			return new Invoice();
			}
			});
			}
		
		
	
}
