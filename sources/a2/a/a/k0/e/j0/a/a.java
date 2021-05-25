package a2.a.a.k0.e.j0.a;

import com.avito.android.delivery.summary.konveyor.input.InputItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ InputItemPresenterImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(InputItemPresenterImpl.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        this.a.c.setValue(str2);
        this.a.b.a.accept(this.a.c);
        return Unit.INSTANCE;
    }
}
