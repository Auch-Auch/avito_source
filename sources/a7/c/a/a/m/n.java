package a7.c.a.a.m;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.mock.webclient.OfferProductWebClientStubInfo;
public final class n extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferProductWebClientStubInfo> {
    public static final n a = new n();

    public n() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductWebClientStubInfo invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
        return new OfferProductWebClientStubInfo(null, null, null, null, null, null, null, 127, null);
    }
}
