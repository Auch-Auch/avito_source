package a2.a.a.e3.d.e;

import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class j extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ k a;
    public final /* synthetic */ ManagerCallItem b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(k kVar, ManagerCallItem managerCallItem) {
        super(1);
        this.a = kVar;
        this.b = managerCallItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        this.a.a.l.postValue(this.b.getDeepLink());
        return Unit.INSTANCE;
    }
}
