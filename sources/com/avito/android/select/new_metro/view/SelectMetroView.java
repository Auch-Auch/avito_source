package com.avito.android.select.new_metro.view;

import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/select/new_metro/view/SelectMetroView;", "", "", "showed", "", "onKeyboardShowed", "(Z)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "items", "onItemsChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "", "selectedStationsId", "onSelectedStationsChanged", "(Ljava/util/List;)V", "onDropText", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectMetroView {
    void onDropText();

    void onItemsChanged(@NotNull DataSource<Item> dataSource);

    void onKeyboardShowed(boolean z);

    void onSelectedStationsChanged(@NotNull List<Integer> list);
}
