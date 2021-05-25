package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.Image;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0005 \u0006*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lru/avito/messenger/api/entity/Image;", "imagesById", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "kotlin.jvm.PlatformType", "apply", "(Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageBodyResolverImpl$downloadImagesForPlatformMessages$1<T, R> implements Function<Map<String, ? extends Image>, List<? extends LocalMessage>> {
    public final /* synthetic */ MessageBodyResolverImpl a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Function4 c;

    public MessageBodyResolverImpl$downloadImagesForPlatformMessages$1(MessageBodyResolverImpl messageBodyResolverImpl, List list, Function4 function4) {
        this.a = messageBodyResolverImpl;
        this.b = list;
        this.c = function4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ List<? extends LocalMessage> apply(Map<String, ? extends Image> map) {
        return apply((Map<String, Image>) map);
    }

    public final List<LocalMessage> apply(@NotNull Map<String, Image> map) {
        Intrinsics.checkNotNullParameter(map, "imagesById");
        List list = this.b;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            MessageBody messageBody = t.body;
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform");
            MessageBody.SystemMessageBody.Platform platform = (MessageBody.SystemMessageBody.Platform) messageBody;
            MessageBodyResolverImpl messageBodyResolverImpl = this.a;
            List<MessageBody.SystemMessageBody.Platform.Bubble> chunks = platform.getChunks();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(chunks, 10));
            for (T t2 : chunks) {
                if (t2 instanceof MessageBody.SystemMessageBody.Platform.Bubble.Image) {
                    t2 = t2;
                    Image image = map.get(t2.getImageId());
                    if (image != null) {
                        String imageId = t2.getImageId();
                        MessageBody convertImageBody = messageBodyResolverImpl.b.convertImageBody(image);
                        Objects.requireNonNull(convertImageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.ImageBody");
                        t2 = new MessageBody.SystemMessageBody.Platform.Bubble.Image(imageId, ((MessageBody.ImageBody) convertImageBody).getImage());
                    }
                }
                arrayList2.add(t2);
            }
            arrayList.add(LocalMessage.copy$default(t, null, null, null, (MessageBody) this.c.invoke(arrayList2, platform.getContextActions(), platform.getFlow(), platform.getFallbackText()), null, null, 0, false, false, null, null, false, null, 8183, null));
        }
        return arrayList;
    }
}
