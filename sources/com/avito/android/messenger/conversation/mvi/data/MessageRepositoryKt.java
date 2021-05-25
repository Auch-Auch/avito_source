package com.avito.android.messenger.conversation.mvi.data;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\"*\u0010\u0006\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000j\u0002`\u00038Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\",\u0010\t\u001a\u0004\u0018\u00010\u0002*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000j\u0002`\u00038Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f*&\u0010\r\"\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00002\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "getMessage", "(Lkotlin/Pair;)Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "getMetaInfo", "(Lkotlin/Pair;)Lru/avito/android/persistence/messenger/MessageMetaInfo;", "metaInfo", "", "MESSAGES_PAGE_SIZE", "J", "MessageAndMetaInfo", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class MessageRepositoryKt {
    public static final long MESSAGES_PAGE_SIZE = 100;

    @NotNull
    public static final LocalMessage getMessage(@NotNull Pair<LocalMessage, MessageMetaInfo> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$message");
        return pair.getFirst();
    }

    @Nullable
    public static final MessageMetaInfo getMetaInfo(@NotNull Pair<LocalMessage, MessageMetaInfo> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$metaInfo");
        return pair.getSecond();
    }
}
