package com.avito.android.tariff.tariff_package_info.recycler.header;

import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderItemView;", "Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderItemView;Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderItem;I)V", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageHeaderPresenter implements ItemPresenter<TariffPackageHeaderItemView, TariffPackageHeaderItem> {
    public void bindView(@NotNull TariffPackageHeaderItemView tariffPackageHeaderItemView, @NotNull TariffPackageHeaderItem tariffPackageHeaderItem, int i) {
        Intrinsics.checkNotNullParameter(tariffPackageHeaderItemView, "view");
        Intrinsics.checkNotNullParameter(tariffPackageHeaderItem, "item");
        tariffPackageHeaderItemView.setTitle(tariffPackageHeaderItem.getTitle());
        tariffPackageHeaderItemView.setBarProgress(tariffPackageHeaderItem.getBarProgress());
        tariffPackageHeaderItemView.setBarTitle(tariffPackageHeaderItem.getBarTitle());
        tariffPackageHeaderItemView.setProgressState(tariffPackageHeaderItem.getBarState());
        tariffPackageHeaderItemView.setBarDescription(tariffPackageHeaderItem.getBarDescription());
        tariffPackageHeaderItemView.setBarDescriptionStatus(tariffPackageHeaderItem.getBarDescriptionStatus());
    }
}
