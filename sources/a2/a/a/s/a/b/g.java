package a2.a.a.s.a.b;

import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.form.ComponentsFormUpdate;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t6.n.e;
public final class g extends Lambda implements Function1<ComponentsFormUpdate, Unit> {
    public final /* synthetic */ BeduinViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(BeduinViewModel beduinViewModel) {
        super(1);
        this.a = beduinViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ComponentsFormUpdate componentsFormUpdate) {
        List list;
        ComponentsFormUpdate componentsFormUpdate2 = componentsFormUpdate;
        Intrinsics.checkNotNullParameter(componentsFormUpdate2, "update");
        if (componentsFormUpdate2 instanceof ComponentsFormUpdate.Component) {
            list = this.a.k;
            ComponentsFormUpdate.Component component = (ComponentsFormUpdate.Component) componentsFormUpdate2;
            ((BeduinComponent) list.get(component.getIndex())).setModel(component.getModel());
        } else if (componentsFormUpdate2 instanceof ComponentsFormUpdate.Form) {
            List<BeduinModel> models = ((ComponentsFormUpdate.Form) componentsFormUpdate2).getModels();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(models, 10));
            Iterator<T> it = models.iterator();
            while (it.hasNext()) {
                arrayList.add(this.a.l.getComponentByModel(it.next(), this.a.j));
            }
            this.a.k = arrayList;
            list = arrayList;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.a.f.setValue(TuplesKt.to(list, componentsFormUpdate2));
        return Unit.INSTANCE;
    }
}
