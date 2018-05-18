package com.hania;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <aTextField href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</aTextField>
 */
class MainFrame extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 350;
    private static final int COLUMNS = 10;

    private JPanel panel;
    private JTextField aTextField;
    private JTextField bTextField;
    private JTextField cTextField;
    private JLabel aLabel;
    private JLabel bLabel;
    private JLabel cLabel;
    private JButton multi01Button;
    private JButton multi02Button;
    private JButton multi03Button;

    private MainFrame() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initPanel();
        initButtonListeners();
        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));
        initComponents();
        panel.add(aLabel);
        panel.add(aTextField);
        panel.add(bLabel);
        panel.add(bTextField);
        panel.add(cLabel);
        panel.add(cTextField);
        panel.add(multi01Button);
        panel.add(multi02Button);
        panel.add(multi03Button);
    }

    private void initComponents() {
        aTextField = new JTextField(COLUMNS);
        bTextField = new JTextField(COLUMNS);
        cTextField = new JTextField(COLUMNS);
        cTextField.setEditable(false);
        aLabel = new JLabel("A:");
        bLabel = new JLabel("B:");
        cLabel = new JLabel("C:");
        multi01Button = new JButton("Multi01");
        multi02Button = new JButton("Multi02");
        multi03Button = new JButton("Multi03");
        multi01Button.setBackground(Color.PINK);
        multi02Button.setBackground(Color.ORANGE);
        multi03Button.setBackground(Color.CYAN);
    }

    private void initButtonListeners() {
        multi01Button.addActionListener(e -> multi01());
        multi02Button.addActionListener(e -> multi02());
        multi03Button.addActionListener(e -> multi03());
    }

    private void multi01() {
        List<Double> aList = getProduct(aTextField);
        List<Double> bList = getProduct(bTextField);

        DotProduct dotProduct = new DotProduct();
        Double result = dotProduct.multi01(aList.toArray(new Double[0]), bList.toArray(new Double[0]));

        cTextField.setText("");
        cTextField.setText(String.valueOf(result));
        cTextField.setBackground(Color.PINK);
    }

    private void multi02() {
        List<Double> aList = getProduct(aTextField);
        List<Double> bList = getProduct(bTextField);

        DotProduct dotProduct = new DotProduct();
        dotProduct.setB(bList.toArray(new Double[0]));
        Double result = dotProduct.multi02(aList.toArray(new Double[0]));

        cTextField.setText("");
        cTextField.setText(String.valueOf(result));
        cTextField.setBackground(Color.ORANGE);
    }

    private void multi03() {
        List<Double> aList = getProduct(aTextField);
        List<Double> bList = getProduct(bTextField);

        DotProduct dotProduct = new DotProduct();
        dotProduct.setA(aList.toArray(new Double[0]));
        dotProduct.setB(bList.toArray(new Double[0]));
        dotProduct.multi03();

        cTextField.setText("");
        cTextField.setText(String.valueOf(dotProduct.getC()));
        cTextField.setBackground(Color.CYAN);
    }

    private List<Double> getProduct(JTextField textField) {
        String aProduct = textField.getText();
        return getDoubleArray(aProduct);
    }

    private List<Double> getDoubleArray(String product) {
        return Arrays.stream(product.split("\\s*,\\s*"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
