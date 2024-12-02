package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.util.modifier.tween.Tweener;



public class FadeOutModifier extends AlphaModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public FadeOutModifier(long duration) {
        super(255, 0, duration);
    }

    public FadeOutModifier(long duration, long startDelay) {
        super(255, 0, duration, startDelay);
    }

    public FadeOutModifier(long duration, Tweener tweener) {
        super(255, 0, duration, tweener);
    }

    public FadeOutModifier(long duration, long startDelay, Tweener tweener) {
        super(255, 0, duration, startDelay, tweener);
    }
    //========================================================

}
