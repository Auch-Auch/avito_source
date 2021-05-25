package t6.w.f.a.m.g.f;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
public final class a extends Lambda implements Function1<KotlinType, CharSequence> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(KotlinType kotlinType) {
        KotlinType kotlinType2 = kotlinType;
        Intrinsics.checkNotNullParameter(kotlinType2, "it");
        return kotlinType2.toString();
    }
}
