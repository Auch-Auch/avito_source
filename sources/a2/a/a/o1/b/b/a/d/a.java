package a2.a.a.o1.b.b.a.d;

import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Predicate<Reducible<StateT>> {
    public final /* synthetic */ d a;

    public a(d dVar) {
        this.a = dVar;
    }

    @Override // io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        Reducible reducible = (Reducible) obj;
        Intrinsics.checkNotNullParameter(reducible, "otherReducible");
        ShouldCancelChecker shouldCancelChecker = this.a.a.a.k;
        Reducible reducible2 = this.a.b;
        Intrinsics.checkNotNullExpressionValue(reducible2, "reducible");
        boolean aShouldCancelB = shouldCancelChecker.aShouldCancelB(reducible, reducible2);
        Function1 function1 = this.a.a.a.m;
        StringBuilder sb = new StringBuilder();
        sb.append(reducible);
        sb.append(' ');
        sb.append(aShouldCancelB ? "SHOULD" : "SHOULD NOT");
        sb.append(" cancel ");
        sb.append(this.a.b);
        function1.invoke(sb.toString());
        return aShouldCancelB;
    }
}
