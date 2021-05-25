package com.otaliastudios.cameraview.overlay;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.R;
import com.otaliastudios.cameraview.overlay.Overlay;
@SuppressLint({"CustomViewStyleable"})
public class OverlayLayout extends FrameLayout implements Overlay {
    public static final String b;
    public static final CameraLogger c;
    @VisibleForTesting
    public Overlay.Target a = Overlay.Target.PREVIEW;

    static {
        String simpleName = OverlayLayout.class.getSimpleName();
        b = simpleName;
        c = CameraLogger.create(simpleName);
    }

    public OverlayLayout(@NonNull Context context) {
        super(context);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c.i("normal draw called.");
        Overlay.Target target = Overlay.Target.PREVIEW;
        if (drawsOn(target)) {
            drawOn(target, canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.a(this.a)) {
            c.v("Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.a, "params:", layoutParams);
            return super.drawChild(canvas, view, j);
        }
        c.v("Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.a, "params:", layoutParams);
        return false;
    }

    @Override // com.otaliastudios.cameraview.overlay.Overlay
    public void drawOn(@NonNull Overlay.Target target, @NonNull Canvas canvas) {
        synchronized (this) {
            this.a = target;
            int ordinal = target.ordinal();
            if (ordinal == 0) {
                super.draw(canvas);
            } else if (ordinal == 1 || ordinal == 2) {
                canvas.save();
                float width = ((float) canvas.getWidth()) / ((float) getWidth());
                float height = ((float) canvas.getHeight()) / ((float) getHeight());
                CameraLogger cameraLogger = c;
                cameraLogger.v("draw", "target:", target, "canvas:", canvas.getWidth() + "x" + canvas.getHeight(), "view:", getWidth() + "x" + getHeight(), "widthScale:", Float.valueOf(width), "heightScale:", Float.valueOf(height));
                canvas.scale(width, height);
                dispatchDraw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // com.otaliastudios.cameraview.overlay.Overlay
    public boolean drawsOn(@NonNull Overlay.Target target) {
        for (int i = 0; i < getChildCount(); i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).a(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOverlay(@Nullable AttributeSet attributeSet) {
        boolean z = false;
        if (attributeSet == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CameraView_Layout);
        if (obtainStyledAttributes.hasValue(R.styleable.CameraView_Layout_layout_drawOnPreview) || obtainStyledAttributes.hasValue(R.styleable.CameraView_Layout_layout_drawOnPictureSnapshot) || obtainStyledAttributes.hasValue(R.styleable.CameraView_Layout_layout_drawOnVideoSnapshot)) {
            z = true;
        }
        obtainStyledAttributes.recycle();
        return z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public boolean drawOnPictureSnapshot = false;
        public boolean drawOnPreview = false;
        public boolean drawOnVideoSnapshot = false;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        @VisibleForTesting
        public boolean a(@NonNull Overlay.Target target) {
            return (target == Overlay.Target.PREVIEW && this.drawOnPreview) || (target == Overlay.Target.VIDEO_SNAPSHOT && this.drawOnVideoSnapshot) || (target == Overlay.Target.PICTURE_SNAPSHOT && this.drawOnPictureSnapshot);
        }

        @Override // java.lang.Object
        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append("[drawOnPreview:");
            sb.append(this.drawOnPreview);
            sb.append(",drawOnPictureSnapshot:");
            sb.append(this.drawOnPictureSnapshot);
            sb.append(",drawOnVideoSnapshot:");
            return a.B(sb, this.drawOnVideoSnapshot, "]");
        }

        public LayoutParams(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraView_Layout);
            try {
                this.drawOnPreview = obtainStyledAttributes.getBoolean(R.styleable.CameraView_Layout_layout_drawOnPreview, false);
                this.drawOnPictureSnapshot = obtainStyledAttributes.getBoolean(R.styleable.CameraView_Layout_layout_drawOnPictureSnapshot, false);
                this.drawOnVideoSnapshot = obtainStyledAttributes.getBoolean(R.styleable.CameraView_Layout_layout_drawOnVideoSnapshot, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public boolean isOverlay(@NonNull ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }
}
