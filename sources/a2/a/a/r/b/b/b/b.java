package a2.a.a.r.b.b.b;

import com.avito.android.basket_legacy.utils.VasService;
import com.avito.android.basket_legacy.utils.VasType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<VasService, Boolean> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(VasService vasService) {
        VasService vasService2 = vasService;
        Intrinsics.checkNotNullParameter(vasService2, "it");
        return Boolean.valueOf(vasService2.getType() == VasType.VISUAL);
    }
}
