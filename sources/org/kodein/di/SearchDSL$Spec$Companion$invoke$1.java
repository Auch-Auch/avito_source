package org.kodein.di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.SearchDSL;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"org/kodein/di/SearchDSL$Spec$Companion$invoke$1", "Lorg/kodein/di/SearchDSL$Spec;", "Lorg/kodein/di/SearchSpecs;", "specs", "", "apply", "(Lorg/kodein/di/SearchSpecs;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class SearchDSL$Spec$Companion$invoke$1 implements SearchDSL.Spec {
    public final /* synthetic */ Function1 a;

    public SearchDSL$Spec$Companion$invoke$1(Function1 function1) {
        this.a = function1;
    }

    @Override // org.kodein.di.SearchDSL.Spec
    public void apply(@NotNull SearchSpecs searchSpecs) {
        Intrinsics.checkParameterIsNotNull(searchSpecs, "specs");
        this.a.invoke(searchSpecs);
    }
}
