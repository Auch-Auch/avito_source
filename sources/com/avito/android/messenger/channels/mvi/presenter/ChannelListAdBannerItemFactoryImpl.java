package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdCascadesInChannelsTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.DfpAppInstallChannelListAdBannerItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.DfpContentChannelListAdBannerItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.DfpUnifiedChannelListAdBannerItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.MyTargetAppInstallChannelListAdBannerItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.MyTargetContentChannelListAdBannerItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.YandexContentChannelListAdBannerItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBanner;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.LoadedNetworkBanner;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.DfpBanner;
import com.avito.android.serp.ad.MyTargetBanner;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.serp.ad.YandexContentBanner;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactoryImpl;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactory;", "Lcom/avito/android/remote/model/CommercialBanner;", "banner", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "create", "(Lcom/avito/android/remote/model/CommercialBanner;)Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "c", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "bgColorProvider", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdCascadesInChannelsTestGroup;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "adCascadesInChannelsTestGroup", "<init>", "(Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/serp/ad/MyTargetImageBgProvider;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelListAdBannerItemFactoryImpl implements ChannelListAdBannerItemFactory {
    public final SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> a;
    public final SchedulersFactory3 b;
    public final MyTargetImageBgProvider c;
    public final Features d;

    @Inject
    public ChannelListAdBannerItemFactoryImpl(@NotNull SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> singleManuallyExposedAbTestGroup, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MyTargetImageBgProvider myTargetImageBgProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "adCascadesInChannelsTestGroup");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(myTargetImageBgProvider, "bgColorProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = singleManuallyExposedAbTestGroup;
        this.b = schedulersFactory3;
        this.c = myTargetImageBgProvider;
        this.d = features;
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelListAdBannerItemFactory
    @Nullable
    public ChannelListAdBannerItem create(@Nullable CommercialBanner commercialBanner) {
        ChannelListAdBannerItem myTargetAppInstallChannelListAdBannerItem;
        LoadedNetworkBanner loadedNetworkBanner;
        AdNetworkBanner adNetworkBanner = (commercialBanner == null || (loadedNetworkBanner = commercialBanner.getLoadedNetworkBanner()) == null) ? null : loadedNetworkBanner.getAdNetworkBanner();
        if (adNetworkBanner == null) {
            return null;
        }
        boolean isTest = this.a.getTestGroup().isTest();
        BannerInfo from = BannerInfo.Companion.from(commercialBanner.getLoadedNetworkBannerItem(), commercialBanner);
        if (adNetworkBanner instanceof YandexContentBanner) {
            myTargetAppInstallChannelListAdBannerItem = new YandexContentChannelListAdBannerItem("YandexContentChannelListAdBannerItem", (YandexContentBanner) adNetworkBanner, from);
        } else if (!isTest) {
            return null;
        } else {
            if (adNetworkBanner instanceof DfpBanner.DfpUnifiedBanner) {
                myTargetAppInstallChannelListAdBannerItem = new DfpUnifiedChannelListAdBannerItem("DfpUnifiedChannelListAdBannerItem", (DfpBanner.DfpUnifiedBanner) adNetworkBanner, from, this.b);
            } else if (adNetworkBanner instanceof DfpBanner.DfpContentBanner) {
                myTargetAppInstallChannelListAdBannerItem = new DfpContentChannelListAdBannerItem("DfpContentChannelListAdBannerItem", (DfpBanner.DfpContentBanner) adNetworkBanner, from);
            } else if (adNetworkBanner instanceof DfpBanner.DfpAppInstallBanner) {
                myTargetAppInstallChannelListAdBannerItem = new DfpAppInstallChannelListAdBannerItem("DfpAppInstallChannelListAdBannerItem", (DfpBanner.DfpAppInstallBanner) adNetworkBanner, from);
            } else if (adNetworkBanner instanceof MyTargetBanner.MyTargetContentBanner) {
                myTargetAppInstallChannelListAdBannerItem = new MyTargetContentChannelListAdBannerItem("MyTargetContentChannelListAdBannerItem", (MyTargetBanner.MyTargetContentBanner) adNetworkBanner, from, this.c, this.d.getMyTargetMediaView().invoke().booleanValue());
            } else if (!(adNetworkBanner instanceof MyTargetBanner.MyTargetAppInstallBanner)) {
                return null;
            } else {
                myTargetAppInstallChannelListAdBannerItem = new MyTargetAppInstallChannelListAdBannerItem("MyTargetAppInstallChannelListAdBannerItem", (MyTargetBanner.MyTargetAppInstallBanner) adNetworkBanner, from, this.c, this.d.getMyTargetMediaView().invoke().booleanValue());
            }
        }
        return myTargetAppInstallChannelListAdBannerItem;
    }
}
