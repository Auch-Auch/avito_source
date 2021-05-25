package com.avito.android.shop_settings.blueprints.moderation_error;

import android.view.View;
import android.widget.TextView;
import com.avito.android.service_subscription.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "", "setSubtitle", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "errorTitle", "t", "errorSubtitle", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsModerationErrorItemViewImpl extends BaseViewHolder implements ShopSettingsModerationErrorItemView {
    public final TextView s;
    public final TextView t;
    public final View u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopSettingsModerationErrorItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        View findViewById = view.findViewById(R.id.shop_settings_moderation_error_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.shop_settings_moderation_error_subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.shop_settings.blueprints.moderation_error.ShopSettingsModerationErrorItemView
    public void setSubtitle(@Nullable CharSequence charSequence) {
        TextViews.bindText(this.t, charSequence, true);
    }

    @Override // com.avito.android.shop_settings.blueprints.moderation_error.ShopSettingsModerationErrorItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText(this.s, str, true);
    }
}
