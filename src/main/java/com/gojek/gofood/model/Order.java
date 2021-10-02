package com.gojek.gofood.model;

public class Order {
	/*
	 * Declare the variable
	 */
	private User dataUser;
	private Product dataProduk;
	private String menu,orderStatus,location;
	private int jmlPesanan;
	private boolean statusPembayaran;
	private float totalPembayaran;
	
	/*
	 * Build the constructor
	 */
	public Order(User user, Product produk, int jml, boolean status, float total) {
		this.dataUser = user;
		this.dataProduk = produk;
		this.jmlPesanan = jml;
		this.statusPembayaran = status;
		this.totalPembayaran = total;
		this.menu="";
		this.orderStatus="";
		this.location="";
	}
	public Order(Product productInfo) {
		this.dataProduk = productInfo;
		this.menu="";
		this.orderStatus="";
		this.location="";
	}
	
	/*
	 * Build the getter
	 */
	public String getNamaProdukPesanan() { return this.dataProduk.getName(); }
	public String getNamaPemesan() { return this.dataUser.getName(); }
	public int getJmlProdukPesanan() { return this.jmlPesanan; }
	public float getHargaProdukPesanan() { return this.dataProduk.getPrice(); }
	public float getPromoProdukPesanan() { return this.dataProduk.getDiscount(); }
	public boolean getStatusPembayaran() { return this.statusPembayaran; }
	public float getTotalPembayaran() {return this.totalPembayaran; }
	public float getSaldoUser() { return this.dataUser.getBalance(); }
	public void setMenu(String menu) { this.menu = menu;}
	public String getMenu() { return this.menu;}
	public void setLocation(String location) { this.location = location;}
	public String getLocation() { return this.location;}
	public void setOrderStatus(String status) { this.orderStatus = status;}
	public String getOrderStatus() { return this.orderStatus;}
	/*
	 * Build the setter
	 */
	public void setTotalPembayaran(float total) {
		this.totalPembayaran = total;
	}
	public String getRecommendedPayment(float amount, float balance) {
		if(amount > balance && this.getSaldoUser() > 0) {
			return "gopay+cash";
		} else if(amount > balance && this.getSaldoUser() == 0) {
			return "cash";
		} else if (amount <= balance) {
			return "gopay";
		}
		return "gopay";
	}
	public float getTotalPembayaranAfterReduction() {
		return this.getTotalPembayaran() - this.getSaldoUser();
	}
}
