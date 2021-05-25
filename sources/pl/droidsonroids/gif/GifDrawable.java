package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.util.TypedValue;
import android.widget.MediaController;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pl.droidsonroids.gif.transforms.CornerRadiusTransform;
import pl.droidsonroids.gif.transforms.Transform;
import y6.a.a.b;
import y6.a.a.d;
import y6.a.a.e;
import y6.a.a.g;
import y6.a.a.h;
public class GifDrawable extends Drawable implements Animatable, MediaController.MediaPlayerControl {
    public final ScheduledThreadPoolExecutor a;
    public volatile boolean b;
    public long c;
    public final Rect d;
    public final Bitmap e;
    public final GifInfoHandle f;
    public final ConcurrentLinkedQueue<AnimationListener> g;
    public ColorStateList h;
    public PorterDuffColorFilter i;
    public PorterDuff.Mode j;
    public final boolean k;
    public final e l;
    public final g m;
    public final Paint mPaint;
    public final Rect n;
    public ScheduledFuture<?> o;
    public int p;
    public int q;
    public Transform r;

    public class a extends h {
        public a(GifDrawable gifDrawable) {
            super(gifDrawable);
        }

        @Override // y6.a.a.h
        public void a() {
            if (GifDrawable.this.f.B()) {
                GifDrawable.this.start();
            }
        }
    }

    public class b extends h {
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(GifDrawable gifDrawable, int i) {
            super(gifDrawable);
            this.b = i;
        }

        @Override // y6.a.a.h
        public void a() {
            GifDrawable gifDrawable = GifDrawable.this;
            gifDrawable.f.H(this.b, gifDrawable.e);
            this.a.l.sendEmptyMessageAtTime(-1, 0);
        }
    }

    public class c extends h {
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(GifDrawable gifDrawable, int i) {
            super(gifDrawable);
            this.b = i;
        }

        @Override // y6.a.a.h
        public void a() {
            GifDrawable gifDrawable = GifDrawable.this;
            gifDrawable.f.F(this.b, gifDrawable.e);
            GifDrawable.this.l.sendEmptyMessageAtTime(-1, 0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifDrawable(@androidx.annotation.NonNull pl.droidsonroids.gif.InputSource r2, @androidx.annotation.Nullable pl.droidsonroids.gif.GifDrawable r3, @androidx.annotation.Nullable java.util.concurrent.ScheduledThreadPoolExecutor r4, boolean r5, @androidx.annotation.NonNull pl.droidsonroids.gif.GifOptions r6) throws java.io.IOException {
        /*
            r1 = this;
            pl.droidsonroids.gif.GifInfoHandle r2 = r2.a()
            char r0 = r6.a
            boolean r6 = r6.b
            r2.J(r0, r6)
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.GifDrawable.<init>(pl.droidsonroids.gif.InputSource, pl.droidsonroids.gif.GifDrawable, java.util.concurrent.ScheduledThreadPoolExecutor, boolean, pl.droidsonroids.gif.GifOptions):void");
    }

    @Nullable
    public static GifDrawable createFromResource(@NonNull Resources resources, @DrawableRes @RawRes int i2) {
        try {
            return new GifDrawable(resources, i2);
        } catch (IOException unused) {
            return null;
        }
    }

    public void a(long j2) {
        if (this.k) {
            this.c = 0;
            this.l.sendEmptyMessageAtTime(-1, 0);
            return;
        }
        ScheduledFuture<?> scheduledFuture = this.o;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.l.removeMessages(-1);
        this.o = this.a.schedule(this.m, Math.max(j2, 0L), TimeUnit.MILLISECONDS);
    }

    public void addAnimationListener(@NonNull AnimationListener animationListener) {
        this.g.add(animationListener);
    }

    public final PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return getNumberOfFrames() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return getNumberOfFrames() > 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z;
        if (this.i == null || this.mPaint.getColorFilter() != null) {
            z = false;
        } else {
            this.mPaint.setColorFilter(this.i);
            z = true;
        }
        Transform transform = this.r;
        if (transform == null) {
            canvas.drawBitmap(this.e, this.n, this.d, this.mPaint);
        } else {
            transform.onDraw(canvas, this.mPaint, this.e);
        }
        if (z) {
            this.mPaint.setColorFilter(null);
        }
    }

    public long getAllocationByteCount() {
        return this.f.b() + ((long) this.e.getAllocationByteCount());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    @Nullable
    public String getComment() {
        return this.f.c();
    }

    @FloatRange(from = 0.0d)
    public float getCornerRadius() {
        Transform transform = this.r;
        if (transform instanceof CornerRadiusTransform) {
            return ((CornerRadiusTransform) transform).getCornerRadius();
        }
        return 0.0f;
    }

    public Bitmap getCurrentFrame() {
        Bitmap bitmap = this.e;
        Bitmap copy = bitmap.copy(bitmap.getConfig(), this.e.isMutable());
        copy.setHasAlpha(this.e.hasAlpha());
        return copy;
    }

    public int getCurrentFrameIndex() {
        return this.f.d();
    }

    public int getCurrentLoop() {
        int e2 = this.f.e();
        return (e2 == 0 || e2 < this.f.j()) ? e2 : e2 - 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f.f();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f.g();
    }

    @NonNull
    public GifError getError() {
        return GifError.a(this.f.l());
    }

    public int getFrameByteCount() {
        return this.e.getHeight() * this.e.getRowBytes();
    }

    public int getFrameDuration(@IntRange(from = 0) int i2) {
        return this.f.h(i2);
    }

    public long getInputSourceByteCount() {
        return this.f.o();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.p;
    }

    public int getLoopCount() {
        return this.f.j();
    }

    public long getMetadataAllocationByteCount() {
        return this.f.k();
    }

    public int getNumberOfFrames() {
        return this.f.m();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f.u() || this.mPaint.getAlpha() < 255) ? -2 : -1;
    }

    @NonNull
    public final Paint getPaint() {
        return this.mPaint;
    }

    public int getPixel(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        if (i2 >= this.f.p()) {
            throw new IllegalArgumentException("x must be < width");
        } else if (i3 < this.f.i()) {
            return this.e.getPixel(i2, i3);
        } else {
            throw new IllegalArgumentException("y must be < height");
        }
    }

    public void getPixels(@NonNull int[] iArr) {
        this.e.getPixels(iArr, 0, this.f.p(), 0, 0, this.f.p(), this.f.i());
    }

    @Nullable
    public Transform getTransform() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        if (this.k && this.b) {
            long j2 = this.c;
            if (j2 != Long.MIN_VALUE) {
                long max = Math.max(0L, j2 - SystemClock.uptimeMillis());
                this.c = Long.MIN_VALUE;
                this.a.remove(this.m);
                this.o = this.a.schedule(this.m, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public boolean isAnimationCompleted() {
        return this.f.t();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.b;
    }

    public boolean isRecycled() {
        return this.f.v();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.h) != null && colorStateList.isStateful());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.d.set(rect);
        Transform transform = this.r;
        if (transform != null) {
            transform.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.h;
        if (colorStateList == null || (mode = this.j) == null) {
            return false;
        }
        this.i = b(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    public void recycle() {
        this.b = false;
        this.l.removeMessages(-1);
        this.f.z();
        this.e.recycle();
    }

    public boolean removeAnimationListener(AnimationListener animationListener) {
        return this.g.remove(animationListener);
    }

    public void reset() {
        this.a.execute(new a(this));
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(@IntRange(from = 0, to = 2147483647L) int i2) {
        if (i2 >= 0) {
            this.a.execute(new b(this, i2));
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    public void seekToBlocking(@IntRange(from = 0, to = 2147483647L) int i2) {
        if (i2 >= 0) {
            synchronized (this.f) {
                this.f.H(i2, this.e);
            }
            this.l.sendEmptyMessageAtTime(-1, 0);
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    public void seekToFrame(@IntRange(from = 0, to = 2147483647L) int i2) {
        if (i2 >= 0) {
            this.a.execute(new c(this, i2));
            return;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public Bitmap seekToFrameAndGet(@IntRange(from = 0, to = 2147483647L) int i2) {
        Bitmap currentFrame;
        if (i2 >= 0) {
            synchronized (this.f) {
                this.f.F(i2, this.e);
                currentFrame = getCurrentFrame();
            }
            this.l.sendEmptyMessageAtTime(-1, 0);
            return currentFrame;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public Bitmap seekToPositionAndGet(@IntRange(from = 0, to = 2147483647L) int i2) {
        Bitmap currentFrame;
        if (i2 >= 0) {
            synchronized (this.f) {
                this.f.H(i2, this.e);
                currentFrame = getCurrentFrame();
            }
            this.l.sendEmptyMessageAtTime(-1, 0);
            return currentFrame;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.mPaint.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setCornerRadius(@FloatRange(from = 0.0d) float f2) {
        CornerRadiusTransform cornerRadiusTransform = new CornerRadiusTransform(f2);
        this.r = cornerRadiusTransform;
        cornerRadiusTransform.onBoundsChange(this.d);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setLoopCount(@IntRange(from = 0, to = 65535) int i2) {
        this.f.I(i2);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this.f.K(f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        this.i = b(colorStateList, this.j);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.j = mode;
        this.i = b(this.h, mode);
        invalidateSelf();
    }

    public void setTransform(@Nullable Transform transform) {
        this.r = transform;
        if (transform != null) {
            transform.onBoundsChange(this.d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.k) {
            if (z) {
                if (z2) {
                    reset();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            if (!this.b) {
                this.b = true;
                a(this.f.C());
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (this.b) {
                this.b = false;
            } else {
                return;
            }
        }
        ScheduledFuture<?> scheduledFuture = this.o;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.l.removeMessages(-1);
        this.f.E();
    }

    @Override // java.lang.Object
    @NonNull
    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.f.p()), Integer.valueOf(this.f.i()), Integer.valueOf(this.f.m()), Integer.valueOf(this.f.l()));
    }

    public GifDrawable(@NonNull Resources resources, @DrawableRes @RawRes int i2) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i2));
        List<String> list = d.a;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.density;
        if (i3 == 0) {
            i3 = 160;
        } else if (i3 == 65535) {
            i3 = 0;
        }
        int i4 = resources.getDisplayMetrics().densityDpi;
        float f2 = (i3 <= 0 || i4 <= 0) ? 1.0f : ((float) i4) / ((float) i3);
        this.q = (int) (((float) this.f.i()) * f2);
        this.p = (int) (((float) this.f.p()) * f2);
    }

    public GifDrawable(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public GifDrawable(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str), null, null, true);
    }

    public GifDrawable(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public GifDrawable(@NonNull InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream), null, null, true);
    }

    public GifDrawable(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public GifDrawable(@NonNull FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor), null, null, true);
    }

    public GifDrawable(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr), null, null, true);
    }

    public GifDrawable(@NonNull ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer), null, null, true);
    }

    public GifDrawable(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.x(contentResolver, uri), null, null, true);
    }

    public GifDrawable(GifInfoHandle gifInfoHandle, GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.b = true;
        this.c = Long.MIN_VALUE;
        this.d = new Rect();
        this.mPaint = new Paint(6);
        this.g = new ConcurrentLinkedQueue<>();
        g gVar = new g(this);
        this.m = gVar;
        this.k = z;
        if (scheduledThreadPoolExecutor == null) {
            int i2 = y6.a.a.b.a;
            scheduledThreadPoolExecutor = b.C0702b.a;
        }
        this.a = scheduledThreadPoolExecutor;
        this.f = gifInfoHandle;
        Bitmap bitmap = null;
        if (gifDrawable != null) {
            synchronized (gifDrawable.f) {
                if (!gifDrawable.f.v() && gifDrawable.f.i() >= gifInfoHandle.i() && gifDrawable.f.p() >= gifInfoHandle.p()) {
                    gifDrawable.b = false;
                    gifDrawable.l.removeMessages(-1);
                    gifDrawable.f.z();
                    Bitmap bitmap2 = gifDrawable.e;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.e = Bitmap.createBitmap(gifInfoHandle.p(), gifInfoHandle.i(), Bitmap.Config.ARGB_8888);
        } else {
            this.e = bitmap;
        }
        this.e.setHasAlpha(!gifInfoHandle.u());
        this.n = new Rect(0, 0, gifInfoHandle.p(), gifInfoHandle.i());
        this.l = new e(this);
        gVar.a();
        this.p = gifInfoHandle.p();
        this.q = gifInfoHandle.i();
    }
}
