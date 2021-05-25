package a7.c.a.a.n.a.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.network.auth.AuthWebClient;
import ru.sravni.android.bankproduct.network.auth.IAuthApi;
public final class b extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, AuthWebClient> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public AuthWebClient invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new AuthWebClient((IAuthApi) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IAuthApi>() { // from class: ru.sravni.android.bankproduct.network.auth.di.NetworkAuthProviderKt$networkAuthKodeinModule$1$2$$special$$inlined$instance$1
        }), null), (IThrowableWrapper) noArgSimpleBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.network.auth.di.NetworkAuthProviderKt$networkAuthKodeinModule$1$2$$special$$inlined$instance$2
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.network.auth.di.NetworkAuthProviderKt$networkAuthKodeinModule$1$2$$special$$inlined$instance$3
        }), null).invoke("network"));
    }
}
