package a7.c.a.a.n.d;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
public final class a extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, OkHttpClient> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OkHttpClient invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        for (Interceptor interceptor : (Iterable) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<List<? extends Interceptor>>() { // from class: ru.sravni.android.bankproduct.network.di.NetworkClientProviderKt$networkClientKodeinModule$1$1$$special$$inlined$instance$1
        }), null)) {
            builder.addInterceptor(interceptor);
        }
        long longValue = ((Number) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Long>() { // from class: ru.sravni.android.bankproduct.network.di.NetworkClientProviderKt$networkClientKodeinModule$1$1$$special$$inlined$instance$2
        }), "connectionTimeout")).longValue();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(longValue, timeUnit).readTimeout(((Number) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Long>() { // from class: ru.sravni.android.bankproduct.network.di.NetworkClientProviderKt$networkClientKodeinModule$1$1$$special$$inlined$instance$3
        }), "readTimeout")).longValue(), timeUnit).callTimeout(((Number) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Long>() { // from class: ru.sravni.android.bankproduct.network.di.NetworkClientProviderKt$networkClientKodeinModule$1$1$$special$$inlined$instance$4
        }), "callTimeout")).longValue(), timeUnit).build();
    }
}
