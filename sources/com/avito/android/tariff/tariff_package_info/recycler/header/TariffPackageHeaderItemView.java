package com.avito.android.tariff.tariff_package_info.recycler.header;

import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "barTitle", "setBarTitle", "", "progress", "setBarProgress", "(F)V", "Lcom/avito/android/paid_services/routing/ProgressState;", "status", "setProgressState", "(Lcom/avito/android/paid_services/routing/ProgressState;)V", "barDescription", "setBarDescription", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "tariffCountStatus", "setBarDescriptionStatus", "(Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffPackageHeaderItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TariffPackageHeaderItemView tariffPackageHeaderItemView) {
            ItemView.DefaultImpls.onUnbind(tariffPackageHeaderItemView);
        }
    }

    void setBarDescription(@Nullable String str);

    void setBarDescriptionStatus(@NotNull TariffCountStatus tariffCountStatus);

    void setBarProgress(float f);

    void setBarTitle(@NotNull String str);

    void setProgressState(@NotNull ProgressState progressState);

    void setTitle(@Nullable String str);
}
