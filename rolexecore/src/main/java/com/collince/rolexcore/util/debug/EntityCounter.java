package com.collince.rolexcore.util.debug;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.core.CoreListener;
import com.collince.rolexcore.entity.Updatable;
import com.collince.rolexcore.entity.text.Text;

import java.util.HashMap;
import java.util.Map;



public class EntityCounter extends Text implements CoreListener {

    private int mEntityCount;

    private final StringBuilder mStringBuilder = new StringBuilder();
    private final Map<String, Integer> mEntityCountMap = new HashMap<>();

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public EntityCounter(Core core, int width, int height) {
        this(core, 0, 0, width, height);
    }

    public EntityCounter(Core core, float x, float y, int width, int height) {
        super(core, x, y, width, height);
        core.addListener(this);
        setCoordinateType(Camera.CoordinateType.CAMERA);
        setPaint(core.getDebugger().getDebugTextPaint());
        setTextHorizontalAlign(TextHorizontalAlign.LEFT);
        setTextVerticalAlign(TextVerticalAlign.TOP);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void onAddToEngine(Updatable updatable) {
        mEntityCount++;
        String name = updatable.getName();
        if (!mEntityCountMap.containsKey(name)) {
            mEntityCountMap.put(name, 1);
        } else {
            int currentCount = mEntityCountMap.get(name);
            mEntityCountMap.put(name, currentCount + 1);
        }
    }

    @Override
    public void onRemoveFromEngine(Updatable updatable) {
        mEntityCount--;
        String name = updatable.getName();
        if (mEntityCountMap.containsKey(name)) {
            int currentCount = mEntityCountMap.get(name) - 1;
            if (currentCount == 0) {
                mEntityCountMap.remove(name);
            } else {
                mEntityCountMap.put(name, currentCount);
            }
        }
    }

    @Override
    protected void onUpdate(long elapsedMillis) {
        mStringBuilder.delete(0, mStringBuilder.length());
        mStringBuilder.append("Total Entity: ")
                .append(mEntityCount)
                .append("\n");
        for (Map.Entry<String, Integer> name : mEntityCountMap.entrySet()) {
            mStringBuilder.append(name.getKey())
                    .append(": ")
                    .append(name.getValue())
                    .append("\n");
        }
        setText(mStringBuilder.toString());
    }
    //========================================================

}
