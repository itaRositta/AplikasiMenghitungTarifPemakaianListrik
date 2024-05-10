package com.example.aplikasipenjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.KeyStore;

public class MainActivity extends AppCompatActivity {

    private EditText editnamapel,editnamaminuman,editjumlahminuman,editharga,edituangbay;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;
    private TextView textnamapel;
    private TextView textnamaminuman;
    private TextView textjumlahminuman;
    private TextView textharga;
    private TextView textuangbay;
    private TextView textbonus;
    private TextView texttotalbelanja;
    private TextView textkembali;
    private TextView textketerangan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Teman Hidup");
        editnamapel = (EditText) findViewById(R.id.nama_pelanggan);
        editnamaminuman = (EditText) findViewById(R.id.nama_minuman);
        editjumlahminuman = (EditText) findViewById(R.id.jml_minuman);
        editharga = (EditText) findViewById(R.id.harga_minuman);
        edituangbay = (EditText) findViewById(R.id.jml_uang);

        btnproses = (Button) findViewById(R.id.proses);
        btnhapus = (Button) findViewById(R.id.reset);
        btnexit =(Button) findViewById(R.id.exit);

        textnamapel = (TextView) findViewById(R.id.nama_pelanggan);
        textnamaminuman = (TextView)  findViewById(R.id.nama_minuman);
        textjumlahminuman = (TextView) findViewById(R.id.jml_minuman);
        textharga = (TextView) findViewById(R.id.harga_minuman);
        textuangbay = (TextView) findViewById(R.id.jml_uang);
        texttotalbelanja = (TextView) findViewById(R.id.total);
        textkembali = (TextView) findViewById(R.id.kembalian);
        textbonus = (TextView)  findViewById(R.id.bonus);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String totalBelanjaStr = texttotalbelanja.getText().toString();


                String namapelanggan = editnamapel.getText().toString().trim();
                String namabarang = editnamaminuman.getText().toString().trim();
                String jumlahbarang = editjumlahminuman.getText().toString().trim();
                String hargabarang = editharga.getText().toString().trim();
                String uangbayarStr = edituangbay.getText().toString().trim();

                double uangbayar = Double.valueOf(uangbayarStr);
                double jmlbrg= Double.valueOf(jumlahbarang);
                double hrgbrg= Double.valueOf(hargabarang);
                double totalBelanja =jmlbrg*hrgbrg;
                double kembalian =uangbayar-totalBelanja;

                texttotalbelanja.setText("Total Belanja : "+totalBelanja);


                if (totalBelanja >=20000) {
                    textbonus.setText("Bonus : Choklat Silverqueen (S)");
                }
                else if (totalBelanja >=50000){
                    textbonus.setText("Bonus : King Mangga (M)");
                }
                else if (totalBelanja>=60000) {
                    textbonus.setText("Bonus : Red Valvet (XL)");
                }
                else {
                    textbonus.setText("Bonus : Tidak Ada Bonus");
                }

                textkembali.setText("uang kembalian"+kembalian);


            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnamapel.setText(" ");
                textnamaminuman.setText(" ");
                textjumlahminuman.setText(" ");
                textharga.setText(" ");
                textkembali.setText(" ");
                textketerangan.setText(" ");
                textbonus.setText(" ");
                texttotalbelanja.setText(" ");

                Toast.makeText(getApplicationContext(),"Data sudah dihapus",Toast.LENGTH_LONG).show();
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);

            }
        });
    }
}