package com.avito.android.advert.item.cre_geo_report;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.teaser.ReportLink;
import com.avito.android.remote.model.teaser.TeaserError;
import com.avito.android.remote.model.teaser.TeaserInsight;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0013\u0010\u0011J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001e\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\tH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006H\u0001¢\u0006\u0004\b \u0010\u0011J\u0010\u0010!\u001a\u00020\u0006H\u0001¢\u0006\u0004\b!\u0010\u0011J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\"H\u0001¢\u0006\u0004\b'\u0010%J/\u0010*\u001a\u00020\u0006*\u00020(2\u0006\u0010)\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\fH\u0002¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001e\u0010\r\u001a\u0004\u0018\u0001008\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserViewImpl;", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserView;", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/teaser/ReportLink;", "reportLink", "", "showReportLink", "(Lcom/avito/android/remote/model/teaser/ReportLink;)V", "", "Lcom/avito/android/remote/model/Action;", "actions", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showButtons", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "hide", "()V", "onUnbind", "showDialog", "", "show", "showDivider", "(Z)V", "Lcom/avito/android/remote/model/teaser/TeaserError;", "error", "showError", "(Lcom/avito/android/remote/model/teaser/TeaserError;)V", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "insights", "showInsights", "(Ljava/util/List;)V", "showLoading", "showResult", "", "subTitle", "showSubtitle", "(Ljava/lang/String;)V", "title", "showTitle", "Lcom/avito/android/lib/design/button/Button;", "action", "t", "(Lcom/avito/android/lib/design/button/Button;Lcom/avito/android/remote/model/Action;Lkotlin/jvm/functions/Function1;)V", "Landroid/widget/LinearLayout;", "s", "Landroid/widget/LinearLayout;", "buttonsContainer", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGeoReportTeaserViewImpl extends BaseViewHolder implements AdvertDetailsGeoReportTeaserView, AdvertDetailsTeaserView {
    public final LinearLayout s;
    public final /* synthetic */ a2.a.a.f.x.s.a t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Action b;

        public a(Function1 function1, Action action) {
            this.a = function1;
            this.b = action;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke(this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsGeoReportTeaserViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new a2.a.a.f.x.s.a(view);
        View findViewById = view.findViewById(R.id.buttons_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.s = linearLayout;
        linearLayout.removeAllViews();
    }

    @Override // com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserView, com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    @Nullable
    public AdvertDetailsTeaserView.Listener getListener() {
        return this.t.getListener();
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void hide() {
        this.t.hide();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.t.onUnbind();
    }

    @Override // com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserView, com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void setListener(@Nullable AdvertDetailsTeaserView.Listener listener) {
        this.t.setListener(listener);
    }

    @Override // com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserView
    public void showButtons(@NotNull List<Action> list, @NotNull Function1<? super Action, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        int min = Math.min(this.s.getChildCount(), list.size());
        for (int i = 0; i < min; i++) {
            View childAt = this.s.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
            t((Button) childAt, list.get(i), function1);
        }
        int size = list.size();
        for (int childCount = this.s.getChildCount(); childCount < size; childCount++) {
            Context context = this.s.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "buttonsContainer.context");
            Button button = new Button(context);
            this.s.addView(button);
            t(button, list.get(childCount), function1);
        }
        int childCount2 = this.s.getChildCount();
        for (int size2 = list.size(); size2 < childCount2; size2++) {
            LinearLayout linearLayout = this.s;
            linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
        }
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
        throw new UnsupportedOperationException("Use showButtons");
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

    public final void t(Button button, Action action, Function1<? super Action, Unit> function1) {
        int i;
        String type = action.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -1015263653) {
                if (hashCode == 1498103 && type.equals(AdvertDetailsGeoReportTeaserItem.TYPE_BUY)) {
                    i = com.avito.android.lib.design.R.attr.buttonPrimaryLarge;
                    button.setAppearanceFromAttr(i);
                    button.setText(action.getTitle());
                    button.setOnClickListener(new a(function1, action));
                }
            } else if (type.equals(AdvertDetailsGeoReportTeaserItem.TYPE_EXAMPLE)) {
                i = com.avito.android.lib.design.R.attr.buttonSecondaryLarge;
                button.setAppearanceFromAttr(i);
                button.setText(action.getTitle());
                button.setOnClickListener(new a(function1, action));
            }
        }
        i = com.avito.android.lib.design.R.attr.buttonPrimaryLarge;
        button.setAppearanceFromAttr(i);
        button.setText(action.getTitle());
        button.setOnClickListener(new a(function1, action));
    }
}
