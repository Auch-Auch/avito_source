package com.avito.android.auto_catalog.items.serp.di;

import com.avito.android.auto_catalog.di.AutoCatalogModule;
import com.avito.android.auto_catalog.items.serp.SerpButtonBlueprint;
import com.avito.android.auto_catalog.items.serp.SerpButtonPresenter;
import com.avito.android.auto_catalog.items.serp.SerpButtonPresenterImpl;
import com.avito.android.auto_catalog.items.serp.SerpHeaderBlueprint;
import com.avito.android.auto_catalog.items.serp.SerpHeaderPresenter;
import com.avito.android.auto_catalog.items.serp.SerpHeaderPresenterImpl;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonBlueprint;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonPresenter;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonPresenterImpl;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryHeaderBlueprint;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryHeaderPresenter;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryHeaderPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0017H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u001eH'¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/auto_catalog/items/serp/di/SerpModule;", "", "Lcom/avito/android/auto_catalog/items/serp/SerpHeaderPresenterImpl;", "presenter", "Lcom/avito/android/auto_catalog/items/serp/SerpHeaderPresenter;", "bindSerpHeaderPresenter", "(Lcom/avito/android/auto_catalog/items/serp/SerpHeaderPresenterImpl;)Lcom/avito/android/auto_catalog/items/serp/SerpHeaderPresenter;", "Lcom/avito/android/auto_catalog/items/serp/SerpHeaderBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindSerpHeaderBlueprint", "(Lcom/avito/android/auto_catalog/items/serp/SerpHeaderBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/auto_catalog/items/serp/SerpButtonPresenterImpl;", "Lcom/avito/android/auto_catalog/items/serp/SerpButtonPresenter;", "bindSerpButtonPresenter", "(Lcom/avito/android/auto_catalog/items/serp/SerpButtonPresenterImpl;)Lcom/avito/android/auto_catalog/items/serp/SerpButtonPresenter;", "Lcom/avito/android/auto_catalog/items/serp/SerpButtonBlueprint;", "bindSerpButtonrBlueprint", "(Lcom/avito/android/auto_catalog/items/serp/SerpButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonPresenterImpl;", "Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonPresenter;", "bindSerpSecondaryButtonPresenter", "(Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonPresenterImpl;)Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonPresenter;", "Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonBlueprint;", "bindSerpSecondaryButtonBlueprint", "(Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryHeaderPresenterImpl;", "Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryHeaderPresenter;", "bindSerpSecondaryHeaderPresenter", "(Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryHeaderPresenterImpl;)Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryHeaderPresenter;", "Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryHeaderBlueprint;", "bindSerpSecondaryHeaderBlueprint", "(Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryHeaderBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SerpModule {
    @PerFragment
    @Binds
    @NotNull
    SerpButtonPresenter bindSerpButtonPresenter(@NotNull SerpButtonPresenterImpl serpButtonPresenterImpl);

    @AutoCatalogModule.AutoCatalogBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindSerpButtonrBlueprint(@NotNull SerpButtonBlueprint serpButtonBlueprint);

    @AutoCatalogModule.AutoCatalogBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindSerpHeaderBlueprint(@NotNull SerpHeaderBlueprint serpHeaderBlueprint);

    @PerFragment
    @Binds
    @NotNull
    SerpHeaderPresenter bindSerpHeaderPresenter(@NotNull SerpHeaderPresenterImpl serpHeaderPresenterImpl);

    @AutoCatalogModule.AutoCatalogBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindSerpSecondaryButtonBlueprint(@NotNull SerpSecondaryButtonBlueprint serpSecondaryButtonBlueprint);

    @PerFragment
    @Binds
    @NotNull
    SerpSecondaryButtonPresenter bindSerpSecondaryButtonPresenter(@NotNull SerpSecondaryButtonPresenterImpl serpSecondaryButtonPresenterImpl);

    @AutoCatalogModule.AutoCatalogBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindSerpSecondaryHeaderBlueprint(@NotNull SerpSecondaryHeaderBlueprint serpSecondaryHeaderBlueprint);

    @PerFragment
    @Binds
    @NotNull
    SerpSecondaryHeaderPresenter bindSerpSecondaryHeaderPresenter(@NotNull SerpSecondaryHeaderPresenterImpl serpSecondaryHeaderPresenterImpl);
}
