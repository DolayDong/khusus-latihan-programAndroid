package com.example.hitungvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LingkaranActivity extends AppCompatActivity {
    private TextView volumeTabung;
    private EditText etTinggiTabung, etRadiusTabung;
    private Button btnHitungVolumeTabung;
    private  final double phi = 3.14;
    private double hasilVolume;
    private final String STATE_AKHIR = "state_akhir";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        volumeTabung = (TextView)findViewById(R.id.tv_volume_Lingkaran);
        etRadiusTabung = (EditText)findViewById(R.id.et_Radius_Tabung);
        etTinggiTabung = (EditText)findViewById(R.id.et_Tinggi_Tabung);
        btnHitungVolumeTabung = (Button)findViewById(R.id.btn_Lingkaran);

        btnHitungVolumeTabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isiTinggiTabung = etTinggiTabung.getText().toString();
                String isiRadiusTabung = etRadiusTabung.getText().toString();

                if (etRadiusTabung.length() == 0){
                    etRadiusTabung.setError("Harap diisi");
                    etRadiusTabung.requestFocus();
                }

                if (etTinggiTabung.length() == 0){
                    etTinggiTabung.setError("Harap diisi");
                    //etTinggiTabung.requestFocus();
                }

                if (etTinggiTabung.length() != 0 && etRadiusTabung.length() != 0){
                    double Radius = Double.parseDouble(isiRadiusTabung);
                    double Tinggi = Double.parseDouble(isiTinggiTabung);

                    hasilVolume = (phi * Radius * Radius) * Tinggi;

                    volumeTabung.setText(String.valueOf(hasilVolume));


                }


            }
        });
        if (savedInstanceState != null){
            hasilVolume = savedInstanceState.getDouble(STATE_AKHIR);
            volumeTabung.setText(String.valueOf(hasilVolume));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(STATE_AKHIR, hasilVolume);
    }
}
