package com.avito.android.messenger.conversation.mvi.data;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageEntity;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lru/avito/android/persistence/messenger/MessageEntity;", "messageEntities", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "kotlin.jvm.PlatformType", "apply", "(Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageRepoImpl$mapToLocalMessages$1<T, R> implements Function<List<? extends MessageEntity>, List<? extends LocalMessage>> {
    public final /* synthetic */ MessageRepoImpl a;

    public MessageRepoImpl$mapToLocalMessages$1(MessageRepoImpl messageRepoImpl) {
        this.a = messageRepoImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ List<? extends LocalMessage> apply(List<? extends MessageEntity> list) {
        return apply((List<MessageEntity>) list);
    }

    public final List<LocalMessage> apply(@NotNull List<MessageEntity> list) {
        Intrinsics.checkNotNullParameter(list, "messageEntities");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.a.d.toLocalMessage(it.next()));
        }
        return arrayList;
    }
}
