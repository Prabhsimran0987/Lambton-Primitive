package primitive_bank;

public class Login_Account {
	private String login_id;
	private String username;
	private String password;
	private String type;

	public Login_Account() {
		this.login_id = "";
		this.username = "";
		this.setPassword("");
		this.type = "";
	}
	
	public Login_Account(String login_id, String username, String password, String type) {
		this.login_id = login_id;
		this.username = username;
		this.setPassword(password);
		this.type = type;
	}	
	
	public String getLoginId() {
		return this.login_id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getType() {
		String type_ = "";
		if( type.compareTo("C") == 0 )
			type_ = "Client";
		else if( type.compareTo("M") == 0 )
			type_ = "Manager";
		else if( type.compareTo("A") == 0 ) 
			type_ = "Accountant";
		return type_;
	}
	
	int verify_account(String acc_num, String SIN)
	{
		DB_Handler db = new DB_Handler();
		int temp_client_id = db.get_client_id(Integer.parseInt( acc_num ));
		System.out.println("The client id is: " + temp_client_id);
		
		if (temp_client_id == -1)
		{
			return -1;
		}
		else if (db.login_exists(temp_client_id) == false)
		{
			return -2;
		}
		else if (db.verify_SIN(temp_client_id, SIN))
		{
			return -3;
		}
		return 0;
	}
	
	int signup(String username, String pass_1, String pass_2, String acc_num)
	{
		DB_Handler db = new DB_Handler();
		int client_id = db.get_client_id(Integer.parseInt(acc_num));
		
		if (pass_1.equals(pass_2) == false )
		{
			return -1;
		}
		else if(username.equals("") == true) {
			return -111;
		}
		else if(pass_1.equals("") == true) {
			return -11;
		}
		
		else
		{
			System.out.println("Two passwords have successfully matched");
			int temp_login = db.create_login(username, pass_1);
			if (temp_login == -1)
			{
				return -2;
			}
			db.set_login_id(temp_login, client_id);
			return 0;
		}
	}
	
	public String getName() {
		DB_Handler db = new DB_Handler();
		return db.getName( this.login_id );
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// end of class
}
