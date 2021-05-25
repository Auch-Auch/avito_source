package a2.a.a.b3.a;

import com.avito.android.str_calendar.booking.CalendarViewModelImpl;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class t<T> implements Consumer<Integer> {
    public final /* synthetic */ CalendarViewModelImpl a;

    public t(CalendarViewModelImpl calendarViewModelImpl) {
        this.a = calendarViewModelImpl;
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
