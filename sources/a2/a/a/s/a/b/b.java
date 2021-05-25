package a2.a.a.s.a.b;

import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
public final class b extends Lambda implements Function1<List<? extends BeduinAction>, Unit> {
    public final /* synthetic */ BeduinViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(BeduinViewModel beduinViewModel) {
        super(1);
        this.a = beduinViewModel;
    }

    public final void a(@NotNull List<? extends BeduinAction> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.a.j.handle(it.next());
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends BeduinAction> list) {
        a(list);
        return Unit.INSTANCE;
    }
}
