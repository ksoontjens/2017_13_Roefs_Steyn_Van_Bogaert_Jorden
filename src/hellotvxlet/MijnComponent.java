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
    int x = 350;
    int y = 0;
    HScene scene;
    Random rnd = new Random();
    
    String[] userCards = new String[12];
    String[] computer1Cards = new String[12];
    String[] computer2Cards = new String[12];
    
    Image[] userCardsImages = new Image[15];
    HGraphicButton[] userCardsButtons = new HGraphicButton[12];
    
    int userCardsLeft = 7;
    int computer1CardsLeft = 7;
    int computer2CardsLeft = 7;
    
    int currentPlayerTurn = 0;
    boolean clockWise = true;
    
    MediaTracker cardTracker = new MediaTracker(this);
//    Image cardtest = this.getToolkit().getImage("blue_0.png");
    
    int tracker = 2;
    
    public void PlayGame() {
        
        DivideCardsOnStart();
        
//        for(int i = 0; i < userCardsImages.length; i++)
//        {
//            if(userCardsImages[i] != null)
//            {
//                userCardsButtons[i].setBackgroundMode(HVisible.BACKGROUND_FILL);
//                cardTracker.addImage(userCardsImages[i], tracker);
//                tracker++;
//            }
//        }
        try {
            cardTracker.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        
        if(currentPlayerTurn == 0)
        {
            System.out.println("Player Turn!");
            System.out.println("userCardsLeft: " +userCardsLeft);
            System.out.println("Player cards: ");
            for(int i = 0; i < userCards.length; i++)
            {
                System.out.print(userCards[i] + " - ");
            }
            
            System.out.println("PC1 cards: ");
            for(int i = 0; i < computer1Cards.length; i++)
            {
                System.out.print(computer1Cards[i] + " - ");
            }
            System.out.println("PC2 cards: ");
            for(int i = 0; i < computer2Cards.length; i++)
            {
                System.out.print(computer2Cards[i] + " - ");
            }
            
        }
    }
    
    public void DivideCardsOnStart() {
         for(int i = 0; i <7; i++)
        {
            String card;
            switch(rnd.nextInt(4)+1)
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
              userCardsButtons[i].setFocusTraversal(null,null,links,rechts);
             }
         }      
         userCardsButtons[0].requestFocus();
        for(int i = 0; i <7; i++)
        {
            String card;
            switch(rnd.nextInt(4)+1)
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
            switch(rnd.nextInt(4)+1)
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
        return "s";
    }
    
    public void CheckIfCardIsGood(String cardToLay) {
        
    }
    
    
    

    public MijnComponent(int x1, int y1, int x2, int y2, HScene scene)
    {
        this.scene=scene;
        this.setBounds(x1, y1, x2, y2);
        //C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3
        background = this.getToolkit().getImage("background.jpg");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(background, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
//        UserEventRepository repo = new UserEventRepository("repo");
//        repo.addAllArrowKeys();
//        repo.addKey(HRcEvent.VK_ENTER);
//        EventManager manager = EventManager.getInstance();
//        manager.addUserEventListener(this, repo); //bovenaan bij implement UserEventListener toevoegen
        
        PlayGame();
    }
    
    
    //OEF 2 BLZ 44
    public void paint(Graphics g) 
    {
          g.drawImage(background, 0, y, null);
//          g.drawImage(cardtest, 0, 495, 50, 75, null);
//          for(int i = 0; i < userCardsImages.length; i++)
//          {
//              if(userCardsImages[i] != null)
//              {
//                  g.drawImage(userCardsImages[i],(5+(i*55)),495, 50, 75, null);
//              }
//          }
          //g.drawImage(schip, x, 500, null);
//        g.setColor(new DVBColor(0,0,255,127));
//        g.fillRoundRect(0,0,200,100,15,15); //x,y,w,h,r1,r2
//        g.fillRoundRect(5,5,200,100,15,15); //x,y,w,h,r1,r2
//        g.setColor(new DVBColor(255,255,0,255));
//        g.drawString("Dit is tekst", 40, 40);
    }

//    public void userEventReceived(UserEvent e) {
//        if(e.getType() == HRcEvent.KEY_PRESSED && currentPlayerTurn == 0)
//        {
//            if(e.getCode() == HRcEvent.VK_LEFT)
//            {
//                System.out.println("left key");
//            }
//            if(e.getCode() == HRcEvent.VK_RIGHT)
//            {
//                System.out.println("right key");
//            }
//            if(e.getCode() == HRcEvent.VK_ENTER)
//            {
//                System.out.println("enter key");
//            }
//        }
//    }

    public void actionPerformed(ActionEvent arg0) { //If enter is pressed on a card (button)
        System.out.println("ACTION="+arg0.getActionCommand());
    }
}
