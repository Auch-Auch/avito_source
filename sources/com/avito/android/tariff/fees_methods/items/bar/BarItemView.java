package com.avito.android.tariff.fees_methods.items.bar;

import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/bar/BarItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "bindSubtitle", "description", "bindDescription", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "tariffCountStatus", "setDescriptionStatus", "(Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "Lcom/avito/android/paid_services/routing/ProgressState;", "progressState", "setProgressState", "(Lcom/avito/android/paid_services/routing/ProgressState;)V", "", "progress", "setProgress", "(F)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface BarItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull BarItemView barItemView) {
            ItemView.DefaultImpls.onUnbind(barItemView);
        }
    }

    void bindDescription(@Nullable String str);

    void bindSubtitle(@Nullable String str);

    void setDescriptionStatus(@NotNull TariffCountStatus tariffCountStatus);

    void setProgress(float f);

    void setProgressState(@NotNull ProgressState progressState);

    void setTitle(@NotNull String str);
}
