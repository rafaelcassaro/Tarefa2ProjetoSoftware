package entities;

import java.util.Scanner;

import db.CustomersDAO;

public class Customers {
	
	private int id;
	private String company;
	private String last_name;
	private String first_name;
	private String mobile_phone;
	private String city;
	private String state_province;
	private String zip_postal_code;
	private String country_region;
	private String email_address;
	private String business_phone;
	CustomersDAO dao = new CustomersDAO();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public String getZip_postal_code() {
		return zip_postal_code;
	}
	public void setZip_postal_code(String zip_postal_code) {
		this.zip_postal_code = zip_postal_code;
	}
	public String getCountry_region() {
		return country_region;
	}
	public void setCountry_region(String country_region) {
		this.country_region = country_region;
	}
	
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}	
	public String getBusiness_phone() {
		return business_phone;
	}
	public void setBusiness_phone(String business_phone) {
		this.business_phone = business_phone;
	}
	

	@Override
	public String toString() {
		return  "ID"+"\tNOME"+"\tSOBRENOME"+"\tE-MAIL"+"\tTELEFONE"+"\n"+
				id + "\t|" + first_name + "\t|" + last_name + "\t|" + email_address + "\t|" + business_phone +
				"\n-------------------------------------------";
	}
	
	public void menu(Customers ct) {
		Scanner sc = new Scanner(System.in);
		
		int escolha = 0;		
		while(escolha != 9) {
		System.out.println("MENU:\n 1)Inserir um novo cliente\n "
	    		+ "2)Listar clientes cadastrados\n "
	    		+ "3)Listar dados de um determinado cliente\n "
	    		+ "4)Atualizar os dados de um cliente\n "
	    		+ "5)Remover um clente do Banco de Dados\n "
	    		+ "9)Sair");
		escolha = sc.nextInt();
		switch(escolha) {
		case 1:				
			System.out.println("Digite somente o nome do novo Cliente ");
			ct.setFirst_name(sc.next());
			System.out.println("Digite o sobrenome do novo Cliente ");
			ct.setLast_name(sc.next());
			System.out.println("Digite o e-mail do novo Cliente ");
			ct.setEmail_address(sc.next());
			System.out.println("Digite o telefone do novo Cliente ");
			ct.setBusiness_phone(sc.next());
			
			dao.insert(ct);
			System.out.println("Cliente inserido\n");
			break;
		
		case 2:						
			dao.select();
			break;		
			
		case 3:			
			System.out.println("Digite o ID de um cliente para procura: ");
			int id = sc.nextInt();
			dao.selectById(id);
			break;
			
		case 4:
			System.out.println("Digite o ID de um cliente para editar: ");
			int id4 = sc.nextInt();
			dao.selectById(id4);
			
			int escolhaTabela = 0;
			String tabela = "";
			
			while(escolhaTabela != 9){
				
			System.out.println("---------------\nDigite uma coluna para editar\n1)Nome\n2)Sobrenome\n3)E-Mail\n4)Telefone\n9)Sair");
			escolhaTabela = sc.nextInt();
			if(escolhaTabela == 1) {
				tabela = "fisrt_name";
			}
			if(escolhaTabela == 2){
				tabela = "last_name";
			}
			if(escolhaTabela == 3){
				tabela = "email_address";
			}
			if(escolhaTabela == 4){
				tabela = "business_phone";
			}
			if (escolhaTabela == 9) {
				break;
			}
			
			System.out.println("Digite os dados novos: ");
			String dados = sc.next();
			
			dao.edit(tabela, dados, id4);
			
			}
			
			break;
			
		case 5:
			System.out.println("Digite o ID de um cliente para apagar: ");
			int id5 = sc.nextInt();
			dao.delete(id5);
			System.out.println("Cliente " + id5 + " deletado\n");
			break;
			
			}
		}
																
		sc.close();
	}

	
	
	


}
