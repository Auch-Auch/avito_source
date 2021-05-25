package com.avito.android.serp.adapter;

import com.avito.android.advert.actions.MoreActionsClickListener;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "Lcom/avito/android/advert/actions/MoreActionsClickListener;", "Lcom/avito/android/serp/adapter/GroupingListener;", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertItemListener extends FavoriteButtonClickListener, MoreActionsClickListener, GroupingListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onAdvertClicked$default(AdvertItemListener advertItemListener, AdvertItem advertItem, int i, Image image, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    image = null;
                }
                advertItemListener.onAdvertClicked(advertItem, i, image);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAdvertClicked");
        }

        public static void onMoreActionsClicked(@NotNull AdvertItemListener advertItemListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            MoreActionsClickListener.DefaultImpls.onMoreActionsClicked(advertItemListener, str);
        }
    }

    void onAdvertClicked(@NotNull AdvertItem advertItem, int i, @Nullable Image image);
}
