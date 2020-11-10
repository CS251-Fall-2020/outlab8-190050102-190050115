
class Car extends Vehicle{

	Car(String x, String y,String z){
		super(x,y,z);
	}

	public void checkPollutionStatus(){

		double cco2 = getco2();
		double cco  = getco();
		double chc = gethc();

		if(cco2 == -1 || cco == -1 || chc == -1){
			this.setpollstat("PENDING");
		}
		else if(cco2<=15 && cco<=0.5 && chc<=750){
			this.setpollstat("PASS");
		}
		else{
			this.setpollstat("FAIL");
		}
	}
}