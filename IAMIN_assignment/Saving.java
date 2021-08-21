class Saving
{
	private int gno;
	private String gname;
	private int gamount;
//	private int gtrans;

Saving(){
}
public Saving(int gno,String gname,int gamount)
{
this.gno = gno;
this.gname = gname;
this.gamount = gamount;	
}

public void setGno(int gno){
	this.gno = gno;
}
public int getGno() {
    return gno;
}

public void setGname(String gname) {
    this.gname = gname;
}
public String getGname() {
    return gname;
}

public void setGamount(int gamount) {
    this.gamount= gamount;
}
public int getGamount() {
    return gamount;
}

}

