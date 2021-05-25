package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    @IdRes
    public static final int e = R.id.glide_custom_view_target_tag;
    public final b a;
    @Nullable
    public View.OnAttachStateChangeListener b;
    public boolean c;
    public boolean d;
    public final T view;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Request request = CustomViewTarget.this.getRequest();
            if (request != null && request.isCleared()) {
                request.begin();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            CustomViewTarget customViewTarget = CustomViewTarget.this;
            Request request = customViewTarget.getRequest();
            if (request != null) {
                customViewTarget.c = true;
                request.clear();
                customViewTarget.c = false;
            }
        }
    }

    @VisibleForTesting
    public static final class b {
        @Nullable
        @VisibleForTesting
        public static Integer e;
        public final View a;
        public final List<SizeReadyCallback> b = new ArrayList();
        public boolean c;
        @Nullable
        public a d;

        public static final class a implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<b> a;

            public a(@NonNull b bVar) {
                this.a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                b bVar = this.a.get();
                if (bVar == null || bVar.b.isEmpty()) {
                    return true;
                }
                int d = bVar.d();
                int c = bVar.c();
                if (!bVar.e(d, c)) {
                    return true;
                }
                Iterator it = new ArrayList(bVar.b).iterator();
                while (it.hasNext()) {
                    ((SizeReadyCallback) it.next()).onSizeReady(d, c);
                }
                bVar.a();
                return true;
            }
        }

        public b(@NonNull View view) {
            this.a = view;
        }

        public void a() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        public final int b(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            Log.isLoggable("CustomViewTarget", 4);
            Context context = this.a.getContext();
            if (e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return e.intValue();
        }

        public final int c() {
            int paddingBottom = this.a.getPaddingBottom() + this.a.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return b(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        public final int d() {
            int paddingRight = this.a.getPaddingRight() + this.a.getPaddingLeft();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return b(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        public final boolean e(int i, int i2) {
            if (i > 0 || i == Integer.MIN_VALUE) {
                if (i2 > 0 || i2 == Integer.MIN_VALUE) {
                    return true;
                }
            }
            return false;
        }
    }

    public CustomViewTarget(@NonNull T t) {
        this.view = (T) ((View) Preconditions.checkNotNull(t));
        this.a = new b(t);
    }

    @NonNull
    public final CustomViewTarget<T, Z> clearOnDetach() {
        if (this.b != null) {
            return this;
        }
        a aVar = new a();
        this.b = aVar;
        if (!this.d) {
            this.view.addOnAttachStateChangeListener(aVar);
            this.d = true;
        }
        return this;
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public final Request getRequest() {
        Object tag = this.view.getTag(e);
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        b bVar = this.a;
        int d2 = bVar.d();
        int c2 = bVar.c();
        if (bVar.e(d2, c2)) {
            sizeReadyCallback.onSizeReady(d2, c2);
            return;
        }
        if (!bVar.b.contains(sizeReadyCallback)) {
            bVar.b.add(sizeReadyCallback);
        }
        if (bVar.d == null) {
            ViewTreeObserver viewTreeObserver = bVar.a.getViewTreeObserver();
            b.a aVar = new b.a(bVar);
            bVar.d = aVar;
            viewTreeObserver.addOnPreDrawListener(aVar);
        }
    }

    @NonNull
    public final T getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(@Nullable Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        this.a.a();
        onResourceCleared(drawable);
        if (!this.c && (onAttachStateChangeListener = this.b) != null && this.d) {
            this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.d = false;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(@Nullable Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.b;
        if (onAttachStateChangeListener != null && !this.d) {
            this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.d = true;
        }
        onResourceLoading(drawable);
    }

    public abstract void onResourceCleared(@Nullable Drawable drawable);

    public void onResourceLoading(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.a.b.remove(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(@Nullable Request request) {
        this.view.setTag(e, request);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Target for: ");
        L.append(this.view);
        return L.toString();
    }

    @Deprecated
    public final CustomViewTarget<T, Z> useTagId(@IdRes int i) {
        return this;
    }

    @NonNull
    public final CustomViewTarget<T, Z> waitForLayout() {
        this.a.c = true;
        return this;
    }
}
