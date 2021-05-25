package com.avito.android.recycler.responsive;

import androidx.exifinterface.media.ExifInterface;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a2\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0003H\b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/konveyor/blueprint/ItemView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenterRegistry;", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "itemPresenter", "", "register", "(Lcom/avito/android/recycler/responsive/ResponsiveItemPresenterRegistry;Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;)V", "recycler_release"}, k = 2, mv = {1, 4, 2})
public final class ResponsiveItemPresenterRegistryKt {
    public static final /* synthetic */ <V extends ItemView> void register(ResponsiveItemPresenterRegistry responsiveItemPresenterRegistry, ResponsiveItemPresenter<? super V, ?> responsiveItemPresenter) {
        Intrinsics.checkNotNullParameter(responsiveItemPresenterRegistry, "$this$register");
        Intrinsics.checkNotNullParameter(responsiveItemPresenter, "itemPresenter");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        responsiveItemPresenterRegistry.register(ItemView.class, responsiveItemPresenter);
    }
}
