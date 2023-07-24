package entidade;

import java.util.Date;

public class ContasReceber {

    private int id;
    private String procedimento;
    private String paciente;
    private int cod_paciente;
    private Date data_emissao;
    private Date data_vencimento;
    private double valor_total;
    private double valor_recebido;
    private double valor_atualizado;
    private double valor_total_tela;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
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

    public double getValor_recebido() {
        return valor_recebido;
    }

    public void setValor_recebido(double valor_recebido) {
        this.valor_recebido = valor_recebido;
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

    public int getCod_paciente() {
        return cod_paciente;
    }

    public void setCod_paciente(int cod_paciente) {
        this.cod_paciente = cod_paciente;
    }

    public double getValor_total_tela() {
        return valor_total_tela;
    }

    public void setValor_total_tela(double valor_total_tela) {
        this.valor_total_tela = valor_total_tela;
    }
}
