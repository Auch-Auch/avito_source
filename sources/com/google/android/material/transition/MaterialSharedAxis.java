package com.google.android.material.transition;

import a2.j.b.d.v.h;
import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.TransitionValues;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class MaterialSharedAxis extends h<VisibilityAnimatorProvider> {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public final int O;
    public final boolean P;

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
            com.google.android.material.transition.ScaleProvider r0 = new com.google.android.material.transition.ScaleProvider
            r0.<init>(r4)
            goto L_0x0035
        L_0x000e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Invalid axis: "
            java.lang.String r3 = a2.b.a.a.a.M2(r0, r3)
            r4.<init>(r3)
            throw r4
        L_0x001a:
            com.google.android.material.transition.SlideDistanceProvider r0 = new com.google.android.material.transition.SlideDistanceProvider
            if (r4 == 0) goto L_0x0021
            r1 = 80
            goto L_0x0023
        L_0x0021:
            r1 = 48
        L_0x0023:
            r0.<init>(r1)
            goto L_0x0035
        L_0x0027:
            com.google.android.material.transition.SlideDistanceProvider r0 = new com.google.android.material.transition.SlideDistanceProvider
            if (r4 == 0) goto L_0x002f
            r1 = 8388613(0x800005, float:1.175495E-38)
            goto L_0x0032
        L_0x002f:
            r1 = 8388611(0x800003, float:1.1754948E-38)
        L_0x0032:
            r0.<init>(r1)
        L_0x0035:
            com.google.android.material.transition.FadeThroughProvider r1 = new com.google.android.material.transition.FadeThroughProvider
            r1.<init>()
            r2.<init>(r0, r1)
            r2.O = r3
            r2.P = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.MaterialSharedAxis.<init>(int, boolean):void");
    }

    @Override // a2.j.b.d.v.h
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // a2.j.b.d.v.h
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.O;
    }

    @Override // a2.j.b.d.v.h
    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // a2.j.b.d.v.h
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.P;
    }

    @Override // a2.j.b.d.v.h, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // a2.j.b.d.v.h, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // a2.j.b.d.v.h
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // a2.j.b.d.v.h
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }
}
