
import javax.swing.JOptionPane;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author marif
 */
public class CHECKIN extends javax.swing.JFrame {
    int idCadastros = 1;
    
    public String fazerRequisicaoCep(String buscaCep) {
        try {            
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + buscaCep + "/json/"))
                    .GET() 
                    .header("Accept", "application/json") 
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao realizar requisição: " + e.getMessage();
        }
    }
    
    // Validacao de CPF conforme regra de calculo real
    private boolean isCpfValido(String cpf) {
        int soma = 0, resto;
        
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        resto = 11 - (soma % 11);
        int digito1 = (resto == 10 || resto == 11) ? 0 : resto;
        if (digito1 != Character.getNumericValue(cpf.charAt(9))) return false;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = 11 - (soma % 11);
        int digito2 = (resto == 10 || resto == 11) ? 0 : resto;
        if (digito2 != Character.getNumericValue(cpf.charAt(10))) return false;

        return true;
    }
    
    // Validacao de CEP 
    private boolean isCepValido(String cep) {
        if (cep.length() != 8) {
            return false;
        }

        for (int i = 0; i < cep.length(); i++) {
            if (!Character.isDigit(cep.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isNumberValido(char c) {
        return Character.isDigit(c);
    }

    /**
     * Creates new form CHECKIN
     */
    public CHECKIN() {
        initComponents();
        
        try {
        
        javax.swing.text.MaskFormatter mascaraTelefone = new javax.swing.text.MaskFormatter("(##) #####-####");
        
        mascaraTelefone.setPlaceholderCharacter('_');
        
        telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascaraTelefone));
            } catch (java.text.ParseException e) {
            e.printStackTrace();
            }    
    
        telefone.setForeground(new java.awt.Color(153, 153, 153));
        
        this.setFocusable(true);
        this.requestFocusInWindow();
        nomehospede.setText("Nome do Hóspede");
        nomehospede.setForeground(new java.awt.Color(153, 153, 153));
        email.setText("E-mail");
        email.setForeground(new java.awt.Color(153, 153, 153));
        telefone.setText("Telefone / WhatsApp");
        telefone.setForeground(new java.awt.Color(153, 153, 153));
        data.setForeground(new java.awt.Color(153, 153, 153));
        limiteCredito.setText("Limite de crédito por quarto");
        limiteCredito.setForeground(new java.awt.Color(153, 153, 153));
        
        try {
        javax.swing.text.MaskFormatter mascaraCpf = new javax.swing.text.MaskFormatter("###.###.###-##");
        mascaraCpf.install(cpf);
        } catch (java.text.ParseException e) {
        e.printStackTrace();
        }
    
        cpf.setForeground(new java.awt.Color(153, 153, 153));
        
        try {
        javax.swing.text.MaskFormatter mascaraCep = new javax.swing.text.MaskFormatter("#####-###");
        mascaraCep.install(cep);
        } catch (java.text.ParseException e) {
        e.printStackTrace();
        }
        
        try {
            javax.swing.text.MaskFormatter mascaraData = new javax.swing.text.MaskFormatter("##/##/####");
            mascaraData.install(data);
            mascaraData.setPlaceholderCharacter('_'); 
        } catch (java.text.ParseException e) {      
            e.printStackTrace();
        }
        
        cep.setForeground(new java.awt.Color(153, 153, 153));
        
        endereco.setText("Endereço");
        endereco.setForeground(new java.awt.Color(153, 153, 153));
        numero.setText("Número");
        numero.setForeground(new java.awt.Color(153, 153, 153));
        complemento.setText("Complemento");
        complemento.setForeground(new java.awt.Color(153, 153, 153));
        bairro.setText("Bairro");
        bairro.setForeground(new java.awt.Color(153, 153, 153));
        cidade.setText("Cidade");
        cidade.setForeground(new java.awt.Color(153, 153, 153));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        limiteCredito = new javax.swing.JTextField();
        nomehospede = new javax.swing.JTextField();
        complemento = new javax.swing.JTextField();
        endereco = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        cep = new javax.swing.JFormattedTextField();
        telefone = new javax.swing.JFormattedTextField();
        data = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        motivoviagem = new javax.swing.JComboBox<>();
        preferenciaquarto = new javax.swing.JComboBox<>();
        uf = new javax.swing.JComboBox<>();
        confirmar = new javax.swing.JButton();
        numero = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ICON = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        confirmar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        limiteCredito.setForeground(new java.awt.Color(115, 3, 13));
        limiteCredito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                limiteCreditoFocusGained(evt);
            }
        });
        limiteCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limiteCreditoActionPerformed(evt);
            }
        });
        limiteCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                limiteCreditoKeyPressed(evt);
            }
        });

        nomehospede.setForeground(new java.awt.Color(115, 3, 13));
        nomehospede.setText("Nome do Hóspede");
        nomehospede.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomehospedeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomehospedeFocusLost(evt);
            }
        });
        nomehospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomehospedeActionPerformed(evt);
            }
        });
        nomehospede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomehospedeKeyPressed(evt);
            }
        });

        complemento.setForeground(new java.awt.Color(115, 3, 13));
        complemento.setText("Complemento");
        complemento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                complementoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                complementoFocusLost(evt);
            }
        });
        complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complementoActionPerformed(evt);
            }
        });
        complemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                complementoKeyPressed(evt);
            }
        });

        endereco.setForeground(new java.awt.Color(115, 3, 13));
        endereco.setText("Endereço");
        endereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                enderecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                enderecoFocusLost(evt);
            }
        });
        endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoActionPerformed(evt);
            }
        });
        endereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enderecoKeyPressed(evt);
            }
        });

        cidade.setForeground(new java.awt.Color(115, 3, 13));
        cidade.setText("Cidade");
        cidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cidadeFocusLost(evt);
            }
        });
        cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeActionPerformed(evt);
            }
        });
        cidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cidadeKeyPressed(evt);
            }
        });

        bairro.setForeground(new java.awt.Color(115, 3, 13));
        bairro.setText("Bairro");
        bairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bairroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bairroFocusLost(evt);
            }
        });
        bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroActionPerformed(evt);
            }
        });
        bairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bairroKeyPressed(evt);
            }
        });

        email.setForeground(new java.awt.Color(115, 3, 13));
        email.setText("E-mail");
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
        });

        cep.setForeground(new java.awt.Color(115, 3, 13));
        cep.setText("CEP");
        cep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cepFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cepFocusLost(evt);
            }
        });
        cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cepActionPerformed(evt);
            }
        });
        cep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cepKeyPressed(evt);
            }
        });

        telefone.setForeground(new java.awt.Color(115, 3, 13));
        telefone.setText("Telefone / WhatsApp ");
        telefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefoneFocusLost(evt);
            }
        });
        telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneActionPerformed(evt);
            }
        });
        telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telefoneKeyPressed(evt);
            }
        });

        data.setForeground(new java.awt.Color(115, 3, 13));
        data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        data.setText("Data");
        data.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dataFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dataFocusLost(evt);
            }
        });
        data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataActionPerformed(evt);
            }
        });
        data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataKeyPressed(evt);
            }
        });

        cpf.setForeground(new java.awt.Color(115, 3, 13));
        cpf.setText("CPF");
        cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cpfFocusLost(evt);
            }
        });
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });
        cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpfKeyPressed(evt);
            }
        });

        motivoviagem.setForeground(new java.awt.Color(115, 3, 13));
        motivoviagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lazer", "Trabalho", "Lazer/ Trabalho", "Visita familiar" }));
        motivoviagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivoviagemActionPerformed(evt);
            }
        });
        motivoviagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                motivoviagemKeyPressed(evt);
            }
        });

        preferenciaquarto.setForeground(new java.awt.Color(115, 3, 13));
        preferenciaquarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quarto Single", "Quarto Casal", "Duplo Solteiro" }));
        preferenciaquarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferenciaquartoActionPerformed(evt);
            }
        });
        preferenciaquarto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                preferenciaquartoKeyPressed(evt);
            }
        });

        uf.setForeground(new java.awt.Color(115, 3, 13));
        uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ufActionPerformed(evt);
            }
        });
        uf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ufKeyPressed(evt);
            }
        });

        confirmar.setBackground(new java.awt.Color(115, 3, 13));
        confirmar.setForeground(new java.awt.Color(255, 255, 255));
        confirmar.setText("Confirmar Check-in");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        confirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmarKeyPressed(evt);
            }
        });

        numero.setForeground(new java.awt.Color(115, 3, 13));
        numero.setText("Número");
        numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numeroFocusLost(evt);
            }
        });
        numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroActionPerformed(evt);
            }
        });
        numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(115, 3, 13));

        jLabel1.setFont(new java.awt.Font("HP Simplified", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FAST CHECK-IN");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/reception.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ICON)
                .addGap(244, 244, 244)
                .addComponent(jLabel1)
                .addGap(422, 422, 422))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(115, 3, 13));

        jLabel2.setBackground(new java.awt.Color(115, 3, 13));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SISTEMA - 2026");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(475, 475, 475))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        sexo.setForeground(new java.awt.Color(115, 3, 13));
        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gênero", "Feminino", "Masculino", "Outro" }));
        sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoActionPerformed(evt);
            }
        });
        sexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sexoKeyPressed(evt);
            }
        });

        jLabel4.setText("Nome do hóspede");

        jLabel5.setText("Gênero");

        jLabel6.setText("CPF");

        jLabel7.setText("E-mail");

        jLabel8.setText("Número");

        jLabel9.setText("Telefone");

        jLabel10.setText("CEP");

        jLabel11.setText("Endereço");

        jLabel12.setText("Complemento");

        jLabel13.setText("Bairro");

        jLabel14.setText("Cidade");

        jLabel15.setText("UF");

        jLabel16.setText("Preferência");

        jLabel17.setText("Motivo");

        jLabel18.setText("Check-in");

        jLabel19.setText("Limite de crédito por quarto");

        confirmar1.setBackground(new java.awt.Color(115, 3, 13));
        confirmar1.setForeground(new java.awt.Color(255, 255, 255));
        confirmar1.setText("Teste Conexão Database");
        confirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar1ActionPerformed(evt);
            }
        });
        confirmar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmar1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(preferenciaquarto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(motivoviagem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomehospede, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(limiteCredito))
                                    .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(232, 232, 232)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomehospede, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preferenciaquarto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motivoviagem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limiteCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limiteCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limiteCreditoActionPerformed

    private void nomehospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomehospedeActionPerformed
        sexo.requestFocus();
    }//GEN-LAST:event_nomehospedeActionPerformed

    private void cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepActionPerformed
        endereco.requestFocus();
    }//GEN-LAST:event_cepActionPerformed

    private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneActionPerformed

    private void dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        email.requestFocus();
    }//GEN-LAST:event_cpfActionPerformed

    private void motivoviagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivoviagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motivoviagemActionPerformed

    private void preferenciaquartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferenciaquartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferenciaquartoActionPerformed

    private void ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ufActionPerformed

    private void complementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complementoActionPerformed
        bairro.requestFocus();
    }//GEN-LAST:event_complementoActionPerformed

    private String popUpDadosCadastro(){
        
        String limiteTexto = limiteCredito.getText().trim();


        if (limiteTexto.isEmpty() || limiteTexto.equals("Limite de crédito por quarto")) {
            limiteTexto = "0,00"; 
        }
        
    return "<html>"
            + "<body style='font-family: sans-serif; padding: 5px;'>"
            + "  <h3 style='color: green; margin-bottom: 10px;'>Dados cadastrados com sucesso!</h3>"
            + "  <table border='0' cellpadding='3' cellspacing='0' style='font-size: 12px;'>"
            + "    <tr><td><b>ID:</b></td><td style='padding-left: 10px;'>" + idCadastros + "</td></tr>"
            + "    <tr><td><b>Nome:</b></td><td style='padding-left: 10px;'>" + nomehospede.getText() + "</td></tr>"
            + "    <tr><td><b>Gênero:</b></td><td style='padding-left: 10px;'>" + sexo.getSelectedItem().toString() + "</td></tr>"
            + "    <tr><td><b>Data Nasc.:</b></td><td style='padding-left: 10px;'>" + data.getText() + "</td></tr>"
            + "    <tr><td><b>CPF:</b></td><td style='padding-left: 10px;'>" + cpf.getText() + "</td></tr>"
            + "    <tr><td><b>E-mail:</b></td><td style='padding-left: 10px;'>" + email.getText() + "</td></tr>"
            + "    <tr><td><b>Telefone:</b></td><td style='padding-left: 10px;'>" + telefone.getText() + "</td></tr>"
            + "    <tr><td><b>CEP:</b></td><td style='padding-left: 10px;'>" + cep.getText() + "</td></tr>"
            + "    <tr><td><b>Endereço:</b></td><td style='padding-left: 10px;'>" + endereco.getText() + ", " + numero.getText() + "</td></tr>"
            + "    <tr><td><b>Bairro:</b></td><td style='padding-left: 10px;'>" + bairro.getText() + "</td></tr>"
            + "    <tr><td><b>Cidade/UF:</b></td><td style='padding-left: 10px;'>" + cidade.getText() + "/" + uf.getSelectedItem().toString() + "</td></tr>"            
            + "    <tr><td><b>Tipo de Quarto:</b></td><td style='padding-left: 10px;'>" + preferenciaquarto.getSelectedItem().toString() + "</td></tr>"
            + "    <tr><td><b>Limite de Crédito:</b></td><td style='padding-left: 10px; color: green;'><b>R$ " + limiteTexto + "</b></td></tr>"
            + "  </table>"
            + "</body>"
            + "</html>";
    }
    
    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
       if (nomehospede.getText().trim().isEmpty() || nomehospede.getText().equals("Nome do Hóspede") ||
        cpf.getText().replace(".", "").replace("-", "").trim().isEmpty() ||
        cep.getText().replace("-", "").trim().isEmpty()) {        
        
        JOptionPane.showMessageDialog(this, 
            "Por favor, preencha todos os campos obrigatórios (Nome, CPF e CEP).", 
            "Campos Incompletos", 
            JOptionPane.WARNING_MESSAGE);
        
        return; 
    }
       
        JOptionPane.showMessageDialog(this, popUpDadosCadastro(), "Dados Preenchidos", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_confirmarActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        telefone.requestFocus();
    }//GEN-LAST:event_emailActionPerformed

    private void nomehospedeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomehospedeFocusGained
      
        if (nomehospede.getText().equals("Nome do Hóspede")) {
            nomehospede.setText("");
            nomehospede.setForeground(new java.awt.Color(0, 0, 0)); 
        }
    }//GEN-LAST:event_nomehospedeFocusGained

    private void nomehospedeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomehospedeFocusLost
        if (nomehospede.getText().isEmpty()) {
            nomehospede.setForeground(new java.awt.Color(153, 153, 153));
            nomehospede.setText("Nome do Hóspede");
        }
    }//GEN-LAST:event_nomehospedeFocusLost

    private void sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoActionPerformed

    private void cpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cpfFocusGained
        cpf.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_cpfFocusGained

    private void cpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cpfFocusLost
        String cpfBruto = cpf.getText().replace(".", "").replace("-", "").replace("_", "").trim();
                
        if (cpfBruto.isEmpty() || cpfBruto.equals("CPF")) {
            return;
        }        
        
        if (!cpfBruto.matches("\\d{11}") || cpfBruto.matches("(\\d)\\1{10}")) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Por favor, insira um CPF válido com 11 dígitos!", 
                "CPF Inválido", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
                
            cpf.requestFocus(); 
            return;
        }
        
        if (!isCpfValido(cpfBruto)) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Os dígitos verificadores do CPF são inválidos!", 
                "CPF Inconsistente", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
                
            cpf.requestFocus();
        }
    }//GEN-LAST:event_cpfFocusLost

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        if (email.getText().equals("E-mail")) {
            email.setText("");
            email.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        String textoEmail = email.getText().trim();
                
        if (textoEmail.isEmpty() || textoEmail.equals("E-mail")) {
            email.setText("E-mail");
            email.setForeground(new java.awt.Color(153, 153, 153));
            return; 
        }        
        
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        
        if (!textoEmail.matches(regexEmail)) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Por favor, insira um endereço de e-mail válido!", 
                "E-mail Inválido", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
                
            email.requestFocus(); 
        }
    }//GEN-LAST:event_emailFocusLost

    private void nomehospedeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomehospedeKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {            
            sexo.requestFocus();
        }
    }//GEN-LAST:event_nomehospedeKeyPressed

    private void sexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sexoKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {        
            cpf.requestFocus();
        }
    }//GEN-LAST:event_sexoKeyPressed

    private void cpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            email.requestFocus();
        }
    }//GEN-LAST:event_cpfKeyPressed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            telefone.requestFocus();
        }
    }//GEN-LAST:event_emailKeyPressed

    private void telefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefoneFocusGained
        if (telefone.getText().equals("Telefone / WhatsApp")) {
            telefone.setText("");
            telefone.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_telefoneFocusGained

    private void telefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefoneFocusLost
        String telefoneBruto = telefone.getText().replace("(", "").replace(")", "").replace(" ", "").replace("-", "").replace("_", "").trim();
        
        if (telefoneBruto.isEmpty()) {
            telefone.setForeground(new java.awt.Color(153, 153, 153));
            return;
        }
                
        String regexTelefone = "^\\d{10,11}$";
        
        if (!telefoneBruto.matches(regexTelefone)) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Por favor, insira um número de telefone/celular válido (com DDD)!", 
                "Telefone Incorreto", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
                
            telefone.requestFocus(); 
            return;
        }
        
        telefone.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_telefoneFocusLost

    private void telefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {            
            cep.requestFocus();
        }
    }//GEN-LAST:event_telefoneKeyPressed

    private void enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoActionPerformed
        numero.requestFocus();
    }//GEN-LAST:event_enderecoActionPerformed

    private void numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroActionPerformed
        complemento.requestFocus();
    }//GEN-LAST:event_numeroActionPerformed

    private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
        cidade.requestFocus();
    }//GEN-LAST:event_bairroActionPerformed

    private void cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeActionPerformed
        uf.requestFocus();
    }//GEN-LAST:event_cidadeActionPerformed

    private void cepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cepFocusGained
        cep.setForeground(new java.awt.Color(0, 0, 0));
        cep.selectAll();
    }//GEN-LAST:event_cepFocusGained

    private void enderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enderecoFocusGained
        if (endereco.getText().equals("Endereço")) {
            endereco.setText("");
            endereco.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_enderecoFocusGained

    private void numeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numeroFocusGained
        if (numero.getText().equals("Número")) {
            numero.setText("");
            numero.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_numeroFocusGained

    private void complementoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_complementoFocusGained
        if (complemento.getText().equals("Complemento")) {
            complemento.setText("");
            complemento.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_complementoFocusGained

    private void bairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bairroFocusGained
        if (bairro.getText().equals("Bairro")) {
            bairro.setText("");
            bairro.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_bairroFocusGained

    private void cidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cidadeFocusGained
        if (cidade.getText().equals("Cidade")) {
            cidade.setText("");
            cidade.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_cidadeFocusGained

    private void cepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cepFocusLost
        
        String cepBruto = cep.getText().replace("-", "").trim();

        if (cepBruto.isEmpty() || cepBruto.equals("CEP")) {
            return;
        }

        if (!cepBruto.matches("\\d{8}")) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Por favor, insira um CEP válido com 8 dígitos!",
                "CEP Inválido",
                javax.swing.JOptionPane.WARNING_MESSAGE);

            cep.requestFocus();
            return;
        }
        else {
            String resJSON = fazerRequisicaoCep(cepBruto);
            
            JSONObject obj = new JSONObject(resJSON);
            
            if (obj.has("erro")) {
                JOptionPane.showMessageDialog(this, "CEP não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                
                endereco.setText(obj.getString("logradouro"));
                bairro.setText(obj.getString("bairro"));
                cidade.setText(obj.getString("localidade"));
                uf.setSelectedItem(obj.getString("uf"));
                
                numero.requestFocus();
            }
            
           
        }
    }//GEN-LAST:event_cepFocusLost

    private void enderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enderecoFocusLost
        if (endereco.getText().isEmpty()) {
            endereco.setForeground(new java.awt.Color(153, 153, 153));
            endereco.setText("Endereço");
        }
    }//GEN-LAST:event_enderecoFocusLost

    private void numeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numeroFocusLost
        if (numero.getText().isEmpty()) {
            numero.setForeground(new java.awt.Color(153, 153, 153));
            numero.setText("Número");
        }
    }//GEN-LAST:event_numeroFocusLost

    private void complementoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_complementoFocusLost
        if (complemento.getText().isEmpty()) {
            complemento.setForeground(new java.awt.Color(153, 153, 153));
            complemento.setText("Complemento");
        }
    }//GEN-LAST:event_complementoFocusLost

    private void bairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bairroFocusLost
        if (bairro.getText().isEmpty()) {
            bairro.setForeground(new java.awt.Color(153, 153, 153));
            bairro.setText("Bairro");
        }
    }//GEN-LAST:event_bairroFocusLost

    private void cidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cidadeFocusLost
        if (cidade.getText().isEmpty()) {
            cidade.setForeground(new java.awt.Color(153, 153, 153));
            cidade.setText("Cidade");
        }
    }//GEN-LAST:event_cidadeFocusLost

    private void cepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cepKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {            
            endereco.requestFocus();
        }
    }//GEN-LAST:event_cepKeyPressed

    private void enderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enderecoKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {            
            numero.requestFocus();
        }
    }//GEN-LAST:event_enderecoKeyPressed

    private void numeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {            
            complemento.requestFocus();
        }
    }//GEN-LAST:event_numeroKeyPressed

    private void complementoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_complementoKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {            
            bairro.requestFocus();
        }
    }//GEN-LAST:event_complementoKeyPressed

    private void bairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bairroKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {            
            cidade.requestFocus();
        }
    }//GEN-LAST:event_bairroKeyPressed

    private void cidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cidadeKeyPressed
        if (evt.getExtendedKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {            
            uf.requestFocus();
        }
    }//GEN-LAST:event_cidadeKeyPressed

    private void numeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroKeyTyped
        if (!isNumberValido(evt.getKeyChar())) {
        evt.consume();
    }
    }//GEN-LAST:event_numeroKeyTyped

    private void dataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataKeyPressed
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            limiteCredito.requestFocus();
        }
    }//GEN-LAST:event_dataKeyPressed

    private void limiteCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_limiteCreditoKeyPressed
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            confirmar.requestFocus();
        }
    }//GEN-LAST:event_limiteCreditoKeyPressed

    private void ufKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ufKeyPressed
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            preferenciaquarto.requestFocus();
        }
    }//GEN-LAST:event_ufKeyPressed

    private void preferenciaquartoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preferenciaquartoKeyPressed
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            motivoviagem.requestFocus();
        }
    }//GEN-LAST:event_preferenciaquartoKeyPressed

    private void motivoviagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motivoviagemKeyPressed
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            data.requestFocus();
        }
    }//GEN-LAST:event_motivoviagemKeyPressed

    private void confirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarKeyPressed
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            JOptionPane.showMessageDialog(this, popUpDadosCadastro(), "Dados Preenchidos", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_confirmarKeyPressed

    private void dataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataFocusLost

        String dataDigitada = data.getText().replace(" ", "").trim();

        if (dataDigitada.equals("__/__/____") || dataDigitada.replace("/", "").trim().isEmpty()) {
            return;
        }

        java.time.format.DateTimeFormatter formatador = java.time.format.DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(java.time.format.ResolverStyle.STRICT);

        try {
            java.time.LocalDate.parse(dataDigitada, formatador);

        } catch (java.time.format.DateTimeParseException e) {
            
            javax.swing.JOptionPane.showMessageDialog(this,
                "Data inválida!",
                "Data Inválida",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            
            data.requestFocus();
            data.setText("");
        }
    }//GEN-LAST:event_dataFocusLost

    private void dataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataFocusGained
        data.selectAll();
    }//GEN-LAST:event_dataFocusGained

    private void limiteCreditoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_limiteCreditoFocusGained
        limiteCredito.selectAll();
    }//GEN-LAST:event_limiteCreditoFocusGained

    private void confirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar1ActionPerformed
        try
        {
            new dao.ConexaoBanco().conectar();
            JOptionPane.showMessageDialog(null, "Banco de Dados Conectado!");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!");
        }
    }//GEN-LAST:event_confirmar1ActionPerformed

    private void confirmar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmar1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CHECKIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CHECKIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CHECKIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CHECKIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CHECKIN().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ICON;
    private javax.swing.JTextField bairro;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField complemento;
    private javax.swing.JButton confirmar;
    private javax.swing.JButton confirmar1;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JTextField email;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField limiteCredito;
    private javax.swing.JComboBox<String> motivoviagem;
    private javax.swing.JTextField nomehospede;
    private javax.swing.JTextField numero;
    private javax.swing.JComboBox<String> preferenciaquarto;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JFormattedTextField telefone;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
