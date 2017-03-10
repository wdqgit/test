package kryo;

import java.io.Serializable;

public class TUserStatus implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4603242188276316970L;
	
	private Integer usid;
	private Integer uid;
	private String modifytime;
	private Integer uspostnum;
	private Integer uspopularity;
	private Integer usattentionnum;
	private Integer usfansnum;
	
	private TUser user;
	public TUserStatus(){}

	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getModifytime() {
		return modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getUspostnum() {
		return uspostnum;
	}

	public void setUspostnum(Integer uspostnum) {
		this.uspostnum = uspostnum;
	}

	public Integer getUspopularity() {
		return uspopularity;
	}

	public void setUspopularity(Integer uspopularity) {
		this.uspopularity = uspopularity;
	}

	public Integer getUsattentionnum() {
		return usattentionnum;
	}

	public void setUsattentionnum(Integer usattentionnum) {
		this.usattentionnum = usattentionnum;
	}

	public Integer getUsfansnum() {
		return usfansnum;
	}

	public void setUsfansnum(Integer usfansnum) {
		this.usfansnum = usfansnum;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}
	
}
