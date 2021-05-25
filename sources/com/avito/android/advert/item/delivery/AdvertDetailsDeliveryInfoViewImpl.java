package com.avito.android.advert.item.delivery;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J?\u0010\u000e\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoView;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "deliveryData", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "viewModel", "Lcom/jakewharton/rxrelay3/PublishRelay;", "advertDeliveryBlockDataObservable", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDeliveryBlock", "(Lcom/avito/android/remote/model/AdvertDeliveryC2C;Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;Lcom/jakewharton/rxrelay3/PublishRelay;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;)V", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView;", "s", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView;", "deliveryBlockView", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDeliveryInfoViewImpl extends BaseViewHolder implements AdvertDetailsDeliveryInfoView {
    public AdvertDeliveryBlockView s;
    public final View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsDeliveryInfoViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoView
    public void showDeliveryBlock(@Nullable AdvertDeliveryC2C advertDeliveryC2C, @NotNull AdvertDeliveryBlockViewModel advertDeliveryBlockViewModel, @NotNull PublishRelay<AdvertDeliveryC2C> publishRelay, @NotNull LifecycleOwner lifecycleOwner, @NotNull AdvertDeliveryBlockView.Listener listener) {
        Intrinsics.checkNotNullParameter(advertDeliveryBlockViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(publishRelay, "advertDeliveryBlockDataObservable");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.s == null) {
            this.s = new AdvertDeliveryBlockView(this.t, advertDeliveryBlockViewModel, lifecycleOwner, listener, true);
        }
        publishRelay.accept(advertDeliveryC2C);
    }
}
