package com.avito.android.photo_picker.legacy;

import android.content.Context;
import android.view.OrientationEventListener;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/photo_picker/legacy/DeviceOrientationProviderImpl$listener$1", "Landroid/view/OrientationEventListener;", "", "orientation", "", "onOrientationChanged", "(I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class DeviceOrientationProviderImpl$listener$1 extends OrientationEventListener {
    public final /* synthetic */ DeviceOrientationProviderImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceOrientationProviderImpl$listener$1(DeviceOrientationProviderImpl deviceOrientationProviderImpl, Context context, Context context2) {
        super(context2);
        this.a = deviceOrientationProviderImpl;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        DeviceOrientationProviderImpl.access$getOrientationStream$p(this.a).accept(Integer.valueOf(i));
    }
}
