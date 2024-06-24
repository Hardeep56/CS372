
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Calculator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel birthDateLabel = new JLabel("Enter Birth Date (YYYY-MM-DD):");
        birthDateLabel.setBounds(10, 20, 200, 25);
        panel.add(birthDateLabel);

        JTextField birthDateText = new JTextField(20);
        birthDateText.setBounds(220, 20, 150, 25);
        panel.add(birthDateText);

        JButton calculateButton = new JButton("Calculate Age");
        calculateButton.setBounds(130, 60, 150, 25);
        panel.add(calculateButton);

        JLabel ageLabel = new JLabel("Your Age:");
        ageLabel.setBounds(10, 100, 200, 25);
        panel.add(ageLabel);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(220, 100, 200, 25);
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthDateStr = birthDateText.getText();
                try {
                    LocalDate birthDate = LocalDate.parse(birthDateStr);
                    LocalDate currentDate = LocalDate.now();
                    if (birthDate.isAfter(currentDate)) {
                        resultLabel.setText("Invalid birth date");
                    } else {
                        int age = Period.between(birthDate, currentDate).getYears();
                        resultLabel.setText(String.valueOf(age));
                    }
                } catch (Exception ex) {
                    resultLabel.setText("Invalid format");
                }
            }
        });
    }
}
