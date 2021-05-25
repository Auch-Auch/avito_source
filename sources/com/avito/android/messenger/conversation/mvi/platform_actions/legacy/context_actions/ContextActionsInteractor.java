package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractor;", "", "", "methodName", "Lcom/avito/android/remote/model/RawJson;", "params", "Lio/reactivex/Single;", "callApiMethod", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;)Lio/reactivex/Single;", ChannelContext.Item.USER_ID, "channelId", "reactionText", "Lio/reactivex/Completable;", "sendReactionAndDeleteContextActions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ContextActionsInteractor {
    @NotNull
    Single<RawJson> callApiMethod(@NotNull String str, @Nullable RawJson rawJson);

    @NotNull
    Completable sendReactionAndDeleteContextActions(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
