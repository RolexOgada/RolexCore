package com.collince.rolexcore.entity.particle;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.shape.primitive.Circle;
import com.collince.rolexcore.util.pool.Pool;
import com.collince.rolexcore.util.pool.SafeFixedObjectPool;



public class CircleParticleSystem extends GenericParticleSystem {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public CircleParticleSystem(Core core, int radius, int minCount) {
        this(core, radius, minCount, minCount);
    }

    public CircleParticleSystem(Core core, int radius, int minCount, int maxCount) {
        super(core, new SafeFixedObjectPool<>(new Pool.PoolObjectFactory<Particle>() {
            @Override
            public Particle createObject() {
                return new GenericParticle<>(core, new Circle(core, radius));
            }
        }, minCount, maxCount));
    }
    //========================================================

}
