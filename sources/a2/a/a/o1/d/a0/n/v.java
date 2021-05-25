package a2.a.a.o1.d.a0.n;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.avito.messenger.api.entity.ChatMessage;
public final class v extends Lambda implements Function1<List<? extends ChatMessage>, Boolean> {
    public static final v a = new v();

    public v() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(List<? extends ChatMessage> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return Boolean.TRUE;
    }
}
