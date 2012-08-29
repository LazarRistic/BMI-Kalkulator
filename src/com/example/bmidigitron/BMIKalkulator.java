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
    	int provera = 0;
    	int tezinaNull = 0;
    	int visinaNull = 0;
    	int tezinaVanGranica = 0;
    	int visinaVanGranica = 0;
    	String izlazBMI = "";
        // Do something in response to button
    	Intent intent = new Intent(this, BMIKalk.class);
    	EditText unesivisinu = (EditText) findViewById(R.id.UnesiVisinu);
    	EditText unesitezinu = (EditText) findViewById(R.id.UnesiTezinu);
    	
    	if(unesitezinu == null ) {

    		unesitezinudouble = 0.0;
    		provera = 1;
    		tezinaNull = 1;

    		} 
    	else {

    		 unesitezinudouble = Double.parseDouble(unesitezinu.getText().toString());
    		 
    		 if ( unesitezinudouble < 30|| unesitezinudouble > 200 ) {
    			 unesitezinudouble = 0.0;
    			 provera = 1;
    			 tezinaVanGranica = 1;
    		 }
    		 

    		}
    	
    	if(unesivisinu == null ) {

    		unesivisinunudouble = 0.0;
    		provera = 1;
    		visinaNull = 1;

    		} else {

    		unesivisinunudouble = Double.parseDouble(unesivisinu.getText().toString());
    		
    		if ( unesivisinunudouble < 1.2 || unesivisinunudouble > 2.4 ) {
    			unesivisinunudouble = 0;
    			provera = 1;
    			visinaVanGranica = 1;
    		}

    		}
    	
    	if ( provera == 0 ) {
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
    		else if ( BMI > 40 ) {
    			izlazBMI = "Gojazani";
    		}
    		else {
    			
    		}
    	
    	}
    	
    	else {
    		izlazBMI = " ";
    	}
    	
    	String blah = intent.getStringExtra(izlazBMI);
    	intent.putExtra(EXTRA_MESSAGE, blah);
    	System.out.println(izlazBMI);
    	
    	/*
    	EditText BMIIzlaz = (EditText)findViewById(R.id.IzlazBMI);
    	BMIIzlaz.setText(izlazBMI, TextView.BufferType.EDITABLE);
    	*/
    	
    	TextView t = (TextView)findViewById(R.id.KakavJeVasBMI);
    	
    	if ( provera == 0) {
    		t.setTextSize(30);
    		t.setText("Vi ste " + izlazBMI);
    	}
    	else if ( provera == 1 && visinaNull == 1 ) {
    		t.setTextSize(30);
    		t.setText("Niste uneli visinu");
    	}
    	else if ( provera == 1 && visinaVanGranica == 1 ) {
    		t.setTextSize(20);
    		t.setText("Visinu koju ste uneli je van dozvoljenih granica (Donja granica: 1.2m, Gornja granica: 2.4m)");
    	}
    	else if ( provera == 1 && tezinaNull == 1) {
    		t.setTextSize(30);
    		t.setText("Niste uneli tezinu");
    	}
    	else if ( provera == 1 && tezinaVanGranica ==1 ) {
    		t.setTextSize(20);
    		t.setText("Tezinu koju ste uneli je van dozvoljenih granica (Donja granica: 30Kg, Gornja granica: 200Kg)");
    	}
    	else {
    		
    	}
    	
	    
    	
    }


    
}
