package hellotvxlet;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HSceneTemplate;
import org.havi.ui.HScreenDimension;
import org.havi.ui.HScreenPoint;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet {
    HScene scene;
    HSceneTemplate sceneTemplate;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      
      scene=HSceneFactory.getInstance().getBestScene(sceneTemplate);
     
      MijnComponent background = new MijnComponent(0,0,720,576);
      scene.add(background);
      
      scene.validate();
      scene.setVisible(true);
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void actionPerformed(ActionEvent arg0) {
        
//LES 1
//        System.out.println(arg0.getActionCommand());
//        
//            HStaticText msg= new HStaticText("msg", 300, 200, 100, 100);
//            msg.setBackground(Color.RED);
//            msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
//            if(arg0.getActionCommand().equals("knop3"))
//            {
//                msg.setTextContent("GOED", HVisible.NORMAL_STATE);
//                msg.setBackground(Color.GREEN);
//            }
//            else
//            {
//                msg.setTextContent("FOUT", HVisible.NORMAL_STATE);
//            }
//            scene.add(msg);
//            scene.popToFront(msg);
//            scene.repaint();
           
    }
}
