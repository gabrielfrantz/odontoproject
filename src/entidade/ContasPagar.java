package entidade;

import java.util.Date;

public class ContasPagar {

    private int id;
    private String fornecedor;
    private String descricao;
    private int cod_fornecedor;
    private Date data_compra;
    private Date data_vencimento;
    private double valor_total;
    private double valor_pago;
    private double valor_atualizado;
    private double valor_total_tela;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public double getValor_atualizado() {
        return valor_atualizado;
    }

    public void setValor_atualizado(double valor_atualizado) {
        this.valor_atualizado = valor_atualizado;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor_total_tela() {
        return valor_total_tela;
    }

    public void setValor_total_tela(double valor_total_tela) {
        this.valor_total_tela = valor_total_tela;
    }

}
