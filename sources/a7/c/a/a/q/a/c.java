package a7.c.a.a.q.a;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.storage.dashboard.DashBoardStorage;
public final class c extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, DashBoardStorage> {
    public static final c a = new c();

    public c() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public DashBoardStorage invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return new DashBoardStorage((Context) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Application>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$3$$special$$inlined$instance$1
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$3$$special$$inlined$instance$2
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$3$$special$$inlined$instance$3
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$3$$special$$inlined$instance$4
        }), null).invoke("storage"));
    }
}
