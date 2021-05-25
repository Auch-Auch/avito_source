package a7.c.a.a.q.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.storage.welcome.SplashScreenInfoStorage;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, SplashScreenInfoStorage> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public SplashScreenInfoStorage invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (SplashScreenInfoStorage) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<SplashScreenInfoStorage>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$2$$special$$inlined$instance$1
        }), null);
    }
}
