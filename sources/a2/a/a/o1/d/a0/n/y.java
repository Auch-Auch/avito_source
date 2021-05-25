package a2.a.a.o1.d.a0.n;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
import t6.n.e;
public final class y<T, R> implements Function<List<List<? extends ChatMessage>>, List<? extends ChatMessage>> {
    public static final y a = new y();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends ChatMessage> apply(List<List<? extends ChatMessage>> list) {
        List<List<? extends ChatMessage>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        return e.flatten(list2);
    }
}
