package primitive_bank;

import java.util.List;

public class Client {
	private String client_id;
	private String f_name;
	private String l_name;
	
	private String SIN;
	private String DOB;
	private String phone;
	private String email;
	
	
	// Default Constructor
	public Client() {
		client_id = "";
		f_name = "";
		l_name = "";
	
		SIN = "";
		DOB = "";
		phone = "";
		email = "";
		
	}

	// Parameterized Constructor
	public Client(String f_name, String l_name, String SIN, String dob, String phone, String email) {
		client_id = "";
		this.f_name = f_name;
		this.l_name = l_name;
		
		this.SIN = SIN;
		this.DOB = dob;
		this.phone = phone;
		this.email = email;
		
	}
	
	// Parameterized Constructor
	public Client(String id, String pf_name, String pl_name, String pSIN, String pdob, String pphone, String pemail) {
		this.client_id = id;
		this.f_name = pf_name;
		this.l_name = pl_name;
		
		this.SIN = pSIN;
		this.DOB = pdob;
		this.phone = pphone;
		this.email = pemail;
		
	}	
	
	void showClientInfo() {
		System.out.println("First Name: "+f_name);
		System.out.println("Last Name: "+l_name);
		System.out.println("SIN Name: "+SIN);
		System.out.println("DOB Name: "+DOB);
		System.out.println("Phone Name: "+phone);
		System.out.println("Email Name: "+email);
		
	}
	
	public String getClientID() {
		return this.client_id;
	}
	
	public String getFName() {
		return f_name;
	}
	
	public String getLName() {
		return l_name;
	}
	

	
	public String getSIN() {
		return SIN;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	

	
	public int transferMoney( String recv_acc, int amount) {
		DB_Handler db = new DB_Handler();
		return db.TransferMoney(this, recv_acc, amount);
	}
	
	
	
	int change_password(String curr_pass, String new_pass_1, String new_pass_2, String acc_num)
	{
		DB_Handler db = new DB_Handler();
		int acc_no = Integer.parseInt(acc_num);
		int login_id = db.getLoginID(acc_no);
		if (login_id == -1)
		{
			return -1;			//could not find portal
		}
		else if ( !curr_pass.equals(db.get_password(login_id)))
		{
			return -2;
		}
		else if (new_pass_1.equals(new_pass_2))
		{
			db.change_password(new_pass_1, login_id);
			return 0;
		}
		else
		{
			return -3;
		}
	}
	
	public List<Transaction_History> getTransactions( String acc_num, String From, String To) {
		DB_Handler db = new DB_Handler();
		List<Transaction_History> list = db.getTransactions( acc_num, From, To);
		return list;
	}
	
	
	
	// end of class
}
