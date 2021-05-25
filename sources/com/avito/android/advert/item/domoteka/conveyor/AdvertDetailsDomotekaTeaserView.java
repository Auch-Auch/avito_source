package com.avito.android.advert.item.domoteka.conveyor;

import android.view.View;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.remote.model.teaser.ReportLink;
import com.avito.android.remote.model.teaser.TeaserError;
import com.avito.android.remote.model.teaser.TeaserInsight;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001bH\u0001¢\u0006\u0004\b \u0010\u001eR\u001e\u0010&\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "", "hide", "()V", "onUnbind", "showDialog", "", "show", "showDivider", "(Z)V", "Lcom/avito/android/remote/model/teaser/TeaserError;", "error", "showError", "(Lcom/avito/android/remote/model/teaser/TeaserError;)V", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "insights", "showInsights", "(Ljava/util/List;)V", "showLoading", "Lcom/avito/android/remote/model/teaser/ReportLink;", "reportLink", "showReportLink", "(Lcom/avito/android/remote/model/teaser/ReportLink;)V", "showResult", "", "subTitle", "showSubtitle", "(Ljava/lang/String;)V", "title", "showTitle", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDomotekaTeaserView extends BaseViewHolder implements AdvertDetailsTeaserView {
    public final /* synthetic */ AdvertDetailsDomotekaTeaserViewImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsDomotekaTeaserView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new AdvertDetailsDomotekaTeaserViewImpl(view, null);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    @Nullable
    public AdvertDetailsTeaserView.Listener getListener() {
        return this.s.getListener();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void hide() {
        this.s.hide();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.onUnbind();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void setListener(@Nullable AdvertDetailsTeaserView.Listener listener) {
        this.s.setListener(listener);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showDialog() {
        this.s.showDialog();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showDivider(boolean z) {
        this.s.showDivider(z);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showError(@NotNull TeaserError teaserError) {
        Intrinsics.checkNotNullParameter(teaserError, "error");
        this.s.showError(teaserError);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showInsights(@NotNull List<TeaserInsight> list) {
        Intrinsics.checkNotNullParameter(list, "insights");
        this.s.showInsights(list);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showLoading() {
        this.s.showLoading();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showReportLink(@NotNull ReportLink reportLink) {
        Intrinsics.checkNotNullParameter(reportLink, "reportLink");
        this.s.showReportLink(reportLink);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showResult() {
        this.s.showResult();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subTitle");
        this.s.showSubtitle(str);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.showTitle(str);
    }
}
