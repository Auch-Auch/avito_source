package a2.a.a.o1.d.a0.m;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<LocalMessage, Unit> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "it");
        return Unit.INSTANCE;
    }
}
