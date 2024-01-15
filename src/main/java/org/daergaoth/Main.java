package org.daergaoth;

import org.daergaoth.staticPackage.StaticObjects;
import org.daergaoth.swing.build.SwingBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File testFile = new File("src/main/resources/icon.png");
        if (testFile.exists() && testFile.isFile()) {
            StaticObjects.LOGOICON = "src/main/resources/icon.png";
        } else {
            testFile = new File("classes/icon.png");
            if (testFile.exists() && testFile.isFile()) {
                StaticObjects.LOGOICON = "classes/icon.png";
            } else {
                testFile = new File("icon.png");
                if (testFile.exists() && testFile.isFile()) {
                    StaticObjects.LOGOICON = "icon.png";
                }
            }
        }
        SwingBuilder builder = SwingBuilder.getInstance();
        builder.build();

    }
}