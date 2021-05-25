package com.avito.android.tariff.edit_info.item.edit_package.di;

import com.avito.android.di.PerFragment;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemBlueprint;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemPresenter;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemPresenterImpl;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemBlueprint;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemPresenter;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\b\u001a\u00020\u0013H'¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/edit_package/di/EditPackageItemModule;", "", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemPresenterImpl;", "presenter", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemPresenter;", "bindEditPackagePresenterImpl", "(Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemPresenterImpl;)Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "bindEditPackagePresenter", "(Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemBlueprint;", "bindMicroCategoryBlueprint", "(Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenterImpl;", "Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenter;", "bindMicroCategoryPresenterImpl", "(Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenterImpl;)Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenter;", "bindMicroCategoryPresenter", "(Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface EditPackageItemModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindBlueprint(@NotNull EditPackageItemBlueprint editPackageItemBlueprint);

    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemPresenter<?, ?> bindEditPackagePresenter(@NotNull EditPackageItemPresenter editPackageItemPresenter);

    @PerFragment
    @Binds
    @NotNull
    EditPackageItemPresenter bindEditPackagePresenterImpl(@NotNull EditPackageItemPresenterImpl editPackageItemPresenterImpl);

    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindMicroCategoryBlueprint(@NotNull MicroCategoryItemBlueprint microCategoryItemBlueprint);

    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemPresenter<?, ?> bindMicroCategoryPresenter(@NotNull MicroCategoryItemPresenter microCategoryItemPresenter);

    @PerFragment
    @Binds
    @NotNull
    MicroCategoryItemPresenter bindMicroCategoryPresenterImpl(@NotNull MicroCategoryItemPresenterImpl microCategoryItemPresenterImpl);
}
