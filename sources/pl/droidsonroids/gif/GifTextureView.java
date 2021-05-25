package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.avito.android.util.preferences.db_preferences.Types;
import java.io.IOException;
import java.lang.ref.WeakReference;
import pl.droidsonroids.gif.InputSource;
import y6.a.a.c;
import y6.a.a.d;
import y6.a.a.f;
public class GifTextureView extends TextureView {
    public static final ImageView.ScaleType[] g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public ImageView.ScaleType a = ImageView.ScaleType.FIT_CENTER;
    public final Matrix b = new Matrix();
    public InputSource c;
    public b d;
    public float e = 1.0f;
    public d.b f;

    public interface PlaceholderDrawListener {
        void onDrawPlaceholder(Canvas canvas);
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static class b extends Thread implements TextureView.SurfaceTextureListener {
        public final y6.a.a.a a = new y6.a.a.a();
        public GifInfoHandle b = new GifInfoHandle();
        public IOException c;
        public long[] d;
        public final WeakReference<GifTextureView> e;

        public class a implements Runnable {
            public final /* synthetic */ GifTextureView a;

            public a(GifTextureView gifTextureView) {
                this.a = gifTextureView;
            }

            @Override // java.lang.Runnable
            public void run() {
                GifTextureView gifTextureView = this.a;
                GifInfoHandle gifInfoHandle = b.this.b;
                ImageView.ScaleType[] scaleTypeArr = GifTextureView.g;
                gifTextureView.c(gifInfoHandle);
            }
        }

        public b(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.e = new WeakReference<>(gifTextureView);
        }

        public void a(@NonNull GifTextureView gifTextureView, @Nullable PlaceholderDrawListener placeholderDrawListener) {
            this.a.a();
            gifTextureView.setSuperSurfaceTextureListener(placeholderDrawListener != null ? new f(placeholderDrawListener) : null);
            this.b.y();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            GifTextureView gifTextureView = this.e.get();
            if (gifTextureView != null) {
                GifInfoHandle gifInfoHandle = this.b;
                ImageView.ScaleType[] scaleTypeArr = GifTextureView.g;
                gifTextureView.c(gifInfoHandle);
            }
            this.a.b();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.a.a();
            this.b.y();
            interrupt();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = this.e.get();
                if (gifTextureView != null) {
                    GifInfoHandle a3 = gifTextureView.c.a();
                    this.b = a3;
                    a3.J(1, gifTextureView.isOpaque());
                    int i = gifTextureView.f.b;
                    if (i >= 0) {
                        this.b.I(i);
                    }
                    GifTextureView gifTextureView2 = this.e.get();
                    if (gifTextureView2 == null) {
                        this.b.z();
                        return;
                    }
                    gifTextureView2.setSuperSurfaceTextureListener(this);
                    boolean isAvailable = gifTextureView2.isAvailable();
                    y6.a.a.a aVar = this.a;
                    synchronized (aVar) {
                        if (isAvailable) {
                            aVar.b();
                        } else {
                            aVar.a();
                        }
                    }
                    if (isAvailable) {
                        gifTextureView2.post(new a(gifTextureView2));
                    }
                    this.b.K(gifTextureView2.e);
                    while (!isInterrupted()) {
                        try {
                            y6.a.a.a aVar2 = this.a;
                            synchronized (aVar2) {
                                while (!aVar2.a) {
                                    aVar2.wait();
                                }
                            }
                            GifTextureView gifTextureView3 = this.e.get();
                            if (gifTextureView3 == null) {
                                break;
                            }
                            SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                            if (surfaceTexture != null) {
                                Surface surface = new Surface(surfaceTexture);
                                try {
                                    this.b.a(surface, this.d);
                                } finally {
                                    surface.release();
                                }
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    this.b.z();
                    this.b = new GifInfoHandle();
                }
            } catch (IOException e2) {
                this.c = e2;
            }
        }
    }

    public GifTextureView(Context context) {
        super(context);
        b(null, 0, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public final void b(AttributeSet attributeSet, int i, int i2) {
        InputSource inputSource;
        InputSource inputSource2;
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = g;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.a = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GifTextureView, i, i2);
            TypedValue typedValue = new TypedValue();
            if (!obtainStyledAttributes.getValue(R.styleable.GifTextureView_gifSource, typedValue)) {
                inputSource = null;
            } else {
                if (typedValue.resourceId != 0) {
                    String resourceTypeName = obtainStyledAttributes.getResources().getResourceTypeName(typedValue.resourceId);
                    if (d.a.contains(resourceTypeName)) {
                        inputSource2 = new InputSource.ResourcesSource(obtainStyledAttributes.getResources(), typedValue.resourceId);
                        inputSource = inputSource2;
                    } else if (!Types.STRING.equals(resourceTypeName)) {
                        throw new IllegalArgumentException(a2.b.a.a.a.e3("Expected string, drawable, mipmap or raw resource type. '", resourceTypeName, "' is not supported"));
                    }
                }
                inputSource2 = new InputSource.AssetSource(obtainStyledAttributes.getResources().getAssets(), typedValue.string.toString());
                inputSource = inputSource2;
            }
            this.c = inputSource;
            super.setOpaque(obtainStyledAttributes.getBoolean(R.styleable.GifTextureView_isOpaque, false));
            obtainStyledAttributes.recycle();
            this.f = new d.b(this, attributeSet, i, i2);
        } else {
            super.setOpaque(false);
            this.f = new d.b();
        }
        if (!isInEditMode()) {
            b bVar = new b(this);
            this.d = bVar;
            if (this.c != null) {
                bVar.start();
            }
        }
    }

    public final void c(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = (float) getWidth();
        float height = (float) getHeight();
        float p = ((float) gifInfoHandle.p()) / width;
        float i = ((float) gifInfoHandle.i()) / height;
        RectF rectF = new RectF(0.0f, 0.0f, (float) gifInfoHandle.p(), (float) gifInfoHandle.i());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f2 = 1.0f;
        switch (a.a[this.a.ordinal()]) {
            case 1:
                matrix.setScale(p, i, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(p, i);
                matrix.setScale(p * min, min * i, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (((float) gifInfoHandle.p()) > width || ((float) gifInfoHandle.i()) > height) {
                    f2 = Math.min(1.0f / p, 1.0f / i);
                }
                matrix.setScale(p * f2, f2 * i, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(p, i);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(p, i);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(p, i);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.b);
                matrix.preScale(p, i);
                break;
        }
        super.setTransform(matrix);
    }

    @Nullable
    public IOException getIOException() {
        b bVar = this.d;
        IOException iOException = bVar.c;
        if (iOException != null) {
            return iOException;
        }
        int l = bVar.b.l();
        int i = GifIOException.b;
        if (l == GifError.NO_ERROR.a) {
            return null;
        }
        return new GifIOException(l, null);
    }

    public ImageView.ScaleType getScaleType() {
        return this.a;
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.b);
        return matrix;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.d.a(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.d.d = cVar.a[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = this.d;
        bVar.d = bVar.b.n();
        return new c(super.onSaveInstanceState(), this.f.a ? this.d.d : null);
    }

    public void setFreezesAnimation(boolean z) {
        this.f.a = z;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(@Nullable InputSource inputSource) {
        setInputSource(inputSource, null);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.c);
        }
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.a = scaleType;
        c(this.d.b);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this.e = f2;
        this.d.b.K(f2);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.b.set(matrix);
        c(this.d.b);
    }

    public synchronized void setInputSource(@Nullable InputSource inputSource, @Nullable PlaceholderDrawListener placeholderDrawListener) {
        this.d.a(this, placeholderDrawListener);
        try {
            this.d.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.c = inputSource;
        b bVar = new b(this);
        this.d = bVar;
        if (inputSource != null) {
            bVar.start();
        }
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet, i, 0);
    }

    @RequiresApi(21)
    public GifTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b(attributeSet, i, i2);
    }
}
