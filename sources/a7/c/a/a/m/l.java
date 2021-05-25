package a7.c.a.a.m;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.mock.webclient.OfferOsagoWebClientStubInfo;
public final class l extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferOsagoWebClientStubInfo> {
    public static final l a = new l();

    public l() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferOsagoWebClientStubInfo invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
        return new OfferOsagoWebClientStubInfo(null, null, null, null, null, null, 63, null);
    }
}
