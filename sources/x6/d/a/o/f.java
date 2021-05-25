package x6.d.a.o;

import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.Kodein;
import org.kodein.di.internal.TypeChecker;
public final class f extends Lambda implements Function1<Map.Entry<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>, Triple> {
    public static final f a = new f();

    public f() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Triple invoke(Map.Entry<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>> entry) {
        Map.Entry<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>> entry2 = entry;
        Intrinsics.checkParameterIsNotNull(entry2, "it");
        return new Triple(entry2.getKey(), entry2.getValue(), null);
    }
}
