
class Truck extends Vehicle{

	Truck(String x, String y,String z){
		super(x,y,z);
	}
	
	@Override
	public void checkPollutionStatus(){
		
		double cco2 = getco2();
		double cco  = getco();
		double chc = gethc();
		
		if(cco2 == -1 || cco == -1 || chc == -1){
			this.setpollstat("PENDING");
		}
		else if(cco2<=25 && cco<=0.8 && chc<=1000){
			this.setpollstat("PASS");
		}
		else{
			this.setpollstat("FAIL");
		}
	}
}