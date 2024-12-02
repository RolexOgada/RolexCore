package com.collince.rolexcore.entity.particle.modifier;

import com.collince.rolexcore.entity.particle.Particle;



public class AlphaParticleModifier extends SingleValueParticleModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public AlphaParticleModifier(float startValue, float endValue, long startDelay) {
        super(startValue, endValue, startDelay);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onUpdateParticle(Particle particle, float value) {
        particle.setAlpha((int) value);
    }
    //========================================================

}
