package a2.a.a.o3;

import com.avito.android.items.BasicInputItem;
import com.avito.android.validation.ParametersListPresenterImpl;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<List<? extends Item>, Unit> {
    public final /* synthetic */ b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(1);
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "$receiver");
        for (Map.Entry entry : this.a.b.entrySet()) {
            int i = this.a.a.c((String) entry.getKey());
            ParametersListPresenterImpl parametersListPresenterImpl = this.a.a;
            Item item = parametersListPresenterImpl.a((Item) parametersListPresenterImpl.c.get(i));
            if (item instanceof BasicInputItem) {
                ((BasicInputItem) item).setValue((String) entry.getValue());
            }
            ParametersListPresenterImpl.access$replaceItem(this.a.a, i, item);
        }
        return Unit.INSTANCE;
    }
}
