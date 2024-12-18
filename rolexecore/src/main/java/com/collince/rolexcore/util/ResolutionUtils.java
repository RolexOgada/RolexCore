package com.collince.rolexcore.util;



public class ResolutionUtils {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    private ResolutionUtils() {
    }
    //========================================================

    //--------------------------------------------------------
    // Static methods
    //--------------------------------------------------------
    public static int getResolutionWidth(int screenWidth, int screenHeight, int worldWidth, int worldHeight) {
        float screenRatio = screenWidth * 1f / screenHeight;
        float worldRatio = worldWidth * 1f / worldHeight;
        return screenRatio > worldRatio ? screenWidth : (int) (screenHeight * worldRatio);
    }

    public static int getResolutionHeight(int screenWidth, int screenHeight, int worldWidth, int worldHeight) {
        float screenRatio = screenWidth * 1f / screenHeight;
        float worldRatio = worldWidth * 1f / worldHeight;
        return screenRatio > worldRatio ? (int) (screenWidth / worldRatio) : screenHeight;
    }
    //========================================================

}
