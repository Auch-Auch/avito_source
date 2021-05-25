package com.androidadvance.topsnackbar;

import a2.c.a.a;
import a2.c.a.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
public final class TSnackbar {
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    public static final Handler g = new Handler(Looper.getMainLooper(), new a());
    public final ViewGroup a;
    public final Context b;
    public final SnackbarLayout c;
    public int d;
    public Callback e;
    public final a.b f = new c();

    public static abstract class Callback {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public void onDismissed(TSnackbar tSnackbar, int i) {
        }

        public void onShown(TSnackbar tSnackbar) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public static class SnackbarLayout extends LinearLayout {
        public TextView a;
        public Button b;
        public int c;
        public int d;
        public b e;
        public a f;

        public interface a {
        }

        public interface b {
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public final boolean a(int i, int i2, int i3) {
            boolean z;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            } else {
                z = false;
            }
            if (this.a.getPaddingTop() == i2 && this.a.getPaddingBottom() == i3) {
                return z;
            }
            TextView textView = this.a;
            if (ViewCompat.isPaddingRelative(textView)) {
                ViewCompat.setPaddingRelative(textView, ViewCompat.getPaddingStart(textView), i2, ViewCompat.getPaddingEnd(textView), i3);
                return true;
            }
            textView.setPadding(textView.getPaddingLeft(), i2, textView.getPaddingRight(), i3);
            return true;
        }

        public Button getActionView() {
            return this.b;
        }

        public TextView getMessageView() {
            return this.a;
        }

        @Override // android.view.View, android.view.ViewGroup
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            a aVar = this.f;
            if (aVar != null) {
                Objects.requireNonNull((a2.c.a.d) aVar);
            }
        }

        @Override // android.view.View, android.view.ViewGroup
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            a aVar = this.f;
            if (aVar != null) {
                a2.c.a.d dVar = (a2.c.a.d) aVar;
                if (dVar.a.isShownOrQueued()) {
                    TSnackbar.g.post(new a2.c.a.c(dVar));
                }
            }
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            this.a = (TextView) findViewById(R.id.snackbar_text);
            this.b = (Button) findViewById(R.id.snackbar_action);
        }

        @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            b bVar;
            super.onLayout(z, i, i2, i3, i4);
            if (z && (bVar = this.e) != null) {
                a2.c.a.e eVar = (a2.c.a.e) bVar;
                TSnackbar tSnackbar = eVar.a;
                int i5 = TSnackbar.LENGTH_INDEFINITE;
                tSnackbar.a();
                eVar.a.c.setOnLayoutChangeListener(null);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
            if (a(1, r0, r0 - r1) != false) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
            if (a(0, r0, r0) != false) goto L_0x0060;
         */
        @Override // android.widget.LinearLayout, android.view.View
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                super.onMeasure(r8, r9)
                int r0 = r7.c
                if (r0 <= 0) goto L_0x0018
                int r0 = r7.getMeasuredWidth()
                int r1 = r7.c
                if (r0 <= r1) goto L_0x0018
                r8 = 1073741824(0x40000000, float:2.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
                super.onMeasure(r8, r9)
            L_0x0018:
                android.content.res.Resources r0 = r7.getResources()
                int r1 = com.androidadvance.topsnackbar.R.dimen.design_snackbar_padding_vertical_2lines
                int r0 = r0.getDimensionPixelSize(r1)
                android.content.res.Resources r1 = r7.getResources()
                int r2 = com.androidadvance.topsnackbar.R.dimen.design_snackbar_padding_vertical
                int r1 = r1.getDimensionPixelSize(r2)
                android.widget.TextView r2 = r7.a
                android.text.Layout r2 = r2.getLayout()
                int r2 = r2.getLineCount()
                r3 = 0
                r4 = 1
                if (r2 <= r4) goto L_0x003c
                r2 = 1
                goto L_0x003d
            L_0x003c:
                r2 = 0
            L_0x003d:
                if (r2 == 0) goto L_0x0056
                int r5 = r7.d
                if (r5 <= 0) goto L_0x0056
                android.widget.Button r5 = r7.b
                int r5 = r5.getMeasuredWidth()
                int r6 = r7.d
                if (r5 <= r6) goto L_0x0056
                int r1 = r0 - r1
                boolean r0 = r7.a(r4, r0, r1)
                if (r0 == 0) goto L_0x0061
                goto L_0x0060
            L_0x0056:
                if (r2 == 0) goto L_0x0059
                goto L_0x005a
            L_0x0059:
                r0 = r1
            L_0x005a:
                boolean r0 = r7.a(r3, r0, r0)
                if (r0 == 0) goto L_0x0061
            L_0x0060:
                r3 = 1
            L_0x0061:
                if (r3 == 0) goto L_0x0066
                super.onMeasure(r8, r9)
            L_0x0066:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.androidadvance.topsnackbar.TSnackbar.SnackbarLayout.onMeasure(int, int):void");
        }

        public void setOnAttachStateChangeListener(a aVar) {
            this.f = aVar;
        }

        public void setOnLayoutChangeListener(b bVar) {
            this.e = bVar;
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            int i = R.styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(i, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(R.layout.tsnackbar_layout_include, this);
            ViewCompat.setAccessibilityLiveRegion(this, 1);
        }
    }

    public static class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            boolean z = false;
            if (i == 0) {
                TSnackbar tSnackbar = (TSnackbar) message.obj;
                if (tSnackbar.c.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = tSnackbar.c.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        e eVar = new e();
                        eVar.setStartAlphaSwipeDistance(0.1f);
                        eVar.setEndAlphaSwipeDistance(0.6f);
                        eVar.setSwipeDirection(0);
                        eVar.setListener(new a2.c.a.b(tSnackbar));
                        ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(eVar);
                    }
                    tSnackbar.a.addView(tSnackbar.c);
                }
                tSnackbar.c.setOnAttachStateChangeListener(new a2.c.a.d(tSnackbar));
                if (ViewCompat.isLaidOut(tSnackbar.c)) {
                    tSnackbar.a();
                } else {
                    tSnackbar.c.setOnLayoutChangeListener(new a2.c.a.e(tSnackbar));
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                TSnackbar tSnackbar2 = (TSnackbar) message.obj;
                int i2 = message.arg1;
                if (tSnackbar2.c.getVisibility() == 0) {
                    ViewGroup.LayoutParams layoutParams2 = tSnackbar2.c.getLayoutParams();
                    if (layoutParams2 instanceof CoordinatorLayout.LayoutParams) {
                        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams2).getBehavior();
                        if ((behavior instanceof SwipeDismissBehavior) && ((SwipeDismissBehavior) behavior).getDragState() != 0) {
                            z = true;
                        }
                    }
                    if (!z) {
                        ViewCompat.animate(tSnackbar2.c).translationY((float) (-tSnackbar2.c.getHeight())).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250).setListener(new f(tSnackbar2, i2)).start();
                        return true;
                    }
                }
                tSnackbar2.d(i2);
                return true;
            }
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public b(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.onClick(view);
            TSnackbar tSnackbar = TSnackbar.this;
            int i = TSnackbar.LENGTH_INDEFINITE;
            tSnackbar.b(1);
        }
    }

    public class c implements a.b {
        public c() {
        }

        @Override // a2.c.a.a.b
        public void a(int i) {
            Handler handler = TSnackbar.g;
            handler.sendMessage(handler.obtainMessage(1, i, 0, TSnackbar.this));
        }

        @Override // a2.c.a.a.b
        public void show() {
            Handler handler = TSnackbar.g;
            handler.sendMessage(handler.obtainMessage(0, TSnackbar.this));
        }
    }

    public class d extends ViewPropertyAnimatorListenerAdapter {
        public d() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            TSnackbar tSnackbar = TSnackbar.this;
            Callback callback = tSnackbar.e;
            if (callback != null) {
                callback.onShown(tSnackbar);
            }
            a2.c.a.a.c().f(TSnackbar.this.f);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            SnackbarLayout snackbarLayout = TSnackbar.this.c;
            ViewCompat.setAlpha(snackbarLayout.a, 0.0f);
            long j = (long) 180;
            long j2 = (long) 70;
            ViewCompat.animate(snackbarLayout.a).alpha(1.0f).setDuration(j).setStartDelay(j2).start();
            if (snackbarLayout.b.getVisibility() == 0) {
                ViewCompat.setAlpha(snackbarLayout.b, 0.0f);
                ViewCompat.animate(snackbarLayout.b).alpha(1.0f).setDuration(j).setStartDelay(j2).start();
            }
        }
    }

    public final class e extends SwipeDismissBehavior<SnackbarLayout> {
        public e() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarLayout;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            SnackbarLayout snackbarLayout = (SnackbarLayout) view;
            if (coordinatorLayout.isPointInChildBounds(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    a2.c.a.a.c().b(TSnackbar.this.f);
                } else if (actionMasked == 1 || actionMasked == 3) {
                    a2.c.a.a.c().g(TSnackbar.this.f);
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, snackbarLayout, motionEvent);
        }
    }

    public TSnackbar(ViewGroup viewGroup) {
        this.a = viewGroup;
        Context context = viewGroup.getContext();
        this.b = context;
        this.c = (SnackbarLayout) LayoutInflater.from(context).inflate(R.layout.tsnackbar_layout, viewGroup, false);
    }

    @NonNull
    public static TSnackbar make(@NonNull View view, @NonNull CharSequence charSequence, int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (!(view instanceof CoordinatorLayout)) {
                if (view instanceof FrameLayout) {
                    if (view.getId() == 16908290) {
                        viewGroup = (ViewGroup) view;
                        break;
                    }
                    viewGroup2 = (ViewGroup) view;
                }
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                        continue;
                    } else {
                        view = null;
                        continue;
                    }
                }
                if (view == null) {
                    viewGroup = viewGroup2;
                    break;
                }
            } else {
                viewGroup = (ViewGroup) view;
                break;
            }
        }
        TSnackbar tSnackbar = new TSnackbar(viewGroup);
        tSnackbar.setText(charSequence);
        tSnackbar.setDuration(i);
        return tSnackbar;
    }

    public final void a() {
        SnackbarLayout snackbarLayout = this.c;
        ViewCompat.setTranslationY(snackbarLayout, (float) (-snackbarLayout.getHeight()));
        ViewCompat.animate(this.c).translationY(0.0f).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250).setListener(new d()).start();
    }

    @Deprecated
    public TSnackbar addIcon(int i, int i2) {
        this.c.getMessageView().setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(Bitmap.createScaledBitmap(((BitmapDrawable) this.b.getResources().getDrawable(i)).getBitmap(), i2, i2, true)), (Drawable) null, (Drawable) null, (Drawable) null);
        return this;
    }

    public final void b(int i) {
        a2.c.a.a c2 = a2.c.a.a.c();
        a.b bVar = this.f;
        synchronized (c2.a) {
            if (c2.d(bVar)) {
                c2.a(c2.c, i);
            } else if (c2.e(bVar)) {
                c2.a(c2.d, i);
            }
        }
    }

    public final Drawable c(Drawable drawable, int i) {
        boolean z;
        Bitmap bitmap;
        if (!(drawable.getIntrinsicWidth() == i && drawable.getIntrinsicHeight() == i) && ((z = drawable instanceof BitmapDrawable))) {
            Resources resources = this.b.getResources();
            if (z) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else if (drawable instanceof VectorDrawable) {
                VectorDrawable vectorDrawable = (VectorDrawable) drawable;
                Bitmap createBitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                vectorDrawable.draw(canvas);
                bitmap = createBitmap;
            } else {
                throw new IllegalArgumentException("unsupported drawable type");
            }
            drawable = new BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, i, i, true));
        }
        drawable.setBounds(0, 0, i, i);
        return drawable;
    }

    public final void d(int i) {
        a2.c.a.a c2 = a2.c.a.a.c();
        a.b bVar = this.f;
        synchronized (c2.a) {
            if (c2.d(bVar)) {
                c2.c = null;
                if (c2.d != null) {
                    c2.i();
                }
            }
        }
        Callback callback = this.e;
        if (callback != null) {
            callback.onDismissed(this, i);
        }
        ViewParent parent = this.c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.c);
        }
    }

    public void dismiss() {
        b(3);
    }

    public int getDuration() {
        return this.d;
    }

    @NonNull
    public View getView() {
        return this.c;
    }

    public boolean isShown() {
        boolean d2;
        a2.c.a.a c2 = a2.c.a.a.c();
        a.b bVar = this.f;
        synchronized (c2.a) {
            d2 = c2.d(bVar);
        }
        return d2;
    }

    public boolean isShownOrQueued() {
        boolean z;
        a2.c.a.a c2 = a2.c.a.a.c();
        a.b bVar = this.f;
        synchronized (c2.a) {
            if (!c2.d(bVar)) {
                if (!c2.e(bVar)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @NonNull
    public TSnackbar setAction(@StringRes int i, View.OnClickListener onClickListener) {
        return setAction(this.b.getText(i), onClickListener);
    }

    @NonNull
    public TSnackbar setActionTextColor(ColorStateList colorStateList) {
        this.c.getActionView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    public TSnackbar setCallback(Callback callback) {
        this.e = callback;
        return this;
    }

    @NonNull
    public TSnackbar setDuration(int i) {
        this.d = i;
        return this;
    }

    public TSnackbar setIconLeft(@DrawableRes int i, float f2) {
        TextView messageView = this.c.getMessageView();
        Drawable drawable = ContextCompat.getDrawable(this.b, i);
        if (drawable != null) {
            Drawable c2 = c(drawable, (int) ((((float) this.b.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f2));
            Drawable[] compoundDrawables = messageView.getCompoundDrawables();
            messageView.setCompoundDrawables(c2, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            return this;
        }
        throw new IllegalArgumentException("resource_id is not a valid drawable!");
    }

    public TSnackbar setIconPadding(int i) {
        this.c.getMessageView().setCompoundDrawablePadding(i);
        return this;
    }

    public TSnackbar setIconRight(@DrawableRes int i, float f2) {
        TextView messageView = this.c.getMessageView();
        Drawable drawable = ContextCompat.getDrawable(this.b, i);
        if (drawable != null) {
            Drawable c2 = c(drawable, (int) ((((float) this.b.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f2));
            Drawable[] compoundDrawables = messageView.getCompoundDrawables();
            messageView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], c2, compoundDrawables[3]);
            return this;
        }
        throw new IllegalArgumentException("resource_id is not a valid drawable!");
    }

    public TSnackbar setMaxWidth(int i) {
        this.c.c = i;
        return this;
    }

    @NonNull
    public TSnackbar setText(@NonNull CharSequence charSequence) {
        this.c.getMessageView().setText(charSequence);
        return this;
    }

    public void show() {
        a2.c.a.a c2 = a2.c.a.a.c();
        int i = this.d;
        a.b bVar = this.f;
        synchronized (c2.a) {
            if (c2.d(bVar)) {
                a.c cVar = c2.c;
                cVar.b = i;
                c2.b.removeCallbacksAndMessages(cVar);
                c2.h(c2.c);
                return;
            }
            if (c2.e(bVar)) {
                c2.d.b = i;
            } else {
                c2.d = new a.c(i, bVar);
            }
            a.c cVar2 = c2.c;
            if (cVar2 == null || !c2.a(cVar2, 4)) {
                c2.c = null;
                c2.i();
            }
        }
    }

    @NonNull
    public TSnackbar setAction(CharSequence charSequence, View.OnClickListener onClickListener) {
        Button actionView = this.c.getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new b(onClickListener));
        }
        return this;
    }

    @NonNull
    public TSnackbar setActionTextColor(@ColorInt int i) {
        this.c.getActionView().setTextColor(i);
        return this;
    }

    @NonNull
    public TSnackbar setText(@StringRes int i) {
        return setText(this.b.getText(i));
    }

    @NonNull
    public static TSnackbar make(@NonNull View view, @StringRes int i, int i2) {
        return make(view, view.getResources().getText(i), i2);
    }
}
