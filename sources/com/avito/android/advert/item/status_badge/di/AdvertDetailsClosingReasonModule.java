package com.avito.android.advert.item.status_badge.di;

import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonBlueprint;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonItem;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonPresenter;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonPresenterImpl;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonView;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/status_badge/di/AdvertDetailsClosingReasonModule;", "", "Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonPresenter;", "bindAdvertDetailsClosingReasonPresenter", "(Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonPresenterImpl;)Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonPresenter;", "Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonView;", "Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonItem;", "bindAdvertDetailsClosingReasonBlueprint", "(Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertDetailsClosingReasonModule {
    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<AdvertDetailsClosingReasonView, AdvertDetailsClosingReasonItem> bindAdvertDetailsClosingReasonBlueprint(@NotNull AdvertDetailsClosingReasonBlueprint advertDetailsClosingReasonBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsClosingReasonPresenter bindAdvertDetailsClosingReasonPresenter(@NotNull AdvertDetailsClosingReasonPresenterImpl advertDetailsClosingReasonPresenterImpl);
}
