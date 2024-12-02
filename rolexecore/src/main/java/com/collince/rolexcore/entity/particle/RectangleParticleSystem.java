package com.collince.rolexcore.entity.particle;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.shape.primitive.Rectangle;
import com.collince.rolexcore.util.pool.Pool;
import com.collince.rolexcore.util.pool.SafeFixedObjectPool;



public class RectangleParticleSystem extends GenericParticleSystem {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public RectangleParticleSystem(Core core, int width, int height, int minCount) {
        this(core, width, height, minCount, minCount);
    }

    public RectangleParticleSystem(Core core, int width, int height, int minCount, int maxCount) {
        super(core, new SafeFixedObjectPool<>(new Pool.PoolObjectFactory<Particle>() {
            @Override
            public Particle createObject() {
                return new GenericParticle<>(core, new Rectangle(core, width, height));
            }
        }, minCount, maxCount));
    }
    //========================================================

}
