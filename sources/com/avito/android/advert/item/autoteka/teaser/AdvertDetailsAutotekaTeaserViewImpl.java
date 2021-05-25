package com.avito.android.advert.item.autoteka.teaser;

import android.view.View;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserView;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserViewImpl;
import com.avito.android.remote.model.AutotekaCpoTeaser;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\u0012\u0006\u00102\u001a\u00020-\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\t\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\"\u0010 J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b%\u0010&R\u001e\u0010,\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0019\u00102\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView;", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaCpoTeaserView;", "", "hide", "()V", "onUnbind", "showDialog", "", "show", "showDivider", "(Z)V", "Lcom/avito/android/remote/model/teaser/TeaserError;", "error", "showError", "(Lcom/avito/android/remote/model/teaser/TeaserError;)V", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "insights", "showInsights", "(Ljava/util/List;)V", "showLoading", "Lcom/avito/android/remote/model/teaser/ReportLink;", "reportLink", "showReportLink", "(Lcom/avito/android/remote/model/teaser/ReportLink;)V", "showResult", "", "subTitle", "showSubtitle", "(Ljava/lang/String;)V", "title", "showTitle", "Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "teaser", "bindCpoTeaserData", "(Lcom/avito/android/remote/model/AutotekaCpoTeaser;)V", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View;", "s", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView$Listener;", "autotekaListener", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutotekaTeaserViewImpl extends BaseViewHolder implements AdvertDetailsAutotekaTeaserView, AdvertDetailsTeaserView, AdvertDetailsAutotekaCpoTeaserView {
    @NotNull
    public final View s;
    public final /* synthetic */ AdvertDetailsTeaserViewImpl t;
    public final /* synthetic */ AdvertDetailsAutotekaCpoTeaserViewDelegate u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsAutotekaTeaserViewImpl(@NotNull View view, @Nullable AdvertDetailsAutotekaTeaserView.Listener listener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new AdvertDetailsTeaserViewImpl(view, listener);
        this.u = new AdvertDetailsAutotekaCpoTeaserViewDelegate(view, listener);
        this.s = view;
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaCpoTeaserView
    public void bindCpoTeaserData(@NotNull AutotekaCpoTeaser autotekaCpoTeaser) {
        Intrinsics.checkNotNullParameter(autotekaCpoTeaser, "teaser");
        this.u.bindCpoTeaserData(autotekaCpoTeaser);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    @Nullable
    public AdvertDetailsTeaserView.Listener getListener() {
        return this.t.getListener();
    }

    @NotNull
    public final View getView() {
        return this.s;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void hide() {
        this.t.hide();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.t.onUnbind();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void setListener(@Nullable AdvertDetailsTeaserView.Listener listener) {
        this.t.setListener(listener);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showDialog() {
        this.t.showDialog();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showDivider(boolean z) {
        this.t.showDivider(z);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showError(@NotNull TeaserError teaserError) {
        Intrinsics.checkNotNullParameter(teaserError, "error");
        this.t.showError(teaserError);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showInsights(@NotNull List<TeaserInsight> list) {
        Intrinsics.checkNotNullParameter(list, "insights");
        this.t.showInsights(list);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showLoading() {
        this.t.showLoading();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showReportLink(@NotNull ReportLink reportLink) {
        Intrinsics.checkNotNullParameter(reportLink, "reportLink");
        this.t.showReportLink(reportLink);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showResult() {
        this.t.showResult();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subTitle");
        this.t.showSubtitle(str);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.showTitle(str);
    }
}
