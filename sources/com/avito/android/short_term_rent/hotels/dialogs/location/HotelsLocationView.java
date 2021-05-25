package com.avito.android.short_term_rent.hotels.dialogs.location;

import com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\b\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationView;", "Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialogView;", "", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItem;", "items", "", "setItemsView", "(Ljava/util/List;)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lio/reactivex/rxjava3/annotations/NonNull;", "selectAction", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface HotelsLocationView extends HotelsFiltersDialogView {
    @Nullable
    PublishRelay<HotelsLocationDialogItem> selectAction();

    void setItemsView(@NotNull List<HotelsLocationDialogItem> list);
}
