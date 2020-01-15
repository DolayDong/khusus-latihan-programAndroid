package com.example.hitungvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class PrismaActivity extends AppCompatActivity {
    private TextView tvHasil;
    private EditText etLebar, etPanjang, etTinggi;
    private Button btnHitung;
    private final String STATE_AKHIR = "state_akhir";
    private double hasilPerhitungan;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etLebar = (EditText)findViewById(R.id.et_Lebar);
        etPanjang = (EditText)findViewById(R.id.et_Panjang);
        etTinggi = (EditText)findViewById(R.id.et_Tinggi);
        tvHasil = (TextView) findViewById(R.id.tv_Hasil);
        btnHitung = (Button) findViewById(R.id.btn_Hitung);


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isiPanjang = etPanjang.getText().toString();
                String isiLebar = etLebar.getText().toString();
                String isiTinggi = etTinggi.getText().toString();

                boolean kosong = false;
                if (isiTinggi.length() == 0 ){
                    etTinggi.setError("Harap diisi");
                    //etTinggi.requestFocus();
                    kosong = true;
                }

                if(isiPanjang.length() == 0){
                    etPanjang.setError("Harap diisi");
                    etPanjang.requestFocus();
                    kosong = true;
                }

                if(isiLebar.length() == 0){
                    etLebar.setError("Harap diisi");
                    //etLebar.requestFocus();
                    kosong = true;
                }

                if (!kosong) {
                    double panjang = Double.parseDouble(isiPanjang);
                    double lebar = Double.parseDouble(isiLebar);
                    double tinggi = Double.parseDouble(isiTinggi);

                    hasilPerhitungan = (panjang * lebar * tinggi) / 2;

                    tvHasil.setText(String.valueOf(hasilPerhitungan));
                }

            }



        });

        if (savedInstanceState != null){
            hasilPerhitungan = savedInstanceState.getDouble(STATE_AKHIR);
            tvHasil.setText(String.valueOf(hasilPerhitungan));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(STATE_AKHIR, hasilPerhitungan);
    }
}
