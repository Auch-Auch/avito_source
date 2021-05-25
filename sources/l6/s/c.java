package l6.s;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import java.util.ArrayList;
import java.util.List;
public final class c implements Function<List<X>, List<Y>> {
    public final /* synthetic */ Function a;

    public c(Function function) {
        this.a = function;
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(@NonNull Object obj) {
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.a.apply(list.get(i)));
        }
        return arrayList;
    }
}
