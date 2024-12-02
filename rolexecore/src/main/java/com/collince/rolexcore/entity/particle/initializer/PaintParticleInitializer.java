package com.collince.rolexcore.entity.particle.initializer;

import android.graphics.Paint;

import com.collince.rolexcore.entity.particle.Particle;



public class PaintParticleInitializer implements ParticleInitializer {

    private final Paint mPaint;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public PaintParticleInitializer(Paint paint) {
        mPaint = paint;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void initParticle(Particle particle) {
        particle.setPaint(mPaint);
    }
    //========================================================

}
