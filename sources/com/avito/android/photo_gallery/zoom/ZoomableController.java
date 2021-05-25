package com.avito.android.photo_gallery.zoom;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
public interface ZoomableController {

    public interface Listener {
        void onTransformBegin(Matrix matrix);

        void onTransformChanged(Matrix matrix);

        void onTransformEnd(Matrix matrix);
    }

    int computeHorizontalScrollExtent();

    int computeHorizontalScrollOffset();

    int computeHorizontalScrollRange();

    int computeVerticalScrollExtent();

    int computeVerticalScrollOffset();

    int computeVerticalScrollRange();

    float getScaleFactor();

    Matrix getTransform();

    boolean isEnabled();

    boolean isIdentity();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setEnabled(boolean z);

    void setImageBounds(RectF rectF);

    void setListener(Listener listener);

    void setViewBounds(RectF rectF);

    boolean wasTransformCorrected();
}
