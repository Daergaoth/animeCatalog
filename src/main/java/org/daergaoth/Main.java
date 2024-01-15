package org.daergaoth;

import org.daergaoth.service.ScriptSetup;
import org.daergaoth.staticPackage.StaticObjects;
import org.daergaoth.swing.build.SwingBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        ScriptSetup scriptSetup = ScriptSetup.getInstance();
        scriptSetup.setupLogoIcon();
        scriptSetup.setupConfiguration();



        SwingBuilder builder = SwingBuilder.getInstance();
        builder.build();

    }
}