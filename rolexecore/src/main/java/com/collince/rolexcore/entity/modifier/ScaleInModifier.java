package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.util.modifier.tween.Tweener;



public class ScaleInModifier extends ScaleModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public ScaleInModifier(long duration) {
        super(0, 1, duration);
    }

    public ScaleInModifier(long duration, long startDelay) {
        super(0, 1, duration, startDelay);
    }

    public ScaleInModifier(long duration, Tweener tweener) {
        super(0, 1, duration, tweener);
    }

    public ScaleInModifier(long duration, long startDelay, Tweener tweener) {
        super(0, 1, duration, startDelay, tweener);
    }
    //========================================================

}
