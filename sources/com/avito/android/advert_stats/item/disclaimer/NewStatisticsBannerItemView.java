package com.avito.android.advert_stats.item.disclaimer;

import android.net.Uri;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function1;", "Landroid/net/Uri;", "", "handler", "setDetailsLink", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseButtonListener", "(Lkotlin/jvm/functions/Function0;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface NewStatisticsBannerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull NewStatisticsBannerItemView newStatisticsBannerItemView) {
            ItemView.DefaultImpls.onUnbind(newStatisticsBannerItemView);
        }
    }

    void setCloseButtonListener(@NotNull Function0<Unit> function0);

    void setDetailsLink(@NotNull Function1<? super Uri, Unit> function1);
}
