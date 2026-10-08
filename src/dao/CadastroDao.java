package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.Cadastro;


public class CadastroDao implements DaoGenerica<Cadastro>{

    private ConexaoBanco conexao;
    
    public CadastroDao()
    {
        this.conexao = new ConexaoBanco();
    }
    
    @Override
    public void inserir(Cadastro cadastro) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO hospede (nome, id_genero, cpf, data_nasc, email, telefone, cep, endereco, numero, complemento, bairro, cidade, id_preferencia, id_motivo, limite_credito, estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //subtitui as interrograções da consulta, pelo valor específico
                sentenca.setString(1,cadastro.getNomeCad()); //subsitui a primeira ocorrência da interrogação pelo atributo nome
                sentenca.setInt(2,cadastro.getGenero());
                sentenca.setString(3,cadastro.getCpf());
                sentenca.setDate(4, java.sql.Date.valueOf(cadastro.getDataNasc()));
                sentenca.setString(5,cadastro.getEmail());
                sentenca.setString(6,cadastro.getTelefone());
                sentenca.setString(7,cadastro.getCep());
                sentenca.setString(8,cadastro.getEndereco());
                sentenca.setString(9,cadastro.getNumero());
                sentenca.setString(10,cadastro.getComplemento());
                sentenca.setString(11,cadastro.getBairro());
                sentenca.setString(12,cadastro.getCidade());
                sentenca.setInt(13,cadastro.getPreferencia());
                sentenca.setInt(14,cadastro.getMotivo());
                sentenca.setDouble(15,cadastro.getLimiteCredito());
                sentenca.setString(16,cadastro.getEstado());
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
/*
    @Override
    public void alterar(Cadastro cadastro) {
        String sql = "UPDATE cadbasico SET nomecad = ?, cpf = ?, sexo = ?, email = ? where idcad = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,cadastro.getNomeCad()); //subsitui a primeira ocorrência da interrogação pelo atributo nome
                sentenca.setString(2,cadastro.getGenero());
                sentenca.setString(3,cadastro.getCpf());
                sentenca.setString(4,cadastro.getDataNasc());
                sentenca.setString(5,cadastro.getEmail());
                sentenca.setString(6,cadastro.getTelefone());
                sentenca.setString(7,cadastro.getCep());
                sentenca.setString(8,cadastro.getEndereco());
                sentenca.setString(9,cadastro.getNumero());
                sentenca.setString(10,cadastro.getComplemento());
                sentenca.setString(11,cadastro.getBairro());
                sentenca.setString(12,cadastro.getCidade());
                sentenca.setString(13,cadastro.getPreferencia());
                sentenca.setString(14,cadastro.getMotivo());
                sentenca.setString(15,cadastro.getLimiteCredito());
                sentenca.setString(16,cadastro.getEstado());
                sentenca.setInt(17, cadastro.getIdCad());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir() {
        String sql = "DELETE FROM ESCOLA";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
   
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
    public void excluirID(int id) {
        String sql = "DELETE FROM cadbasico WHERE idcad = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1, id);
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    

    @Override
    public ArrayList<Cadastro> consultar() {
        
        ArrayList<Cadastro> listaCadastros = new ArrayList<Cadastro>();
        String sql = "SELECT c.idcad, c.nomecad, c.cpf, c.email, s.nomesexo "+
                     "FROM cadbasico as c "+
                     "LEFT JOIN cadsexo AS s ON (s.idsexo = c.idsexo) "+  
                     "ORDER BY c.idcad ";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Cadastro cadastro = new Cadastro();
                    cadastro.setIdCad(resultadoSentenca.getInt("idcad"));
                    cadastro.setNomeCad(resultadoSentenca.getString("nomecad"));
                    cadastro.setCpf(resultadoSentenca.getString("cpf"));
                    cadastro.SetSexo(resultadoSentenca.getString("nomesexo"));
                    cadastro.setEmail(resultadoSentenca.getString("email"));
                    
                    listaCadastros.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaCadastros;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    public ArrayList<Cadastro> consultar(String str) {
        
        ArrayList<Cadastro> listaCadastrosStr = new ArrayList<Cadastro>();
        String sql = "SELECT c.idcad, c.nomecad, c.cpf, c.email, s.nomesexo "+
                     "FROM cadbasico as c "+
                     "LEFT JOIN cadsexo AS s ON (s.idsexo = c.idsexo) "+
                     "WHERE ( UPPER(c.nomecad like UPPER(?))) "+   
                     "ORDER BY s.nomesexo ";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                sentenca.setString(1, "%"+str+"%");
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Cadastro cadastro = new Cadastro();
                    cadastro.setIdCad(resultadoSentenca.getInt("idcad"));
                    cadastro.setNomeCad(resultadoSentenca.getString("nomecad"));
                    cadastro.setCpf(resultadoSentenca.getString("cpf"));
                    cadastro.SetSexo(resultadoSentenca.getString("nomesexo"));
                    cadastro.setEmail(resultadoSentenca.getString("email"));
                    
                    listaCadastrosStr.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaCadastrosStr;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    public ArrayList<Cadastro> dashboard() {
        
        ArrayList<Cadastro> ListarDashBoard = new ArrayList<Cadastro>();
//        String sql = "select count(idcad) as numcad, count(idcad)*2 as sumcad, (select count(idsexo)+100 from cadsexo) as numsexualidade from cadbasico;";
        String sql = "SELECT FLOOR( RAND( ) * ( 10 -5 +1 ) *10 ) AS numcad, FLOOR( RAND( ) * ( 10 -5 +1 ) *10 ) AS sumcad, FLOOR( RAND( ) * ( 10 -5 +1 ) *10 ) AS numsexualidade";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                 ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Cadastro cadastro = new Cadastro();
                    cadastro.setTotalCadastros(resultadoSentenca.getInt("numcad"));
                    cadastro.SetSomaCodigos(resultadoSentenca.getInt("sumcad"));
                    cadastro.SetNumSexualidade(resultadoSentenca.getInt("numsexualidade"));
                    
                    ListarDashBoard.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return ListarDashBoard;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    */
}
