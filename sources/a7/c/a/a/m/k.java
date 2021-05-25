package a7.c.a.a.m;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.mock.auth.IAuthRefreshToken;
import ru.sravni.android.bankproduct.mock.webclient.TokenWebClientStub;
public final class k extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, TokenWebClientStub> {
    public static final k a = new k();

    public k() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public TokenWebClientStub invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new TokenWebClientStub(((Number) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Long>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$5$$special$$inlined$instance$1
        }), "delay")).longValue(), (IAuthRefreshToken) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IAuthRefreshToken>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$5$$special$$inlined$instance$2
        }), null));
    }
}
