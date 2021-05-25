package com.avito.android.messenger.conversation.mvi.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverterImpl;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lru/avito/android/persistence/messenger/MessageEntity;", "toMessageEntity", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lru/avito/android/persistence/messenger/MessageEntity;", "entity", "toLocalMessage", "(Lru/avito/android/persistence/messenger/MessageEntity;)Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "bodySerializer", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageEntityConverterImpl implements MessageEntityConverter {
    public final MessageBodySerializer a;

    @Inject
    public MessageEntityConverterImpl(@NotNull MessageBodySerializer messageBodySerializer) {
        Intrinsics.checkNotNullParameter(messageBodySerializer, "bodySerializer");
        this.a = messageBodySerializer;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter
    @NotNull
    public LocalMessage toLocalMessage(@NotNull MessageEntity messageEntity) {
        Intrinsics.checkNotNullParameter(messageEntity, "entity");
        return new LocalMessage(messageEntity.getLocalId(), messageEntity.getRemoteId(), messageEntity.getChannelId(), this.a.deserialize(messageEntity.getType(), messageEntity.getJsonBody()), messageEntity.getUserId(), messageEntity.getFromId(), messageEntity.getCreated(), messageEntity.isRead(), messageEntity.isFailed(), messageEntity.getReadTimestamp(), messageEntity.getPreview(), messageEntity.isSupported(), messageEntity.getReadLocallyTimestamp());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (r3.getImage() == null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if ((r2.length() > 0) != false) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2  */
    @Override // com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ru.avito.android.persistence.messenger.MessageEntity toMessageEntity(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.messenger.message.LocalMessage r25) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl.toMessageEntity(com.avito.android.remote.model.messenger.message.LocalMessage):ru.avito.android.persistence.messenger.MessageEntity");
    }
}
