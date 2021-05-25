package com.avito.android.brandspace.items.textmeasurement;

import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurer;", "", "", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "items", "Lio/reactivex/rxjava3/core/Single;", "measure", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "item", "(Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;)Lio/reactivex/rxjava3/core/Single;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface ItemsMeasurer {
    @NotNull
    Single<TextMeasurableItem> measure(@NotNull TextMeasurableItem textMeasurableItem);

    @NotNull
    Single<List<TextMeasurableItem>> measure(@NotNull List<? extends TextMeasurableItem> list);
}
