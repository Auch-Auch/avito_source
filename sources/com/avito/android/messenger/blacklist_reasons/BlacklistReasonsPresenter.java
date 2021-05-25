package com.avito.android.messenger.blacklist_reasons;

import androidx.lifecycle.LiveData;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\u0005R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "", "loadBlacklistReasons", "()V", "", ChannelContext.Item.USER_ID, "channelId", "itemId", "", "reasonId", "blockUserWithReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "retry", "Landroidx/lifecycle/LiveData;", "getUserBlockedStream", "()Landroidx/lifecycle/LiveData;", "userBlockedStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BlacklistReasonsPresenter extends MviEntity<BlacklistReasonsView.State> {
    void blockUserWithReason(@NotNull String str, @NotNull String str2, @Nullable String str3, long j);

    @NotNull
    LiveData<Unit> getUserBlockedStream();

    void loadBlacklistReasons();

    void retry();
}
