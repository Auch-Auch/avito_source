package a2.a.a.k1.a.f;

import com.avito.android.lib.design.picker.WheelData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<WheelData<?>, String> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public String invoke(WheelData<?> wheelData) {
        WheelData<?> wheelData2 = wheelData;
        Intrinsics.checkNotNullParameter(wheelData2, "it");
        return wheelData2.getName();
    }
}
