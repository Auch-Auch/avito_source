package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    public final a a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public Paint i;
    public Rect j;
    public List<Animatable2Compat.AnimationCallback> k;

    public static final class a extends Drawable.ConstantState {
        @VisibleForTesting
        public final GifFrameLoader a;

        public a(GifFrameLoader gifFrameLoader) {
            this.a = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new GifDrawable(this);
        }
    }

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i2, i3, bitmap);
    }

    public final Paint a() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }

    public final void b() {
        Preconditions.checkArgument(!this.d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.a.a.a.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.b) {
            this.b = true;
            GifFrameLoader gifFrameLoader = this.a.a;
            if (gifFrameLoader.k) {
                throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
            } else if (!gifFrameLoader.c.contains(this)) {
                boolean isEmpty = gifFrameLoader.c.isEmpty();
                gifFrameLoader.c.add(this);
                if (isEmpty && !gifFrameLoader.f) {
                    gifFrameLoader.f = true;
                    gifFrameLoader.k = false;
                    gifFrameLoader.a();
                }
                invalidateSelf();
            } else {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
        }
    }

    public final void c() {
        this.b = false;
        GifFrameLoader gifFrameLoader = this.a.a;
        gifFrameLoader.c.remove(this);
        if (gifFrameLoader.c.isEmpty()) {
            gifFrameLoader.f = false;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap;
        if (!this.d) {
            if (this.h) {
                int intrinsicWidth = getIntrinsicWidth();
                int intrinsicHeight = getIntrinsicHeight();
                Rect bounds = getBounds();
                if (this.j == null) {
                    this.j = new Rect();
                }
                Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.j);
                this.h = false;
            }
            GifFrameLoader gifFrameLoader = this.a.a;
            GifFrameLoader.a aVar = gifFrameLoader.j;
            if (aVar != null) {
                bitmap = aVar.g;
            } else {
                bitmap = gifFrameLoader.m;
            }
            if (this.j == null) {
                this.j = new Rect();
            }
            canvas.drawBitmap(bitmap, (Rect) null, this.j, a());
        }
    }

    public ByteBuffer getBuffer() {
        return this.a.a.a.getData().asReadOnlyBuffer();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    public Bitmap getFirstFrame() {
        return this.a.a.m;
    }

    public int getFrameCount() {
        return this.a.a.a.getFrameCount();
    }

    public int getFrameIndex() {
        GifFrameLoader.a aVar = this.a.a.j;
        if (aVar != null) {
            return aVar.e;
        }
        return -1;
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.a.a.n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.a.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.a.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        GifFrameLoader gifFrameLoader = this.a.a;
        return gifFrameLoader.a.getByteSize() + gifFrameLoader.p;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public void onFrameReady() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.f++;
        }
        int i2 = this.g;
        if (i2 != -1 && this.f >= i2) {
            List<Animatable2Compat.AnimationCallback> list = this.k;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.k.get(i3).onAnimationEnd(this);
                }
            }
            stop();
        }
    }

    public void recycle() {
        this.d = true;
        GifFrameLoader gifFrameLoader = this.a.a;
        gifFrameLoader.c.clear();
        Bitmap bitmap = gifFrameLoader.m;
        if (bitmap != null) {
            gifFrameLoader.e.put(bitmap);
            gifFrameLoader.m = null;
        }
        gifFrameLoader.f = false;
        GifFrameLoader.a aVar = gifFrameLoader.j;
        if (aVar != null) {
            gifFrameLoader.d.clear(aVar);
            gifFrameLoader.j = null;
        }
        GifFrameLoader.a aVar2 = gifFrameLoader.l;
        if (aVar2 != null) {
            gifFrameLoader.d.clear(aVar2);
            gifFrameLoader.l = null;
        }
        GifFrameLoader.a aVar3 = gifFrameLoader.o;
        if (aVar3 != null) {
            gifFrameLoader.d.clear(aVar3);
            gifFrameLoader.o = null;
        }
        gifFrameLoader.a.clear();
        gifFrameLoader.k = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback != null) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.k.add(animationCallback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        a().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        a().setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.a.a.c(transformation, bitmap);
    }

    public void setLoopCount(int i2) {
        int i3 = -1;
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i2 == 0) {
            int totalIterationCount = this.a.a.a.getTotalIterationCount();
            if (totalIterationCount != 0) {
                i3 = totalIterationCount;
            }
            this.g = i3;
        } else {
            this.g = i2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.checkArgument(!this.d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.e = z;
        if (!z) {
            c();
        } else if (this.c) {
            b();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.c = true;
        this.f = 0;
        if (this.e) {
            b();
        }
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.b, "You cannot restart a currently running animation.");
        GifFrameLoader gifFrameLoader = this.a.a;
        Preconditions.checkArgument(!gifFrameLoader.f, "Can't restart a running animation");
        gifFrameLoader.h = true;
        GifFrameLoader.a aVar = gifFrameLoader.o;
        if (aVar != null) {
            gifFrameLoader.d.clear(aVar);
            gifFrameLoader.o = null;
        }
        start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.c = false;
        c();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        a aVar = new a(new GifFrameLoader(Glide.get(context), gifDecoder, i2, i3, transformation, bitmap));
        this.e = true;
        this.g = -1;
        this.a = (a) Preconditions.checkNotNull(aVar);
    }

    public GifDrawable(a aVar) {
        this.e = true;
        this.g = -1;
        this.a = (a) Preconditions.checkNotNull(aVar);
    }
}
