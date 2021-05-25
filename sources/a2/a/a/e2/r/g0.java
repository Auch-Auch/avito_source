package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.remote.model.ParamKeyValue;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class g0 extends Lambda implements Function1<List<? extends ParamKeyValue>, Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;
    public final /* synthetic */ Function0 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(PublishDetailsPresenterImpl publishDetailsPresenterImpl, Function0 function0) {
        super(1);
        this.a = publishDetailsPresenterImpl;
        this.b = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends ParamKeyValue> list) {
        List<? extends ParamKeyValue> list2 = list;
        CategoryParameters categoryParameters = PublishDetailsPresenterImpl.access$getPublishViewModel$p(this.a).getCategoryParameters();
        PublishDetailsPresenterImpl publishDetailsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "suggestedParams");
        for (ParamKeyValue paramKeyValue : PublishDetailsPresenterImpl.access$filterChangedParams(publishDetailsPresenterImpl, list2)) {
            ParameterSlot findParameter = categoryParameters != null ? categoryParameters.findParameter(paramKeyValue.getId()) : null;
            if (!(findParameter instanceof CharParameter)) {
                findParameter = null;
            }
            CharParameter charParameter = (CharParameter) findParameter;
            if (charParameter != null) {
                String value = paramKeyValue.getValue();
                if (!Intrinsics.areEqual(charParameter.get_value(), value)) {
                    charParameter.set_value(value);
                    charParameter.setError(null);
                }
            }
        }
        this.b.invoke();
        return Unit.INSTANCE;
    }
}
