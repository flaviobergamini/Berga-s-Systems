package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Contas;
import model.ContasAPagar;
import model.ContasAReceber;
import model.ExtratoBancario;
import model.GestaoCusto;

/**
 * Esta classe faz todo o CRUD com o banco SQL.
 */

/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class BancoDeDados {

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

    /**
     *
     * O método "connectToDb" faz a conexão com o banco de dados SQL
     *
     */
    public void connectToDb() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

    }

    /**
     *
     * O método "geraRelatorio" chama o método Registro que está presente no
     * banco SQL, ela é responsável por inserir os dados do fluxo de caixa na
     * tabela relatório.
     *
     * @param data É a variável responsável para o método Resistro no banco
     * selecionar o fluxo de dados corretamente e inserir na tablema relatório.
     *
     */
    private void geraRelatorio(String data) {
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT Registro('" + data + "') FROM fluxo_de_caixa";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            rs.next();

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
    }

    /**
     *
     * @param fluxo O objeto da classe FluxoCaixa é enviado como argumento para
     * esse método, onde seus atributos são salvos na tabela SQL.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
    public boolean inserirFluxoCaixa(FluxoCaixa fluxo) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO fluxo_de_caixa (credito, debito, nome, data) values (?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, fluxo.getCredito()); //1- refere-se à primeira interrogação
            pst.setFloat(2, fluxo.getDebito());  //2- refere-se à segunda interrogação
            pst.setString(3, fluxo.getNome());  //3- refere-se à segunda interrogação
            pst.setString(4, fluxo.getData());  //4- refere-se à segunda interrogação

            pst.execute();
            sucesso = true;
            geraRelatorio(fluxo.getData());
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
     *
     * @param novaConta O objeto da classe ContasAPagar é enviado como argumento
     * para esse método, onde seus atributos são salvos na tabela SQL.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
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
            pst.setString(4, novaConta.getData());

            pst.execute();
            sucesso = true;
            JOptionPane.showMessageDialog(null, "Cadastro feito Realizado com sucesso!");
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
     *
     * @param novaConta O objeto da classe ContasAReceber é enviado como
     * argumento para esse método, onde seus atributos são salvos na tabela SQL.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
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
            pst.setString(4, novaConta.getData());

            pst.execute();
            sucesso = true;
            JOptionPane.showMessageDialog(null, "Cadastro feito Realizado com sucesso!");
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
     *
     * @param novoRelatorio O objeto da classe Relatorio é enviado como
     * argumento para esse método, onde seus atributos são salvos na tabela SQL.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
    public boolean inserirRelatorio(Relatorio novoRelatorio) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO relatorio (credito, debito, nome, data) values (?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, novoRelatorio.getCredito());
            pst.setFloat(2, novoRelatorio.getDebito());
            pst.setString(3, novoRelatorio.getNome());
            pst.setString(4, novoRelatorio.getData());

            pst.execute();
            sucesso = true;
            JOptionPane.showMessageDialog(null, "Cadastro feito Realizado com sucesso!");
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
     *
     * @param gestao O objeto da classe GestaoCusto é enviado como argumento
     * para esse método, onde seus atributos são salvos na tabela SQL.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
    public boolean inserirGestaoCusto(GestaoCusto gestao) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO gestao_de_custo (nome, valor) values (?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, gestao.getNome());
            pst.setFloat(2, gestao.getValor());

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
     *
     * @param extrato O objeto da classe ExtratoBancario é enviado como
     * argumento para esse método, onde seus atributos são salvos na tabela SQL.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
    public boolean inserirExtrato(ExtratoBancario extrato) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO extrato (nome, valor_de_entrada) values (?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, extrato.getNome());
            pst.setFloat(2, extrato.getEntrada());

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

    /*
     * ********************** ATUALIZAR DADOS ********************************
     */
    /**
     *
     * @param id Ele recebe o ID da linha na tabela, no qual quer se atualizar
     * algum dado em alguma das colunas
     * @param nome Recebe o novo nome para ser atualizado na coluna da tabela do
     * banco de dados
     * @param credito Recebe o novo valor para ser atualizado na tabela do banco
     * de dados
     * @param debito Recebe o novo valor para ser atualizado na tabela do banco
     * de dados
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
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
            }
        }
        return false;
    }

    /**
     *
     * @param id Ele recebe o ID da linha na tabela, no qual quer se atualizar
     * algum dado em alguma das colunas
     * @param nome Recebe o novo nome para ser atualizado na coluna da tabela do
     * banco de dados
     * @param credito Recebe o novo valor para ser atualizado na tabela do banco
     * de dados
     * @param debito Recebe o novo valor para ser atualizado na tabela do banco
     * de dados
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
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
            }
        }
        return false;
    }

    /**
     *
     * @param id Ele recebe o ID da linha na tabela, no qual quer se atualizar
     * algum dado em alguma das colunas
     * @param fornecedor Recebe o novo nome de fornecedor para ser atualizado na
     * coluna da tabela do banco de dados
     * @param contasPagar Recebe o novo valor para ser atualizado na coluna da
     * tabela do banco de dados
     * @param contasPagas Recebe o novo valor para ser atualizado na coluna da
     * tabela do banco de dados
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
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
            }
        }
        return false;
    }

    /**
     *
     * @param id Ele recebe o ID da linha na tabela, no qual quer se atualizar
     * algum dado em alguma das colunas
     * @param cliente Recebe o novo nome do cliente para ser atualizado na
     * coluna da tabela do banco de dados
     * @param contasReceber Recebe o novo valor para ser atualizado na coluna da
     * tabela do banco de dados
     * @param contasRecebidas Recebe o novo valor para ser atualizado na coluna
     * da tabela do banco de dados
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
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

    /**
     *
     * @param id Ele recebe o ID da linha na tabela, no qual quer se atualizar
     * algum dado em alguma das colunas
     * @param nome Recebe o novo nome para ser atualizado na coluna da tabela do
     * banco de dados
     * @param entrada Recebe o novo valor para ser atualizado na coluna da
     * tabela do banco de dados
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
    public boolean atualizarExtrato(int id, String nome, float entrada) {
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
            }
        }
        return sucesso;
    }

    /**
     *
     * @param id Ele recebe o ID da linha na tabela, no qual quer se atualizar
     * algum dado em alguma das colunas
     * @param nome Recebe o novo nome para ser atualizado na coluna da tabela do
     * banco de dados
     * @param valor Recebe o novo valor para ser atualizado na coluna da tabela
     * do banco de dados
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha.
     */
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

    /*
     * ********************** DELETAR REGISTROS ******************************
     */
    /**
     *
     * @param id Ele recebe o ID da linha na tabela no qual quer exlucir.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha
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

    /**
     *
     * @param id Ele recebe o ID da linha na tabela no qual quer exlucir.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha
     */
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

    /**
     *
     * @param id Ele recebe o ID da linha na tabela no qual quer exlucir.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha
     */
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

    /**
     *
     * @param id Ele recebe o ID da linha na tabela no qual quer exlucir.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha
     */
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

    /**
     *
     * @param id Ele recebe o ID da linha na tabela no qual quer exlucir.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha
     */
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

    /**
     *
     * @param id Ele recebe o ID da linha na tabela no qual quer exlucir.
     * @return Este Método retorna verdadeiro "true" quando a comunicação com o
     * banco SQL foi um sucesso, e retorna falso "false" quando existe alguma
     * falha
     */
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

    /*
     * ********************** BUSCAR DADOS ********************************
     */
    /**
     *
     * @param id Ele recebe o ID da linha na tabela no qual quer fazer a busca.
     * @return Este Método retorna um ArrayList de todos os itens de uma linha
     * específica pelo na tabela do banco SQL
     */
    public ArrayList<FluxoCaixa> buscarFluxoDeCaixaID(int id) {
        ArrayList<FluxoCaixa> listaDeFluxo = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM fluxo_de_caixa WHERE ID=" + id;
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                FluxoCaixa fluxo = new FluxoCaixa(rs.getString("nome"), rs.getFloat("credito"), rs.getFloat("debito"), rs.getString("data"));
                listaDeFluxo.add(fluxo);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeFluxo;
    }

    /**
     *
     * @return Este Método retorna um ArrayList de todos os itens da tabela do
     * banco SQL
     */
    public ArrayList<FluxoCaixa> buscarFluxoDeCaixa() {
        ArrayList<FluxoCaixa> listaDeFluxo = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM fluxo_de_caixa";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                FluxoCaixa fluxo = new FluxoCaixa(rs.getString("nome"), rs.getFloat("credito"), rs.getFloat("debito"), rs.getString("data"));
                fluxo.setID(rs.getString("ID"));
                listaDeFluxo.add(fluxo);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeFluxo;
    }

    /**
     *
     * @param id Ele recebe o ID da linha na tabela onde se deseja colher o
     * valor da conta.
     * @param set Recebe o valor 1 para retornar os dados da tabela
     * contas_a_pagar, ou qualquer outro valor diferente de 1 para retornar os
     * dados dados da tabela contas_a_receber.
     * @return De acordo com o valor atribuído ao argumento "set", retorna o
     * valor para uma determinada conta a ser paga ou a ser recebida.
     */
    public float buscaContasAPagarID(int id, int set) {
        connectToDb();
        //Comando em SQL:
        String sql;
        if (set == 1) {
            sql = "SELECT * FROM contas_a_pagar WHERE ID=" + id;
        } else {
            sql = "SELECT * FROM contas_a_receber WHERE ID=" + id;
        }
        float contaP = 0, contaAP;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            rs.next();
            if (set == 1) {
                contaAP = rs.getFloat("contas_a_pagar");
                contaP = rs.getFloat("contas_pagas");
            } else {
                contaAP = rs.getFloat("contas_a_receber");
                contaP = rs.getFloat("contas_recebidas");
            }
            return contaAP;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return -1;
    }

    /**
     *
     * @return Retorna todas as contas a pagar, cuja coluna contas_pagas da
     * tabela do banco SQL é maior que zero
     */
    public ArrayList<ContasAPagar> buscarContasPagas() {
        ArrayList<ContasAPagar> listaDeContasAPagar = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM contas_a_pagar WHERE contas_pagas > 0";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                ContasAPagar conta = new ContasAPagar(rs.getString("fornecedor"), rs.getFloat("contas_a_pagar"), rs.getFloat("contas_pagas"), rs.getString("data"));
                conta.setID(rs.getString("ID"));
                listaDeContasAPagar.add(conta);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeContasAPagar;
    }

    /**
     *
     * @return Retorna todas as contas a pagar, cuja coluna contas_a_pagar da
     * tabela do banco SQL é maior que zero
     */
    public ArrayList<ContasAPagar> buscarContasPagar() {
        ArrayList<ContasAPagar> listaDeContasAPagar = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM contas_a_pagar WHERE contas_a_pagar > 0";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                ContasAPagar conta = new ContasAPagar(rs.getString("fornecedor"), rs.getFloat("contas_a_pagar"), rs.getFloat("contas_pagas"), rs.getString("data"));
                conta.setID(rs.getString("ID"));
                listaDeContasAPagar.add(conta);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeContasAPagar;
    }

    /**
     *
     * @return Retorna todas as informações da tabela contas_a_pagar que estão
     * no banco SQL.
     */
    public ArrayList<ContasAPagar> buscarContasAPagar() {
        ArrayList<ContasAPagar> listaDeContasAPagar = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM contas_a_pagar";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                ContasAPagar conta = new ContasAPagar(rs.getString("fornecedor"), rs.getFloat("contas_a_pagar"), rs.getFloat("contas_pagas"), rs.getString("data"));
                conta.setID(rs.getString("ID"));
                listaDeContasAPagar.add(conta);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeContasAPagar;
    }

    /**
     *
     * @return Retorna todas as contas a receber, cuja coluna contas_recebidas
     * da tabela do banco SQL é maior que zero
     */
    public ArrayList<ContasAReceber> buscarContasRecebidas() {
        ArrayList<ContasAReceber> listaDeContasAReceber = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM contas_a_receber WHERE contas_recebidas > 0";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                ContasAReceber conta = new ContasAReceber(rs.getString("cliente"), rs.getFloat("contas_a_receber"), rs.getFloat("contas_recebidas"), rs.getString("data"));
                conta.setID(rs.getString("ID"));
                listaDeContasAReceber.add(conta);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeContasAReceber;
    }

    /**
     *
     * @return Retorna todas as contas a receber, cuja coluna contas_a_receber
     * da tabela do banco SQL é maior que zero
     */
    public ArrayList<ContasAReceber> buscarContasReceber() {
        ArrayList<ContasAReceber> listaDeContasAReceber = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM contas_a_receber WHERE contas_a_receber > 0";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                ContasAReceber conta = new ContasAReceber(rs.getString("cliente"), rs.getFloat("contas_a_receber"), rs.getFloat("contas_recebidas"), rs.getString("data"));
                conta.setID(rs.getString("ID"));
                listaDeContasAReceber.add(conta);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeContasAReceber;
    }

    /**
     *
     * @return Retorna todas as informações da tabela contas_a_receber que estão
     * no banco SQL.
     */
    public ArrayList<ContasAReceber> buscarContasAReceber() {
        ArrayList<ContasAReceber> listaDeContasAReceber = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM contas_a_receber";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                ContasAReceber conta = new ContasAReceber(rs.getString("cliente"), rs.getFloat("contas_a_receber"), rs.getFloat("contas_recebidas"), rs.getString("data"));
                conta.setID(rs.getString("ID"));
                listaDeContasAReceber.add(conta);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeContasAReceber;
    }

    /**
     *
     * @return Retorna todas as informações da tabela relatorio que estão no
     * banco SQL.
     */
    public ArrayList<Relatorio> buscarRelatorio() {
        ArrayList<Relatorio> listaRelatorios = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM relatorio";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                Relatorio relatorio = new Relatorio(rs.getString("nome"), rs.getFloat("credito"), rs.getFloat("debito"));
                relatorio.setID(rs.getString("ID"));
                listaRelatorios.add(relatorio);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaRelatorios;
    }

    /**
     *
     * @return Retorna todas as informações da tabela gestao_de_custo que estão
     * no banco SQL.
     */
    public ArrayList<GestaoCusto> buscarGestaoDeCusto() {
        ArrayList<GestaoCusto> listaGestao = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM gestao_de_custo";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                GestaoCusto gestao = new GestaoCusto(rs.getString("nome"), rs.getFloat("valor"));
                gestao.setID(rs.getString("ID"));
                listaGestao.add(gestao);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaGestao;
    }

    /**
     *
     * @return Retorna todas as informações da tabela extrato que estão no banco
     * SQL.
     */
    public ArrayList<ExtratoBancario> buscarExtrato() {
        ArrayList<ExtratoBancario> listaExtrato = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM extrato";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            while (rs.next()) {
                ExtratoBancario extrato = new ExtratoBancario(rs.getString("nome"), rs.getFloat("valor_de_entrada"));
                extrato.setID(rs.getString("ID"));
                listaExtrato.add(extrato);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaExtrato;
    }
}
