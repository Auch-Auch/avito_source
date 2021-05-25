package com.avito.android.advert_stats.item.disclaimer;

import android.net.Uri;
import android.view.View;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerItemView;
import com.avito.android.analytics.R;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.serp.BaseSerpViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItemViewImpl;", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lkotlin/Function1;", "Landroid/net/Uri;", "", "handler", "setDetailsLink", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseButtonListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "s", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "container", "Lcom/avito/android/lib/design/alert_banner/AlertBannerContent;", "t", "Lcom/avito/android/lib/design/alert_banner/AlertBannerContent;", "content", "<init>", "(Landroid/view/View;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class NewStatisticsBannerItemViewImpl extends BaseSerpViewHolder implements NewStatisticsBannerItemView {
    public final AlertBanner s;
    public final AlertBannerContent t;
    public final View u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ NewStatisticsBannerItemViewImpl a;
        public final /* synthetic */ Function1 b;

        public b(NewStatisticsBannerItemViewImpl newStatisticsBannerItemViewImpl, Function1 function1) {
            this.a = newStatisticsBannerItemViewImpl;
            this.b = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.b;
            Uri parse = Uri.parse(this.a.u.getResources().getString(R.string.new_statistics_info_link));
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(view.resources…ew_statistics_info_link))");
            function1.invoke(parse);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewStatisticsBannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        View findViewById = view.findViewById(com.avito.android.advert_stats.R.id.new_statistics_banner_item);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.alert_banner.AlertBanner");
        AlertBanner alertBanner = (AlertBanner) findViewById;
        this.s = alertBanner;
        this.t = alertBanner.getContent();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        NewStatisticsBannerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerItemView
    public void setCloseButtonListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setCloseButtonListener(new a(function0));
    }

    @Override // com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerItemView
    public void setDetailsLink(@NotNull Function1<? super Uri, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "handler");
        AlertBannerContent.setLink$default(this.t, null, new b(this, function1), 1, null);
    }
}
