package t6.w.f.a.m.j.j;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
public final class c extends Lambda implements Function0<String> {
    public final /* synthetic */ Set<SimpleType> a;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Set<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Set<? extends SimpleType> set) {
        super(0);
        this.a = set;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public String invoke() {
        return Intrinsics.stringPlus("This collections cannot be empty! input types: ", CollectionsKt___CollectionsKt.joinToString$default(this.a, null, null, null, 0, null, null, 63, null));
    }
}
