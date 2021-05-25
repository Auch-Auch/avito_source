package com.avito.android.messenger.conversation.create;

import com.avito.android.messenger.conversation.create.CreateChannelInteractor;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "channelId", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/String;)Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class CreateChannelInteractorImpl$createChannel$1<T, R> implements Function<String, CreateChannelInteractor.Result> {
    public static final CreateChannelInteractorImpl$createChannel$1 INSTANCE = new CreateChannelInteractorImpl$createChannel$1();

    public final CreateChannelInteractor.Result apply(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        return new CreateChannelInteractor.Result.Success(str);
    }
}
