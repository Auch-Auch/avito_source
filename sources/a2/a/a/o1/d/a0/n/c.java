package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import ru.avito.messenger.api.entity.body.item.BodyItem;
import t6.n.e;
public final class c<T, R> implements Function<List<? extends BodyItem>, List<? extends LocalMessage>> {
    public final /* synthetic */ List a;
    public final /* synthetic */ MessageBodyResolverImpl b;

    public c(List list, MessageBodyResolverImpl messageBodyResolverImpl) {
        this.a = list;
        this.b = messageBodyResolverImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends LocalMessage> apply(List<? extends BodyItem> list) {
        List<? extends BodyItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "bodyItems");
        Sequence filterNotNull = SequencesKt___SequencesKt.filterNotNull(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list2), new b(this)));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : filterNotNull) {
            Pair pair = TuplesKt.to(t.getId(), t);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        List list3 = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list3, 10));
        for (T t2 : list3) {
            MessageBody messageBody = t2.body;
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.ItemReference");
            MessageBody.Item item = (MessageBody.Item) linkedHashMap.get(((MessageBody.ItemReference) messageBody).getItemId());
            if (item != null) {
                t2 = (T) LocalMessage.copy$default(t2, null, null, null, item, null, null, 0, false, false, null, null, false, null, 8183, null);
            }
            arrayList.add(t2);
        }
        return arrayList;
    }
}
