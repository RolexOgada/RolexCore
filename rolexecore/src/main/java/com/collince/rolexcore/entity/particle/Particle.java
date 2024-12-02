package com.collince.rolexcore.entity.particle;

import android.graphics.Paint;

import com.collince.rolexcore.entity.Reusable;
import com.collince.rolexcore.entity.particle.initializer.ParticleInitializer;
import com.collince.rolexcore.entity.particle.modifier.ParticleModifier;

import java.util.List;



public interface Particle extends Reusable<Particle> {

    long getDuration();

    void setDuration(long duration);

    void setSpeedX(float speedX);

    void setSpeedY(float speedY);

    void setAccelerationX(float accelerationX);

    void setAccelerationY(float accelerationY);

    void setRotationSpeed(float rotationSpeed);

    void setRotation(float rotation);

    void setScale(float scale);

    void setAlpha(int alpha);

    void setPaint(Paint paint);

    void setParticleInitializer(List<ParticleInitializer> initializers);

    void setParticleModifier(List<ParticleModifier> modifiers);

    void activate(float x, float y, int layer);

}
