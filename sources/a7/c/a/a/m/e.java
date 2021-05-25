package a7.c.a.a.m;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.mock.webclient.ScoringWebClientStubInfo;
public final class e extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ScoringWebClientStubInfo> {
    public static final e a = new e();

    public e() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ScoringWebClientStubInfo invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
        return new ScoringWebClientStubInfo(null, 1, null);
    }
}
