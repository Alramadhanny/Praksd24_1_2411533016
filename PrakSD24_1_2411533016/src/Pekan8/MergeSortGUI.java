package Pekan8;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MergeSortGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private int[] array;
    private JLabel[] labelArray;
    private JTextField inputField;
    private JButton setButton, stepButton, resetButton;
    private JPanel panelArray;
    private JTextArea stepArea;

    private Queue<int[]> mergeQueue = new LinkedList<>();
    private int[] temp;
    private int left, mid, right, i, j, k;
    private boolean isMerging = false, copying = false;
    private int stepCount = 1;

    public MergeSortGUI() {
        setTitle("Merge Sort Langkah per Langkah");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputField = new JTextField(30);
        setButton = new JButton("Set Array");
        inputPanel.add(new JLabel("Masukkan angka (pisahkan dengan koma): "));
        inputPanel.add(inputField);
        inputPanel.add(setButton);

        panelArray = new JPanel(new FlowLayout());

        JPanel controlPanel = new JPanel();
        stepButton = new JButton("Langkah Selanjutnya");
        resetButton = new JButton("Reset");
        controlPanel.add(stepButton);
        controlPanel.add(resetButton);

        stepArea = new JTextArea(10, 60);
        stepArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        stepArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(stepArea);

        add(inputPanel, BorderLayout.NORTH);
        add(panelArray, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);

        setButton.addActionListener(e -> setArrayFromInput());
        stepButton.setEnabled(false);
        stepButton.addActionListener(e -> performStep());
        resetButton.addActionListener(e -> reset());
    }

    private void setArrayFromInput() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        String[] parts = text.split(",");
        array = new int[parts.length];

        try {
            for (int k = 0; k < parts.length; k++) {
                array[k] = Integer.parseInt(parts[k].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka dipisahkan koma!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        labelArray = new JLabel[array.length];
        panelArray.removeAll();

        for (int k = 0; k < array.length; k++) {
            labelArray[k] = new JLabel(String.valueOf(array[k]));
            labelArray[k].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray[k].setOpaque(true);
            labelArray[k].setBackground(Color.WHITE);
            labelArray[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray[k].setPreferredSize(new Dimension(50, 50));
            labelArray[k].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray.add(labelArray[k]);
        }
        mergeQueue.clear();
        generateMergeSteps(0, array.length - 1);
        stepButton.setEnabled(true);
        stepArea.setText("");
        isMerging = false;
        copying = false;
        stepCount = 1;
        panelArray.revalidate();
        panelArray.repaint();
    }

    private void generateMergeSteps(int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            generateMergeSteps(l, m);
            generateMergeSteps(m + 1, r);
            mergeQueue.offer(new int[]{l, m, r});
        }
    }

    private void performStep() {
        resetHighlights();

        if (!isMerging && !mergeQueue.isEmpty()) {
            int[] range = mergeQueue.poll();
            left = range[0];
            mid = range[1];
            right = range[2];
            i = left;
            j = mid + 1;
            k = 0;
            temp = new int[right - left + 1];
            isMerging = true;
            copying = false;
            stepArea.append("Langkah " + stepCount++ + ": Mulai merge dari " + left + " ke " + right + "\n");
            return;
        }

        if (isMerging && !copying) {
            if (i <= mid && j <= right) {
                labelArray[i].setBackground(Color.CYAN);
                labelArray[j].setBackground(Color.CYAN);
                if (array[i] <= array[j]) {
                    temp[k++] = array[i++];
                    stepArea.append("Langkah " + stepCount++ + ": Salin dari kiri\n");
                } else {
                    temp[k++] = array[j++];
                    stepArea.append("Langkah " + stepCount++ + ": Salin dari kanan\n");
                }
                return;
            } else if (i <= mid) {
                temp[k++] = array[i++];
                stepArea.append("Langkah " + stepCount++ + ": Salin sisa kiri\n");
                return;
                
            } else if (j <= right) {
                temp[k++] = array[j++];
                stepArea.append("Langkah " + stepCount++ + ": Salin sisa kanan\n");
                return;
            } else {
                copying = true;
                k = 0;
                return;
            }
        }

        if (copying && k < temp.length) {
            array[left + k] = temp[k];
            labelArray[left + k].setText(String.valueOf(temp[k]));
            labelArray[left + k].setBackground(Color.GREEN);
            stepArea.append("Langkah " + stepCount++ + ": Tempelkan ke array utama\n");
            k++;
            return;
        }

        if (copying && k == temp.length) {
            isMerging = false;
            copying = false;
        }

        
        if (mergeQueue.isEmpty() && !isMerging) {
            stepArea.append("Selesai.\n");
            stepArea.append("Array akhir: " + Arrays.toString(array) + "\n");

            // Highlight semua elemen akhir
            for (JLabel label : labelArray) {
                label.setBackground(Color.ORANGE);
            }

            stepButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
        }
    }

    private void resetHighlights() {
        if (labelArray == null) return;
        for (JLabel label : labelArray) {
            label.setBackground(Color.WHITE);
        }
    }

    private void reset() {
        inputField.setText("");
        panelArray.removeAll();
        panelArray.revalidate();
        panelArray.repaint();
        stepArea.setText("");
        stepButton.setEnabled(false);
        mergeQueue.clear();
        isMerging = false;
        copying = false;
        stepCount = 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MergeSortGUI().setVisible(true);
        });
    }
}