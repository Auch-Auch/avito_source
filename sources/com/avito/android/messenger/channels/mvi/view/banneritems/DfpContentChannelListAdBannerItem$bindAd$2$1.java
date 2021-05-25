package com.avito.android.messenger.channels.mvi.view.banneritems;

import com.avito.android.messenger.channels.mvi.view.banneritems.DfpContentChannelListAdBannerItem;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/avito/android/messenger/channels/mvi/view/banneritems/DfpContentChannelListAdBannerItem$bindAd$2$1", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", VKApiConst.POSITION, "", "onAdBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "", "itemId", "onItemClose", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DfpContentChannelListAdBannerItem$bindAd$2$1 implements AdBannerEventListener {
    public final /* synthetic */ DfpContentChannelListAdBannerItem.b a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public DfpContentChannelListAdBannerItem$bindAd$2$1(DfpContentChannelListAdBannerItem.b bVar) {
        this.a = bVar;
    }

    @Override // com.avito.android.serp.adapter.AdBannerEventListener
    public void onAdBannerOpened(@NotNull BannerInfo bannerInfo, int i) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.a.a.onAdOpened(i);
    }

    @Override // com.avito.android.serp.adapter.OnCloseItemListener
    public void onItemClose(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.a.a.onAdClosed();
    }
}
