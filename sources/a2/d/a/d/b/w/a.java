package a2.d.a.d.b.w;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public final class a implements Runnable {
    public static final C0017a i = new C0017a();
    public static final long j = TimeUnit.SECONDS.toMillis(1);
    public final BitmapPool a;
    public final MemoryCache b;
    public final b c;
    public final C0017a d;
    public final Set<PreFillType> e = new HashSet();
    public final Handler f;
    public long g = 40;
    public boolean h;

    @VisibleForTesting
    /* renamed from: a2.d.a.d.b.w.a$a  reason: collision with other inner class name */
    public static class C0017a {
    }

    public static final class b implements Key {
        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(BitmapPool bitmapPool, MemoryCache memoryCache, b bVar) {
        C0017a aVar = i;
        Handler handler = new Handler(Looper.getMainLooper());
        this.a = bitmapPool;
        this.b = memoryCache;
        this.c = bVar;
        this.d = aVar;
        this.f = handler;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010c, code lost:
        if ((r10.c.c == 0) == false) goto L_0x0110;
     */
    @Override // java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        // Method dump skipped, instructions count: 294
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.d.a.d.b.w.a.run():void");
    }
}
