package x6.d.a.o;

import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.Kodein;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.internal.TypeChecker;
public final class e extends Lambda implements Function1<Map.Entry<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>>, Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>>> {
    public final /* synthetic */ ContextTranslator a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ContextTranslator contextTranslator) {
        super(1);
        this.a = contextTranslator;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>> invoke(Map.Entry<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>> entry) {
        Map.Entry<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>> entry2 = entry;
        Intrinsics.checkParameterIsNotNull(entry2, "it");
        return new Triple<>(entry2.getKey(), entry2.getValue(), this.a);
    }
}
