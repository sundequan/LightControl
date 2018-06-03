package repo.sundq.light.pojo;

/**
 * 
 * @author ksun
 * @date 2018年6月3日
 */
public class HttpMsg {
	/*
	 * device id
	 */
	private Integer did;
	
	/**
	 * data to send
	 */
	private String data;

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
