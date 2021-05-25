package a2.a.a.e2.n;

import com.avito.android.items.CheckBoxItem;
import com.avito.android.publish.analytics.PublishInputsAnalyticTrackerImpl;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<CheckBoxItem> {
    public final /* synthetic */ PublishInputsAnalyticTrackerImpl a;

    public e(PublishInputsAnalyticTrackerImpl publishInputsAnalyticTrackerImpl) {
        this.a = publishInputsAnalyticTrackerImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CheckBoxItem checkBoxItem) {
        CheckBoxItem checkBoxItem2 = checkBoxItem;
        this.a.e.trackParamValueChangedEvent(checkBoxItem2.getText(), String.valueOf(checkBoxItem2.isChecked()), PublishInputsAnalyticTrackerImpl.access$getNavigationProvider$p(this.a).getNavigation());
    }
}
