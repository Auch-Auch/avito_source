package defpackage;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.network.di.NetworkDataProviderKt;
/* compiled from: kotlin-style lambda group */
/* renamed from: b6  reason: default package */
public final class b6 extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, Long> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b6(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
            return Long.valueOf(((NetworkDataProviderKt.a) this.b).a.getConnectionTimeout());
        } else if (i == 1) {
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
            return Long.valueOf(((NetworkDataProviderKt.a) this.b).a.getReadTimeout());
        } else if (i == 2) {
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
            return Long.valueOf(((NetworkDataProviderKt.a) this.b).a.getCallTimeout());
        } else {
            throw null;
        }
    }
}
