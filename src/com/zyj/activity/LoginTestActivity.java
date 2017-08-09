package com.zyj.activity;

import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.zyj.login.R;
import com.zyj.util.SaveInfo;

public class LoginTestActivity extends Activity {
    /** Called when the activity is first created. */
	private EditText eaccount;
	private EditText epwd;
	private Button login;
	private CheckBox ck;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        eaccount=(EditText) findViewById(R.id.account);
        epwd=(EditText) findViewById(R.id.password);
        ck=(CheckBox) findViewById(R.id.ck);
        SharedPreferences sp=getSharedPreferences("info", 0);
        String account = sp.getString("account", "");
        String password=sp.getString("password", "");
        eaccount.setText(account);
    	epwd.setText(password);
        Boolean b=sp.getBoolean("ck", false);
        ck.setChecked(b);
       /* Map<String,String> map=SaveInfo.readinfo(LoginTestActivity.this);
        if(map!=null){
        	eaccount.setText(map.get("account"));
        	epwd.setText(map.get("password"));
        }*/
    }
    
    public void login(View v){
    	String account =eaccount.getText().toString().trim();
    	String password=epwd.getText().toString().trim();
    	if(TextUtils.isEmpty(account)||TextUtils.isEmpty(password)){
    		Toast.makeText(LoginTestActivity.this,"用户名和密码不能为空！",1).show();
    	}else{
    		if(ck.isChecked()){
    			SharedPreferences sp=getSharedPreferences("info", 0);
    			Editor edit=sp.edit();
    			edit.putString("account", account);
    			edit.putString("password", password);
    			edit.putBoolean("ck", true);
    			edit.commit();
    			//SaveInfo.saveinfo(LoginTestActivity.this, account, password);
    		}
    		System.out.println("登录中。。。");
    	}
    }
}