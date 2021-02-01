package com.example.calcolatrice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Converter extends AppCompatActivity {

    EditText testo;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    Button btnE;
    Button btnF;
    Button btnConverti;
    TextView totale;
    Button btnBase;
    Button btnTo;

    int base=0;
    int baseConversione=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        testo=(EditText)findViewById(R.id.textView);
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnA=(Button)findViewById(R.id.btnA);
        btnB=(Button)findViewById(R.id.btnB);
        btnC=(Button)findViewById(R.id.btnC);
        btnD=(Button)findViewById(R.id.btnD);
        btnE=(Button)findViewById(R.id.btnE);
        btnF=(Button)findViewById(R.id.btnF);
        btnConverti=(Button)findViewById(R.id.btnConverti);
        totale=(TextView)findViewById(R.id.textView2);

        testo.setShowSoftInputOnFocus(false); //nascondo la comparsa automatica del tastierino al click della textview
        testo.setEnabled(false);
        btnBase=(Button) findViewById(R.id.btnBase);
        btnBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sceltaBase();
                testo.setText("");
                btnConverti.setEnabled(true);
                btn0.setEnabled(true);
                btn1.setEnabled(true);
                btnConverti.setEnabled(false);
            }
        });

        btnTo=(Button) findViewById(R.id.btnTo);
        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseTo();
                btnConverti.setEnabled(true);
            }
        });


    }

    public void aggiornaTesto(String s) {
        String ss = testo.getText().toString();
        int posizioneCurosre = testo.getSelectionStart();
        String sx = ss.substring(0, posizioneCurosre);
        String dx = ss.substring(posizioneCurosre);
        if (getString(R.string.scritta).equals(testo.getText().toString())) {
            testo.setText(s);
            testo.setSelection(posizioneCurosre + 1);
        } else {
            testo.setText(String.format("%s%s%s", sx, s, dx));
            testo.setSelection(posizioneCurosre + 1);
        }
    }

    public void BaseTo()
    {
        if(base!=10)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("SELECT MODE:");
            String[] opzioni = {"10"};
            builder.setItems(opzioni, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            baseConversione=10;
                            btnTo.setText("TO: 10");
                            break;
                    }
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("SELECT MODE:");
            String[] opzioni = {"2", "3", "4", "5", "6", "7", "8", "9", "11", "12", "13", "14", "15", "16"};
            builder.setItems(opzioni, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            baseConversione=2;
                            btnTo.setText("TO: 2");
                            break;
                        case 1:
                            baseConversione=3;
                            btnTo.setText("TO: 3");
                            break;
                        case 2:
                            baseConversione=4;
                            btnTo.setText("TO: 4");
                            break;
                        case 3:
                            baseConversione=5;
                            btnTo.setText("TO: 5");
                            break;
                        case 4:
                            baseConversione=6;
                            btnTo.setText("TO: 6");
                            break;
                        case 5:
                            baseConversione=7;
                            btnTo.setText("TO: 7");
                            break;
                        case 6:
                            baseConversione=8;
                            btnTo.setText("TO: 8");
                            break;
                        case 7:
                            baseConversione=9;
                            btnTo.setText("TO: 9");
                            break;
                        case 8:
                            baseConversione=11;
                            btnTo.setText("TO: 11");
                            break;
                        case 9:
                            baseConversione=12;
                            btnTo.setText("TO: 12");
                            break;
                        case 10:
                            baseConversione=13;
                            btnTo.setText("TO: 13");
                            break;
                        case 11:
                            baseConversione=14;
                            btnTo.setText("TO: 14");
                            break;
                        case 12:
                            baseConversione=15;
                            btnTo.setText("TO: 15");
                            break;
                        case 13:
                            baseConversione=16;
                            btnTo.setText("TO: 16");
                            break;
                    }
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
    public void sceltaBase() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SELECT MODE:");
        String[] opzioni = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        builder.setItems(opzioni, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        base=2;
                        btnBase.setText("FROM: 2");
                        btn2.setEnabled(false);
                        btn3.setEnabled(false);
                        btn4.setEnabled(false);
                        btn5.setEnabled(false);
                        btn6.setEnabled(false);
                        btn7.setEnabled(false);
                        btn8.setEnabled(false);
                        btn9.setEnabled(false);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 1:
                        base=3;
                        btnBase.setText("FROM: 3");
                        btn2.setEnabled(true);
                        btn3.setEnabled(false);
                        btn4.setEnabled(false);
                        btn5.setEnabled(false);
                        btn6.setEnabled(false);
                        btn7.setEnabled(false);
                        btn8.setEnabled(false);
                        btn9.setEnabled(false);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 2:
                        base=4;
                        btnBase.setText("FROM: 4");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(false);
                        btn5.setEnabled(false);
                        btn6.setEnabled(false);
                        btn7.setEnabled(false);
                        btn8.setEnabled(false);
                        btn9.setEnabled(false);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 3:
                        base=5;
                        btnBase.setText("FROM: 5");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(false);
                        btn6.setEnabled(false);
                        btn7.setEnabled(false);
                        btn8.setEnabled(false);
                        btn9.setEnabled(false);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 4:
                        base=6;
                        btnBase.setText("FROM: 6");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(false);
                        btn7.setEnabled(false);
                        btn8.setEnabled(false);
                        btn9.setEnabled(false);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 5:
                        base=7;
                        btnBase.setText("FROM: 7");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(false);
                        btn8.setEnabled(false);
                        btn9.setEnabled(false);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 6:
                        base=8;
                        btnBase.setText("FROM: 8");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(false);
                        btn9.setEnabled(false);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 7:
                        base=9;
                        btnBase.setText("FROM: 9");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(true);
                        btn9.setEnabled(false);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 8:
                        base=10;
                        btnBase.setText("FROM: 10");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(true);
                        btn9.setEnabled(true);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 9:
                        base=11;
                        btnBase.setText("FROM: 11");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(true);
                        btn9.setEnabled(true);
                        btnA.setEnabled(true);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 10:
                        base=12;
                        btnBase.setText("FROM: 12");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(true);
                        btn9.setEnabled(true);
                        btnA.setEnabled(true);
                        btnB.setEnabled(true);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 11:
                        base=13;
                        btnBase.setText("FROM: 13");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(true);
                        btn9.setEnabled(true);
                        btnA.setEnabled(true);
                        btnB.setEnabled(true);
                        btnC.setEnabled(true);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 12:
                        base=14;
                        btnBase.setText("FROM: 14");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(true);
                        btn9.setEnabled(true);
                        btnA.setEnabled(true);
                        btnB.setEnabled(true);
                        btnC.setEnabled(true);
                        btnD.setEnabled(true);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        break;
                    case 13:
                        base=15;
                        btnBase.setText("FROM: 15");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(true);
                        btn9.setEnabled(true);
                        btnA.setEnabled(true);
                        btnB.setEnabled(true);
                        btnC.setEnabled(true);
                        btnD.setEnabled(true);
                        btnE.setEnabled(true);
                        btnF.setEnabled(false);
                        break;
                    case 14:
                        base=16;
                        btnBase.setText("FROM: 16");
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                        btn7.setEnabled(true);
                        btn8.setEnabled(true);
                        btn9.setEnabled(true);
                        btnA.setEnabled(true);
                        btnB.setEnabled(true);
                        btnC.setEnabled(true);
                        btnD.setEnabled(true);
                        btnE.setEnabled(true);
                        btnF.setEnabled(true);
                        break;
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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

    public void btnA(View view)
    {
        aggiornaTesto("A");
    }

    public void btnB(View view)
    {
        aggiornaTesto("B");
    }

    public void btnC(View view)
    {
        aggiornaTesto("C");
    }

    public void btnD(View view)
    {
        aggiornaTesto("D");
    }

    public void btnE(View view)
    {
        aggiornaTesto("E");
    }

    public void btnF(View view)
    {
        aggiornaTesto("F");
    }

    public void btnCanc(View view)
    {
        testo.setText("");
    }

    public void bottoneConverti(View view)
    {
        Converti(testo.getText().toString());
    }

    public void btnBackspace(View view)
    {
        int posizioneCursore=testo.getSelectionStart();
        int lunghezzaTesto=testo.getText().length();
        if(posizioneCursore!=0 && lunghezzaTesto!=0)
        {
            SpannableStringBuilder s=(SpannableStringBuilder) testo.getText();
            s.replace(posizioneCursore-1, posizioneCursore, "");
            testo.setText(s);
            testo.setSelection(posizioneCursore-1);
        }
    }

    public void Converti(String t) {
        if(base==10)
        {
            int decimale=Integer.parseInt(t); //Numero da convertire
            int risultato; //Risultato divisione
            int resto;
            String s = new String();
            risultato = decimale;
            do
            {
                resto= risultato%baseConversione;
                risultato= risultato/baseConversione;
                s+=resto;

            }while (risultato != 0);


            String veroRisultato = new String();
            for (int i = s.length()-1; i>=0;i--)
                veroRisultato += s.charAt(i);
            totale.setText(veroRisultato);
        }
        else {
            try {
                char[] ss = t.toCharArray();
                String[] boh = new String[ss.length];
                int[] vet = new int[ss.length];
                int esponente = vet.length - 1;
                for (int i = 0; i < ss.length; i++) {
                    boh[i] = new String(ss[i] + "");
                }
                int risultato = 0;
                for (int j = 0; j < boh.length; j++) {
                    switch (boh[j]) {
                        case "A":
                            vet[j] = 10;
                            break;
                        case "B":
                            vet[j] = 11;
                            break;
                        case "C":
                            vet[j] = 12;
                            break;
                        case "D":
                            vet[j] = 13;
                            break;
                        case "E":
                            vet[j] = 14;
                            break;
                        case "F":
                            vet[j] = 15;
                            break;
                        default:
                            vet[j] = Integer.parseInt(boh[j]);
                            break;
                    }
                }
                for (int k = 0; k < vet.length; k++) {
                    risultato += vet[(k)] * Math.pow(base, esponente);
                    esponente--;
                }
                totale.setText("" + risultato);
            } catch (Exception e) {
                Toast.makeText(Converter.this, "Inserire un valore valido", Toast.LENGTH_LONG).show();
            }
        }
    }

}