package a2.a.a.e2.x;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import com.avito.android.publish.objects.ObjectsEditPresenterImpl;
import io.reactivex.functions.Consumer;
public final class j<T> implements Consumer<DateIntervalItemPresenter.DateSelectInfo> {
    public final /* synthetic */ ObjectsEditPresenterImpl a;

    public j(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
        this.a = objectsEditPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DateIntervalItemPresenter.DateSelectInfo dateSelectInfo) {
        DateIntervalItemPresenter.DateSelectInfo dateSelectInfo2 = dateSelectInfo;
        ParameterElement.DateTime end = dateSelectInfo2.getSelectInfo().getEnd();
        if (end != null) {
            this.a.onDateIntervalValueChanged(dateSelectInfo2.getSelectInfo(), end, null, dateSelectInfo2.isPresentTime(), false);
        }
        ItemDetailsSelectResultHandler.ResultListener.DefaultImpls.onParametersUpdated$default(this.a, null, null, 3, null);
    }
}
