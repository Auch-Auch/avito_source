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
import androidx.annotation.CallSuper;
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
@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    public static boolean f;
    public static int g = R.id.glide_custom_view_target_tag;
    public final b b;
    @Nullable
    public View.OnAttachStateChangeListener c;
    public boolean d;
    public boolean e;
    public final T view;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Request request = ViewTarget.this.getRequest();
            if (request != null && request.isCleared()) {
                request.begin();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTarget viewTarget = ViewTarget.this;
            Request request = viewTarget.getRequest();
            if (request != null) {
                viewTarget.d = true;
                request.clear();
                viewTarget.d = false;
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
                if (Log.isLoggable("ViewTarget", 2)) {
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
            Log.isLoggable("ViewTarget", 4);
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

    public ViewTarget(@NonNull T t) {
        this.view = (T) ((View) Preconditions.checkNotNull(t));
        this.b = new b(t);
    }

    @Deprecated
    public static void setTagId(int i) {
        if (!f) {
            g = i;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @NonNull
    public final ViewTarget<T, Z> clearOnDetach() {
        if (this.c != null) {
            return this;
        }
        a aVar = new a();
        this.c = aVar;
        if (!this.e) {
            this.view.addOnAttachStateChangeListener(aVar);
            this.e = true;
        }
        return this;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @Nullable
    public Request getRequest() {
        Object tag = this.view.getTag(g);
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        b bVar = this.b;
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
    public T getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadCleared(@Nullable Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onLoadCleared(drawable);
        this.b.a();
        if (!this.d && (onAttachStateChangeListener = this.c) != null && this.e) {
            this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.e = false;
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener != null && !this.e) {
            this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.e = true;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.b.b.remove(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(@Nullable Request request) {
        f = true;
        this.view.setTag(g, request);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Target for: ");
        L.append(this.view);
        return L.toString();
    }

    @NonNull
    public final ViewTarget<T, Z> waitForLayout() {
        this.b.c = true;
        return this;
    }

    @Deprecated
    public ViewTarget(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            waitForLayout();
        }
    }
}
