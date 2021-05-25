package a2.a.a.g1.e.b;

import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModelImpl;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Consumer<Integer> {
    public final /* synthetic */ InlineFiltersCalendarViewModelImpl a;

    public h(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
        this.a = inlineFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        if (num2.intValue() >= 0 && num2.intValue() < this.a.getListItems().size()) {
            if (num2.intValue() <= this.a.getListItems().size() - 1) {
                SingleLiveEvent<Integer> scrollToChanges = this.a.getScrollToChanges();
                Intrinsics.checkNotNullExpressionValue(num2, "checkInPosition");
                scrollToChanges.setValue(num2);
                return;
            }
            this.a.getScrollToChanges().setValue(Integer.valueOf(this.a.getListItems().size() - 1));
        }
    }
}
