package com.avito.android.di.module;

import com.avito.android.serp.adapter.advert_xl.AdvertXlDimensionsProvider;
import com.avito.android.serp.adapter.advert_xl.AdvertXlDimensionsProviderImpl;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemBlueprint;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemPresenter;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemPresenterImpl;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemView;
import com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/di/module/AdvertXlItemModule;", "", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemView;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "bindAdvertXlItemBlueprint", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemPresenterImpl;", "presenter", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemPresenter;", "bindAdvertXlItemPresenter", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemPresenterImpl;)Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemPresenter;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "bindAdvertXlStateProvider", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemPresenter;)Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProvider;", "bindAdvertXlDimensionsProvider", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProviderImpl;)Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProvider;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DateTimeFormatterModule.class})
public interface AdvertXlItemModule {
    @Reusable
    @Binds
    @NotNull
    AdvertXlDimensionsProvider bindAdvertXlDimensionsProvider(@NotNull AdvertXlDimensionsProviderImpl advertXlDimensionsProviderImpl);

    @Reusable
    @Binds
    @NotNull
    ItemBlueprint<AdvertXlItemView, AdvertXlItem> bindAdvertXlItemBlueprint(@NotNull AdvertXlItemBlueprint advertXlItemBlueprint);

    @Reusable
    @Binds
    @NotNull
    AdvertXlItemPresenter bindAdvertXlItemPresenter(@NotNull AdvertXlItemPresenterImpl advertXlItemPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    AdvertXlStateProvider bindAdvertXlStateProvider(@NotNull AdvertXlItemPresenter advertXlItemPresenter);
}
