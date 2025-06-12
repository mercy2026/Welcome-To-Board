import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CardDisplay extends JPanel {
	
    private static final List<String> cardFilenames = new ArrayList<>(List.of(
        "1_Fence.png", "1_Market.png", "1_Park.png", "2_Fence.png",
        "2_Market.png", "2_Park.png", "3_Bis.png", "3_Construction.png", "3_Fence.png", "3_Pool.png",
        "4_Bis.png", "4_Construction.png", "4_Market.png", "4_Pool.png", "4_Park.png",
        "5_Fence.png", "5_Market.png", "5_Park.png", "6_Bis.png", "6_Construction.png", "6_Fence.png", "6_Park.png",
        "6_Pool.png", "6_Market.png", "7_Construction.png", "7_Fence.png", "7_Market.png", "7_Park.png",
        "7_Pool.png", "8_Bis.png", "8_Construction.png", "8_Park.png", "8_Pool.png", "8_Market.png",
        "8_Fence.png", "9_Market.png", "9_Park.png", "9_Construction.png", "10_Construction.png",
        "10_Pool.png", "10_Fence.png", "11_Fence.png", "11_Park.png", "11_Market.png",
        "12_Construction.png", "12_Park.png", "12_Market.png", "13_Bis.png", "13_Construction.png",
        "13_Fence.png", "14_Fence.png", "14_Market.png", "14_Park.png", "15_Market.png", "15_Park.png",
        "15_Fence.png"
    ));

    private static final List<String> backFilenames = List.of(
        "B_Fence.png", "B_Market.png", "B_Park.png", "B_Pool.png", "B_Construction.png", "B_Bis.png"
    );

    private static final HashMap<String, String> frontToBackMap = new HashMap<>();
    //private static final List<String> displayedCards = new ArrayList<>();
    private int currentIndex = 0;
    private JPanel cardsPanel;
    private int previousIndex = -3;

    /*static {
        // Initialize the mapping from front to back
        for (String card : cardFilenames) {
            String[] parts = card.split("_");
            if (parts.length > 1) {
                String cardType = parts[1].replace(".png", "");
                for (String back : backFilenames) {
                    if (back.contains(cardType)) {
                        frontToBackMap.put(card, back);
                        break;
                    }
                }
            }
        }
        
        //Collections.shuffle(cardFilenames);
    }*/

    public CardDisplay() {
    	setLayout(null);
    	setOpaque(false);
        setPreferredSize(new Dimension(800, 900));
            // Initialize the mapping from front to back
        for (String card : cardFilenames) {
        	String[] parts = card.split("_");
        	if (parts.length > 1) {
        		String cardType = parts[1].replace(".png", "");
        		for (String back : backFilenames) {
        			if (back.contains(cardType)) {
        				frontToBackMap.put(card, back);
                        break;
                    }
                }
            }
        }
            
            cardsPanel = new JPanel();
            cardsPanel.setLayout(null);
            cardsPanel.setBounds(0, 0, 800, 690); // Adjust size to hold cards
            cardsPanel.setOpaque(false);
            add(cardsPanel);
            
            displayNextSet();
    }

    public void displayNextSet() {
    	cardsPanel.removeAll();  // Clear old components
        cardsPanel.repaint();
    	
        int xBack = 0;
        int xFront = 0;
        int y = 0;
        
        if (previousIndex >= 0) {
            for (int i = 0; i < 3; i++) {
                int idx = previousIndex + i;
                if (idx >= cardFilenames.size()) break;
                String frontCard = cardFilenames.get(idx);
                String backCard = frontToBackMap.get(frontCard);
                if (backCard != null) {
                    JLabel backLabel = createCardLabel(backCard, xBack + 140, y);
                    cardsPanel.add(backLabel);
                }
                y += 230;
            }
        }


        y = 0;
        
        for (int i = 0; i < 3; i++) {
        	
        	 int idx = currentIndex + i;
             if (idx >= cardFilenames.size()) break;
             String frontCard = cardFilenames.get(idx);
             JLabel frontLabel = createCardLabel(frontCard, xFront, y);
             cardsPanel.add(frontLabel);
             y += 230;
            /*if (currentIndex >= cardFilenames.size()) {
                currentIndex = 0;
            }

            String frontCard = cardFilenames.get(currentIndex);
            String backCard = frontToBackMap.get(frontCard);

            //if (!displayedCards.contains(frontCard)) 
                //displayedCards.add(frontCard);

                /*ImageIcon frontIcon = new ImageIcon(getClass().getResource("/Welcome To/welCards/" + frontCard));
                JLabel frontLabel = new JLabel(frontIcon);
                frontLabel.setBounds(x, y, 240, 299);
                add(frontLabel);*/
             // Load front image and scale
             /**ImageIcon frontIconOriginal = new ImageIcon(getClass().getResource("/Welcome To/welCards/" + frontCard));
             Image frontImageScaled = frontIconOriginal.getImage().getScaledInstance(130, 180, Image.SCALE_SMOOTH);
             ImageIcon frontIcon = new ImageIcon(frontImageScaled);

             JLabel frontLabel = new JLabel(frontIcon);
             frontLabel.setBounds(x, y, 130, 180);
             cardsPanel.add(frontLabel);*/

                /*ImageIcon backIcon = new ImageIcon(getClass().getResource("/Welcome To/welCards/" + backCard));
                JLabel backLabel = new JLabel(backIcon);
                backLabel.setBounds(x + 10, y, 240, 299);
                add(backLabel);*/
             // Load back image and scale
              /**if(backCard != null) {
                ImageIcon backIconOriginal = new ImageIcon(getClass().getResource("/Welcome To/welCards/" + backCard));
                Image backImageScaled = backIconOriginal.getImage().getScaledInstance(130, 180, Image.SCALE_SMOOTH);
                ImageIcon backIcon = new ImageIcon(backImageScaled);

                JLabel backLabel = new JLabel(backIcon);
                backLabel.setBounds(x + 140, y, 130, 180);
                cardsPanel.add(backLabel);
              }

              y += 230;
              currentIndex++;*/
        }
        
        //Update indexes after rendering
        previousIndex = currentIndex;
        currentIndex += 3;
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
    
    private JLabel createCardLabel(String filename, int x, int y) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Welcome To/welCards/" + filename));
        Image image = icon.getImage().getScaledInstance(130, 180, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(x, y, 130, 180);
        return label;
    }

    public void shuffleAndDisplay() {
        //displayedCards.clear();
        Collections.shuffle(cardFilenames);
        currentIndex = 0;
        previousIndex = -3;
        //removeAll();
        //repaint();
        displayNextSet();
    }
}
