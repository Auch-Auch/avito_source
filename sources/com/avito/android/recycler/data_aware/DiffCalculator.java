package com.avito.android.recycler.data_aware;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/recycler/data_aware/DiffCalculator;", "", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "oldList", "newList", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "calculateDiff", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/konveyor/data_source/DataSource;)Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "recycler_release"}, k = 1, mv = {1, 4, 2})
public interface DiffCalculator {
    @NotNull
    DiffUtil.DiffResult calculateDiff(@NotNull DataSource<? extends Item> dataSource, @NotNull DataSource<? extends Item> dataSource2);
}
