package clinica;

public class Session {
	private int id;
	private int serviceId;
	private String date;
	private String time;
	
	//Construtor {metodo chamado para instanciar/inicializar o objeto}
	public Session(int id, int serviceId, String date, String  time) {
		this.id = id;
		this.serviceId = serviceId;
		this.date = date;
		this.time = time;
	}
	
	 //usado para acessar o valor
	public int getId() {
		return id;
	}
	
	//usado para modificar/atribuir o valor
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getServiceId() {
		return serviceId;
	}
	
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
}
