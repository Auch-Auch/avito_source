package com.avito.android.safedeal.delivery_courier.time_interval_select;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItem;
import com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\"\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;", "", "", FirebaseAnalytics.Param.INDEX, "", "onDialogDismissed", "(I)V", "Landroidx/lifecycle/LiveData;", "getTimeIntervalSelectErrorChanges", "()Landroidx/lifecycle/LiveData;", "timeIntervalSelectErrorChanges", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "getTimeIntervalSelectedChanges", "timeIntervalSelectedChanges", "", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;", "getShowDialogChanges", "showDialogChanges", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItem;", "getSelectedItemConsumer", "()Lio/reactivex/functions/Consumer;", "selectedItemConsumer", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierTimeIntervalSelectViewModel {
    @NotNull
    Consumer<TimeIntervalItem> getSelectedItemConsumer();

    @NotNull
    LiveData<List<DialogData>> getShowDialogChanges();

    @NotNull
    LiveData<Unit> getTimeIntervalSelectErrorChanges();

    @NotNull
    LiveData<TimeInterval> getTimeIntervalSelectedChanges();

    void onDialogDismissed(int i);
}
