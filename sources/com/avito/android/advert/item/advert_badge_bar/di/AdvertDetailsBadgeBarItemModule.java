package com.avito.android.advert.item.advert_badge_bar.di;

import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.advert_badge_bar.AdvertBadgeBarBlueprint;
import com.avito.android.advert_core.advert_badge_bar.di.AdvertDetailsBadgeBarModule;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/advert_badge_bar/di/AdvertDetailsBadgeBarItemModule;", "", "Lcom/avito/android/advert/item/advert_badge_bar/AdvertBadgeBarBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindAdvertBadgeBarBlueprint", "(Lcom/avito/android/advert/item/advert_badge_bar/AdvertBadgeBarBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdvertDetailsBadgeBarModule.class})
public interface AdvertDetailsBadgeBarItemModule {
    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindAdvertBadgeBarBlueprint(@NotNull AdvertBadgeBarBlueprint advertBadgeBarBlueprint);
}
