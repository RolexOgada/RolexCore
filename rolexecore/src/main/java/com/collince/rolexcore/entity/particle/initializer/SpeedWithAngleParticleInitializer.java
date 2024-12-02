package com.collince.rolexcore.entity.particle.initializer;

import com.collince.rolexcore.entity.particle.Particle;



public class SpeedWithAngleParticleInitializer extends DoubleValueParticleInitializer {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public SpeedWithAngleParticleInitializer(float minValueX, float maxValueX, float minValueY, float maxValueY) {
        super(minValueX, maxValueX, minValueY, maxValueY);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onInitParticle(Particle particle, float speed, float angle) {
        double angleInRads = Math.toRadians(angle);
        float valueX = (float) (speed * Math.cos(angleInRads) / 1000);
        float valueY = (float) (speed * Math.sin(angleInRads) / 1000);
        particle.setSpeedX(valueX);
        particle.setSpeedY(valueY);
    }
    //========================================================

}
