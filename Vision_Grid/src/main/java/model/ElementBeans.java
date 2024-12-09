package model;

import java.io.Serializable;

public class ElementBeans implements Serializable {

    private int elementId;
    private int visionId;
    private String position;
    private String elementKey;
    private String elementText;

    // Default Constructor
    public ElementBeans() {}

    // Constructor with specific fields
    public ElementBeans(int visionId, String position, String elementKey, String elementText) {
        this.visionId = visionId;
        this.position = position;
        this.elementKey = elementKey;
        this.elementText = elementText;
    }

    // Constructor with all fields
    public ElementBeans(int elementId, int visionId, String position, String elementKey, String elementText) {
        this.elementId = elementId;
        this.visionId = visionId;
        this.position = position;
        this.elementKey = elementKey;
        this.elementText = elementText;
    }

    // Getters and Setters
    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public int getVisionId() {
        return visionId;
    }

    public void setVisionId(int visionId) {
        this.visionId = visionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getElementKey() {
        return elementKey;
    }

    public void setElementKey(String elementKey) {
        this.elementKey = elementKey;
    }

    public String getElementText() {
        return elementText;
    }

    public void setElementText(String elementText) {
        this.elementText = elementText;
    }
}

