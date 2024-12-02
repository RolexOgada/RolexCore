package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.util.modifier.tween.Tweener;



public class FadeInModifier extends AlphaModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public FadeInModifier(long duration) {
        super(0, 255, duration);
    }

    public FadeInModifier(long duration, long startDelay) {
        super(0, 255, duration, startDelay);
    }

    public FadeInModifier(long duration, Tweener tweener) {
        super(0, 255, duration, tweener);
    }

    public FadeInModifier(long duration, long startDelay, Tweener tweener) {
        super(0, 255, duration, startDelay, tweener);
    }
    //========================================================

}
