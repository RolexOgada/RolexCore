package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.util.modifier.tween.Tweener;



public class ScaleOutModifier extends ScaleModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public ScaleOutModifier(long duration) {
        super(1, 0, duration);
    }

    public ScaleOutModifier(long duration, long startDelay) {
        super(1, 0, duration, startDelay);
    }

    public ScaleOutModifier(long duration, Tweener tweener) {
        super(1, 0, duration, tweener);
    }

    public ScaleOutModifier(long duration, long startDelay, Tweener tweener) {
        super(1, 0, duration, startDelay, tweener);
    }
    //========================================================

}
