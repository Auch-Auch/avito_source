package a2.a.a.e2.r;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import io.reactivex.functions.Consumer;
public final class n<T> implements Consumer<ParameterElement.Multiselect> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    public n(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        this.a = publishDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ParameterElement.Multiselect multiselect) {
        ParameterSlot findParameter = this.a.getParametersTree().findParameter(multiselect.getStringId());
        if (findParameter instanceof MultiselectParameter) {
            ((MultiselectParameter) findParameter).setValue(null);
            this.a.c(PublishDetailsFlowTracker.FlowContext.PARAMETER_VALUE_UPDATE);
        }
    }
}
