package org.daergaoth.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfigurationModel {
    @XmlElement(name="client-id")
    public String clientId;
}
