package com.google.android.material.transition.platform;

import a2.j.b.d.v.l.k;
import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@RequiresApi(21)
public final class MaterialSharedAxis extends k<VisibilityAnimatorProvider> {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public final int d;
    public final boolean e;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Axis {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialSharedAxis(int r3, boolean r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0027
            r0 = 1
            if (r3 == r0) goto L_0x001a
            r0 = 2
            if (r3 != r0) goto L_0x000e
            com.google.android.material.transition.platform.ScaleProvider r0 = new com.google.android.material.transition.platform.ScaleProvider
            r0.<init>(r4)
            goto L_0x0035
        L_0x000e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Invalid axis: "
            java.lang.String r3 = a2.b.a.a.a.M2(r0, r3)
            r4.<init>(r3)
            throw r4
        L_0x001a:
            com.google.android.material.transition.platform.SlideDistanceProvider r0 = new com.google.android.material.transition.platform.SlideDistanceProvider
            if (r4 == 0) goto L_0x0021
            r1 = 80
            goto L_0x0023
        L_0x0021:
            r1 = 48
        L_0x0023:
            r0.<init>(r1)
            goto L_0x0035
        L_0x0027:
            com.google.android.material.transition.platform.SlideDistanceProvider r0 = new com.google.android.material.transition.platform.SlideDistanceProvider
            if (r4 == 0) goto L_0x002f
            r1 = 8388613(0x800005, float:1.175495E-38)
            goto L_0x0032
        L_0x002f:
            r1 = 8388611(0x800003, float:1.1754948E-38)
        L_0x0032:
            r0.<init>(r1)
        L_0x0035:
            com.google.android.material.transition.platform.FadeThroughProvider r1 = new com.google.android.material.transition.platform.FadeThroughProvider
            r1.<init>()
            r2.<init>(r0, r1)
            r2.d = r3
            r2.e = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.platform.MaterialSharedAxis.<init>(int, boolean):void");
    }

    @Override // a2.j.b.d.v.l.k
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // a2.j.b.d.v.l.k
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.d;
    }

    @Override // a2.j.b.d.v.l.k
    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // a2.j.b.d.v.l.k
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.e;
    }

    @Override // a2.j.b.d.v.l.k, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // a2.j.b.d.v.l.k, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // a2.j.b.d.v.l.k
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // a2.j.b.d.v.l.k
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }
}
