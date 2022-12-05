package com.example.javaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText txtPoids;
    private EditText txtTaille;
    private RadioButton radioM, radioC;
    private Button btnCalculer;
    private Button btnRAZ;
    private TextView txtResultat;

    private int resultatnet;
    private float poids, taille, resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisations();
    }

    public void initialisations(){

        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        radioM = (RadioButton) findViewById(R.id.radiobtnM);
        radioC = (RadioButton) findViewById(R.id.radiobtnC);
        btnCalculer = (Button) findViewById(R.id.btnCalculer);
        btnRAZ = (Button) findViewById(R.id.btnRAZ);
        txtResultat = (TextView) findViewById(R.id.txtResultat);

        btnCalculer.setOnClickListener ( new calculIMC());
        btnRAZ.setOnClickListener(new reinitialiser());
    }

    private class calculIMC implements View.OnClickListener {
        public void onClick(View v){
            poids = Float.parseFloat(txtPoids.getText().toString());
            taille = Float.parseFloat(txtTaille.getText().toString());

            if(radioC.isChecked())
            {
                taille = taille / 100;
            }
            resultat = poids / (taille * taille);
            resultatnet = (int) Math.abs(resultat);
            txtResultat.setText(String.valueOf(resultatnet));
        }
    }

    private class reinitialiser implements  View.OnClickListener{
        public void onClick(View v){
            txtPoids.setText("");
            txtTaille.setText("");
        }
    }
}