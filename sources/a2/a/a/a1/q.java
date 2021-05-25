package a2.a.a.a1;

import com.avito.android.home.HomePresenterImpl;
import com.avito.android.home.LoadState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class q extends Lambda implements Function1<Unit, Boolean> {
    public final /* synthetic */ HomePresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(HomePresenterImpl homePresenterImpl) {
        super(1);
        this.a = homePresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return Boolean.valueOf(this.a.g.getLocationState() == LoadState.LOADING);
    }
}
