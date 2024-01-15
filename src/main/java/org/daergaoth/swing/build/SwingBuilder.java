package org.daergaoth.swing.build;

import org.daergaoth.Main;
import org.daergaoth.model.anime.Anime;
import org.daergaoth.model.mal.MalApiResponse;
import org.daergaoth.staticPackage.StaticObjects;
import org.daergaoth.swing.elements.MyButton;
import org.daergaoth.swing.elements.MyFrame;
import org.daergaoth.swing.elements.MyLabel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.daergaoth.swing.elements.MyTextArea;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SwingBuilder {

    private static SwingBuilder instance = null;

    private MyFrame frame;

    private final Map<String, Object> swingElements;
    //Only to speed up development
    private String defaultRootFolder = "";

    private SwingBuilder() {
        swingElements = new HashMap<>();
        defaultRootFolder = System.getProperty("user.dir");
    }

    public static SwingBuilder getInstance(){
        if (Objects.isNull(instance)){
            instance = new SwingBuilder();
        }
        return instance;
    }

    public Map<String, Object> getSwingElements() {
        return swingElements;
    }

    public void build() {
        try {
            if(Objects.isNull(frame)){
                this.frame = new MyFrame();
            }
            swingSetupSearchFrame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void swingSetupSearchFrame() {
        // Build Search Button
        buildButton(StaticObjects.SEARCH_BUTTON_KEY,1215,600,100,30).addActionListener(e -> {
            cleanFrame();
            buildLogoIcon(StaticObjects.LOGO_IMAGE_KEY, 612, 20, 120, 120);
            ButtonMethodProvider provider = ButtonMethodProvider.getInstance();
            List<Anime> searchResult = provider.executeSearchButtonCommand(swingElements);
            System.out.println();

        });

        // Build Exit Button
        buildButton(StaticObjects.EXIT_BUTTON_KEY,1215,50,100,30).addActionListener(e -> {
            ButtonMethodProvider provider = ButtonMethodProvider.getInstance();
//            cleanFrame();
//            System.out.println("EXIT-ONE");
            // Build Exit Button
//            buildButton(StaticObjects.EXIT_BUTTON_KEY,1215,50,100,30).addActionListener(f -> {
////                ButtonMethodProvider provider = ButtonMethodProvider.getInstance();
//                cleanFrame();
//                swingSetupSearchFrame();
//                revalidateFrame();
//                System.out.println("EXIT-TWO");
//
////            provider.executeExitButtonCommand();
//            });
            provider.executeExitButtonCommand();
        });

        // Build Logo Image
        if(!StaticObjects.LOGO_ICON.isEmpty()){
            buildLogoIcon(StaticObjects.LOGO_IMAGE_KEY, 20, 20, 120, 120);
        }

        // Build Mal Client ID Input
        buildInputLabel(StaticObjects.MAL_CLIENT_ID_LABEL_KEY, 200, 50, 200, 30);
        buildUserInput(StaticObjects.MAL_CLIENT_ID_INPUT_KEY, StaticObjects.MAL_CLIENT_ID, 400, 50, 800, 30,800, 30);

        // Build query Input
        buildInputLabel(StaticObjects.QUERY_LABEL_KEY, 200, 100, 200, 30);
        buildUserInput(StaticObjects.QUERY_INPUT_KEY, Main.class.getName(), 400, 100, 800, 30,800, 30);

        // Start up frame
        revalidateFrame();
    }



    private MyButton buildButton(String key, int x, int y, int width, int height){
        MyButton myButtonOne = new MyButton();
        myButtonOne.setupDefaultButton(x, y, width, height, key);
        frame.add(myButtonOne);
        swingElements.put(key, myButtonOne);
        return myButtonOne;

    }

    private void buildInputLabel(String key, int x, int y, int width, int height){
        MyLabel keywordLabelLabel = new MyLabel();
        keywordLabelLabel.setupTextField(x, y, width, height);
        keywordLabelLabel.setText(key + ":");
        frame.add(keywordLabelLabel);
        swingElements.put(key,keywordLabelLabel);
    }

    private void buildUserInput(String key, String placeholder, int x, int y, int width, int height, int areaWidth, int areaHeight){

        MyLabel keywordTextareaLabel = new MyLabel();
        keywordTextareaLabel.setupTextField(x, y, width, height);
        MyTextArea keywordTextArea = new MyTextArea();
        keywordTextArea.setupDefaultPanel();
        keywordTextArea.setSize(areaWidth, areaHeight);
        if (!placeholder.isEmpty()) {
            keywordTextArea.setText(placeholder);
        }
        keywordTextareaLabel.add(keywordTextArea);
        frame.add(keywordTextareaLabel);
        swingElements.put(key,keywordTextArea);
    }

    private void buildLogoIcon(String key, int x, int y, int width, int height){
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File(StaticObjects.LOGO_ICON));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (Objects.nonNull(myPicture)) {
            MyLabel picLabel = new MyLabel();
            picLabel.setupTextField(x, y, width, height);
            Image image = new ImageIcon(myPicture).getImage();
            Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(newimg);
            picLabel.setIcon(imageIcon);
            frame.add(picLabel);
            swingElements.put(key, picLabel);
        }
    }

    private void cleanFrame(){
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    private void revalidateFrame(){
        frame.setupDefaultFrame();
        frame.revalidate();
    }
}
