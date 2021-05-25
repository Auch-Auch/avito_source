package com.avito.android.auto_catalog.items.specs_selector.di;

import com.avito.android.advert_core.specifications.SpecificationsConverter;
import com.avito.android.advert_core.specifications.SpecificationsConverterImpl;
import com.avito.android.auto_catalog.di.AutoCatalogModule;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorBlueprint;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorPresenter;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/auto_catalog/items/specs_selector/di/SpecsSelectorModule;", "", "Lcom/avito/android/advert_core/specifications/SpecificationsConverterImpl;", "converter", "Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "bindsSpecificationsConverter", "(Lcom/avito/android/advert_core/specifications/SpecificationsConverterImpl;)Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorPresenterImpl;", "presenter", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorPresenter;", "bindSpecsSelector", "(Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorPresenterImpl;)Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorPresenter;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindSpecsSelectorBlueprint", "(Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SpecsSelectorModule {
    @PerFragment
    @Binds
    @NotNull
    SpecsSelectorPresenter bindSpecsSelector(@NotNull SpecsSelectorPresenterImpl specsSelectorPresenterImpl);

    @AutoCatalogModule.AutoCatalogBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindSpecsSelectorBlueprint(@NotNull SpecsSelectorBlueprint specsSelectorBlueprint);

    @PerFragment
    @Binds
    @NotNull
    SpecificationsConverter bindsSpecificationsConverter(@NotNull SpecificationsConverterImpl specificationsConverterImpl);
}
