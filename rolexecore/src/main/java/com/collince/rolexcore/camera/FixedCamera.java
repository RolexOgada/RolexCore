package com.collince.rolexcore.camera;



public class FixedCamera extends BaseCamera {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public FixedCamera(int cameraWidth, int cameraHeight) {
        super(cameraWidth, cameraHeight);
    }

    public FixedCamera(int cameraWidth, int cameraHeight, int worldWidth, int worldHeight) {
        super(cameraWidth, cameraHeight, worldWidth, worldHeight);
    }

    public FixedCamera(int cameraWidth, int cameraHeight, int worldWidth, int worldHeight, int projectWorldWidth, int projectWorldHeight) {
        super(cameraWidth, cameraHeight, worldWidth, worldHeight, projectWorldWidth, projectWorldHeight);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void update(long elapsedMillis) {
    }
    //========================================================

}
