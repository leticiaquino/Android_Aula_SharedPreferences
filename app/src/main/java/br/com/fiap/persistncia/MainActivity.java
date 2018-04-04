package br.com.fiap.persistncia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        sp = getPreferences(MODE_PRIVATE);

    }

    public void salvar(View view) {
        String nome = this.edtNome.getText().toString();
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("nome", nome);
        edit.commit();
    }

    public void recuperar(View view) {
        String nome = sp.getString("nome", "");
        Toast.makeText(this, nome, Toast.LENGTH_SHORT).show();
    }
}
