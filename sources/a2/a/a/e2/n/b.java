package a2.a.a.e2.n;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.analytics.PublishInputsAnalyticTrackerImpl;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<List<ParameterElement.Select>> {
    public final /* synthetic */ PublishInputsAnalyticTrackerImpl a;

    public b(PublishInputsAnalyticTrackerImpl publishInputsAnalyticTrackerImpl) {
        this.a = publishInputsAnalyticTrackerImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<ParameterElement.Select> list) {
        List<ParameterElement.Select> list2 = list;
        Intrinsics.checkNotNullExpressionValue(list2, "changedItems");
        for (T t : list2) {
            this.a.e.trackParamValueChangedEvent(t.getTitle(), t.getValue(), PublishInputsAnalyticTrackerImpl.access$getNavigationProvider$p(this.a).getNavigation());
        }
    }
}
