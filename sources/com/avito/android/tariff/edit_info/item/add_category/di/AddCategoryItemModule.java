package com.avito.android.tariff.edit_info.item.add_category.di;

import com.avito.android.di.PerFragment;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemBlueprint;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemPresenter;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/add_category/di/AddCategoryItemModule;", "", "Lcom/avito/android/tariff/edit_info/item/add_category/AddCategoryItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/tariff/edit_info/item/add_category/AddCategoryItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/edit_info/item/add_category/AddCategoryItemPresenterImpl;", "presenter", "Lcom/avito/android/tariff/edit_info/item/add_category/AddCategoryItemPresenter;", "bindAddCategoryPresenterImpl", "(Lcom/avito/android/tariff/edit_info/item/add_category/AddCategoryItemPresenterImpl;)Lcom/avito/android/tariff/edit_info/item/add_category/AddCategoryItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "bindAddCategoryPresenter", "(Lcom/avito/android/tariff/edit_info/item/add_category/AddCategoryItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AddCategoryItemModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemPresenter<?, ?> bindAddCategoryPresenter(@NotNull AddCategoryItemPresenter addCategoryItemPresenter);

    @PerFragment
    @Binds
    @NotNull
    AddCategoryItemPresenter bindAddCategoryPresenterImpl(@NotNull AddCategoryItemPresenterImpl addCategoryItemPresenterImpl);

    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindBlueprint(@NotNull AddCategoryItemBlueprint addCategoryItemBlueprint);
}
