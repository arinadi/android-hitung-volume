package com.dicoding.barvolume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String STATE_HASIL = "hasil_hitung";
    private EditText inputLebar, inputTinggi, inputPanjang;
    private Button btnHitung;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputLebar = (EditText)findViewById(R.id.lebar);
        inputTinggi = (EditText)findViewById(R.id.tinggi);
        inputPanjang = (EditText)findViewById(R.id.panjang);
        btnHitung = (Button)findViewById(R.id.hitung);
        txtHasil = (TextView)findViewById(R.id.hasil);
        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            txtHasil.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.hitung){
            String panjang = inputPanjang.getText().toString().trim();
            String lebar = inputLebar.getText().toString().trim();
            String tinggi = inputTinggi.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(panjang)){
                isEmptyFields = true;
                inputPanjang.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(lebar)){
                isEmptyFields = true;
                inputLebar.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tinggi)){
                isEmptyFields = true;
                inputTinggi.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);
                double t = Double.parseDouble(tinggi);
                double volume = p * l * t;
                txtHasil.setText(String.valueOf(volume));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, txtHasil.getText().toString());
        super.onSaveInstanceState(outState);
    }
}