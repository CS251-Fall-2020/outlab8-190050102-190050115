
public class Vehicle{
	private String regNo,manufacturer,owner;
	private double co2,co,hc;
	private String pollutionStatus;

	public Vehicle(String x,String y,String z){
		regNo = x;
		manufacturer=y;
		owner = z;
		pollutionStatus = "PENDING";
		co2=-1;
		co = -1;
		hc = -1;
	}

	public void checkPollutionStatus(){
		
	}

	public void setvalues(double x,double y,double z){
		co2 = x;
		co = y;
		hc = z;
	}

	public String toString(){
		String s="";
		s = "Reg No.: "+regNo+"\n"+"Manufacturer: "+manufacturer+"\n"+"Owner: "+owner+"\n"+"Pollution Status: "+pollutionStatus;
		return s;
	}

	public double getco2(){
		return this.co2;
	}

	public double getco(){
		return this.co;
	}

	public double gethc(){
		return this.hc;
	}

	public String getregNo(){
		return this.regNo;
	}

	public String getpollutionStatus(){
		return this.pollutionStatus;
	}

	public void setpollstat(String s){
		this.pollutionStatus = s;
	}
}