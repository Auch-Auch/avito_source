package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItemPresenterImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItemPresenter;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItemView;", "view", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItemView;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "changeConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SingleCourierServiceItemPresenterImpl implements SingleCourierServiceItemPresenter {
    public final Consumer<BaseCourierServiceItem> a;

    public SingleCourierServiceItemPresenterImpl(@NotNull Consumer<BaseCourierServiceItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "changeConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull SingleCourierServiceItemView singleCourierServiceItemView, @NotNull SingleCourierServiceItem singleCourierServiceItem, int i) {
        Intrinsics.checkNotNullParameter(singleCourierServiceItemView, "view");
        Intrinsics.checkNotNullParameter(singleCourierServiceItem, "item");
        singleCourierServiceItemView.setTitle(singleCourierServiceItem.getTitle());
        singleCourierServiceItemView.setSubtitle(singleCourierServiceItem.getSubtitle());
        this.a.accept(singleCourierServiceItem);
    }
}
