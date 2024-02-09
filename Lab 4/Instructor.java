package Lab04B;

abstract class Instructor {
	
	//Number of unread mail the instructor has
	private int unreadMail;
	
	//Age of instructor
	private int age;
	
	//Number of eccentricities
	private int eccentricities;

	/**
	 * @param age
	 * @param unreadMail
	 */
	public Instructor (int age, int unreadMail){
		this.age = age;
		this.unreadMail = unreadMail;
		this.eccentricities = 0;
	};
	
	abstract void cope();
	
	/**
	 * @param newMail
	 */
	public void getMail(int newMail){
		this.unreadMail += newMail;					
		if(Math.random() > 0.8){					
			if(Math.random() >0.5){					
				this.eccentricities += 2;
			}
			else{
				if((this.eccentricities-2) >= 0){	
					this.eccentricities -= 2;	    
				}
				else{
					this.eccentricities = 0;		
				}
			}
		}
		if(stress() > respect()){				   
			System.out.println("Stress Level: " + stress() + " Respect Level: " + respect());
			cope();			
		}
	}
	
	/**
	 * @return stress level
	 */
	public int stress(){
		if(unreadMail < 1000){
			return unreadMail;
		}
		else{
			return 1000;
		}
	}
	
	/**
	 * @return respect
	 */
	public int respect(){
		int aid = age - eccentricities;		
		if (aid >= 0){
			return aid;
		}
		else{
			return 0;
		}
	}
	
	
	/**
	 * @return unreadMail
	 */
	public int getUnreadMail(){
		return unreadMail;
	}
	
	/**
	 * @return age
	 */
	public int getAge(){
		return age;
	}
	
	/**
	 * @return eccentricities
	 */
	public int getEccentric(){
		return eccentricities;
	}
	
	
	/**
	 * @param age
	 */
	public void setAge(int age){
		this.age = age;
	}
	
	
	/**
	 * @param readMail 
	 */
	public void reduceMail(int readMail){
		if(unreadMail >= readMail){
			this.unreadMail = this.unreadMail - readMail;
		}
		else{
			System.out.println("Not enough mail to delete. Unread Mail: " + unreadMail);
		}
	}
	
	/**
	 * @param eccentric
	 */
	public void addToEccentric(int eccentric){
		if(eccentric >= 0){									
			this.eccentricities += eccentric;				
		}
		else{  
			if((this.eccentricities + eccentric) < 0){		
				this.eccentricities = 0;
			}
			else{
				this.eccentricities = this.eccentricities + eccentric;
			}
		}
	}
}
