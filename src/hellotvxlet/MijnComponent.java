/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.util.Random;
import org.havi.ui.HComponent;
import org.havi.ui.HGraphicButton;
import org.havi.ui.HScene;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

public class MijnComponent extends HComponent implements HActionListener {

    Image background;
    Image cardDeck;
    int x = 350;
    int y = 0;
    HScene scene;
    Random rnd = new Random();
    String[] userCards = new String[12];
    String[] computer1Cards = new String[12];
    String[] computer2Cards = new String[12];
    Image[] userCardsImages = new Image[15];
    HGraphicButton[] userCardsButtons = new HGraphicButton[12];
    HGraphicButton deck = new HGraphicButton(cardDeck, (720 / 2) + 50, (576 / 2) - 60, 50, 75);
    int userCardsLeft = 7;
    int computer1CardsLeft = 7;
    int computer2CardsLeft = 7;
    int currentPlayerTurn = 0; //0 = player, 1 = pc 1, 2 = pc2

    boolean clockWise = true;
    int chanceOfWildCard = 10;
    int maxRandom = 4;
    String lastCardPlayed;
    Image lastCardPlayedImage;
    HStaticText msg = new HStaticText("Player Turn", 0, (576 / 2)-60, 300, 100);
    Image cardBack = this.getToolkit().getImage("card_back.png");
    HGraphicButton[] pc2Cards = new HGraphicButton[12];
    HGraphicButton[] pc1Cards = new HGraphicButton[12];
    MediaTracker mt = new MediaTracker(this);

    public void PlayGame() {

        DivideCardsOnStart();
        currentPlayerTurn = 0;

        DrawComputerCards();
    }

    public void DrawComputerCards() //Call this fucntion every time computer picks or lays a card so they get added to the scene
    {

        for (int i = 0; i < pc1Cards.length; i++) {
            if (pc1Cards[i] != null) {
                scene.remove(pc1Cards[i]);
            }
        }

        for (int i = 0; i < pc2Cards.length; i++) {
            if (pc2Cards[i] != null) {
                scene.remove(pc2Cards[i]);
            }
        }


        for (int i = 0; i < computer1CardsLeft; i++) {
            pc1Cards[i] = new HGraphicButton(cardBack, (5 + (i * 30)), 5, 30, 44);
            pc1Cards[i].setResizeMode(HVisible.RESIZE_ARBITRARY);
            scene.add(pc1Cards[i]);
            scene.popToFront(pc1Cards[i]);
        }

        for (int i = 0; i < computer2CardsLeft; i++) {
            pc2Cards[i] = new HGraphicButton(cardBack, 690, (5 + (i * 44)), 30, 44);
            pc2Cards[i].setResizeMode(HVisible.RESIZE_ARBITRARY);
            scene.add(pc2Cards[i]);
            scene.popToFront(pc2Cards[i]);
        }
        scene.repaint();
    }

    public void RandomCardMiddle() //Call on start so a random card gets set in the middle
    {
        switch (rnd.nextInt(maxRandom) + 1) {
            case 1:
                lastCardPlayed = "yellow_";
                break;
            case 2:
                lastCardPlayed = "blue_";
                break;
            case 3:
                lastCardPlayed = "green_";
                break;
            case 4:
                lastCardPlayed = "red_";
                break;
            case 5:
                lastCardPlayed = "wild_0.png";
                break;
            case 6:
                lastCardPlayed = "wild_1.png";
                break;
            default:
                lastCardPlayed = "yellow_";
                break;
        }
        switch (rnd.nextInt(13)) {
            case 0:
                lastCardPlayed += "0.png";
                break;
            case 1:
                lastCardPlayed += "1.png";
                break;
            case 2:
                lastCardPlayed += "2.png";
                break;
            case 3:
                lastCardPlayed += "3.png";
                break;
            case 4:
                lastCardPlayed += "4.png";
                break;
            case 5:
                lastCardPlayed += "5.png";
                break;
            case 6:
                lastCardPlayed += "6.png";
                break;
            case 7:
                lastCardPlayed += "7.png";
                break;
            case 8:
                lastCardPlayed += "8.png";
                break;
            case 9:
                lastCardPlayed += "9.png";
                break;
            default:
                lastCardPlayed += "0.png";
                break;
        }
        lastCardPlayedImage = this.getToolkit().getImage(lastCardPlayed);
        scene.repaint();
    }

    public void DivideCardsOnStart() //Give all players (pcs and player) 7 cards
    {

        for (int i = 0; i < 7; i++) {
            String card;

            if (chanceOfWildCard > rnd.nextInt(100)) {
                maxRandom = 6;
            } else {
                maxRandom = 4;
            }

            switch (rnd.nextInt(maxRandom) + 1) {
                case 1:
                    card = "yellow_";
                    break;
                case 2:
                    card = "blue_";
                    break;
                case 3:
                    card = "green_";
                    break;
                case 4:
                    card = "red_";
                    break;
                case 5:
                    card = "wild_0.png";
                    break;
                case 6:
                    card = "wild_1.png";
                    break;
                default:
                    card = "yellow_";
                    break;
            }
            if (card.equals("wild_0.png") || card.equals("wild_1.png")) {
            } else {
                switch (rnd.nextInt(13)) {
                    case 0:
                        card += "0.png";
                        break;
                    case 1:
                        card += "1.png";
                        break;
                    case 2:
                        card += "2.png";
                        break;
                    case 3:
                        card += "3.png";
                        break;
                    case 4:
                        card += "4.png";
                        break;
                    case 5:
                        card += "5.png";
                        break;
                    case 6:
                        card += "6.png";
                        break;
                    case 7:
                        card += "7.png";
                        break;
                    case 8:
                        card += "8.png";
                        break;
                    case 9:
                        card += "9.png";
                        break;
                    case 10:
                        card += "picker.png";
                        break;
                    case 11:
                        card += "reverse.png";
                        break;
                    case 12:
                        card += "skip.png";
                        break;
                    default:
                        card += "0.png";
                        break;
                }
            }
            userCards[i] = card;
        }

        for (int i = 0; i < userCards.length; i++) {
            if (userCards[i] != null) {
                userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                userCardsButtons[i].setActionCommand(String.valueOf(i));
                userCardsButtons[i].addHActionListener(this);
                scene.add(userCardsButtons[i]);

                scene.repaint();
            }
        }
        for (int i = 0; i < userCards.length; i++) {
            if (userCards[i] != null) {
                HGraphicButton links = null, rechts = null;
                if (i > 0) {
                    links = userCardsButtons[i - 1];
                }
                if (i < userCards.length - 1) {
                    rechts = userCardsButtons[i + 1];
                }
                userCardsButtons[i].setFocusTraversal(deck, null, links, rechts);
            }
        }
        userCardsButtons[0].requestFocus();
        for (int i = 0; i < 7; i++) {
            String card;
            if (chanceOfWildCard > rnd.nextInt(100)) {
                maxRandom = 6;
            } else {
                maxRandom = 4;
            }
            switch (rnd.nextInt(maxRandom) + 1) {
                case 1:
                    card = "yellow_";
                    break;
                case 2:
                    card = "blue_";
                    break;
                case 3:
                    card = "green_";
                    break;
                case 4:
                    card = "red_";
                    break;
                case 5:
                    card = "wild_0.png";
                    break;
                case 6:
                    card = "wild_1.png";
                    break;
                default:
                    card = "yellow_";
                    break;
            }
            if (card.equals("wild_0.png") || card.equals("wild_1.png")) {
            } else {
                switch (rnd.nextInt(13)) {
                    case 0:
                        card += "0.png";
                        break;
                    case 1:
                        card += "1.png";
                        break;
                    case 2:
                        card += "2.png";
                        break;
                    case 3:
                        card += "3.png";
                        break;
                    case 4:
                        card += "4.png";
                        break;
                    case 5:
                        card += "5.png";
                        break;
                    case 6:
                        card += "6.png";
                        break;
                    case 7:
                        card += "7.png";
                        break;
                    case 8:
                        card += "8.png";
                        break;
                    case 9:
                        card += "9.png";
                        break;
                    case 10:
                        card += "picker.png";
                        break;
                    case 11:
                        card += "reverse.png";
                        break;
                    case 12:
                        card += "skip.png";
                        break;
                    default:
                        card += "0.png";
                        break;
                }
            }
            computer1Cards[i] = card;
        }

        for (int i = 0; i < 7; i++) {
            String card;
            if (chanceOfWildCard > rnd.nextInt(100)) {
                maxRandom = 6;
            } else {
                maxRandom = 4;
            }
            switch (rnd.nextInt(maxRandom) + 1) {
                case 1:
                    card = "yellow_";
                    break;
                case 2:
                    card = "blue_";
                    break;
                case 3:
                    card = "green_";
                    break;
                case 4:
                    card = "red_";
                    break;
                case 5:
                    card = "wild_0.png";
                    break;
                case 6:
                    card = "wild_1.png";
                    break;
                default:
                    card = "yellow_";
                    break;
            }
            if (card.equals("wild_0.png") || card.equals("wild_1.png")) {
            } else {
                switch (rnd.nextInt(13)) {
                    case 0:
                        card += "0.png";
                        break;
                    case 1:
                        card += "1.png";
                        break;
                    case 2:
                        card += "2.png";
                        break;
                    case 3:
                        card += "3.png";
                        break;
                    case 4:
                        card += "4.png";
                        break;
                    case 5:
                        card += "5.png";
                        break;
                    case 6:
                        card += "6.png";
                        break;
                    case 7:
                        card += "7.png";
                        break;
                    case 8:
                        card += "8.png";
                        break;
                    case 9:
                        card += "9.png";
                        break;
                    case 10:
                        card += "picker.png";
                        break;
                    case 11:
                        card += "reverse.png";
                        break;
                    case 12:
                        card += "skip.png";
                        break;
                    default:
                        card += "0.png";
                        break;
                }
            }
            computer2Cards[i] = card;
        }
    }

    public String TakeACard() //Get a card from the middle
    {

        String card;
        switch (rnd.nextInt(6) + 1) {
            case 1:
                card = "yellow_";
                break;
            case 2:
                card = "blue_";
                break;
            case 3:
                card = "green_";
                break;
            case 4:
                card = "red_";
                break;
            case 5:
                card = "wild_0.png";
                break;
            case 6:
                card = "wild_1.png";
                break;
            default:
                card = "yellow_";
                break;
        }
        if (!card.equals("wild_0.png") && !card.equals("wild_1.png")) {
            switch (rnd.nextInt(13)) {
                case 0:
                    card += "0.png";
                    break;
                case 1:
                    card += "1.png";
                    break;
                case 2:
                    card += "2.png";
                    break;
                case 3:
                    card += "3.png";
                    break;
                case 4:
                    card += "4.png";
                    break;
                case 5:
                    card += "5.png";
                    break;
                case 6:
                    card += "6.png";
                    break;
                case 7:
                    card += "7.png";
                    break;
                case 8:
                    card += "8.png";
                    break;
                case 9:
                    card += "9.png";
                    break;
                case 10:
                    card += "picker.png";
                    break;
                case 11:
                    card += "reverse.png";
                    break;
                case 12:
                    card += "skip.png";
                    break;
                default:
                    card += "0.png";
                    break;
            }
            return card;
        }
        return card;
    }

    public boolean CardPlayable(String card) //Check if card can be played
    {
        String cardNum;
        String lastCardNum;
        if (card.equals("wild_0.png") || card.equals("wild_1.png")) {
            return true;
        } else if (card.substring(0, 3).equals(lastCardPlayed.substring(0, 3))) {
            return true;
        } else {
            cardNum = card.substring(card.lastIndexOf('_') + 1); //should return everything after the '_'

            lastCardNum = lastCardPlayed.substring(lastCardPlayed.lastIndexOf('_') + 1);
            if (cardNum.substring(0, 1).equals(lastCardNum.substring(0, 1))) //compares the first character, which should be the numbers
            {
                return true;
            } else {
                return false;
            }
        }

    }

    public void StartComputerTurn(int computerNum) //Let the computer play
    {
        boolean cardLaid = false;

        switch (computerNum) {
            case 1:
                for (int i = 0; i < computer1Cards.length; i++) {
                    if (computer1Cards[i] != null) {
                        if (CardPlayable(computer1Cards[i])) {
                            System.out.println("PC legt " + computer1Cards[i]);
                            //play computer1Cards[i]
                            lastCardPlayed = computer1Cards[i];
                            lastCardPlayedImage = this.getToolkit().getImage(lastCardPlayed);
                            CheckForSpecialCard(computer1Cards[i]);
                            computer1Cards[i] = null;
                            computer1CardsLeft--;
                            cardLaid = true;
                            if (computer1CardsLeft == 1) {
                                msg.setTextContent("PC 1 UNO", HVisible.NORMAL_STATE);
                                msg.setBackground(Color.RED);
                                msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            }
                            if (computer1CardsLeft == 0) {
                                msg.setTextContent("PC 1 WON! GAME OVER", HVisible.NORMAL_STATE);
                                msg.setBackground(Color.RED);
                                msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                                currentPlayerTurn = -1;

                            }
                            scene.repaint();
                            DrawComputerCards();
                            break;
                        } else if (i == computer1Cards.length - 1) {
                            String cardReceived = TakeACard();
                            System.out.println("PC1 took a card");
                            computer1CardsLeft++;
                            if (computer1CardsLeft <= 12) {
                                for (int j = 0; j < computer1Cards.length; j++) {
                                    if (computer1Cards[j] == null) {
                                        computer1Cards[j] = cardReceived;
                                        break;
                                    }
                                }
                            } else {
                                msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                                msg.setBackground(Color.black);
                                msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                                scene.repaint();
                                currentPlayerTurn = -1;

                            }
                        }
                    }
                }
                if (cardLaid == false) {
                    String cardReceived = TakeACard();
                    System.out.println("PC1 took a card");
                    computer1CardsLeft++;
                    if (computer1CardsLeft <= 12) {
                        for (int j = 0; j < computer1Cards.length; j++) {
                            if (computer1Cards[j] == null) {
                                computer1Cards[j] = cardReceived;
                                break;
                            }
                        }
                    } else {
                        msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                        msg.setBackground(Color.black);
                        msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                        scene.repaint();
                        currentPlayerTurn = -1;

                    }
                }
                break;
            case 2:
                for (int i = 0; i < computer2Cards.length; i++) {
                    if (computer2Cards[i] != null) {
                        if (CardPlayable(computer2Cards[i])) {
                            System.out.println("PC2 legt " + computer2Cards[i]);
                            //play computer1Cards[i]
                            lastCardPlayed = computer2Cards[i];
                            lastCardPlayedImage = this.getToolkit().getImage(lastCardPlayed);
                            CheckForSpecialCard(computer2Cards[i]);
                            computer2Cards[i] = null;
                            computer2CardsLeft--;
                            cardLaid = true;
                            if (computer2CardsLeft == 1) {
                                msg.setTextContent("PC 2 UNO", HVisible.NORMAL_STATE);
                                msg.setBackground(Color.RED);
                                msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            }
                            if (computer2CardsLeft == 0) {
                                msg.setTextContent("PC 2 WON! GAME OVER", HVisible.NORMAL_STATE);
                                msg.setBackground(Color.RED);
                                msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                                currentPlayerTurn = -1;

                            }
                            scene.repaint();
                            DrawComputerCards();
                            break;
                        } else if (i == computer2Cards.length - 1) {
                            String cardReceived = TakeACard();
                            System.out.println("PC2 takes a card");
                            computer2CardsLeft++;
                            if (computer2CardsLeft <= 12) {
                                for (int j = 0; j < computer2Cards.length; j++) {
                                    if (computer2Cards[j] == null) {
                                        computer2Cards[j] = cardReceived;
                                        break;
                                    }
                                }
                            } else {
                                msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                                msg.setBackground(Color.black);
                                msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                                scene.repaint();
                                currentPlayerTurn = -1;

                            }
                        }
                    }
                }
                if (cardLaid == false) {
                    String cardReceived = TakeACard();
                    computer2CardsLeft++;
                    if (computer2CardsLeft <= 12) {
                        for (int j = 0; j < computer2Cards.length; j++) {
                            if (computer2Cards[j] == null) {
                                computer2Cards[j] = cardReceived;
                                break;
                            }
                        }
                    } else {
                        msg.setTextContent("PC FORFEITS! Player wins!!", HVisible.NORMAL_STATE);
                        msg.setBackground(Color.black);
                        msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                        scene.repaint();
                        currentPlayerTurn = -1;

                    }
                }
                break;
        }
        if (currentPlayerTurn != -1) {
            NextTurn();
        }
        DrawComputerCards();
    }

    public void CheckForSpecialCard(String card) {
        if (card.substring(0, 6).equals("wild_0")) {
            RandomCardMiddle();
        } else if (card.substring(0, 6).equals("wild_1")) {
            RandomCardMiddle();

            if (clockWise) {
                switch (currentPlayerTurn) {
                    case 0: // 4 kaarten voor computer 1

                        String cardReceived = TakeACard();
                        System.out.println("PC1 takes 4 cards");
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        DrawComputerCards();
                        break;
                    case 1: // 4 kaarten voor computer 2

                        cardReceived = TakeACard();
                        System.out.println("PC2 takes 4 cards");
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        DrawComputerCards();
                        break;
                    case 2: // 4 kaarten voor player
                        System.out.println("Player takes 4 cards");
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        break;
                }
            } else {
                switch (currentPlayerTurn) {
                    case 0: // 4 kaarten voor computer 2
                        System.out.println("PC2 takes 4 cards");
                        String cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        DrawComputerCards();
                        break;
                    case 1: // 4 kaarten voor player
                        System.out.println("Player takes 4 cards");
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        break;
                    case 2: // 4 kaarten voor computer 1
                        System.out.println("PC1 takes 4 cards");
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        DrawComputerCards();
                        break;
                }
            }

        } else if (card.substring(card.lastIndexOf('_') + 1).equals("picker.png")) {

            if (clockWise) {
                switch (currentPlayerTurn) {
                    case 0: // 2 kaarten voor computer 1

                        String cardReceived = TakeACard();
                        System.out.println("PC1 takes 2 cards");
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        DrawComputerCards();
                        break;
                    case 1: // 2 kaarten voor computer 2
                        System.out.println("PC2 takes 2 cards");
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        DrawComputerCards();
                        break;
                    case 2: // 2 kaarten voor player
                        System.out.print(("Player takes 2 cards"));
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        break;
                }
            } else {
                switch (currentPlayerTurn) {
                    case 0: // 2 kaarten voor computer 2
                        System.out.println("PC2 takes 2 cards");
                        String cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer2CardsLeft++;
                        if (computer2CardsLeft <= 12) {
                            for (int i = 0; i < computer2Cards.length; i++) {
                                if (computer2Cards[i] == null) {
                                    computer2Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        DrawComputerCards();
                        break;
                    case 1: // 2 kaarten voor player

                        cardReceived = TakeACard();
                        System.out.println("Player takes 2 cards");
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        userCardsLeft++;
                        if (userCardsLeft <= 12) {
                            for (int i = 0; i < userCards.length; i++) {
                                if (userCards[i] == null) {
                                    userCards[i] = cardReceived;
                                    userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                                    userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                                    userCardsButtons[i].setActionCommand(String.valueOf(i));
                                    userCardsButtons[i].addHActionListener(this);
                                    scene.add(userCardsButtons[i]);
                                    scene.popToFront(userCardsButtons[i]);
                                    break;
                                }
                            }
                            scene.repaint();
                            SetFocusValues();
                        } else {
                            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.RED);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        break;
                    case 2: // 2 kaarten voor computer 1

                        cardReceived = TakeACard();
                        System.out.println("PC1 takes 2 cards");
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        cardReceived = TakeACard();
                        computer1CardsLeft++;
                        if (computer1CardsLeft <= 12) {
                            for (int i = 0; i < computer1Cards.length; i++) {
                                if (computer1Cards[i] == null) {
                                    computer1Cards[i] = cardReceived;
                                    break;
                                }
                            }
                        } else {
                            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
                            msg.setBackground(Color.black);
                            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                            scene.repaint();
                            currentPlayerTurn = -1;

                        }
                        DrawComputerCards();
                        break;
                }
            }
        } else if (card.substring(card.lastIndexOf('_') + 1).equals("reverse.png")) {
            if (clockWise) {
                clockWise = false;
            } else {
                clockWise = true;
            }
        } else if (card.substring(card.lastIndexOf('_') + 1).equals("skip.png")) {
            if (clockWise) {
                currentPlayerTurn++;
                NextTurn();
            } else {
                currentPlayerTurn--;
                NextTurn();
            }
        }
    }

    public void NextTurn() //Set next player depending on clockwise turn.
    {
        mt.addImage(lastCardPlayedImage, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        if (userCardsLeft > 12) {
            msg.setBackground(Color.RED);
            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
            msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
            scene.repaint();
            currentPlayerTurn = -1;
        } else if (computer1CardsLeft > 12) {
            msg.setBackground(Color.black);
            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
            scene.repaint();
            currentPlayerTurn = -1;
        } else if (computer2CardsLeft > 12) {
            msg.setBackground(Color.black);
            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
            msg.setTextContent("PC FORFEIT! Player wins!!", HVisible.NORMAL_STATE);
            scene.repaint();
            currentPlayerTurn = -1;
        } else {
            if (clockWise) {
                currentPlayerTurn++;
                if (currentPlayerTurn > 2) {
                    currentPlayerTurn = 0;
                }
            } else {
                currentPlayerTurn--;
                if (currentPlayerTurn < 0) {
                    currentPlayerTurn = 2;
                }
            }

            if (currentPlayerTurn != 0) {
                msg.setBackground(Color.GRAY);
                msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                msg.setTextContent("Computer turn", HVisible.NORMAL_STATE);
                scene.repaint();
                StartComputerTurn(currentPlayerTurn);
            } else {
                msg.setBackground(Color.GRAY);
                msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                msg.setTextContent("Player turn", HVisible.NORMAL_STATE);
                scene.repaint();
            }
        }

    }

    public MijnComponent(int x1, int y1, int x2, int y2, HScene scene) {
        this.scene = scene;
        this.setBounds(x1, y1, x2, y2);
        //C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3
        background = this.getToolkit().getImage("background.jpg");
        cardDeck = this.getToolkit().getImage("card_back.png");

        deck.setActionCommand("TakeACard");
        deck.addHActionListener(this);
        scene.add(deck);
        scene.add(msg);
        RandomCardMiddle();
        mt.addImage(background, 1);
        mt.addImage(lastCardPlayedImage, 2);
        mt.addImage(cardDeck, 3);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        PlayGame();
        deck.setFocusTraversal(null, userCardsButtons[0], null, null);
    }

    public void paint(Graphics g) //scherm is 720 x 576
    {
        g.drawImage(background, 0, y, null);
        g.drawImage(lastCardPlayedImage, (720 / 2) - 10, (576 / 2) - 60, 50, 75, null);
        g.drawImage(cardDeck, (720 / 2) + 50, (576 / 2) - 60, 50, 75, null);
    }

    public void SetFocusValues() //Set the focus traversal values for all player cards
    {

        HGraphicButton links = null;
        HGraphicButton rechts = null;
        HGraphicButton down = null;

        for (int i = 0; i < userCardsButtons.length; i++) {
            if (userCardsButtons[i] != null) {
                down = userCardsButtons[i];
                userCardsButtons[i].requestFocus();
                break;
            }
        }
        deck.setFocusTraversal(null, down, null, null);

        for (int i = 0; i < userCardsButtons.length; i++) {
            if (i == 0) {
                if (userCardsButtons[i] != null) {
                    for (int j = i + 1; j < userCardsButtons.length; j++) {
                        if (userCardsButtons[j] != null) {
                            rechts = userCardsButtons[j];
                            break;
                        }
                    }
                    userCardsButtons[i].setFocusTraversal(deck, null, null, rechts);
                }
            }

            if (i == 11) {
                if (userCardsButtons[i] != null) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (userCardsButtons[j] != null) {
                            links = userCardsButtons[j];
                            break;
                        }
                    }
                    userCardsButtons[i].setFocusTraversal(deck, null, links, null);
                }
            }

            if (i != 0 && i != 11) {
                if (userCardsButtons[i] != null) {
                    for (int j = i + 1; j < userCardsButtons.length; j++) {
                        if (userCardsButtons[j] != null) {
                            rechts = userCardsButtons[j];
                            break;
                        }
                    }
                    for (int j = i - 1; j >= 0; j--) {
                        if (userCardsButtons[j] != null) {
                            links = userCardsButtons[j];
                            break;
                        }
                    }
                    userCardsButtons[i].setFocusTraversal(deck, null, links, rechts);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent arg0) //If enter is pressed on a card (button)
    {
        if (currentPlayerTurn == 0) {
            if (arg0.getActionCommand().equals("TakeACard")) {
                String cardReceived = TakeACard();
                userCardsLeft++;
                if (userCardsLeft <= 12) {
                    for (int i = 0; i < userCards.length; i++) {
                        if (userCards[i] == null) {
                            userCards[i] = cardReceived;
                            userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                            userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5 + (i * 55)), 495, 50, 75);
                            userCardsButtons[i].setActionCommand(String.valueOf(i));
                            userCardsButtons[i].addHActionListener(this);
                            scene.add(userCardsButtons[i]);
                            scene.popToFront(userCardsButtons[i]);
                            break;
                        }
                    }
                    scene.repaint();
                    SetFocusValues();
                } else {
                    msg.setTextContent("GAME OVER", HVisible.NORMAL_STATE);
                    msg.setBackground(Color.RED);
                    msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                    scene.repaint();
                    currentPlayerTurn = -1;

                }
                if (currentPlayerTurn != -1) {
                    NextTurn();
                }
            } else {
                if (CardPlayable(userCards[Integer.parseInt(arg0.getActionCommand())])) {
                    lastCardPlayed = userCards[Integer.parseInt(arg0.getActionCommand())];
                    lastCardPlayedImage = this.getToolkit().getImage(lastCardPlayed);
                    CheckForSpecialCard(userCards[Integer.parseInt(arg0.getActionCommand())]);
                    userCards[Integer.parseInt(arg0.getActionCommand())] = null;
                    userCardsImages[Integer.parseInt(arg0.getActionCommand())] = null;
                    scene.remove(userCardsButtons[Integer.parseInt(arg0.getActionCommand())]);
                    userCardsLeft--;
                    if (userCardsLeft == 1) {
                        msg.setTextContent("PLAYER UNO", HVisible.NORMAL_STATE);
                        msg.setBackground(Color.black);
                        msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                    }
                    if (userCardsLeft == 0) {
                        msg.setTextContent("GAME WON!!", HVisible.NORMAL_STATE);
                        msg.setBackground(Color.black);
                        msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                        currentPlayerTurn = -1;

                    }
                    userCardsButtons[Integer.parseInt(arg0.getActionCommand())] = null;
                    scene.repaint();
                    SetFocusValues();
                    if (currentPlayerTurn != -1) {
                        NextTurn();
                    }
                }
            }

        }
    }
}
