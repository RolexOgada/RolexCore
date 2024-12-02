package com.collince.rolexcore.entity.particle.modifier;

import com.collince.rolexcore.entity.particle.Particle;



public interface ParticleModifier {

    void updateParticle(Particle particle, long elapsedMillis);

}
