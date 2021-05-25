package com.avito.android.messenger.conversation.mvi.reply_suggests;

import androidx.lifecycle.LiveData;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tR2\u0010\u0010\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f0\u000bj\u0002`\r0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "", SocialButtonClickedEventKt.SUGGEST, "", "replySuggestClicked", "(Ljava/lang/String;)V", "closeButtonClicked", "()V", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/TextMessageAndTemplates;", "getSendMessageLiveEvents", "()Landroidx/lifecycle/LiveData;", "sendMessageLiveEvents", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelReplySuggestsPresenter extends MviEntity<ChannelReplySuggestsView.State> {
    void closeButtonClicked();

    @NotNull
    LiveData<Pair<String, List<String>>> getSendMessageLiveEvents();

    void replySuggestClicked(@NotNull String str);
}
