package com.avito.android.advert.item.cre_geo_report;

import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.remote.model.Action;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserView;", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "", "Lcom/avito/android/remote/model/Action;", "actions", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showButtons", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsGeoReportTeaserView extends AdvertDetailsTeaserView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsGeoReportTeaserView advertDetailsGeoReportTeaserView) {
            AdvertDetailsTeaserView.DefaultImpls.onUnbind(advertDetailsGeoReportTeaserView);
        }
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    @Nullable
    AdvertDetailsTeaserView.Listener getListener();

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    void setListener(@Nullable AdvertDetailsTeaserView.Listener listener);

    void showButtons(@NotNull List<Action> list, @NotNull Function1<? super Action, Unit> function1);
}
