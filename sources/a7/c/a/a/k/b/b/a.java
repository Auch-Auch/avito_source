package a7.c.a.a.k.b.b;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.AppBuildInfo;
import ru.sravni.android.bankproduct.network.interceptor.SravniHeaderAddInterceptor;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, List<? extends Interceptor>> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public List<? extends Interceptor> invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Interceptor[]{httpLoggingInterceptor, new SravniHeaderAddInterceptor((AppBuildInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<AppBuildInfo>() { // from class: ru.sravni.android.bankproduct.di.buildlevel.release.BuildProviderKt$releaseBuildTypeKodeinModule$1$1$$special$$inlined$instance$1
        }), null))});
    }
}
