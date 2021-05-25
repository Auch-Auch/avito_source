package a7.c.a.a.k.b.b;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.di.buildlevel.AppBuildInfoObjectKt;
import ru.sravni.android.bankproduct.domain.AppBuildInfo;
public final class f extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, AppBuildInfo> {
    public static final f a = new f();

    public f() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public AppBuildInfo invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein, "$receiver");
        return AppBuildInfoObjectKt.getAppBuildInfo();
    }
}
