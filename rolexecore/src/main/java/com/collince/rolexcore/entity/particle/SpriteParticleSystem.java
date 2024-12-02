package com.collince.rolexcore.entity.particle;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.sprite.Sprite;
import com.collince.rolexcore.texture.Texture;
import com.collince.rolexcore.util.pool.Pool;
import com.collince.rolexcore.util.pool.SafeFixedObjectPool;



public class SpriteParticleSystem extends GenericParticleSystem {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public SpriteParticleSystem(Core core, Texture texture, int minCount) {
        this(core, texture, minCount, minCount);
    }

    public SpriteParticleSystem(Core core, Texture texture, int minCount, int maxCount) {
        super(core, new SafeFixedObjectPool<>(new Pool.PoolObjectFactory<Particle>() {
            @Override
            public Particle createObject() {
                return new GenericParticle<>(core, new Sprite(core, texture));
            }
        }, minCount, maxCount));
    }
    //========================================================

}
