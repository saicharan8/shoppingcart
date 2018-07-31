package com.shoppingcart.model;

public class Cart {

public int OID;
public int TotalPrice;

public Cart(int OID, int TotalPrice) {
    this.OID = OID;
    this.TotalPrice = TotalPrice;
}

public Cart() {
	// TODO Auto-generated constructor stub
}

public int getOID() {
    return OID;
}

public void setOID(int OID) {
    this.OID = OID;
}



public int getTotalPrice() {
    return TotalPrice;
}

public void setTotalPrice(int TotalPrice) {
    this.TotalPrice = TotalPrice;
}

}