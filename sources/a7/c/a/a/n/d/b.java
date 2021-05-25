package a7.c.a.a.n.d;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, Retrofit> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Retrofit invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return new Retrofit.Builder().client((OkHttpClient) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<OkHttpClient>() { // from class: ru.sravni.android.bankproduct.network.di.NetworkClientProviderKt$networkClientKodeinModule$1$2$$special$$inlined$instance$1
        }), null)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl((String) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.network.di.NetworkClientProviderKt$networkClientKodeinModule$1$2$$special$$inlined$instance$2
        }), "baseUrl")).build();
    }
}
