package a2.a.a.e2.x;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ i a;
    public final /* synthetic */ DateIntervalItemPresenter.DateSelectInfo b;
    public final /* synthetic */ ParameterElement.DateTime c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(i iVar, DateIntervalItemPresenter.DateSelectInfo dateSelectInfo, ParameterElement.DateTime dateTime) {
        super(1);
        this.a = iVar;
        this.b = dateSelectInfo;
        this.c = dateTime;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Long l) {
        this.a.a.onDateIntervalValueChanged(this.b.getSelectInfo(), this.c, Long.valueOf(l.longValue()), this.c.isPresentTime(), false);
        ItemDetailsSelectResultHandler.ResultListener.DefaultImpls.onParametersUpdated$default(this.a.a, null, null, 3, null);
        return Unit.INSTANCE;
    }
}
