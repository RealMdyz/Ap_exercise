package View;

import Model.Ball;
import Model.Block;
import Model.UsualItem;
import Model.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class GameFrame extends JFrame {


    BackGroundPanel backGroundPanel;

    public boolean Aim = false;
    private final static int BallStartX = 270;
    private final static int BallStartY = 650;
    private int AddOnMore = 25, AddItemBallLoop = 7;

    public String PlayerName, Color;

    protected SoundManager soundManager;

    JPanel panel;
    JPanel gamePanel;
    Ball ball;
    public boolean onMove = false;
    public boolean addInThisState = false;
    public boolean Stop = false;
    public boolean Sound = false;
    public int Level = 0;
    public int Point = 0;
    public JLabel pointsLabel;


    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Ball>  balls = new ArrayList<>();
    private ArrayList<UsualItem> itemBalls = new ArrayList<>();

    private ArrayList<String> history = new ArrayList<>();
    private int totalRecord = 0; // Initialize total record here


    public GameFrame(){


        soundManager = new SoundManager();
        Color = "Red";
        setTitle("Bricks Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        backGroundPanel = new BackGroundPanel();
        backGroundPanel.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 600, 800);
        panel.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.setLayout(null);
        setContentPane(panel);

        pointsLabel = new JLabel("Points: " + Point);
        pointsLabel.setBounds(500, 700, 100, 50);
        panel.add(pointsLabel);

        gamePanel = new JPanel();
        gamePanel.setBounds(0,0, 600, 800);
        gamePanel.setVisible(true);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        gamePanel.requestFocusInWindow();
        gamePanel.setLayout(null);
        gamePanel.setOpaque(false);

        panel.add(gamePanel);
        panel.add(backGroundPanel);
        gamePanel.repaint();
        AddMenu();
    }
    public void AddMenu(){

            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            // Create menu items
            JMenuItem startMenuItem = new JMenuItem("Start Game");
            JMenuItem totalRecordMenuItem = new JMenuItem("Total Record");
            JMenuItem gameHistoryMenuItem = new JMenuItem("Game History");
            JMenuItem settingMenuItem = new JMenuItem("Settings");
            JMenuItem ExitMenuItem = new JMenuItem("Exit");
            // Add menu items to menu bar
            menuBar.add(startMenuItem);
            menuBar.add(totalRecordMenuItem);
            menuBar.add(gameHistoryMenuItem);
            menuBar.add(settingMenuItem);
            menuBar.add(ExitMenuItem);
            setVisible(true);
            // Add action listeners for menu items
            startMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resetGame();
                    showLevelSelectionPanel();
                }
            });
            ExitMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            totalRecordMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showTotalRecordPanel();
                }
            });

            gameHistoryMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Action to perform when "Game History" is selected
                    // Implement your logic here
                    showGameHistoryPanel();
                }
            });

            settingMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Action to perform when "Settings" is selected
                    // Implement your logic here
                    showSoundSettingsPanel();
                }
            });
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void AddballsToPanel() {
        ArrayList<Ball> ballsCopy = new ArrayList<>(balls);
        for (Ball ball1 : ballsCopy) {
            gamePanel.add(ball1);
        }
        gamePanel.repaint();
    }

    public void AddBlocksToPanel(){
        ArrayList<Block> blockCopy = new ArrayList<>(blocks);
        for (Block block : blockCopy) {
            gamePanel.add(block);
        }
        gamePanel.repaint();
    }
    public void AddItemBallToPanel(){
        ArrayList<UsualItem> itemBallCopy = new ArrayList<>(itemBalls);
        for(UsualItem itemBall : itemBallCopy)
                gamePanel.add(itemBall);
        gamePanel.repaint();
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
    public void addRandomBlock(){
        int Cnt = (Level / AddOnMore) + 1;
        int u = (int)(Math.random() * 5);
        int xFori = u * 100;
        if(Level % AddItemBallLoop == 0){
            UsualItem itemBall = new UsualItem(xFori, 0, 1, "purple");
            gamePanel.add(itemBall);
            itemBalls.add(itemBall);
        }
        else if(Level % AddItemBallLoop == 1){
            UsualItem itemBall = new UsualItem(xFori, 0, 1, "red");
            gamePanel.add(itemBall);
            itemBalls.add(itemBall);
        }
        else if(Level % AddItemBallLoop == 2){
            UsualItem itemBall = new UsualItem(xFori, 0, 1, "green");
            gamePanel.add(itemBall);
            itemBalls.add(itemBall);
        }
        else if(Level % AddItemBallLoop == 4){
            UsualItem itemBall = new UsualItem(xFori, 0, 1, "yellow");
            gamePanel.add(itemBall);
            itemBalls.add(itemBall);
        }
        else if(Level % AddItemBallLoop == 3){
            UsualItem itemBall = new UsualItem(xFori, 0, 1, "orange");
            gamePanel.add(itemBall);
            itemBalls.add(itemBall);
        }
        else if(Level % AddItemBallLoop == 5){
            UsualItem itemBall = new UsualItem(xFori, 0, 1, "blue");
            gamePanel.add(itemBall);
            itemBalls.add(itemBall);
        }


        Level += 1;
        int x = 0;
        for(int i = 0; i < Cnt; i++){
            u = (int)(Math.random() * 5);
            x =  (u * 100);
            if(x == xFori)
                continue;
            Block block = new Block(x, 0, Level);
            blocks.add(block);
            gamePanel.add(block);
        }
        gamePanel.repaint();

    }
    public void addball(int x, int y){
        Ball ball1 = new Ball(x, y);
        ball1.setLayout(null);
        balls.add(ball1);

    }
    public void removeBlock(Block block) {
        blocks.remove(block);
        gamePanel.remove(block);
        AddBlocksToPanel();
        gamePanel.repaint();
    }
    public void removeItemBall(UsualItem itemBall){
        itemBalls.remove(itemBall);
        gamePanel.remove(itemBall);

    }

    public void resetGame() {
        addToHistory(PlayerName, Point);
        for(Block block : blocks)
            gamePanel.remove(block);
        for(Ball ball1 : balls)
            gamePanel.remove(ball1);
        for(UsualItem itemBall : itemBalls)
            gamePanel.remove(itemBall);
        itemBalls.clear();
        gamePanel.removeAll();
        gamePanel.repaint();
        blocks.clear();
        gamePanel.removeAll();
        gamePanel.repaint();
        balls.clear();
        gamePanel.removeAll();
        gamePanel.repaint();
        onMove = false;
        addInThisState = false;
        Stop = false;
        Level = 0;
        totalRecord = Math.max(totalRecord, Point);
        Point = 0;
        gamePanel.repaint();

    }
    private void showGameHistoryPanel() {
        // Create a text area to display the history
        JTextArea historyTextArea = new JTextArea(10, 30); // 10 rows, 30 columns
        historyTextArea.setEditable(false); // Make the text area read-only

        // Append history entries to the text area
        for (String entry : history) {
            historyTextArea.append(entry + "\n"); // Append each entry and a newline character
        }

        // Create a scroll pane to contain the text area
        JScrollPane scrollPane = new JScrollPane(historyTextArea);

        // Configure scroll pane to provide scrolling if needed
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Show a dialog with the scroll pane
        JOptionPane.showMessageDialog(this, scrollPane, "Game History", JOptionPane.PLAIN_MESSAGE);
    }


    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public void RmB(Block block){
        this.blocks.remove(block);
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    private void showTotalRecordPanel() {
        // Create a JPanel to hold the total record label
        JPanel totalRecordPanel = new JPanel(new BorderLayout());

        // Create a JLabel to display the total record
        JLabel totalRecordLabel = new JLabel("Max Record: " + totalRecord);
        totalRecordLabel.setHorizontalAlignment(JLabel.CENTER); // Center-align the text

        // Add the total record label to the panel
        totalRecordPanel.add(totalRecordLabel, BorderLayout.CENTER);

        // Show a dialog with the total record panel
        JOptionPane.showMessageDialog(this, totalRecordPanel, "Total Record", JOptionPane.PLAIN_MESSAGE);
    }
    private void showLevelSelectionPanel() {
        JPanel levelPanel = new JPanel();
        levelPanel.setLayout(new GridLayout(5, 1)); // Grid layout with 5 rows (level options, player name, and color chooser)

        // Create radio buttons for each level option
        JRadioButton easyButton = new JRadioButton("Easy");
        JRadioButton normalButton = new JRadioButton("Normal");
        JRadioButton hardButton = new JRadioButton("Hard");

        // Group the radio buttons so that only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(easyButton);
        group.add(normalButton);
        group.add(hardButton);

        // Add the radio buttons to the panel
        levelPanel.add(easyButton);
        levelPanel.add(normalButton);
        levelPanel.add(hardButton);

        // Add text field for entering player name
        JTextField playerNameField = new JTextField(20);
        JPanel playerNamePanel = new JPanel();
        playerNamePanel.add(new JLabel("Enter Your Name:"));
        playerNamePanel.add(playerNameField);
        levelPanel.add(playerNamePanel);

        // Define a list of color names
        String[] colorNames = {"Red", "Green", "Blue", "Yellow", "Orange", "Purple"};
        JComboBox<String> colorComboBox = new JComboBox<>(colorNames);
        JPanel colorPanel = new JPanel();
        colorPanel.add(new JLabel("Choose Ball Color:"));
        colorPanel.add(colorComboBox);
        levelPanel.add(colorPanel);

        // Show a dialog with the level selection panel
        int result = JOptionPane.showConfirmDialog(this, levelPanel, "Choose Game Level", JOptionPane.OK_CANCEL_OPTION);

        // Handle the selected level, player name, and ball color
        if (result == JOptionPane.OK_OPTION) {
            PlayerName = playerNameField.getText(); // Get the entered player name
            Color = (String) colorComboBox.getSelectedItem(); // Get the selected color name

            if (easyButton.isSelected()) {
                // Start game with easy level
                AddItemBallLoop = 7;
                AddOnMore = 25;
            } else if (normalButton.isSelected()) {
                // Start game with normal level
                AddItemBallLoop = 10;
                AddOnMore = 15;
            } else if (hardButton.isSelected()) {
                // Start game with hard level
                AddItemBallLoop = 20;
                AddOnMore = 5;
            }
        }
    }
    private void showSoundSettingsPanel() {
        // Create sound settings panel
        JPanel soundSettingsPanel = new JPanel();
        soundSettingsPanel.setLayout(new GridLayout(4, 1)); // Grid layout with 4 rows

        // Create checkboxes for aiming and saving options
        JCheckBox aimCheckBox = new JCheckBox("Aim");
        JCheckBox saveCheckBox = new JCheckBox("Save Game");

        // Add checkboxes to the panel
        soundSettingsPanel.add(aimCheckBox);
        soundSettingsPanel.add(saveCheckBox);

        // Create radio buttons for sound options
        JRadioButton onSoundButton = new JRadioButton("On Sound");
        JRadioButton offSoundButton = new JRadioButton("Off Sound");

        // Group the radio buttons so that only one can be selected at a time
        ButtonGroup soundGroup = new ButtonGroup();
        soundGroup.add(onSoundButton);
        soundGroup.add(offSoundButton);

        // Add radio buttons to the panel
        soundSettingsPanel.add(onSoundButton);
        soundSettingsPanel.add(offSoundButton);

        // Add the sound settings panel to a dialog and display it
        int result = JOptionPane.showConfirmDialog(this, soundSettingsPanel, "Sound Settings", JOptionPane.OK_CANCEL_OPTION);

        // Handle the selected options
        if (result == JOptionPane.OK_OPTION) {
            if (onSoundButton.isSelected()) {
                soundManager.playBackgroundMusic();
            } else if (offSoundButton.isSelected()) {
                soundManager.stopBackgroundMusic();
            }
            // Handle aim option
            if (aimCheckBox.isSelected()) {
                Aim = true;
            } else {
                Aim = false;
            }

            // Handle save game option
            if (saveCheckBox.isSelected()) {
                System.out.println("Save Game");
            } else {
                System.out.println("Do not save game");
            }
        }
    }
    private void addToHistory(String playerName, int score) {
        LocalDateTime currentTime = getCurrentSystemTime();
        history.add(playerName + " : " + score + " : " + currentTime); // Add the player name and score as a single entry
    }
    public static LocalDateTime getCurrentSystemTime() {
        return LocalDateTime.now();
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }

    public void setSoundManager(SoundManager soundManager) {
        this.soundManager = soundManager;
    }

    public ArrayList<UsualItem> getItemBalls() {
        return itemBalls;
    }

    public void setItemBalls(ArrayList<UsualItem> itemBalls) {
        this.itemBalls = itemBalls;
    }
}
