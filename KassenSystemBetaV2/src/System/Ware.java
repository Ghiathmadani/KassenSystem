package System;

public class Ware {
	
    private String name;
    private int menge;
    private double price;

    // constructor
    public Ware(String name, int menge, double price) {
    	this.name = name;
    	this.menge = menge;
    	this.price = price;
    }
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public void decreaseMenge(int n) {
		this.menge= menge-n;
	}

	@Override
	public String toString() {
		return  " name=" + name + " menge=" + menge + " price=" + price + "\n";
	}


//    public Item(Connection c,String name,int menge,int price) throws SQLException {
//		String sql = "INSERT INTO myWare (name, menge, price) VALUES (?, ?, ?)";
//
//		try (PreparedStatement stm = c.prepareStatement(sql)) {
//			
//			stm.setString(1, name);
//			stm.setInt(2, menge);
//			stm.setDouble(3, price);
//			stm.executeUpdate();
//		}
//    }

	

	
    
}
