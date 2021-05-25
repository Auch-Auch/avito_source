package t6.w.f.a.m.c.a.d;

import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
public final class d extends Lambda implements Function1<Integer, JavaTypeQualifiers> {
    public final /* synthetic */ JavaTypeQualifiers[] a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(JavaTypeQualifiers[] javaTypeQualifiersArr) {
        super(1);
        this.a = javaTypeQualifiersArr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public JavaTypeQualifiers invoke(Integer num) {
        int intValue = num.intValue();
        JavaTypeQualifiers[] javaTypeQualifiersArr = this.a;
        return (intValue < 0 || intValue > ArraysKt___ArraysKt.getLastIndex(javaTypeQualifiersArr)) ? JavaTypeQualifiers.Companion.getNONE() : javaTypeQualifiersArr[intValue];
    }
}
