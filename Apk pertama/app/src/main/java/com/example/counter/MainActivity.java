package com.example.counter;


import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String STATE_AKHIR = "state_akhir";
    private final String STATE_LAST_ORIENTATION = "state_last_orientation";

    //pembuatan object component
    TextView tvHasil;
    Button btnCount, btnReset;
    //cara pertama : dengan tipe data primitif; keuntungan lebih sedikit memory digunakan
    int count = 0;
    /*cara kedua :  dengan tipe data reference;
    * Integer count = 0
    * */

    int last_orientation = 1; // 1 for portrait

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // R adalah Object Resource. R akan mencari data sesuai dengan yang ditulis lalu akan ditampilkan sebagai tampilan

        setContentView(R.layout.activity_main); //bind ke layout yang akan pertama kali ditampilkan

        //binding component ke view
        tvHasil = findViewById(R.id.tv_count);
        btnCount = findViewById(R.id.btn_count);
        btnReset = findViewById(R.id.btn_reset);

        /* catatan : listener
        *
        * */
        // cara 1 : setting method yang digunakan ketika btnCount di click. dengan fungsi setOnClick()

                btnCount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        count++;
                        if (count >= 100) {
                            // jika lebih dari 100 maka ubah ukuran font dengan R.dimen yang berada di folder values dan
                            if (last_orientation == Configuration.ORIENTATION_LANDSCAPE) {
                                //orientasinya landscape maka
                                tvHasil.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.ukuran_font_angka_100_lebih));
                            } else {
                                tvHasil.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.ukuran_default_text_tv_count_land));
                            }
                        }

                        //dengan cara pertama
                        tvHasil.setText(String.valueOf(count));
                        //dengan cara kedua
                        //tvHasil.setText(count.toString(count));

                        //untuk menampilkan log / catatan pada logcat
                        //Log.e("ERORRR", String.valueOf(count));

                    }
                });

                btnReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        count = 0;
                        tvHasil.setText(String.valueOf(count));
                        //mengubah ukuran font jika reset di klik
                       // tvHasil.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.ukuran_font_default));

                       // Log.i("Count ", String.valueOf(count));
                    }

                });
                //cek apakah ada state yang disimpan?
                if (savedInstanceState != null) {
                    count = savedInstanceState.getInt(STATE_AKHIR);
//                    last_orientation = savedInstanceState.getInt(STATE_LAST_ORIENTATION);
//                    if (count >= 100){
//                        if (last_orientation == Configuration.ORIENTATION_LANDSCAPE){
//                            tvHasil.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.ukuran_default_text_tv_count_land));
//                        }else{
//                            tvHasil.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.ukuran_font_default));

//                    }else{
//                        if (last_orientation == Configuration.ORIENTATION_LANDSCAPE){
//                            tvHasil.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.ukuran_font_default));
//                        } else {
//                            tvHasil.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.ukuran_default_text_tv_count_land));
//                            //tvHasil.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.ukuran_font_default));
//                        }
//                    }
                    tvHasil.setText(String.valueOf(count));
                }
    }


           // }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //simpan state ketika apk dikembali/ditutup
        outState.putInt(STATE_AKHIR, count);
    }
}

