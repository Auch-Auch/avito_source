package com.sumsub.sns.camera;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/sumsub/sns/core/common/ExtensionsKt$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSCameraActivity$onCreate$$inlined$observe$6<T> implements Observer<T> {
    public final /* synthetic */ SNSCameraActivity a;

    public SNSCameraActivity$onCreate$$inlined$observe$6(SNSCameraActivity sNSCameraActivity) {
        this.a = sNSCameraActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            TextView helperBrief = this.a.getHelperBrief();
            Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(helperBrief, new Runnable(helperBrief, this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observe$6$lambda$1
                public final /* synthetic */ View a;
                public final /* synthetic */ SNSCameraActivity$onCreate$$inlined$observe$6 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int height = this.b.a.getHelperBrief().getHeight() + (this.b.a.getHelper().getHeight() - this.b.a.getHelperDetails().getHeight());
                    int height2 = (this.b.a.getRootView().getHeight() - this.b.a.getTakePicture().getBottom()) - this.b.a.getResources().getDimensionPixelSize(R.dimen.sns_margin_medium);
                    BottomSheetBehavior from = BottomSheetBehavior.from(this.b.a.getHelper());
                    Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from(getHelper())");
                    from.setPeekHeight(Math.min(height, height2));
                }
            }), "OneShotPreDrawListener.add(this) { action(this) }");
            this.a.getHelperBrief().setText(t);
        }
    }
}
