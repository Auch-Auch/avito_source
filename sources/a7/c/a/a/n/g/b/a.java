package a7.c.a.a.n.g.b;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import retrofit2.Retrofit;
import ru.sravni.android.bankproduct.network.scoring.IScoringApi;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, IScoringApi> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public IScoringApi invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (IScoringApi) ((Retrofit) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Retrofit>() { // from class: ru.sravni.android.bankproduct.network.scoring.di.NetworkScoringProviderKt$networkScoringKodeinModule$1$1$$special$$inlined$instance$1
        }), null)).create(IScoringApi.class);
    }
}
