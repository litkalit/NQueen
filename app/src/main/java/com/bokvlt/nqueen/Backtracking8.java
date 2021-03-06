package com.bokvlt.nqueen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bokvlt.nqueen.nQueenBacktracking8.nQueenBacktracking8;

public class Backtracking8 extends AppCompatActivity {

    nQueenBacktracking8 solver;
    ImageView[] queens;

    ViewGroup.MarginLayoutParams tampil;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backtracking8);

        solver = new nQueenBacktracking8(8);

        inisialisasiKotak();

        Log.w("TAG", solver.getBanyakSolusis()+"");

        TextView txt = (TextView) findViewById(R.id.txtState);

        txt.setText(solver.getBanyakSolusis() + " states");


        Button btn = (Button) findViewById(R.id.btnShow);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tampilkanJawaban();
            }
        });
    }

    void inisialisasiKotak(){
        queens = new ImageView[8];
        queens[0] = (ImageView) findViewById(R.id.queen0);
        queens[1] = (ImageView) findViewById(R.id.queen1);
        queens[2] = (ImageView) findViewById(R.id.queen2);
        queens[3] = (ImageView) findViewById(R.id.queen3);
        queens[4] = (ImageView) findViewById(R.id.queen4);
        queens[5] = (ImageView) findViewById(R.id.queen5);
        queens[6] = (ImageView) findViewById(R.id.queen6);
        queens[7] = (ImageView) findViewById(R.id.queen7);
    }


    void tampilkanJawaban(){
        int index = (int) (Math.random() * solver.getBanyakSolusis());
        int[] pilihSolusi = solver.getSolusis()[index];



        for (int i=0;i<8;i++){
            tampil = (ViewGroup.MarginLayoutParams) queens[i].getLayoutParams();
            DisplayMetrics dm = queens[i].getResources().getDisplayMetrics();
            tampil.setMargins(convertDpToPx(32 * i, dm),convertDpToPx(32 * (pilihSolusi[i]-1),dm),0,0);
            queens[i].setLayoutParams(tampil);

        }
    }


    private int ukuranLayar(){
        int density= getResources().getDisplayMetrics().densityDpi;
        int size =0;
        switch(density) {
            case DisplayMetrics.DENSITY_LOW:
                size = 38;
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                size = 35;
                break;
            case DisplayMetrics.DENSITY_HIGH:
                size = 33;
                break;
        }
        return size;
    }

    private int convertDpToPx(int dp, DisplayMetrics displayMetrics){
        float pxs = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
        return Math.round(pxs);
    }

}
