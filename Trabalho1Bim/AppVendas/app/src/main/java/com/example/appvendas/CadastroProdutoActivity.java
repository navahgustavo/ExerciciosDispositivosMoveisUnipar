package com.example.appvendas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appvendas.modelo.Cliente;
import com.example.appvendas.modelo.Produto;

import java.util.ArrayList;

public class CadastroProdutoActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText edtDescricaoProduto;
    private EditText edtValorProduto;
    private TextView txvListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        edtDescricaoProduto = findViewById(R.id.edtDescricaoProduto);
        edtValorProduto = findViewById(R.id.edtValorProduto);
        txvListaProdutos = findViewById(R.id.txvListaProdutos);
        btnSalvar = findViewById(R.id.btnSalvarProduto);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarProduto();      
            }
        });

        atualizarLista();
    }

    private void salvarProduto() {
        Double valor;

        if (edtDescricaoProduto.getText().toString().isEmpty()) {
            edtDescricaoProduto.setError("A descrição do produto deve ser informada!");
            return;
        }
        if (edtValorProduto.getText().toString().isEmpty()) {
            edtValorProduto.setError("O valor do produto deve ser informado!");
            return;
        } else {
            valor = Double.parseDouble(edtValorProduto.getText().toString());
            if (valor <= 0) {
                edtValorProduto.setError("O valor do produto não pode ser 0!");
                return;
            }
        }

        Produto produto = new Produto();

        valor = Double.parseDouble(edtValorProduto.getText().toString());
        produto.setDescricao(edtDescricaoProduto.getText().toString());
        produto.setValor(valor);

        Controller.getInstancia().salvarProduto(produto);

        Toast.makeText(CadastroProdutoActivity.this, "Produto cadastrado com sucesso!", Toast.LENGTH_LONG).show();

        finish();
    }

    private void atualizarLista() {
        String texto = "";
        ArrayList<Produto> lista = Controller.getInstancia().retornarProduto();
        for (Produto produto: lista) {
            texto += produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getValor() + "\n";
        }
        txvListaProdutos.setText(texto);
    }
}