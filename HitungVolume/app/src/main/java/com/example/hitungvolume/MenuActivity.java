package com.example.hitungvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button btnPrisma, btnLingkaran;
    // intent , adalah sebuah class yang bisa digunakan untuk pindah halaman.
    Intent pindahHalamanPrisma, pindahHalamanLingkaran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnPrisma = (Button)findViewById(R.id.btn_Prisma);
        btnLingkaran = (Button)findViewById(R.id.btn_Lingkaran);

        btnPrisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pindahHalamanPrisma = new Intent(MenuActivity.this, PrismaActivity.class);
                startActivity(pindahHalamanPrisma);
            }
        });

        btnLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pindahHalamanLingkaran = new Intent(MenuActivity.this, LingkaranActivity.class);
                startActivity(pindahHalamanLingkaran);
            }
        });

    }


}
