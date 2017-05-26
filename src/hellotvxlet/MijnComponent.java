/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;
import org.havi.ui.HGraphicButton;
import org.havi.ui.HScene;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

public class MijnComponent extends HComponent implements  /*UserEventListener,*/ HActionListener {
    
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
    
    HGraphicButton deck = new HGraphicButton(cardDeck, (720/2)+50, (576/2)-60, 50, 75);
    
    int userCardsLeft = 7;
    int computer1CardsLeft = 7;
    int computer2CardsLeft = 7;
    
    int currentPlayerTurn = 0; //0 = player, 1 = pc 1, 2 = pc2
    boolean clockWise = true;
    
    int chanceOfWildCard = 10;
    int maxRandom = 4;
    
    String lastCardPlayed;
    Image lastCardPlayedImage;
    
    public void PlayGame() {
        
        DivideCardsOnStart();
        currentPlayerTurn = 0;
        
        if(currentPlayerTurn == 0)
        {
            System.out.println("Player Turn!");
            System.out.println("userCardsLeft: " +userCardsLeft);
            
            
        }
    }
    
    public void RandomCardMiddle() {
        switch(rnd.nextInt(maxRandom)+1)
            {
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
        switch(rnd.nextInt(13))
                {
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
    }
    
    public void DivideCardsOnStart() {
        
         for(int i = 0; i <7; i++)
        {
            String card;
            
            if(chanceOfWildCard > rnd.nextInt(100)) 
            {
                maxRandom = 6;
            }
            else
            {
                maxRandom = 4;
            } 
            
            switch(rnd.nextInt(maxRandom)+1)
            {
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
            if(card.equals("wild_0.png") || card.equals("wild_1.png"))
            {
                
            }
            else
            {
                switch(rnd.nextInt(13))
                {
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
         
         for(int i = 0; i < userCards.length; i++)
         {
             if(userCards[i] != null)
             {
                 userCardsImages[i] = this.getToolkit().getImage(userCards[i]);
                 userCardsButtons[i] = new HGraphicButton(userCardsImages[i], (5+(i*55)),495, 50, 75);
                   userCardsButtons[i].setActionCommand(String.valueOf(i));
                     userCardsButtons[i].addHActionListener(this);
                 scene.add(userCardsButtons[i]);
                 
                 scene.repaint();
             }
         }
           for(int i = 0; i < userCards.length; i++)
         {
             if(userCards[i] != null)
             {
                 HGraphicButton links=null,rechts=null;
                 if (i>0) links=userCardsButtons[i-1];
                 if (i<userCards.length-1) rechts=userCardsButtons[i+1];
              userCardsButtons[i].setFocusTraversal(deck,null,links,rechts);
             }
         }      
         userCardsButtons[0].requestFocus();
        for(int i = 0; i <7; i++)
        {
            String card;
            if(chanceOfWildCard > rnd.nextInt(100)) 
            {
                maxRandom = 6;
            }
            else
            {
                maxRandom = 4;
            } 
            switch(rnd.nextInt(maxRandom)+1)
            {
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
            if(card.equals("wild_0.png") || card.equals("wild_1.png"))
            {
                
            }
            else
            {
                switch(rnd.nextInt(13))
                {
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
        
        for(int i = 0; i <7; i++)
        {
            String card;
            if(chanceOfWildCard > rnd.nextInt(100)) 
            {
                maxRandom = 6;
            }
            else
            {
                maxRandom = 4;
            } 
            switch(rnd.nextInt(maxRandom)+1)
            {
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
            if(card.equals("wild_0.png") || card.equals("wild_1.png"))
            {
                
            }
            else
            {
                switch(rnd.nextInt(13))
                {
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
    
    public String TakeACard() {

            String card;
            switch(rnd.nextInt(6)+1)
            {
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
            if(!card.equals("wild_0.png") && !card.equals("wild_1.png"))
            {        
                switch(rnd.nextInt(13))
                {
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
    

    public boolean CardPlayable(String card)
    {
        if (card.equals("wild_0.png") || card.equals("wild_1.png"))
        {
            return true;
        }   
        else if (card.substring(0,3).equals(lastCardPlayed.substring(0,3)))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public void StartComputerTurn(Int computerNum)
    {
        boolean cardPlayed = false;
        switch (computerNum)
            case 1:
                for(int i = 0; i < computer1Cards.Length; i++)
                {
                   if(CardPlayable(computer1Cards[i]))
                   {
                        //play computer1Cards[i]
                        NextTurn();
                        break;
                    }
                }
            case 2:
                for(int i = 0; i < computer2Cards.Length; i++)
                {
                   if(CardPlayable(computer2Cards[i]))
                   {
                        //play computer2Cards[i]
                        NextTurn();
                        break;
                    }
                }            
    }


    
    public void NextTurn() //Set next player depending on clockwise turn.
    {
        if(clockWise)
        {
            currentPlayerTurn++;
            if(currentPlayerTurn > 2)
            {
                currentPlayerTurn = 0;
            }
        }
        else
        {
            currentPlayerTurn--;
            if(currentPlayerTurn < 0)
            {
                currentPlayerTurn = 2;
            }
        }
        
        if(currentPlayerTurn != 0)
        {
            StartComputerTurn(currentPlayerTurn)
        }
    }
    
     

    public MijnComponent(int x1, int y1, int x2, int y2, HScene scene)
    {
        this.scene=scene;
        this.setBounds(x1, y1, x2, y2);
        //C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3
        background = this.getToolkit().getImage("background.jpg");
        cardDeck = this.getToolkit().getImage("card_back.png");
        
        deck.setActionCommand("TakeACard");
        deck.addHActionListener(this);
        scene.add(deck);
        RandomCardMiddle();
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(background, 1);
        mt.addImage(lastCardPlayedImage, 2);
        mt.addImage(cardDeck, 3);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        PlayGame();        
        deck.setFocusTraversal(null,userCardsButtons[0],null,null);
    }
    
    
    public void paint(Graphics g) //scherm is 720 x 576
    {
          g.drawImage(background, 0, y, null);
          g.drawImage(lastCardPlayedImage, (720/2)-10, (576/2)-60, 50, 75, null);
          g.drawImage(cardDeck, (720/2)+50, (576/2)-60, 50, 75, null);
    }
    
    public void SetFocusValues() {
        
        HGraphicButton links = null;
        HGraphicButton rechts = null;
        HGraphicButton down = null;
        
        for (int i = 0; i < userCardsButtons.length; i++)
        {
            if(userCardsButtons[i] != null)
            {
                down = userCardsButtons[i];
                break;
            }
        }
        deck.setFocusTraversal(null, down, null, null);
        
        for(int i = 0; i < userCardsButtons.length; i++)
        {
            if(i == 0)
            {
                if(userCardsButtons[i] != null)
                {
                    for(int j = i+1; j < userCardsButtons.length; j++)
                    {
                        if(userCardsButtons[j] != null)
                        {
                            rechts = userCardsButtons[j];
                            break;
                        }
                    }
                    userCardsButtons[i].setFocusTraversal(deck,null,null,rechts);
                }
            }
            
            if(i == 11)
            {
                if(userCardsButtons[i] != null)
                {
                    for(int j = i-1; j >= 0; j--)
                    {
                        if(userCardsButtons[j] != null)
                        {
                            links = userCardsButtons[j];
                            break;
                        }
                    }
                    userCardsButtons[i].setFocusTraversal(deck,null,links,null);
                }
            }
            
            if(i != 0 && i != 11)
            {
                if(userCardsButtons[i] != null)
                {
                    for(int j = i+1; j < userCardsButtons.length; j++)
                    {
                        if(userCardsButtons[j] != null)
                        {
                            rechts = userCardsButtons[j];
                            break;
                        }
                    }
                    for(int j = i-1; j >= 0; j--)
                    {
                        if(userCardsButtons[j] != null)
                        {
                            links = userCardsButtons[j];
                            break;
                        }
                    }
                    userCardsButtons[i].setFocusTraversal(deck,null,links,rechts);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent arg0) { //If enter is pressed on a card (button)
        System.out.println("ACTION="+arg0.getActionCommand());
        if(currentPlayerTurn == 0)
        {
          if(arg0.getActionCommand().equals("TakeACard"))
            {
                System.out.println(TakeACard());
            }
          else
          {
              if(CardPlayable(userCards[Integer.parseInt(arg0.getActionCommand())]))
              {
                  lastCardPlayed = userCards[Integer.parseInt(arg0.getActionCommand())];
                  lastCardPlayedImage = this.getToolkit().getImage(lastCardPlayed);
                  userCards[Integer.parseInt(arg0.getActionCommand())] = null;
                  userCardsImages[Integer.parseInt(arg0.getActionCommand())] = null;
                  scene.remove(userCardsButtons[Integer.parseInt(arg0.getActionCommand())]);
                  userCardsButtons[Integer.parseInt(arg0.getActionCommand())] = null;
                  scene.repaint();
                  SetFocusValues();
              }
          }
          
        }
//        lastCardPlayedImage = this.getToolkit().getImage(("card_back.png"));
//        scene.repaint();
    }
}
