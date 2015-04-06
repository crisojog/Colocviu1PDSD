package com.example.practicaltest01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Intent intent = getIntent();
		final EditText t1 = (EditText) findViewById(R.id.editText3);
		final EditText t2 = (EditText) findViewById(R.id.editText4);
		//Bundle b = intent.getExtras();
		t1.setText(intent.getStringExtra("text1"));
		t2.setText(intent.getStringExtra("text2"));
		
		Button bOk = (Button) findViewById(R.id.buttonOk);
		Button bCancel = (Button) findViewById(R.id.buttonCancel);
		final Context context = this;
		bOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, PracticalTest01MainActivity.class);
				intent.putExtra("rezultat", "OK");			
				startActivity(intent);
			}			
		});
		bCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, PracticalTest01MainActivity.class);
				intent.putExtra("rezultat", "Cancel");			
				startActivity(intent);
			}			
		});
	}
	
	
	
}
