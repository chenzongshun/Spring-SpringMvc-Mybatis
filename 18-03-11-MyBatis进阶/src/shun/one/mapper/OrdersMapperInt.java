package shun.one.mapper;

import java.util.List;

import shun.one.pojo.Orders;
 
/**
* @author czs
* @version ����ʱ�䣺2018��3��10�� ����3:52:55 
*/
public interface OrdersMapperInt {
	/**
	 * ��ѯ������order���������� 
	 * @return
	 */
	public List<Orders> selectOrdersList(); 
	
	/**
	 * һ��һ������ѯ���Զ���Ϊ���Ĺ����û�    ���������Ӧһ���û�
	 * @return
	 */
	public List<Orders> selectOrders();
	
	
}
