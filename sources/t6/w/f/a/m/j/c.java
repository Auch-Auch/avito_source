package t6.w.f.a.m.j;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
public final class c extends Lambda implements Function1<TypeConstructor, Iterable<? extends KotlinType>> {
    public final /* synthetic */ AbstractTypeConstructor a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.a = abstractTypeConstructor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Iterable<? extends KotlinType> invoke(TypeConstructor typeConstructor) {
        TypeConstructor typeConstructor2 = typeConstructor;
        Intrinsics.checkNotNullParameter(typeConstructor2, "it");
        return AbstractTypeConstructor.access$computeNeighbours(this.a, typeConstructor2, false);
    }
}
