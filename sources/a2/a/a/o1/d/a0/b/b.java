package a2.a.a.o1.d.a0.b;

import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.n.q;
import t6.v.e;
public final class b<T, R> implements Function<List<? extends MessageMetaInfo>, List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>> {
    public final /* synthetic */ MessageRepoImpl a;
    public final /* synthetic */ List b;

    public b(MessageRepoImpl messageRepoImpl, List list) {
        this.a = messageRepoImpl;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>> apply(List<? extends MessageMetaInfo> list) {
        List<? extends MessageMetaInfo> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "metaInfoList");
        MessageRepoImpl messageRepoImpl = this.a;
        List list3 = this.b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(list2, 10)), 16));
        for (T t : list2) {
            linkedHashMap.put(t.getLocalMessageId(), t);
        }
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list3, 10));
        for (T t2 : list3) {
            arrayList.add(TuplesKt.to(messageRepoImpl.d.toLocalMessage(t2), linkedHashMap.get(t2.getLocalId())));
        }
        return arrayList;
    }
}
