package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class u extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Triple a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(Triple triple) {
        super(1);
        this.a = triple;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ((ExtraLoadingListItems) this.a.getFirst()).errorLoading();
        return Unit.INSTANCE;
    }
}
