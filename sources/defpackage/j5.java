package defpackage;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.presentation.navigation.CiceroneHolder;
/* compiled from: kotlin-style lambda group */
/* renamed from: j5  reason: default package */
public final class j5 extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, CiceroneHolder> {
    public static final j5 b = new j5(0);
    public static final j5 c = new j5(1);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j5(int i) {
        super(1);
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final CiceroneHolder invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein, "$receiver");
            return new CiceroneHolder();
        } else if (i == 1) {
            Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein, "$receiver");
            return new CiceroneHolder();
        } else {
            throw null;
        }
    }
}
