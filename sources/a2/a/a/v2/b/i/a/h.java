package a2.a.a.v2.b.i.a;

import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModelImpl;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Consumer<Integer> {
    public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

    public h(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
        this.a = hotelsFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
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
