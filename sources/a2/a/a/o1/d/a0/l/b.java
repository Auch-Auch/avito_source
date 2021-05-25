package a2.a.a.o1.d.a0.l;

import arrow.core.Either;
import arrow.core.EitherKt;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractorImpl;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
import t6.y.m;
public final class b<T, R> implements Function<Map<String, ? extends List<? extends String>>, Either> {
    public final /* synthetic */ ChannelReplySuggestsInteractorImpl.c a;

    public b(ChannelReplySuggestsInteractorImpl.c cVar) {
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Either apply(Map<String, ? extends List<? extends String>> map) {
        Map<String, ? extends List<? extends String>> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "suggestByChannel");
        List<T> list = (List) map2.get(this.a.a.b);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(m.capitalize(t));
        }
        return EitherKt.right(arrayList);
    }
}
