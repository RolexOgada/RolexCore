package com.collince.rolexcore.input.touch;

import android.view.View;

import com.collince.rolexcore.input.InputController;

import java.util.List;



public interface TouchController extends InputController, View.OnTouchListener {

    float getTouchX();

    float getTouchY();

    boolean isTouchDown();

    List<TouchEvent> getTouchEvents();

}
