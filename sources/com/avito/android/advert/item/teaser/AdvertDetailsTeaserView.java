package com.avito.android.advert.item.teaser;

import com.avito.android.remote.model.teaser.ReportLink;
import com.avito.android.remote.model.teaser.TeaserError;
import com.avito.android.remote.model.teaser.TeaserInsight;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\u0017J\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\u0017R\u001e\u0010$\u001a\u0004\u0018\u00010\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "show", "", "showDivider", "(Z)V", "", "title", "showTitle", "(Ljava/lang/String;)V", "subTitle", "showSubtitle", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "insights", "showInsights", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/teaser/ReportLink;", "reportLink", "showReportLink", "(Lcom/avito/android/remote/model/teaser/ReportLink;)V", "showResult", "()V", "showLoading", "Lcom/avito/android/remote/model/teaser/TeaserError;", "error", "showError", "(Lcom/avito/android/remote/model/teaser/TeaserError;)V", "showDialog", "hide", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsTeaserView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsTeaserView advertDetailsTeaserView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsTeaserView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "", "", "onClickGetReport", "()V", "onClickDialogButton", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static void onClickDialogButton(@NotNull Listener listener) {
            }
        }

        void onClickDialogButton();

        void onClickGetReport();
    }

    @Nullable
    Listener getListener();

    void hide();

    void setListener(@Nullable Listener listener);

    void showDialog();

    void showDivider(boolean z);

    void showError(@NotNull TeaserError teaserError);

    void showInsights(@NotNull List<TeaserInsight> list);

    void showLoading();

    void showReportLink(@NotNull ReportLink reportLink);

    void showResult();

    void showSubtitle(@NotNull String str);

    void showTitle(@NotNull String str);
}
