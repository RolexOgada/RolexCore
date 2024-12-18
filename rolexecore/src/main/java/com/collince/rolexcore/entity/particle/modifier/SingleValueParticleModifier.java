package com.collince.rolexcore.entity.particle.modifier;

import com.collince.rolexcore.entity.particle.Particle;



public abstract class SingleValueParticleModifier implements ParticleModifier {

    private final float mStartValue;
    private final float mRange;
    private final long mStartDelay;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected SingleValueParticleModifier(float startValue, float endValue, long startDelay) {
        mStartValue = startValue;
        mRange = endValue - startValue;
        mStartDelay = startDelay;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void updateParticle(Particle particle, long elapsedMillis) {
        if (elapsedMillis < mStartDelay) {
            onUpdateParticle(particle, mStartValue);
        } else {
            float percentage = (elapsedMillis - mStartDelay) * 1f / (particle.getDuration() - mStartDelay);
            float value = mStartValue + mRange * percentage;
            onUpdateParticle(particle, value);
        }
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected abstract void onUpdateParticle(Particle particle, float value);
    //========================================================

}
