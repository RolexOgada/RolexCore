package com.collince.rolexcore.entity.shape.primitive;

import android.graphics.Canvas;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.shape.RectangleShapeEntity;



public class Grid extends RectangleShapeEntity {

    protected int mRow;
    protected int mColumn;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Grid(Core core, int row, int column) {
        this(core, 0, 0, core.getCamera().getWorldWidth(), core.getCamera().getWorldHeight(), row, column);
    }

    public Grid(Core core, float x, float y, int width, int height, int row, int column) {
        super(core, x, y, width, height);
        mRow = row;
        mColumn = column;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public int getRow() {
        return mRow;
    }

    public void setRow(int row) {
        mRow = row;
    }

    public int getColumn() {
        return mColumn;
    }

    public void setColumn(int column) {
        mColumn = column;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onDrawCanvas(Canvas canvas) {
        // Draw vertical line
        float gridWidth = getWidth() * 1f / mColumn;   // Use float for higher currency
        for (int i = 0; i <= mColumn; i++) {
            float x = i * gridWidth;
            canvas.drawLine(x, 0, x, getHeight(), mPaint);
        }

        // Draw horizontal line
        float gridHeight = getHeight() * 1f / mRow;   // Use float for higher currency
        for (int i = 0; i <= mRow; i++) {
            float y = i * gridHeight;
            canvas.drawLine(0, y, getWidth(), y, mPaint);
        }
    }
    //========================================================

}
