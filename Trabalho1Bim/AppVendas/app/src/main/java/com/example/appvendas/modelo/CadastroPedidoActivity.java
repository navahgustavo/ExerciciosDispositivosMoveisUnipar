package com.example.appvendas.modelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appvendas.Controller;
import com.example.appvendas.R;

import java.util.ArrayList;

public class CadastroPedidoActivity extends AppCompatActivity {

    private TextView txvNumeroPedido;
    private AutoCompleteTextView autoCliente;
    private AutoCompleteTextView autoAdicionarProduto;
    private EditText edtQtdProduto;
    private Button btnAdicionarProduto;
    private TextView txvDescricaoProduto;
    private TextView txvQtdProduto;
    private TextView txvValorProduto;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Produto> listaProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        txvNumeroPedido = findViewById(R.id.txvNumeroPedido);
        autoCliente = findViewById(R.id.autoCliente);
        autoAdicionarProduto = findViewById(R.id.autoAdicionarProduto);
        edtQtdProduto = findViewById(R.id.edtQtdProduto);
        btnAdicionarProduto = findViewById(R.id.btnAdicionarProduto);
        txvDescricaoProduto = findViewById(R.id.txvDescricaoProduto);
        txvQtdProduto = findViewById(R.id.txvQtdProduto);
        txvValorProduto = findViewById(R.id.txvValorProduto);

        numPedidoAutomatico();
        carregarClientes();
        carregaProdutos();
    }

    private void carregarClientes() {
        listaClientes = Controller.getInstancia().retornarClient();
        String[] vetClientes = new String[listaClientes.size()];
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            vetClientes[i] = cliente.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(CadastroPedidoActivity.this, android.R.layout.simple_dropdown_item_1line, vetClientes);

        autoCliente.setAdapter(adapter);
    }

    private void carregaProdutos() {
        listaProdutos = Controller.getInstancia().retornarProduto();
        String[] vetProdutos = new String[listaProdutos.size()];
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto produto = listaProdutos.get(i);
            vetProdutos[i] = produto.getDescricao() + " - R$ " + produto.getValor();
        }
        ArrayAdapter adapter = new ArrayAdapter(CadastroPedidoActivity.this, android.R.layout.simple_dropdown_item_1line, vetProdutos);

        autoAdicionarProduto.setAdapter(adapter);
    }

    private void numPedidoAutomatico(){
        ArrayList<Pedido> lista = Controller.getInstancia().retornarPedido();
        String numPedido = String.valueOf(lista.size() + 1);

        txvNumeroPedido.setText(numPedido);
    }
}