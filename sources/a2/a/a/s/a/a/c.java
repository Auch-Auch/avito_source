package a2.a.a.s.a.a;

import android.view.View;
import androidx.lifecycle.Observer;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.form.ComponentsFormUpdate;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.ui.fragment.BeduinFragment;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
public final class c<T> implements Observer<Pair<? extends List<? extends BeduinComponent<BeduinModel, View>>, ? extends ComponentsFormUpdate>> {
    public final /* synthetic */ BeduinFragment a;

    public c(BeduinFragment beduinFragment) {
        this.a = beduinFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Pair<? extends List<? extends BeduinComponent<BeduinModel, View>>, ? extends ComponentsFormUpdate> pair) {
        Pair<? extends List<? extends BeduinComponent<BeduinModel, View>>, ? extends ComponentsFormUpdate> pair2 = pair;
        List<? extends BeduinComponent<BeduinModel, View>> list = (List) pair2.component1();
        ComponentsFormUpdate componentsFormUpdate = (ComponentsFormUpdate) pair2.component2();
        if (componentsFormUpdate instanceof ComponentsFormUpdate.Component) {
            this.a.getBeduinAdapter$beduin_release().notifyItemChanged(((ComponentsFormUpdate.Component) componentsFormUpdate).getIndex());
        } else if (componentsFormUpdate instanceof ComponentsFormUpdate.Form) {
            this.a.getBeduinAdapter$beduin_release().updateList(list);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
