package com.avito.android.serp.adapter.rich_snippets;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.GroupingListener;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "Lcom/avito/android/serp/adapter/GroupingListener;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "galleryPosition", "", "onRichAdvertXlClicked", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;ILcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "Lcom/avito/android/serp/adapter/AdvertItem;", "onRichAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "onCallActionClicked", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;)V", "onWriteActionClicked", "onDeepLinkActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertRichItemListener extends FavoriteButtonClickListener, GroupingListener {
    void onCallActionClicked(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource);

    void onDeepLinkActionClicked(@NotNull DeepLink deepLink);

    void onRichAdvertClicked(@NotNull AdvertItem advertItem, int i, @Nullable Image image, @Nullable Integer num);

    void onRichAdvertXlClicked(@NotNull AdvertXlItem advertXlItem, int i, @Nullable Image image, @Nullable Integer num);

    void onWriteActionClicked(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource);
}
