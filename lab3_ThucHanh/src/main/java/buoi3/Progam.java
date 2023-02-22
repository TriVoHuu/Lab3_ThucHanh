package buoi3;

public class Progam {

	public static void main(String[] args) {

		Manufactory manu2 = new Manufactory("manu2","name","US",200);
		Phone p = new Phone("phone2","Samsung",16000000,"pink","china",2,manu2);
		ManufactoryDAO.add(manu2);
		PhoneDAO.add(p);
		PhoneDAO.getAll();
		PhoneDAO.highestPrice();
		PhoneDAO.sort_country();
		PhoneDAO.price_over50M();
		PhoneDAO.pink_over15M();
		
		ManufactoryDAO.getAll();
		ManufactoryDAO.over100employee();
		ManufactoryDAO.sum_employee();
		ManufactoryDAO.base_in_US();
	}

}
