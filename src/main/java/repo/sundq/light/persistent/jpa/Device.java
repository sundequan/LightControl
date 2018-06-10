package repo.sundq.light.persistent.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 *@auther ksun
 *@date 2018年6月10日 下午5:57:33
*/

@Entity
public class Device {
	@Id
	@GeneratedValue
	private int id;
	private int status;
	private int groupId;
	private String lng;
	private String lat;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public int getId() {
		return id;
	}
	
	
}
