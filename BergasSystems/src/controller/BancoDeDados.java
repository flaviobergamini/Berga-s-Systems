/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Contas;
import model.ContasAPagar;
import model.ContasAReceber;
import model.ExtratoBancario;
import model.GestaoCusto;

/**
 *
 * @author fhmbe
 */
public class BancoDeDados {
     /***************** CONEXÃO COM O BANCO DE DADOS ************************/

    // objeto responsável pela conexão com o servidor do banco de dados
    Connection con;
    // objeto responsável por preparar as consultas dinâmicas
    PreparedStatement pst;
    // objeto responsável por executar as consultas estáticas
    Statement st;
    // objeto responsável por referenciar a tabela resultante da busca
    ResultSet rs;

    // NOME DO BANCO DE DADOS
    String database = "financeiro";
    // URL: VERIFICAR QUAL A PORTA
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    // USUÁRIO
    String user = "root";
    // SENHA
    String password = "/MS-DOSV.6.22";

    boolean sucesso = false;
    
    // Conectar ao banco de dados
    public void connectToDb() 
    {
        try 
        {  
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso!");
        } 
        catch (SQLException ex) 
        {
             System.out.println("Erro: " + ex.getMessage());
        }
                
    }
    
     
    /************************ INSERIR DADOS
     * @param novaConta *********************************/
    public boolean inserirContasAPagar(ContasAPagar novaConta) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO contas_a_pagar (fornecedor, contas_a_pagar, contas_pagas, data) values (?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, novaConta.getNome()); //1- refere-se à primeira interrogação
            pst.setFloat(2, novaConta.getContasPagar());  //2- refere-se à segunda interrogação
            pst.setFloat(3, novaConta.getContasPagas());  //3- refere-se à segunda interrogação
            pst.setString(4, "19/05/2020");
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean inserirContasAReceber(ContasAReceber novaConta) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO contas_a_receber (cliente, contas_a_receber, contas_recebidas, data) values (?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, novaConta.getNome()); //1- refere-se à primeira interrogação
            pst.setFloat(2, novaConta.getContasReceber());  //2- refere-se à segunda interrogação
            pst.setFloat(3, novaConta.getContasRecebidas());  //3- refere-se à segunda interrogação
            pst.setString(4, "19/05/2020");
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean inserirRelatorio(Relatorio novoRelatorio) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO relatorio (credito, debito, nome, data) values (?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try 
        {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, novoRelatorio.getCredito());
            pst.setFloat(2, novoRelatorio.getDebito());
            pst.setString(3, novoRelatorio.getNome()); //1- refere-se à primeira interrogação
            pst.setString(4, novoRelatorio.getData());
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean inserirGestaoCusto(GestaoCusto gestao) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO gestao_de_custo (nome, valor) values (?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, gestao.getNome());
            pst.setFloat(2, gestao.getValor());
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean inserirExtrato(ExtratoBancario extrato) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO gestao_de_custo (nome, valor_de_entrada, valor_de_saida) values (?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try 
        {
            pst = con.prepareStatement(sql);
           pst.setString(1, extrato.getNome());
           pst.setFloat(2, extrato.getEntrada());
           pst.setFloat(3, extrato.getSaida());
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    /************************ ATUALIZAR DADOS *********************************/
    public boolean atualizarNomeUsuario(int id, String novoNome) 
    {
        connectToDb();
        //Comando em SQL
        String sql = "UPDATE usuario SET nome=? WHERE id=?";
        
         //O comando recebe paramêtros -> consulta dinâmica (pst)
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoNome);
            pst.setInt(2, id);
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }

        }
        return sucesso;
    }
    
    /************************ DELETAR REGISTROS *******************************/
    public boolean deletarUsuario(int id) 
    {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM usuario WHERE id=?";
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    /************************ BUSCAR DADOS *********************************/ /*
    public ArrayList<Usuario> buscarUsuariosSemFiltro() 
    {
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM usuario";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de usuarios: ");
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                Usuario usuarioTemp = new Usuario(rs.getString("nome"),rs.getString("cpf"));
                System.out.println("Nome = "+usuarioTemp.getNome());
                System.out.println("CPF = "+usuarioTemp.getCpf());
                System.out.println("---------------------------------");
                listaDeUsuarios.add(usuarioTemp);
            }
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeUsuarios;
    }
    */
}
