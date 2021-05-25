package a7.c.a.a.k.b.b;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
public final class g extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, Application> {
    public static final g a = new g();

    public g() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Application invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return ((AppCompatActivity) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<AppCompatActivity>() { // from class: ru.sravni.android.bankproduct.di.buildlevel.release.BuildProviderKt$releaseBuildTypeKodeinModule$1$7$$special$$inlined$instance$1
        }), null)).getApplication();
    }
}
