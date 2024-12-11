package model;

import java.io.Serializable;

public class ActionBeans implements Serializable {

    private int actionId;
    private int elementId;
    private String position;
    private String actionKey;
    private String actionText;

    // Default Constructor
    public ActionBeans() {}

    // Constructor 
    public ActionBeans(int elementId, String position, String actionKey, String actionText) {
        this.elementId = elementId;
        this.position = position;
        this.actionKey = actionKey;
        this.actionText = actionText;
    }
    
    public ActionBeans( String position, String actionKey, String actionText) {
        this.position = position;
        this.actionKey = actionKey;
        this.actionText = actionText;
    }

    public ActionBeans(int actionId, int elementId, String position, String actionKey, String actionText) {
        this.actionId = actionId;
        this.elementId = elementId;
        this.position = position;
        this.actionKey = actionKey;
        this.actionText = actionText;
    }
    
    
    
    

    // Getters and Setters
    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getActionKey() {
        return actionKey;
    }

    public void setActionKey(String actionKey) {
        this.actionKey = actionKey;
    }

    public String getActionText() {
        return actionText;
    }

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }
}
