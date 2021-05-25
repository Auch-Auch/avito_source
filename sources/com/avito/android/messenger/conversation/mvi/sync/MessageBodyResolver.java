package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "messages", "Lio/reactivex/Single;", "resolveMessageBodies", "(Ljava/util/List;)Lio/reactivex/Single;", "message", "resolveMessageBody", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageBodyResolver {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T, R> implements Function<List<? extends LocalMessage>, LocalMessage> {
            public static final a a = new a();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public LocalMessage apply(List<? extends LocalMessage> list) {
                List<? extends LocalMessage> list2 = list;
                Intrinsics.checkNotNullParameter(list2, "resolvedMessages");
                return (LocalMessage) CollectionsKt___CollectionsKt.single((List<? extends Object>) list2);
            }
        }

        @NotNull
        public static Single<LocalMessage> resolveMessageBody(@NotNull MessageBodyResolver messageBodyResolver, @NotNull LocalMessage localMessage) {
            Intrinsics.checkNotNullParameter(localMessage, "message");
            Single<R> map = messageBodyResolver.resolveMessageBodies(d.listOf(localMessage)).map(a.a);
            Intrinsics.checkNotNullExpressionValue(map, "resolveMessageBodies(lis…solvedMessages.single() }");
            return map;
        }
    }

    @NotNull
    Single<List<LocalMessage>> resolveMessageBodies(@NotNull List<LocalMessage> list);

    @NotNull
    Single<LocalMessage> resolveMessageBody(@NotNull LocalMessage localMessage);
}
