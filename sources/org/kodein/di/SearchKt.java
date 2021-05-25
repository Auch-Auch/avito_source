package org.kodein.di;

import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.bindings.ContextTranslator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aj\u0010\u000b\u001aB\u0012>\u0012<\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u0006\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n0\u00070\u0006*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lorg/kodein/di/KodeinTree;", "Lkotlin/Function1;", "Lorg/kodein/di/FindDSL;", "", "Lkotlin/ExtensionFunctionType;", "f", "", "Lkotlin/Triple;", "Lorg/kodein/di/Kodein$Key;", "Lorg/kodein/di/KodeinDefinition;", "Lorg/kodein/di/bindings/ContextTranslator;", "findAllBindings", "(Lorg/kodein/di/KodeinTree;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class SearchKt {
    @NotNull
    public static final List<Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>>> findAllBindings(@NotNull KodeinTree kodeinTree, @NotNull Function1<? super FindDSL, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(kodeinTree, "$this$findAllBindings");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        FindDSL findDSL = new FindDSL();
        function1.invoke(findDSL);
        return kodeinTree.find(findDSL.getSpecs$kodein_di_core());
    }
}
