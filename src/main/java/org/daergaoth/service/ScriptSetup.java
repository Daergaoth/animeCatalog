package org.daergaoth.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.daergaoth.model.ConfigurationModel;
import org.daergaoth.staticPackage.StaticObjects;

import java.io.File;
import java.util.Objects;

public class ScriptSetup {
    private static ScriptSetup instance;

    private ScriptSetup() {

    }

    public static ScriptSetup getInstance(){
        if(Objects.isNull(instance)){
            instance = new ScriptSetup();
        }
        return instance;
    }

    public void setupLogoIcon(){
        File iconFile = new File("src/main/resources/icon.png");
        if (iconFile.exists() && iconFile.isFile()) {
            StaticObjects.LOGO_ICON = "src/main/resources/icon.png";
        } else {
            iconFile = new File("classes/icon.png");
            if (iconFile.exists() && iconFile.isFile()) {
                StaticObjects.LOGO_ICON = "classes/icon.png";
            } else {
                iconFile = new File("icon.png");
                if (iconFile.exists() && iconFile.isFile()) {
                    StaticObjects.LOGO_ICON = "icon.png";
                }
            }
        }
    }

    public void setupConfiguration(){
        File configurationFile = new File("src/main/resources/configuration.xml");
        if (configurationFile.exists() && configurationFile.isFile()) {
            fetchConfiguration(configurationFile);
        } else {
            configurationFile = new File("classes/configuration.xml");
            if (configurationFile.exists() && configurationFile.isFile()) {
                fetchConfiguration(configurationFile);
            } else {
                configurationFile = new File("configuration.xml");
                if (configurationFile.exists() && configurationFile.isFile()) {
                    fetchConfiguration(configurationFile);
                }
            }
        }
    }

    private void fetchConfiguration(File configurationFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ConfigurationModel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ConfigurationModel configuration = (ConfigurationModel) jaxbUnmarshaller.unmarshal(configurationFile);
            System.out.println(configuration);
            StaticObjects.MAL_CLIENT_ID = configuration.clientId;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
