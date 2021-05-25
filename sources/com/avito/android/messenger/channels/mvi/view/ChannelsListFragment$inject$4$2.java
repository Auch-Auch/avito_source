package com.avito.android.messenger.channels.mvi.view;

import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter;
import com.avito.android.serp.ad.BannerInfo;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", VKApiConst.POSITION, "", "invoke", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListFragment$inject$4$2 extends Lambda implements Function2<BannerInfo, Integer, Unit> {
    public final /* synthetic */ ChannelsListPresenter a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsListFragment$inject$4$2(ChannelsListPresenter channelsListPresenter) {
        super(2);
        this.a = channelsListPresenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(BannerInfo bannerInfo, Integer num) {
        invoke(bannerInfo, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BannerInfo bannerInfo, int i) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.a.onAdBannerOpened(bannerInfo, i);
    }
}
