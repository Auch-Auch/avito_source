package com.yandex.mobile.ads.nativeads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.yandex.mobile.ads.impl.ms;
import com.yandex.mobile.ads.impl.mt;
import com.yandex.mobile.ads.impl.mv;
import com.yandex.mobile.ads.impl.rh;
import java.lang.ref.WeakReference;
public final class bo {
    @NonNull
    private final rh a = new rh();
    @NonNull
    private final ms b = mt.a();
    @Nullable
    private b c;
    @Nullable
    private mv d;
    @Nullable
    private a e;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        @NonNull
        private final WeakReference<View> b;

        public a(View view) {
            this.b = new WeakReference<>(view);
        }

        public final void a() {
            View view = this.b.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Integer valueOf;
            View view = this.b.get();
            if (view != null && view.getTag() != (valueOf = Integer.valueOf(view.getVisibility()))) {
                view.setTag(valueOf);
                if (bo.this.c == null) {
                    return;
                }
                if (valueOf.intValue() == 0) {
                    bo.this.c.a();
                } else {
                    bo.this.c.b();
                }
            }
        }
    }

    public interface b {
        void a();

        void b();
    }

    public class c implements mv {
        private final WeakReference<Context> b;

        public c(Context context) {
            this.b = new WeakReference<>(context);
        }

        @Override // com.yandex.mobile.ads.impl.mv
        public final void a(@NonNull Activity activity) {
            Context context = this.b.get();
            if (context != null && context.equals(activity) && bo.this.c != null) {
                bo.this.c.a();
            }
        }

        @Override // com.yandex.mobile.ads.impl.mv
        public final void b(@NonNull Activity activity) {
            Context context = this.b.get();
            if (context != null && context.equals(activity) && bo.this.c != null) {
                bo.this.c.b();
            }
        }
    }

    private void b(@NonNull Context context) {
        mv mvVar = this.d;
        if (mvVar != null) {
            this.b.b(context, mvVar);
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(@NonNull View view, @NonNull b bVar) {
        this.c = bVar;
        b(view.getContext());
        Context a3 = rh.a(view.getContext());
        if (a3 != null) {
            this.d = new c(a3);
            this.e = new a(view);
            this.b.a(a3, this.d);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
        }
    }

    public final void a(@NonNull Context context) {
        this.c = null;
        b(context);
    }
}
