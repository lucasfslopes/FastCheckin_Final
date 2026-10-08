package modelo;

import java.time.LocalDate;

public class Cadastro {
        
    private int idCad;
    private String nomeCad;
    private int genero;
    private String cpf;
    private LocalDate dataNasc;
    private String email;
    private String telefone;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int preferencia;
    private int motivo;
    private double limiteCredito;
    
    //Construtor
    public Cadastro() {
    }
    
    public Cadastro(String nome, int genero, String cpf, LocalDate dataNasc, String email, String telefone, String cep, String endereco, String numero, String complemento, String bairro, String cidade, int preferencia, int motivo, double limite_credito, String estado) {
        this.nomeCad = nome;
        this.genero = genero;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.preferencia = preferencia;
        this.motivo = motivo;
        this.limiteCredito = limite_credito;       
    }
    
    public Cadastro(int id, String nome, int genero, String cpf, LocalDate dataNasc, String email, String telefone, String cep, String endereco, String numero, String complemento, String bairro, String cidade, int preferencia, int motivo, double limite_credito, String estado) {
        this.idCad = id;
        this.nomeCad = nome;
        this.genero = genero;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.preferencia = preferencia;
        this.motivo = motivo;
        this.limiteCredito = limite_credito;       
    }
    
   //Metodos GETs e SETs 
   public int getIdCad() {
        return idCad;
    }
   //Metodo com parâmetro e sem retorno
    public void setIdCad(int idCad) {
        this.idCad = idCad;
    }

    public String getNomeCad() {
        return nomeCad;
    }

    public void setNomeCad(String nomeCad) {
        this.nomeCad = nomeCad;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    public int getGenero(){
        return genero;
    }
    
    public void setGenero(int genero){
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(int preferencia) {
        this.preferencia = preferencia;
    }
    
    public int getMotivo() {
        return motivo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }
    
    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}
