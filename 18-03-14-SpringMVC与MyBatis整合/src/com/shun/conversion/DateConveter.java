package com.shun.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
* @author czs
* @version 创建时间：2018年3月17日 上午10:08:53
* 用来转换日期的案例 
* 泛型s---String是从页面传递过来的类型
* 泛型t---Date是转换后的类型
*/
public class DateConveter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			if (null != source) {
				// 假如在jsp页用户输入的格式为======2018:03-17 10_21-55，那么在这里进行格式化（比如没有用日期控件输入进来的格式）
				DateFormat dateFormat = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
				return dateFormat.parse(source);
			}
		} catch (Exception e) {// 转换失败的处理
			e.printStackTrace();
		}
		return null;
	}
}


