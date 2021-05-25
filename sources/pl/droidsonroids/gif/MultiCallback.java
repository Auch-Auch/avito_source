package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
public class MultiCallback implements Drawable.Callback {
    public final CopyOnWriteArrayList<a> a;
    public final boolean b;

    public static final class a extends WeakReference<Drawable.Callback> {
        public a(Drawable.Callback callback) {
            super(callback);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass() && get() == ((a) obj).get()) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Drawable.Callback callback = (Drawable.Callback) get();
            if (callback != null) {
                return callback.hashCode();
            }
            return 0;
        }
    }

    public MultiCallback() {
        this(false);
    }

    public void addView(Drawable.Callback callback) {
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = this.a.get(i);
            if (((Drawable.Callback) aVar.get()) == null) {
                this.a.remove(aVar);
            }
        }
        this.a.addIfAbsent(new a(callback));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = this.a.get(i);
            Drawable.Callback callback = (Drawable.Callback) aVar.get();
            if (callback == null) {
                this.a.remove(aVar);
            } else if (!this.b || !(callback instanceof View)) {
                callback.invalidateDrawable(drawable);
            } else {
                ((View) callback).invalidate();
            }
        }
    }

    public void removeView(Drawable.Callback callback) {
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = this.a.get(i);
            Drawable.Callback callback2 = (Drawable.Callback) aVar.get();
            if (callback2 == null || callback2 == callback) {
                this.a.remove(aVar);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = this.a.get(i);
            Drawable.Callback callback = (Drawable.Callback) aVar.get();
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            } else {
                this.a.remove(aVar);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = this.a.get(i);
            Drawable.Callback callback = (Drawable.Callback) aVar.get();
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            } else {
                this.a.remove(aVar);
            }
        }
    }

    public MultiCallback(boolean z) {
        this.a = new CopyOnWriteArrayList<>();
        this.b = z;
    }
}
