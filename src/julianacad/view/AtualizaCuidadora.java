package julianacad.view;
import java.awt.Graphics;
import java.util.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import model.beans.Cuidadora;
import model.dao.CadastroCuidadoraDAO;
//marca
/**
 *
 * @author Augusto Barros
 */
public class AtualizaCuidadora extends javax.swing.JInternalFrame {

    public static int idRefe2;
    public String caminho2;
    
    /**
     * Creates new form CadastroCuidadora
     */
    public AtualizaCuidadora() {
        
        initComponents();
        CadastroCuidadoraDAO re = new CadastroCuidadoraDAO();
        Cuidadora ca = new Cuidadora();
        

        re.consultaCadastro(ca,idRefe2);
        this.setTitle("Alteração no Cadastro de " + ca.getNome());
        
        //id cuidadora
        jTextField3.setText(String.valueOf(ca.getIdCuidadora()));
        
        // nome cuidadora
        jTextField10.setText(ca.getNome());
        
        //Tipo de cuidadora
        if(ca.getTipoCuidadora() == 1){
            jRadioButton3.setSelected(true);
        }else if(ca.getTipoCuidadora() == 2){
            jRadioButton1.setSelected(true);
        }else if(ca.getTipoCuidadora() == 3){
            jRadioButton2.setSelected(true);
        }
       
        //tem mei
        if(ca.getTemMei() == 1){
            btnRadMEI.setSelected(true);
        }
        
        //cnpj
        if(btnRadMEI.isSelected()){
            txtCNPJ.setEnabled(true);
            lblCNPJ.setEnabled(true);
            txtCNPJ.setText(ca.getCnpj());
        }
         
        //RG
        jTextField30.setText(ca.getNumeroRg());
        
        //CPF
        txtFild3.setText(ca.getCpf());
        
        //idade
        txtFild10.setText(ca.getIdade());
        
        String nasc = txtFild10.getText();
        nasc = nasc.substring(6, 10);
        int nascInt = Integer.parseInt(nasc);
        
        //data e conversão para int para calculo
        Date hoje = new Date();
        String data = hoje.toString();
        String ano = data.substring(25, 29);
        int anoInt = Integer.parseInt(ano);
        
        Integer res = anoInt - nascInt;
        
        
        
        jTextField6.setText(res.toString());
        
        //altura
        jTextField2.setText(ca.getAltura());
        
        //peso
        jTextField7.setText(ca.getPeso());
        
        //cor da pele
        jComboBox3.setSelectedIndex(ca.getCorPeleIndex());
        
        //regiao
        jComboBox7.setSelectedIndex(ca.getRegiaoListaIndex());
        
        //estado civil
        jComboBox2.setSelectedIndex(ca.getEstadoCivilIndex());
        
        //filhos
        if(ca.getFilhosSimNao() == 1){
            radFilhoSim.setSelected(true);
            radMenor.setEnabled(true);
            radMaior.setEnabled(true);
        }else if(ca.getFilhosSimNao() == 2){
            radFilhoNao.setSelected(true);
        }
        
        //filhor menor maior e campo menor
        if(ca.getFilhoMaiorMenor() == 2){
            
            radMenor.setSelected(true);
            txtNumFilhos.setEnabled(true);
            txtNumFilhos.setText(ca.getCampoMenor());
        }else if(ca.getFilhoMaiorMenor() == 1){
            radMaior.setSelected(true);
            
        }
        
        //cnh sim nao
        if(ca.getCnhSimNao() == 1){
            jRadioButton4.setSelected(true);
        }else if(ca.getCnhSimNao() == 2){
            jRadioButton5.setSelected(true);
        }
        
        if(ca.getPossuiCarroSimNao() == 1){
            jRadioButton7.setSelected(true);
        }else if(ca.getPossuiCarroSimNao() == 2){
            jRadioButton6.setSelected(true);
        }
        
        //endereco
        jTextField11.setText(ca.getEndereco());
        
                
        //numero
        jTextField8.setText(ca.getNumeroEndereco());
        
        //cep
        txtFild4.setText(ca.getCepEndereco());
        
        //uf index
        jComboBox1.setSelectedIndex(ca.getUfListaIndex());
        
        //Bairro Endere
        jTextField9.setText(ca.getBairroEndereco());
        
        //ciade endere
        jTextField4.setText(ca.getCidade());
        
        //telefone Resi
        txtFild5.setText(ca.getTelefoneResidencialCuidadora());
        
        //Telefone Ce
        txtFild2.setText(ca.getTelefoneCelularCuidadora());
        
        //whats
        if(ca.getWhatsappSimNao() == 1){
            jRadioButton8.setSelected(true);
        }else if(ca.getWhatsappSimNao() == 2){
            jRadioButton9.setSelected(true);
        }
        
        //religiao
        jComboBox5.setSelectedIndex(ca.getReligiaoIndex());
        
        //fumante sim nao
        if(ca.getFumanteSimNao() == 1){
            jRadioButton10.setSelected(true);
        }else if(ca.getFumanteSimNao() == 2){
            jRadioButton11.setSelected(true);
        }
        
        //grau
        jComboBox6.setSelectedIndex(ca.getGrauEscolarIndex());
        
        //campo superior
        jTextField5.setText(ca.getCursoSuperior());
        
        //gosta de animais
        if(ca.getGostaAnimalSimNao() == 1){
            jRadioButton13.setSelected(true);
        }else if(ca.getGostaAnimalSimNao() == 2){
            jRadioButton12.setSelected(true);
        }
        
        //alergias sim nao
        if(ca.getAlergiaSimNao() == 1){
            jRadioButton14.setSelected(true);
            txtAlergia.setEnabled(true);
            txtAlergia.setText(ca.getQualAlergia());
        }else if(ca.getAlergiaSimNao() == 2){
            jRadioButton15.setSelected(true);
        }
        
        //registro Clt
        if(ca.getRegistroCLTSimNao() == 1){
            jRadioButton17.setSelected(true);
        }else if(ca.getRegistroCLTSimNao() == 2){
            jRadioButton16.setSelected(true);
        }
        
        //convenio medico
        if(ca.getConvenioMedicoSimNao() == 1){
            jRadioButton19.setSelected(true);
        }else if(ca.getConvenioMedicoSimNao() == 2){
            jRadioButton18.setSelected(true);
        }
        
        //habilidades
        jTextField15.setText(ca.getHabilidades());
        
        //disponibilidade para viajar
        if(ca.getDisponivelViagemSimNao() == 1){
            jRadioButton21.setSelected(true);
        }else if(ca.getDisponivelViagemSimNao() == 2){
            jRadioButton20.setSelected(true);
        }
        
        //cozinha sim nao
        if(ca.getCozinhaSimNao() == 1){
            jRadioButton23.setSelected(true);
        }else if(ca.getCozinhaSimNao() == 2){
            jRadioButton22.setSelected(true);
        }
        
        //prefere H ou M
        if(ca.getPrefereHouM() == 3){
            jCheckBox1.setSelected(true);
            jCheckBox2.setSelected(true);
        }else if(ca.getPrefereHouM() == 2){
            jCheckBox2.setSelected(true);
        }else if(ca.getPrefereHouM() == 1){
            jCheckBox1.setSelected(true);
        }
        
        //pressao alta sim nao
        if(ca.getPressaoAltaSimNao() == 1) {
            jRadioButton27.setSelected(true);
        }else if(ca.getPressaoAltaSimNao() == 2){
            jRadioButton26.setSelected(true);
        }
        
        //diabetes
        if(ca.getDiabeteSimNao() == 1){
            jRadioButton28.setSelected(true);
        }else if(ca.getDiabeteSimNao() == 2){
            jRadioButton29.setSelected(true);
        }
        
        //tratamento medico
        jTextField13.setText(ca.getTratamentoMedico());
        
        //dormir trabalho
        if(ca.getDormirTrabalhoSimNao() == 1){
            jRadioButton31.setSelected(true);
        }else if(ca.getDormirTrabalhoSimNao() == 2){
            jRadioButton30.setSelected(true);
        }
        
        //escala 5 2 agora é disponobilidade total
        if(ca.getDisponibilidadeTotal() == 1){
            jCheckBox17.setSelected(true);
        }else {
            jCheckBox17.setSelected(false);
        }
        
        //escala 2424
        if(ca.getEscala2424SimNao() == 1){
            jRadioButton33.setSelected(true);
        }else if(ca.getEscala2424SimNao() == 2){
            jRadioButton32.setSelected(true);
        }
        
        //escala 1236
        if(ca.getEscala1236SimNao() == 1){
            jRadioButton35.setSelected(true);
        }else if(ca.getEscala1236SimNao() == 2){
            jRadioButton34.setSelected(true);
        }
        
        //lista diuron
        if(jRadioButton35.isSelected()){
            jComboBox4.setSelectedIndex(ca.getDiurnoIndex());
        }
        
        //somente seg a sex
        if(ca.getSomenteSegASex() == 1){
            jCheckBox3.setSelected(true);
        }
        
        //folguista fds
        if(ca.getFolguistaFdsSimNao() == 1){
            jRadioButton37.setSelected(true);
        }else if(ca.getFolguistaFdsSimNao() == 2){
            jRadioButton36.setSelected(true);
        }
        
        //integral fds
        if(ca.getIntegralFdsSimNao() == 1){
            jRadioButton39.setSelected(true);
        }else if(ca.getIntegralFdsSimNao() == 2){
            jRadioButton38.setSelected(true);
        }
        
        //pretencao sal
        txtFild.setText(ca.getPretencaoSalarial());
        
        //obsercações
        jTextArea1.setText(ca.getObservacoes());
        
        //tem curso cuidadora
        if(ca.getTemCursoCuidadora() == 1){
            jRadioButton41.setSelected(true);
            lblQual.setEnabled(true);
            jTextField12.setEnabled(true);
            lblCertificado.setEnabled(true);
            btnRadSimCertificado.setEnabled(true);
            btnRadNaoCertificado.setEnabled(true);
        }else if(ca.getTemCertificadoSimNao() == 2){
            jRadioButton40.setSelected(true);
        }
        
        //qual curos
        if(jRadioButton41.isSelected()){
            jTextField12.setText(ca.getQualCursoCuidadora());
        }
        
        //tem certificado
        if(ca.getTemCertificadoSimNao() == 1){
            btnRadSimCertificado.setSelected(true);
        }else if(ca.getTemCertificadoSimNao() == 2){
            btnRadNaoCertificado.setSelected(true);
        }
        
        //coren ativo
        if(ca.getCorenAtivoSimNao() == 1){
            jRadioButton45.setSelected(true);
            txtInscricao.setEnabled(true);
        }else if(ca.getCorenAtivoSimNao() == 2){
            jRadioButton44.setSelected(true);
        }
        
        //numero conren
        if(jRadioButton45.isSelected()){
            txtInscricao.setText(ca.getInscricaoCoren());
        }
        
        //como pedou conecimento
        if(ca.getComoAdiquiriuConhecimentoPraCur() == 3){
            jCheckBox5.setSelected(true);
            jCheckBox4.setSelected(true);
        }else if(ca.getComoAdiquiriuConhecimentoPraCur() == 1){
            jCheckBox4.setSelected(true);
        }else if(ca.getComoAdiquiriuConhecimentoPraCur() == 2){
            jCheckBox5.setSelected(true);
        }
        
        //sabe aferir dados vitais
        if(ca.getAferirSinaisVitais() == 30){
            jCheckBox6.setSelected(true);
            jCheckBox7.setSelected(true);
            jCheckBox8.setSelected(true);
            jCheckBox9.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 19){
            jCheckBox6.setSelected(true);
            jCheckBox7.setSelected(true);
            jCheckBox8.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 21){
            jCheckBox6.setSelected(true);
            jCheckBox7.setSelected(true);
            jCheckBox9.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 23){
            jCheckBox6.setSelected(true);
            jCheckBox9.setSelected(true);
            jCheckBox8.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 27){
            jCheckBox9.setSelected(true);
            jCheckBox7.setSelected(true);
            jCheckBox8.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 10){
            jCheckBox6.setSelected(true);
            jCheckBox7.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 12){
            jCheckBox6.setSelected(true);
            jCheckBox8.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 14){
            jCheckBox6.setSelected(true);
            jCheckBox9.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 16){
            jCheckBox7.setSelected(true);
            jCheckBox8.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 18){
            jCheckBox7.setSelected(true);
            jCheckBox9.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 20){
            jCheckBox8.setSelected(true);
            jCheckBox9.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 3){
            jCheckBox6.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 7){
            jCheckBox7.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 9){
            jCheckBox8.setSelected(true);
        }else if(ca.getAferirSinaisVitais() == 11){
            jCheckBox9.setSelected(true);
        }
        
        //trabalha com sonda
        if(ca.getTrabalhaSondaSimNao() == 1){
            
            jRadioButton46.setSelected(true);
            lblQualBolsa.setEnabled(true);
            txtQualBolsa.setEnabled(true);
        }else if(ca.getTrabalhaBolsaSimNao() == 2){
            jRadioButton47.setSelected(true);
        }
        
        //qual sonda
        
        txtQualBolsa.setText(ca.getQualSonda());
        
        
        //trabalha com bolsa
        if(ca.getTrabalhaBolsaSimNao() == 1){
            jRadioButton49.setSelected(true);
            
        }else if(ca.getTrabalhaBolsaSimNao() == 2){
            jRadioButton48.setSelected(true);
        }
        
        //colostomia
        if(ca.getColostomia() == 1){
            jCheckBox16.setEnabled(true);
            jCheckBox16.setSelected(true);
        }
        
        
        //dependenic
        jTextField17.setText(ca.getGrauDependencia());
        
        //enfermidade Alz
        if(ca.getEnfermidadeAlze() == 1){
            jCheckBox10.setSelected(true);
        }
        
        //enfermidade park
        if(ca.getEnfermidadeParkin() == 1){
            jCheckBox11.setSelected(true);
        }
        
        //enfer esqui
        if(ca.getEnfermidadeEsquizo() == 1){
            jCheckBox12.setSelected(true);
        }
        
        //enfer deme
        if(ca.getEnfermidadeDeme() == 1){
            jCheckBox13.setSelected(true);
        }
        
        //enfer avc
        if(ca.getEnfermidadeAvc() == 1){
            jCheckBox14.setSelected(true);
        }
        
        //enfer cance
        if(ca.getEnfermidadeCancer() == 1){
            jCheckBox15.setSelected(true);
        }
        
        //observacoes profissional
        jTextArea3.setText(ca.getObservacoesProfissional());
        
        //observacoes uktimo
       jTextArea2.setText(ca.getObervacoesUltimosEmpregos());
        
        //nome empregador 1
        jTextField18.setText(ca.getNomeEmpregador1());
        
        //telefone 1
        txtFild6.setText(ca.getTelefoneEmpregador1());

        //data emrpegador 1
        txtFild7.setText(ca.getDataEmpregador1());
        
        //obs emprega 1
        jTextField16.setText(ca.getObservacoresEmpregador1());
        
        //nome empregador 2
        jTextField20.setText(ca.getNomeEmpregador2());
        
        //telefone
        txtFild8.setText(ca.getTelefoneEmpregador2());
        
        //data emrpeg 2
        txtFild9.setText(ca.getDataEmpregador2());
        
        //obs emp 2
        jTextField19.setText(ca.getObservacoresEmpregador2());
        
        //rg
        jTextField21.setText(ca.getRgArquivo()); 
        
        //cpf
        jTextField22.setText(ca.getCpfArquivo());
        
        //endereco
        jTextField23.setText(ca.getEnderecoArquivo());
        
        //coren
        jTextField24.setText(ca.getConrenArquivo());
        
        //cert cuidadora
        jTextField25.setText(ca.getCertificadoCuidadoraArquivo());
        
        
        //Cert enfer,m
        jTextField26.setText(ca.getCertificadoEnfermagemArquivo());
        
        
        //cnh
        jTextField27.setText(ca.getCnhArquivo());
        
        
        //cnpj
        jTextField28.setText(ca.getCnpjArquivo());
        
        //Outros
        jTextField29.setText(ca.getOutrosArquivo());
        
        //consire
        jTextArea4.setText(ca.getConsidecoes());
        
        //curso de enfermagem tec
        if(ca.getCursoEnferTecnico() == 1){
            jCheckBox18.setSelected(true);
        }

        //curso de enfermagem aux
        if(ca.getCursoEnferAux() == 1){
            jCheckBox19.setSelected(true);
        }
        //banho no leito
        if(ca.getBanhoSimNao() == 1){
            jRadioButton51.setSelected(true);
        }else if(ca.getBanhoSimNao() == 2){
            jRadioButton50.setSelected(true);
        }
        
        //tratamento escarras
        if(ca.getEscarrasSimNao() == 1){
            jRadioButton53.setSelected(true);
        }else if(ca.getEscarrasSimNao() == 2){
            jRadioButton52.setSelected(true);
        }
        
        //cadeirante
        if(ca.getCadeiranteSimNao() == 1){
            jRadioButton55.setSelected(true);
        }else if(ca.getCadeiranteSimNao() == 2){
            jRadioButton54.setSelected(true);
        }
        
        //outras doenças
        jTextField31.setText(ca.getOutrasDoencas());
        
        //foto
        caminho2 = ca.getCaminhoFoto();
        if(caminho2 != null){
            File file = new File(caminho2);
            try {
                BufferedImage image = ImageIO.read(file);
                ImageIcon icon = new ImageIcon(image);
                Image foto = icon.getImage();
                Image fotoResize = foto.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),java.awt.Image.SCALE_SMOOTH);
                icon.setImage(fotoResize);
                lblFoto.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(AtualizaCuidadora.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seletorDocumentosEmAnexo = new javax.swing.JFileChooser();
        btnGrupoTipoDeCuidadora = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        btnGrupoMaiorMenor = new javax.swing.ButtonGroup();
        btnGrupoFilhos = new javax.swing.ButtonGroup();
        btnGrupoCNH = new javax.swing.ButtonGroup();
        btnGrupoTemCarro = new javax.swing.ButtonGroup();
        btnGrupoWhats = new javax.swing.ButtonGroup();
        btnGrupoFuma = new javax.swing.ButtonGroup();
        btnGrupoGostaAnimal = new javax.swing.ButtonGroup();
        btnGrupoAlergia = new javax.swing.ButtonGroup();
        btnGrupoRegistroCLT = new javax.swing.ButtonGroup();
        btnGrupoConvenio = new javax.swing.ButtonGroup();
        btnGrupoViagem = new javax.swing.ButtonGroup();
        btnGrupoCozinha = new javax.swing.ButtonGroup();
        btnGrupoPressao = new javax.swing.ButtonGroup();
        btnGrupoDiabetes = new javax.swing.ButtonGroup();
        btnGrupoDormir = new javax.swing.ButtonGroup();
        btnGrupoEscala2424 = new javax.swing.ButtonGroup();
        btnGrupoEscala1236 = new javax.swing.ButtonGroup();
        btnGrupoFolguistaFinalDeSemana = new javax.swing.ButtonGroup();
        btnGrupoIntegralSabadoDomingo = new javax.swing.ButtonGroup();
        btnGrupoCursoCuidadora = new javax.swing.ButtonGroup();
        btnGrupoCertificado = new javax.swing.ButtonGroup();
        btnGrupoCorenAtivo = new javax.swing.ButtonGroup();
        btnGrupoSonda = new javax.swing.ButtonGroup();
        btnGrupoBolsa = new javax.swing.ButtonGroup();
        btnGrupoEscarras = new javax.swing.ButtonGroup();
        btnGrupoCadeirante = new javax.swing.ButtonGroup();
        btnGrupoBanho = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/FundoCadastroDadosPessoais.png"));
        final Image imageDados = icon1.getImage();
        panelDadosPessoais = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics graph){
                super.paintComponent(graph);
                graph.drawImage(imageDados, 0, 0, getWidth(), getHeight(),this);
            }
        };
        lblCNPJ = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnRadMEI = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumFilhos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblFoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSelecionarFoto = new javax.swing.JButton();
        txtFild3 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        radFilhoNao = new javax.swing.JRadioButton();
        radFilhoSim = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        radMenor = new javax.swing.JRadioButton();
        radMaior = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtFild4 = new javax.swing.JFormattedTextField();
        txtFild5 = new javax.swing.JFormattedTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jTextField11 = new javax.swing.JTextField();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        txtAlergia = new javax.swing.JTextField();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFild2 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jTextField30 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator62 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator63 = new javax.swing.JSeparator();
        jSeparator64 = new javax.swing.JSeparator();
        jSeparator65 = new javax.swing.JSeparator();
        jSeparator66 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator67 = new javax.swing.JSeparator();
        jSeparator68 = new javax.swing.JSeparator();
        jSeparator69 = new javax.swing.JSeparator();
        jSeparator70 = new javax.swing.JSeparator();
        jSeparator71 = new javax.swing.JSeparator();
        jSeparator72 = new javax.swing.JSeparator();
        jSeparator73 = new javax.swing.JSeparator();
        jSeparator74 = new javax.swing.JSeparator();
        jSeparator75 = new javax.swing.JSeparator();
        jSeparator76 = new javax.swing.JSeparator();
        jSeparator77 = new javax.swing.JSeparator();
        jSeparator78 = new javax.swing.JSeparator();
        jSeparator79 = new javax.swing.JSeparator();
        jSeparator80 = new javax.swing.JSeparator();
        jSeparator81 = new javax.swing.JSeparator();
        jSeparator82 = new javax.swing.JSeparator();
        jSeparator83 = new javax.swing.JSeparator();
        jSeparator84 = new javax.swing.JSeparator();
        jSeparator85 = new javax.swing.JSeparator();
        jSeparator86 = new javax.swing.JSeparator();
        jLabel85 = new javax.swing.JLabel();
        txtFild10 = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        ImageIcon icon44 = new ImageIcon(getClass().getResource("/images/FundoInfo.png"));
        final Image imageInfo = icon44.getImage();
        panelInfo = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics graph){
                super.paintComponent(graph);
                graph.drawImage(imageInfo, 0, 0, getWidth(), getHeight(),this);
            }
        };
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jLabel37 = new javax.swing.JLabel();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jLabel41 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel38 = new javax.swing.JLabel();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jRadioButton35 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jLabel39 = new javax.swing.JLabel();
        jRadioButton32 = new javax.swing.JRadioButton();
        jRadioButton33 = new javax.swing.JRadioButton();
        jLabel44 = new javax.swing.JLabel();
        jCheckBox17 = new javax.swing.JCheckBox();
        jLabel43 = new javax.swing.JLabel();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel46 = new javax.swing.JLabel();
        jRadioButton36 = new javax.swing.JRadioButton();
        jRadioButton37 = new javax.swing.JRadioButton();
        jLabel47 = new javax.swing.JLabel();
        jRadioButton38 = new javax.swing.JRadioButton();
        jRadioButton39 = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        txtFild = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jSeparator31 = new javax.swing.JSeparator();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator33 = new javax.swing.JSeparator();
        jSeparator34 = new javax.swing.JSeparator();
        jSeparator35 = new javax.swing.JSeparator();
        jSeparator36 = new javax.swing.JSeparator();
        jSeparator37 = new javax.swing.JSeparator();
        jSeparator38 = new javax.swing.JSeparator();
        jSeparator39 = new javax.swing.JSeparator();
        jSeparator40 = new javax.swing.JSeparator();
        jSeparator41 = new javax.swing.JSeparator();
        jSeparator42 = new javax.swing.JSeparator();
        jSeparator43 = new javax.swing.JSeparator();
        jSeparator44 = new javax.swing.JSeparator();
        jSeparator45 = new javax.swing.JSeparator();
        jSeparator46 = new javax.swing.JSeparator();
        jSeparator47 = new javax.swing.JSeparator();
        jSeparator48 = new javax.swing.JSeparator();
        jSeparator49 = new javax.swing.JSeparator();
        jSeparator50 = new javax.swing.JSeparator();
        jSeparator51 = new javax.swing.JSeparator();
        jSeparator52 = new javax.swing.JSeparator();
        jSeparator53 = new javax.swing.JSeparator();
        jSeparator54 = new javax.swing.JSeparator();
        jSeparator55 = new javax.swing.JSeparator();
        jSeparator56 = new javax.swing.JSeparator();
        jSeparator57 = new javax.swing.JSeparator();
        jSeparator58 = new javax.swing.JSeparator();
        jSeparator59 = new javax.swing.JSeparator();
        jSeparator60 = new javax.swing.JSeparator();
        jSeparator61 = new javax.swing.JSeparator();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/FundoConhecimentos.png"));
        final Image imageConhecimentos = icon2.getImage();
        panelConhecimentosProfissionais = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imageConhecimentos, 0, 0, getWidth(), getHeight(), this);
            }
        };
        lblCertificado = new javax.swing.JLabel();
        jRadioButton40 = new javax.swing.JRadioButton();
        jRadioButton41 = new javax.swing.JRadioButton();
        lblInscricao = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        lblQual = new javax.swing.JLabel();
        btnRadNaoCertificado = new javax.swing.JRadioButton();
        btnRadSimCertificado = new javax.swing.JRadioButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtInscricao = new javax.swing.JTextField();
        jRadioButton44 = new javax.swing.JRadioButton();
        jRadioButton45 = new javax.swing.JRadioButton();
        lblCoren = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel56 = new javax.swing.JLabel();
        jRadioButton46 = new javax.swing.JRadioButton();
        jRadioButton47 = new javax.swing.JRadioButton();
        lblQualBolsa = new javax.swing.JLabel();
        jRadioButton48 = new javax.swing.JRadioButton();
        jRadioButton49 = new javax.swing.JRadioButton();
        txtQualBolsa = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jTextField17 = new javax.swing.JTextField();
        jCheckBox16 = new javax.swing.JCheckBox();
        jLabel79 = new javax.swing.JLabel();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel83 = new javax.swing.JLabel();
        jRadioButton50 = new javax.swing.JRadioButton();
        jRadioButton51 = new javax.swing.JRadioButton();
        jLabel84 = new javax.swing.JLabel();
        jRadioButton52 = new javax.swing.JRadioButton();
        jRadioButton53 = new javax.swing.JRadioButton();
        jLabel81 = new javax.swing.JLabel();
        jRadioButton54 = new javax.swing.JRadioButton();
        jRadioButton55 = new javax.swing.JRadioButton();
        jTextField31 = new javax.swing.JTextField();
        jSeparator92 = new javax.swing.JSeparator();
        jSeparator95 = new javax.swing.JSeparator();
        jSeparator93 = new javax.swing.JSeparator();
        jSeparator94 = new javax.swing.JSeparator();
        jSeparator96 = new javax.swing.JSeparator();
        jSeparator97 = new javax.swing.JSeparator();
        jSeparator98 = new javax.swing.JSeparator();
        jSeparator99 = new javax.swing.JSeparator();
        jSeparator100 = new javax.swing.JSeparator();
        jSeparator101 = new javax.swing.JSeparator();
        jSeparator102 = new javax.swing.JSeparator();
        jSeparator103 = new javax.swing.JSeparator();
        jSeparator104 = new javax.swing.JSeparator();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        ImageIcon ic = new ImageIcon(getClass().getResource("/images/FundoRefe.png"));
        final Image imageFundo = ic.getImage();
        panelRefe = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics gr){
                super.paintComponent(gr);
                gr.drawImage(imageFundo, 0 ,0 , getWidth(), getHeight(), this);
            }
        };
        jSeparator87 = new javax.swing.JSeparator();
        jSeparator88 = new javax.swing.JSeparator();
        jSeparator89 = new javax.swing.JSeparator();
        jSeparator90 = new javax.swing.JSeparator();
        jSeparator91 = new javax.swing.JSeparator();
        jLabel63 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField18 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtFild6 = new javax.swing.JFormattedTextField();
        jLabel66 = new javax.swing.JLabel();
        txtFild7 = new javax.swing.JFormattedTextField();
        txtFild9 = new javax.swing.JFormattedTextField();
        jLabel72 = new javax.swing.JLabel();
        txtFild8 = new javax.swing.JFormattedTextField();
        jLabel71 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/FundoAnexo.png"));
        final Image imageAnexo = icon3.getImage();
        panelAnexo = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics gra){
                super.paintComponent(gra);
                gra.drawImage(imageAnexo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jLabel51 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jSeparator23 = new javax.swing.JSeparator();

        seletorDocumentosEmAnexo.setFileFilter(new FiltroDocumentos());

        btnGrupoTipoDeCuidadora.add(jRadioButton1);
        btnGrupoTipoDeCuidadora.add(jRadioButton2);
        btnGrupoTipoDeCuidadora.add(jRadioButton3);

        jFileChooser1.setFileFilter(new MyCustomFilter());

        btnGrupoMaiorMenor.add(radMaior);
        btnGrupoMaiorMenor.add(radMenor);

        btnGrupoFilhos.add(radFilhoNao);
        btnGrupoFilhos.add(radFilhoSim);

        btnGrupoCNH.add(jRadioButton4);
        btnGrupoCNH.add(jRadioButton5);

        btnGrupoTemCarro.add(jRadioButton6);
        btnGrupoTemCarro.add(jRadioButton7);

        btnGrupoWhats.add(jRadioButton8);
        btnGrupoWhats.add(jRadioButton9);

        btnGrupoFuma.add(jRadioButton10);
        btnGrupoFuma.add(jRadioButton11);

        btnGrupoGostaAnimal.add(jRadioButton12);
        btnGrupoGostaAnimal.add(jRadioButton13);

        btnGrupoAlergia.add(jRadioButton14);
        btnGrupoAlergia.add(jRadioButton15);

        btnGrupoRegistroCLT.add(jRadioButton16);
        btnGrupoRegistroCLT.add(jRadioButton17);

        btnGrupoConvenio.add(jRadioButton18);
        btnGrupoConvenio.add(jRadioButton19);

        btnGrupoViagem.add(jRadioButton20);
        btnGrupoViagem.add(jRadioButton21);

        btnGrupoCozinha.add(jRadioButton22);
        btnGrupoCozinha.add(jRadioButton23);

        btnGrupoPressao.add(jRadioButton26);
        btnGrupoPressao.add(jRadioButton27);

        btnGrupoDiabetes.add(jRadioButton28);
        btnGrupoDiabetes.add(jRadioButton29);

        btnGrupoDormir.add(jRadioButton30);
        btnGrupoDormir.add(jRadioButton31);

        btnGrupoEscala2424.add(jRadioButton32);
        btnGrupoEscala2424.add(jRadioButton33);

        btnGrupoEscala1236.add(jRadioButton34);
        btnGrupoEscala1236.add(jRadioButton35);

        btnGrupoFolguistaFinalDeSemana.add(jRadioButton36);
        btnGrupoFolguistaFinalDeSemana.add(jRadioButton37);

        btnGrupoIntegralSabadoDomingo.add(jRadioButton38);
        btnGrupoIntegralSabadoDomingo.add(jRadioButton39);

        btnGrupoCursoCuidadora.add(jRadioButton40);
        btnGrupoCursoCuidadora.add(jRadioButton41);

        btnGrupoCertificado.add(btnRadNaoCertificado);
        btnGrupoCertificado.add(btnRadSimCertificado);

        btnGrupoCorenAtivo.add(jRadioButton45);
        btnGrupoCorenAtivo.add(jRadioButton44);

        btnGrupoSonda.add(jRadioButton46);
        btnGrupoSonda.add(jRadioButton47);

        btnGrupoBolsa.add(jRadioButton48);
        btnGrupoBolsa.add(jRadioButton49);

        btnGrupoEscarras.add(jRadioButton52);
        btnGrupoEscarras.add(jRadioButton53);

        btnGrupoCadeirante.add(jRadioButton54);
        btnGrupoCadeirante.add(jRadioButton55);

        btnGrupoBanho.add(jRadioButton50);
        btnGrupoBanho.add(jRadioButton51);

        setClosable(true);
        setIconifiable(true);
        setTitle("Alteração de Cadastro");
        setMinimumSize(new java.awt.Dimension(1350, 770));
        setPreferredSize(new java.awt.Dimension(1350, 770));
        getContentPane().setLayout(null);

        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        panelDadosPessoais.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDadosPessoais.setLayout(null);

        lblCNPJ.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblCNPJ.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCNPJ.setText("-    CNPJ:");
        lblCNPJ.setEnabled(false);
        panelDadosPessoais.add(lblCNPJ);
        lblCNPJ.setBounds(920, 10, 70, 30);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel2.setText("Código:");
        panelDadosPessoais.add(jLabel2);
        jLabel2.setBounds(20, 10, 80, 30);

        jRadioButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jRadioButton1.setText("Técnica(o) em Enfermagem");
        panelDadosPessoais.add(jRadioButton1);
        jRadioButton1.setBounds(440, 10, 260, 33);

        jRadioButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jRadioButton2.setText("Cuidadora");
        panelDadosPessoais.add(jRadioButton2);
        jRadioButton2.setBounds(710, 10, 120, 33);

        jRadioButton3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jRadioButton3.setText("Auxiliar de Enfermagem");
        panelDadosPessoais.add(jRadioButton3);
        jRadioButton3.setBounds(210, 10, 230, 33);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel3.setText("Data de Nasc.:");
        panelDadosPessoais.add(jLabel3);
        jLabel3.setBounds(220, 130, 110, 30);

        btnRadMEI.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        btnRadMEI.setText("MEI");
        btnRadMEI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadMEIActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(btnRadMEI);
        btnRadMEI.setBounds(860, 10, 60, 30);

        jTextField2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField2);
        jTextField2.setBounds(270, 185, 60, 30);

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCNPJ.setEnabled(false);
        txtCNPJ.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(txtCNPJ);
        txtCNPJ.setBounds(1000, 10, 180, 30);

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField3);
        jTextField3.setBounds(90, 10, 90, 30);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel4.setText("Fumante:");
        panelDadosPessoais.add(jLabel4);
        jLabel4.setBounds(510, 185, 80, 30);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel5.setText("RG:");
        panelDadosPessoais.add(jLabel5);
        jLabel5.setBounds(890, 65, 40, 30);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("CPF: ");
        panelDadosPessoais.add(jLabel6);
        jLabel6.setBounds(1130, 65, 40, 30);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel7.setText("UF:");
        panelDadosPessoais.add(jLabel7);
        jLabel7.setBounds(20, 365, 30, 30);

        jTextField4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField4);
        jTextField4.setBounds(240, 365, 140, 30);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel8.setText("Altura:");
        panelDadosPessoais.add(jLabel8);
        jLabel8.setBounds(220, 185, 50, 30);

        txtNumFilhos.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        txtNumFilhos.setEnabled(false);
        panelDadosPessoais.add(txtNumFilhos);
        txtNumFilhos.setBounds(1090, 185, 70, 30);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel9.setText("Cor de Pele:");
        panelDadosPessoais.add(jLabel9);
        jLabel9.setBounds(1000, 125, 90, 30);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel10.setText("Kg");
        panelDadosPessoais.add(jLabel10);
        jLabel10.setBounds(470, 185, 20, 30);

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        panelDadosPessoais.add(jComboBox1);
        jComboBox1.setBounds(60, 365, 60, 30);

        jComboBox2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)", "Separado(a)" }));
        panelDadosPessoais.add(jComboBox2);
        jComboBox2.setBounds(800, 125, 170, 30);

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PlaceholderResize.jpg"))); // NOI18N
        lblFoto.setText("jLabel1");
        panelDadosPessoais.add(lblFoto);
        lblFoto.setBounds(40, 80, 130, 160);

        jButton1.setText("Apagar Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(jButton1);
        jButton1.setBounds(50, 290, 110, 30);

        btnSelecionarFoto.setText("Selecionar Foto");
        btnSelecionarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarFotoActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(btnSelecionarFoto);
        btnSelecionarFoto.setBounds(40, 250, 130, 30);

        try {
            txtFild3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFild3.setText("");
        txtFild3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(txtFild3);
        txtFild3.setBounds(1170, 65, 160, 30);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel12.setText("Peso:");
        panelDadosPessoais.add(jLabel12);
        jLabel12.setBounds(360, 185, 40, 30);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel13.setText("m");
        panelDadosPessoais.add(jLabel13);
        jLabel13.setBounds(330, 185, 20, 30);

        radFilhoNao.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        radFilhoNao.setText("Não");
        radFilhoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFilhoNaoActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(radFilhoNao);
        radFilhoNao.setBounds(780, 185, 55, 30);

        radFilhoSim.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        radFilhoSim.setText("Sim");
        radFilhoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFilhoSimActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(radFilhoSim);
        radFilhoSim.setBounds(840, 185, 50, 30);

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel16.setText("Filhos :");
        panelDadosPessoais.add(jLabel16);
        jLabel16.setBounds(720, 185, 50, 30);

        radMenor.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        radMenor.setText("Menor:");
        radMenor.setEnabled(false);
        panelDadosPessoais.add(radMenor);
        radMenor.setBounds(1010, 185, 80, 30);

        radMaior.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        radMaior.setText("Maior");
        radMaior.setEnabled(false);
        panelDadosPessoais.add(radMaior);
        radMaior.setBounds(940, 185, 70, 30);

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel17.setText("Estado Civil:");
        panelDadosPessoais.add(jLabel17);
        jLabel17.setBounds(700, 125, 100, 30);

        jTextField7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField7);
        jTextField7.setBounds(400, 185, 70, 30);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel11.setText("Nome Completo:");
        panelDadosPessoais.add(jLabel11);
        jLabel11.setBounds(220, 65, 240, 30);

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel19.setText("WhatsApp:");
        panelDadosPessoais.add(jLabel19);
        jLabel19.setBounds(660, 245, 80, 30);

        jTextField6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField6);
        jTextField6.setBounds(590, 125, 80, 30);

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel20.setText("Número:");
        panelDadosPessoais.add(jLabel20);
        jLabel20.setBounds(1050, 305, 70, 30);

        jTextField8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField8);
        jTextField8.setBounds(1120, 305, 180, 30);

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel21.setText("Endereço:");
        panelDadosPessoais.add(jLabel21);
        jLabel21.setBounds(220, 305, 80, 30);

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel22.setText("Bairro:");
        panelDadosPessoais.add(jLabel22);
        jLabel22.setBounds(420, 365, 50, 30);

        jTextField9.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField9);
        jTextField9.setBounds(480, 365, 140, 30);

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel23.setText("Telefone:");
        panelDadosPessoais.add(jLabel23);
        jLabel23.setBounds(220, 245, 70, 30);

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel24.setText("Celular:");
        panelDadosPessoais.add(jLabel24);
        jLabel24.setBounds(450, 245, 60, 30);

        try {
            txtFild4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFild4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(txtFild4);
        txtFild4.setBounds(700, 365, 110, 30);

        try {
            txtFild5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFild5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(txtFild5);
        txtFild5.setBounds(300, 245, 110, 30);

        jTextField10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField10);
        jTextField10.setBounds(360, 70, 500, 30);

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel25.setText("Cidade:");
        panelDadosPessoais.add(jLabel25);
        jLabel25.setBounds(180, 365, 60, 30);

        jRadioButton8.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton8.setText("Sim");
        panelDadosPessoais.add(jRadioButton8);
        jRadioButton8.setBounds(810, 245, 50, 30);

        jRadioButton9.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton9.setText("Não");
        panelDadosPessoais.add(jRadioButton9);
        jRadioButton9.setBounds(750, 245, 60, 30);

        jTextField11.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField11);
        jTextField11.setBounds(300, 305, 710, 30);

        jRadioButton10.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton10.setText("Sim");
        panelDadosPessoais.add(jRadioButton10);
        jRadioButton10.setBounds(640, 185, 50, 29);

        jRadioButton11.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton11.setText("Não");
        panelDadosPessoais.add(jRadioButton11);
        jRadioButton11.setBounds(580, 185, 60, 29);

        jComboBox3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Muito Clara", "Clara", "Clara Média(Caucasiano)", "Escura Média", "Escuro (Pardo)", "Negra" }));
        panelDadosPessoais.add(jComboBox3);
        jComboBox3.setBounds(1100, 125, 230, 30);

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel28.setText("Alergias:");
        panelDadosPessoais.add(jLabel28);
        jLabel28.setBounds(280, 425, 70, 30);

        txtAlergia.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        txtAlergia.setEnabled(false);
        panelDadosPessoais.add(txtAlergia);
        txtAlergia.setBounds(580, 425, 360, 30);

        jRadioButton12.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton12.setText("Não");
        panelDadosPessoais.add(jRadioButton12);
        jRadioButton12.setBounds(140, 425, 60, 30);

        jRadioButton13.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton13.setText("Sim");
        panelDadosPessoais.add(jRadioButton13);
        jRadioButton13.setBounds(200, 425, 50, 30);

        jRadioButton14.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton14.setText("Sim");
        jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton14ActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(jRadioButton14);
        jRadioButton14.setBounds(410, 425, 50, 29);

        jRadioButton15.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton15.setText("Não");
        jRadioButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton15ActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(jRadioButton15);
        jRadioButton15.setBounds(350, 425, 55, 29);

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel31.setText("Gosta de Animais:");
        panelDadosPessoais.add(jLabel31);
        jLabel31.setBounds(10, 425, 130, 30);

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel15.setText("CEP:");
        panelDadosPessoais.add(jLabel15);
        jLabel15.setBounds(660, 365, 40, 30);

        try {
            txtFild2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFild2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(txtFild2);
        txtFild2.setBounds(510, 245, 120, 30);

        jButton3.setBackground(new java.awt.Color(77, 166, 255));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(jButton3);
        jButton3.setBounds(850, 630, 135, 50);

        jTextField30.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(jTextField30);
        jTextField30.setBounds(920, 65, 170, 30);

        jComboBox7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sul", "Norte", "Leste", "Oeste", "Central" }));
        panelDadosPessoais.add(jComboBox7);
        jComboBox7.setBounds(920, 365, 90, 30);

        jLabel50.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel50.setText("Região:");
        panelDadosPessoais.add(jLabel50);
        jLabel50.setBounds(850, 365, 60, 30);

        jButton4.setBackground(new java.awt.Color(77, 166, 255));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton4.setText("Atualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelDadosPessoais.add(jButton4);
        jButton4.setBounds(690, 630, 135, 50);

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator10);
        jSeparator10.setBounds(830, 0, 2, 50);

        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator11);
        jSeparator11.setBounds(0, 48, 1400, 2);

        jSeparator62.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator62.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator62);
        jSeparator62.setBounds(830, 0, 2, 50);

        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator12);
        jSeparator12.setBounds(200, 50, 2, 298);

        jSeparator63.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator63);
        jSeparator63.setBounds(200, 110, 1140, 2);

        jSeparator64.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator64);
        jSeparator64.setBounds(200, 288, 1140, 2);

        jSeparator65.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator65.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator65);
        jSeparator65.setBounds(880, 50, 2, 60);

        jSeparator66.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator66);
        jSeparator66.setBounds(200, 170, 1140, 2);

        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator15);
        jSeparator15.setBounds(1105, 50, 2, 60);

        jSeparator67.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator67.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator67);
        jSeparator67.setBounds(520, 110, 2, 60);

        jSeparator68.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator68.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator68);
        jSeparator68.setBounds(690, 110, 2, 60);

        jSeparator69.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator69.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator69);
        jSeparator69.setBounds(985, 110, 2, 60);

        jSeparator70.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator70.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator70);
        jSeparator70.setBounds(350, 170, 2, 60);

        jSeparator71.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator71.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator71);
        jSeparator71.setBounds(500, 170, 2, 60);

        jSeparator72.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator72.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator72);
        jSeparator72.setBounds(710, 170, 2, 60);

        jSeparator73.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator73.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator73);
        jSeparator73.setBounds(920, 170, 2, 60);

        jSeparator74.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator74);
        jSeparator74.setBounds(200, 228, 1140, 2);

        jSeparator75.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator75.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator75);
        jSeparator75.setBounds(430, 230, 2, 60);

        jSeparator76.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator76.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator76);
        jSeparator76.setBounds(640, 230, 2, 60);

        jSeparator77.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator77.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator77);
        jSeparator77.setBounds(1025, 290, 2, 60);

        jSeparator78.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator78);
        jSeparator78.setBounds(0, 348, 1335, 2);

        jSeparator79.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator79);
        jSeparator79.setBounds(0, 408, 1335, 2);

        jSeparator80.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator80.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator80);
        jSeparator80.setBounds(150, 350, 2, 60);

        jSeparator81.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator81.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator81);
        jSeparator81.setBounds(400, 350, 2, 60);

        jSeparator82.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator82.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator82);
        jSeparator82.setBounds(640, 350, 2, 60);

        jSeparator83.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator83.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator83);
        jSeparator83.setBounds(830, 350, 2, 60);

        jSeparator84.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator84);
        jSeparator84.setBounds(0, 468, 1335, 2);

        jSeparator85.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator85.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator85);
        jSeparator85.setBounds(270, 410, 2, 60);

        jSeparator86.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator86.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelDadosPessoais.add(jSeparator86);
        jSeparator86.setBounds(470, 410, 2, 60);

        jLabel85.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel85.setText("Alergias a:");
        panelDadosPessoais.add(jLabel85);
        jLabel85.setBounds(490, 425, 90, 30);

        try {
            txtFild10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFild10.setText("");
        txtFild10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelDadosPessoais.add(txtFild10);
        txtFild10.setBounds(370, 130, 130, 30);

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel34.setText("Idade:");
        panelDadosPessoais.add(jLabel34);
        jLabel34.setBounds(540, 125, 50, 30);

        jTabbedPane1.addTab("Dados Pessoais", panelDadosPessoais);

        panelInfo.setLayout(null);

        jComboBox5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cátolico", "Evangélico", "Espírita", "Testemunha de Jeová", "Ateu", "Outros" }));
        panelInfo.add(jComboBox5);
        jComboBox5.setBounds(90, 90, 160, 30);

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel29.setText("Religião:");
        panelInfo.add(jLabel29);
        jLabel29.setBounds(20, 90, 63, 30);

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel26.setText("Grau de Instrução:");
        panelInfo.add(jLabel26);
        jLabel26.setBounds(320, 90, 140, 30);

        jComboBox6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Analfabeto", "Técnico em Enfermagem", "Ensino Fundamental Incompleto", "Ensino Fundamental Completo", "Ensino médio incompleto", "Ensino médio completo", "Superior completo", "Pós-Graduação", "Mestrado", "Doutorado", "Pòs-Doutorado " }));
        panelInfo.add(jComboBox6);
        jComboBox6.setBounds(460, 90, 260, 30);

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel27.setText("Superior:");
        panelInfo.add(jLabel27);
        jLabel27.setBounds(770, 90, 70, 30);

        jTextField5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelInfo.add(jTextField5);
        jTextField5.setBounds(840, 90, 310, 30);

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel18.setText("CNH:");
        panelInfo.add(jLabel18);
        jLabel18.setBounds(20, 150, 50, 30);

        jRadioButton5.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton5.setText("Não");
        panelInfo.add(jRadioButton5);
        jRadioButton5.setBounds(70, 150, 60, 30);

        jRadioButton4.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton4.setText("Sim");
        panelInfo.add(jRadioButton4);
        jRadioButton4.setBounds(130, 150, 51, 30);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel14.setText("Possui Carro:");
        panelInfo.add(jLabel14);
        jLabel14.setBounds(210, 150, 100, 30);

        jRadioButton7.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton7.setText("Sim");
        panelInfo.add(jRadioButton7);
        jRadioButton7.setBounds(370, 150, 50, 30);

        jRadioButton6.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton6.setText("Não");
        panelInfo.add(jRadioButton6);
        jRadioButton6.setBounds(310, 150, 60, 30);

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel36.setText("Cozinha:");
        panelInfo.add(jLabel36);
        jLabel36.setBounds(450, 150, 70, 30);

        jRadioButton23.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton23.setText("Sim");
        panelInfo.add(jRadioButton23);
        jRadioButton23.setBounds(520, 150, 50, 30);

        jRadioButton22.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton22.setText("Não");
        panelInfo.add(jRadioButton22);
        jRadioButton22.setBounds(580, 150, 60, 30);

        jRadioButton27.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton27.setText("Sim");
        panelInfo.add(jRadioButton27);
        jRadioButton27.setBounds(390, 270, 50, 30);

        jRadioButton26.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton26.setText("Não");
        panelInfo.add(jRadioButton26);
        jRadioButton26.setBounds(330, 270, 55, 30);

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel37.setText("Pressão Alta:");
        panelInfo.add(jLabel37);
        jLabel37.setBounds(230, 270, 100, 30);

        jRadioButton19.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton19.setText("Sim");
        panelInfo.add(jRadioButton19);
        jRadioButton19.setBounds(510, 210, 50, 29);

        jRadioButton18.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton18.setText("Não");
        panelInfo.add(jRadioButton18);
        jRadioButton18.setBounds(450, 210, 55, 29);

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel30.setText("Possui Convênio Médico:");
        panelInfo.add(jLabel30);
        jLabel30.setBounds(260, 210, 190, 30);

        jRadioButton17.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton17.setText("Sim");
        panelInfo.add(jRadioButton17);
        jRadioButton17.setBounds(180, 210, 50, 29);

        jRadioButton16.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton16.setText("Não");
        panelInfo.add(jRadioButton16);
        jRadioButton16.setBounds(120, 210, 60, 29);

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel32.setText("Registro CLT:");
        panelInfo.add(jLabel32);
        jLabel32.setBounds(20, 210, 100, 30);

        jTextField15.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelInfo.add(jTextField15);
        jTextField15.setBounds(850, 150, 420, 30);

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel40.setText("Habilidades Manuais:");
        panelInfo.add(jLabel40);
        jLabel40.setBounds(690, 150, 154, 30);

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel35.setText("Disponibilidade Para Viagens:");
        panelInfo.add(jLabel35);
        jLabel35.setBounds(610, 210, 220, 30);

        jRadioButton20.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton20.setText("Não");
        panelInfo.add(jRadioButton20);
        jRadioButton20.setBounds(830, 210, 55, 29);

        jRadioButton21.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jRadioButton21.setText("Sim");
        panelInfo.add(jRadioButton21);
        jRadioButton21.setBounds(890, 210, 50, 29);

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel41.setText("Prefere Cuidar de:");
        panelInfo.add(jLabel41);
        jLabel41.setBounds(980, 210, 140, 30);

        jCheckBox1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox1.setText("Homem");
        panelInfo.add(jCheckBox1);
        jCheckBox1.setBounds(1120, 210, 80, 30);

        jCheckBox2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox2.setText("Mulher");
        panelInfo.add(jCheckBox2);
        jCheckBox2.setBounds(1200, 210, 75, 30);

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel38.setText("Diabetes:");
        panelInfo.add(jLabel38);
        jLabel38.setBounds(20, 270, 70, 30);

        jRadioButton29.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton29.setText("Não");
        panelInfo.add(jRadioButton29);
        jRadioButton29.setBounds(90, 270, 55, 30);

        jRadioButton28.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton28.setText("Sim");
        panelInfo.add(jRadioButton28);
        jRadioButton28.setBounds(150, 270, 51, 30);

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel33.setText("Tratamento Médico:");
        panelInfo.add(jLabel33);
        jLabel33.setBounds(490, 270, 160, 30);

        jTextField13.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelInfo.add(jTextField13);
        jTextField13.setBounds(650, 270, 640, 30);

        jComboBox4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diurno", "Noturno", "Sem Preferência" }));
        jComboBox4.setEnabled(false);
        panelInfo.add(jComboBox4);
        jComboBox4.setBounds(1040, 390, 150, 30);

        jSeparator16.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator16);
        jSeparator16.setBounds(0, 375, 1335, 2);

        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator14);
        jSeparator14.setBounds(0, 135, 1335, 2);

        jRadioButton35.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton35.setText("Sim");
        jRadioButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton35ActionPerformed(evt);
            }
        });
        panelInfo.add(jRadioButton35);
        jRadioButton35.setBounds(970, 390, 51, 30);

        jRadioButton34.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton34.setText("Não");
        jRadioButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton34ActionPerformed(evt);
            }
        });
        panelInfo.add(jRadioButton34);
        jRadioButton34.setBounds(910, 390, 60, 30);

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel39.setText("Escala 12H/36H:");
        panelInfo.add(jLabel39);
        jLabel39.setBounds(790, 390, 120, 30);

        jRadioButton32.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton32.setText("Não");
        panelInfo.add(jRadioButton32);
        jRadioButton32.setBounds(650, 390, 55, 30);

        jRadioButton33.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton33.setText("Sim");
        panelInfo.add(jRadioButton33);
        jRadioButton33.setBounds(710, 390, 51, 30);

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel44.setText("Escala 24H/24H:");
        panelInfo.add(jLabel44);
        jLabel44.setBounds(530, 390, 120, 30);
        panelInfo.add(jCheckBox17);
        jCheckBox17.setBounds(480, 390, 20, 30);

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel43.setText("Disponibilidade Total:");
        panelInfo.add(jLabel43);
        jLabel43.setBounds(310, 390, 160, 30);

        jRadioButton31.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton31.setText("Sim");
        panelInfo.add(jRadioButton31);
        jRadioButton31.setBounds(230, 390, 60, 30);

        jRadioButton30.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton30.setText("Não");
        panelInfo.add(jRadioButton30);
        jRadioButton30.setBounds(170, 390, 55, 30);

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel48.setText("Dormir no Trabalho:");
        panelInfo.add(jLabel48);
        jLabel48.setBounds(20, 390, 150, 30);

        jLabel49.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel49.setText("Somente Segunda a Sexta:");
        panelInfo.add(jLabel49);
        jLabel49.setBounds(20, 450, 200, 30);

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel45.setText("Observações:");
        panelInfo.add(jLabel45);
        jLabel45.setBounds(600, 510, 100, 30);
        panelInfo.add(jCheckBox3);
        jCheckBox3.setBounds(220, 450, 20, 30);

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel46.setText("Folguista Finais de Semana:");
        panelInfo.add(jLabel46);
        jLabel46.setBounds(270, 450, 210, 30);

        jRadioButton36.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton36.setText("Não");
        panelInfo.add(jRadioButton36);
        jRadioButton36.setBounds(480, 450, 60, 29);

        jRadioButton37.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton37.setText("Sim");
        panelInfo.add(jRadioButton37);
        jRadioButton37.setBounds(540, 450, 60, 29);

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel47.setText("Integral Sábado e Domingo:");
        panelInfo.add(jLabel47);
        jLabel47.setBounds(630, 450, 210, 30);

        jRadioButton38.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton38.setText("Não");
        panelInfo.add(jRadioButton38);
        jRadioButton38.setBounds(840, 450, 55, 30);

        jRadioButton39.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton39.setText("Sim");
        panelInfo.add(jRadioButton39);
        jRadioButton39.setBounds(900, 450, 51, 30);

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel42.setText("Pretenção Salarial:");
        panelInfo.add(jLabel42);
        jLabel42.setBounds(980, 450, 140, 30);

        txtFild.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtFild.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFild.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelInfo.add(txtFild);
        txtFild.setBounds(1130, 450, 100, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        panelInfo.add(jScrollPane1);
        jScrollPane1.setBounds(20, 550, 1290, 140);

        jSeparator17.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator17);
        jSeparator17.setBounds(0, 73, 1335, 2);

        jSeparator18.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator18);
        jSeparator18.setBounds(662, 135, 2, 60);

        jSeparator24.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator24);
        jSeparator24.setBounds(192, 135, 0, 60);

        jSeparator25.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator25);
        jSeparator25.setBounds(430, 135, 2, 60);

        jSeparator26.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator26);
        jSeparator26.setBounds(0, 193, 1335, 2);

        jSeparator27.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator27);
        jSeparator27.setBounds(190, 135, 2, 60);

        jSeparator28.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator28);
        jSeparator28.setBounds(240, 193, 2, 60);

        jSeparator29.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator29);
        jSeparator29.setBounds(580, 193, 2, 60);

        jSeparator30.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator30);
        jSeparator30.setBounds(950, 193, 2, 60);

        jSeparator31.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator31);
        jSeparator31.setBounds(0, 253, 1335, 2);

        jSeparator32.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator32);
        jSeparator32.setBounds(215, 253, 2, 60);

        jSeparator33.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator33);
        jSeparator33.setBounds(460, 253, 2, 60);

        jSeparator34.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator34);
        jSeparator34.setBounds(0, 313, 1335, 2);

        jSeparator35.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator35);
        jSeparator35.setBounds(295, 375, 2, 60);

        jSeparator36.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator36);
        jSeparator36.setBounds(515, 375, 2, 60);

        jSeparator37.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator37);
        jSeparator37.setBounds(770, 375, 2, 60);

        jSeparator38.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator38);
        jSeparator38.setBounds(0, 433, 1335, 2);

        jSeparator39.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator39);
        jSeparator39.setBounds(250, 435, 2, 60);

        jSeparator40.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator40);
        jSeparator40.setBounds(275, 75, 2, 60);

        jSeparator41.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator41);
        jSeparator41.setBounds(750, 75, 2, 60);

        jSeparator42.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator42);
        jSeparator42.setBounds(607, 435, 2, 60);

        jSeparator43.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator43);
        jSeparator43.setBounds(960, 435, 2, 60);

        jSeparator44.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator44);
        jSeparator44.setBounds(0, 493, 1335, 2);

        jSeparator45.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator45);
        jSeparator45.setBounds(0, 193, 1335, 2);

        jSeparator46.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator46);
        jSeparator46.setBounds(190, 135, 2, 60);

        jSeparator47.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator47);
        jSeparator47.setBounds(0, 375, 1335, 2);

        jSeparator48.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator48);
        jSeparator48.setBounds(0, 135, 1335, 2);

        jSeparator49.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator49);
        jSeparator49.setBounds(0, 73, 1335, 2);

        jSeparator50.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator50);
        jSeparator50.setBounds(662, 135, 2, 60);

        jSeparator51.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator51);
        jSeparator51.setBounds(192, 135, 0, 60);

        jSeparator52.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator52);
        jSeparator52.setBounds(430, 135, 2, 60);

        jSeparator53.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator53);
        jSeparator53.setBounds(240, 193, 2, 60);

        jSeparator54.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator54);
        jSeparator54.setBounds(580, 193, 2, 60);

        jSeparator55.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator55);
        jSeparator55.setBounds(950, 193, 2, 60);

        jSeparator56.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator56);
        jSeparator56.setBounds(0, 253, 1335, 2);

        jSeparator57.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator57);
        jSeparator57.setBounds(215, 253, 2, 60);

        jSeparator58.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator58);
        jSeparator58.setBounds(460, 253, 2, 60);

        jSeparator59.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator59);
        jSeparator59.setBounds(0, 313, 1335, 2);

        jSeparator60.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator60);
        jSeparator60.setBounds(295, 375, 2, 60);

        jSeparator61.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelInfo.add(jSeparator61);
        jSeparator61.setBounds(515, 375, 2, 60);

        jTabbedPane1.addTab("Informações e Horários", panelInfo);

        panelConhecimentosProfissionais.setLayout(null);

        lblCertificado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblCertificado.setText("Certificado:");
        lblCertificado.setEnabled(false);
        panelConhecimentosProfissionais.add(lblCertificado);
        lblCertificado.setBounds(690, 115, 90, 30);

        jRadioButton40.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton40.setSelected(true);
        jRadioButton40.setText("Não");
        jRadioButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton40ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton40);
        jRadioButton40.setBounds(210, 115, 60, 30);

        jRadioButton41.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton41.setText("Sim");
        jRadioButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton41ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton41);
        jRadioButton41.setBounds(270, 115, 60, 30);

        lblInscricao.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblInscricao.setText("Inscrição:");
        panelConhecimentosProfissionais.add(lblInscricao);
        lblInscricao.setBounds(840, 175, 70, 30);

        jTextField12.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jTextField12.setEnabled(false);
        panelConhecimentosProfissionais.add(jTextField12);
        jTextField12.setBounds(390, 115, 290, 30);

        lblQual.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblQual.setText("Qual(is):");
        lblQual.setEnabled(false);
        panelConhecimentosProfissionais.add(lblQual);
        lblQual.setBounds(330, 115, 70, 30);

        btnRadNaoCertificado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        btnRadNaoCertificado.setText("Não");
        btnRadNaoCertificado.setEnabled(false);
        panelConhecimentosProfissionais.add(btnRadNaoCertificado);
        btnRadNaoCertificado.setBounds(780, 115, 55, 29);

        btnRadSimCertificado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        btnRadSimCertificado.setText("Sim");
        btnRadSimCertificado.setEnabled(false);
        panelConhecimentosProfissionais.add(btnRadSimCertificado);
        btnRadSimCertificado.setBounds(840, 115, 50, 29);

        jLabel52.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel52.setText("Possui Curso de Cuidadora:");
        panelConhecimentosProfissionais.add(jLabel52);
        jLabel52.setBounds(10, 115, 210, 30);

        jLabel53.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel53.setText("Sabe Aferir Sinais Vitais:");
        panelConhecimentosProfissionais.add(jLabel53);
        jLabel53.setBounds(30, 220, 180, 30);

        txtInscricao.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelConhecimentosProfissionais.add(txtInscricao);
        txtInscricao.setBounds(910, 175, 70, 30);

        jRadioButton44.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton44.setText("Não");
        jRadioButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton44ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton44);
        jRadioButton44.setBounds(720, 175, 55, 29);

        jRadioButton45.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton45.setText("Sim");
        jRadioButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton45ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton45);
        jRadioButton45.setBounds(780, 175, 50, 29);

        lblCoren.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblCoren.setText("COREN Ativo:");
        panelConhecimentosProfissionais.add(lblCoren);
        lblCoren.setBounds(620, 175, 100, 30);

        jLabel54.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel54.setText("Curso de Auxiliar de Enfermagem:");
        panelConhecimentosProfissionais.add(jLabel54);
        jLabel54.setBounds(310, 175, 250, 30);

        jCheckBox4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox4.setText("Prática");
        panelConhecimentosProfissionais.add(jCheckBox4);
        jCheckBox4.setBounds(1120, 115, 73, 30);

        jCheckBox5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox5.setText("Curso");
        panelConhecimentosProfissionais.add(jCheckBox5);
        jCheckBox5.setBounds(1200, 115, 65, 30);

        jLabel55.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel55.setText("Sabe Trabalhar com Bolsa:");
        panelConhecimentosProfissionais.add(jLabel55);
        jLabel55.setBounds(670, 280, 210, 30);

        jCheckBox6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox6.setText("Pressão Manual");
        panelConhecimentosProfissionais.add(jCheckBox6);
        jCheckBox6.setBounds(40, 250, 133, 30);

        jCheckBox7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox7.setText("Pressão Digital");
        panelConhecimentosProfissionais.add(jCheckBox7);
        jCheckBox7.setBounds(40, 280, 127, 30);

        jCheckBox8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox8.setText("Diabetes");
        panelConhecimentosProfissionais.add(jCheckBox8);
        jCheckBox8.setBounds(40, 310, 85, 30);

        jCheckBox9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox9.setText("Insulina");
        panelConhecimentosProfissionais.add(jCheckBox9);
        jCheckBox9.setBounds(40, 340, 81, 30);

        jLabel56.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel56.setText("Conhecimeto através de :");
        panelConhecimentosProfissionais.add(jLabel56);
        jLabel56.setBounds(920, 115, 190, 30);

        jRadioButton46.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton46.setText("Sim");
        jRadioButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton46ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton46);
        jRadioButton46.setBounds(940, 230, 51, 30);

        jRadioButton47.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton47.setSelected(true);
        jRadioButton47.setText("Não");
        jRadioButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton47ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton47);
        jRadioButton47.setBounds(880, 230, 55, 30);

        lblQualBolsa.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblQualBolsa.setText("Qual(is):");
        lblQualBolsa.setEnabled(false);
        panelConhecimentosProfissionais.add(lblQualBolsa);
        lblQualBolsa.setBounds(1000, 230, 60, 30);

        jRadioButton48.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton48.setSelected(true);
        jRadioButton48.setText("Não");
        jRadioButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton48ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton48);
        jRadioButton48.setBounds(870, 280, 55, 30);

        jRadioButton49.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton49.setText("Sim");
        jRadioButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton49ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton49);
        jRadioButton49.setBounds(930, 280, 60, 30);

        txtQualBolsa.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        txtQualBolsa.setEnabled(false);
        panelConhecimentosProfissionais.add(txtQualBolsa);
        txtQualBolsa.setBounds(1070, 230, 240, 30);

        jLabel59.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel59.setText("Sabe Trabalhar com Sonda:");
        panelConhecimentosProfissionais.add(jLabel59);
        jLabel59.setBounds(670, 230, 200, 30);

        jCheckBox10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox10.setText("Alzheimer");
        panelConhecimentosProfissionais.add(jCheckBox10);
        jCheckBox10.setBounds(240, 250, 100, 30);

        jCheckBox11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox11.setText("Parkinson");
        panelConhecimentosProfissionais.add(jCheckBox11);
        jCheckBox11.setBounds(240, 290, 100, 30);

        jCheckBox12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox12.setText("Esquizofrenia");
        panelConhecimentosProfissionais.add(jCheckBox12);
        jCheckBox12.setBounds(500, 250, 120, 30);

        jCheckBox13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox13.setText("Demência");
        panelConhecimentosProfissionais.add(jCheckBox13);
        jCheckBox13.setBounds(370, 250, 100, 30);

        jCheckBox14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox14.setText("AVC");
        panelConhecimentosProfissionais.add(jCheckBox14);
        jCheckBox14.setBounds(370, 290, 60, 30);

        jCheckBox15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox15.setText("Câncer");
        panelConhecimentosProfissionais.add(jCheckBox15);
        jCheckBox15.setBounds(500, 290, 73, 30);

        jTextField17.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelConhecimentosProfissionais.add(jTextField17);
        jTextField17.setBounds(1040, 335, 290, 30);

        jCheckBox16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jCheckBox16.setText("Colostomia");
        jCheckBox16.setEnabled(false);
        panelConhecimentosProfissionais.add(jCheckBox16);
        jCheckBox16.setBounds(990, 280, 110, 29);

        jLabel79.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel79.setText("Curso de Técnico em Enfermagem:");
        panelConhecimentosProfissionais.add(jLabel79);
        jLabel79.setBounds(10, 175, 260, 30);
        panelConhecimentosProfissionais.add(jCheckBox18);
        jCheckBox18.setBounds(270, 175, 21, 30);
        panelConhecimentosProfissionais.add(jCheckBox19);
        jCheckBox19.setBounds(560, 175, 21, 30);

        jLabel83.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel83.setText("Sabe dar Banho no Leito:");
        panelConhecimentosProfissionais.add(jLabel83);
        jLabel83.setBounds(10, 395, 210, 30);

        jRadioButton50.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton50.setSelected(true);
        jRadioButton50.setText("Não");
        jRadioButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton50ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton50);
        jRadioButton50.setBounds(200, 395, 60, 30);

        jRadioButton51.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton51.setText("Sim");
        jRadioButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton51ActionPerformed(evt);
            }
        });
        panelConhecimentosProfissionais.add(jRadioButton51);
        jRadioButton51.setBounds(260, 395, 50, 30);

        jLabel84.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel84.setText("Tratamento de Escarras:");
        panelConhecimentosProfissionais.add(jLabel84);
        jLabel84.setBounds(330, 395, 210, 30);

        jRadioButton52.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton52.setSelected(true);
        jRadioButton52.setText("Não");
        panelConhecimentosProfissionais.add(jRadioButton52);
        jRadioButton52.setBounds(510, 395, 60, 30);

        jRadioButton53.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton53.setText("Sim");
        panelConhecimentosProfissionais.add(jRadioButton53);
        jRadioButton53.setBounds(570, 395, 60, 30);

        jLabel81.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel81.setText("Já trabalhou com Cadeirantes:");
        panelConhecimentosProfissionais.add(jLabel81);
        jLabel81.setBounds(640, 395, 220, 30);

        jRadioButton54.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton54.setSelected(true);
        jRadioButton54.setText("Não");
        panelConhecimentosProfissionais.add(jRadioButton54);
        jRadioButton54.setBounds(870, 395, 60, 30);

        jRadioButton55.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jRadioButton55.setText("Sim");
        panelConhecimentosProfissionais.add(jRadioButton55);
        jRadioButton55.setBounds(930, 395, 60, 30);

        jTextField31.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelConhecimentosProfissionais.add(jTextField31);
        jTextField31.setBounds(300, 335, 330, 30);

        jSeparator92.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator92);
        jSeparator92.setBounds(-10, 100, 1350, 2);

        jSeparator95.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator95);
        jSeparator95.setBounds(900, 100, 2, 60);

        jSeparator93.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator93);
        jSeparator93.setBounds(-10, 160, 1350, 2);

        jSeparator94.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator94);
        jSeparator94.setBounds(600, 160, 2, 60);

        jSeparator96.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator96);
        jSeparator96.setBounds(-10, 220, 1380, 2);

        jSeparator97.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator97);
        jSeparator97.setBounds(650, 220, 2, 160);

        jSeparator98.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator98);
        jSeparator98.setBounds(650, 270, 750, 2);

        jSeparator99.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator99);
        jSeparator99.setBounds(650, 320, 750, 2);

        jSeparator100.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator100);
        jSeparator100.setBounds(-10, 380, 1380, 2);

        jSeparator101.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator101);
        jSeparator101.setBounds(220, 220, 2, 160);

        jSeparator102.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator102);
        jSeparator102.setBounds(320, 380, 2, 60);

        jSeparator103.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator103);
        jSeparator103.setBounds(-10, 440, 1350, 2);

        jSeparator104.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelConhecimentosProfissionais.add(jSeparator104);
        jSeparator104.setBounds(630, 380, 2, 60);

        jLabel86.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel86.setText("Experiência com Doenças, Enfermidades ou Debilidades:");
        panelConhecimentosProfissionais.add(jLabel86);
        jLabel86.setBounds(230, 220, 420, 30);

        jLabel87.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel87.setText("Outros:");
        panelConhecimentosProfissionais.add(jLabel87);
        jLabel87.setBounds(230, 335, 60, 30);

        jLabel88.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel88.setText("Grau de Dependendecia de Cuidados Realizados:");
        panelConhecimentosProfissionais.add(jLabel88);
        jLabel88.setBounds(670, 335, 370, 30);

        jTabbedPane1.addTab("Conhecimentos Profissionais", panelConhecimentosProfissionais);

        panelRefe.setLayout(null);

        jSeparator87.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelRefe.add(jSeparator87);
        jSeparator87.setBounds(-10, 100, 1350, 2);

        jSeparator88.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelRefe.add(jSeparator88);
        jSeparator88.setBounds(-10, 460, 1360, 40);

        jSeparator89.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator89.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelRefe.add(jSeparator89);
        jSeparator89.setBounds(673, 100, 2, 370);

        jSeparator90.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelRefe.add(jSeparator90);
        jSeparator90.setBounds(-10, 145, 1350, 2);

        jSeparator91.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelRefe.add(jSeparator91);
        jSeparator91.setBounds(-10, 600, 1350, 2);

        jLabel63.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 17)); // NOI18N
        jLabel63.setText("Observações sobre Experiência Profissional para o Cargo Pretendido:");
        panelRefe.add(jLabel63);
        jLabel63.setBounds(60, 110, 530, 30);

        jLabel61.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 17)); // NOI18N
        jLabel61.setText("Observações Sobre dois últimos empregos, quanto tempo ficou e por que saiu:");
        panelRefe.add(jLabel61);
        jLabel61.setBounds(700, 110, 610, 30);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        panelRefe.add(jScrollPane2);
        jScrollPane2.setBounds(690, 160, 630, 300);

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setPreferredSize(new java.awt.Dimension(270, 109));
        jScrollPane3.setViewportView(jTextArea3);

        panelRefe.add(jScrollPane3);
        jScrollPane3.setBounds(10, 160, 650, 300);

        jTextField18.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelRefe.add(jTextField18);
        jTextField18.setBounds(310, 510, 400, 30);

        jLabel68.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel68.setText("Nome do Empregador:");
        panelRefe.add(jLabel68);
        jLabel68.setBounds(130, 510, 180, 30);

        jLabel67.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel67.setText("Observações:");
        panelRefe.add(jLabel67);
        jLabel67.setBounds(130, 560, 100, 30);

        jTextField16.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelRefe.add(jTextField16);
        jTextField16.setBounds(240, 560, 950, 30);

        jLabel62.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel62.setText("Telefone:");
        panelRefe.add(jLabel62);
        jLabel62.setBounds(760, 510, 70, 30);

        try {
            txtFild6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild6.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFild6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelRefe.add(txtFild6);
        txtFild6.setBounds(850, 510, 120, 30);

        jLabel66.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel66.setText("Data:");
        panelRefe.add(jLabel66);
        jLabel66.setBounds(1010, 510, 50, 30);

        try {
            txtFild7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFild7.setText("");
        txtFild7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelRefe.add(txtFild7);
        txtFild7.setBounds(1060, 510, 130, 30);

        try {
            txtFild9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFild9.setText("");
        txtFild9.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelRefe.add(txtFild9);
        txtFild9.setBounds(1060, 620, 130, 30);

        jLabel72.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel72.setText("Data:");
        panelRefe.add(jLabel72);
        jLabel72.setBounds(1010, 620, 50, 30);

        try {
            txtFild8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFild8.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFild8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelRefe.add(txtFild8);
        txtFild8.setBounds(850, 620, 120, 30);

        jLabel71.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel71.setText("Telefone:");
        panelRefe.add(jLabel71);
        jLabel71.setBounds(760, 620, 70, 30);

        jTextField20.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelRefe.add(jTextField20);
        jTextField20.setBounds(310, 620, 400, 30);

        jLabel69.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel69.setText("Nome do Empregador:");
        panelRefe.add(jLabel69);
        jLabel69.setBounds(130, 620, 180, 30);

        jLabel70.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel70.setText("Observações:");
        panelRefe.add(jLabel70);
        jLabel70.setBounds(130, 670, 100, 30);

        jTextField19.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        panelRefe.add(jTextField19);
        jTextField19.setBounds(240, 670, 950, 30);

        jTabbedPane1.addTab("Referências Profissionais", panelRefe);

        panelAnexo.setLayout(null);

        jLabel51.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel51.setText("Cópia do CPF:");
        panelAnexo.add(jLabel51);
        jLabel51.setBounds(250, 80, 110, 30);

        jLabel57.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel57.setText("Compovante de Endereço:");
        panelAnexo.add(jLabel57);
        jLabel57.setBounds(160, 130, 200, 30);

        jLabel73.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel73.setText("COREN:");
        panelAnexo.add(jLabel73);
        jLabel73.setBounds(300, 180, 60, 30);

        jLabel74.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel74.setText("Certificado Curso de Cuidadora:");
        panelAnexo.add(jLabel74);
        jLabel74.setBounds(120, 230, 240, 30);

        jLabel75.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel75.setText("Cert. Aux/Téc. Enfermagem:");
        panelAnexo.add(jLabel75);
        jLabel75.setBounds(150, 280, 210, 30);

        jLabel76.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel76.setText("Habilitação:");
        panelAnexo.add(jLabel76);
        jLabel76.setBounds(270, 330, 90, 30);

        jLabel77.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel77.setText("CNPJ:");
        panelAnexo.add(jLabel77);
        jLabel77.setBounds(310, 380, 50, 30);

        jLabel78.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel78.setText("Outros:");
        panelAnexo.add(jLabel78);
        jLabel78.setBounds(300, 430, 60, 30);

        jButton5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton5.setText("Selecionar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton5);
        jButton5.setBounds(960, 30, 110, 30);

        jButton6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton6.setText("Abrir");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton6);
        jButton6.setBounds(1090, 30, 120, 30);

        jButton7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton7.setText("Abrir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton7);
        jButton7.setBounds(1090, 80, 120, 30);

        jButton8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton8.setText("Selecionar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton8);
        jButton8.setBounds(960, 80, 110, 30);

        jButton9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton9.setText("Abrir");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton9);
        jButton9.setBounds(1090, 130, 120, 30);

        jButton10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton10.setText("Selecionar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton10);
        jButton10.setBounds(960, 130, 110, 30);

        jButton11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton11.setText("Abrir");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton11);
        jButton11.setBounds(1090, 180, 120, 30);

        jButton12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton12.setText("Selecionar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton12);
        jButton12.setBounds(960, 180, 110, 30);

        jButton13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton13.setText("Abrir");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton13);
        jButton13.setBounds(1090, 230, 120, 30);

        jButton14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton14.setText("Selecionar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton14);
        jButton14.setBounds(960, 230, 110, 30);

        jButton15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton15.setText("Abrir");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton15);
        jButton15.setBounds(1090, 280, 120, 30);

        jButton16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton16.setText("Selecionar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton16);
        jButton16.setBounds(960, 280, 110, 30);

        jButton17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton17.setText("Abrir");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton17);
        jButton17.setBounds(1090, 330, 120, 30);

        jButton18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton18.setText("Selecionar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton18);
        jButton18.setBounds(960, 330, 110, 30);

        jButton19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton19.setText("Abrir");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton19);
        jButton19.setBounds(1090, 380, 120, 30);

        jButton20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton20.setText("Selecionar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton20);
        jButton20.setBounds(960, 380, 110, 30);

        jButton21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton21.setText("Abrir");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton21);
        jButton21.setBounds(1090, 430, 120, 30);

        jButton22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jButton22.setText("Selecionar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        panelAnexo.add(jButton22);
        jButton22.setBounds(960, 430, 110, 30);

        jLabel80.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel80.setText("Cópia do RG:");
        panelAnexo.add(jLabel80);
        jLabel80.setBounds(250, 30, 100, 30);

        jTextField21.setEditable(false);
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField21.setFocusable(false);
        panelAnexo.add(jTextField21);
        jTextField21.setBounds(360, 30, 590, 30);

        jTextField22.setEditable(false);
        jTextField22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelAnexo.add(jTextField22);
        jTextField22.setBounds(360, 80, 590, 30);

        jTextField23.setEditable(false);
        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelAnexo.add(jTextField23);
        jTextField23.setBounds(360, 130, 590, 30);

        jTextField24.setEditable(false);
        jTextField24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelAnexo.add(jTextField24);
        jTextField24.setBounds(360, 180, 590, 30);

        jTextField25.setEditable(false);
        jTextField25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelAnexo.add(jTextField25);
        jTextField25.setBounds(360, 230, 590, 30);

        jTextField26.setEditable(false);
        jTextField26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelAnexo.add(jTextField26);
        jTextField26.setBounds(360, 280, 590, 30);

        jTextField27.setEditable(false);
        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelAnexo.add(jTextField27);
        jTextField27.setBounds(360, 330, 590, 30);

        jTextField28.setEditable(false);
        jTextField28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelAnexo.add(jTextField28);
        jTextField28.setBounds(360, 380, 590, 30);

        jTextField29.setEditable(false);
        jTextField29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelAnexo.add(jTextField29);
        jTextField29.setBounds(360, 430, 590, 30);

        jLabel82.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel82.setText("CONSIDERAÇÕES FINAIS");
        panelAnexo.add(jLabel82);
        jLabel82.setBounds(590, 497, 210, 30);

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        panelAnexo.add(jScrollPane4);
        jScrollPane4.setBounds(26, 546, 1270, 130);

        jSeparator23.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        panelAnexo.add(jSeparator23);
        jSeparator23.setBounds(0, 500, 1360, 30);

        jTabbedPane1.addTab("Documentos em Anexo / Considerações Finais", panelAnexo);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1350, 750);

        setBounds(0, 0, 1350, 776);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRadMEIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadMEIActionPerformed
        if(btnRadMEI.isSelected()){
            lblCNPJ.setEnabled(true);
            txtCNPJ.setEnabled(true);
        }else if(btnRadMEI.isSelected() == false){
            lblCNPJ.setEnabled(false);
            txtCNPJ.setEnabled(false);
        }
    }//GEN-LAST:event_btnRadMEIActionPerformed

    private void radFilhoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radFilhoNaoActionPerformed
        if(radFilhoNao.isSelected()){
            radMaior.setEnabled(false);
            radMenor.setEnabled(false);
            txtNumFilhos.setEnabled(false);
        }
    }//GEN-LAST:event_radFilhoNaoActionPerformed

    private void radFilhoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radFilhoSimActionPerformed
        if(radFilhoSim.isSelected()){
            radMaior.setEnabled(true);
            radMenor.setEnabled(true);
            txtNumFilhos.setEnabled(true);
        }
    }//GEN-LAST:event_radFilhoSimActionPerformed

    private void btnSelecionarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarFotoActionPerformed
        int returnVal = jFileChooser1.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = jFileChooser1.getSelectedFile();
            try{
                BufferedImage image = ImageIO.read(file);
                ImageIcon icon = new ImageIcon(image);
                Image foto = icon.getImage();
                Image fotoResize = foto.getScaledInstance(lblFoto.getWidth(),lblFoto.getHeight(),java.awt.Image.SCALE_SMOOTH );                
                icon.setImage(fotoResize);
                lblFoto.setIcon(icon);
            }catch(IOException ex){
                System.out.println("Problemas para acessar a imagem" + file.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_btnSelecionarFotoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //ImageIcon fotoResize = new ImageIcon("JulianaCad/images/PlaceHolderResize.jpg");
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PlaceholderResize.jpg")));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton15ActionPerformed
        if(jRadioButton15.isSelected()){
            txtAlergia.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton15ActionPerformed

    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        if(jRadioButton14.isSelected()){
            txtAlergia.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void jRadioButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton35ActionPerformed
        if(jRadioButton35.isSelected()){
            jComboBox4.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton35ActionPerformed

    private void jRadioButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton34ActionPerformed
        if(jRadioButton34.isSelected()){
            jComboBox4.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton34ActionPerformed

    private void jRadioButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton40ActionPerformed
        if(jRadioButton40.isSelected()){
            lblQual.setEnabled(false);
            jTextField12.setEnabled(false);
            lblCertificado.setEnabled(false);
            btnRadNaoCertificado.setEnabled(false);
            btnRadSimCertificado.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton40ActionPerformed

    private void jRadioButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton41ActionPerformed
        if(jRadioButton41.isSelected()){
            lblQual.setEnabled(true);
            jTextField12.setEnabled(true);
            lblCertificado.setEnabled(true);
            btnRadNaoCertificado.setEnabled(true);
            btnRadSimCertificado.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton41ActionPerformed

    private void jRadioButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton48ActionPerformed
        if(jRadioButton48.isSelected()){
            jCheckBox16.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton48ActionPerformed

    private void jRadioButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton49ActionPerformed
        if(jRadioButton49.isSelected()){
            jCheckBox16.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_jRadioButton49ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField21);
         
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField22);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField23);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField24);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField25);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField26);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField27);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
       Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField29);
        
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        Utilitario seletor = new Utilitario();
        seletor.selecionarArquivo(seletorDocumentosEmAnexo, jTextField28);
        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
               
        Utilitario.abrirArquivo(jTextField21); 
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
        Utilitario.abrirArquivo(jTextField22);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
        Utilitario.abrirArquivo(jTextField23);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
        Utilitario.abrirArquivo(jTextField24);
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       
        Utilitario.abrirArquivo(jTextField25);
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        
        Utilitario.abrirArquivo(jTextField26);
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
       
        Utilitario.abrirArquivo(jTextField27);
        
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
       
        Utilitario.abrirArquivo(jTextField28);
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        
        Utilitario.abrirArquivo(jTextField29);
        
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jRadioButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton44ActionPerformed
        if(jRadioButton44.isSelected()){
            lblInscricao.setEnabled(false);
            txtInscricao.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton44ActionPerformed

    private void jRadioButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton45ActionPerformed
        if(jRadioButton45.isSelected()){
            lblInscricao.setEnabled(true);
            txtInscricao.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton45ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CadastroCuidadoraDAO  alt = new CadastroCuidadoraDAO();
        Cuidadora c = new Cuidadora();
        if(jRadioButton3.isSelected()){
            c.setTipoCuidadora(1);
        }else if(jRadioButton1.isSelected()){
            c.setTipoCuidadora(2);
        }else if(jRadioButton2.isSelected()){
            c.setTipoCuidadora(3);
        }
        
        //get o tem_mei
        
        if(btnRadMEI.isSelected()){
            c.setTemMei(1);
        }else{
            c.setTemMei(0); 
        }
        
        //cnpj
        
        if(btnRadMEI.isSelected() && txtCNPJ.isEnabled()){
            c.setCnpj(txtCNPJ.getText());
        }else{
            c.setCnpj("");
        }
        
        //nome
        c.setNome(jTextField10.getText());
        
        //numero_rg
        c.setNumeroRg(jTextField30.getText());
        
        //cpf
        c.setCpf(txtFild3.getText());
        
        //idade
        c.setIdade(txtFild10.getText());
        
       
        
        
        
        //altura
        c.setAltura(jTextField2.getText());
        
        //peso
        c.setPeso(jTextField7.getText());
        
        //cor da pele
        c.setCorPeleIndex(jComboBox3.getSelectedIndex());
        
        //regiao
        int ind = jComboBox7.getSelectedIndex();
        c.setRegiaoListaIndex(ind);
        
        //estado civil
        c.setEstadoCivilIndex(jComboBox2.getSelectedIndex());
        
        //filhos sim nao
        if(radFilhoSim.isSelected()){
            c.setFilhosSimNao(1);
        }else if(radFilhoNao.isSelected()){
            c.setFilhosSimNao(2);
        }
        
        //filhos menor maior
        if(radFilhoSim.isSelected() && radMaior.isSelected()){
            c.setFilhoMaiorMenor(1);
        } else if(radFilhoSim.isSelected() && radMenor.isSelected()){
            c.setFilhoMaiorMenor(2);
        }
        
        //campo maior
        if(radMenor.isSelected()){
            c.setCampoMenor(txtNumFilhos.getText());
        }
        
        //cnh sim nao
        if(jRadioButton4.isSelected()){
            c.setCnhSimNao(1);
        }else if(jRadioButton5.isSelected()){
            c.setCnhSimNao(2);
        }
        
        //possui carro
        if(jRadioButton7.isSelected()){
            c.setPossuiCarroSimNao(1);
        }else if(jRadioButton6.isSelected()){
            c.setPossuiCarroSimNao(2);
        }
        
        //endereco
        c.setEndereco(jTextField11.getText());
        
        //numero endereco
        c.setNumeroEndereco(jTextField8.getText());
        
        //endereco cep
        c.setCepEndereco(txtFild4.getText());
        
        //uf index
        c.setUfListaIndex(jComboBox1.getSelectedIndex());
        
        //bairro endereco
        c.setBairroEndereco(jTextField9.getText());
        
        //cidade endereço
        c.setCidade(jTextField4.getText());
        
        //telefone reseidencial
        c.setTelefoneResidencialCuidadora(txtFild5.getText());
        
        //telefone celular
        c.setTelefoneCelularCuidadora(txtFild2.getText());
        
        //whatsapp sim nao
        if(jRadioButton8.isSelected()){
            c.setWhatsappSimNao(1);
        }else if(jRadioButton9.isSelected()){
            c.setWhatsappSimNao(2);
        }
        
        //religiao
        c.setReligiaoIndex(jComboBox5.getSelectedIndex());
        
        //fumante sim nao
        if(jRadioButton10.isSelected()){
            c.setFumanteSimNao(1);
        }else if(jRadioButton11.isSelected()){
            c.setFumanteSimNao(2);
        }
        
        //grau escolar
        c.setGrauEscolarIndex(jComboBox6.getSelectedIndex());
        
        //curso superior
        c.setCursoSuperior(jTextField5.getText());
        
        //gosta de animais
        if(jRadioButton13.isSelected()){
            c.setGostaAnimalSimNao(1);
        }else if(jRadioButton12.isSelected()){
            c.setGostaAnimalSimNao(2);
        }
        
        //alergias
        if(jRadioButton14.isSelected()){
            c.setAlergiaSimNao(1);
        }else if(jRadioButton15.isSelected()){
            c.setAlergiaSimNao(2);
        }
        
        //qual alergia
        if(jRadioButton14.isSelected()){
            c.setQualAlergia(txtAlergia.getText());
        }
        
        //registro CLT
        if(jRadioButton17.isSelected()){
            c.setRegistroCLTSimNao(1);
        }else if(jRadioButton16.isSelected()){
            c.setRegistroCLTSimNao(2);
        }
        
        //covenio medico
        if(jRadioButton19.isSelected()){
            c.setConvenioMedicoSimNao(1);
        }else if(jRadioButton18.isSelected()){
            c.setConvenioMedicoSimNao(2);
        }
        
        //habilidades
        c.setHabilidades(jTextField15.getText());
        
        //diponibilidade para viajar
        if(jRadioButton21.isSelected()){
            c.setDisponivelViagemSimNao(1);
        }else if(jRadioButton20.isSelected()){
            c.setDisponivelViagemSimNao(2);
        }
        
        //Cozinha sim nao
        if(jRadioButton23.isSelected()){
            c.setCozinhaSimNao(1);
        }else if(jRadioButton22.isSelected()){
            c.setCozinhaSimNao(HEIGHT);
        }
        
        //prefere homem ou mulher          ----          homem = 1 ; mulher = 2 ; Os dois marcados 3
        if(jCheckBox1.isSelected() && jCheckBox2.isSelected()){
            c.setPrefereHouM(3);
        }else if(jCheckBox2.isSelected()){
            c.setPrefereHouM(2);
        }else if(jCheckBox1.isSelected()){
            c.setPrefereHouM(1);
        }    
        
        //pressão alta sim nao
        if(jRadioButton27.isSelected()){
            c.setPressaoAltaSimNao(1);
        }else if(jRadioButton26.isSelected()){
            c.setPressaoAltaSimNao(2);
        }
        
        
        //diabetes sim nao
        if(jRadioButton28.isSelected()){
            c.setDiabeteSimNao(1);
        }else if(jRadioButton29.isSelected()){
            c.setDiabeteSimNao(2);
        }
        
        
        //tratamento medico
        c.setTratamentoMedico(jTextField13.getText());
        
        
        //dormir no trabalho sim nao
        if(jRadioButton31.isSelected()){
            c.setDormirTrabalhoSimNao(1);
        }else if(jRadioButton30.isSelected()){
            c.setDormirTrabalhoSimNao(2);
        }
        
     
        
        //escala 24 24
        if(jRadioButton33.isSelected()){
            c.setEscala2424SimNao(1);
        }else if(jRadioButton32.isSelected()){
            c.setEscala2424SimNao(2);
        }
        
        
        //Escala 1236
        if(jRadioButton35.isSelected()){
            c.setEscala1236SimNao(1);
        }else if(jRadioButton34.isSelected()){
            c.setEscala1236SimNao(2);
        }
        
        
        //Turno indice
        if(jRadioButton35.isSelected() && jComboBox4.isEnabled()){
            c.setDiurnoIndex(jComboBox4.getSelectedIndex());
        }
        
        
        //somente segunda a sex
        if(jCheckBox3.isSelected()){
            c.setSomenteSegASex(1);
        }
        
        
        //folguista FDS sim nao
        if(jRadioButton37.isSelected()){
            c.setFolguistaFdsSimNao(1);
        }else if(jRadioButton36.isSelected()){
            c.setFolguistaFdsSimNao(2);
        }
        
        
        //integral sab dom, sim nao
        if(jRadioButton39.isSelected()){
            c.setIntegralFdsSimNao(1);
        }else if(jRadioButton38.isSelected()){
            c.setIntegralFdsSimNao(2);
        }
        
        //pretenção salarial
        c.setPretencaoSalarial(txtFild.getText());
        
        //observaçoes
        c.setObservacoes(jTextArea1.getText());
        
        //FIM DA PRIMEIRA ABA
        
        //tem curso cuidadora
        if(jRadioButton41.isSelected()){
            c.setTemCursoCuidadora(1);
        }else if(jRadioButton40.isSelected()){
            
        }
        
        //qual curso
        if(jRadioButton41.isSelected() && jTextField12.isEnabled()){
            c.setQualCursoCuidadora(jTextField12.getText());
        }
        
        //tem cerifidao
        if(jRadioButton41.isSelected() && btnRadSimCertificado.isSelected()){
            c.setTemCertificadoSimNao(1);
        }else if(jRadioButton41.isSelected() && btnRadNaoCertificado.isSelected()){
            c.setTemCertificadoSimNao(2);
        }
        
        //conren atinvo
        if(jRadioButton45.isSelected()){
            c.setCorenAtivoSimNao(1);
        }else if(jRadioButton44.isSelected()){
            c.setCorenAtivoSimNao(PROPERTIES);
        }
        
        //campo de inscrição coren
        if(jRadioButton45.isSelected()){
            c.setInscricaoCoren(txtInscricao.getText());
        }
        
        //como adquiriu conhecimento pratica curso               pratica = 1 ; curso = 2 ; os dois = 3
        if(jCheckBox4.isSelected() && jCheckBox5.isSelected()){
            c.setComoAdiquiriuConhecimentoPraCur(3);
        }else if(jCheckBox4.isSelected()){
            c.setComoAdiquiriuConhecimentoPraCur(1);
        }else if(jCheckBox5.isSelected()){
            c.setComoAdiquiriuConhecimentoPraCur(2);
        }
        
        //saber aferir dados vitais
        
        /* 
        jCheckBox6 = 3(E)   jCheckBox7 = 7(M)   jCheckBox8 = 9(O)  jCheckBox9 = 11(P)
        
        E= 3  M = 7  O = 9  P = 11  
        
        3,7,9,11 = 30 --
        3,7,9 = 19 --
        3,7,11 = 21 --
        3,11,9 = 23 -- 
        11,7,9 = 27--
        3,7 = 10--
        3,9 = 12--
        3,11 = 14--
        7,9 = 16--
        7,11 = 18--
        9,11 = 20
        3 = 3
        7 = 7
        9 = 9
        11 = 
        */
        
        if(jCheckBox6.isSelected() && jCheckBox7.isSelected() && jCheckBox8.isSelected() && jCheckBox9.isSelected()){//ok{
            c.setAferirSinaisVitais(30);
        }else if(jCheckBox6.isSelected() && jCheckBox7.isSelected() && jCheckBox8.isSelected()){ //ok
            c.setAferirSinaisVitais(19);
        }else if(jCheckBox6.isSelected() && jCheckBox7.isSelected() && jCheckBox9.isSelected()){ //ok
            c.setAferirSinaisVitais(21);
        }else if(jCheckBox6.isSelected() && jCheckBox9.isSelected() && jCheckBox8.isSelected()){
            c.setAferirSinaisVitais(23);
        }else if(jCheckBox9.isSelected() && jCheckBox7.isSelected() && jCheckBox8.isSelected()){
            c.setAferirSinaisVitais(27);
        }else if(jCheckBox6.isSelected() && jCheckBox7.isSelected()){
            c.setAferirSinaisVitais(10);
        }else if(jCheckBox6.isSelected() && jCheckBox8.isSelected()){
            c.setAferirSinaisVitais(12);
        }else if(jCheckBox6.isSelected() && jCheckBox9.isSelected()){
            c.setAferirSinaisVitais(14);
        }else if(jCheckBox7.isSelected() && jCheckBox8.isSelected()){
            c.setAferirSinaisVitais(16);
        }else if(jCheckBox7.isSelected() && jCheckBox9.isSelected()){
            c.setAferirSinaisVitais(18);
        }else if(jCheckBox8.isSelected() && jCheckBox9.isSelected()){
            c.setAferirSinaisVitais(20);
        }else if(jCheckBox6.isSelected()){
            c.setAferirSinaisVitais(3);
        }else if(jCheckBox7.isSelected()){
            c.setAferirSinaisVitais(7);
        }else if(jCheckBox8.isSelected()){
            c.setAferirSinaisVitais(9);
        }else if(jCheckBox9.isSelected()){
            c.setAferirSinaisVitais(11);
        }
        
        //trabalha com sonda sim nao
        if(jRadioButton46.isSelected()){
            c.setTrabalhaSondaSimNao(1);
        }else if(jRadioButton47.isSelected()){
            c.setTrabalhaSondaSimNao(2);
        }
        
        //qual sonda
        
        c.setQualSonda(txtQualBolsa.getText());
        
        
        //trabalha com bolsa
        if(jRadioButton49.isSelected()){
            c.setTrabalhaBolsaSimNao(1);
        }else if(jRadioButton48.isSelected()){
            c.setTrabalhaBolsaSimNao(2);
        }
        
        //colostomia
        if(jCheckBox16.isSelected()){
            c.setColostomia(1);
        }else if(!(jCheckBox16.isSelected())){
            c.setColostomia(0);
        }
        
        
        //grau dependeincia
        c.setGrauDependencia(jTextField17.getText());
        
        //endermidades ALZEIMER
        if(jCheckBox10.isSelected()){
            c.setEnfermidadeAlze(1);
        }
        
        //enfermidade parkinson
        if(jCheckBox11.isSelected()){
            c.setEnfermidadeParkin(1);
        }
        
        //enfetmidade esquizofrenia
        if(jCheckBox12.isSelected()){
            c.setEnfermidadeEsquizo(1);
        }
        
        //enfermidade demencia
        if(jCheckBox13.isSelected()){
            c.setEnfermidadeDeme(1);
        }
        
        //enfermidade avc
        if(jCheckBox14.isSelected()){
            c.setEnfermidadeAvc(1);
        }
        
        //enfermidade cancer
        if(jCheckBox15.isSelected()){
            c.setEnfermidadeCancer(1);
        }
        
        //obsercacoes profissional
        c.setObservacoesProfissional(jTextArea3.getText());
        
        //obersa ultimo empregos
        c.setObervacoesUltimosEmpregos(jTextArea2.getText());
        
        //nome empregador 1
        c.setNomeEmpregador1(jTextField18.getText());
        
        //telefone empregador 1
        c.setTelefoneEmpregador1(txtFild6.getText());
        
        //data empregador 1
        c.setDataEmpregador1(txtFild7.getText());
        
        //obs empregador 1
        c.setObservacoresEmpregador1(jTextField16.getText());
        
        //nome empregador 2
        c.setNomeEmpregador2(jTextField20.getText());
        
        //telefone empregador 2
        c.setTelefoneEmpregador2(txtFild8.getText());
        
        //data empregador 2
        c.setDataEmpregador2(txtFild9.getText());
        
        //observacoes empreador 2
        c.setObservacoresEmpregador2(jTextField19.getText());
        
        //caminho arquivo certificado_cuidadora
        c.setRgArquivo(jTextField21.getText());
        
        //Caminho arquivo cpf
        c.setCpfArquivo(jTextField22.getText());
        
        //Caminho arquivo endereco
        c.setEnderecoArquivo(jTextField23.getText());
        
        //Caminho arquivo coren
        c.setConrenArquivo(jTextField24.getText());
        
        //Caminho arquivo certificado cuidadora
        c.setCertificadoCuidadoraArquivo(jTextField25.getText());
        
        //Caminho arquivo certificado enfermagem
        c.setCertificadoEnfermagemArquivo(jTextField26.getText());
        
        //Caminho arquivo cnh
        c.setCnhArquivo(jTextField27.getText());
        
        //Caminho arquivo cnpj
        c.setCnpjArquivo(jTextField28.getText());
        
        //Caminho arquivo outros
        c.setOutrosArquivo(jTextField29.getText());

        //Considerações
        c.setConsidecoes(jTextArea4.getText());
        
        //curso enfermagem tec
        if(jCheckBox18.isSelected()){
            c.setCursoEnferTecnico(1);
        }else{
            c.setCursoEnferTecnico(0);
        }
        
        //curso enfermagem auz
        if(jCheckBox19.isSelected()){
            c.setCursoEnferAux(1);
        }else{
            c.setCursoEnferTecnico(0);
        }
        
        //banho no leito
        if(jRadioButton51.isSelected()){
            c.setBanhoSimNao(1);
        }else if(jRadioButton50.isSelected()){
            c.setBanhoSimNao(2);
        }
        
        //tratamento de escarras
        if(jRadioButton53.isSelected()){
            c.setEscarrasSimNao(1);
        }else if(jRadioButton52.isSelected()){
            c.setEscarrasSimNao(2);
        }
        
        //cadeirante
        if(jRadioButton55.isSelected()){
            c.setCadeiranteSimNao(1);
        }else if(jRadioButton54.isSelected()){
            c.setCadeiranteSimNao(2);
        }
        
        //outras doenças
        c.setOutrasDoencas(jTextField31.getText());
        
        
        c.setIdCuidadora(idRefe2);
        
        //foto
        String nome = jTextField10.getText();
        String destino1 = "\\Cadastros de Cuidadoras\\" + nome + "\\Foto " + nome + ".jpg";
        File arq = new File(destino1);
        arq.delete();
        
        if(jFileChooser1.getSelectedFile() != null){
            File file = jFileChooser1.getSelectedFile();
            String caminho = file.getAbsolutePath();
           
            File diretorio = new File("\\Cadastros de Cuidadoras\\" + nome);
            if(diretorio.exists()){
                
                File antigo = new File(destino1);
                if(antigo.exists()){
                    antigo.delete();
            
                }
                File origem =  jFileChooser1.getSelectedFile().getAbsoluteFile();
                
                try {
                
                FileInputStream streamInDe = new FileInputStream(origem);
                FileOutputStream streamOutPara = new FileOutputStream(destino1);
                
                FileChannel canalPara = streamInDe.getChannel();
                FileChannel canalDe = streamOutPara.getChannel();
                
                if(canalPara.transferTo(0, canalPara.size(), canalDe) == 0L){
                    canalPara.close();
                    canalDe.close();
                }
                } catch (FileNotFoundException ex) {
                Logger.getLogger(CadastroCuidadora.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(CadastroCuidadora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
            
             c.setCaminhoFoto(destino1);
        }else{
            c.setCaminhoFoto(caminho2);
        }
  
        alt.alterarDados(c);
        
        this.dispose();
        
//marca
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton46ActionPerformed
        if(jRadioButton46.isSelected()){
            lblQualBolsa.setEnabled(true);
            txtQualBolsa.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton46ActionPerformed

    private void jRadioButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton47ActionPerformed
       if(jRadioButton47.isSelected()){
        lblQualBolsa.setEnabled(false);
       txtQualBolsa.setEnabled(false);
       }
    }//GEN-LAST:event_jRadioButton47ActionPerformed

    private void jRadioButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton51ActionPerformed
        if(jRadioButton41.isSelected()){
            lblQual.setEnabled(true);
            jTextField12.setEnabled(true);
            lblCertificado.setEnabled(true);
            btnRadNaoCertificado.setEnabled(true);
            btnRadSimCertificado.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton51ActionPerformed

    private void jRadioButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton50ActionPerformed
        if(jRadioButton40.isSelected()){
            lblQual.setEnabled(false);
            jTextField12.setEnabled(false);
            lblCertificado.setEnabled(false);
            btnRadNaoCertificado.setEnabled(false);
            btnRadSimCertificado.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton50ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrupoAlergia;
    private javax.swing.ButtonGroup btnGrupoBanho;
    private javax.swing.ButtonGroup btnGrupoBolsa;
    private javax.swing.ButtonGroup btnGrupoCNH;
    private javax.swing.ButtonGroup btnGrupoCadeirante;
    private javax.swing.ButtonGroup btnGrupoCertificado;
    private javax.swing.ButtonGroup btnGrupoConvenio;
    private javax.swing.ButtonGroup btnGrupoCorenAtivo;
    private javax.swing.ButtonGroup btnGrupoCozinha;
    private javax.swing.ButtonGroup btnGrupoCursoCuidadora;
    private javax.swing.ButtonGroup btnGrupoDiabetes;
    private javax.swing.ButtonGroup btnGrupoDormir;
    private javax.swing.ButtonGroup btnGrupoEscala1236;
    private javax.swing.ButtonGroup btnGrupoEscala2424;
    private javax.swing.ButtonGroup btnGrupoEscarras;
    private javax.swing.ButtonGroup btnGrupoFilhos;
    private javax.swing.ButtonGroup btnGrupoFolguistaFinalDeSemana;
    private javax.swing.ButtonGroup btnGrupoFuma;
    private javax.swing.ButtonGroup btnGrupoGostaAnimal;
    private javax.swing.ButtonGroup btnGrupoIntegralSabadoDomingo;
    private javax.swing.ButtonGroup btnGrupoMaiorMenor;
    private javax.swing.ButtonGroup btnGrupoPressao;
    private javax.swing.ButtonGroup btnGrupoRegistroCLT;
    private javax.swing.ButtonGroup btnGrupoSonda;
    private javax.swing.ButtonGroup btnGrupoTemCarro;
    private javax.swing.ButtonGroup btnGrupoTipoDeCuidadora;
    private javax.swing.ButtonGroup btnGrupoViagem;
    private javax.swing.ButtonGroup btnGrupoWhats;
    private javax.swing.JRadioButton btnRadMEI;
    private javax.swing.JRadioButton btnRadNaoCertificado;
    private javax.swing.JRadioButton btnRadSimCertificado;
    private javax.swing.JButton btnSelecionarFoto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JFileChooser jFileChooser1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JRadioButton jRadioButton39;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton40;
    private javax.swing.JRadioButton jRadioButton41;
    private javax.swing.JRadioButton jRadioButton44;
    private javax.swing.JRadioButton jRadioButton45;
    private javax.swing.JRadioButton jRadioButton46;
    private javax.swing.JRadioButton jRadioButton47;
    private javax.swing.JRadioButton jRadioButton48;
    private javax.swing.JRadioButton jRadioButton49;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton50;
    private javax.swing.JRadioButton jRadioButton51;
    private javax.swing.JRadioButton jRadioButton52;
    private javax.swing.JRadioButton jRadioButton53;
    private javax.swing.JRadioButton jRadioButton54;
    private javax.swing.JRadioButton jRadioButton55;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator100;
    private javax.swing.JSeparator jSeparator101;
    private javax.swing.JSeparator jSeparator102;
    private javax.swing.JSeparator jSeparator103;
    private javax.swing.JSeparator jSeparator104;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator48;
    private javax.swing.JSeparator jSeparator49;
    private javax.swing.JSeparator jSeparator50;
    private javax.swing.JSeparator jSeparator51;
    private javax.swing.JSeparator jSeparator52;
    private javax.swing.JSeparator jSeparator53;
    private javax.swing.JSeparator jSeparator54;
    private javax.swing.JSeparator jSeparator55;
    private javax.swing.JSeparator jSeparator56;
    private javax.swing.JSeparator jSeparator57;
    private javax.swing.JSeparator jSeparator58;
    private javax.swing.JSeparator jSeparator59;
    private javax.swing.JSeparator jSeparator60;
    private javax.swing.JSeparator jSeparator61;
    private javax.swing.JSeparator jSeparator62;
    private javax.swing.JSeparator jSeparator63;
    private javax.swing.JSeparator jSeparator64;
    private javax.swing.JSeparator jSeparator65;
    private javax.swing.JSeparator jSeparator66;
    private javax.swing.JSeparator jSeparator67;
    private javax.swing.JSeparator jSeparator68;
    private javax.swing.JSeparator jSeparator69;
    private javax.swing.JSeparator jSeparator70;
    private javax.swing.JSeparator jSeparator71;
    private javax.swing.JSeparator jSeparator72;
    private javax.swing.JSeparator jSeparator73;
    private javax.swing.JSeparator jSeparator74;
    private javax.swing.JSeparator jSeparator75;
    private javax.swing.JSeparator jSeparator76;
    private javax.swing.JSeparator jSeparator77;
    private javax.swing.JSeparator jSeparator78;
    private javax.swing.JSeparator jSeparator79;
    private javax.swing.JSeparator jSeparator80;
    private javax.swing.JSeparator jSeparator81;
    private javax.swing.JSeparator jSeparator82;
    private javax.swing.JSeparator jSeparator83;
    private javax.swing.JSeparator jSeparator84;
    private javax.swing.JSeparator jSeparator85;
    private javax.swing.JSeparator jSeparator86;
    private javax.swing.JSeparator jSeparator87;
    private javax.swing.JSeparator jSeparator88;
    private javax.swing.JSeparator jSeparator89;
    private javax.swing.JSeparator jSeparator90;
    private javax.swing.JSeparator jSeparator91;
    private javax.swing.JSeparator jSeparator92;
    private javax.swing.JSeparator jSeparator93;
    private javax.swing.JSeparator jSeparator94;
    private javax.swing.JSeparator jSeparator95;
    private javax.swing.JSeparator jSeparator96;
    private javax.swing.JSeparator jSeparator97;
    private javax.swing.JSeparator jSeparator98;
    private javax.swing.JSeparator jSeparator99;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JLabel lblCertificado;
    private javax.swing.JLabel lblCoren;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblInscricao;
    private javax.swing.JLabel lblQual;
    private javax.swing.JLabel lblQualBolsa;
    private javax.swing.JPanel panelAnexo;
    private javax.swing.JPanel panelConhecimentosProfissionais;
    private javax.swing.JPanel panelDadosPessoais;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelRefe;
    private javax.swing.JRadioButton radFilhoNao;
    private javax.swing.JRadioButton radFilhoSim;
    private javax.swing.JRadioButton radMaior;
    private javax.swing.JRadioButton radMenor;
    private javax.swing.JFileChooser seletorDocumentosEmAnexo;
    private javax.swing.JTextField txtAlergia;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtFild;
    private javax.swing.JFormattedTextField txtFild10;
    private javax.swing.JFormattedTextField txtFild2;
    private javax.swing.JFormattedTextField txtFild3;
    private javax.swing.JFormattedTextField txtFild4;
    private javax.swing.JFormattedTextField txtFild5;
    private javax.swing.JFormattedTextField txtFild6;
    private javax.swing.JFormattedTextField txtFild7;
    private javax.swing.JFormattedTextField txtFild8;
    private javax.swing.JFormattedTextField txtFild9;
    private javax.swing.JTextField txtInscricao;
    private javax.swing.JTextField txtNumFilhos;
    private javax.swing.JTextField txtQualBolsa;
    // End of variables declaration//GEN-END:variables
}
