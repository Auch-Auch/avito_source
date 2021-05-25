package com.avito.android.lib.design.promo_block.grouping;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/lib/design/promo_block/grouping/GroupingListProcessor;", "", "T", "", "list", "fillOutput", "(Ljava/util/List;)Ljava/util/List;", "components_release"}, k = 1, mv = {1, 4, 2})
public interface GroupingListProcessor {
    @NotNull
    <T> List<T> fillOutput(@NotNull List<? extends T> list);
}
