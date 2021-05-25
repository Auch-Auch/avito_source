package com.avito.android.advert.item.delivery;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.advert_core.di.module.AdvertDeliveryBlockDataObservable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u000e\b\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\"\u0010#J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenterImpl;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenter;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoView;", "view", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoView;Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoItem;I)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "setFragmentDelegate", "(Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDeliveryBlockListener", "(Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;)V", "detachListener", "()V", AuthSource.SEND_ABUSE, "Landroidx/lifecycle/LifecycleOwner;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "d", "Lcom/jakewharton/rxrelay3/PublishRelay;", "advertDeliveryBlockDataObservable", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "c", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "viewModel", "<init>", "(Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDeliveryInfoPresenterImpl implements AdvertDetailsDeliveryInfoPresenter {
    public LifecycleOwner a;
    public AdvertDeliveryBlockView.Listener b;
    public final AdvertDeliveryBlockViewModel c;
    public final PublishRelay<AdvertDeliveryC2C> d;

    @Inject
    public AdvertDetailsDeliveryInfoPresenterImpl(@NotNull AdvertDeliveryBlockViewModel advertDeliveryBlockViewModel, @AdvertDeliveryBlockDataObservable @NotNull PublishRelay<AdvertDeliveryC2C> publishRelay) {
        Intrinsics.checkNotNullParameter(advertDeliveryBlockViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(publishRelay, "advertDeliveryBlockDataObservable");
        this.c = advertDeliveryBlockViewModel;
        this.d = publishRelay;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenter
    public void detachListener() {
        this.b = null;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenter
    public void setDeliveryBlockListener(@NotNull AdvertDeliveryBlockView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = listener;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenter
    public void setFragmentDelegate(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.a = lifecycleOwner;
    }

    public void bindView(@NotNull AdvertDetailsDeliveryInfoView advertDetailsDeliveryInfoView, @NotNull AdvertDetailsDeliveryInfoItem advertDetailsDeliveryInfoItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsDeliveryInfoView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsDeliveryInfoItem, "item");
        AdvertDeliveryBlockView.Listener listener = this.b;
        if (listener != null) {
            AdvertDeliveryC2C delivery = advertDetailsDeliveryInfoItem.getDelivery();
            AdvertDeliveryBlockViewModel advertDeliveryBlockViewModel = this.c;
            PublishRelay<AdvertDeliveryC2C> publishRelay = this.d;
            LifecycleOwner lifecycleOwner = this.a;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            }
            advertDetailsDeliveryInfoView.showDeliveryBlock(delivery, advertDeliveryBlockViewModel, publishRelay, lifecycleOwner, listener);
        }
    }
}
