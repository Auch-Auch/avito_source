package a7.c.a.a.n.a.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import retrofit2.Retrofit;
import ru.sravni.android.bankproduct.network.auth.IAuthApi;
public final class a extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, IAuthApi> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public IAuthApi invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return (IAuthApi) ((Retrofit) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Retrofit>() { // from class: ru.sravni.android.bankproduct.network.auth.di.NetworkAuthProviderKt$networkAuthKodeinModule$1$1$$special$$inlined$instance$1
        }), null)).create(IAuthApi.class);
    }
}
