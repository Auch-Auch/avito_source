package a2.a.a.o1.b.b.a.b;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity;
import com.avito.android.util.Logs;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<StateT, SingleSource<? extends Pair<? extends StateT, ? extends StateT>>> {
    public final /* synthetic */ BaseMviEntity.a.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;

    public b(BaseMviEntity.a.b bVar, String str, Function1 function1) {
        this.a = bVar;
        this.b = str;
        this.c = function1;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "oldState");
        String tag = this.a.a.a.getTAG();
        StringBuilder sb = new StringBuilder();
        a.f1("Thread.currentThread()", a.I('['), ']', sb, " New Mutator: ");
        sb.append(this.b);
        Logs.debug$default(tag, sb.toString(), null, 4, null);
        return ((Single) this.c.invoke(obj)).map(new a(obj));
    }
}
