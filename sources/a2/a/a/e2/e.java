package a2.a.a.e2;

import com.avito.android.publish.PublishParametersInteractorImpl;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt__CollectionsKt;
public final class e<V> implements Callable<Single<TypedResult<CategoryParameters>>> {
    public final /* synthetic */ PublishParametersInteractorImpl a;
    public final /* synthetic */ Navigation b;
    public final /* synthetic */ CategoryParameters c;
    public final /* synthetic */ Boolean d;

    public e(PublishParametersInteractorImpl publishParametersInteractorImpl, Navigation navigation, CategoryParameters categoryParameters, Boolean bool) {
        this.a = publishParametersInteractorImpl;
        this.b = navigation;
        this.c = categoryParameters;
        this.d = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Single<TypedResult<CategoryParameters>> call() {
        List<ParameterSlot> list;
        io.reactivex.rxjava3.core.Single<TypedResult<CategoryParameters>> single;
        Map<String, String> convertToFieldMap = this.a.e.convertToFieldMap(this.b);
        CategoryParameters categoryParameters = this.c;
        if (categoryParameters == null || (list = categoryParameters.getParametersExceptOwnedBySlots()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Map<String, String> convertToSlotFieldMap = this.a.g.convertToSlotFieldMap(this.a.g.convertToSlotAttributesTree(list));
        Map<String, String> convertToParameterFieldMap = this.a.g.convertToParameterFieldMap(this.a.g.convertToParameterAttributesTree(list));
        if (this.a.h.getHtmlDescriptionOnPublish().invoke().booleanValue()) {
            single = this.a.a.loadExtraStepsAndParametersV6((String) this.a.c.invoke(), convertToFieldMap, convertToParameterFieldMap, convertToSlotFieldMap, this.d);
        } else {
            single = this.a.a.loadExtraStepsAndParameters((String) this.a.c.invoke(), convertToFieldMap, convertToParameterFieldMap, convertToSlotFieldMap, this.d);
        }
        return InteropKt.toV2(single);
    }
}
