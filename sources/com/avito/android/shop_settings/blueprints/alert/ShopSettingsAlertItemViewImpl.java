package com.avito.android.shop_settings.blueprints.alert;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.model.Color;
import com.avito.android.service_subscription.R;
import com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItem;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.internal.AnalyticsEvents;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setSubtitle", "Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setStyle", "(Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "s", "Landroid/view/View;", "rootView", "u", "subtitleView", VKApiConst.VERSION, "view", "<init>", "(Landroid/view/View;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsAlertItemViewImpl extends BaseViewHolder implements ShopSettingsAlertItemView {
    public final View s;
    public final TextView t;
    public final TextView u;
    public final View v;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ShopSettingsAlertItem.Style.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            ShopSettingsAlertItem.Style style = ShopSettingsAlertItem.Style.Confirmation;
            iArr[2] = 1;
            ShopSettingsAlertItem.Style style2 = ShopSettingsAlertItem.Style.Alert;
            iArr[0] = 2;
            ShopSettingsAlertItem.Style style3 = ShopSettingsAlertItem.Style.Message;
            iArr[1] = 3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopSettingsAlertItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        View findViewById = view.findViewById(R.id.shop_settings_alert);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById;
        View findViewById2 = view.findViewById(R.id.shop_settings_alert_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.shop_settings_alert_subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
    }

    @Override // com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItemView
    public void setStyle(@NotNull ShopSettingsAlertItem.Style style) {
        int i;
        Intrinsics.checkNotNullParameter(style, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        Context context = this.v.getContext();
        int ordinal = style.ordinal();
        if (ordinal == 0) {
            i = com.avito.android.lib.design.R.attr.red50;
        } else if (ordinal == 1) {
            i = com.avito.android.lib.design.R.attr.green50;
        } else if (ordinal == 2) {
            i = com.avito.android.lib.design.R.attr.oldBackground;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        View view = this.s;
        int i2 = R.drawable.bg_subscription_banner;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int value = new Color(Contexts.getColorByAttr(context, i)).getValue();
        view.setBackground(ContextCompat.getDrawable(view.getContext(), i2));
        view.setBackgroundTintList(ColorStateList.valueOf(value));
    }

    @Override // com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItemView
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText(this.u, str, true);
    }

    @Override // com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText(this.t, str, true);
    }
}
