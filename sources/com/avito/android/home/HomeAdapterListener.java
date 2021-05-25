package com.avito.android.home;

import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdvertItemListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/home/HomeAdapterListener;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface HomeAdapterListener extends AdvertItemListener, AdBannerEventListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull HomeAdapterListener homeAdapterListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            AdvertItemListener.DefaultImpls.onMoreActionsClicked(homeAdapterListener, str);
        }
    }
}
