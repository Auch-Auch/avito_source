package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.ObservableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.Image;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolverImpl;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "messages", "Lio/reactivex/Single;", "resolveMessageBodies", "(Ljava/util/List;)Lio/reactivex/Single;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/MessengerClient;", "messengerClient", "Lcom/avito/android/messenger/MessengerEntityConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/MessengerEntityConverter;", "messengerEntityConverter", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageBodyResolverImpl implements MessageBodyResolver {
    public final MessengerClient<AvitoMessengerApi> a;
    public final MessengerEntityConverter b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<List<? extends LocalMessage>, SingleSource<? extends List<? extends LocalMessage>>> {
        public final /* synthetic */ MessageBodyResolverImpl a;

        public a(MessageBodyResolverImpl messageBodyResolverImpl) {
            this.a = messageBodyResolverImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends List<? extends LocalMessage>> apply(List<? extends LocalMessage> list) {
            List<? extends LocalMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "chunk");
            return MessageBodyResolverImpl.access$resolveMessageBodiesInternal(this.a, list2);
        }
    }

    public static final class b<T, R> implements Function<List<List<? extends LocalMessage>>, List<? extends LocalMessage>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends LocalMessage> apply(List<List<? extends LocalMessage>> list) {
            List<List<? extends LocalMessage>> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return e.flatten(list2);
        }
    }

    public MessageBodyResolverImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(messengerClient, "messengerClient");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = messengerClient;
        this.b = messengerEntityConverter;
        this.c = schedulersFactory;
    }

    public static final List access$createChunksWithResolvedImages(MessageBodyResolverImpl messageBodyResolverImpl, MessageBody.SystemMessageBody.Platform platform, Map map) {
        Objects.requireNonNull(messageBodyResolverImpl);
        List<MessageBody.SystemMessageBody.Platform.Bubble> chunks = platform.getChunks();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(chunks, 10));
        for (T t : chunks) {
            if (t instanceof MessageBody.SystemMessageBody.Platform.Bubble.Image) {
                t = t;
                Image image = (Image) map.get(t.getImageId());
                if (image != null) {
                    String imageId = t.getImageId();
                    MessageBody convertImageBody = messageBodyResolverImpl.b.convertImageBody(image);
                    Objects.requireNonNull(convertImageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.ImageBody");
                    t = new MessageBody.SystemMessageBody.Platform.Bubble.Image(imageId, ((MessageBody.ImageBody) convertImageBody).getImage());
                }
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Set access$getImageIdsToDownloadForPlatformMessages(com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl r3, java.util.List r4) {
        /*
            java.util.Objects.requireNonNull(r3)
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x000c:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x004d
            java.lang.Object r0 = r4.next()
            com.avito.android.remote.model.messenger.message.LocalMessage r0 = (com.avito.android.remote.model.messenger.message.LocalMessage) r0
            com.avito.android.remote.model.messenger.message.MessageBody r0 = r0.body
            java.lang.String r1 = "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform"
            java.util.Objects.requireNonNull(r0, r1)
            com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform r0 = (com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform) r0
            java.util.List r0 = r0.getChunks()
            java.util.Iterator r0 = r0.iterator()
        L_0x0029:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x000c
            java.lang.Object r1 = r0.next()
            com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform$Bubble r1 = (com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform.Bubble) r1
            boolean r2 = r1 instanceof com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform.Bubble.Image
            if (r2 == 0) goto L_0x0046
            com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform$Bubble$Image r1 = (com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform.Bubble.Image) r1
            com.avito.android.remote.model.Image r2 = r1.getImage()
            if (r2 != 0) goto L_0x0046
            java.lang.String r1 = r1.getImageId()
            goto L_0x0047
        L_0x0046:
            r1 = 0
        L_0x0047:
            if (r1 == 0) goto L_0x0029
            r3.add(r1)
            goto L_0x0029
        L_0x004d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl.access$getImageIdsToDownloadForPlatformMessages(com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl, java.util.List):java.util.Set");
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x027b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x025b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x030c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02ec A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.Single access$resolveMessageBodiesInternal(com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl r13, java.util.List r14) {
        /*
        // Method dump skipped, instructions count: 885
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl.access$resolveMessageBodiesInternal(com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl, java.util.List):io.reactivex.Single");
    }

    @Override // com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver
    @NotNull
    public Single<List<LocalMessage>> resolveMessageBodies(@NotNull List<LocalMessage> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        Single<List<LocalMessage>> map = ObservableKt.toObservable(CollectionsKt___CollectionsKt.chunked(list, 100)).flatMapSingle(new a(this)).toList().map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "messages.chunked(CHUNK_S…    .map { it.flatten() }");
        return map;
    }

    @Override // com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver
    @NotNull
    public Single<LocalMessage> resolveMessageBody(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "message");
        return MessageBodyResolver.DefaultImpls.resolveMessageBody(this, localMessage);
    }
}
