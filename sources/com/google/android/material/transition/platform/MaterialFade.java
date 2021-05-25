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
public final class MaterialFade extends k<FadeProvider> {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialFade() {
        /*
            r3 = this;
            com.google.android.material.transition.platform.FadeProvider r0 = new com.google.android.material.transition.platform.FadeProvider
            r0.<init>()
            r1 = 1050253722(0x3e99999a, float:0.3)
            r0.setIncomingEndThreshold(r1)
            com.google.android.material.transition.platform.ScaleProvider r1 = new com.google.android.material.transition.platform.ScaleProvider
            r1.<init>()
            r2 = 0
            r1.setScaleOnDisappear(r2)
            r2 = 1061997773(0x3f4ccccd, float:0.8)
            r1.setIncomingStartScale(r2)
            r3.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.platform.MaterialFade.<init>():void");
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
