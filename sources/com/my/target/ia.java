package com.my.target;

import a2.l.a.q;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.my.target.common.models.ImageData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
public class ia {
    @NonNull
    public static final WeakHashMap<ImageView, ImageData> c = new WeakHashMap<>();
    @NonNull
    public final List<ImageData> a;
    @Nullable
    public a b;

    public interface a {
        void i(boolean z);
    }

    public static class b implements a {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ ImageData b;
        public final /* synthetic */ a c;

        public b(WeakReference weakReference, ImageData imageData, a aVar) {
            this.a = weakReference;
            this.b = imageData;
            this.c = aVar;
        }

        @Override // com.my.target.ia.a
        public void i(boolean z) {
            WeakHashMap<ImageView, ImageData> weakHashMap;
            ImageView imageView = (ImageView) this.a.get();
            boolean z2 = true;
            if (imageView != null && this.b == (weakHashMap = ia.c).get(imageView)) {
                weakHashMap.remove(imageView);
                Bitmap bitmap = this.b.getBitmap();
                if (bitmap != null) {
                    if (imageView instanceof gc) {
                        ((gc) imageView).setImageBitmap(bitmap, true);
                    } else {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
            a aVar = this.c;
            if (aVar != null) {
                if (this.b.getBitmap() == null) {
                    z2 = false;
                }
                aVar.i(z2);
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ia.this.ab(this.a);
            ia iaVar = ia.this;
            if (iaVar.b != null) {
                af.c(new q(iaVar));
            }
        }
    }

    public ia(@NonNull List<ImageData> list) {
        this.a = list;
    }

    @UiThread
    public static void a(@NonNull ImageData imageData, @NonNull ImageView imageView) {
        a(imageData, imageView, null);
    }

    @UiThread
    public static void a(@NonNull ImageData imageData, @NonNull ImageView imageView, @Nullable a aVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ae.b("[ImageLoader] method loadAndDisplay called from worker thread");
            return;
        }
        WeakHashMap<ImageView, ImageData> weakHashMap = c;
        if (weakHashMap.get(imageView) != imageData) {
            weakHashMap.remove(imageView);
            if (imageData.getBitmap() != null) {
                Bitmap bitmap = imageData.getBitmap();
                if (imageView instanceof gc) {
                    ((gc) imageView).setImageBitmap(bitmap, true);
                } else {
                    imageView.setImageBitmap(bitmap);
                }
            } else {
                weakHashMap.put(imageView, imageData);
                b(imageData).a(new b(new WeakReference(imageView), imageData, aVar)).aa(imageView.getContext());
            }
        }
    }

    @NonNull
    public static ia b(@NonNull ImageData imageData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(imageData);
        return new ia(arrayList);
    }

    @UiThread
    public static void b(@NonNull ImageData imageData, @NonNull ImageView imageView) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ae.b("[ImageLoader] method cancel called from worker thread");
            return;
        }
        WeakHashMap<ImageView, ImageData> weakHashMap = c;
        if (weakHashMap.get(imageView) == imageData) {
            weakHashMap.remove(imageView);
        }
    }

    @NonNull
    public static ia g(@NonNull List<ImageData> list) {
        return new ia(list);
    }

    @NonNull
    public ia a(@Nullable a aVar) {
        this.b = aVar;
        return this;
    }

    public void aa(@NonNull Context context) {
        if (!this.a.isEmpty()) {
            af.a(new c(context.getApplicationContext()));
        } else if (this.b != null) {
            af.c(new q(this));
        }
    }

    @WorkerThread
    public void ab(@NonNull Context context) {
        Bitmap bitmap;
        if (af.isMainThread()) {
            ae.b("[ImageLoader] method loadSync called from main thread");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        dc cF = dc.cF();
        for (ImageData imageData : this.a) {
            if (imageData.getBitmap() == null && (bitmap = (Bitmap) cF.f(imageData.getUrl(), applicationContext)) != null) {
                imageData.setData(bitmap);
                if (imageData.getHeight() == 0 || imageData.getWidth() == 0) {
                    imageData.setHeight(bitmap.getHeight());
                    imageData.setWidth(bitmap.getWidth());
                }
            }
        }
    }
}
