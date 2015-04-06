package com.example.practicaltest01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class PracticalTest01MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		Intent intent = getIntent();
		if(intent != null) {
			try {
				Toast.makeText(this, intent.getStringExtra("rezultat"), Toast.LENGTH_LONG).show();
			} catch (Exception e) {	}
		}
		
		final CheckBox c1 = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
		final EditText t1 = (EditText) findViewById(R.id.editText1);
		final EditText t2 = (EditText) findViewById(R.id.editText2);
		
		if(savedInstanceState != null) {
			Log.d("PT1", "restore from onCreate()");
			c1.setChecked(savedInstanceState.getBoolean("checkbox1"));
		    c2.setChecked(savedInstanceState.getBoolean("checkbox2"));
		    t1.setText(savedInstanceState.getString("text1"));
		    t2.setText(savedInstanceState.getString("text2"));
		    if (c1.isChecked()) {
				t1.setEnabled(true);
			} else {
				t1.setEnabled(false);
			}
		    if (c2.isChecked()) {
				t2.setEnabled(true);
			} else {
				t2.setEnabled(false);
			}
		}
				
		c1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (c1.isChecked()) {
					t1.setEnabled(true);
				} else {
					t1.setEnabled(false);
				}
			}
		});
		
		c2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (c2.isChecked()) {
					t2.setEnabled(true);
				} else {
					t2.setEnabled(false);
				}
			}
		});
		
		Button b1 = (Button) findViewById(R.id.button1);
		final Context context = this;
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent(context, PracticalTest01SecondaryActivity.class);
				intent.putExtra("text1", t1.getText().toString());
				intent.putExtra("text2", t2.getText().toString());
			
				startActivity(intent);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	  @Override
	  public void onSaveInstanceState(Bundle savedInstanceState) {
	    super.onSaveInstanceState(savedInstanceState);
	    Log.d("PT1", "onSaveInstanceState()");
	    CheckBox c1 = (CheckBox) findViewById(R.id.checkBox1);
		CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
		EditText t1 = (EditText) findViewById(R.id.editText1);
		EditText t2 = (EditText) findViewById(R.id.editText2);
	    savedInstanceState.putBoolean("checkbox1", c1.isChecked());
	    savedInstanceState.putBoolean("checkbox2", c2.isChecked());
	    savedInstanceState.putString("text1", t1.getText().toString());
	    savedInstanceState.putString("text2", t2.getText().toString());
	  }
	  
	  @Override
	  public void onRestoreInstanceState(Bundle savedInstanceState) {
	    super.onRestoreInstanceState(savedInstanceState);
	    Log.d("PT1", "onRestoreInstanceState()");
	    CheckBox c1 = (CheckBox) findViewById(R.id.checkBox1);
		CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
		EditText t1 = (EditText) findViewById(R.id.editText1);
		EditText t2 = (EditText) findViewById(R.id.editText2);
		c1.setChecked(savedInstanceState.getBoolean("checkbox1"));
	    c2.setChecked(savedInstanceState.getBoolean("checkbox2"));
	    t1.setText(savedInstanceState.getString("text1"));
	    t2.setText(savedInstanceState.getString("text2"));
	    if (c1.isChecked()) {
			t1.setEnabled(true);
		} else {
			t1.setEnabled(false);
		}
	    if (c2.isChecked()) {
			t2.setEnabled(true);
		} else {
			t2.setEnabled(false);
		}
	  }
}
