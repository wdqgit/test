package kryo;

import java.io.Serializable;

public class TUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4787206831934673868L;
	
	private Integer uid;
	private String createtime;
	private String modifytime;
	private String uregistrationid;
	private Integer ucompany;
	private String uemployeeid;
	private String unt;
	private String uname;
	private String unickname;
	private String unicknamesearch;
	private String upwd;
	private String usign;
	private String udevice;
	private Integer uisleave;
	private Integer uregion;
	private String uheader;
	private String ulocation;
	private Integer uisshownickname;
	private String uintroduction;
	private String usex;
	private String uorganame;
	private Integer upersonid;
	private Integer uatallpermission;
	
	private TUserStatus userStatus;
	public TUser(){}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getModifytime() {
		return modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	public String getUregistrationid() {
		return uregistrationid;
	}

	public void setUregistrationid(String uregistrationid) {
		this.uregistrationid = uregistrationid;
	}

	public Integer getUcompany() {
		return ucompany;
	}

	public void setUcompany(Integer ucompany) {
		this.ucompany = ucompany;
	}

	public String getUemployeeid() {
		return uemployeeid;
	}

	public void setUemployeeid(String uemployeeid) {
		this.uemployeeid = uemployeeid;
	}

	public String getUnt() {
		return unt;
	}

	public void setUnt(String unt) {
		this.unt = unt;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUnickname() {
		return unickname;
	}

	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUsign() {
		return usign;
	}

	public void setUsign(String usign) {
		this.usign = usign;
	}

	public String getUdevice() {
		return udevice;
	}

	public void setUdevice(String udevice) {
		this.udevice = udevice;
	}

	public Integer getUisleave() {
		return uisleave;
	}

	public void setUisleave(Integer uisleave) {
		this.uisleave = uisleave;
	}

	public Integer getUregion() {
		return uregion;
	}

	public void setUregion(Integer uregion) {
		this.uregion = uregion;
	}

	public String getUheader() {
		return uheader;
	}

	public void setUheader(String uheader) {
		this.uheader = uheader;
	}

	public String getUlocation() {
		return ulocation;
	}

	public void setUlocation(String ulocation) {
		this.ulocation = ulocation;
	}

	public TUserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(TUserStatus userStatus) {
		this.userStatus = userStatus;
	}
	
	public Integer getUisshownickname() {
		return uisshownickname;
	}

	public void setUisshownickname(Integer uisshownickname) {
		this.uisshownickname = uisshownickname;
	}

	public String getUintroduction() {
		return uintroduction;
	}

	public void setUintroduction(String uintroduction) {
		this.uintroduction = uintroduction;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}
	
	public String getUorganame() {
		return uorganame;
	}

	public void setUorganame(String uorganame) {
		this.uorganame = uorganame;
	}
	
	public String getUnicknamesearch() {
		return unicknamesearch;
	}

	public void setUnicknamesearch(String unicknamesearch) {
		this.unicknamesearch = unicknamesearch;
	}
	
	public Integer getUpersonid() {
		return upersonid;
	}

	public void setUpersonid(Integer upersonid) {
		this.upersonid = upersonid;
	}

	public Integer getUatallpermission() {
		return uatallpermission;
	}

	public void setUatallpermission(Integer uatallpermission) {
		this.uatallpermission = uatallpermission;
	}

	@Override
	public String toString() {
		return "TUser [uid=" + uid + ", createtime=" + createtime + ", modifytime=" + modifytime + ", uregistrationid=" + uregistrationid + ", ucompany=" + ucompany + ", uemployeeid=" + uemployeeid + ", unt=" + unt + ", uname=" + uname + ", unickname=" + unickname + ", unicknamesearch=" + unicknamesearch + ", upwd=" + upwd + ", usign=" + usign + ", udevice=" + udevice + ", uisleave=" + uisleave + ", uregion=" + uregion + ", uheader=" + uheader + ", ulocation=" + ulocation + ", uisshownickname=" + uisshownickname + ", uintroduction=" + uintroduction + ", usex=" + usex + ", uorganame=" + uorganame + ", upersonid=" + upersonid + ", uatallpermission=" + uatallpermission + ", userStatus=" + userStatus + "]";
	}
	
}
