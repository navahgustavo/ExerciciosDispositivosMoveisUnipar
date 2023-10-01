package com.example.appvendas;

import com.example.appvendas.modelo.Cliente;
import com.example.appvendas.modelo.Produto;
import com.example.appvendas.modelo.Pedido;

import java.util.ArrayList;

public class Controller {

    private static Controller instancia;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Produto> listaProdutos;
    private ArrayList<Pedido> listaPedidos;

    public static Controller getInstancia() {
        if (instancia == null) {
            return instancia = new Controller();
        } else {
            return instancia;
        }
    }

    private Controller() {
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();
        listaPedidos = new ArrayList<>();
    }

    public void salvarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> retornarClient(){
        return listaClientes;
    }

    public void salvarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public ArrayList<Produto> retornarProduto(){
        return listaProdutos;
    }
    public void salvarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public ArrayList<Pedido> retornarPedido(){
        return listaPedidos;
    }
}
