package a2.a.a.g1.e.d;

import a2.b.a.a.a;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.select.group_select.models.SelectableGroup;
import com.avito.android.select.group_select.models.SelectableOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import t6.n.e;
import t6.n.h;
public final class b extends Lambda implements Function1<List<? extends SelectableGroup>, Unit> {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function0 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Function1 function1, Function0 function0) {
        super(1);
        this.a = function1;
        this.b = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends SelectableGroup> list) {
        List<? extends SelectableGroup> list2 = list;
        ArrayList i0 = a.i0(list2, "groups");
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            List<SelectableOption> items = it.next().getItems();
            ArrayList arrayList = new ArrayList();
            for (T t : items) {
                if (t.isSelected()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((SelectableOption) it2.next()).getId());
            }
            h.addAll(i0, arrayList2);
        }
        this.a.invoke(new InlineFilterValue.InlineFilterMultiSelectValue(i0));
        this.b.invoke();
        return Unit.INSTANCE;
    }
}
