package com.avito.android.safedeal.delivery_type.items.subtitle.di;

import com.avito.android.di.PerFragment;
import com.avito.android.safedeal.delivery_type.di.DeliveryTypeModule;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitleBlueprint;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitlePresenter;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitlePresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/items/subtitle/di/SubTitleModule;", "", "Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitlePresenterImpl;", "presenter", "Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitlePresenter;", "bindSubTitlePresenter", "(Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitlePresenterImpl;)Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitlePresenter;", "Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitleBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindSubTitleBlueprint", "(Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitleBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SubTitleModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    @DeliveryTypeModule.DeliveryTypeBlueprints
    ItemBlueprint<?, ?> bindSubTitleBlueprint(@NotNull SubTitleBlueprint subTitleBlueprint);

    @PerFragment
    @Binds
    @NotNull
    SubTitlePresenter bindSubTitlePresenter(@NotNull SubTitlePresenterImpl subTitlePresenterImpl);
}
