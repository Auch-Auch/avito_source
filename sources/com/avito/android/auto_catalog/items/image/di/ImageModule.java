package com.avito.android.auto_catalog.items.image.di;

import com.avito.android.auto_catalog.di.AutoCatalogModule;
import com.avito.android.auto_catalog.items.image.ImageBlueprint;
import com.avito.android.auto_catalog.items.image.ImagePresenter;
import com.avito.android.auto_catalog.items.image.ImagePresenterImpl;
import com.avito.android.auto_catalog.items.image.SchemeBlueprint;
import com.avito.android.auto_catalog.items.image.SchemePresenter;
import com.avito.android.auto_catalog.items.image.SchemePresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/auto_catalog/items/image/di/ImageModule;", "", "Lcom/avito/android/auto_catalog/items/image/ImagePresenterImpl;", "presenter", "Lcom/avito/android/auto_catalog/items/image/ImagePresenter;", "bindImagePresenter", "(Lcom/avito/android/auto_catalog/items/image/ImagePresenterImpl;)Lcom/avito/android/auto_catalog/items/image/ImagePresenter;", "Lcom/avito/android/auto_catalog/items/image/ImageBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindImageBlueprint", "(Lcom/avito/android/auto_catalog/items/image/ImageBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/auto_catalog/items/image/SchemePresenterImpl;", "Lcom/avito/android/auto_catalog/items/image/SchemePresenter;", "bindShemePresenter", "(Lcom/avito/android/auto_catalog/items/image/SchemePresenterImpl;)Lcom/avito/android/auto_catalog/items/image/SchemePresenter;", "Lcom/avito/android/auto_catalog/items/image/SchemeBlueprint;", "bindSchemeeBlueprint", "(Lcom/avito/android/auto_catalog/items/image/SchemeBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface ImageModule {
    @AutoCatalogModule.AutoCatalogBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindImageBlueprint(@NotNull ImageBlueprint imageBlueprint);

    @PerFragment
    @Binds
    @NotNull
    ImagePresenter bindImagePresenter(@NotNull ImagePresenterImpl imagePresenterImpl);

    @AutoCatalogModule.AutoCatalogBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindSchemeeBlueprint(@NotNull SchemeBlueprint schemeBlueprint);

    @PerFragment
    @Binds
    @NotNull
    SchemePresenter bindShemePresenter(@NotNull SchemePresenterImpl schemePresenterImpl);
}
