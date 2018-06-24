package shun.one.mapper;

import java.util.List;

import shun.one.pojo.Orders;
 
/**
* @author czs
* @version 创建时间：2018年3月10日 下午3:52:55 
*/
public interface OrdersMapperInt {
	/**
	 * 查询订单表order的所有数据 
	 * @return
	 */
	public List<Orders> selectOrdersList(); 
	
	/**
	 * 一对一关联查询，以订单为中心关联用户    多个订单对应一个用户
	 * @return
	 */
	public List<Orders> selectOrders();
	
	
}
