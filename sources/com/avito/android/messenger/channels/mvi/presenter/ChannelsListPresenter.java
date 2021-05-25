package com.avito.android.messenger.channels.mvi.presenter;

import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import com.avito.android.serp.ad.BannerInfo;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0005H&¢\u0006\u0004\b\u0013\u0010\tJ\u001f\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "", "isRetry", "", "initialDataRequest", "(Z)V", "attach", "()V", "detach", "refresh", "refreshNotificationBannerState", "loadNextPage", "", "channelId", "deleteChannel", "(Ljava/lang/String;)V", "tryToUpdateAdBanner", "hideAdBanner", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", VKApiConst.POSITION, "onAdBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "Landroidx/lifecycle/LiveData;", "getChannelDeletedStream", "()Landroidx/lifecycle/LiveData;", "channelDeletedStream", "getErrorMessageStream", "errorMessageStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsListPresenter extends MviEntity<ChannelsListState> {
    void attach();

    void deleteChannel(@NotNull String str);

    void detach();

    @NotNull
    LiveData<Unit> getChannelDeletedStream();

    @NotNull
    LiveData<String> getErrorMessageStream();

    void hideAdBanner();

    void initialDataRequest(boolean z);

    void loadNextPage();

    void onAdBannerOpened(@NotNull BannerInfo bannerInfo, int i);

    void refresh();

    void refreshNotificationBannerState();

    void tryToUpdateAdBanner();
}
