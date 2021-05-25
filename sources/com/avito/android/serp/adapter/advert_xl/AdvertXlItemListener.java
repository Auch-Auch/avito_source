package com.avito.android.serp.adapter.advert_xl;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemListener;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "onCallActionClicked", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;Lcom/avito/android/deep_linking/links/DeepLink;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertXlItemListener extends FavoriteButtonClickListener {
    void onAdvertClicked(@NotNull AdvertXlItem advertXlItem, int i, @Nullable Image image);

    void onCallActionClicked(@NotNull AdvertXlItem advertXlItem, @NotNull DeepLink deepLink);
}
