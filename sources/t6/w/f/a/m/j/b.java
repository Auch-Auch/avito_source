package t6.w.f.a.m.j;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
public final class b extends Lambda implements Function1<KotlinType, Unit> {
    public final /* synthetic */ AbstractTypeConstructor a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.a = abstractTypeConstructor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(KotlinType kotlinType) {
        KotlinType kotlinType2 = kotlinType;
        Intrinsics.checkNotNullParameter(kotlinType2, "it");
        this.a.reportScopesLoopError(kotlinType2);
        return Unit.INSTANCE;
    }
}
