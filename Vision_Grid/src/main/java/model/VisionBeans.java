package model;

import java.io.Serializable;

public class VisionBeans implements Serializable {

    private int visionId;
    private int userId;
    private String visionKey;
    private String visionText;

    // Default Constructor
    public VisionBeans() {}

    // Constructor with specific fields
    public VisionBeans(int userId, String visionKey, String visionText) {
        this.userId = userId;
        this.visionKey = visionKey;
        this.visionText = visionText;
    }

    // Constructor with all fields
    public VisionBeans(int visionId, int userId, String visionKey, String visionText) {
        this.visionId = visionId;
        this.userId = userId;
        this.visionKey = visionKey;
        this.visionText = visionText;
    }

    // Getters and Setters
    public int getVisionId() {
        return visionId;
    }

    public void setVisionId(int visionId) {
        this.visionId = visionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVisionKey() {
        return visionKey;
    }

    public void setVisionKey(String visionKey) {
        this.visionKey = visionKey;
    }

    public String getVisionText() {
        return visionText;
    }

    public void setVisionText(String visionText) {
        this.visionText = visionText;
    }
}

