package com.google.android.material.transition.platform;

import a2.j.b.d.v.l.k;
import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
public final class MaterialElevationScale extends k<ScaleProvider> {
    public final boolean d;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialElevationScale(boolean r3) {
        /*
            r2 = this;
            com.google.android.material.transition.platform.ScaleProvider r0 = new com.google.android.material.transition.platform.ScaleProvider
            r0.<init>(r3)
            r1 = 1062836634(0x3f59999a, float:0.85)
            r0.setOutgoingEndScale(r1)
            r0.setIncomingStartScale(r1)
            com.google.android.material.transition.platform.FadeProvider r1 = new com.google.android.material.transition.platform.FadeProvider
            r1.<init>()
            r2.<init>(r0, r1)
            r2.d = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.platform.MaterialElevationScale.<init>(boolean):void");
    }

    @Override // a2.j.b.d.v.l.k
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // a2.j.b.d.v.l.k
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // a2.j.b.d.v.l.k
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isGrowing() {
        return this.d;
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
