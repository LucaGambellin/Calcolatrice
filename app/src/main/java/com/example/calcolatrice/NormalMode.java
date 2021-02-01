package com.example.calcolatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class NormalMode extends AppCompatActivity {

    EditText operazione;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode);
        operazione=findViewById(R.id.txtOperazione);
        operazione.setShowSoftInputOnFocus(false); //nascondo la comparsa automatica del tastierino al click della textview
        operazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.scritta).equals(operazione.getText().toString()))
                    operazione.setText("");
            }
        });
    }

    public void aggiornaTesto(String s)
    {
        String ss=operazione.getText().toString();
        int posizioneCurosre=operazione.getSelectionStart();
        String sx=ss.substring(0, posizioneCurosre);
        String dx=ss.substring(posizioneCurosre);
        if(getString(R.string.scritta).equals(operazione.getText().toString())) {
            operazione.setText(s);
            operazione.setSelection(posizioneCurosre + 1);
        }
        else {
            operazione.setText(String.format("%s%s%s", sx, s, dx));
            operazione.setSelection(posizioneCurosre + 1);
        }
    }
    public void btnZero(View view)
    {
        aggiornaTesto("0");
    }

    public void btnOne(View view)
    {
        aggiornaTesto("1");
    }

    public void btnTwo(View view)
    {
        aggiornaTesto("2");
    }

    public void btnThree(View view)
    {
        aggiornaTesto("3");
    }

    public void btnFour(View view)
    {
        aggiornaTesto("4");
    }

    public void btnFive(View view)
    {
        aggiornaTesto("5");
    }

    public void btnSix(View view)
    {
        aggiornaTesto("6");
    }

    public void btnSeven(View view)
    {
        aggiornaTesto("7");
    }

    public void btnEight(View view)
    {
        aggiornaTesto("8");
    }

    public void btnNine(View view)
    {
        aggiornaTesto("9");
    }

    public void btnUguale(View view)
    {
        String calcolo=operazione.getText().toString();
        calcolo=calcolo.replaceAll("÷", "/");
        calcolo=calcolo.replaceAll("x", "*");

        Expression espressione=new Expression((calcolo));
        String risultato=String.valueOf(espressione.calculate());

        operazione.setText(risultato);
        operazione.setSelection(risultato.length());
    }

    public void btnPiu(View view)
    {
        aggiornaTesto("+");
    }

    public void btnMeno(View view)
    {
        aggiornaTesto("-");
    }

    public void btnPer(View view)
    {
        aggiornaTesto("x");
    }

    public void btnDiviso(View view)
    {
        aggiornaTesto("÷");
    }

    public void btnPiuMeno(View view)
    {
        int pos = operazione.getSelectionStart();
        if(!operazione.getText().toString().substring(0, 1).equals("-")) {
            String leftOfCursor = operazione.getText().toString().substring(0, pos);
            String rightOfCursor = operazione.getText().toString().substring(pos);
            operazione.setText("-" + leftOfCursor + rightOfCursor);
            operazione.setSelection(pos + 1);
        }
        else
        {
            int a=operazione.getText().toString().length();
            String x=operazione.getText().toString().substring(1, (a));
            operazione.setText(x);
            operazione.setSelection(operazione.getText().toString().length());
        }
    }

    public void btnCanc(View view)
    {
        operazione.setText("");
    }

    public void btnVirgola(View view)
    {
        aggiornaTesto(".");
    }

    public void btnParentesiAperta(View view)
    {
        aggiornaTesto("(");
    }

    public void btnParentesiChiusa(View view)
    {
        aggiornaTesto(")");
    }

    public void btnEsponente(View view)
    {
        aggiornaTesto("^");
    }

    public void btnBackspace(View view)
    {
        int posizioneCursore=operazione.getSelectionStart();
        int lunghezzaTesto=operazione.getText().length();
        if(posizioneCursore!=0 && lunghezzaTesto!=0)
        {
            SpannableStringBuilder s=(SpannableStringBuilder) operazione.getText();
            s.replace(posizioneCursore-1, posizioneCursore, "");
            operazione.setText(s);
            operazione.setSelection(posizioneCursore-1);
        }
    }
}