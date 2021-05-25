package com.bluejamesbond.text;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.bluejamesbond.text.IDocumentLayout;
import com.bluejamesbond.text.style.TextAlignment;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
public class DocumentView extends ScrollView {
    public static final int FORMATTED_TEXT = 1;
    public static final int PLAIN_TEXT = 0;
    public static final ITween p = new a();
    public static final Object q = new Object();
    public static int r = -1;
    public IDocumentLayout a;
    public TextPaint b;
    public TextPaint c;
    public View d;
    public ITween e;
    public int f = 250;
    public int g = 35;
    public volatile MeasureTask h;
    public volatile i i;
    public int j;
    public int k;
    public CacheConfig l;
    public ILayoutProgressListener layoutProgressListener;
    public CacheBitmap m;
    public CacheBitmap n;
    public boolean o;

    public class CacheBitmap {
        public long a;
        public Bitmap b;
        public int c = -1;
        public volatile boolean d = false;
        public volatile CacheDrawTask e;

        public class CacheDrawTask extends AsyncTask<Void, Void, Void> {
            public Runnable a;

            public CacheDrawTask(Runnable runnable) {
                this.a = runnable;
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                super.onPreExecute();
            }

            public Void doInBackground(Void... voidArr) {
                this.a.run();
                return null;
            }

            public void onPostExecute(Void r3) {
                CacheBitmap.this.a = System.currentTimeMillis();
                CacheBitmap.this.d = true;
                DocumentView.this.invalidate();
            }
        }

        public CacheBitmap(int i, int i2, Bitmap.Config config) {
            this.b = Bitmap.createBitmap(i, i2, config);
        }

        public void a(Runnable runnable) {
            if (this.e != null) {
                this.e.cancel(true);
                this.e = null;
            }
            this.d = false;
            this.e = new CacheDrawTask(runnable);
            this.e.execute(new Void[0]);
        }

        public int b() {
            return (int) Math.min(DocumentView.this.e.get((float) (System.currentTimeMillis() - this.a), 0.0f, 255.0f, (float) DocumentView.this.f), 255.0f);
        }

        public void c() {
            if (this.e != null) {
                this.e.cancel(true);
                this.e = null;
                this.d = false;
            }
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                bitmap.recycle();
                this.b = null;
            }
        }
    }

    public enum CacheConfig {
        NO_CACHE(null, 0),
        AUTO_QUALITY(Bitmap.Config.ARGB_4444, 1),
        LOW_QUALITY(Bitmap.Config.RGB_565, 2),
        HIGH_QUALITY(Bitmap.Config.ARGB_8888, 3),
        GRAYSCALE(Bitmap.Config.ALPHA_8, 4);
        
        public final Bitmap.Config a;
        public final int b;

        /* access modifiers changed from: public */
        CacheConfig(Bitmap.Config config, int i) {
            this.a = config;
            this.b = i;
        }

        public static CacheConfig getById(int i) {
            if (i == 1) {
                return AUTO_QUALITY;
            }
            if (i == 2) {
                return LOW_QUALITY;
            }
            if (i == 3) {
                return HIGH_QUALITY;
            }
            if (i != 4) {
                return NO_CACHE;
            }
            return GRAYSCALE;
        }

        public int getId() {
            return this.b;
        }
    }

    public interface ILayoutProgressListener {
        void onCancelled();

        void onFinish();

        void onProgressUpdate(float f);

        void onStart();
    }

    public interface ITween {
        float get(float f, float f2, float f3, float f4);
    }

    public class MeasureTask extends AsyncTask<Void, Float, Boolean> {
        public IDocumentLayout.IProgress<Float> a;
        public IDocumentLayout.ICancel<Boolean> b;

        public class a implements IDocumentLayout.IProgress<Float> {
            public a(DocumentView documentView) {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.bluejamesbond.text.IDocumentLayout.IProgress
            public void onUpdate(Float f) {
                Float f2 = f;
                ILayoutProgressListener iLayoutProgressListener = DocumentView.this.layoutProgressListener;
                if (iLayoutProgressListener != null) {
                    iLayoutProgressListener.onProgressUpdate(f2.floatValue());
                }
            }
        }

        public class b implements IDocumentLayout.ICancel<Boolean> {
            public b(DocumentView documentView) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bluejamesbond.text.IDocumentLayout.ICancel
            public Boolean isCancelled() {
                return Boolean.valueOf(MeasureTask.this.isCancelled());
            }
        }

        public MeasureTask(float f) {
            DocumentView.this.a.getLayoutParams().setParentWidth(f);
            this.a = new a(DocumentView.this);
            this.b = new b(DocumentView.this);
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            ILayoutProgressListener iLayoutProgressListener = DocumentView.this.layoutProgressListener;
            if (iLayoutProgressListener != null) {
                iLayoutProgressListener.onCancelled();
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            ILayoutProgressListener iLayoutProgressListener = DocumentView.this.layoutProgressListener;
            if (iLayoutProgressListener != null) {
                iLayoutProgressListener.onStart();
            }
        }

        public Boolean doInBackground(Void... voidArr) {
            try {
                return Boolean.valueOf(DocumentView.this.a.measure(this.a, this.b));
            } catch (Exception e) {
                e.printStackTrace();
                return Boolean.FALSE;
            }
        }

        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue() || isCancelled()) {
                ILayoutProgressListener iLayoutProgressListener = DocumentView.this.layoutProgressListener;
                if (iLayoutProgressListener != null) {
                    iLayoutProgressListener.onCancelled();
                    return;
                }
                return;
            }
            DocumentView.this.h = null;
            DocumentView.this.i = i.FINISH;
            DocumentView.super.requestLayout();
            ILayoutProgressListener iLayoutProgressListener2 = DocumentView.this.layoutProgressListener;
            if (iLayoutProgressListener2 != null) {
                iLayoutProgressListener2.onFinish();
            }
        }
    }

    public static class a implements ITween {
        @Override // com.bluejamesbond.text.DocumentView.ITween
        public float get(float f, float f2, float f3, float f4) {
            return ((f3 * f) / f4) + f2;
        }
    }

    public class b extends SpannableDocumentLayout {
        public b(Context context, TextPaint textPaint) {
            super(context, textPaint);
        }

        @Override // com.bluejamesbond.text.IDocumentLayout
        public void onLayoutParamsChange() {
            DocumentView.this.invalidateCache();
            DocumentView.this.postInvalidate();
        }

        @Override // com.bluejamesbond.text.IDocumentLayout
        public void onTextChange() {
            DocumentView.this.invalidateCache();
            DocumentView.this.requestLayout();
        }
    }

    public class c extends StringDocumentLayout {
        public c(Context context, TextPaint textPaint) {
            super(context, textPaint);
        }

        @Override // com.bluejamesbond.text.IDocumentLayout
        public void onLayoutParamsChange() {
            DocumentView.this.invalidateCache();
            DocumentView.this.postInvalidate();
        }

        @Override // com.bluejamesbond.text.IDocumentLayout
        public void onTextChange() {
            DocumentView.this.invalidateCache();
            DocumentView.this.requestLayout();
        }
    }

    public class d implements ILayoutProgressListener {
        public ProgressBar a;
        public final /* synthetic */ int b;

        public d(int i) {
            this.b = i;
        }

        @Override // com.bluejamesbond.text.DocumentView.ILayoutProgressListener
        public void onCancelled() {
            ProgressBar progressBar = this.a;
            progressBar.setProgress(progressBar.getMax());
            this.a = null;
        }

        @Override // com.bluejamesbond.text.DocumentView.ILayoutProgressListener
        public void onFinish() {
            ProgressBar progressBar = this.a;
            progressBar.setProgress(progressBar.getMax());
            this.a = null;
        }

        @Override // com.bluejamesbond.text.DocumentView.ILayoutProgressListener
        public void onProgressUpdate(float f) {
            ProgressBar progressBar = this.a;
            progressBar.setProgress((int) (f * ((float) progressBar.getMax())));
        }

        @Override // com.bluejamesbond.text.DocumentView.ILayoutProgressListener
        public void onStart() {
            ProgressBar progressBar = (ProgressBar) ((Activity) DocumentView.this.getContext()).getWindow().getDecorView().findViewById(this.b);
            this.a = progressBar;
            progressBar.setProgress(0);
        }
    }

    public class e implements ILayoutProgressListener {
        public final /* synthetic */ ProgressBar a;

        public e(DocumentView documentView, ProgressBar progressBar) {
            this.a = progressBar;
        }

        @Override // com.bluejamesbond.text.DocumentView.ILayoutProgressListener
        public void onCancelled() {
            ProgressBar progressBar = this.a;
            progressBar.setProgress(progressBar.getMax());
        }

        @Override // com.bluejamesbond.text.DocumentView.ILayoutProgressListener
        public void onFinish() {
            ProgressBar progressBar = this.a;
            progressBar.setProgress(progressBar.getMax());
        }

        @Override // com.bluejamesbond.text.DocumentView.ILayoutProgressListener
        public void onProgressUpdate(float f) {
            ProgressBar progressBar = this.a;
            progressBar.setProgress((int) (f * ((float) progressBar.getMax())));
        }

        @Override // com.bluejamesbond.text.DocumentView.ILayoutProgressListener
        public void onStart() {
            this.a.setProgress(0);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ CacheBitmap a;
        public final /* synthetic */ int b;

        public f(CacheBitmap cacheBitmap, int i) {
            this.a = cacheBitmap;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            DocumentView documentView = DocumentView.this;
            Canvas canvas = new Canvas(this.a.b);
            int i = this.b;
            documentView.drawLayout(canvas, i, DocumentView.r + i, true);
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ CacheBitmap a;
        public final /* synthetic */ int b;

        public g(CacheBitmap cacheBitmap, int i) {
            this.a = cacheBitmap;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            DocumentView documentView = DocumentView.this;
            Canvas canvas = new Canvas(this.a.b);
            int i = this.b;
            documentView.drawLayout(canvas, i, DocumentView.r + i, true);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ CacheBitmap a;
        public final /* synthetic */ int b;

        public h(CacheBitmap cacheBitmap, int i) {
            this.a = cacheBitmap;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            DocumentView documentView = DocumentView.this;
            Canvas canvas = new Canvas(this.a.b);
            int i = this.b;
            documentView.drawLayout(canvas, i, DocumentView.r + i, true);
        }
    }

    public enum i {
        AWAIT,
        FINISH,
        START,
        FINISH_AWAIT
    }

    public DocumentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet, 0);
    }

    private static int getMaxTextureSize() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
        EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
        egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, iArr[0], iArr);
        int[] iArr2 = new int[1];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr[0]; i3++) {
            egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i3], 12332, iArr2);
            if (i2 < iArr2[0]) {
                i2 = iArr2[0];
            }
        }
        egl10.eglTerminate(eglGetDisplay);
        return Math.max(i2, 2048);
    }

    public void allocateResources() {
        if (this.m == null) {
            this.m = new CacheBitmap(getWidth(), r, this.l.a);
        }
        if (this.n == null) {
            this.n = new CacheBitmap(getWidth(), r, this.l.a);
        }
    }

    public final void b(Context context, AttributeSet attributeSet, int i2) {
        synchronized (q) {
            if (r == -1) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                r = Math.min((Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels) * 7) / 6, getMaxTextureSize());
            }
        }
        this.o = false;
        this.e = p;
        this.l = CacheConfig.AUTO_QUALITY;
        this.b = new TextPaint();
        this.c = new TextPaint();
        this.d = new View(context);
        this.i = i.START;
        initPaint(this.b);
        setPadding(0, 0, 0, 0);
        addView(this.d);
        if (attributeSet == null || isInEditMode()) {
            this.a = getDocumentLayoutInstance(i2, this.b);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DocumentView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        IDocumentLayout documentLayoutInstance = getDocumentLayoutInstance(obtainStyledAttributes.getInt(R.styleable.DocumentView_documentView_textFormat, 0), this.b);
        this.a = documentLayoutInstance;
        IDocumentLayout.LayoutParams layoutParams = documentLayoutInstance.getLayoutParams();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.DocumentView_documentView_insetPadding) {
                Float valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                layoutParams.setInsetPaddingLeft(valueOf.floatValue());
                layoutParams.setInsetPaddingBottom(valueOf.floatValue());
                layoutParams.setInsetPaddingRight(valueOf.floatValue());
                layoutParams.setInsetPaddingTop(valueOf.floatValue());
            } else if (index == R.styleable.DocumentView_documentView_insetPaddingLeft) {
                layoutParams.setInsetPaddingLeft(obtainStyledAttributes.getDimension(index, layoutParams.getInsetPaddingLeft()));
            } else if (index == R.styleable.DocumentView_documentView_insetPaddingBottom) {
                layoutParams.setInsetPaddingBottom(obtainStyledAttributes.getDimension(index, layoutParams.getInsetPaddingBottom()));
            } else if (index == R.styleable.DocumentView_documentView_insetPaddingRight) {
                layoutParams.setInsetPaddingRight(obtainStyledAttributes.getDimension(index, layoutParams.getInsetPaddingRight()));
            } else if (index == R.styleable.DocumentView_documentView_insetPaddingTop) {
                layoutParams.setInsetPaddingTop(obtainStyledAttributes.getDimension(index, layoutParams.getInsetPaddingTop()));
            } else if (index == R.styleable.DocumentView_documentView_offsetX) {
                layoutParams.setOffsetX(obtainStyledAttributes.getDimension(index, layoutParams.getOffsetX()));
            } else if (index == R.styleable.DocumentView_documentView_offsetY) {
                layoutParams.setOffsetY(obtainStyledAttributes.getDimension(index, layoutParams.getOffsetY()));
            } else if (index == R.styleable.DocumentView_documentView_hyphen) {
                layoutParams.setHyphen(obtainStyledAttributes.getString(index));
            } else if (index == R.styleable.DocumentView_documentView_maxLines) {
                layoutParams.setMaxLines(obtainStyledAttributes.getInt(index, layoutParams.getMaxLines()));
            } else if (index == R.styleable.DocumentView_documentView_lineHeightMultiplier) {
                layoutParams.setLineHeightMultiplier(obtainStyledAttributes.getFloat(index, layoutParams.getLineHeightMultiplier()));
            } else if (index == R.styleable.DocumentView_documentView_lineSpacingExtra) {
                layoutParams.setLineSpacingExtra(obtainStyledAttributes.getDimension(index, layoutParams.getLineSpacingExtra()));
            } else if (index == R.styleable.DocumentView_documentView_textAlignment) {
                layoutParams.setTextAlignment(TextAlignment.getById(obtainStyledAttributes.getInt(index, layoutParams.getTextAlignment().getId())));
            } else if (index == R.styleable.DocumentView_documentView_reverse) {
                layoutParams.setReverse(obtainStyledAttributes.getBoolean(index, layoutParams.isReverse()));
            } else if (index == R.styleable.DocumentView_documentView_wordSpacingMultiplier) {
                layoutParams.setWordSpacingMultiplier(obtainStyledAttributes.getFloat(index, layoutParams.getWordSpacingMultiplier().floatValue()));
            } else if (index == R.styleable.DocumentView_documentView_textColor) {
                layoutParams.setTextColor(obtainStyledAttributes.getColor(index, layoutParams.getTextColor()));
            } else if (index == R.styleable.DocumentView_documentView_textSize) {
                layoutParams.setRawTextSize(obtainStyledAttributes.getDimension(index, layoutParams.getTextSize()));
            } else if (index == R.styleable.DocumentView_documentView_textStyle) {
                int i4 = obtainStyledAttributes.getInt(index, 0);
                boolean z = true;
                layoutParams.setTextFakeBold((i4 & 1) > 0);
                layoutParams.setTextUnderline(((i4 >> 1) & 1) > 0);
                if (((i4 >> 2) & 1) <= 0) {
                    z = false;
                }
                layoutParams.setTextStrikeThru(z);
            } else if (index == R.styleable.DocumentView_documentView_textTypefacePath) {
                layoutParams.setTextTypeface(Typeface.createFromAsset(getResources().getAssets(), obtainStyledAttributes.getString(index)));
            } else if (index == R.styleable.DocumentView_documentView_antialias) {
                layoutParams.setAntialias(obtainStyledAttributes.getBoolean(index, layoutParams.isAntiAlias()));
            } else if (index == R.styleable.DocumentView_documentView_textSubPixel) {
                layoutParams.setTextSubPixel(obtainStyledAttributes.getBoolean(index, layoutParams.isTextSubPixel()));
            } else if (index == R.styleable.DocumentView_documentView_text) {
                this.a.setText(obtainStyledAttributes.getString(index));
            } else if (index == R.styleable.DocumentView_documentView_cacheConfig) {
                setCacheConfig(CacheConfig.getById(obtainStyledAttributes.getInt(index, CacheConfig.AUTO_QUALITY.getId())));
            } else {
                int i5 = R.styleable.DocumentView_documentView_progressBar;
                if (index == i5) {
                    setProgressBar(obtainStyledAttributes.getResourceId(i5, 0));
                } else if (index == R.styleable.DocumentView_documentView_fadeInAnimationStepDelay) {
                    setFadeInAnimationStepDelay(obtainStyledAttributes.getInteger(index, getFadeInAnimationStepDelay()));
                } else if (index == R.styleable.DocumentView_documentView_fadeInDuration) {
                    setFadeInDuration(obtainStyledAttributes.getInteger(index, getFadeInDuration()));
                } else if (index == R.styleable.DocumentView_documentView_disallowInterceptTouch) {
                    setDisallowInterceptTouch(obtainStyledAttributes.getBoolean(index, isDisallowInterceptTouch()));
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void destroyCache() {
        CacheBitmap cacheBitmap = this.m;
        if (cacheBitmap != null) {
            cacheBitmap.c();
            this.m = null;
        }
        CacheBitmap cacheBitmap2 = this.n;
        if (cacheBitmap2 != null) {
            cacheBitmap2.c();
            this.n = null;
        }
    }

    public boolean drawCacheToView(Canvas canvas, Paint paint, CacheBitmap cacheBitmap, int i2) {
        if (!cacheBitmap.d) {
            return false;
        }
        int alpha = paint.getAlpha();
        paint.setAlpha(cacheBitmap.b());
        canvas.drawBitmap(cacheBitmap.b, 0.0f, (float) i2, paint);
        paint.setAlpha(alpha);
        if (cacheBitmap.b() < 255) {
            return true;
        }
        return false;
    }

    public synchronized void drawLayout(Canvas canvas, int i2, int i3, boolean z) {
        if (z) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        this.a.draw(canvas, i2, i3);
        if (getDocumentLayoutParams().isDebugging()) {
            IDocumentLayout.LayoutParams documentLayoutParams = getDocumentLayoutParams();
            int color = this.b.getColor();
            float strokeWidth = this.b.getStrokeWidth();
            Paint.Style style = this.b.getStyle();
            this.b.setColor(-65281);
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setStrokeWidth(4.0f);
            float f2 = documentLayoutParams.insetPaddingLeft;
            float f3 = documentLayoutParams.insetPaddingTop;
            float f4 = (float) i2;
            float f5 = (f3 < f4 || f3 >= ((float) i3)) ? 0.0f : f3;
            float f6 = documentLayoutParams.parentWidth - documentLayoutParams.insetPaddingRight;
            float measuredHeight = ((float) this.a.getMeasuredHeight()) - documentLayoutParams.insetPaddingBottom;
            canvas.drawRect(f2, f5, f6, (measuredHeight < f4 || measuredHeight >= ((float) i3)) ? (float) canvas.getHeight() : measuredHeight - f4, this.b);
            this.b.setStrokeWidth(strokeWidth);
            this.b.setColor(color);
            this.b.setStyle(style);
        }
    }

    public void freeResources() {
        this.d.setMinimumHeight(this.j);
        if (this.h != null) {
            this.h.cancel(true);
            this.h = null;
            this.i = i.START;
        }
        destroyCache();
    }

    public CacheConfig getCacheConfig() {
        return this.l;
    }

    public IDocumentLayout getDocumentLayoutInstance(int i2, TextPaint textPaint) {
        if (i2 != 1) {
            return new c(getContext(), textPaint);
        }
        return new b(getContext(), textPaint);
    }

    public IDocumentLayout.LayoutParams getDocumentLayoutParams() {
        return this.a.getLayoutParams();
    }

    public int getFadeInAnimationStepDelay() {
        return this.g;
    }

    public int getFadeInDuration() {
        return this.f;
    }

    public ITween getFadeInTween() {
        return this.e;
    }

    public IDocumentLayout getLayout() {
        return this.a;
    }

    public CharSequence getText() {
        return this.a.getText();
    }

    public View getViewportView() {
        return this.d;
    }

    public void initPaint(Paint paint) {
        paint.setTypeface(Typeface.defaultFromStyle(0));
        paint.setTextSize(34.0f);
        paint.setAntiAlias(true);
    }

    public void invalidateCache() {
        CacheBitmap cacheBitmap = this.m;
        if (cacheBitmap != null) {
            cacheBitmap.c = -1;
        }
        CacheBitmap cacheBitmap2 = this.n;
        if (cacheBitmap2 != null) {
            cacheBitmap2.c = -1;
        }
    }

    public boolean isDisallowInterceptTouch() {
        return this.o;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        this.k = getResources().getConfiguration().orientation;
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i2 = this.k;
        int i3 = configuration.orientation;
        if (i2 != i3) {
            this.k = i3;
            freeResources();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.widget.ScrollView, android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        freeResources();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public final void onDraw(Canvas canvas) {
        boolean z;
        super.onDraw(canvas);
        if (!isInEditMode()) {
            int i2 = 0;
            if (this.l != CacheConfig.NO_CACHE && this.a.getMeasuredHeight() > getHeight()) {
                allocateResources();
                int scrollY = getScrollY();
                int height = getHeight() + scrollY;
                int i3 = r;
                CacheBitmap cacheBitmap = scrollY % (i3 * 2) < i3 ? this.m : this.n;
                CacheBitmap cacheBitmap2 = height % (i3 * 2) >= i3 ? this.n : this.m;
                int i4 = scrollY - (scrollY % (i3 * 2));
                if (cacheBitmap != this.m) {
                    i2 = i3;
                }
                int i5 = i4 + i2;
                if (cacheBitmap == cacheBitmap2) {
                    if (i5 != cacheBitmap.c) {
                        cacheBitmap.c = i5;
                        cacheBitmap.a(new f(cacheBitmap2, i5));
                    }
                    z = drawCacheToView(canvas, this.c, cacheBitmap, i5);
                } else {
                    int i6 = i3 + i5;
                    if (i5 != cacheBitmap.c) {
                        cacheBitmap.c = i5;
                        cacheBitmap.a(new g(cacheBitmap, i5));
                    }
                    if (i6 != cacheBitmap2.c) {
                        cacheBitmap2.c = i6;
                        cacheBitmap2.a(new h(cacheBitmap2, i6));
                    }
                    z = drawCacheToView(canvas, this.c, cacheBitmap2, i6) | drawCacheToView(canvas, this.c, cacheBitmap, i5);
                }
                if (z) {
                    postInvalidateDelayed((long) this.g);
                    return;
                }
                return;
            }
            drawLayout(canvas, 0, this.a.getMeasuredHeight(), false);
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int ordinal = this.i.ordinal();
        if (ordinal == 1) {
            this.d.setMinimumWidth(size);
            this.d.setMinimumHeight(this.a.getMeasuredHeight());
            this.i = i.FINISH_AWAIT;
            if (this.l != CacheConfig.NO_CACHE) {
                allocateResources();
            }
        } else if (ordinal == 2) {
            if (this.h != null) {
                this.h.cancel(true);
                this.h = null;
            }
            this.h = new MeasureTask((float) size);
            this.h.execute(new Void[0]);
            this.i = i.AWAIT;
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(this.o);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.ViewParent, android.view.View
    public void requestLayout() {
        this.i = i.START;
        super.requestLayout();
    }

    public void setCacheConfig(CacheConfig cacheConfig) {
        this.l = cacheConfig;
    }

    public void setDisallowInterceptTouch(boolean z) {
        this.o = z;
    }

    public void setFadeInAnimationStepDelay(int i2) {
        this.g = i2;
    }

    public void setFadeInDuration(int i2) {
        this.f = i2;
    }

    public void setFadeInTween(ITween iTween) {
        this.e = iTween;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.j = i2;
        this.d.setMinimumHeight(i2);
    }

    public void setOnLayoutProgressListener(ILayoutProgressListener iLayoutProgressListener) {
        this.layoutProgressListener = iLayoutProgressListener;
    }

    public void setProgressBar(int i2) {
        setOnLayoutProgressListener(new d(i2));
    }

    public void setText(CharSequence charSequence) {
        this.a.setText(charSequence);
        requestLayout();
    }

    public void setProgressBar(ProgressBar progressBar) {
        setOnLayoutProgressListener(new e(this, progressBar));
    }

    public DocumentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public DocumentView(Context context) {
        super(context);
        b(context, null, 0);
    }

    public DocumentView(Context context, int i2) {
        super(context);
        b(context, null, i2);
    }

    @TargetApi(21)
    public DocumentView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        b(context, attributeSet, 0);
    }
}
