package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.LruCache;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zaj;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zaq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import ru.avito.messenger.internal.ConstantsKt;
public final class ImageManager {
    private static final Object zaa = new Object();
    private static HashSet<Uri> zab = new HashSet<>();
    private static ImageManager zac;
    private final Context zad;
    private final Handler zae = new zap(Looper.getMainLooper());
    private final ExecutorService zaf = zal.zaa().zaa(4, zaq.zab);
    @Nullable
    private final zaa zag = null;
    private final zaj zah = new zaj();
    private final Map<zab, ImageReceiver> zai = new HashMap();
    private final Map<Uri, ImageReceiver> zaj = new HashMap();
    private final Map<Uri, Long> zak = new HashMap();

    public interface OnImageLoadedListener {
        void onImageLoaded(@RecentlyNonNull Uri uri, @Nullable Drawable drawable, @RecentlyNonNull boolean z);
    }

    public static final class zaa extends LruCache<zaa, Bitmap> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // androidx.collection.LruCache
        public final /* synthetic */ void entryRemoved(boolean z, zaa zaa, Bitmap bitmap, @Nullable Bitmap bitmap2) {
            throw new NoSuchMethodError();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // androidx.collection.LruCache
        public final /* synthetic */ int sizeOf(zaa zaa, Bitmap bitmap) {
            throw new NoSuchMethodError();
        }
    }

    public final class zab implements Runnable {
        private final zab zaa;

        public zab(zab zab2) {
            this.zaa = zab2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zai.get(this.zaa);
            if (imageReceiver != null) {
                ImageManager.this.zai.remove(this.zaa);
                imageReceiver.zab(this.zaa);
            }
            zab zab2 = this.zaa;
            zaa zaa2 = zab2.zaa;
            if (zaa2.zaa == null) {
                zab2.zaa(ImageManager.this.zad, ImageManager.this.zah, true);
                return;
            }
            Bitmap zaa3 = ImageManager.this.zaa(zaa2);
            if (zaa3 != null) {
                this.zaa.zaa(ImageManager.this.zad, zaa3, true);
                return;
            }
            Long l = (Long) ImageManager.this.zak.get(zaa2.zaa);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS) {
                    this.zaa.zaa(ImageManager.this.zad, ImageManager.this.zah, true);
                    return;
                }
                ImageManager.this.zak.remove(zaa2.zaa);
            }
            this.zaa.zaa(ImageManager.this.zad, ImageManager.this.zah);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zaj.get(zaa2.zaa);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zaa2.zaa);
                ImageManager.this.zaj.put(zaa2.zaa, imageReceiver2);
            }
            imageReceiver2.zaa(this.zaa);
            if (!(this.zaa instanceof zac)) {
                ImageManager.this.zai.put(this.zaa, imageReceiver2);
            }
            synchronized (ImageManager.zaa) {
                if (!ImageManager.zab.contains(zaa2.zaa)) {
                    ImageManager.zab.add(zaa2.zaa);
                    imageReceiver2.zaa();
                }
            }
        }
    }

    public final class zac implements Runnable {
        private final Uri zaa;
        @Nullable
        private final ParcelFileDescriptor zab;

        public zac(Uri uri, @Nullable ParcelFileDescriptor parcelFileDescriptor) {
            this.zaa = uri;
            this.zab = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            Bitmap bitmap;
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.zab;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError unused) {
                    String.valueOf(this.zaa).length();
                    z2 = true;
                }
                try {
                    this.zab.close();
                } catch (IOException unused2) {
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.zae.post(new zad(this.zaa, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused3) {
                String.valueOf(this.zaa).length();
            }
        }
    }

    public final class zad implements Runnable {
        private final Uri zaa;
        @Nullable
        private final Bitmap zab;
        private final CountDownLatch zac;
        private boolean zad;

        public zad(Uri uri, @Nullable Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zaa = uri;
            this.zab = bitmap;
            this.zad = z;
            this.zac = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.zab != null;
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zaj.remove(this.zaa);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.zab;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    zab zab2 = (zab) arrayList.get(i);
                    if (this.zab == null || !z) {
                        ImageManager.this.zak.put(this.zaa, Long.valueOf(SystemClock.elapsedRealtime()));
                        zab2.zaa(ImageManager.this.zad, ImageManager.this.zah, false);
                    } else {
                        zab2.zaa(ImageManager.this.zad, this.zab, false);
                    }
                    if (!(zab2 instanceof zac)) {
                        ImageManager.this.zai.remove(zab2);
                    }
                }
            }
            this.zac.countDown();
            synchronized (ImageManager.zaa) {
                ImageManager.zab.remove(this.zaa);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.zad = context.getApplicationContext();
    }

    @RecentlyNonNull
    public static ImageManager create(@RecentlyNonNull Context context) {
        if (zac == null) {
            zac = new ImageManager(context, false);
        }
        return zac;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @Nullable
    private final Bitmap zaa(zaa zaa2) {
        return null;
    }

    private final void zaa(zab zab2) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zab(zab2).run();
    }

    public final void loadImage(@RecentlyNonNull ImageView imageView, @RecentlyNonNull Uri uri) {
        zaa(new zad(imageView, uri));
    }

    @KeepName
    public final class ImageReceiver extends ResultReceiver {
        private final Uri zaa;
        private final ArrayList<zab> zab = new ArrayList<>();

        public ImageReceiver(Uri uri) {
            super(new zap(Looper.getMainLooper()));
            this.zaa = uri;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zaf.execute(new zac(this.zaa, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zaa(zab zab2) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zab.add(zab2);
        }

        public final void zab(zab zab2) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zab.remove(zab2);
        }

        public final void zaa() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(Constants.EXTRA_URI, this.zaa);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.zad.sendBroadcast(intent);
        }
    }

    public final void loadImage(@RecentlyNonNull ImageView imageView, @RecentlyNonNull int i) {
        zaa(new zad(imageView, i));
    }

    public final void loadImage(@RecentlyNonNull ImageView imageView, @RecentlyNonNull Uri uri, @RecentlyNonNull int i) {
        zad zad2 = new zad(imageView, uri);
        zad2.zab = i;
        zaa(zad2);
    }

    public final void loadImage(@RecentlyNonNull OnImageLoadedListener onImageLoadedListener, @RecentlyNonNull Uri uri) {
        zaa(new zac(onImageLoadedListener, uri));
    }

    public final void loadImage(@RecentlyNonNull OnImageLoadedListener onImageLoadedListener, @RecentlyNonNull Uri uri, @RecentlyNonNull int i) {
        zac zac2 = new zac(onImageLoadedListener, uri);
        zac2.zab = i;
        zaa(zac2);
    }
}
