package com.example.appvendas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appvendas.modelo.Cliente;

import java.util.ArrayList;

public class CadastroClienteActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText edtNomeCliente;
    private EditText edtCpfCliente;
    private TextView txvListaClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        edtNomeCliente = findViewById(R.id.edtNomeCliente);
        edtCpfCliente = findViewById(R.id.edtCpfCliente);
        txvListaClientes = findViewById(R.id.txvListaClientes);
        btnSalvar = findViewById(R.id.btnSalvarCliente);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente();
            }
        });

        atualizarLista();
    }

    private void salvarCliente() {
        if (edtNomeCliente.getText().toString().isEmpty()) {
            edtNomeCliente.setError("O nome do cliente deve ser informado!");
            return;
        }
        if (edtCpfCliente.getText().toString().isEmpty()) {
            edtCpfCliente.setError("O C.P.F. do cliente deve ser informado!");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(edtNomeCliente.getText().toString());
        cliente.setCpf(edtCpfCliente.getText().toString());

        Controller.getInstancia().salvarCliente(cliente);

        Toast.makeText(CadastroClienteActivity.this, "Cliente cadastrado com sucesso!", Toast.LENGTH_LONG).show();

        finish();
    }

    private void atualizarLista() {
        String texto = "";
        ArrayList<Cliente> lista = Controller.getInstancia().retornarClient();
        for (Cliente cliente: lista) {
            texto += cliente.getNome() + " - " + cliente.getCpf() + "\n";
        }
        txvListaClientes.setText(texto);
    }
}