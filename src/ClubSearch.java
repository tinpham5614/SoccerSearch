import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Club Search Class
 */
public final class ClubSearch extends JFrame {
    /**
     * Hash map club
     */
    private final HashMap<Integer, Club> clubHashMap;

    /**
     * Club search constructor
     */
    public ClubSearch() {
        //JFrame
        setTitle("Soccer Men's Club Ranking");
        setSize(700, 700);
        setResizable(false);
        Dimension screenSize = getToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //JPanel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        //JLabel
        JLabel hintLabel = new JLabel("Please enter rank or name to search");
        hintLabel.setBounds(35, 100, 400, 30);
        panel.add(hintLabel);

        JLabel rankLabel = new JLabel("Rank:");
        rankLabel.setBounds(35, 150, 75, 30);
        panel.add(rankLabel);

        JLabel prevRankLabel = new JLabel("Previous Rank:");
        prevRankLabel.setBounds(35, 200, 150, 30);
        panel.add(prevRankLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(35, 250, 75, 30);
        panel.add(nameLabel);

        JLabel leagueLabel = new JLabel("League");
        leagueLabel.setBounds(35, 300, 75, 30);
        panel.add(leagueLabel);

        JLabel offLabel = new JLabel("Offensive:");
        offLabel.setBounds(35, 350, 75, 30);
        panel.add(offLabel);

        JLabel defLabel = new JLabel("Defensive:");
        defLabel.setBounds(35, 400, 75, 30);
        panel.add(defLabel);

        JLabel spiLabel = new JLabel("SPI:");
        spiLabel.setBounds(35, 450, 75, 30);
        panel.add(spiLabel);

        //JTextField
        JTextField rankField = new JTextField();
        rankField.setBounds(200, 150, 200, 30);
        panel.add(rankField);

        JTextField prevRankField = new JTextField();
        prevRankField.setBounds(200, 200, 200, 30);
        panel.add(prevRankField);
        prevRankField.setEditable(false);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 250, 200, 30);
        panel.add(nameField);

        JTextField leagueField = new JTextField();
        leagueField.setBounds(200, 300, 200, 30);
        panel.add(leagueField);
        leagueField.setEditable(false);

        JTextField offField = new JTextField();
        offField.setBounds(200, 350, 200, 30);
        panel.add(offField);
        offField.setEditable(false);

        JTextField defField = new JTextField();
        defField.setBounds(200, 400, 200, 30);
        panel.add(defField);
        defField.setEditable(false);

        JTextField spiField = new JTextField();
        spiField.setBounds(200, 450, 200, 30);
        panel.add(spiField);
        spiField.setEditable(false);


        rankField.addKeyListener(new KeyAdapter() {
            /**
             * Invoked when a key has been pressed.
             *
             * @param e represents event
             */
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (Integer key : clubHashMap.keySet()) {
                        if (Objects.equals(rankField.getText(), clubHashMap.get(key).rank())) {
                            prevRankField.setText(String.valueOf(clubHashMap.get(key).prevRank()));
                            nameField.setText(String.valueOf(clubHashMap.get(key).name()));
                            leagueField.setText(clubHashMap.get(key).league());
                            offField.setText(String.valueOf(clubHashMap.get(key).offensivePoint()));
                            defField.setText(String.valueOf(clubHashMap.get(key).defensivePoint()));
                            spiField.setText(String.valueOf(clubHashMap.get(key).spiPoint()));
                            hintLabel.setText("Club Found!");
                        }
                    }
                }
            }
        });

        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (Integer key : clubHashMap.keySet()) {
                        if (nameField.getText().equals(clubHashMap.get(key).name())) {
                            rankField.setText(clubHashMap.get(key).rank());
                            prevRankField.setText(String.valueOf(clubHashMap.get(key).prevRank()));
                            leagueField.setText(clubHashMap.get(key).league());
                            offField.setText(String.valueOf(clubHashMap.get(key).offensivePoint()));
                            defField.setText(String.valueOf(clubHashMap.get(key).defensivePoint()));
                            spiField.setText(String.valueOf(clubHashMap.get(key).spiPoint()));
                            hintLabel.setText("Club Found!");
                        }
                    }
                }
            }
        });
        // load Button
        JButton loadButton = new JButton("Search");
        loadButton.setBounds(35, 30, 130, 30);
        panel.add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
//                for (Integer key : clubHashMap.keySet()) {
//                    if (Objects.equals(rankField.getText(), clubHashMap.get(key).rank())) {
//                        prevRankField.setText(String.valueOf(clubHashMap.get(key).prevRank()));
//                        nameField.setText(String.valueOf(clubHashMap.get(key).name()));
//                        leagueField.setText(clubHashMap.get(key).league());
//                        offField.setText(String.valueOf(clubHashMap.get(key).offensivePoint()));
//                        defField.setText(String.valueOf(clubHashMap.get(key).defensivePoint()));
//                        spiField.setText(String.valueOf(clubHashMap.get(key).spiPoint()));
//                        hintLabel.setText("Club FOUND!");
//                    }
//                    else if (nameField.getText().equals(clubHashMap.get(key).name())){
//                        rankField.setText(clubHashMap.get(key).rank());
//                        prevRankField.setText(String.valueOf(clubHashMap.get(key).prevRank()));
//                        nameField.setText(String.valueOf(clubHashMap.get(key).name()));
//                        leagueField.setText(clubHashMap.get(key).league());
//                        offField.setText(String.valueOf(clubHashMap.get(key).offensivePoint()));
//                        defField.setText(String.valueOf(clubHashMap.get(key).defensivePoint()));
//                        spiField.setText(String.valueOf(clubHashMap.get(key).spiPoint()));
//                        hintLabel.setText("Club FOUND!");
//                    }
//                }
                String s1 = rankField.getText();
                int key = Integer.parseInt(s1);

                if (e.getSource() == loadButton){
                    if (!clubHashMap.containsKey(key) || clubHashMap.get(key) == null){
                        hintLabel.setText("Club not FOUND");
                        rankField.setText("");
                        prevRankField.setText("");
                        nameField.setText("");
                        leagueField.setText("");
                        offField.setText("");
                        defField.setText("");
                        spiField.setText("");
                    } else {
                        prevRankField.setText(clubHashMap.get(key).prevRank());
                        nameField.setText(clubHashMap.get(key).name());
                        leagueField.setText(clubHashMap.get(key).league());
                        offField.setText(String.valueOf(clubHashMap.get(key).offensivePoint()));
                        defField.setText(String.valueOf(clubHashMap.get(key).defensivePoint()));
                        spiField.setText(String.valueOf(clubHashMap.get(key).spiPoint()));
                        hintLabel.setText("Club Found!");
                    }
                }
            }
        });
        //Clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(185, 30, 130, 30);
        panel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                hintLabel.setText("Please enter rank or name to search");
                rankField.setText("");
                prevRankField.setText("");
                nameField.setText("");
                leagueField.setText("");
                offField.setText("");
                defField.setText("");
                spiField.setText("");
            }
        });
        setVisible(true);
        /* Read data from file */
        clubHashMap = new HashMap<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("spi_global_rankings.csv"));
        } catch (FileNotFoundException e) {
            JOptionPane jOptionPane = new JOptionPane();
            JOptionPane.showMessageDialog(null, "File not found, please check try again!");
            panel.add(jOptionPane);
            rankField.setEditable(false);
        }
        if (scanner != null) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] clubData = scanner.nextLine().split(",");
                Club club = new Club(
                        clubData[0],
                        clubData[1],
                        clubData[2],
                        clubData[3],
                        Double.parseDouble(clubData[4]),
                        Double.parseDouble(clubData[5]),
                        Double.parseDouble(clubData[6])
                );
                clubHashMap.put(Integer.parseInt(clubData[0]), club);
            }
            scanner.close();
        }
        //end search
    }

    /**
     * @param args main
     */
    public static void main(String[] args) {
        new ClubSearch();
    }
}
