package ru.avito.component.appbar.floating_toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\"\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010!\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0019\u0010!\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015¨\u0006%"}, d2 = {"Lru/avito/component/appbar/floating_toolbar/FloatingToolbarImpl;", "Lru/avito/component/appbar/floating_toolbar/FloatingToolbar;", "", "showToolbar", "()V", "adjustToolbarVisibility", "", "scrollY", "offsetY", "onContentScroll", "(II)V", "", "isVisible", AuthSource.SEND_ABUSE, "(Z)V", "verticalOffset", "c", "(I)V", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "d", "Landroid/view/View;", "getToolbar", "()Landroid/view/View;", "toolbar", "f", "Z", "isConcealableShadow", "()Z", "I", "scrollingOffset", "e", "getShadow", "shadow", "toolbarContainer", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FloatingToolbarImpl implements FloatingToolbar {
    public int a;
    public int b;
    public final View c;
    @NotNull
    public final View d;
    @NotNull
    public final View e;
    public final boolean f;

    public FloatingToolbarImpl(@NotNull View view, @NotNull View view2, @NotNull View view3, boolean z) {
        Intrinsics.checkNotNullParameter(view, "toolbarContainer");
        Intrinsics.checkNotNullParameter(view2, "toolbar");
        Intrinsics.checkNotNullParameter(view3, "shadow");
        this.c = view;
        this.d = view2;
        this.e = view3;
        this.f = z;
    }

    public static final void access$toggleToolbarShadow(FloatingToolbarImpl floatingToolbarImpl, boolean z) {
        View view = floatingToolbarImpl.e;
        if (z) {
            Views.show(view);
        } else {
            Views.conceal(view);
        }
    }

    public final void a(boolean z) {
        View view = this.e;
        if (z) {
            Views.show(view);
        } else {
            Views.conceal(view);
        }
    }

    @Override // ru.avito.component.appbar.floating_toolbar.FloatingToolbar
    public void adjustToolbarVisibility() {
        int i = this.b;
        if (i > 0) {
            if (this.a > this.d.getHeight()) {
                b();
            } else {
                c(this.a);
            }
        } else if (i >= 0) {
        } else {
            if (((double) this.c.getTranslationY()) >= ((double) this.d.getHeight()) * -0.6d || this.a <= this.d.getHeight()) {
                c(this.a);
            } else {
                b();
            }
        }
    }

    public final void b() {
        this.c.animate().translationY((float) (-this.d.getHeight())).setInterpolator(new LinearInterpolator()).setDuration(180).setListener(new AnimatorListenerAdapter(this) { // from class: ru.avito.component.appbar.floating_toolbar.FloatingToolbarImpl$toolbarAnimateHide$1
            public final /* synthetic */ FloatingToolbarImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                FloatingToolbarImpl.access$toggleToolbarShadow(this.a, false);
            }
        });
    }

    public final void c(int i) {
        this.c.animate().translationY(0.0f).setInterpolator(new LinearInterpolator()).setDuration(180).setListener(new AnimatorListenerAdapter(this, i) { // from class: ru.avito.component.appbar.floating_toolbar.FloatingToolbarImpl$toolbarAnimateShow$1
            public final /* synthetic */ FloatingToolbarImpl a;
            public final /* synthetic */ int b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                FloatingToolbarImpl floatingToolbarImpl = this.a;
                FloatingToolbarImpl.access$toggleToolbarShadow(floatingToolbarImpl, this.b != 0 || !floatingToolbarImpl.isConcealableShadow());
            }
        });
    }

    @NotNull
    public final View getShadow() {
        return this.e;
    }

    @NotNull
    public final View getToolbar() {
        return this.d;
    }

    public final boolean isConcealableShadow() {
        return this.f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (r0 != false) goto L_0x006b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // ru.avito.component.appbar.floating_toolbar.FloatingToolbar
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onContentScroll(int r4, int r5) {
        /*
            r3 = this;
            r3.a = r5
            r3.b = r4
            float r4 = (float) r4
            android.view.View r5 = r3.c
            float r5 = r5.getTranslationY()
            float r4 = r4 - r5
            int r4 = (int) r4
            android.view.View r5 = r3.c
            android.view.ViewPropertyAnimator r5 = r5.animate()
            r5.cancel()
            int r5 = r3.b
            r0 = 0
            r1 = 1
            if (r5 <= 0) goto L_0x004b
            android.view.View r5 = r3.d
            int r5 = r5.getHeight()
            if (r4 >= r5) goto L_0x0039
            int r5 = r3.a
            android.view.View r2 = r3.d
            int r2 = r2.getHeight()
            if (r5 <= r2) goto L_0x0031
            r3.a(r1)
        L_0x0031:
            int r5 = r3.a
            if (r5 != 0) goto L_0x0036
            r0 = 1
        L_0x0036:
            if (r0 == 0) goto L_0x0068
            goto L_0x006b
        L_0x0039:
            r3.a(r0)
            int r4 = r3.a
            if (r4 != 0) goto L_0x0041
            r0 = 1
        L_0x0041:
            if (r0 == 0) goto L_0x0044
            goto L_0x006b
        L_0x0044:
            android.view.View r4 = r3.d
            int r4 = r4.getHeight()
            goto L_0x0068
        L_0x004b:
            if (r5 >= 0) goto L_0x006b
            if (r4 >= 0) goto L_0x005b
            int r4 = r3.a
            if (r4 > 0) goto L_0x006b
            boolean r4 = r3.f
            if (r4 == 0) goto L_0x006b
            r3.a(r0)
            goto L_0x006b
        L_0x005b:
            int r5 = r3.a
            android.view.View r0 = r3.d
            int r0 = r0.getHeight()
            if (r5 <= r0) goto L_0x0068
            r3.a(r1)
        L_0x0068:
            int r4 = -r4
            float r4 = (float) r4
            goto L_0x006c
        L_0x006b:
            r4 = 0
        L_0x006c:
            int r5 = r3.b
            if (r5 == 0) goto L_0x0075
            android.view.View r5 = r3.c
            r5.setTranslationY(r4)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.component.appbar.floating_toolbar.FloatingToolbarImpl.onContentScroll(int, int):void");
    }

    @Override // ru.avito.component.appbar.floating_toolbar.FloatingToolbar
    public void showToolbar() {
        if (!(this.c.getTranslationY() == 0.0f)) {
            a(true);
            this.c.setTranslationY(0.0f);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatingToolbarImpl(View view, View view2, View view3, boolean z, int i, j jVar) {
        this(view, view2, view3, (i & 8) != 0 ? true : z);
    }
}
