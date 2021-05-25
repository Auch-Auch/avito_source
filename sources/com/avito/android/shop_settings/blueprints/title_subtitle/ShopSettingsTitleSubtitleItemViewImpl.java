package com.avito.android.shop_settings.blueprints.title_subtitle;

import android.view.View;
import android.widget.TextView;
import com.avito.android.service_subscription.R;
import com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItemView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemViewImpl;", "Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setSubtitle", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "subtitleView", "s", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsTitleSubtitleItemViewImpl extends BaseViewHolder implements ShopSettingsTitleSubtitleItemView {
    public final TextView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopSettingsTitleSubtitleItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.shop_settings_title_subtitle_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.shop_settings_title_subtitle_subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ShopSettingsTitleSubtitleItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItemView
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText(this.t, str, true);
    }

    @Override // com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }
}
