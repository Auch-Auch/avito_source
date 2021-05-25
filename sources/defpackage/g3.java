package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import java.util.Set;
import kotlin.Pair;
/* compiled from: java-style lambda group */
/* renamed from: g3  reason: default package */
public final class g3<T> implements Observer<Pair<? extends String, ? extends Boolean>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public g3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Pair<? extends String, ? extends Boolean> pair) {
        int i = this.a;
        if (i == 0) {
            Pair<? extends String, ? extends Boolean> pair2 = pair;
            String str = (String) pair2.component1();
            boolean booleanValue = ((Boolean) pair2.component2()).booleanValue();
            Set set = ((MyAdvertSafeDealServicesView) this.b).c;
            if (booleanValue) {
                set.add(str);
            } else {
                set.remove(str);
            }
            SwitcherListItem switcherListItem = (SwitcherListItem) ((MyAdvertSafeDealServicesView) this.b).b.get(str);
            if (switcherListItem != null) {
                switcherListItem.setLoading(booleanValue);
            }
        } else if (i == 1) {
            Pair<? extends String, ? extends Boolean> pair3 = pair;
            boolean booleanValue2 = ((Boolean) pair3.component2()).booleanValue();
            SwitcherListItem switcherListItem2 = (SwitcherListItem) ((MyAdvertSafeDealServicesView) this.b).b.get((String) pair3.component1());
            if (switcherListItem2 != null) {
                switcherListItem2.setChecked(booleanValue2);
            }
        } else {
            throw null;
        }
    }
}
