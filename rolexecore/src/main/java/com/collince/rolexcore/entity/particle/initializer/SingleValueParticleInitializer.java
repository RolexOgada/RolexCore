package com.collince.rolexcore.entity.particle.initializer;

import com.collince.rolexcore.entity.particle.Particle;
import com.collince.rolexcore.util.RandomUtils;



public abstract class SingleValueParticleInitializer implements ParticleInitializer {

    private final float mMinValue;
    private final float mMaxValue;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected SingleValueParticleInitializer(float minValue, float maxValue) {
        mMinValue = minValue;
        mMaxValue = maxValue;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void initParticle(Particle particle) {
        float value = RandomUtils.nextFloat(mMinValue, mMaxValue);
        onInitParticle(particle, value);
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected abstract void onInitParticle(Particle particle, float value);
    //========================================================

}
