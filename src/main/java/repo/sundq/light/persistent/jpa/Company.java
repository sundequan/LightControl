package repo.sundq.light.persistent.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 *
 *@auther ksun
 *@date 2018年6月10日 下午5:57:33
*/

@Entity
public class Company {
	@Id
	@GeneratedValue
	private int id;

	@Column(columnDefinition=("varchar(255) not null comment '公司名字'"))
	private String name;
	
	@Column(columnDefinition=("varchar(255) not null"))
	private String addr;
	
	@Column(columnDefinition=("varchar(50) comment '电话号码多个逗号分隔'"))
	private String tel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
