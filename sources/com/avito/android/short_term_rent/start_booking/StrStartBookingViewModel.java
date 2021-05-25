package com.avito.android.short_term_rent.start_booking;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import com.avito.android.short_term_rent.confirm_booking.event.ConfirmBookingEvent;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemClearListenter;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemClickListenter;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountClickListener;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountsProvider;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u000bR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR2\u0010 \u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\"\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001bR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001b¨\u0006*"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountClickListener;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountsProvider;", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemClickListenter;", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemClearListenter;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "onNextButtonClicked", "()V", "", "success", "Landroid/content/Intent;", "data", "onDatesSelected", "(ZLandroid/content/Intent;)V", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onRestoreInstanceState", "onAuthCompleted", "Landroidx/lifecycle/LiveData;", "", "getErrorMessageChanges", "()Landroidx/lifecycle/LiveData;", "errorMessageChanges", "Lkotlin/Triple;", "Ljava/util/Date;", "getSelectDatesChanges", "selectDatesChanges", "", "Lkotlin/ranges/IntRange;", "getGroupsChanges", "groupsChanges", "getAuthScreenChanges", "authScreenChanges", "Lcom/avito/android/short_term_rent/confirm_booking/event/ConfirmBookingEvent;", "getNextButtonClicks", "nextButtonClicks", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface StrStartBookingViewModel extends GuestsCountClickListener, GuestsCountsProvider, SelectItemClickListenter, SelectItemClearListenter {
    @NotNull
    LiveData<Unit> getAuthScreenChanges();

    @NotNull
    LiveData<String> getErrorMessageChanges();

    @NotNull
    LiveData<List<IntRange>> getGroupsChanges();

    @NotNull
    LiveData<ConfirmBookingEvent> getNextButtonClicks();

    @NotNull
    LiveData<Triple<String, Date, Date>> getSelectDatesChanges();

    void onAuthCompleted();

    void onDatesSelected(boolean z, @Nullable Intent intent);

    void onNextButtonClicked();

    void onRestoreInstanceState(@NotNull Bundle bundle);

    void onSaveInstanceState(@NotNull Bundle bundle);

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);
}
