package com.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;

public class Util {

	/**
	 * 解析请求参数
	 * @param request
	 * @return
	 */
	public static String httpProcess(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer() ;
		InputStream is = null;
		try {
			is = request.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String s = "" ;
		try {
			while((s=br.readLine())!=null){
				sb.append(s) ;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sb.toString().length()<=0){
			return null;
		}else {
			return sb.toString();
		}
	}

}