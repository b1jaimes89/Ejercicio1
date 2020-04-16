package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton  botonsiguiente;
    EditText cuadronombre,cuadroap,cuadroam,cuadrofecha;
    String anunciomayus,cvacio,fechainvalida,rfcresultado,nombre,apaterno,amaterno,requerido,problema;
    String auxnombre , auxap , auxam , auxdia, auxmes, auxyear;
    String auxfechaadia , auxfechaames = null, auxfechaayear  ;

    private static final String CERO = "0";
    private static final String BARRA = "/";
    public final Calendar c = Calendar.getInstance();
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializacion elementos

        botonsiguiente = findViewById(R.id.botonsiguiente);
        cuadronombre = findViewById(R.id.cuadronombre);
        cuadroap = findViewById(R.id.cuadroapaterno);
        cuadroam = findViewById(R.id.cuadroamaterno);
        cuadrofecha = findViewById(R.id.cuadrofecha);
        anunciomayus = getResources().getString(R.string.anunciomayus);
        cvacio = getResources().getString(R.string.cvacio);
        fechainvalida = getResources().getString(R.string.fechainvalida);
        rfcresultado = getResources().getString(R.string.rfcresultado);
        nombre = getResources().getString(R.string.nombre);
        apaterno = getResources().getString(R.string.apaterno);
        amaterno = getResources().getString(R.string.amaterno);
        requerido = getResources().getString(R.string.requerido);
        problema = getResources().getString(R.string.problema);

        botonsiguiente.setOnClickListener(this);
        cuadrofecha.setOnClickListener(this);

    }

    @Override
    public  void onClick(View v){
        String aux,aux2,edadold,prueba, u= null; //manipular la informacion

        int usudia, usumes, usuyear;
        int actualdia, actualmes, actualyear;

        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = new Date();
        String fechaa = fecha.format(date); //paa validar fecha

        switch (v.getId()){
            case  R.id.cuadrofecha:
                obtenerFecha();
                break;
            case R.id.botonsiguiente:
                try{

                    aux = cuadronombre.getText().toString();
                    if(validarInformacion(aux)){//checamos si el campo nombre esta bien
                        //Toast.makeText(MainActivity.this,fechaa.substring(0,4),Toast.LENGTH_SHORT).show();
                        auxnombre = aux.substring(0,1);

                    }else  {
                        cuadronombre.setError(requerido);
                        Toast.makeText(MainActivity.this,problema,Toast.LENGTH_LONG).show();
                        break;
                    }

                    aux = cuadroap.getText().toString();
                    if(validarInformacion(aux)){//checamos si el campo apellido paterno esta bien
                        //Toast.makeText(MainActivity.this,"estabien",Toast.LENGTH_SHORT).show();
                        auxap = aux.substring(0,1);
                        if (auxap.equals("Ñ")) auxap = "X";
                        for (int j=1;j< aux.length(); j++)
                            if ((aux.charAt(j) == 'A') ||(aux.charAt(j) == 'E') || (aux.charAt(j) == 'I') ||(aux.charAt(j) == 'O') ||(aux.charAt(j) == 'U' )){
                                u = Character.toString(aux.charAt(j));
                                break;
                            }
                         auxap = auxap+u;
                    }else  {
                        cuadroap.setError(requerido);
                        Toast.makeText(MainActivity.this,problema,Toast.LENGTH_LONG).show();
                        break;
                    }

                    aux = cuadroam.getText().toString();
                    if(validarInformacion(aux)){//checamos si el campo apellido materno esta bien
                        //Toast.makeText(MainActivity.this,"estabien",Toast.LENGTH_SHORT).show();
                        auxam = aux.substring(0,1);
                    }else  {
                        cuadroam.setError(requerido);
                        Toast.makeText(MainActivity.this,problema,Toast.LENGTH_LONG).show();
                        break;
                    }

                    //checamos si la fecha esta bien, debe cambiar DD y el año menor al actual
                    //datos usuario
                    auxdia = cuadrofecha.getText().toString().substring(0,2);
                    auxmes = cuadrofecha.getText().toString().substring(3,5);
                    auxyear = cuadrofecha.getText().toString().substring(6,10);

                    aux2 = cuadrofecha.getText().toString().substring(8,10);

                    auxfechaadia = fechaa.substring(0,2);
                    auxfechaames = fechaa.substring(3,5);
                    auxfechaayear= fechaa.substring(6,10);

                    actualdia = Integer.parseInt(auxfechaadia);
                    actualmes = Integer.parseInt(auxfechaames);
                    actualyear = Integer.parseInt(auxfechaayear);

                     usudia = Integer.parseInt(auxdia);
                     usumes = Integer.parseInt(auxmes);
                     usuyear = Integer.parseInt(auxyear);

                    if(usuyear >= actualyear) {
                        cuadrofecha.setError(requerido);
                        Toast.makeText(MainActivity.this,fechainvalida,Toast.LENGTH_LONG).show();
                        break;
                    }


                    edadold = Edad(usudia,usumes,usuyear,actualdia,actualmes,actualyear);
                    //Toast.makeText(MainActivity.this,"en edad: "+edadold,Toast.LENGTH_LONG).show();

                    Bundle bundle = new Bundle();
                    Bundle pruebaa = new Bundle();
                    bundle.putString("dd",auxdia);
                    bundle.putString("mm",auxmes);
                    bundle.putString("yyyy",auxyear);
                    bundle.putString("yymmdd",aux2+auxmes+auxdia);
                    bundle.putString("info",auxap+auxam+auxnombre);
                    bundle.putString("edad",edadold);

                    prueba = bundle.getString("edad");
                   //Toast.makeText(MainActivity.this,"en prueba: "+prueba,Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, RfcListo.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }catch (Exception e){
                    break;
                }
                break;
        }
    }

    private void obtenerFecha() {

        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int mesActual = month + 1;
                String diaFormateado = (dayOfMonth < 10) ? CERO + String.valueOf(dayOfMonth) : String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10) ? CERO + String.valueOf(mesActual) : String.valueOf(mesActual);
                cuadrofecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
            }
        }, anio, mes, dia);
        recogerFecha.show();
    }

    protected boolean validarInformacion(String info){
        boolean vac = true;
        boolean min = true;
        if (info.equals("")) vac = false;
        if (info.matches(".*[^A-Z ].*")) min = false;
        if (vac && min) return true;
        return false;

    }

    private String Edad (int dia1, int mes1, int year1, int dia2, int mes2, int year2){
        int edadf = 0;
        String eda = null;
        if (mes1 == mes2 ){
            if (dia1 >= dia2) {
                edadf = year2 - year1 - 1;
                eda = String.valueOf(edadf);
            }else {
                    edadf = year2 - year1;
                    eda = String.valueOf(edadf);
            }
        }

        if(mes1 > mes2){
                edadf = year2 - year1 - 1 ;
                eda = String.valueOf(edadf);
            }

        if(mes1 < mes2){
            edadf = year2-year1;
            eda = String.valueOf(edadf);
        }
        return  eda;
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
