package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.List;
public class GifFrameLoader {
    public final GifDecoder a;
    public final Handler b;
    public final List<FrameCallback> c = new ArrayList();
    public final RequestManager d;
    public final BitmapPool e;
    public boolean f;
    public boolean g;
    public boolean h;
    public RequestBuilder<Bitmap> i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public Transformation<Bitmap> n;
    public a o;
    public int p;
    public int q;
    public int r;

    public interface FrameCallback {
        void onFrameReady();
    }

    @VisibleForTesting
    public static class a extends CustomTarget<Bitmap> {
        public final Handler d;
        public final int e;
        public final long f;
        public Bitmap g;

        public a(Handler handler, int i, long j) {
            this.d = handler;
            this.e = i;
            this.f = j;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
            this.g = null;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
            this.g = (Bitmap) obj;
            this.d.sendMessageAtTime(this.d.obtainMessage(1, this), this.f);
        }
    }

    public class b implements Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.b((a) message.obj);
                return true;
            } else if (i != 2) {
                return false;
            } else {
                GifFrameLoader.this.d.clear((a) message.obj);
                return false;
            }
        }
    }

    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i2, int i3, Transformation<Bitmap> transformation, Bitmap bitmap) {
        BitmapPool bitmapPool = glide.getBitmapPool();
        RequestManager with = Glide.with(glide.getContext());
        RequestBuilder<Bitmap> apply = Glide.with(glide.getContext()).asBitmap().apply(((RequestOptions) ((RequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true)).skipMemoryCache(true)).override(i2, i3));
        this.d = with;
        Handler handler = new Handler(Looper.getMainLooper(), new b());
        this.e = bitmapPool;
        this.b = handler;
        this.i = apply;
        this.a = gifDecoder;
        c(transformation, bitmap);
    }

    public final void a() {
        if (this.f && !this.g) {
            if (this.h) {
                Preconditions.checkArgument(this.o == null, "Pending target must be null when starting from the first frame");
                this.a.resetFrameIndex();
                this.h = false;
            }
            a aVar = this.o;
            if (aVar != null) {
                this.o = null;
                b(aVar);
                return;
            }
            this.g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.a.getNextDelay());
            this.a.advance();
            this.l = new a(this.b, this.a.getCurrentFrameIndex(), uptimeMillis);
            this.i.apply((BaseRequestOptions<?>) RequestOptions.signatureOf(new ObjectKey(Double.valueOf(Math.random())))).load((Object) this.a).into((RequestBuilder<Bitmap>) this.l);
        }
    }

    @VisibleForTesting
    public void b(a aVar) {
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f) {
            this.o = aVar;
        } else {
            if (aVar.g != null) {
                Bitmap bitmap = this.m;
                if (bitmap != null) {
                    this.e.put(bitmap);
                    this.m = null;
                }
                a aVar2 = this.j;
                this.j = aVar;
                int size = this.c.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    this.c.get(size).onFrameReady();
                }
                if (aVar2 != null) {
                    this.b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            a();
        }
    }

    public void c(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.n = (Transformation) Preconditions.checkNotNull(transformation);
        this.m = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.i = this.i.apply(new RequestOptions().transform(transformation));
        this.p = Util.getBitmapByteSize(bitmap);
        this.q = bitmap.getWidth();
        this.r = bitmap.getHeight();
    }
}
