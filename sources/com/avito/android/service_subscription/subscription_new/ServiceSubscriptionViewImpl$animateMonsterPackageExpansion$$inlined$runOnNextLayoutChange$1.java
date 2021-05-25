package com.avito.android.service_subscription.subscription_new;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.avito.android.service_subscription.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JY\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010¸\u0006\u0000"}, d2 = {"com/avito/android/util/Views$runOnNextLayoutChange$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", VKApiConst.VERSION, "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceSubscriptionViewImpl$animateMonsterPackageExpansion$$inlined$runOnNextLayoutChange$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ServiceSubscriptionViewImpl b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;
    public final /* synthetic */ View e;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ServiceSubscriptionViewImpl$animateMonsterPackageExpansion$$inlined$runOnNextLayoutChange$1 a;

        public a(AccelerateDecelerateInterpolator accelerateDecelerateInterpolator, ServiceSubscriptionViewImpl$animateMonsterPackageExpansion$$inlined$runOnNextLayoutChange$1 serviceSubscriptionViewImpl$animateMonsterPackageExpansion$$inlined$runOnNextLayoutChange$1) {
            this.a = serviceSubscriptionViewImpl$animateMonsterPackageExpansion$$inlined$runOnNextLayoutChange$1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) a2.b.a.a.a.g2(valueAnimator, "animator", "null cannot be cast to non-null type kotlin.Float")).floatValue();
            for (View view : this.a.c) {
                view.setAlpha(floatValue);
            }
            float f = 1.0f - floatValue;
            for (View view2 : this.a.d) {
                view2.setAlpha(f);
            }
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ View b;

        public b(AccelerateDecelerateInterpolator accelerateDecelerateInterpolator, TextView textView, View view) {
            this.a = textView;
            this.b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) a2.b.a.a.a.g2(valueAnimator, "animator", "null cannot be cast to non-null type kotlin.Float")).floatValue();
            TextView textView = this.a;
            Intrinsics.checkNotNullExpressionValue(textView, "minimizedLocations");
            textView.setY(floatValue);
            View view = this.b;
            Intrinsics.checkNotNullExpressionValue(view, "expandedLocations");
            view.setY(floatValue);
        }
    }

    public ServiceSubscriptionViewImpl$animateMonsterPackageExpansion$$inlined$runOnNextLayoutChange$1(View view, ServiceSubscriptionViewImpl serviceSubscriptionViewImpl, List list, List list2, View view2) {
        this.a = view;
        this.b = serviceSubscriptionViewImpl;
        this.c = list;
        this.d = list2;
        this.e = view2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@Nullable View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "this");
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.addUpdateListener(new a(accelerateDecelerateInterpolator, this));
        View findViewById = this.e.findViewById(R.id.subscription_monster_locations_container);
        TextView textView = (TextView) this.e.findViewById(R.id.locations);
        Intrinsics.checkNotNullExpressionValue(textView, "minimizedLocations");
        Intrinsics.checkNotNullExpressionValue(findViewById, "expandedLocations");
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(textView.getY(), findViewById.getY());
        ofFloat2.setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "this");
        ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat2.addUpdateListener(new b(accelerateDecelerateInterpolator, textView, findViewById));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.excludeTarget(this.e, true);
        autoTransition.setDuration(300L);
        autoTransition.setInterpolator((TimeInterpolator) accelerateDecelerateInterpolator);
        TransitionManager.beginDelayedTransition((ViewGroup) this.b.n.findViewById(R.id.content), autoTransition);
        this.a.removeOnLayoutChangeListener(this);
    }
}
