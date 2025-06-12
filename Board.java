import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;



public class Board extends JFrame {
	
	// Move these to class-level fields so they persist
	 private CardDisplay cardDisplay;
	 private JButton nextButton;
	 private JButton shuffleButton;
	
//board creation
    public Board() {
        ImageIcon gameBoard = new ImageIcon("C:\\Users\\mercykoranteng\\OneDrive - Harford County Public Schools\\Pictures\\Screenshots\\mk_welcometo_board_game.png");

        // Set up the frame
        setTitle("Welcome to ... Game Board");
        setSize(1000, 800);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        // Create a JLabel to hold the image
        JLabel gameLabel = new JLabel(gameBoard);
        gameLabel.setBounds(10, 21, 1420, 800);//1420 //800
        gameLabel.setLayout(null);
        getContentPane().add(gameLabel);
        
                
        //Create a JTextField to create the name
        JTextField name = new JTextField("Game Name");
        name.setBounds(360, 120, 100, 40);
        name.setForeground(Color.BLACK);
        name.setHorizontalAlignment(JTextField.CENTER);
        name.setEditable(true);

        // Add a FocusListener to clear the text when the field gains focus
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (name.getText().equals("Game Name")) {
                    name.setText("");
                }
            }
        });

        gameLabel.add(name);
        
        cardDisplay = new CardDisplay();
        cardDisplay.setBounds(0, 0, 800, 700); // You can tweak width/height as needed
        gameLabel.add(cardDisplay);
        
        //initialize Next Button
        nextButton = new JButton("Next");
        nextButton.setBounds(20, 679, 100, 30); // Just under the 3rd row of front cards
        gameLabel.add(nextButton);
        
        nextButton.addActionListener(e -> cardDisplay.displayNextSet());
        
        /*nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardDisplay.displayNextSet(); // Load next 3 cards with backs
            }
        });*/
        
        // Initialize Shuffle button
        shuffleButton = new JButton("Shuffle");
        shuffleButton.setBounds(150, 700, 100, 30); // Under the back of 3rd row card
        add(shuffleButton);

        // Shuffle button logic
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardDisplay.shuffleAndDisplay(); // Show only new 3 cards without backs
            }
        });

        //calling the methods to set up the game
        createHouses(gameLabel);
        setupFences(gameLabel);
        createGroups(gameLabel);
        createPool(gameLabel);
        createParks(gameLabel);
        setupBis(gameLabel);
        constructionSigns(gameLabel);
        marketCheck(gameLabel);
        crossingOff(gameLabel);
        
      //Groups Challenge
        JTextField groupN1 = new JTextField();
        groupN1.setBounds(342, 547, 30, 27);//342
        gameLabel.add(groupN1);
        
        JTextField groupN2 = new JTextField();
        groupN2.setBounds(342, 612, 30, 27); //132
        gameLabel.add(groupN2);
        
        JTextField groupN3 = new JTextField();
        groupN3.setBounds(342, 678, 30, 27);
        gameLabel.add(groupN3);
        
        //Text box count the amount of points I have
        JTextField groups = new JTextField();
        //groups.setHorizontalAlignment(JTextField.CENTER);
        groups.setOpaque(false);
        groups.setForeground(Color.BLACK);
        groups.setHorizontalAlignment(JTextField.CENTER);
        groups.setEditable(true);
        groups.setBounds(343, 738, 30, 27);
        gameLabel.add(groups);
        
        JTextField result = new JTextField();
        result.setOpaque(false);
        result.setForeground(Color.BLACK);
        result.setHorizontalAlignment(JTextField.CENTER);
        result.setEditable(true);
        result.setBounds(1062, 738, 30, 27);
        gameLabel.add(result);

        // Make the frame visible
        setVisible(true);
    }
    
    public void createHouses(JLabel gameLabel) {
    	//HOUSES CODE 
        //finds the positions of each house
        int[][] housePositions = { //Level 1
        	{390, 385}, {445, 390}, {500, 390}, {555, 390}, {610, 390},
        	{665, 390}, {720, 390}, {780, 390}, {835, 390}, {890, 390},
        	{945, 390}, {1000, 390},
        	//Level 2
        	{445, 250}, {500, 240}, {555, 240}, {610, 250}, {665, 240}, 
        	{720, 240}, {780, 240}, {835, 250}, {890, 240}, {945, 240}, 
        	{1000, 240},
        	//Level 3
        	{500, 96}, {555, 98}, {610, 98}, {665, 98}, {720, 98}, //+210
        	{780, 98}, {835, 98}, {890, 98}, {945, 98}, {1000, 98}
        };
        //places a text box at of the elements in the array
        for (int i = 0; i < housePositions.length; i++) {
            int x = housePositions[i][0]; 
            int y = housePositions[i][1];
            
            JTextField houseText = new JTextField(""); 
            houseText.setBounds(x, y, 35, 40); 
            //houseText.setBackground(new Color(0, 0, 0, 0));
            houseText.setOpaque(false);
            houseText.setForeground(Color.BLACK);
            houseText.setHorizontalAlignment(JTextField.CENTER);
            houseText.setEditable(true);
            gameLabel.add(houseText);
        }

    }
    
    public void setupFences(JLabel gameLabel) {
        
        int[][] fencePositions = {//level1
        	{430, 360}, {485, 360}, {540, 360}, {595, 360}, {653, 360}, {705, 360}, 
        	{764, 360}, {820, 360}, {875, 360}, {930, 360}, {985, 360},
        	//level2
        	{485, 212}, {540, 212}, {595, 212}, {653, 212}, {705, 212}, {764, 212}, 
        	{820, 212}, {875, 212}, {930, 212}, {985, 212},
        	//level3
        	{540, 64}, {595, 64}, {653, 64}, {705, 64}, {764, 64}, {820, 64}, 
        	{875, 64}, {930, 64}, {985, 64}, //+210
        };
        //loops through the array and places a button there
        //this button-when clicked-will reveal a line 
        //this line represents the fence.
        for (int j = 0; j < fencePositions.length; j++) {
        	int x2 = fencePositions[j][0]; 
            int y2 = fencePositions[j][1];
            
            //this panel creates the line
            JPanel fenceLine = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setColor(Color.BLACK);
                    g2.setStroke(new BasicStroke(4));
                    g2.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
                }
            };
            fenceLine.setBounds(x2, y2, 10, 84);
            fenceLine.setOpaque(false);
            fenceLine.setVisible(false); // Hidden initially

            //fence button
            JButton fence = new JButton();
            fence.setBounds(x2, y2, 10, 84);
            fence.setOpaque(false);
            fence.setContentAreaFilled(false);
            fence.setBorderPainted(false);

            fence.addActionListener(new ActionListener() {
                boolean isLineVisible = false;

                @Override
                public void actionPerformed(ActionEvent e) {
                    isLineVisible = !isLineVisible;
                    fenceLine.setVisible(isLineVisible);
                    fenceLine.repaint();
                }
            });

            gameLabel.add(fence);
            gameLabel.add(fenceLine);
        }
    }
    
    
    public void createGroups(JLabel gameLabel) {
    	//GROUPS CODE
        int[][] groupsCord = {
        	{380, 350}, {437, 350}, {492, 350}, {547, 350}, {605, 350}, 
        	{657, 350}, {710, 350}, {770, 350}, {825, 350}, {882, 350},
        	/*can only make a group of two*/{935, 350},
        	{437, 202}, {492, 202}, {547, 202}, {605, 202}, {657, 202}, 
        	{710, 202}, {770, 202}, {825, 202}, {882, 202}, {935, 202},
        	/*next level*/{492, 55}, {547, 55}, {605, 55}, {657, 55}, {710, 55}, 
        	{770, 55}, {825, 55}, {882, 55}, {935, 55} //+210
        };
        
        for (int i1 = 0; i1 < groupsCord.length; i1++) {
            int x4 = groupsCord[i1][0];
            int y4 = groupsCord[i1][1];
            
            GrowingLinePanel groupLine = new GrowingLinePanel();
            groupLine.setBounds(x4, y4, 56, 5);
            groupLine.setVisible(false);
            gameLabel.add(groupLine);

            final int maxClicks = 5;
            final int widthIncrease = 54;
            final int[] clickCount = {0};

            JButton group = new JButton();
            group.setBounds(x4, y4, 56, 10);
            group.setOpaque(false);
            group.setContentAreaFilled(false);
            group.setBorderPainted(false);
            gameLabel.add(group);

            group.addActionListener(e -> {
            	clickCount[0]++;
            	
            	if(clickCount[0] == 1) {
                	groupLine.setVisible(true);
                }
            	
                if (clickCount[0] < maxClicks) {
                    groupLine.increaseWidth(widthIncrease);
                }
                
                if (clickCount[0] == maxClicks) {
                	groupLine.resetLine();
                    clickCount[0] = 0;
                    
                }
            });
        }
    }
    
    
    public void createPool(JLabel gameLabel) {
    	//Creating pool button
        /*JButton pool = new JButton();
        pool.setBounds(740, 370, 20, 15);
        gameLabel.add(pool);*/
        int[][] poolPos = {
        		//level1
        		{450, 370}, {730, 370}, {950, 370},
        		//level2
        		{450, 220}, {620, 220}, {840, 220},
        		//level3
        		{620, 70}, {840, 70}, {900, 70}
        	};
        
        //the places to cross out the pools
        int[][] poolChePos = {
        		{480, 582}, {505, 582}, //270 //295
        		{480, 608}, {505, 608},
        		{480, 636}, {505, 636},
        		{480, 665}, {505, 665},
        		{480, 690}//+210
        };
        
        //This is the text box that is used
        //to count the amount of pools that are selected.
        JTextField pools = new JTextField();
        pools.setOpaque(false);
        pools.setOpaque(false);
        pools.setForeground(Color.BLACK);
        pools.setHorizontalAlignment(JTextField.CENTER);
        pools.setEditable(true);
        pools.setBounds(485, 738, 30, 27);
        gameLabel.add(pools);
        
        
        //final int[] circleIndex = {0};
        Deque<Integer> availableIndexes = new ArrayDeque<>();
        for (int i = 0; i < poolChePos.length; i++) {
            availableIndexes.addLast(i);
        }

        // Track which checkbox owns which circle and which index
        Map<JCheckBox, CirclePanels> checkboxToCircle = new HashMap<>();
        Map<JCheckBox, Integer> checkboxToIndex = new HashMap<>();

        //Places each of the pool buttons down where
        //the pool positions are
        for (int i = 0; i < poolPos.length; i++) {
            int x = poolPos[i][0];
            int y = poolPos[i][1];

            JCheckBox poolCheck = new JCheckBox();
            poolCheck.setBounds(x, y, 20, 20); 
            poolCheck.setOpaque(false);
            poolCheck.setContentAreaFilled(false);
            poolCheck.setBorderPainted(false);
            poolCheck.setFocusPainted(false); 
            gameLabel.add(poolCheck);
            
            poolCheck.addActionListener(e -> {
                if (poolCheck.isSelected()) {
                    // First time selecting
                    if (!checkboxToCircle.containsKey(poolCheck)) {
                        if (!availableIndexes.isEmpty()) {
                            int index = availableIndexes.removeFirst();
                            Point circlePos = new Point(poolChePos[index][0], poolChePos[index][1]);
                            CirclePanels circle = new CirclePanels(circlePos);

                            checkboxToCircle.put(poolCheck, circle);
                            checkboxToIndex.put(poolCheck, index);

                            gameLabel.add(circle);
                            gameLabel.repaint();
                        }
                    } else {
                        // Re-adding existing circle
                        CirclePanels existing = checkboxToCircle.get(poolCheck);
                        if (existing != null) {
                            gameLabel.add(existing);
                            gameLabel.repaint();
                        }
                    }
                } else {
                    // Deselecting — remove circle and free index
                    CirclePanels circle = checkboxToCircle.remove(poolCheck);
                    Integer index = checkboxToIndex.remove(poolCheck);

                    if (circle != null && index != null) {
                        gameLabel.remove(circle);
                        availableIndexes.addFirst(index); // put freed spot at front to reuse immediately
                        gameLabel.repaint();
                    }
                }
            });
        }
    }
    
    private void createParks(JLabel gameLabel) {
        int[][] parkPos = {
            {900, 325}, {929, 325}, {958, 325}, {986, 325}, {1013, 325}, //690, 718, 748, 776, 803
            {929, 175}, {958, 175}, {986, 175}, {1013, 175},
            {958, 28}, {986, 28}, {1013, 28}
        };

        for (int k = 0; k < parkPos.length; k++) {
            int x3 = parkPos[k][0];
            int y3 = parkPos[k][1];

            JCheckBox parCheck = new JCheckBox();
            parCheck.setOpaque(false);
            parCheck.setContentAreaFilled(false);
            parCheck.setBorderPainted(false);
            parCheck.setFocusPainted(false);
            //parCheck.setVisible(false);
            parCheck.setBounds(x3, y3, 20, 17);
            //counters
            JTextField parks = new JTextField();
            parks.setOpaque(false);
            parks.setForeground(Color.BLACK);
            parks.setHorizontalAlignment(JTextField.CENTER);
            parks.setEditable(true);
            parks.setBounds(410, 738, 30, 27);

            final JLabel xLabel = new JLabel("X", SwingConstants.CENTER);
            xLabel.setBounds(x3, y3, 20, 20);
            xLabel.setHorizontalAlignment(SwingConstants.CENTER);
            xLabel.setVerticalAlignment(SwingConstants.CENTER);
            xLabel.setForeground(java.awt.Color.BLACK);
            xLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));

            parCheck.addActionListener(e -> {
                if (parCheck.isSelected()) {
                    if (!gameLabel.isAncestorOf(xLabel)) {
                        gameLabel.add(xLabel);
                        gameLabel.repaint();
                        gameLabel.revalidate();
                    }
                } else {
                    gameLabel.remove(xLabel);
                    gameLabel.repaint();
                    gameLabel.revalidate();
                }
            });
            
            gameLabel.add(parks);
            gameLabel.add(parCheck);
        }
    }
    
    public void setupBis(JLabel gameLabel) {
        //CONSTRUCTION
        /*JButton group = new JButton();
        group.setBounds(282, 55, 56, 10);
        gameLabel.add(group);*/
        int[][] bisPos = { //Level 1
            	{920, 554}, {950, 554}, 
            	{920, 588}, {950, 588}, 
            	{920, 621}, {950, 621}, 
            	{920, 656}, {950, 656}, 
            	{920, 690}, //+210
            };
        
        //Text for the bis count of points
        JTextField bis = new JTextField();
        bis.setOpaque(false);
        bis.setForeground(Color.BLACK);
        bis.setHorizontalAlignment(JTextField.CENTER);
        bis.setEditable(true);
        bis.setBounds(931, 738, 30, 27);
        gameLabel.add(bis);
        
        for (int b = 0; b < bisPos.length; b++) {
            int x = bisPos[b][0];
            int y = bisPos[b][1];

            JCheckBox bisCheck = new JCheckBox();
            bisCheck.setBounds(x, y, 20, 20);
            bisCheck.setOpaque(false);
            bisCheck.setContentAreaFilled(false);
            bisCheck.setBorderPainted(false);
            bisCheck.setFocusPainted(false);
            bisCheck.setIcon(null); // Hide default icon
            bisCheck.setSelectedIcon(null); // Hide selected icon too

            // "X" Label
            JLabel xLabel = new JLabel("X", SwingConstants.CENTER);
            xLabel.setBounds(x, y, 20, 20);
            xLabel.setFont(new Font("Arial", Font.BOLD, 14));
            xLabel.setForeground(Color.BLACK);
            xLabel.setVisible(false); // Start hidden
            gameLabel.add(xLabel);

            // Toggle X visibility on click
            bisCheck.addActionListener(e -> {
                if (bisCheck.isSelected()) {
                    xLabel.setVisible(true);
                } else {
                    xLabel.setVisible(false);
                }
                gameLabel.repaint();
            });
            gameLabel.add(bisCheck);
        }
    }
    
    //CONSTRUCTION
    public void constructionSigns(JLabel gameLabel) {
        int[][] conPos = {
            {390, 430}, {447, 430}, {502, 430}, {558, 430}, {614, 430},
            {670, 432}, {726, 430}, {780, 430}, {835, 430}, {890, 430},//+210
            {945, 432}, {1000, 430},
            {447, 288}, {502, 280}, {558, 280}, {614, 280}, {670, 282},
            {726, 280}, {780, 280}, {835, 280}, {890, 280}, {945, 282},
            {1000, 280},
            {502, 130}, {558, 130}, {614, 132}, {670, 132}, {726, 130},
            {780, 130}, {835, 130}, {890, 130}, {945, 132}, {1000, 130}
        };

        int[][] conBlocks = {
            {565, 569}, {598, 569}, {582, 584},
            {565, 599}, {598, 599}, {582, 614},
            {565, 631}, {598, 631}, {582, 646},
            {565, 662}, {598, 662}//+210
        };
        
        Deque<Integer> availableBlockIndexes = new ArrayDeque<>();
        for (int i = 0; i < conBlocks.length; i++) {
            availableBlockIndexes.addLast(i); // same as queue behavior for initial insert
        }

        Map<JButton, Integer> buttonToBlockIndex = new HashMap<>();
        Map<JButton, JPanel> buttonToBlockPanel = new HashMap<>();

        for (int i = 0; i < conPos.length; i++) {
            int x = conPos[i][0];
            int y = conPos[i][1];

            JButton button = new JButton();
            button.setBounds(x, y, 20, 20);
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(true);
            button.setFocusPainted(false);

            JLabel hashLabel = new JLabel("#", SwingConstants.CENTER);
            hashLabel.setBounds(x, y, 20, 20);
            hashLabel.setForeground(Color.BLACK);
            hashLabel.setFont(new Font("Arial", Font.BOLD, 16));
            hashLabel.setVisible(false);
            
            //construct text
            JTextField construct = new JTextField();
            construct.setOpaque(false);
            construct.setForeground(Color.BLACK);
            construct.setHorizontalAlignment(JTextField.CENTER);
            construct.setEditable(true);
            construct.setBounds(574, 738, 30, 27);
            gameLabel.add(construct);

            gameLabel.add(button);
            gameLabel.add(hashLabel);

            button.addActionListener(e -> {
                if (!hashLabel.isVisible()) {
                    // FIRST CLICK — show hash and place block
                    if (!availableBlockIndexes.isEmpty()) {
                        int blockIdx = availableBlockIndexes.removeFirst(); // take from front
                        int blockX = conBlocks[blockIdx][0];
                        int blockY = conBlocks[blockIdx][1];

                        JPanel blockPanel = new JPanel();
                        blockPanel.setBounds(blockX, blockY, 20, 17);
                        blockPanel.setBackground(Color.WHITE);
                        gameLabel.add(blockPanel);

                        buttonToBlockIndex.put(button, blockIdx);
                        buttonToBlockPanel.put(button, blockPanel);
                        hashLabel.setVisible(true);
                    }
                } else {
                    // SECOND CLICK — remove hash and block, return block index to front
                    hashLabel.setVisible(false);

                    Integer idx = buttonToBlockIndex.remove(button);
                    JPanel blockPanel = buttonToBlockPanel.remove(button);
                    if (idx != null && blockPanel != null) {
                        gameLabel.remove(blockPanel);
                        availableBlockIndexes.addFirst(idx); // return to front of deque
                    }
                }

                gameLabel.repaint();
            });
        }

    }
    
    public void marketCheck(JLabel gameLabel) {
    	int[][] numPos = {
        		{668, 617}, {706, 604}, {706, 628}, {741, 590}, {741, 613}, {741, 637},
        		{779, 577}, {779, 600}, {779, 623}, {779, 648}, {817, 565}, {817, 589},
        		{817, 612}, {817, 635}, {853, 553}, {853, 577}, {853, 600}, {853, 623}
        	};
    	
    	for (int c = 0; c < numPos.length; c++) {
            int x = numPos[c][0];
            int y = numPos[c][1];

            JCheckBox numCheck = new JCheckBox();
            numCheck.setBounds(x, y, 21, 17);
            numCheck.setOpaque(false);
            numCheck.setContentAreaFilled(false);
            numCheck.setBorderPainted(false);
            numCheck.setFocusPainted(false);
            numCheck.setIcon(null);
            //numCheck.setVisible(false);
            numCheck.setSelectedIcon(null); // Hide selected icon too
            
            
            // "X" Label
            JLabel xLab = new JLabel("X", SwingConstants.CENTER);
            xLab.setBounds(x, y, 24, 21);
            xLab.setFont(new Font("Arial", Font.BOLD, 14));
            xLab.setForeground(Color.BLACK);
            xLab.setVisible(false); // Start hidden
            gameLabel.add(xLab);

            // Toggle X visibility on click
            numCheck.addActionListener(e -> {
                if (numCheck.isSelected()) {
                    xLab.setVisible(true);
                } else {
                    xLab.setVisible(false);
                }
                gameLabel.repaint();
            });
          
            gameLabel.add(numCheck);
        }
    	
    	int[][] marketPos = { {659, 738}, {696, 738}, 
    			{733, 738}, {771, 738}, 
        		{812, 738}, {853, 738} };
    	
    	for(int i = 0; i <= marketPos.length - 1; i++) {
    		int x1 = marketPos[i][0];
            int y1 = marketPos[i][1];
    		JTextField marketText = new JTextField(""); 
            marketText.setBounds(x1, y1, 30, 27); 
            //marketText.setBounds(null);
            marketText.setOpaque(false);
            marketText.setForeground(Color.BLACK);
            marketText.setHorizontalAlignment(JTextField.CENTER);
            marketText.setEditable(true);
            gameLabel.add(marketText);
    	}
    }
    
    public void crossingOff(JLabel gameLabel){
    	//write the amount you lost.
    	JTextField cross = new JTextField();
    	cross.setOpaque(false);
        cross.setForeground(Color.BLACK);
        cross.setHorizontalAlignment(JTextField.CENTER);
        cross.setEditable(true);
        cross.setBounds(1004, 738, 30, 27);
        gameLabel.add(cross);
        
    	int[][] crossPos = { {1007, 500}, {1007, 532}, //795
    		{1007, 599}, {1007, 631}, 
    		{1007, 663}
    		};
    	
    	for (int c = 0; c < crossPos.length; c++) {
            int x = crossPos[c][0];
            int y = crossPos[c][1];

            JCheckBox crosCheck = new JCheckBox();
            crosCheck.setBounds(x, y, 24, 21);
            crosCheck.setOpaque(false);
            crosCheck.setContentAreaFilled(false);
            crosCheck.setBorderPainted(false);
            crosCheck.setFocusPainted(false);
            crosCheck.setIcon(null);
            crosCheck.setSelectedIcon(null); // Hide selected icon too

            // "X" Label
            JLabel xLab = new JLabel("X", SwingConstants.CENTER);
            xLab.setBounds(x, y, 24, 21);
            xLab.setFont(new Font("Arial", Font.BOLD, 14));
            xLab.setForeground(Color.BLACK);
            xLab.setVisible(false); // Start hidden
            gameLabel.add(xLab);

            // Toggle X visibility on click
            crosCheck.addActionListener(e -> {
                if (crosCheck.isSelected()) {
                    xLab.setVisible(true);
                } else {
                    xLab.setVisible(false);
                }
                gameLabel.repaint();
            });
            gameLabel.add(crosCheck);
        }
    }


    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(() -> new Board());
    }
}
