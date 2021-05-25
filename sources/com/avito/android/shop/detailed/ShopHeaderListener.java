package com.avito.android.shop.detailed;

import com.avito.android.analytics.source.ShopContactsSource;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/avito/android/shop/detailed/ShopHeaderListener;", "", "", "onDescriptionCollapsed", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/analytics/source/ShopContactsSource;", "shopContactsSource", "onDeepLinkFollowed", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/source/ShopContactsSource;)V", "", "title", "description", "Lcom/avito/android/remote/model/Action;", "action", "onShowPopup", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "onContactsExpanded", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopHeaderListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onDeepLinkFollowed$default(ShopHeaderListener shopHeaderListener, DeepLink deepLink, ShopContactsSource shopContactsSource, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    shopContactsSource = ShopContactsSource.CONTACTS;
                }
                shopHeaderListener.onDeepLinkFollowed(deepLink, shopContactsSource);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDeepLinkFollowed");
        }
    }

    void onContactsExpanded();

    void onDeepLinkFollowed(@NotNull DeepLink deepLink, @NotNull ShopContactsSource shopContactsSource);

    void onDescriptionCollapsed();

    void onShowPopup(@Nullable String str, @Nullable String str2, @Nullable Action action);
}
