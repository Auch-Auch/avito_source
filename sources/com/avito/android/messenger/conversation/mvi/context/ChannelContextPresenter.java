package com.avito.android.messenger.conversation.mvi.context;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import com.avito.android.remote.model.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR.\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000e0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\tR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "Lcom/avito/android/messenger/conversation/mvi/context/OpenAdvertHandler;", "", "openDealActionOrAdvert", "()V", "Landroidx/lifecycle/LiveData;", "getUserBlockedStream", "()Landroidx/lifecycle/LiveData;", "userBlockedStream", "", "getCallUserConfirmedStream", "callUserConfirmedStream", "Lkotlin/Pair;", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "", "Lcom/avito/android/remote/model/Action;", "getAbuseReportStream", "abuseReportStream", "getCloseScreenStream", "closeScreenStream", "getErrorMessageStream", "errorMessageStream", "getChannelDeletedStream", "channelDeletedStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelContextPresenter extends MviEntity<ChannelContextView.State>, OpenAdvertHandler {
    @NotNull
    LiveData<Pair<AbuseReportLink, List<Action>>> getAbuseReportStream();

    @NotNull
    LiveData<String> getCallUserConfirmedStream();

    @NotNull
    LiveData<Unit> getChannelDeletedStream();

    @NotNull
    LiveData<Unit> getCloseScreenStream();

    @NotNull
    LiveData<String> getErrorMessageStream();

    @NotNull
    LiveData<Unit> getUserBlockedStream();

    void openDealActionOrAdvert();
}
