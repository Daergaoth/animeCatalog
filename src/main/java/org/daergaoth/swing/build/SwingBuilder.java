package org.daergaoth.swing.build;

import org.daergaoth.Main;
import org.daergaoth.service.malAPI.MalService;
import org.daergaoth.staticPackage.StaticObjects;
import org.daergaoth.swing.elements.MyButton;
import org.daergaoth.swing.elements.MyFrame;
import org.daergaoth.swing.elements.MyLabel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.daergaoth.swing.elements.MyTextArea;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SwingBuilder {

    private static SwingBuilder instance = null;

    private final Map<String, Object> swingElements;

    //Only to speed up development
    private String defaultKeyword = "";
    //Only to speed up development
    private String defaultRootFolder = "";

    private SwingBuilder() {
        swingElements = new HashMap<>();
        defaultRootFolder = System.getProperty("user.dir");
        defaultKeyword = Main.class.getName();
    }

    public static SwingBuilder getInstance(){
        if (Objects.isNull(instance)){
            instance = new SwingBuilder();
        }
        return instance;
    }

    public void build() {
        try {
            MyFrame frame = new MyFrame();
            swingSetup(frame);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void swingSetup(MyFrame frame) {
        buildButton(frame,StaticObjects.SEARCH_BUTTON_KEY,1215,600,100,30).addActionListener(e -> {
            ButtonMethodProvider provider = ButtonMethodProvider.getInstance();
            provider.executeSearchButtonCommand(swingElements);
        });

        if(!StaticObjects.LOGOICON.isEmpty()){
            buildLogoIcon(frame, StaticObjects.LOGO_IMAGE_KEY, 20, 20, 120, 120);
        }

        buildInputLabel(frame, StaticObjects.QUERY_LABEL_KEY, 200, 50, 200, 30);
        buildUserInput(frame, StaticObjects.QUERY_INPUT_KEY, 400, 50, 800, 30,800, 30);

        startUp(frame);
    }



    private MyButton buildButton(MyFrame frame, String key, int x, int y, int width, int height){
        MyButton myButtonOne = new MyButton();
        myButtonOne.setupDefaultButton(x, y, width, height, key);

        frame.add(myButtonOne);
        swingElements.put(key, myButtonOne);

        return myButtonOne;
    }

    private void buildInputLabel(MyFrame frame, String key, int x, int y, int width, int height){
        MyLabel keywordLabelLabel = new MyLabel();
        keywordLabelLabel.setupTextField(x, y, width, height);
        keywordLabelLabel.setText(key + ":");
        frame.add(keywordLabelLabel);
        swingElements.put(key,keywordLabelLabel);
    }

    private void buildUserInput(MyFrame frame, String key, int x, int y, int width, int height, int areaWidth, int areaHeight){

        MyLabel keywordTextareaLabel = new MyLabel();
        keywordTextareaLabel.setupTextField(x, y, width, height);
        MyTextArea keywordTextArea = new MyTextArea();
        keywordTextArea.setupDefaultPanel();
        keywordTextArea.setSize(areaWidth, areaHeight);
        if (!defaultKeyword.isEmpty()) {
            keywordTextArea.setText(defaultKeyword);
        }
        keywordTextareaLabel.add(keywordTextArea);
        frame.add(keywordTextareaLabel);
        swingElements.put(key,keywordTextArea);
    }

    private void buildLogoIcon(MyFrame frame, String key, int x, int y, int width, int height){
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File(StaticObjects.LOGOICON));
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

    private void startUp(MyFrame frame){
        frame.setupDefaultFrame();
        frame.revalidate();
    }
}
