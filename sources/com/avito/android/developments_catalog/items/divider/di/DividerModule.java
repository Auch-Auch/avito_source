package com.avito.android.developments_catalog.items.divider.di;

import com.avito.android.developments_catalog.di.DevelopmentsCatalogBlueprints;
import com.avito.android.developments_catalog.items.divider.DividerBlueprint;
import com.avito.android.developments_catalog.items.divider.DividerPresenter;
import com.avito.android.developments_catalog.items.divider.DividerPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/developments_catalog/items/divider/di/DividerModule;", "", "Lcom/avito/android/developments_catalog/items/divider/DividerPresenterImpl;", "presenter", "Lcom/avito/android/developments_catalog/items/divider/DividerPresenter;", "bindDividerPresenter", "(Lcom/avito/android/developments_catalog/items/divider/DividerPresenterImpl;)Lcom/avito/android/developments_catalog/items/divider/DividerPresenter;", "Lcom/avito/android/developments_catalog/items/divider/DividerBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindDividerBlueprint", "(Lcom/avito/android/developments_catalog/items/divider/DividerBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface DividerModule {
    @Binds
    @IntoSet
    @NotNull
    @DevelopmentsCatalogBlueprints
    @PerFragment
    ItemBlueprint<?, ?> bindDividerBlueprint(@NotNull DividerBlueprint dividerBlueprint);

    @PerFragment
    @Binds
    @NotNull
    DividerPresenter bindDividerPresenter(@NotNull DividerPresenterImpl dividerPresenterImpl);
}
