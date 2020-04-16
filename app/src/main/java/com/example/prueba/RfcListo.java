package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class RfcListo extends AppCompatActivity {

    TextView rfdresultado3,cuadroedad,zodiaco2,zodchino2,elemntozod2;
    ImageView signozod2;
    String finalrfc , finaledad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rfc_listo);

        rfdresultado3 = findViewById(R.id.rfdresultado3);
        cuadroedad = findViewById(R.id.cuadroedad);
        zodiaco2 = findViewById(R.id.zodiaco2);
        zodchino2 = findViewById(R.id.zodchino2);
        elemntozod2 = findViewById(R.id.elemntozod2);
        signozod2 = findViewById(R.id.signozod2);


        finalrfc = getResources().getString(R.string.rfcresultado);
        finaledad = getResources().getString(R.string.edad2);

        String dd , mm , yyyy , yymmdd , info, edadin;
        int ddi, mmi, yyyyi,zchino;

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        //Toast.makeText(MainActivity.this,"en edad: "+edadold, Toast.LENGTH_LONG).show();

        dd = bundle.getString("dd");
        mm = bundle.getString("mm");
        yyyy = bundle.getString("yyyy");
        yymmdd = bundle.getString("yymmdd");
        info = bundle.getString("info");
        edadin = bundle.getString("edad");
       //Toast.makeText(RfcListo.this,"en edad segunda: "+edadin, Toast.LENGTH_LONG).show();

        ddi = Integer.parseInt(dd);
        mmi = Integer.parseInt(mm);
        yyyyi = Integer.parseInt(yyyy);

        rfdresultado3.setText(finalrfc+" "+info+yymmdd);
        cuadroedad.setText(finaledad+" "+edadin+" "+getResources().getString(R.string.year));

        //zodiaco

        if((mmi == 3 && ddi > 20) || (mmi == 4 && ddi < 21)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.aries));
            signozod2.setImageResource(R.drawable.aries);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.fuego));
        }

        if((mmi == 4 && ddi > 20) || (mmi == 5 && ddi < 21)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.tauro));
            signozod2.setImageResource(R.drawable.tauro);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.tierra));
        }

        if((mmi == 5 && ddi > 20) || (mmi == 6 && ddi < 22)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.geminis));
            signozod2.setImageResource(R.drawable.geminis);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.aire));
        }
        if((mmi == 6 && ddi > 21) || (mmi == 7 && ddi < 23)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.cancer));
            signozod2.setImageResource(R.drawable.cancer);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.agua));
        }
        if((mmi == 7 && ddi > 22) || (mmi == 8 && ddi < 23)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.leo));
            signozod2.setImageResource(R.drawable.leo);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.fuego));
        }
        if((mmi == 8 && ddi > 22) || (mmi == 9 && ddi < 23)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.virgo));
            signozod2.setImageResource(R.drawable.virgo);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.tierra));
        }
        if((mmi == 9 && ddi > 22) || (mmi == 10 && ddi < 22)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.libra));
            signozod2.setImageResource(R.drawable.libra);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.aire));
        }

        if((mmi == 10 && ddi > 21) || (mmi == 11 && ddi < 23)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.escorpio));
            signozod2.setImageResource(R.drawable.escorpion);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.agua));
        }
        if((mmi == 11 && ddi > 22) || (mmi == 12 && ddi < 22)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.sagitario));
            signozod2.setImageResource(R.drawable.sagitario);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.fuego));
        }
        if((mmi == 12 && ddi > 21) || (mmi == 1 && ddi < 21)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.capricornio));
            signozod2.setImageResource(R.drawable.capricornio);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.tierra));
        }
        if((mmi == 1 && ddi > 20) || (mmi == 2 && ddi < 19)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.acuario));
            signozod2.setImageResource(R.drawable.acuario);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.agua));
        }
        if((mmi == 2 && ddi > 18) || (mmi == 3 && ddi < 21)) {
            zodiaco2.setText(getResources().getString(R.string.zodico) + " " + getResources().getString(R.string.piscis));
            signozod2.setImageResource(R.drawable.picis);
            elemntozod2.setText(getResources().getString(R.string.elemento) + " " + getResources().getString(R.string.aire));
        }

        //Zodiacochino

        zchino = (yyyyi % 12) + 1;

        if (zchino == 1) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.mono));
        if (zchino == 2) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.gallo));
        if (zchino == 3) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.perro));
        if (zchino == 4) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.cerdo));
        if (zchino == 5) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.rata));
        if (zchino == 6) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.buey));
        if (zchino == 7) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.tigre));
        if (zchino == 8) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.conejo));
        if (zchino == 9) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.dragon));
        if (zchino == 10) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.serpiente));
        if (zchino == 11) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.caballo));
        if (zchino == 12) zodchino2.setText(getResources().getString(R.string.zodiacochino) + " " + getResources().getString(R.string.cabra));

    }



    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}
