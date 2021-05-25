package com.avito.android.brandspace.items.carousel;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0015J5\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/CarouselItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "", VKApiConst.POSITION, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bind", "(Ljava/util/List;IILcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;)V", "", "animated", "setCurrentPosition", "(IZ)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "scheduleScrollToNextPage", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Listener", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface CarouselItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CarouselItemView carouselItemView) {
            ItemView.DefaultImpls.onUnbind(carouselItemView);
        }

        public static /* synthetic */ void setCurrentPosition$default(CarouselItemView carouselItemView, int i, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = false;
                }
                carouselItemView.setCurrentPosition(i, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCurrentPosition");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;", "", "", VKApiConst.POSITION, "", "isProgrammatic", "", "onCurrentPositionChanged", "(IZ)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onHeightChanged", "(I)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onCurrentPositionChanged(int i, boolean z);

        void onHeightChanged(int i);
    }

    void bind(@NotNull List<? extends BrandspaceItem> list, int i, int i2, @NotNull Listener listener);

    void scheduleScrollToNextPage(@NotNull SchedulersFactory3 schedulersFactory3);

    void setCurrentPosition(int i, boolean z);
}
