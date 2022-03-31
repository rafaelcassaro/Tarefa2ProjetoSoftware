package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Customers;


public class CustomersDAO {
private Connection conexao;
	
	public CustomersDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	
	public void insert(Customers ct) {
		String sql = "insert into customers (first_name, last_name, email_address, Business_phone) values (?,?,?,?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
		
			stmt.setString(1, ct.getFirst_name());
			stmt.setString(2, ct.getLast_name());
			stmt.setString(3, ct.getEmail_address());
			stmt.setString(4, ct.getBusiness_phone());
			
			
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e) {
			e.getMessage();
		}
	}
	
	
	public void delete(int id) {				
		String a = "DELETE FROM northwind.customers WHERE id = ";					
		String sql = a + id;

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.execute();
			stmt.close();
			
		}
		catch(SQLException e) {
			e.getMessage();
		}
	}
	
	
	public void edit(String tabela,String dados,int id) {				
		//String a = "UPDATE northwind.customers SET "
			//	+ " first_name = 'jefim' WHERE id = 30";	
		 
		//String b = "UPDATE northwind.customers SET " + tabela  +"= '" + dados + "' WHERE id = "+id;
		String sql = "UPDATE northwind.customers SET " + tabela  +"= '" + dados + "' WHERE id = "+id;

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.execute();
			stmt.close();
			
		}
		catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public void select() {
		String sql = "SELECT id , first_name , last_name , email_address , business_phone FROM customers ;";
		
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");				
				String email_address = rs.getString("email_address");
				String business_phone = rs.getString("business_phone");
				
				Customers os = new Customers();
				os.setId(id);
				os.setFirst_name(first_name);
				os.setLast_name(last_name);
				os.setEmail_address(email_address);
				os.setBusiness_phone(business_phone);
				
				lista.add(os);
			}
			
			rs.close();
			stmt.close();
			
			//imprimir a lista
			for (Customers status : lista) {
				System.out.println(status.toString());
			}
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectById(int id) {
		String a = "SELECT * FROM customers WHERE id LIKE ";
		
		
		String sql = a + id;
		
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email_address = rs.getString("email_address");
				String business_phone = rs.getString("business_phone");
								
				Customers os = new Customers();
				os.setFirst_name(first_name);
				os.setLast_name(last_name);
				os.setEmail_address(email_address);
				os.setBusiness_phone(business_phone);
							
				lista.add(os);
			}
			
			rs.close();
			stmt.close();
			
			//imprimir a lista
			for (Customers status : lista) {
				System.out.println("NOME"+"\tSOBRENOME"+"\tE-MAIL"+"\tTELEFONE"+"\n"+
			status.getFirst_name()+"\t"+status.getLast_name()+"\t"+status.getEmail_address()+"\t"+status.getBusiness_phone());
			}
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}				
		
	}
	
	public void selectByFirstName(String name) {
		String b = " '%";
		String c = "%' ;";
		String a = "SELECT * FROM customers WHERE first_name OR last_name LIKE";
		String sql = a+b+name+c;
		
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				
				Customers os = new Customers();
				os.setFirst_name(first_name);
				os.setLast_name(last_name);
				
				lista.add(os);
			}
			
			rs.close();
			stmt.close();
			
			//imprimir a lista
			for (Customers status : lista) {
				System.out.println("Client: "+ status.getFirst_name() +" "+ status.getLast_name());
			}
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



}
