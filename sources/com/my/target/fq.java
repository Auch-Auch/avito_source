package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.SimpleExoPlayer;
public class fq extends FrameLayout {
    @NonNull
    public final TextureView a;
    @Nullable
    public SurfaceView b;
    public int c;
    public int d;
    @Nullable
    public a e;
    public int f;

    public interface a {
        void J();
    }

    public fq(Context context) {
        super(context);
        this.a = new TextureView(context);
        a();
    }

    public final void a() {
        View view;
        io.a(this.a, "ad_video");
        if (getChildAt(0) != null) {
            removeViewAt(0);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        if (this.f == 0) {
            view = this.a;
        } else {
            if (this.b == null) {
                this.b = new SurfaceView(getContext());
            }
            view = this.b;
        }
        addView(view, layoutParams);
    }

    public void d(int i, int i2) {
        this.c = i;
        this.d = i2;
        requestLayout();
        invalidate();
    }

    @Nullable
    public Bitmap getScreenShot() {
        if (this.f == 1) {
            return null;
        }
        try {
            return this.a.getBitmap(getWidth(), getHeight());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @NonNull
    public TextureView getTextureView() {
        return this.a;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        a aVar;
        super.onAttachedToWindow();
        if (!io.k(this) && (aVar = this.e) != null) {
            aVar.J();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = this.c;
        if (i4 <= 0 || (i3 = this.d) <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        float f2 = ((float) i4) / ((float) i3);
        if (mode == 0 && mode2 == 0) {
            size = i4;
            size2 = i3;
        } else {
            if (mode == 0) {
                size = (int) (((float) size2) * f2);
            } else {
                float f3 = (float) size;
                if (mode2 == 0) {
                    size2 = (int) (f3 / f2);
                } else {
                    float f4 = f3 / ((float) i4);
                    float f5 = (float) size2;
                    if (Math.min(f4, f5 / ((float) i3)) != f4 || f2 <= 0.0f) {
                        i4 = size;
                        i3 = size2;
                        size = (int) (f5 * f2);
                    } else {
                        i4 = size;
                        i3 = size2;
                        size2 = (int) (f3 / f2);
                    }
                }
            }
            i4 = size;
            i3 = size2;
        }
        this.a.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        SurfaceView surfaceView = this.b;
        if (surfaceView != null) {
            surfaceView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        setMeasuredDimension(i4, i3);
    }

    public void setAdVideoViewListener(@Nullable a aVar) {
        this.e = aVar;
    }

    public void setExoPlayer(@Nullable SimpleExoPlayer simpleExoPlayer) {
        if (simpleExoPlayer != null) {
            int i = this.f;
            if (i == 0) {
                simpleExoPlayer.setVideoSurfaceView(null);
                simpleExoPlayer.setVideoTextureView(this.a);
            } else if (i == 1) {
                simpleExoPlayer.setVideoTextureView(null);
                simpleExoPlayer.setVideoSurfaceView(this.b);
            }
        }
    }

    public void setViewMode(int i) {
        if (this.f != i) {
            this.f = i;
            a();
        }
    }
}
