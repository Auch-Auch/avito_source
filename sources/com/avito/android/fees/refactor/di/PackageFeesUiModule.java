package com.avito.android.fees.refactor.di;

import com.avito.android.di.PerFragment;
import com.avito.android.fees.refactor.item.PackageFeeBlueprint;
import com.avito.android.fees.refactor.item.PackageItem;
import com.avito.android.fees.refactor.item.PackageItemPresenter;
import com.avito.android.fees.refactor.item.PackageItemView;
import com.avito.android.fees.refactor.item.header.HeaderItem;
import com.avito.android.fees.refactor.item.header.HeaderItemBlueprint;
import com.avito.android.fees.refactor.item.header.HeaderItemPresenter;
import com.avito.android.fees.refactor.item.header.HeaderItemView;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\b\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/fees/refactor/di/PackageFeesUiModule;", "", "Lcom/avito/android/fees/refactor/item/PackageFeeBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "providePackageItemBlueprint", "(Lcom/avito/android/fees/refactor/item/PackageFeeBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/fees/refactor/item/PackageItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/fees/refactor/item/PackageItemView;", "Lcom/avito/android/fees/refactor/item/PackageItem;", "providePackageItemPresenter", "(Lcom/avito/android/fees/refactor/item/PackageItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/fees/refactor/item/header/HeaderItemBlueprint;", "provideHeaderItemBlueprint", "(Lcom/avito/android/fees/refactor/item/header/HeaderItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/fees/refactor/item/header/HeaderItemPresenter;", "Lcom/avito/android/fees/refactor/item/header/HeaderItemView;", "Lcom/avito/android/fees/refactor/item/header/HeaderItem;", "provideHeaderItemPresenter", "(Lcom/avito/android/fees/refactor/item/header/HeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "fees_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class})
public interface PackageFeesUiModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> provideHeaderItemBlueprint(@NotNull HeaderItemBlueprint headerItemBlueprint);

    @Binds
    @NotNull
    @PerFragment
    ItemPresenter<HeaderItemView, HeaderItem> provideHeaderItemPresenter(@NotNull HeaderItemPresenter headerItemPresenter);

    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> providePackageItemBlueprint(@NotNull PackageFeeBlueprint packageFeeBlueprint);

    @Binds
    @NotNull
    @PerFragment
    ItemPresenter<PackageItemView, PackageItem> providePackageItemPresenter(@NotNull PackageItemPresenter packageItemPresenter);
}
