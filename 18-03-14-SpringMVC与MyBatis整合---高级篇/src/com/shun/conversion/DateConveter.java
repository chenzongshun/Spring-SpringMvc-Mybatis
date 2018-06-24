package com.shun.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
* @author czs
* @version ����ʱ�䣺2018��3��17�� ����10:08:53
* ����ת�����ڵİ��� 
* ����s---String�Ǵ�ҳ�洫�ݹ���������
* ����t---Date��ת���������
*/
public class DateConveter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			if (null != source) {
				// ������jspҳ�û�����ĸ�ʽΪ======2018:03-17 10_21-55����ô��������и�ʽ��������û�������ڿؼ���������ĸ�ʽ��
				DateFormat dateFormat = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
				return dateFormat.parse(source);
			}
		} catch (Exception e) {// ת��ʧ�ܵĴ���
			e.printStackTrace();
		}
		return null;
	}
}


