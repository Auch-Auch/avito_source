package a2.a.a.o1.b.b.a.a;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.v1.BaseMviEntity;
import com.avito.android.util.Logs;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Pair<? extends StateT, ? extends StateT>, Unit> {
    public final /* synthetic */ BaseMviEntity.a a;

    public d(BaseMviEntity.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.jakewharton.rxrelay2.Relay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public Unit apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        Object component2 = pair.component2();
        String tag = this.a.a.getTAG();
        StringBuilder sb = new StringBuilder();
        StringBuilder I = a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        sb.append(I.toString());
        sb.append(" New State: ");
        sb.append(component2);
        Logs.info$default(tag, sb.toString(), null, 4, null);
        this.a.a.c.accept(component2);
        return Unit.INSTANCE;
    }
}
