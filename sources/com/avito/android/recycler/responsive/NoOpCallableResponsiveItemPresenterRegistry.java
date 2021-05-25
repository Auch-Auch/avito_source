package com.avito.android.recycler.responsive;

import androidx.exifinterface.media.ExifInterface;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/recycler/responsive/NoOpCallableResponsiveItemPresenterRegistry;", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "Lcom/avito/konveyor/blueprint/ItemView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/lang/Class;", "viewType", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "itemPresenter", "", "register", "(Ljava/lang/Class;Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;)V", "itemView", "", VKApiConst.POSITION, "onViewAttached", "(Lcom/avito/konveyor/blueprint/ItemView;I)V", "unregister", "(Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;)V", "onViewDetached", "<init>", "()V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class NoOpCallableResponsiveItemPresenterRegistry implements CallableResponsiveItemPresenterRegistry {
    @Override // com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry
    public void onViewAttached(@NotNull ItemView itemView, int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    @Override // com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry
    public void onViewDetached(@NotNull ItemView itemView, int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    @Override // com.avito.android.recycler.responsive.ResponsiveItemPresenterRegistry
    public <V extends ItemView> void register(@NotNull Class<V> cls, @NotNull ResponsiveItemPresenter<? super V, ?> responsiveItemPresenter) {
        Intrinsics.checkNotNullParameter(cls, "viewType");
        Intrinsics.checkNotNullParameter(responsiveItemPresenter, "itemPresenter");
    }

    @Override // com.avito.android.recycler.responsive.ResponsiveItemPresenterRegistry
    public void unregister(@NotNull ResponsiveItemPresenter<?, ?> responsiveItemPresenter) {
        Intrinsics.checkNotNullParameter(responsiveItemPresenter, "itemPresenter");
    }
}
