package com.avito.android.shop_settings.blueprints.moderation_error;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItemPresenterImpl;", "Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItemPresenter;", "Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItemView;", "view", "Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItemView;Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItem;I)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsModerationErrorItemPresenterImpl implements ShopSettingsModerationErrorItemPresenter {
    public final AttributedTextFormatter a;

    @Inject
    public ShopSettingsModerationErrorItemPresenterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = attributedTextFormatter;
    }

    public void bindView(@NotNull ShopSettingsModerationErrorItemView shopSettingsModerationErrorItemView, @NotNull ShopSettingsModerationErrorItem shopSettingsModerationErrorItem, int i) {
        Intrinsics.checkNotNullParameter(shopSettingsModerationErrorItemView, "view");
        Intrinsics.checkNotNullParameter(shopSettingsModerationErrorItem, "item");
        shopSettingsModerationErrorItemView.setTitle(shopSettingsModerationErrorItem.getTitle());
        shopSettingsModerationErrorItemView.setSubtitle(this.a.format(shopSettingsModerationErrorItem.getSubtitle()));
    }
}
