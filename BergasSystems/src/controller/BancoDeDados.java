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

    /**
     * *************** CONEXÃO COM O BANCO DE DADOS ***********************
     */
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
    public void connectToDb() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

    }

    /**
     * ********************** INSERIR DADOS
     *
     * @param fluxo
     */
    public boolean inserirFluxoCaixa(FluxoCaixa fluxo) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO fluxo_de_caixa (credito, debito, nome) values (?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, fluxo.getCredito()); //1- refere-se à primeira interrogação
            pst.setFloat(2, fluxo.getDebito());  //2- refere-se à segunda interrogação
            pst.setString(3, fluxo.getNome());  //3- refere-se à segunda interrogação
            //e assim por diante....
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {   //Encerra a conexão
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean inserirContasAPagar(ContasAPagar novaConta) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO contas_a_pagar (fornecedor, contas_a_pagar, contas_pagas, data) values (?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novaConta.getNome()); //1- refere-se à primeira interrogação
            pst.setFloat(2, novaConta.getContasPagar());  //2- refere-se à segunda interrogação
            pst.setFloat(3, novaConta.getContasPagas());  //3- refere-se à segunda interrogação
            pst.setString(4, "19/05/2020");
            //e assim por diante....
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {   //Encerra a conexão
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    public boolean inserirContasAReceber(ContasAReceber novaConta) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO contas_a_receber (cliente, contas_a_receber, contas_recebidas, data) values (?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novaConta.getNome()); //1- refere-se à primeira interrogação
            pst.setFloat(2, novaConta.getContasReceber());  //2- refere-se à segunda interrogação
            pst.setFloat(3, novaConta.getContasRecebidas());  //3- refere-se à segunda interrogação
            pst.setString(4, "19/05/2020");
            //e assim por diante....
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {   //Encerra a conexão
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    public boolean inserirRelatorio(Relatorio novoRelatorio) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO relatorio (credito, debito, nome, data) values (?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, novoRelatorio.getCredito());
            pst.setFloat(2, novoRelatorio.getDebito());
            pst.setString(3, novoRelatorio.getNome()); //1- refere-se à primeira interrogação
            pst.setString(4, novoRelatorio.getData());
            //e assim por diante....
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {   //Encerra a conexão
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    public boolean inserirGestaoCusto(GestaoCusto gestao) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO gestao_de_custo (nome, valor) values (?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, gestao.getNome());
            pst.setFloat(2, gestao.getValor());
            //e assim por diante....
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {   //Encerra a conexão
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    public boolean inserirExtrato(ExtratoBancario extrato) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO extrato (nome, valor_de_entrada, valor_de_saida) values (?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, extrato.getNome());
            pst.setFloat(2, extrato.getEntrada());
            pst.setFloat(3, extrato.getSaida());
            //e assim por diante....
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {   //Encerra a conexão
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    /**
     * ********************** ATUALIZAR DADOS ********************************
     */
    
    public boolean atualizarfluxo(int id, String nome, float credito, float debito) {
        for (int i = 0; i < 4; i++) {
            if (nome.length() > 0) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE fluxo_de_caixa SET nome=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, nome);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                nome = "";
                //return sucesso;
            } else if (credito > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE fluxo_de_caixa SET credito=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, credito);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                credito = -1;
               // return sucesso;
            } else if (debito > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE fluxo_de_caixa SET debito=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, debito);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                debito = -1;
                //return sucesso;
            }
        }
        return false;
    }
    
    public boolean atualizarRelatorio(int id, String nome, float credito, float debito) {
        for (int i = 0; i < 4; i++) {
            if (nome.length() > 0) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE relatorio SET nome=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, nome);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                nome = "";
                //return sucesso;
            } else if (credito > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE relatorio SET credito=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, credito);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                credito = -1;
               // return sucesso;
            } else if (debito > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE relatorio SET debito=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, debito);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                debito = -1;
                //return sucesso;
            }
        }
        return false;
    }
    
    public boolean atualizarContasPagar(int id, String fornecedor, float contasPagar, float contasPagas) {
        for (int i = 0; i < 4; i++) {
            if (fornecedor.length() > 0) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE contas_a_pagar SET fornecedor=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, fornecedor);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                fornecedor = "";
                //return sucesso;
            } else if (contasPagar > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE contas_a_pagar SET contas_a_pagar=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, contasPagar);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                contasPagar = -1;
               // return sucesso;
            } else if (contasPagas > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE contas_a_pagar SET contas_pagas=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, contasPagas);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                contasPagas = -1;
                //return sucesso;
            }
        }
        return false;
    }
    
    public boolean atualizarContasReceber(int id, String cliente, float contasReceber, float contasRecebidas) {
        for (int i = 0; i < 4; i++) {
            if (cliente.length() > 0) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE contas_a_receber SET cliente=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, cliente);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                cliente = "";
               
            } else if (contasReceber > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE contas_a_receber SET contas_a_receber=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, contasReceber);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                contasReceber = -1;
                
            } else if (contasRecebidas > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE contas_a_receber SET contas_recebidas=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, contasRecebidas);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                contasRecebidas = -1;
            }
        }
        return false;
    }
    
    public boolean atualizarExtrato(int id, String nome, float entrada, float saida) {
        for (int i = 0; i < 4; i++) {
            if (nome.length() > 0) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE extrato SET nome=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, nome);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                nome = "";
               
            } else if (entrada > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE extrato SET valor_de_entrada=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, entrada);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                entrada = -1;
                
            } else if (saida > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE extrato SET valor_de_saida=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, saida);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                saida = -1;
            }
        }
        return false;
    }
    
    public boolean atualizarGestaoCusto(int id, String nome, float valor) {
        for (int i = 0; i < 3; i++) {
            if (nome.length() > 0) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE gestao_de_custo SET nome=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, nome);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                nome = "";
               
            } else if (valor > -1) {
                connectToDb();
                //Comando em SQL
                String sql = "UPDATE gestao_de_custo SET valor=? WHERE id=?";

                //O comando recebe paramêtros -> consulta dinâmica (pst)
                try {
                    pst = con.prepareStatement(sql);
                    pst.setFloat(1, valor);
                    pst.setInt(2, id);
                    pst.execute();
                    sucesso = true;
                } catch (SQLException ex) {
                    System.out.println("Erro = " + ex.getMessage());
                    sucesso = false;
                } finally {
                    try {
                        con.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro = " + ex.getMessage());
                    }

                }
                valor = -1; 
            } 
        }
        return false;
    }
    
    /**
     * ********************** DELETAR REGISTROS ******************************
     */
    public boolean deletarFluxo(int id) {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM fluxo_de_caixa WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean deletarContaPagar(int id) {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM contas_a_pagar WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean deletarContaReceber(int id) {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM contas_a_receber WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean deletarRelatorio(int id) {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM relatorio WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean deletarGestaoCusto(int id) {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM gestao_de_custo WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean deletarExtrato(int id) {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM extrato WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    /**
     * ********************** BUSCAR DADOS ********************************
     */
    
    public ArrayList<FluxoCaixa> buscarFluxoDeCaixa() 
    {
        ArrayList<FluxoCaixa> listaDeFluxo = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM fluxo_de_caixa";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                FluxoCaixa fluxo = new FluxoCaixa(rs.getString("nome"), rs.getFloat("credito"), rs.getFloat("debito"));
                System.out.println("Nome = " + fluxo.getNome());
                System.out.println("Crédito: " + fluxo.getCredito());
                System.out.println("Débito: " + fluxo.getDebito());
                System.out.println("---------------------------------");
                listaDeFluxo.add(fluxo);
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
        return listaDeFluxo;
    }
    
    public ArrayList<ContasAPagar> buscarContasAPagar() 
    {
        ArrayList<ContasAPagar> listaDeContasAPagar = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM contas_a_pagar";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                ContasAPagar conta = new ContasAPagar(rs.getString("fornecedor"), rs.getFloat("contas_a_pagar"), rs.getFloat("contas_pagas"));
                System.out.println("Nome = " + conta.getNome());
                System.out.println("Contas a Pagar: " + conta.getContasPagar());
                System.out.println("Contas Pagas: " + conta.getContasPagas());
                System.out.println("---------------------------------");
                listaDeContasAPagar.add(conta);
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
        return listaDeContasAPagar;
    }
    
    public ArrayList<ContasAReceber> buscarContasAReceber() 
    {
        ArrayList<ContasAReceber> listaDeContasAReceber = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM contas_a_pagar";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                ContasAReceber conta = new ContasAReceber(rs.getString("cliente"), rs.getFloat("contas_a_receber"), rs.getFloat("contas_a_recebidas"));
                System.out.println("Nome = " + conta.getNome());
                System.out.println("Contas a Receber: " + conta.getContasReceber());
                System.out.println("Contas Recebidas: " + conta.getContasRecebidas());
                System.out.println("---------------------------------");
                listaDeContasAReceber.add(conta);
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
        return listaDeContasAReceber;
    }
    
    public ArrayList<Relatorio> buscarRelatorio() 
    {
        ArrayList<Relatorio> listaRelatorios = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM relatorio";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                Relatorio relatorio = new Relatorio(rs.getString("nome"), rs.getFloat("credito"), rs.getFloat("debito"));
                System.out.println("Nome = " + relatorio.getNome());
                System.out.println("Crédito: " + relatorio.getCredito());
                System.out.println("Débito: " + relatorio.getDebito());
                System.out.println("Data:" + relatorio.getData());
                System.out.println("---------------------------------");
                listaRelatorios.add(relatorio);
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
        return listaRelatorios;
    }
    
    public ArrayList<GestaoCusto> buscarGestaoDeCusto() 
    {
        ArrayList<GestaoCusto> listaGestao = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM gestao_de_custo";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                GestaoCusto gestao = new GestaoCusto(rs.getString("nome"), rs.getFloat("valor"));
                System.out.println("Nome = " + gestao.getNome());
                System.out.println("Valor: " + gestao.getValor());
                System.out.println("---------------------------------");
                listaGestao.add(gestao);
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
        return listaGestao;
    }
    
    public ArrayList<ExtratoBancario> buscarExtrato() 
    {
        ArrayList<ExtratoBancario> listaExtrato = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM extrato";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                ExtratoBancario extrato = new ExtratoBancario(rs.getString("nome"), rs.getFloat("valor_de_entrada"), rs.getFloat("valor_de_saida"));
                System.out.println("Nome = " + extrato.getNome());
                System.out.println("Valor de Entrada: " + extrato.getEntrada());
                System.out.println("Valor de Saída: " + extrato.getSaida());
                System.out.println("---------------------------------");
                listaExtrato.add(extrato);
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
        return listaExtrato;
    }
}
