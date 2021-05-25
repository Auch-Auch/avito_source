package a2.a.a.e2.x;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.R;
import com.avito.android.publish.date_picker.DatePickerSheetDialog;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import com.avito.android.publish.objects.ObjectsEditPresenter;
import com.avito.android.publish.objects.ObjectsEditPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class i<T> implements Consumer<DateIntervalItemPresenter.DateSelectInfo> {
    public final /* synthetic */ ObjectsEditPresenterImpl a;

    public i(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
        this.a = objectsEditPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DateIntervalItemPresenter.DateSelectInfo dateSelectInfo) {
        DateIntervalItemPresenter.DateSelectInfo dateSelectInfo2 = dateSelectInfo;
        ParameterElement.DateTime end = dateSelectInfo2.getSelectInfo().getEnd();
        Intrinsics.checkNotNull(end);
        ObjectsEditPresenter.Router router = this.a.c;
        if (router != null) {
            String title = end.getTitle();
            String string = this.a.n.getString(R.string.choose);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.choose)");
            DatePickerSheetDialog.DialogResources dialogResources = new DatePickerSheetDialog.DialogResources(title, string);
            Long value = end.getValue();
            Long delimiter = dateSelectInfo2.getDelimiter();
            router.showDatePickerDialog(dialogResources, value, Long.valueOf(delimiter != null ? delimiter.longValue() : end.getMin()), Long.valueOf(end.getMax()), new h(this, dateSelectInfo2, end));
        }
    }
}
