package com.example.bmidigitron;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMIKalkulator extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myapp.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void izracunajBMI(View view) {
    	double unesitezinudouble;
    	double unesivisinunudouble;
    	String izlazBMI = "";
        // Do something in response to button
    	Intent intent = new Intent(this, BMIKalk.class);
    	EditText unesivisinu = (EditText) findViewById(R.id.UnesiVisinu);
    	EditText unesitezinu = (EditText) findViewById(R.id.UnesiTezinu);
    	
    	if(unesitezinu == null ) {

    		unesitezinudouble = 0.0;

    		} 
    	else {

    		 unesitezinudouble = Double.parseDouble(unesitezinu.getText().toString());
    		 
    		 if ( unesitezinudouble < 30|| unesitezinudouble > 200 ) {
    			 unesitezinudouble = 0.0;
    		 }
    		 

    		}
    	
    	if(unesivisinu == null ) {

    		unesivisinunudouble = 0.0;

    		} else {

    		unesivisinunudouble = Double.parseDouble(unesivisinu.getText().toString());
    		
    		if ( unesivisinunudouble < 1.2 || unesivisinunudouble > 2.4 ) {
    			unesivisinunudouble = 0;
    		}

    		}
    	
    	double BMI = unesitezinudouble / (unesivisinunudouble * unesivisinunudouble);
    	
    	if ( BMI <= 15 ) {
    		izlazBMI = "Anoreksicni";
    	}
    	else if ( ( BMI > 15 ) && ( BMI <= 18.5 ) ) {
    		izlazBMI = "Mrsavi";
    	}
    	else if ( ( BMI > 18.5 ) && ( BMI <= 25 ) ) {
    		izlazBMI = "Normalni";
    	}
    	else if ( ( BMI > 25 ) && ( BMI <= 30 ) ) {
    		izlazBMI = "Popunjeni";
    	}
    	else if ( ( BMI > 30 ) && ( BMI <= 40 ) ) {
    		izlazBMI = "Debeli";
    	}
    	if ( BMI > 40 ) {
    		izlazBMI = "Gojazani";
    	}
    	String blah = intent.getStringExtra(izlazBMI);
    	intent.putExtra(EXTRA_MESSAGE, blah);
    	System.out.println(izlazBMI);
    	
    	/*
    	EditText BMIIzlaz = (EditText)findViewById(R.id.IzlazBMI);
    	BMIIzlaz.setText(izlazBMI, TextView.BufferType.EDITABLE);
    	*/
    	
    	TextView t = (TextView)findViewById(R.id.KakavJeVasBMI);
    	t.setTextSize(30);
    	t.setText("Vi ste " + izlazBMI);
    	
	    
    	
    }


    
}
