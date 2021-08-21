class Transact
{
 private int gTransNo, gtransAmount;

Transact()
{
}

public Transact(int gTransNo,int gtransAmount)
{
this.gTransNo = gTransNo;
this.gtransAmount = gtransAmount;
}
public int getgTransNo() {
	return gTransNo;
}

public void setgTransNo(int gTransNo) {
	this.gTransNo = gTransNo;
}

public int getGtransAmount() {
	return gtransAmount;
}

public void setGtransAmount(int gtransAmount) {
	this.gtransAmount = gtransAmount;
}

}

