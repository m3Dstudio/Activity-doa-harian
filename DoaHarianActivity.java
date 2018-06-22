package com.m3dstudio.playpadanakmuslim;

import android.app.Activity;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoaHarianActivity extends Activity {

    Button doaSebelumMakan, doaSetelahMakan;
    Dialog tampilan;
    Button dengar , kembali ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_harian);

        //kode panggilan dialog
        //sebelum makan
        doaSebelumMakan = findViewById(R.id.bt_sebelummakan);
        doaSebelumMakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TampilanDoa();

            }
        });
        //setelah makan
        doaSetelahMakan = findViewById(R.id.bt_setelahmakan);
        doaSetelahMakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.bt_setelahmakan)
                TampilanDoa2();
            }
        });


    }

    public void TampilanDoa() {
        //sebelum makan
        tampilan = new Dialog(DoaHarianActivity.this);
        tampilan.setContentView(R.layout.layout_doa);

        dengar = tampilan.findViewById(R.id.btdengar);
        kembali = tampilan.findViewById(R.id.btkembali);

        final MediaPlayer
                mp=MediaPlayer.create(this, R.raw.doasebelummakan);
        dengar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                tampilan.cancel();
            }
        });
        tampilan.show();
    }

    public void TampilanDoa2() {
        //setelah makan
        tampilan = new Dialog(DoaHarianActivity.this);
        tampilan.setContentView(R.layout.layout_doa2);

        dengar = tampilan.findViewById(R.id.btdengar);
        kembali = tampilan.findViewById(R.id.btkembali);

        final MediaPlayer
                mp=MediaPlayer.create(this, R.raw.doasetelahmakan);
        dengar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                tampilan.cancel();
            }
        });
        tampilan.show();
    }
}
