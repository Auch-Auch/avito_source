package com.avito.android.advert.item.delivery.di;

import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsBlueprint;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsItem;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsPresenter;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsPresenterImpl;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsView;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoBlueprint;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoItem;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenter;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenterImpl;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoView;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\b\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert/item/delivery/di/AdvertDetailsDeliveryModule;", "", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsPresenter;", "bindAdvertDetailsDeliveryActionsPresenter", "(Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsPresenterImpl;)Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsPresenter;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsItem;", "bindAdvertDetailsDeliveryActionsBlueprint", "(Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenterImpl;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenter;", "bindAdvertDetailsDeliveryInfoPresenter", "(Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenterImpl;)Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenter;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoBlueprint;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoView;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoItem;", "bindAdvertDetailsDeliveryInfoBlueprint", "(Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertDetailsDeliveryModule {
    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<AdvertDetailsDeliveryActionsView, AdvertDetailsDeliveryActionsItem> bindAdvertDetailsDeliveryActionsBlueprint(@NotNull AdvertDetailsDeliveryActionsBlueprint advertDetailsDeliveryActionsBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsDeliveryActionsPresenter bindAdvertDetailsDeliveryActionsPresenter(@NotNull AdvertDetailsDeliveryActionsPresenterImpl advertDetailsDeliveryActionsPresenterImpl);

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<AdvertDetailsDeliveryInfoView, AdvertDetailsDeliveryInfoItem> bindAdvertDetailsDeliveryInfoBlueprint(@NotNull AdvertDetailsDeliveryInfoBlueprint advertDetailsDeliveryInfoBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsDeliveryInfoPresenter bindAdvertDetailsDeliveryInfoPresenter(@NotNull AdvertDetailsDeliveryInfoPresenterImpl advertDetailsDeliveryInfoPresenterImpl);
}
