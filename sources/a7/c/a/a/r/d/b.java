package a7.c.a.a.r.d;

import android.app.Application;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.Kodein;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Provider;
import ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt;
import ru.sravni.android.bankproduct.utils.di.UtilProviderKt;
import ru.sravni.android.bankproduct.utils.extlib.di.LibKodeinProviderKt;
public final class b extends Lambda implements Function1<Kodein.MainBuilder, Unit> {
    public final /* synthetic */ Application a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(1);
        this.a = application;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Kodein.MainBuilder mainBuilder) {
        Kodein.MainBuilder mainBuilder2 = mainBuilder;
        Intrinsics.checkParameterIsNotNull(mainBuilder2, "$receiver");
        mainBuilder2.Bind(TypesKt.TT(new TypeReference<Application>() { // from class: ru.sravni.android.bankproduct.utils.extlib.LibUtilKt$avitoKodein$1$$special$$inlined$bind$1
        }), null, null).with(new Provider(mainBuilder2.getContextType(), TypesKt.TT(new TypeReference<Application>() { // from class: ru.sravni.android.bankproduct.utils.extlib.LibUtilKt$avitoKodein$1$$special$$inlined$provider$1
        }), new a(this)));
        Kodein.Builder.DefaultImpls.import$default(mainBuilder2, StorageClientProviderKt.getStorageKodeinModule(), false, 2, null);
        Kodein.Builder.DefaultImpls.import$default(mainBuilder2, UtilProviderKt.getUtilKodeinModule(), false, 2, null);
        Kodein.Builder.DefaultImpls.import$default(mainBuilder2, LibKodeinProviderKt.getLibKodeinModule(), false, 2, null);
        return Unit.INSTANCE;
    }
}
