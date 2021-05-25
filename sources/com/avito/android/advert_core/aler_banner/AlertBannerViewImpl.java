package com.avito.android.advert_core.aler_banner;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.aler_banner.AlertBannerView;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.remote.model.BannerType;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_core/aler_banner/AlertBannerViewImpl;", "Lcom/avito/android/advert_core/aler_banner/AlertBannerView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "text", "setText", "Lcom/avito/android/remote/model/BannerType;", "alertType", "setType", "(Lcom/avito/android/remote/model/BannerType;)V", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "s", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "banner", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AlertBannerViewImpl extends BaseViewHolder implements AlertBannerView {
    public final AlertBanner s;
    public final View t;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BannerType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            BannerType bannerType = BannerType.ALERT_TYPE_HAS_PROBLEM;
            iArr[0] = 1;
            BannerType bannerType2 = BannerType.ALERT_TYPE_NO_SALES;
            iArr[1] = 2;
            BannerType bannerType3 = BannerType.ALERT_TYPE_HIGH_TRAFFIC;
            iArr[2] = 3;
            BannerType bannerType4 = BannerType.ALERT_TYPE_HOUSEHOLDS;
            iArr[3] = 4;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertBannerViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        View findViewById = view.findViewById(R.id.dc_alert_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.dc_alert_banner)");
        this.s = (AlertBanner) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AlertBannerView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert_core.aler_banner.AlertBannerView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.getContent().setBody(str);
    }

    @Override // com.avito.android.advert_core.aler_banner.AlertBannerView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.getContent().setTitle(str);
    }

    @Override // com.avito.android.advert_core.aler_banner.AlertBannerView
    public void setType(@NotNull BannerType bannerType) {
        Intrinsics.checkNotNullParameter(bannerType, "alertType");
        int ordinal = bannerType.ordinal();
        if (ordinal == 0) {
            View view = this.t;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view.setBackgroundTintList(Contexts.getColorStateListByAttr(context, com.avito.android.lib.design.R.attr.red100));
            this.s.getContent().setImageDrawable(ContextCompat.getDrawable(this.t.getContext(), R.drawable.alert_banner_status_error));
            AlertBannerContent content = this.s.getContent();
            Context context2 = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            content.setImageTint(Contexts.getColorStateListByAttr(context2, com.avito.android.lib.design.R.attr.red));
        } else if (ordinal == 1) {
            View view2 = this.t;
            Context context3 = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            view2.setBackgroundTintList(Contexts.getColorStateListByAttr(context3, com.avito.android.lib.design.R.attr.orange50));
            AlertBannerContent content2 = this.s.getContent();
            Context context4 = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "view.context");
            content2.setImageDrawable(Contexts.getDrawableByAttr(context4, com.avito.android.lib.design.R.attr.ic_time24));
            AlertBannerContent content3 = this.s.getContent();
            Context context5 = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "view.context");
            content3.setImageTint(Contexts.getColorStateListByAttr(context5, com.avito.android.lib.design.R.attr.orange));
        } else if (ordinal == 2) {
            View view3 = this.t;
            Context context6 = view3.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "view.context");
            view3.setBackgroundTintList(Contexts.getColorStateListByAttr(context6, com.avito.android.lib.design.R.attr.green50));
            this.s.getContent().setImageDrawable(ContextCompat.getDrawable(this.t.getContext(), R.drawable.alert_banner_high_traffic));
            AlertBannerContent content4 = this.s.getContent();
            Context context7 = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "view.context");
            content4.setImageTint(Contexts.getColorStateListByAttr(context7, com.avito.android.lib.design.R.attr.green700));
        } else if (ordinal == 3) {
            View view4 = this.t;
            Context context8 = view4.getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "view.context");
            view4.setBackgroundTintList(Contexts.getColorStateListByAttr(context8, com.avito.android.lib.design.R.attr.green50));
            this.s.getContent().setImageDrawable(ContextCompat.getDrawable(this.t.getContext(), R.drawable.alert_banner_households));
            AlertBannerContent content5 = this.s.getContent();
            Context context9 = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context9, "view.context");
            content5.setImageTint(Contexts.getColorStateListByAttr(context9, com.avito.android.lib.design.R.attr.green700));
        }
    }
}
