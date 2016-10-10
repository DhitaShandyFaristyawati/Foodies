package id.sch.smktelkom_mlg.tugas01.xiirpl3011.fodies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Nama;

    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nama = (EditText) findViewById(R.id.editTextNama);

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

            tvHasil.setText(" Nama Pemesan : " + nama);
        }


    }

    private boolean isValid() {
        boolean valid = true;

        String nama = Nama.getText().toString();
        if (nama.isEmpty()) {
            Nama.setError("Nama Harus Diisi");
        } else {
            Nama.setError(null);
        }

        return valid;
    }
}
