package id.sch.smktelkom_mlg.tugas01.xiirpl3011.fodies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Nama, Alamat;
    CheckBox Soto, Rendang, Pecel, Sate, Padang;
    RadioButton Go, Grab, Uber;

    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nama = (EditText) findViewById(R.id.editTextNama);
        Alamat = (EditText) findViewById(R.id.editTextAlamat);

        Soto = (CheckBox) findViewById(R.id.checkBoxSoto);
        Rendang = (CheckBox) findViewById(R.id.checkBoxRendang);
        Pecel = (CheckBox) findViewById(R.id.checkBoxPecel);
        Sate = (CheckBox) findViewById(R.id.checkBoxSate);
        Padang = (CheckBox) findViewById(R.id.checkBoxPadang);

        Go = (RadioButton) findViewById(R.id.radioButtonGo);
        Grab = (RadioButton) findViewById(R.id.radioButtonGrab);
        Uber = (RadioButton) findViewById(R.id.radioButtonUber);

        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doProcess();
            }


        });

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });

    }

    private void doProcess() {

        if (isValid()) {
            String nama = Nama.getText().toString();
            String alamat = Alamat.getText().toString();

            String hasil2 = "";
            if (Soto.isChecked()) hasil2 += Soto.getText() + " , ";
            if (Rendang.isChecked()) hasil2 += Rendang.getText() + " , ";
            if (Pecel.isChecked()) hasil2 += Pecel.getText() + " , ";
            if (Sate.isChecked()) hasil2 += Sate.getText() + " , ";
            if (Padang.isChecked()) hasil2 += Padang.getText() + " , ";

            String hasil = null;
            if (Go.isChecked()) {
                hasil = Go.getText().toString();
            } else if (Grab.isChecked()) {
                hasil = Grab.getText().toString();
            } else if (Uber.isChecked()) {
                hasil = Uber.getText().toString();
            }

            tvHasil.setText(" Nama Pemesan : " + nama + "\n Beralamat di : " + alamat + "\n Memesan : " + hasil2 + "\n Dikirim dengan : " + hasil);
        }


    }

    private boolean isValid() {
        boolean valid = true;

        String nama = Nama.getText().toString();
        String alamat = Alamat.getText().toString();

        if (nama.isEmpty()) {
            Nama.setError("Nama Harus Diisi");
        } else {
            Nama.setError(null);
        }

        if (alamat.isEmpty()) {
            Alamat.setError("Alamat Tidak Boleh Kosong");
        } else {
            Alamat.setError(null);
        }

        return valid;
    }
}
