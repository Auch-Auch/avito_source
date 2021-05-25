package com.avito.android.messenger.conversation.mvi.menu;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView;
import com.avito.android.remote.model.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR.\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000e0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "", "showChannelMenu", "()V", "openProfile", "Landroidx/lifecycle/LiveData;", "getChannelDeletedStream", "()Landroidx/lifecycle/LiveData;", "channelDeletedStream", "", "getCallUserConfirmedStream", "callUserConfirmedStream", "Lkotlin/Pair;", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "", "Lcom/avito/android/remote/model/Action;", "getAbuseReportStream", "abuseReportStream", "getUserBlockedStream", "userBlockedStream", "getErrorMessageStream", "errorMessageStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelMenuPresenter extends MviEntity<ChannelMenuView.State> {
    @NotNull
    LiveData<Pair<AbuseReportLink, List<Action>>> getAbuseReportStream();

    @NotNull
    LiveData<String> getCallUserConfirmedStream();

    @NotNull
    LiveData<Unit> getChannelDeletedStream();

    @NotNull
    LiveData<String> getErrorMessageStream();

    @NotNull
    LiveData<Unit> getUserBlockedStream();

    void openProfile();

    void showChannelMenu();
}
