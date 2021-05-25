package a2.a.a.r.b.b.b;

import com.avito.android.basket_legacy.utils.VasService;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<VasService, String> {
    public static final c a = new c();

    public c() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public String invoke(VasService vasService) {
        VasService vasService2 = vasService;
        Intrinsics.checkNotNullParameter(vasService2, "it");
        return vasService2.getSlug();
    }
}
