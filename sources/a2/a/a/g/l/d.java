package a2.a.a.g.l;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.util.Logs;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding3.view.RxView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Observer<Pair<? extends MyAdvertSafeDeal, ? extends Set<? extends String>>> {
    public final /* synthetic */ MyAdvertSafeDealServicesView a;

    public d(MyAdvertSafeDealServicesView myAdvertSafeDealServicesView) {
        this.a = myAdvertSafeDealServicesView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Pair<? extends MyAdvertSafeDeal, ? extends Set<? extends String>> pair) {
        int i;
        Pair<? extends MyAdvertSafeDeal, ? extends Set<? extends String>> pair2 = pair;
        MyAdvertSafeDeal myAdvertSafeDeal = (MyAdvertSafeDeal) pair2.component1();
        Set set = (Set) pair2.component2();
        if (MyAdvertSafeDealServicesView.access$getView$p(this.a).getChildCount() > 0) {
            MyAdvertSafeDealServicesView.access$getView$p(this.a).removeAllViews();
        }
        List<MyAdvertSafeDeal.Service> services = myAdvertSafeDeal.getServices();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = services.iterator();
        while (true) {
            boolean z = false;
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.getContent().getId() != null) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            MyAdvertSafeDeal.Service service = (MyAdvertSafeDeal.Service) it2.next();
            MyAdvertSafeDeal.Service.Type type = service.getType();
            if (type != null) {
                int ordinal = type.ordinal();
                if (ordinal == 0) {
                    MyAdvertSafeDealServicesView myAdvertSafeDealServicesView = this.a;
                    int i2 = R.layout.safedeal_service_item;
                    ViewGroup access$getView$p = MyAdvertSafeDealServicesView.access$getView$p(myAdvertSafeDealServicesView);
                    View inflate = MyAdvertSafeDealServicesView.access$getLayoutInflater$p(myAdvertSafeDealServicesView).inflate(i2, access$getView$p, false);
                    Objects.requireNonNull(inflate, "null cannot be cast to non-null type T");
                    SwitcherListItem switcherListItem = (SwitcherListItem) inflate;
                    View findViewById = switcherListItem.findViewById(com.avito.android.lib.design.R.id.design_item_switcher);
                    Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
                    Views.conceal(findViewById);
                    MyAdvertSafeDealServicesView.access$bindTexts(this.a, switcherListItem, service.getContent());
                    Integer access$getIconRes = MyAdvertSafeDealServicesView.access$getIconRes(this.a, service.getContent().getIcon());
                    if (access$getIconRes != null) {
                        switcherListItem.setImageResource(access$getIconRes.intValue());
                    }
                    access$getView$p.addView(inflate);
                } else if (ordinal == i) {
                    String id = service.getContent().getId();
                    Intrinsics.checkNotNull(id);
                    MyAdvertSafeDealServicesView myAdvertSafeDealServicesView2 = this.a;
                    int i3 = R.layout.safedeal_service_item;
                    ViewGroup access$getView$p2 = MyAdvertSafeDealServicesView.access$getView$p(myAdvertSafeDealServicesView2);
                    View inflate2 = MyAdvertSafeDealServicesView.access$getLayoutInflater$p(myAdvertSafeDealServicesView2).inflate(i3, access$getView$p2, false);
                    Objects.requireNonNull(inflate2, "null cannot be cast to non-null type T");
                    SwitcherListItem switcherListItem2 = (SwitcherListItem) inflate2;
                    switcherListItem2.setTag(id);
                    MyAdvertSafeDealServicesView.access$bindTexts(this.a, switcherListItem2, service.getContent());
                    Integer access$getIconRes2 = MyAdvertSafeDealServicesView.access$getIconRes(this.a, service.getContent().getIcon());
                    if (access$getIconRes2 != null) {
                        switcherListItem2.setImageResource(access$getIconRes2.intValue());
                    }
                    switcherListItem2.setChecked(set.contains(id));
                    RxView.clicks(switcherListItem2).filter(new b(id, service, this, set)).subscribe(new c(switcherListItem2, id, service, this, set));
                    access$getView$p2.addView(inflate2);
                    MyAdvertSafeDealServicesView.access$getSwitchersMap$p(this.a).put(id, switcherListItem2);
                }
                i = 1;
            }
            Logs.error$default("Need to handle new type of safeDeal services from json", null, 2, null);
            i = 1;
        }
    }
}
