package a2.a.a.g.l;

import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.Unit;
public final class c<T> implements Consumer<Unit> {
    public final /* synthetic */ SwitcherListItem a;
    public final /* synthetic */ String b;
    public final /* synthetic */ d c;

    public c(SwitcherListItem switcherListItem, String str, MyAdvertSafeDeal.Service service, d dVar, Set set) {
        this.a = switcherListItem;
        this.b = str;
        this.c = dVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.c.a.e.onSwitcherToggled(this.b, this.a.isChecked());
    }
}
