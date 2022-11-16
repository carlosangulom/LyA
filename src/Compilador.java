
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author yisus
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens1;
    private ArrayList<Token> tokens2;
    private ArrayList<Token> tokens3;
    private ArrayList<Token> tokens4;
    private ArrayList<String> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private HashMap<String, String> identificadoresTV;
    private boolean codeHasBeenCompiled = false;
    private int cont = 0;
    private ArrayList<Producciones> PD1;
    private Automatas a = new Automatas();
    private Producciones PD2;
    
    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Pastillitas";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".pill");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        labelTextSize.setText("Tamaño: " + jtpCode.getFont().getSize());
        labelTextSizeConsole.setText("Tamaño: " + jtpCode.getFont().getSize());
        //Functions.setLineNumberOnJTextComponent(jtpCode);
        Functions.setLineNumberOnJTextComponent(jtpCode, WIDTH, new Color(243, 139, 168));
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();

            int posicion = jtpCode.getCaretPosition();
            jtpCode.setText(jtpCode.getText().replaceAll("[\r]+", ""));
            jtpCode.setCaretPosition(posicion);

            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        a.setLocationRelativeTo(this);
        tokens1 = new ArrayList<>();
        tokens2 = new ArrayList<>();
        tokens3 = new ArrayList<>();
        tokens4 = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        identificadoresTV = new HashMap<>();
        PD1 = new ArrayList<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        JTableHeader tblHeader = tblTokens.getTableHeader();
        tblHeader.setBackground(Color.decode("#24273a"));
        tblHeader.setForeground(Color.decode("#cad3f5"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        panelButtonTextSize = new javax.swing.JPanel();
        btnTextEditorMinus = new javax.swing.JButton();
        btnTextEditorPlus = new javax.swing.JButton();
        labelTextSize = new java.awt.Label();
        panelButtonTextSize1 = new javax.swing.JPanel();
        btnConsoleMinus = new javax.swing.JButton();
        btnConsolePlus = new javax.swing.JButton();
        labelTextSizeConsole = new java.awt.Label();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        CL1 = new javax.swing.JMenuItem();
        CL2 = new javax.swing.JMenuItem();
        CL3 = new javax.swing.JMenuItem();
        CL4 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(24, 25, 38));

        buttonsFilePanel.setBackground(new java.awt.Color(24, 25, 38));

        btnAbrir.setBackground(new java.awt.Color(49, 50, 68));
        btnAbrir.setForeground(new java.awt.Color(186, 194, 222));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abrir.png"))); // NOI18N
        btnAbrir.setToolTipText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(49, 50, 68));
        btnNuevo.setForeground(new java.awt.Color(186, 194, 222));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setFocusPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(49, 50, 68));
        btnGuardar.setForeground(new java.awt.Color(186, 194, 222));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setBackground(new java.awt.Color(49, 50, 68));
        btnGuardarC.setForeground(new java.awt.Color(186, 194, 222));
        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar_como.png"))); // NOI18N
        btnGuardarC.setToolTipText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpCode.setBackground(new java.awt.Color(30, 32, 48));
        jtpCode.setForeground(new java.awt.Color(202, 211, 245));
        jtpCode.setCaretColor(new java.awt.Color(202, 211, 245));
        jScrollPane1.setViewportView(jtpCode);

        panelButtonCompilerExecute.setBackground(new java.awt.Color(24, 25, 38));

        btnCompilar.setBackground(new java.awt.Color(49, 50, 68));
        btnCompilar.setForeground(new java.awt.Color(186, 194, 222));
        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compile.png"))); // NOI18N
        btnCompilar.setToolTipText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setBackground(new java.awt.Color(49, 50, 68));
        btnEjecutar.setForeground(new java.awt.Color(186, 194, 222));
        btnEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ejecutar.png"))); // NOI18N
        btnEjecutar.setToolTipText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(30, 32, 48));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setForeground(new java.awt.Color(202, 211, 245));
        jtaOutputConsole.setRows(5);
        jtaOutputConsole.setFocusable(false);
        jtaOutputConsole.setHighlighter(null);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setBackground(new java.awt.Color(30, 32, 48));
        tblTokens.setForeground(new java.awt.Color(202, 211, 245));
        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.setGridColor(new java.awt.Color(54, 58, 79));
        tblTokens.setSelectionBackground(new java.awt.Color(147, 154, 183));
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        panelButtonTextSize.setBackground(new java.awt.Color(24, 25, 38));

        btnTextEditorMinus.setBackground(new java.awt.Color(49, 50, 68));
        btnTextEditorMinus.setForeground(new java.awt.Color(186, 194, 222));
        btnTextEditorMinus.setText("-");
        btnTextEditorMinus.setToolTipText("Texto mas chico");
        btnTextEditorMinus.setFocusPainted(false);
        btnTextEditorMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTextEditorMinusActionPerformed(evt);
            }
        });

        btnTextEditorPlus.setBackground(new java.awt.Color(49, 50, 68));
        btnTextEditorPlus.setForeground(new java.awt.Color(186, 194, 222));
        btnTextEditorPlus.setText("+");
        btnTextEditorPlus.setToolTipText("Texto mas grande");
        btnTextEditorPlus.setFocusPainted(false);
        btnTextEditorPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTextEditorPlusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonTextSizeLayout = new javax.swing.GroupLayout(panelButtonTextSize);
        panelButtonTextSize.setLayout(panelButtonTextSizeLayout);
        panelButtonTextSizeLayout.setHorizontalGroup(
            panelButtonTextSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonTextSizeLayout.createSequentialGroup()
                .addComponent(btnTextEditorMinus, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTextEditorPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelButtonTextSizeLayout.setVerticalGroup(
            panelButtonTextSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonTextSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonTextSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTextEditorPlus, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnTextEditorMinus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        labelTextSize.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTextSize.setForeground(new java.awt.Color(186, 194, 222));
        labelTextSize.setText("Tamaño: ");

        panelButtonTextSize1.setBackground(new java.awt.Color(24, 25, 38));

        btnConsoleMinus.setBackground(new java.awt.Color(49, 50, 68));
        btnConsoleMinus.setForeground(new java.awt.Color(186, 194, 222));
        btnConsoleMinus.setText("-");
        btnConsoleMinus.setToolTipText("Texto mas chico");
        btnConsoleMinus.setFocusPainted(false);
        btnConsoleMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsoleMinusActionPerformed(evt);
            }
        });

        btnConsolePlus.setBackground(new java.awt.Color(49, 50, 68));
        btnConsolePlus.setForeground(new java.awt.Color(186, 194, 222));
        btnConsolePlus.setText("+");
        btnConsolePlus.setToolTipText("Texto mas grande");
        btnConsolePlus.setFocusPainted(false);
        btnConsolePlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsolePlusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonTextSize1Layout = new javax.swing.GroupLayout(panelButtonTextSize1);
        panelButtonTextSize1.setLayout(panelButtonTextSize1Layout);
        panelButtonTextSize1Layout.setHorizontalGroup(
            panelButtonTextSize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonTextSize1Layout.createSequentialGroup()
                .addComponent(btnConsoleMinus, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsolePlus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelButtonTextSize1Layout.setVerticalGroup(
            panelButtonTextSize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonTextSize1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonTextSize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConsolePlus, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnConsoleMinus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        labelTextSizeConsole.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTextSizeConsole.setForeground(new java.awt.Color(186, 194, 222));
        labelTextSizeConsole.setText("Tamaño: ");

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                        .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTextSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelButtonTextSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTextSizeConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButtonTextSize1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(513, 513, 513))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelButtonTextSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelTextSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelButtonTextSize1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addComponent(labelTextSizeConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );

        getContentPane().add(rootPanel);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setForeground(new java.awt.Color(255, 204, 204));
        jMenu1.setText("Archivo");

        jMenuItem1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abrir.png"))); // NOI18N
        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar_como.png"))); // NOI18N
        jMenuItem4.setText("Guardar Como");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Correr");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compile.png"))); // NOI18N
        jMenuItem6.setText("Compilar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ejecutar.png"))); // NOI18N
        jMenuItem7.setText("Ejecutar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Tablas");

        jMenuItem23.setText("De simbolos");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem23);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("Análisis Léxico ");

        CL1.setText("Identificador");
        CL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL1ActionPerformed(evt);
            }
        });
        jMenu3.add(CL1);

        CL2.setText("Numero");
        CL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL2ActionPerformed(evt);
            }
        });
        jMenu3.add(CL2);

        CL3.setText("Hora");
        CL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL3ActionPerformed(evt);
            }
        });
        jMenu3.add(CL3);

        CL4.setText("Dia");
        CL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL4ActionPerformed(evt);
            }
        });
        jMenu3.add(CL4);

        jMenuItem12.setText("Cadena");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem13.setText("Tipo de dato");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem14.setText("Signo de puntuación");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuItem15.setText("Agrupación");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuItem16.setText("Asignación");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem16);

        jMenuItem17.setText("Ciclo");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuItem18.setText("Condicional");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem18);

        jMenuItem19.setText("Operador lógico");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem19);

        jMenuItem22.setText("Bool");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem22);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Análisis Sintáctico");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {              
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens2, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnTextEditorMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTextEditorMinusActionPerformed
        String fontName = jtpCode.getFont().getFontName();
        int fontSize = jtpCode.getFont().getSize() - 2;
        
        Font font = new Font(fontName, 0, fontSize);
        
        jtpCode.setFont(font);
        
        labelTextSize.setText("Tamaño: " + jtpCode.getFont().getSize());
    }//GEN-LAST:event_btnTextEditorMinusActionPerformed

    private void btnTextEditorPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTextEditorPlusActionPerformed
        String fontName = jtpCode.getFont().getFontName();
        int fontSize = jtpCode.getFont().getSize() + 2;
        
        Font font = new Font(fontName, 0, fontSize);
        
        jtpCode.setFont(font);
        
        labelTextSize.setText("Tamaño: " + jtpCode.getFont().getSize());
    }//GEN-LAST:event_btnTextEditorPlusActionPerformed

    private void btnConsoleMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsoleMinusActionPerformed
        String fontName = jtaOutputConsole.getFont().getFontName();
        int fontSize = jtaOutputConsole.getFont().getSize() - 2;
        
        Font font = new Font(fontName, 0, fontSize);
        
        jtaOutputConsole.setFont(font);
        
        labelTextSizeConsole.setText("Tamaño: " + jtaOutputConsole.getFont().getSize());
    }//GEN-LAST:event_btnConsoleMinusActionPerformed

    private void btnConsolePlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsolePlusActionPerformed
        String fontName = jtaOutputConsole.getFont().getFontName();
        int fontSize = jtaOutputConsole.getFont().getSize() + 2;
        
        Font font = new Font(fontName, 0, fontSize);
        
        jtaOutputConsole.setFont(font);
        
        labelTextSizeConsole.setText("Tamaño: " + jtaOutputConsole.getFont().getSize());
    }//GEN-LAST:event_btnConsolePlusActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens2, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        TablaDeSimbolos tds = new TablaDeSimbolos();
        tds.setVisible(true);
        tds.setLocationRelativeTo(this);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void CL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL1ActionPerformed
        a.Limpiar();
        identificador();
        a.setVisible(true);
    }//GEN-LAST:event_CL1ActionPerformed

    private void CL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL2ActionPerformed
        a.Limpiar();
        numero();
        a.setVisible(true);
    }//GEN-LAST:event_CL2ActionPerformed

    private void CL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL4ActionPerformed
        a.Limpiar();
        dias();
        a.setVisible(true);
    }//GEN-LAST:event_CL4ActionPerformed

    private void CL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL3ActionPerformed
        a.Limpiar();
        //hora();
        a.setVisible(true);
    }//GEN-LAST:event_CL3ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        a.Limpiar();
        cadena();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        a.Limpiar();
        tipoDeDato();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        a.Limpiar();
        signoDePuntuacion();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        a.Limpiar();
        agrupacion();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        a.Limpiar();
        asignacion();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        a.Limpiar();
        ciclo();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        a.Limpiar();
        condicional();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        a.Limpiar();
        operadorLogico();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        a.Limpiar();
        bool();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens1.add(token);
                tokens2.add(token);
                tokens3.add(token);
                tokens4.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        //COMPONENTES LEXICOS (MENSAJE DE ERRORES)
        for(int i=0; i < tokens1.size(); i++){
            if(tokens1.get(i).getLexicalComp().equals("ERROR_X")){
                errors.add("-----> ERROR LÉXICO X:  Error desconocido, Línea["+tokens1.get(i).getLine()+"], Columna["+tokens1.get(i).getColumn()+"]");
            }
            if(tokens1.get(i).getLexicalComp().equals("ERROR_1")){
                errors.add("-----> ERROR LÉXICO 1:  El identificador tiene caracteres no validos, Línea["+tokens1.get(i).getLine()+"], Columna["+tokens1.get(i).getColumn()+"]");
            }
            if(tokens1.get(i).getLexicalComp().equals("ERROR_2")){
                errors.add("-----> ERROR LÉXICO 2:  Este carácter no es valido de esta manera, Línea["+tokens1.get(i).getLine()+"], Columna["+tokens1.get(i).getColumn()+"]");
            }
            if(tokens1.get(i).getLexicalComp().equals("ERROR_3")){
                errors.add("-----> ERROR LÉXICO 3:  Falta una comilla en la cadena, Línea["+tokens1.get(i).getLine()+"], Columna["+tokens1.get(i).getColumn()+"]");
            }
            if(tokens1.get(i).getLexicalComp().equals("ERROR_4")){
                errors.add("-----> ERROR LÉXICO 4:  Carácter no valido, Línea["+tokens1.get(i).getLine()+"], Columna["+tokens1.get(i).getColumn()+"]");
            }
            if(tokens1.get(i).getLexicalComp().equals("ERROR_5")){
                errors.add("-----> ERROR LÉXICO 5:  El número entero no es valido, Línea["+tokens1.get(i).getLine()+"], Columna["+tokens1.get(i).getColumn()+"]");
            }
            if(tokens1.get(i).getLexicalComp().equals("ERROR_6")){
                errors.add("-----> ERROR LÉXICO 6:  Falta agregar datos al día, Línea["+tokens1.get(i).getLine()+"], Columna["+tokens1.get(i).getColumn()+"]");
            }
        }
        //ELIMINACION DE ERRORES LEXICOS
        for(Token id: tokens1){
            if(id.getLexicalComp().contains("ERROR_X")){
                tokens2.remove(id);
                tokens3.remove(id);
                tokens4.remove(id);
            }
            if(id.getLexicalComp().contains("ERROR_1")){
                tokens2.remove(id);
                tokens3.remove(id);
                tokens4.remove(id);
            }
            if(id.getLexicalComp().contains("ERROR_2")){
                tokens2.remove(id);
                tokens3.remove(id);
                tokens4.remove(id);
            }
            if(id.getLexicalComp().contains("ERROR_3")){
                tokens2.remove(id);
                tokens3.remove(id);
                tokens4.remove(id);
            }
            if(id.getLexicalComp().contains("ERROR_4")){
                tokens2.remove(id);
                tokens3.remove(id);
                tokens4.remove(id);
            }
            if(id.getLexicalComp().contains("ERROR_5")){
                tokens2.remove(id);
                tokens3.remove(id);
                tokens4.remove(id);
            }
            if(id.getLexicalComp().contains("ERROR_6")){
                tokens2.remove(id);
                tokens3.remove(id);
                tokens4.remove(id);
            }
        }
        //ESTRUCTURAS DE ASIGNACIÓN
        
        //ESTRUCTURAS DE ASIGNACIÓN CON VALOR
        for(int i=0;i<tokens2.size();i++){
            if(tokens2.get(i).getLexicalComp().equals("TIPO_ENTERO")
            || tokens2.get(i).getLexicalComp().equals("TIPO_CADENA") || tokens2.get(i).getLexicalComp().equals("TIPO_BOOL")){
                if(tokens2.get(i+1).getLexicalComp().equals("IDENTIFICADOR")){
                    if((tokens2.get(i+2).getLexicalComp().equals("ASIGNACION"))){
                        if(tokens2.get(i+3).getLexicalComp().equals("NUMERO_ENTERO")
                        || tokens2.get(i+3).getLexicalComp().equals("CADENA") || tokens2.get(i+3).getLexicalComp().equals("BOOL")
                        || tokens2.get(i+3).getLexicalComp().equals("HORA") || tokens2.get(i+3).getLexicalComp().equals("DIAS")){
                            if(tokens2.get(i+4).getLexicalComp().equals("DELIMITADOR")){
                                PD1.add(PD2 = new Producciones(tokens3.get(i),tokens3.get(i+1),tokens3.get(i+2),tokens3.get(i+3),tokens3.get(i+4)));
                                
                            }else{
                                errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                            }
                        }else{
                            errors.add("-----> ERROR SINTÁCTICO 3:  Falta agregar el valor y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                        }
                    }else{
                        errors.add("-----> ERROR SINTÁCTICO 2:  Falta agregar el = y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                    }
                }else{
                    errors.add("-----> ERROR SINTÁCTICO 1:  Falta agregar el identificador y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                }
            }
        }
        //ESTRUCTURAS DE ASIGNACION CON VALOR PARA DIAS
        for(int i=0;i<tokens2.size();i++){
            if(tokens2.get(i).getLexicalComp().equals("TIPO_DIAS")){
                if(tokens2.get(i+1).getLexicalComp().equals("IDENTIFICADOR")){
                    if(tokens2.get(i+2).getLexicalComp().equals("ASIGNACION")){
                        if(tokens2.get(i+3).getLexicalComp().equals("MENOR_QUE")){
                            if(tokens2.get(i+4).getLexicalComp().equals("NUMERO_ENTERO")
                            || tokens2.get(i+4).getLexicalComp().equals("CADENA") || tokens2.get(i+4).getLexicalComp().equals("BOOL")
                            || tokens2.get(i+4).getLexicalComp().equals("HORA") || tokens2.get(i+4).getLexicalComp().equals("DIAS")){
                                if(tokens2.get(i+5).getLexicalComp().equals("MAYOR_QUE")){
                                    if(tokens2.get(i+6).getLexicalComp().equals("DELIMITADOR")){
                                        PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),tokens2.get(i+5),tokens2.get(i+6)));
                                    }else{
                                        errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                    }
                                }else{
                                    errors.add("-----> ERROR SINTÁCTICO 6:  Falta agregar el > y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                }
                            }else{
                                errors.add("-----> ERROR SINTÁCTICO 3:  Falta agregar el valor y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                            }
                        }else{
                            errors.add("-----> ERROR SINTÁCTICO 5:  Falta agregar el < y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                        }
                    }else{
                        errors.add("-----> ERROR SINTÁCTICO 2:  Falta agregar el = y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                    }
                }else{
                    errors.add("-----> ERROR SINTÁCTICO 1:  Falta agregar el identificador y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                }
            }
        }
        //ESTRUCTURAS DE ASIGNACIÓN CON VALOR PARA HORA
        for(int i=0;i<tokens2.size();i++){
            if(tokens2.get(i).getLexicalComp().equals("TIPO_HORA")){
                if(tokens2.get(i+1).getLexicalComp().equals("IDENTIFICADOR")){
                    if((tokens2.get(i+2).getLexicalComp().equals("ASIGNACION"))){
                        if(tokens2.get(i+3).getLexicalComp().equals("MENOR_QUE")){
                            if(tokens2.get(i+4).getLexicalComp().equals("NUMERO_ENTERO")
                            || tokens2.get(i+4).getLexicalComp().equals("CADENA") || tokens2.get(i+4).getLexicalComp().equals("BOOL")
                            || tokens2.get(i+4).getLexicalComp().equals("HORA") || tokens2.get(i+4).getLexicalComp().equals("DIAS")){
                                if(tokens2.get(i+5).getLexicalComp().equals("COMA")){
                                    if(tokens2.get(i+6).getLexicalComp().equals("NUMERO_ENTERO")
                                    || tokens2.get(i+6).getLexicalComp().equals("CADENA") || tokens2.get(i+6).getLexicalComp().equals("BOOL")
                                    || tokens2.get(i+6).getLexicalComp().equals("HORA") || tokens2.get(i+6).getLexicalComp().equals("DIAS")){
                                        if(tokens2.get(i+7).getLexicalComp().equals("COMA")){
                                            if(tokens2.get(i+8).getLexicalComp().equals("NUMERO_ENTERO")
                                            || tokens2.get(i+8).getLexicalComp().equals("CADENA") || tokens2.get(i+8).getLexicalComp().equals("BOOL")
                                            || tokens2.get(i+8).getLexicalComp().equals("HORA") || tokens2.get(i+8).getLexicalComp().equals("DIAS")){
                                                if(tokens2.get(i+9).getLexicalComp().equals("COMA")){
                                                    if(tokens2.get(i+10).getLexicalComp().equals("NUMERO_ENTERO")
                                                    || tokens2.get(i+10).getLexicalComp().equals("CADENA") || tokens2.get(i+10).getLexicalComp().equals("BOOL")
                                                    || tokens2.get(i+10).getLexicalComp().equals("HORA") || tokens2.get(i+10).getLexicalComp().equals("DIAS")){
                                                        if(tokens2.get(i+11).getLexicalComp().equals("COMA")){
                                                            if(tokens2.get(i+12).getLexicalComp().equals("NUMERO_ENTERO")
                                                            || tokens2.get(i+12).getLexicalComp().equals("CADENA") || tokens2.get(i+12).getLexicalComp().equals("BOOL")
                                                            || tokens2.get(i+12).getLexicalComp().equals("HORA") || tokens2.get(i+12).getLexicalComp().equals("DIAS")){
                                                                if(tokens2.get(i+13).getLexicalComp().equals("MAYOR_QUE")){
                                                                    if(tokens2.get(i+14).getLexicalComp().equals("DELIMITADOR")){
                                                                        PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),tokens2.get(i+5),tokens2.get(i+6),tokens2.get(i+7),tokens2.get(i+8),tokens2.get(i+9),tokens2.get(i+10),tokens2.get(i+11),tokens2.get(i+12),tokens2.get(i+13),tokens2.get(i+14)));
                                                                    }else{
                                                                        errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                    }
                                                                }else{
                                                                    errors.add("-----> ERROR SINTÁCTICO 6:  Falta agregar el > y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                }
                                                            }else{
                                                                errors.add("-----> ERROR SINTÁCTICO 8:  Falta agregar la hora y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                            }
                                                        }else{
                                                            if(tokens2.get(i+11).getLexicalComp().equals("MAYOR_QUE")){
                                                                if(tokens2.get(i+12).getLexicalComp().equals("DELIMITADOR")){
                                                                    PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),tokens2.get(i+5),tokens2.get(i+6),tokens2.get(i+7),tokens2.get(i+8),tokens2.get(i+9),tokens2.get(i+10),null,null,tokens2.get(i+11),tokens2.get(i+12)));
                                                                }else{
                                                                    errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                }
                                                            }else{
                                                                errors.add("-----> ERROR SINTÁCTICO 7:  Falta agregar el > o una , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                            }
                                                        }
                                                    }else{
                                                        errors.add("-----> ERROR SINTÁCTICO 8:  Falta agregar la hora y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                    }
                                                }else{
                                                    if(tokens2.get(i+9).getLexicalComp().equals("MAYOR_QUE")){
                                                        if(tokens2.get(i+10).getLexicalComp().equals("DELIMITADOR")){
                                                            PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),tokens2.get(i+5),tokens2.get(i+6),tokens2.get(i+7),tokens2.get(i+8),null,null,null,null,tokens2.get(i+9),tokens2.get(i+10)));
                                                        }else{
                                                            errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                        }
                                                    }else{
                                                        errors.add("-----> ERROR SINTÁCTICO 7:  Falta agregar el > o una , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                    }
                                                }
                                            }else{
                                                errors.add("-----> ERROR SINTÁCTICO 8:  Falta agregar la hora y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                            }
                                        }else{
                                            if(tokens2.get(i+7).getLexicalComp().equals("MAYOR_QUE")){
                                                if(tokens2.get(i+8).getLexicalComp().equals("DELIMITADOR")){
                                                    PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),tokens2.get(i+5),tokens2.get(i+6),null,null,null,null,null,null,tokens2.get(i+7),tokens2.get(i+8)));
                                                }else{
                                                    errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                }
                                            }else{
                                                errors.add("-----> ERROR SINTÁCTICO 7:  Falta agregar el > o una , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                            }
                                        }
                                    }else{
                                        errors.add("-----> ERROR SINTÁCTICO 8:  Falta agregar la hora y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                    }
                                }else{
                                    if(tokens2.get(i+5).getLexicalComp().equals("MAYOR_QUE")){
                                        if(tokens2.get(i+6).getLexicalComp().equals("DELIMITADOR")){
                                            PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),null,null,null,null,null,null,null,null,tokens2.get(i+5),tokens2.get(i+6)));
                                        }else{
                                            errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                        }
                                    }else{
                                        errors.add("-----> ERROR SINTÁCTICO 7:  Falta agregar el > o una , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                    }
                                }
                            }else{
                                errors.add("-----> ERROR SINTÁCTICO 8:  Falta agregar la hora y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                            }
                        }else{
                            errors.add("-----> ERROR SINTÁCTICO 5:  Falta agregar el < y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                        }
                    }else{
                        errors.add("-----> ERROR SINTÁCTICO 2:  Falta agregar el = y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                    }
                }else{
                    errors.add("-----> ERROR SINTÁCTICO 1:  Falta agregar el identificador y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                }
            }
        }
        //ESTRUCTURA DE ASIGNACION CON VALOR A MEDICAMENTOS
        for(int i=0;i<tokens2.size();i++){
            if(tokens2.get(i).getLexicalComp().equals("TIPO_MEDICAMENTO")){
                if(tokens2.get(i+1).getLexicalComp().equals("IDENTIFICADOR")){
                    if((tokens2.get(i+2).getLexicalComp().equals("ASIGNACION"))){
                        if(tokens2.get(i+3).getLexicalComp().equals("MENOR_QUE")){
                            if(tokens2.get(i+4).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+4).getLexicalComp().equals("NUMERO_ENTERO")
                            || tokens2.get(i+4).getLexicalComp().equals("BOOL")
                            || tokens2.get(i+4).getLexicalComp().equals("CADENA") || tokens2.get(i+4).getLexicalComp().equals("HORA") 
                            || tokens2.get(i+4).getLexicalComp().equals("DIAS")){
                                if(tokens2.get(i+5).getLexicalComp().equals("COMA")){
                                    if(tokens2.get(i+6).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+6).getLexicalComp().equals("NUMERO_ENTERO")
                                    || tokens2.get(i+6).getLexicalComp().equals("BOOL")
                                    || tokens2.get(i+6).getLexicalComp().equals("CADENA") || tokens2.get(i+6).getLexicalComp().equals("HORA") 
                                    || tokens2.get(i+6).getLexicalComp().equals("DIAS")){
                                        if(tokens2.get(i+7).getLexicalComp().equals("COMA")){
                                            if(tokens2.get(i+8).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+8).getLexicalComp().equals("NUMERO_ENTERO")
                                            || tokens2.get(i+8).getLexicalComp().equals("BOOL")
                                            || tokens2.get(i+8).getLexicalComp().equals("CADENA") || tokens2.get(i+8).getLexicalComp().equals("HORA") 
                                            || tokens2.get(i+8).getLexicalComp().equals("DIAS")){
                                                if(tokens2.get(i+9).getLexicalComp().equals("MAYOR_QUE")){
                                                    if(tokens2.get(i+10).getLexicalComp().equals("DELIMITADOR")){
                                                        PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),tokens2.get(i+5),tokens2.get(i+6),tokens2.get(i+7),tokens2.get(i+8),tokens2.get(i+9),tokens2.get(i+10)));
                                                    }else{
                                                        errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                    }
                                                }else{
                                                    errors.add("-----> ERROR SINTÁCTICO 6:  Falta agregar el > y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                }
                                            }else{
                                                errors.add("-----> ERROR SINTÁCTICO 12:  Falta agregar la cantidad del medicamento y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                            }
                                        }else{
                                            errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                        }
                                    }else{
                                        errors.add("-----> ERROR SINTÁCTICO 11:  Falta agregar los gramos del medicamento y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                    }
                                }else{
                                    errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                }
                            }else{
                                errors.add("-----> ERROR SINTÁCTICO 10:  Falta agregar el nombre del medicamento y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                            }
                        }else{
                            errors.add("-----> ERROR SINTÁCTICO 5:  Falta agregar el < y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                        }
                    }else{
                        errors.add("-----> ERROR SINTÁCTICO 2:  Falta agregar el = y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                    }
                }else{
                    errors.add("-----> ERROR SINTÁCTICO 1:  Falta agregar el identificador y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                }
            }
        }
        //ESTRUCTURA DE ASIGNACION CON VALOR A RUTINA
        for(int i=0;i<tokens2.size();i++){
            if(tokens2.get(i).getLexicalComp().equals("TIPO_RUTINA")){
                if(tokens2.get(i+1).getLexicalComp().equals("IDENTIFICADOR")){
                    if((tokens2.get(i+2).getLexicalComp().equals("ASIGNACION"))){
                        if(tokens2.get(i+3).getLexicalComp().equals("PARENTESIS_A")){
                            if(tokens2.get(i+4).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+4).getLexicalComp().equals("NUMERO_ENTERO")
                            || tokens2.get(i+4).getLexicalComp().equals("BOOL")
                            || tokens2.get(i+4).getLexicalComp().equals("CADENA") || tokens2.get(i+4).getLexicalComp().equals("HORA") 
                            || tokens2.get(i+4).getLexicalComp().equals("DIAS")){
                                if(tokens2.get(i+5).getLexicalComp().equals("COMA")){
                                    if(tokens2.get(i+6).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+6).getLexicalComp().equals("NUMERO_ENTERO")
                                    || tokens2.get(i+6).getLexicalComp().equals("BOOL")
                                    || tokens2.get(i+6).getLexicalComp().equals("CADENA") || tokens2.get(i+6).getLexicalComp().equals("HORA") 
                                    || tokens2.get(i+6).getLexicalComp().equals("DIAS")){
                                        if(tokens2.get(i+7).getLexicalComp().equals("COMA")){
                                            if(tokens2.get(i+8).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+8).getLexicalComp().equals("NUMERO_ENTERO")
                                            || tokens2.get(i+8).getLexicalComp().equals("BOOL")
                                            || tokens2.get(i+8).getLexicalComp().equals("CADENA") || tokens2.get(i+8).getLexicalComp().equals("HORA") 
                                            || tokens2.get(i+8).getLexicalComp().equals("DIAS")){
                                                if(tokens2.get(i+9).getLexicalComp().equals("COMA")){
                                                    if(tokens2.get(i+10).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+10).getLexicalComp().equals("NUMERO_ENTERO")
                                                    || tokens2.get(i+10).getLexicalComp().equals("BOOL")
                                                    || tokens2.get(i+10).getLexicalComp().equals("CADENA") || tokens2.get(i+10).getLexicalComp().equals("HORA") 
                                                    || tokens2.get(i+10).getLexicalComp().equals("DIAS")){
                                                        if(tokens2.get(i+11).getLexicalComp().equals("PARENTESIS_C")){
                                                            if(tokens2.get(i+12).getLexicalComp().equals("DELIMITADOR")){
                                                                PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),tokens2.get(i+5),tokens2.get(i+6),tokens2.get(i+7),tokens2.get(i+8),tokens2.get(i+9),tokens2.get(i+10),tokens2.get(i+11),tokens2.get(i+12)));
                                                            }else{
                                                               errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                            }
                                                        }else{
                                                            errors.add("-----> ERROR SINTÁCTICO 14:  Falta agregar el ) y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                        }
                                                    }else{
                                                        errors.add("-----> ERROR SINTÁCTICO 18:  Falta agregar el estado lógico y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                    }
                                                }else{
                                                    errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                }
                                            }else{
                                                errors.add("-----> ERROR SINTÁCTICO 17:  Falta agregar las horas y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                            }
                                        }else{
                                            errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                        }
                                    }else{
                                        errors.add("-----> ERROR SINTÁCTICO 16:  Falta agregar los días y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                    }
                                }else{
                                    errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                }
                            }else{
                                if(tokens2.get(i+4).getLexicalComp().equals("MENOR_QUE")){
                                    if(tokens2.get(i+5).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+5).getLexicalComp().equals("NUMERO_ENTERO")
                                    || tokens2.get(i+5).getLexicalComp().equals("BOOL")
                                    || tokens2.get(i+5).getLexicalComp().equals("CADENA") || tokens2.get(i+5).getLexicalComp().equals("HORA") 
                                    || tokens2.get(i+5).getLexicalComp().equals("DIAS")){
                                        if(tokens2.get(i+6).getLexicalComp().equals("COMA")){
                                            if(tokens2.get(i+7).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+7).getLexicalComp().equals("NUMERO_ENTERO")
                                            || tokens2.get(i+7).getLexicalComp().equals("BOOL")
                                            || tokens2.get(i+7).getLexicalComp().equals("CADENA") || tokens2.get(i+7).getLexicalComp().equals("HORA") 
                                            || tokens2.get(i+7).getLexicalComp().equals("DIAS")){
                                                if(tokens2.get(i+8).getLexicalComp().equals("COMA")){
                                                    if(tokens2.get(i+9).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+9).getLexicalComp().equals("NUMERO_ENTERO")
                                                    || tokens2.get(i+9).getLexicalComp().equals("BOOL")
                                                    || tokens2.get(i+9).getLexicalComp().equals("CADENA") || tokens2.get(i+9).getLexicalComp().equals("HORA") 
                                                    || tokens2.get(i+9).getLexicalComp().equals("DIAS")){
                                                        if(tokens2.get(i+10).getLexicalComp().equals("MAYOR_QUE")){
                                                            if(tokens2.get(i+11).getLexicalComp().equals("COMA")){
                                                                if(tokens2.get(i+12).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+12).getLexicalComp().equals("NUMERO_ENTERO")
                                                                || tokens2.get(i+12).getLexicalComp().equals("BOOL")
                                                                || tokens2.get(i+12).getLexicalComp().equals("CADENA") || tokens2.get(i+12).getLexicalComp().equals("HORA") 
                                                                || tokens2.get(i+12).getLexicalComp().equals("DIAS")){
                                                                    if(tokens2.get(i+13).getLexicalComp().equals("COMA")){
                                                                        if(tokens2.get(i+14).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+14).getLexicalComp().equals("NUMERO_ENTERO")
                                                                        || tokens2.get(i+14).getLexicalComp().equals("BOOL")
                                                                        || tokens2.get(i+14).getLexicalComp().equals("CADENA") || tokens2.get(i+14).getLexicalComp().equals("HORA") 
                                                                        || tokens2.get(i+14).getLexicalComp().equals("DIAS")){
                                                                            if(tokens2.get(i+15).getLexicalComp().equals("COMA")){
                                                                                if(tokens2.get(i+16).getLexicalComp().equals("IDENTIFICADOR") || tokens2.get(i+16).getLexicalComp().equals("NUMERO_ENTERO")
                                                                                || tokens2.get(i+16).getLexicalComp().equals("BOOL")
                                                                                || tokens2.get(i+16).getLexicalComp().equals("CADENA") || tokens2.get(i+16).getLexicalComp().equals("HORA") 
                                                                                || tokens2.get(i+16).getLexicalComp().equals("DIAS")){
                                                                                    if(tokens2.get(i+17).getLexicalComp().equals("PARENTESIS_C")){
                                                                                        if(tokens2.get(i+18).getLexicalComp().equals("DELIMITADOR")){
                                                                                            PD1.add(PD2 = new Producciones(tokens2.get(i),tokens2.get(i+1),tokens2.get(i+2),tokens2.get(i+3),tokens2.get(i+4),tokens2.get(i+5),tokens2.get(i+6),tokens2.get(i+7),tokens2.get(i+8),tokens2.get(i+9),tokens2.get(i+10),tokens2.get(i+11),tokens2.get(i+12),tokens2.get(i+13),tokens2.get(i+14),tokens2.get(i+15),tokens2.get(i+16),tokens2.get(i+17),tokens2.get(i+18)));
                                                                                        }else{
                                                                                            errors.add("-----> ERROR SINTÁCTICO 4:  Falta agregar el delimitador en la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                                        }
                                                                                    }else{
                                                                                        errors.add("-----> ERROR SINTÁCTICO 14:  Falta agregar el ) y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                                    }
                                                                                }else{
                                                                                    errors.add("-----> ERROR SINTÁCTICO 18:  Falta agregar el estado lógico y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                                }
                                                                            }else{
                                                                                errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                            }
                                                                        }else{
                                                                            errors.add("-----> ERROR SINTÁCTICO 17:  Falta agregar las horas y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                        }
                                                                    }else{
                                                                        errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                    }
                                                                }else{
                                                                    errors.add("-----> ERROR SINTÁCTICO 16:  Falta agregar los días y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                                }
                                                            }else{
                                                                errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                            }
                                                        }else{
                                                            errors.add("-----> ERROR SINTÁCTICO 6:  Falta agregar el > y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                        }
                                                    }else{
                                                        errors.add("-----> ERROR SINTÁCTICO 12:  Falta agregar la cantidad del medicamento y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                    }
                                                }else{
                                                    errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                                }
                                            }else{
                                                errors.add("-----> ERROR SINTÁCTICO 11:  Falta agregar los gramos del medicamento y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                            }
                                        }else{
                                            errors.add("-----> ERROR SINTÁCTICO 9:  Falta agregar la , y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                        }
                                    }else{
                                        errors.add("-----> ERROR SINTÁCTICO 10:  Falta agregar el nombre del medicamento y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                    }
                                }else{
                                    errors.add("-----> ERROR SINTÁCTICO 15:  Falta agregar el < o el medicamento y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                                }
                            }
                        }else{
                            errors.add("-----> ERROR SINTÁCTICO 13:  Falta agregar el ( y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                        }
                    }else{
                        errors.add("-----> ERROR SINTÁCTICO 2:  Falta agregar el = y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                    }
                }else{
                    errors.add("-----> ERROR SINTÁCTICO 1:  Falta agregar el identificador y los demás elementos de la Asignación, Línea["+tokens2.get(i).getLine()+"], Columna["+tokens2.get(i).getColumn()+"]");
                }
            }
        }
        
        //ESTRUCTURA DE CICLOS FOR
        
        //ESTRUCTURA DE CICLOS WHILE
        
    }

    private void semanticAnalysis() {
        for(Producciones id: PD1){
            //ASIGNACION ENT
            if(id.TipoDeDato.getLexicalComp().equals("TIPO_ENTERO")){
                if(id.ValorDeDato.getLexicalComp().equals("NUMERO_ENTERO")){
                    if(identificadores.containsKey(id.Identificador.getLexeme())){
                        errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                    }else{
                        identificadores.put(id.Identificador.getLexeme(),id.ValorDeDato.getLexeme());
                        identificadoresTV.put(id.Identificador.getLexeme(),id.ValorDeDato.getLexicalComp());
                    }
                }else{
                    errors.add("-----> ERROR SEMÁNTICO 1:  La Asignación de tipo ent no cuenta con el valor correcto, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                }
            }
            //ASIGNACION STR
            if(id.TipoDeDato.getLexicalComp().equals("TIPO_CADENA")){
                if(id.ValorDeDato.getLexicalComp().equals("CADENA")){
                    if(identificadores.containsKey(id.Identificador.getLexeme())){
                        errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                    }else{
                        identificadores.put(id.Identificador.getLexeme(),id.ValorDeDato.getLexeme());
                        identificadoresTV.put(id.Identificador.getLexeme(),id.ValorDeDato.getLexicalComp());
                    }
                }else{
                    errors.add("-----> ERROR SEMÁNTICO 2:  La Asignación de tipo str no cuenta con el valor correcto, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                }
            }
            //ASIGNACION BOOL
            if(id.TipoDeDato.getLexicalComp().equals("TIPO_BOOL")){
                if(id.ValorDeDato.getLexicalComp().equals("BOOL")){
                    if(identificadores.containsKey(id.Identificador.getLexeme())){
                        errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                    }else{
                        identificadores.put(id.Identificador.getLexeme(),id.ValorDeDato.getLexeme());
                        identificadoresTV.put(id.Identificador.getLexeme(),id.ValorDeDato.getLexicalComp());
                    }
                }else{
                    errors.add("-----> ERROR SEMÁNTICO 3:  La Asignación de tipo bool no cuenta con el valor correcto, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                }
            }
            //ASIGNACION DIAS
            if(id.TipoDeDato.getLexicalComp().equals("TIPO_DIAS")){
                if(id.Dias.getLexicalComp().equals("DIAS")){
                    if(identificadores.containsKey(id.Identificador.getLexeme())){
                        errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                    }else{
                        identificadores.put(id.Identificador.getLexeme(),id.Dias.getLexeme());
                        identificadoresTV.put(id.Identificador.getLexeme(),id.Dias.getLexicalComp());
                    }
                }else{
                    errors.add("-----> ERROR SEMÁNTICO 4:  La Asignación de tipo dias no cuenta con el valor correcto, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                }
            }
            //ASIGNACION MEDICAMENTOS
            if(id.TipoDeDato.getLexicalComp().equals("TIPO_MEDICAMENTO")){
                if(id.Cadena.getLexicalComp().equals("CADENA") || id.Cadena.getLexicalComp().equals("IDENTIFICADOR")){
                    if(id.Cadena.getLexicalComp().equals("IDENTIFICADOR")){
                        if(identificadores.containsKey(id.Cadena.getLexeme())){
                            if(identificadoresTV.get(id.Cadena.getLexeme()).equals("CADENA")){
                                if(id.Entero1.getLexicalComp().equals("NUMERO_ENTERO") || id.Entero1.getLexicalComp().equals("IDENTIFICADOR")){
                                    if(id.Entero1.getLexicalComp().equals("IDENTIFICADOR")){
                                        if(identificadores.containsKey(id.Entero1.getLexeme())){
                                            if(identificadoresTV.get(id.Entero1.getLexeme()).equals("NUMERO_ENTERO")){
                                                if(id.Entero2.getLexicalComp().equals("NUMERO_ENTERO") || id.Entero2.getLexicalComp().equals("IDENTIFICADOR")){
                                                    if(id.Entero2.getLexicalComp().equals("IDENTIFICADOR")){
                                                        if(identificadores.containsKey(id.Entero2.getLexeme())){
                                                            if(identificadoresTV.get(id.Entero2.getLexeme()).equals("NUMERO_ENTERO")){
                                                                if(identificadores.containsKey(id.Identificador.getLexeme())){
                                                                    errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                                }else{
                                                                    identificadores.put(id.Identificador.getLexeme(),id.Cadena.getLexeme()+" , "+id.Entero1.getLexeme()+" , "+id.Entero2.getLexeme());
                                                                }
                                                            }else{
                                                                errors.add("-----> ERROR SEMÁNTICO 10:  El identificador en la Asignación de tipo med no cuenta con el valor correcto en la cantidad del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                            }
                                                        }else{
                                                            errors.add("-----> ERROR SEMÁNTICO 8:  El identificador en la Asignación de tipo med no cuenta con valor asignado, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                        }
                                                    }else{
                                                        if(identificadores.containsKey(id.Identificador.getLexeme())){
                                                            errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                        }else{
                                                            identificadores.put(id.Identificador.getLexeme(),id.Cadena.getLexeme()+" , "+id.Entero1.getLexeme()+" , "+id.Entero2.getLexeme());
                                                        }
                                                    }
                                                }else{
                                                    errors.add("-----> ERROR SEMÁNTICO 7:  La Asignación de tipo med no cuenta con el valor correcto en la cantidad del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                }
                                            }else{
                                                errors.add("-----> ERROR SEMÁNTICO 10:  El identificador en la Asignación de tipo med no cuenta con el valor correcto en los gramos del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                            }
                                        }else{
                                            errors.add("-----> ERROR SEMÁNTICO 8:  El identificador en la Asignación de tipo med no cuenta con valor asignado, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                        }
                                    }else{
                                        if(id.Entero2.getLexicalComp().equals("NUMERO_ENTERO") || id.Entero2.getLexicalComp().equals("IDENTIFICADOR")){
                                            if(id.Entero2.getLexicalComp().equals("IDENTIFICADOR")){
                                                if(identificadores.containsKey(id.Entero2.getLexeme())){
                                                    if(identificadoresTV.get(id.Entero2.getLexeme()).equals("NUMERO_ENTERO")){
                                                        if(identificadores.containsKey(id.Identificador.getLexeme())){
                                                            errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                        }else{
                                                            identificadores.put(id.Identificador.getLexeme(),id.Cadena.getLexeme()+" , "+id.Entero1.getLexeme()+" , "+id.Entero2.getLexeme());
                                                        }
                                                    }else{
                                                        errors.add("-----> ERROR SEMÁNTICO 10:  El identificador en la Asignación de tipo med no cuenta con el valor correcto en la cantidad del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                    }
                                                }else{
                                                    errors.add("-----> ERROR SEMÁNTICO 8:  El identificador en la Asignación de tipo med no cuenta con valor asignado, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                }
                                            }else{
                                                if(identificadores.containsKey(id.Identificador.getLexeme())){
                                                    errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                }else{
                                                    identificadores.put(id.Identificador.getLexeme(),id.Cadena.getLexeme()+" , "+id.Entero1.getLexeme()+" , "+id.Entero2.getLexeme());
                                                }
                                            }
                                        }else{
                                            errors.add("-----> ERROR SEMÁNTICO 7:  La Asignación de tipo med no cuenta con el valor correcto en la cantidad del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                        }
                                    }
                                }else{
                                    errors.add("-----> ERROR SEMÁNTICO 6:  La Asignación de tipo med no cuenta con el valor correcto en los gramos del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                }
                            }else{
                                errors.add("-----> ERROR SEMÁNTICO 9:  El identificador en la Asignación de tipo med no cuenta con el valor correcto en el nombre del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                            }
                        }else{
                            errors.add("-----> ERROR SEMÁNTICO 8:  El identificador en la Asignación de tipo med no cuenta con valor asignado, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                        }
                    }else{
                        if(id.Entero1.getLexicalComp().equals("NUMERO_ENTERO") || id.Entero1.getLexicalComp().equals("IDENTIFICADOR")){
                            if(id.Entero1.getLexicalComp().equals("IDENTIFICADOR")){
                                if(identificadores.containsKey(id.Entero1.getLexeme())){
                                    if(identificadoresTV.get(id.Entero1.getLexeme()).equals("NUMERO_ENTERO")){
                                        if(id.Entero2.getLexicalComp().equals("NUMERO_ENTERO") || id.Entero2.getLexicalComp().equals("IDENTIFICADOR")){
                                            if(id.Entero2.getLexicalComp().equals("IDENTIFICADOR")){
                                                if(identificadores.containsKey(id.Entero2.getLexeme())){
                                                    if(identificadoresTV.get(id.Entero2.getLexeme()).equals("NUMERO_ENTERO")){
                                                        if(identificadores.containsKey(id.Identificador.getLexeme())){
                                                            errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                        }else{
                                                            identificadores.put(id.Identificador.getLexeme(),id.Cadena.getLexeme()+" , "+id.Entero1.getLexeme()+" , "+id.Entero2.getLexeme());
                                                        }
                                                    }else{
                                                        errors.add("-----> ERROR SEMÁNTICO 10:  El identificador en la Asignación de tipo med no cuenta con el valor correcto en la cantidad del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                    }
                                                }else{
                                                    errors.add("-----> ERROR SEMÁNTICO 8:  El identificador en la Asignación de tipo med no cuenta con valor asignado, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                }
                                            }else{
                                                if(identificadores.containsKey(id.Identificador.getLexeme())){
                                                    errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                }else{
                                                    identificadores.put(id.Identificador.getLexeme(),id.Cadena.getLexeme()+" , "+id.Entero1.getLexeme()+" , "+id.Entero2.getLexeme());
                                                }
                                            }
                                        }else{
                                            errors.add("-----> ERROR SEMÁNTICO 7:  La Asignación de tipo med no cuenta con el valor correcto en la cantidad del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                        }
                                    }else{
                                        errors.add("-----> ERROR SEMÁNTICO 10:  El identificador en la Asignación de tipo med no cuenta con el valor correcto en los gramos del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                    }
                                }else{
                                    errors.add("-----> ERROR SEMÁNTICO 8:  El identificador en la Asignación de tipo med no cuenta con valor asignado, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                }
                            }else{
                                if(id.Entero2.getLexicalComp().equals("NUMERO_ENTERO") || id.Entero2.getLexicalComp().equals("IDENTIFICADOR")){
                                    if(id.Entero2.getLexicalComp().equals("IDENTIFICADOR")){
                                        if(identificadores.containsKey(id.Entero2.getLexeme())){
                                            if(identificadoresTV.get(id.Entero2.getLexeme()).equals("NUMERO_ENTERO")){
                                                if(identificadores.containsKey(id.Identificador.getLexeme())){
                                                    errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                                }else{
                                                    identificadores.put(id.Identificador.getLexeme(),id.Cadena.getLexeme()+" , "+id.Entero1.getLexeme()+" , "+id.Entero2.getLexeme());
                                                }
                                            }else{
                                                errors.add("-----> ERROR SEMÁNTICO 10:  El identificador en la Asignación de tipo med no cuenta con el valor correcto en la cantidad del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                            }
                                        }else{
                                            errors.add("-----> ERROR SEMÁNTICO 8:  El identificador en la Asignación de tipo med no cuenta con valor asignado, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                        }
                                    }else{
                                        if(identificadores.containsKey(id.Identificador.getLexeme())){
                                            errors.add("-----> ERROR SEMÁNTICO 20:  El identificador ya ha sido usado en alguna Asignación, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                        }else{
                                            identificadores.put(id.Identificador.getLexeme(),id.Cadena.getLexeme()+" , "+id.Entero1.getLexeme()+" , "+id.Entero2.getLexeme());
                                        }
                                    }
                                }else{
                                    errors.add("-----> ERROR SEMÁNTICO 7:  La Asignación de tipo med no cuenta con el valor correcto en la cantidad del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                                }
                            }
                        }else{
                            errors.add("-----> ERROR SEMÁNTICO 6:  La Asignación de tipo med no cuenta con el valor correcto en los gramos del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                        }
                    }
                }else{
                    errors.add("-----> ERROR SEMÁNTICO 5:  La Asignación de tipo med no cuenta con el valor correcto en el nombre del medicamento, Línea["+id.TipoDeDato.getLine()+"], Columna["+id.TipoDeDato.getColumn()+"]");
                }
            }
        }
        //ASIGNACION HORAS
        
        System.out.println(identificadores);
        System.out.println(identificadoresTV);
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(202, 211, 245));
    }

    private void fillTableTokens() {
        tokens2.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            String strErrors = "\n";
            for (String error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens1.clear();
        tokens2.clear();
        tokens3.clear();
        tokens4.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        identificadoresTV.clear();
        PD1.clear();
        codeHasBeenCompiled = false;
    }
    private void identificador(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("IDENTIFICADOR")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("IDENTIFICADO1");
                    a.mostrarAutomata("IDENTIFICADOR2","IDENTIFICADOR",id.getLexeme(),"Las transiciones del estado inicial [q0] al estado final\n[q1] se generan sin error, por lo tanto el autómata\nse genera correctamente.");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_1")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("IDENTIFICADO1");
                    a.mostrarAutomata("IDENTIFICADOR3","IDENTIFICADOR",id.getLexeme(),"Del estado [q0] a [q1] o bien de el lazo de [q1] a [q1]\nhay un simbolo que no pertenece a la transición, por\nlo tanto evita llegar al estado final [q1] y se genera un\nerror en el autómata.");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("IDENTIFICADO1");
                    a.mostrarAutomata("IDENTIFICADOR4","IDENTIFICADOR",id.getLexeme(),"El token no pertence al autómata, por lo tanto jamas\nentra al estado inicial [q0].");
                    cont++;
                }
            }
        }
    }
    
    private void numero(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("NUMERO_ENTERO")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("NUMERO1");
                    a.mostrarAutomata("NUMERO2","NUMERO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("NUMERO1");
                    a.mostrarAutomata("NUMERO4","NUMERO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_5")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("NUMERO1");
                    a.mostrarAutomata("NUMERO3","NUMERO",id.getLexeme(),"");
                    cont++;
                } 
            }
        }
    }
    private void dias(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("DIAS")){
                    if(id.getLexeme().chars().count() == 1){
                        a.nuevoAutomata(cont,id.getLexeme());
                        a.mostrarAutomataO("DIAS1");
                        a.mostrarAutomata("DIAS2","DIAS",id.getLexeme(),"");
                        cont++;
                    }else{
                        a.nuevoAutomata(cont,id.getLexeme());
                        a.mostrarAutomataO("DIAS1");
                        a.mostrarAutomata("DIAS3","DIAS",id.getLexeme(),"");
                        cont++;
                    }
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("DIAS1");
                    a.mostrarAutomata("DIAS6","DIAS",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_7")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("DIAS1");
                    if(id.getLexeme().chars().count() == 2){
                        a.mostrarAutomata("DIAS4","DIAS",id.getLexeme(),"");
                    }else{
                        a.mostrarAutomata("DIAS4","DIAS",id.getLexeme(),"");
                    }
                    cont++;
                }
            }
        }
    }
    /*
    private void hora(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("HORA")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("HORA1");
                    if(id.getLexeme().equals("24:00")){
                        a.mostrarAutomata("HORA8","HORA",id.getLexeme(),"");
                        cont++;
                    }else{
                        a.mostrarAutomata("HORA6","HORA",id.getLexeme(),"");
                        cont++;
                    }
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("HORA1");
                    a.mostrarAutomata("HORA9","HORA",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("NUMERO_ENTERO")){
                    for(int i = 0; i < tokens1.size(); i++){
                        if(tokens1.get(i).getLexeme().equals(id.getLexeme())){
                            if(Integer.parseInt(id.getLexeme()) < 24){
                                if(i == tokens1.size()-1){
                                    a.nuevoAutomata(cont,id.getLexeme());
                                    a.mostrarAutomataO("HORA1");
                                    a.mostrarAutomata("HORA3","HORA",id.getLexeme(),"");
                                    cont++;
                                    break;
                                }else{
                                    if(tokens1.get(i+1).getLexeme().equals(":")){
                                        if(i == tokens1.size()-2){
                                            a.nuevoAutomata(cont,id.getLexeme()+tokens1.get(i+1).getLexeme());
                                            a.mostrarAutomataO("HORA1");
                                            a.mostrarAutomata("HORA5","HORA",id.getLexeme()+tokens1.get(i+1).getLexeme(),"");
                                            cont++;
                                            break;
                                        }else{
                                            if(tokens1.get(i+2).getLexicalComp().equals("NUMERO_ENTERO") && Integer.parseInt(tokens1.get(i+2).getLexeme()) > 60){
                                                a.nuevoAutomata(cont,id.getLexeme()+tokens1.get(i+1).getLexeme()+tokens1.get(i+2).getLexeme());
                                                a.mostrarAutomataO("HORA1");
                                                a.mostrarAutomata("HORA5","HORA",id.getLexeme()+tokens1.get(i+1).getLexeme()+tokens1.get(i+2).getLexeme(),"");
                                                cont++;
                                                break;
                                            }
                                        }
                                    }else{
                                        a.nuevoAutomata(cont,id.getLexeme());
                                        a.mostrarAutomataO("HORA1");
                                        a.mostrarAutomata("HORA3","HORA",id.getLexeme(),"");
                                        cont++;
                                        break;
                                    }
                                }
                            }else if(Integer.parseInt(id.getLexeme()) > 23){
                                if(i == tokens1.size()-1){
                                    a.nuevoAutomata(cont,id.getLexeme());
                                    a.mostrarAutomataO("HORA1");
                                    a.mostrarAutomata("HORA4","HORA",id.getLexeme(),"");
                                    cont++;
                                    break;
                                }else{
                                    if(tokens1.get(i+1).getLexeme().equals(":")){
                                        if(i == tokens1.size()-2){
                                            a.nuevoAutomata(cont,id.getLexeme()+tokens1.get(i+1).getLexeme());
                                            a.mostrarAutomataO("HORA1");
                                            a.mostrarAutomata("HORA7","HORA",id.getLexeme()+tokens1.get(i+1).getLexeme(),"");
                                            cont++;
                                            break;
                                        }else{
                                            if(tokens1.get(i+2).getLexicalComp().equals("NUMERO_ENTERO") && Integer.parseInt(tokens1.get(i+2).getLexeme()) > 60){
                                                a.nuevoAutomata(cont,id.getLexeme()+tokens1.get(i+1).getLexeme()+tokens1.get(i+2).getLexeme());
                                                a.mostrarAutomataO("HORA1");
                                                a.mostrarAutomata("HORA7","HORA",id.getLexeme()+tokens1.get(i+1).getLexeme()+tokens1.get(i+2).getLexeme(),"");
                                                cont++;
                                                break;
                                            }
                                        }
                                    }else{
                                        a.nuevoAutomata(cont,id.getLexeme());
                                        a.mostrarAutomataO("HORA1");
                                        a.mostrarAutomata("HORA4","HORA",id.getLexeme(),"");
                                        cont++;
                                        break;
                                    }
                                }
                            }        
                        }
                    }
                }
                
            }
        }
    }
    */
    private void cadena(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("CADENA")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CADENA1");
                    a.mostrarAutomata("CADENA3","CADENA",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_2")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CADENA1");
                    a.mostrarAutomata("CADENA2","CADENA",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_3")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CADENA1");
                    a.mostrarAutomata("CADENA2","CADENA",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CADENA1");
                    a.mostrarAutomata("CADENA4","CADENA",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    
    private void tipoDeDato(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("TIPO_ENTERO")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("TIPO DE DATO1");
                    a.mostrarAutomata("TIPO DE DATO2","TIPO DE DATO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("TIPO_MEDICAMENTO")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("TIPO DE DATO1");
                    a.mostrarAutomata("TIPO DE DATO3","TIPO DE DATO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("TIPO_CADENA")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("TIPO DE DATO1");
                    a.mostrarAutomata("TIPO DE DATO4","TIPO DE DATO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("TIPO_BOOL")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("TIPO DE DATO1");
                    a.mostrarAutomata("TIPO DE DATO5","TIPO DE DATO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("TIPO_HORA")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("TIPO DE DATO1");
                    a.mostrarAutomata("TIPO DE DATO6","TIPO DE DATO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("TIPO_DIAS")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("TIPO DE DATO1");
                    a.mostrarAutomata("TIPO DE DATO7","TIPO DE DATO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("TIPO_RUTINA")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("TIPO DE DATO1");
                    a.mostrarAutomata("TIPO DE DATO8","TIPO DE DATO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("TIPO DE DATO1");
                    a.mostrarAutomata("TIPO DE DATO9","TIPO DE DATO",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    
    private void signoDePuntuacion(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("COMA")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("SIGNO DE PUNTUACIÓN1");
                    a.mostrarAutomata("SIGNO DE PUNTUACIÓN2","SIGNO DE PUNTUACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("DELIMITADOR")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("SIGNO DE PUNTUACIÓN1");
                    a.mostrarAutomata("SIGNO DE PUNTUACIÓN3","SIGNO DE PUNTUACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("DOS_PUNTOS")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("SIGNO DE PUNTUACIÓN1");
                    a.mostrarAutomata("SIGNO DE PUNTUACIÓN4","SIGNO DE PUNTUACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("SIGNO DE PUNTUACIÓN1");
                    a.mostrarAutomata("SIGNO DE PUNTUACIÓN5","SIGNO DE PUNTUACION",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    
    private void agrupacion(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("PARENTESIS_A")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("AGRUPACIÓN1");
                    a.mostrarAutomata("AGRUPACIÓN2","AGRUPACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("MENOR_QUE")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("AGRUPACIÓN1");
                    a.mostrarAutomata("AGRUPACIÓN4","AGRUPACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("MAYOR_QUE")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("AGRUPACIÓN1");
                    a.mostrarAutomata("AGRUPACIÓN5","AGRUPACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("LLAVE_A")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("AGRUPACIÓN1");
                    a.mostrarAutomata("AGRUPACIÓN6","AGRUPACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("LLAVE_C")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("AGRUPACIÓN1");
                    a.mostrarAutomata("AGRUPACIÓN7","AGRUPACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("SQUARE_A")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("AGRUPACIÓN1");
                    a.mostrarAutomata("AGRUPACIÓN8","AGRUPACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("SQUARE_C")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("AGRUPACIÓN1");
                    a.mostrarAutomata("AGRUPACIÓN9","AGRUPACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("AGRUPACIÓN1");
                    a.mostrarAutomata("AGRUPACIÓN10","AGRUPACION",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    
    private void asignacion(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("ASIGNACION")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("ASIGNACIÓN1");
                    a.mostrarAutomata("ASIGNACIÓN2","ASIGNACION",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("ASIGNACIÓN1");
                    a.mostrarAutomata("ASIGNACIÓN3","ASIGNACION",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    
    private void ciclo(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("CICLO_WHILE")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CICLO1");
                    a.mostrarAutomata("CICLO2","CICLO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("CICLO_FOR")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CICLO1");
                    a.mostrarAutomata("CICLO3","CICLO",id.getLexeme(),"");
                    cont++;
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CICLO1");
                    a.mostrarAutomata("CICLO4","CICLO",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    
    private void condicional(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("CONDICIONAL")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CONDICIONAL1");
                    if(id.getLexeme().equals("if")){
                        a.mostrarAutomata("CONDICIONAL2","CONDICIONAL",id.getLexeme(),"");
                        cont++;
                    }else if(id.getLexeme().equals("else")){
                        a.mostrarAutomata("CONDICIONAL3","CONDICIONAL",id.getLexeme(),"");
                        cont++;
                    }else if(id.getLexeme().equals("ifnot")){
                        a.mostrarAutomata("CONDICIONAL4","CONDICIONAL",id.getLexeme(),"");
                        cont++;
                    }
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("CONDICIONAL1");
                    a.mostrarAutomata("CONDICIONAL5","CONDICIONAL",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    
    private void operadorLogico(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("OP_LOGICO")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("OPERADOR LOGICO1");
                    if(id.getLexeme().equals("&&")){
                        a.mostrarAutomata("OPERADOR LOGICO2","OPERADOR LOGICO",id.getLexeme(),"");
                        cont++;
                    }else if(id.getLexeme().equals("|")){
                        a.mostrarAutomata("OPERADOR LOGICO3","OPERADOR LOGICO",id.getLexeme(),"");
                        cont++;
                    }else if(id.getLexeme().equals("!")){
                        a.mostrarAutomata("OPERADOR LOGICO4","OPERADOR LOGICO",id.getLexeme(),"");
                        cont++;
                    }else if(id.getLexeme().equals("!=")){
                        a.mostrarAutomata("OPERADOR LOGICO5","OPERADOR LOGICO",id.getLexeme(),"");
                        cont++;
                    }else if(id.getLexeme().equals("==")){
                        a.mostrarAutomata("OPERADOR LOGICO6","OPERADOR LOGICO",id.getLexeme(),"");
                        cont++;
                    }
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("OPERADOR LOGICO1");
                    a.mostrarAutomata("OPERADOR LOGICO7","OPERADOR LOGICO",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    private void bool(){
        cont = 0;
        if(tokens1.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay codigo, por lo tanto no hay tokens",
                        "ERROR DE TOKENS", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Token id: tokens1){
                if(id.getLexicalComp().equals("BOOL")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("BOOL1");
                    if(id.getLexeme().equals("true")){
                        a.mostrarAutomata("BOOL2","BOOL",id.getLexeme(),"");
                        cont++;
                    }else{
                        a.mostrarAutomata("BOOL3","BOOL",id.getLexeme(),"");
                        cont++;
                    }
                }
                if(id.getLexicalComp().equals("ERROR_4")){
                    a.nuevoAutomata(cont,id.getLexeme());
                    a.mostrarAutomataO("BOOL1");
                    a.mostrarAutomata("BOOL4","BOOL",id.getLexeme(),"");
                    cont++;
                }
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                UIManager.put("TitlePane.unifiedBackground", false);
                UIManager.put("TitlePane.background", new Color(17, 17, 27));
                UIManager.put("TitlePane.foreground", new Color(183, 189, 248));
                UIManager.put("TitlePane.titleMargins", new Insets(8, 5, 8, 5));

            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            Compilador c = new Compilador();
            ImageIcon icon = new ImageIcon("src/img/icon.png");
            c.setIconImage(icon.getImage());
            c.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CL1;
    private javax.swing.JMenuItem CL2;
    private javax.swing.JMenuItem CL3;
    private javax.swing.JMenuItem CL4;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnConsoleMinus;
    private javax.swing.JButton btnConsolePlus;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnTextEditorMinus;
    private javax.swing.JButton btnTextEditorPlus;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private java.awt.Label labelTextSize;
    private java.awt.Label labelTextSizeConsole;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel panelButtonTextSize;
    private javax.swing.JPanel panelButtonTextSize1;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
