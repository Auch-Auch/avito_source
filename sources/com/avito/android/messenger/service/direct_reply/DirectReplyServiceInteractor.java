package com.avito.android.messenger.service.direct_reply;

import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractor;", "", "", "channelId", "text", "", "isRetry", MessageBody.RANDOM_ID, "Lio/reactivex/Completable;", "sendMessageAndReadChat", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/Completable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface DirectReplyServiceInteractor {
    @NotNull
    Completable sendMessageAndReadChat(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3);
}
