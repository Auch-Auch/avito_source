package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
public final class AsyncLayoutInflater {
    public LayoutInflater a;
    public Handler b;
    public d c;
    public Handler.Callback d = new a();

    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View view, @LayoutRes int i, @Nullable ViewGroup viewGroup);
    }

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            c cVar = (c) message.obj;
            if (cVar.d == null) {
                cVar.d = AsyncLayoutInflater.this.a.inflate(cVar.c, cVar.b, false);
            }
            cVar.e.onInflateFinished(cVar.d, cVar.c, cVar.b);
            d dVar = AsyncLayoutInflater.this.c;
            Objects.requireNonNull(dVar);
            cVar.e = null;
            cVar.a = null;
            cVar.b = null;
            cVar.c = 0;
            cVar.d = null;
            dVar.b.release(cVar);
            return true;
        }
    }

    public static class b extends LayoutInflater {
        public static final String[] a = {"android.widget.", "android.webkit.", "android.app."};

        public b(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new b(context);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            for (String str2 : a) {
                try {
                    View createView = createView(str, str2, attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    public static class c {
        public AsyncLayoutInflater a;
        public ViewGroup b;
        public int c;
        public View d;
        public OnInflateFinishedListener e;
    }

    public static class d extends Thread {
        public static final d c;
        public ArrayBlockingQueue<c> a = new ArrayBlockingQueue<>(10);
        public Pools.SynchronizedPool<c> b = new Pools.SynchronizedPool<>(10);

        static {
            d dVar = new d();
            c = dVar;
            dVar.start();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    c take = this.a.take();
                    try {
                        take.d = take.a.a.inflate(take.c, take.b, false);
                    } catch (RuntimeException unused) {
                    }
                    Message.obtain(take.a.b, 0, take).sendToTarget();
                } catch (InterruptedException unused2) {
                }
            }
        }
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.a = new b(context);
        this.b = new Handler(this.d);
        this.c = d.c;
    }

    @UiThread
    public void inflate(@LayoutRes int i, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        Objects.requireNonNull(onInflateFinishedListener, "callback argument may not be null!");
        c acquire = this.c.b.acquire();
        if (acquire == null) {
            acquire = new c();
        }
        acquire.a = this;
        acquire.c = i;
        acquire.b = viewGroup;
        acquire.e = onInflateFinishedListener;
        d dVar = this.c;
        Objects.requireNonNull(dVar);
        try {
            dVar.a.put(acquire);
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }
    }
}
