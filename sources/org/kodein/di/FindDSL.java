package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.SearchDSL;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u00020\u00068\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lorg/kodein/di/FindDSL;", "Lorg/kodein/di/SearchDSL;", "Lorg/kodein/di/SearchDSL$Spec;", "", "unaryPlus", "(Lorg/kodein/di/SearchDSL$Spec;)V", "Lorg/kodein/di/SearchSpecs;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/SearchSpecs;", "getSpecs$kodein_di_core", "()Lorg/kodein/di/SearchSpecs;", "specs", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class FindDSL extends SearchDSL {
    @NotNull
    public final SearchSpecs a = new SearchSpecs(null, null, null, null, 15, null);

    @NotNull
    public final SearchSpecs getSpecs$kodein_di_core() {
        return this.a;
    }

    public final void unaryPlus(@NotNull SearchDSL.Spec spec) {
        Intrinsics.checkParameterIsNotNull(spec, "$this$unaryPlus");
        spec.apply(this.a);
    }
}
