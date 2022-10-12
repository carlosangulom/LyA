
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
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

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
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
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
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelButtonTextSize1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addComponent(labelTextSizeConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );

        getContentPane().add(rootPanel);

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
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
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
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);

        //Eliminar Errores
        gramatica.delete(new String[]{"ERROR_0", "ERROR_1"}, 1, " x Error sintáctico {}: No se esperaba el token '[]' [#, %]");

        // Asignación de valores
        gramatica.group("VALOR_ENTERO", "NUMERO_ENTERO", true);
        gramatica.group("VALOR_DECIMAL", "NUMERO_DECIMAL", true);
        gramatica.group("VALOR_BOOL", "BOOL", true);
        gramatica.group("VALOR_CADENA", "CADENA", true);
        gramatica.group("VALOR_HORA", "HORA", true);
        gramatica.group("VALOR_DIAS", "MENOR_QUE DIAS MAYOR_QUE", true);
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) COMA (IDENTIFICADOR | VALOR_ENTERO) COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true);
        gramatica.group("VALOR_RUTINA", "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true);
        
        String valores = "(VALOR_ENTERO | VALOR_DECIMAL | VALOR_CADENA | VALOR_HORA | VALOR_DIAS | VALOR_MEDICAMENTO | VALOR_RUTINA)";
        String tipos = "(TIPO_ENTERO | TIPO_DECIMAL | TIPO_CADENA | TIPO_HORA | TIPO_DIAS | TIPO_MEDICAMENTO | TIPO_RUTINA)";

        //Errores de agrupación
        gramatica.group("VALOR_AGRUPADO", "MENOR_QUE MAYOR_QUE", true, 92, 
                " x Error sintáctico {}: Debe haber un valor entre <> [#, %]");

        //Errores días
        gramatica.group("VALOR_DIAS", "DIAS MAYOR_QUE", true, 92, 
                " x Error sintáctico {}: El formato de los días debe ser <L,M,W,J,V,S,D> [#, %]");
        gramatica.group("VALOR_DIAS", "MENOR_QUE DIAS", true, 92, 
                " x Error sintáctico {}: El formato de los días debe ser <L,M,W,J,V,S,D> [#, %]");
        
        //Errores medicamento
        //Parentesis faltantes
        gramatica.group("VALOR_MEDICAMENTO", "(IDENTIFICADOR | VALOR_CADENA) COMA (IDENTIFICADOR | VALOR_ENTERO) COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "(MENOR_QUE IDENTIFICADOR | VALOR_CADENA) COMA (IDENTIFICADOR | VALOR_ENTERO) COMA (IDENTIFICADOR |VALOR_ENTERO)", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "( IDENTIFICADOR | VALOR_CADENA) COMA (IDENTIFICADOR | VALOR_ENTERO) COMA (IDENTIFICADOR |VALOR_ENTERO)", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        
        //Formato incorrecto
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE COMA (IDENTIFICADOR | VALOR_ENTERO) COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_ENTERO) COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");        
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) (IDENTIFICADOR | VALOR_ENTERO) COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) COMA (IDENTIFICADOR | VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) (IDENTIFICADOR | VALOR_ENTERO) COMA MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) (IDENTIFICADOR | VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) COMA COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) COMA (IDENTIFICADOR |VALOR_ENTERO) MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) COMA  MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA)  MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        gramatica.group("VALOR_MEDICAMENTO", "MENOR_QUE (IDENTIFICADOR | VALOR_CADENA) COMA (IDENTIFICADOR | VALOR_ENTERO) COMA MAYOR_QUE", true, 122, 
                " x Error sintáctico {}: El formato de los medicamentos debe ser <'Nombre', Gramos => Ent, Cantidad => Ent> [#, %]");
        
        //Errores Rutina
        //Parentesis faltantes
        gramatica.group("VALOR_RUTINA", 
                "(IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL)", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "(IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL)", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        
        //Formato incorrecto
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");        
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");        
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");        
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");      
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA  PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");        
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");        
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA COMA PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA COMA COMA PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A COMA COMA COMA PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");        
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) COMA (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) COMA (IDENTIFICADOR | VALOR_DIAS) COMA (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) (IDENTIFICADOR | VALOR_DIAS) (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) (IDENTIFICADOR | VALOR_BOOL) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) (IDENTIFICADOR | VALOR_DIAS) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
        gramatica.group("VALOR_RUTINA", 
                "PARENTESIS_A (IDENTIFICADOR | VALOR_MEDICAMENTO) (IDENTIFICADOR | VALOR_DIAS)  (IDENTIFICADOR | SQUARE_A (VALOR_HORA (COMA VALOR_HORA)*) SQUARE_C) PARENTESIS_C", true, 102,
                " x Error sintáctico {}: El formato de las rutinas debe ser (Medicamento => med, Días => dias, [Horas] => hora, servirAgua => bool) [#, %]");
               
           
        // Declaración de variables
        //Errores de declaración de variables 20+
        gramatica.group("VARIABLE_ERROR", tipos + " ASIGNACION " + valores, true, 20,
                " x Error sintáctico {}: Falta el identificador en la declaración [#, %]");//Identificador no asignado
        gramatica.group("VARIABLE_ERROR", tipos + " IDENTIFICADOR " + valores, true, 21,
                " x Error sintáctico {}: Se debe utilizar el símbolo de asignación [#, %]");//Sin símbolo de asignación 
        
        //Tipo Entero
        //Errores tipo entero 50+
        gramatica.group("VARIABLE_ENTERO", "TIPO_ENTERO IDENTIFICADOR ASIGNACION VALOR_ENTERO", true);
        gramatica.group("VARIABLE_ENTERO", "TIPO_ENTERO IDENTIFICADOR ASIGNACION (VALOR_DECIMAL | VALOR_CADENA | VALOR_HORA | VALOR_DIAS)", true, 50,
                " x Error sintáctico {}: Se debe asignar un valor de tipo entero [#, %]");//Tipos incorrectos
        gramatica.group("VARIABLE_ENTERO", "TIPO_ENTERO IDENTIFICADOR ASIGNACION", true, 51,
                " x Error sintáctico {}: Se debe asignar un valor a la variable [#, %]");//Valor no asignado
        
        //Tipo Decimal
        //Errores tipo decimal 60+
        gramatica.group("VARIABLE_DECIMAL", "TIPO_DECIMAL IDENTIFICADOR ASIGNACION VALOR_DECIMAL", true);
        gramatica.group("VARIABLE_DECIMAL", "TIPO_DECIMAL IDENTIFICADOR ASIGNACION (VALOR_ENTERO | VALOR_CADENA | VALOR_HORA | VALOR_DIAS)", true, 60,
                " x Error sintáctico {}: Se debe asignar un valor de tipo decimal [#, %]");//Tipos incorrectos
        gramatica.group("VARIABLE_DECIMAL", "TIPO_DECIMAL IDENTIFICADOR ASIGNACION", true, 61,
                " x Error sintáctico {}: Se debe asignar un valor a la variable [#, %]");//Valor no asignado
        
        //Tipo Cadena
        //Errores tipo cadena 70+
        gramatica.group("VARIABLE_CADENA", "TIPO_CADENA IDENTIFICADOR ASIGNACION VALOR_CADENA", true);
        gramatica.group("VARIABLE_CADENA", "TIPO_CADENA IDENTIFICADOR ASIGNACION (VALOR_ENTERO | VALOR_DECIMAL | VALOR_HORA | VALOR_DIAS)", true, 70,
                " x Error sintáctico {}: Se debe asignar un valor de tipo cadena [#, %]");//Tipos incorrectos
        gramatica.group("VARIABLE_CADENA", "TIPO_CADENA IDENTIFICADOR ASIGNACION", true, 71,
                " x Error sintáctico {}: Se debe asignar un valor a la variable [#, %]");//Valor no asignado
        
        //Tipo Hora
        //Errores Hora 80+
        gramatica.group("VARIABLE_HORA", "TIPO_HORA IDENTIFICADOR ASIGNACION VALOR_HORA", true);
        gramatica.group("VARIABLE_HORA", "TIPO_HORA IDENTIFICADOR ASIGNACION (VALOR_ENTERO | VALOR_DECIMAL | VALOR_CADENA | VALOR_DIAS)", true, 80,
                " x Error sintáctico {}: Se debe asignar un valor de tipo hora [#, %]");//Tipos incorrectos
        gramatica.group("VARIABLE_HORA", "TIPO_HORA IDENTIFICADOR ASIGNACION", true, 81,
                " x Error sintáctico {}: Se debe asignar un valor a la variable [#, %]");//Valor no asignado
        
        //Tipo días
        //Errores Días 90+
        gramatica.group("VARIABLE_DIAS", "TIPO_DIAS IDENTIFICADOR ASIGNACION VALOR_DIAS", true);
        gramatica.group("VARIABLE_DIAS", "TIPO_DIAS IDENTIFICADOR ASIGNACION (VALOR_ENTERO | VALOR_DECIMAL | VALOR_CADENA | VALOR_HORAS)", true, 90,
                " x Error sintáctico {}: Se debe asignar un valor de tipo día [#, %]");//Tipos incorrectos
        gramatica.group("VARIABLE_DIAS", "TIPO_DIAS IDENTIFICADOR ASIGNACION", true, 91,
                " x Error sintáctico {}: Se debe asignar un valor a la variable [#, %]");//Valor no asignado
                
        //Tipo Rutina
        //Error Rutina 100+
        gramatica.group("VARIABLE_RUTINA", "TIPO_RUTINA IDENTIFICADOR ASIGNACION VALOR_RUTINA", true);
        gramatica.group("VARIABLE_RUTINA", "TIPO_RUTINA IDENTIFICADOR ASIGNACION (VALOR_ENTERO | VALOR_DECIMAL | VALOR_CADENA | VALOR_HORAS | VALOR_DIAS | VALOR_MEDICAMENTO)", true, 100,
                " x Error sintáctico {}: Se debe asignar un valor de tipo medicamento [#, %]");//Tipos incorrectos
        
        //Tipo Medicamento
        //Error medicamento 120+
        gramatica.group("VARIABLE_MEDICAMENTO", "TIPO_MEDICAMENTO IDENTIFICADOR ASIGNACION VALOR_MEDICAMENTO", true);
        gramatica.group("VARIABLE_MEDICAMENTO", "TIPO_MEDICAMENTO IDENTIFICADOR ASIGNACION (VALOR_ENTERO | VALOR_DECIMAL | VALOR_CADENA | VALOR_HORAS | VALOR_DIAS | VALOR_RUTINA)", true, 120,
                " x Error sintáctico {}: Se debe asignar un valor de tipo medicamento [#, %]");//Tipos incorrectos
        gramatica.group("VARIABLE_MEDICAMENTO", "TIPO_MEDICAMENTO IDENTIFICADOR ASIGNACION", true, 121,
                " x Error sintáctico {}: Se debe asignar un valor a la variable [#, %]");//Valor no asignado
        
        
        // Declarar tipos de datos
        gramatica.group("VARIABLE_ERROR", "IDENTIFICADOR ASIGNACION (VALOR_ENTERO | VALOR_DECIMAL)", true, 22,
                " x Error sintáctico {}: Se debe especificar el tipo de dato [#, %]");
        
        //Eliminar tipos de datos y operadores de asignación
        gramatica.delete("TIPO_ENTERO", 23, 
                " x Error sintáctico {}: El tipo de dato no está en una declaración [#, %]");
        gramatica.delete("TIPO_DECIMAL", 23, 
                " x Error sintáctico {}: El tipo de dato no está en una declaración [#, %]");
        gramatica.delete("TIPO_CADENA", 23, 
                " x Error sintáctico {}: El tipo de dato no está en una declaración [#, %]");
        gramatica.delete("TIPO_HORA", 23, 
                " x Error sintáctico {}: El tipo de dato no está en una declaración [#, %]");
        gramatica.delete("TIPO_MEDICAMENTO", 23, 
                " x Error sintáctico {}: El tipo de dato no está en una declaración [#, %]");
        gramatica.delete("ASIGNACION", 23, 
                " x Error sintáctico {}: El operador de asignación no está en una declaración [#, %]");
        
        //Eliminar valores
        gramatica.delete("VALOR_ENTERO", 24, 
                " x Error sintáctico {}: El valor no está en una declaración [#, %]");
        gramatica.delete("VALOR_DECIMAL", 24, 
                " x Error sintáctico {}: El valor no está en una declaración [#, %]");
        gramatica.delete("VALOR_CADENA", 24, 
                " x Error sintáctico {}: El valor no está en una declaración [#, %]");
        gramatica.delete("VALOR_HORA", 24, 
                " x Error sintáctico {}: El valor no está en una declaración [#, %]");
        gramatica.delete("VALOR_DIAS", 24, 
                " x Error sintáctico {}: El valor no está en una declaración [#, %]");
        gramatica.delete("VALOR_MEDICAMENTO", 24, 
                " x Error sintáctico {}: El valor no está en una declaración [#, %]");
        gramatica.delete("VALOR_RUTINA", 24, 
                " x Error sintáctico {}: El valor no está en una declaración [#, %]");
        
        //Agrupación de identificadores y parámetros
        //gramatica.group("VALOR", valores, true);
        //gramatica.group("VALOR", "IDENTIFICADOR", true);
        //gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+", true);
        
        //Agrupación de funciones
        //gramatica.group("DEC_FUNCION", "FUNCION ");

        /* Mostrar gramáticas */
        gramatica.show();
    }

    private void semanticAnalysis() {
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
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
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
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
