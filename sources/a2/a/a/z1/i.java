package a2.a.a.z1;

import a2.b.a.a.a;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.photo_wizard.WizardPhotoPickerViewImpl;
import kotlin.jvm.internal.Intrinsics;
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WizardPhotoPickerViewImpl a;
    public final /* synthetic */ ValueAnimator b;

    public i(WizardPhotoPickerViewImpl wizardPhotoPickerViewImpl, ValueAnimator valueAnimator) {
        this.a = wizardPhotoPickerViewImpl;
        this.b = valueAnimator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) a.g2(this.b, "valueAnimator", "null cannot be cast to non-null type kotlin.Int")).intValue();
        FrameLayout frameLayout = this.a.f;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "previewContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = intValue;
        FrameLayout frameLayout2 = this.a.f;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "previewContainer");
        frameLayout2.setLayoutParams(layoutParams);
    }
}
