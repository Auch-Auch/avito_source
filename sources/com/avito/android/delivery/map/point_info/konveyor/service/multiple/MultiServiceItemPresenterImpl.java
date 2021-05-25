package com.avito.android.delivery.map.point_info.konveyor.service.multiple;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemPresenterImpl;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemPresenter;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemView;", "view", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemView;Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "selectConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class MultiServiceItemPresenterImpl implements MultiServiceItemPresenter {
    public final Consumer<String> a;

    public MultiServiceItemPresenterImpl(@NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "selectConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull MultiServiceItemView multiServiceItemView, @NotNull MultiServiceItem multiServiceItem, int i) {
        Intrinsics.checkNotNullParameter(multiServiceItemView, "view");
        Intrinsics.checkNotNullParameter(multiServiceItem, "item");
        multiServiceItemView.setTitle(multiServiceItem.getTitle());
        multiServiceItemView.setLabel(multiServiceItem.getLabel());
        multiServiceItemView.setSubtitles(multiServiceItem.getSubtitles());
        multiServiceItemView.setSelected(multiServiceItem.getSelected());
        multiServiceItemView.setClickConsumer(multiServiceItem.getStringId(), this.a);
    }
}
