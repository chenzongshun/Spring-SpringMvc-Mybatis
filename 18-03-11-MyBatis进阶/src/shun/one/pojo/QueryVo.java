package shun.one.pojo;

import java.io.Serializable;
import java.util.List;

/**
* @author czs
* @version ����ʱ�䣺2018��3��10�� ����2:06:20  ��װ��
*/
public class QueryVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private List<Integer> idsList;
	
	private Integer[] ids;

	public List<Integer> getIdsList() {
		return idsList;
	}

	public void setIdsList(List<Integer> idsList) {
		this.idsList = idsList;
	}

	public Integer[] getIds() {
		return ids;
	}
 
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
