package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class u extends Lambda implements Function1<List<? extends Item>, Unit> {
    public final /* synthetic */ ParametersListPresenterImpl.o a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(ParametersListPresenterImpl.o oVar) {
        super(1);
        this.a = oVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "$receiver");
        List unused = this.a.a.c;
        return Unit.INSTANCE;
    }
}
