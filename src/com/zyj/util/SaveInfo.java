package com.zyj.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

public class SaveInfo {
	
	public static boolean saveinfo(Context context,String account,String password){
		String result=account+","+password;
		String path=context.getFilesDir().getPath();
		File file=new File(path, "info.txt");
		try {
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(result.getBytes());
			fos.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static Map<String,String> readinfo(Context context){
		
		Map<String,String> map=new HashMap<String, String>();
		String path=context.getFilesDir().getPath();
		File file=new File(path,"info.txt");
		try {
			FileInputStream fis=new FileInputStream(file);
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fis));
			String data=bufferedReader.readLine();
			String[] datas=data.split(",");
			map.put("account", datas[0]);
			map.put("password", datas[1]);
			fis.close();
			return map;
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
