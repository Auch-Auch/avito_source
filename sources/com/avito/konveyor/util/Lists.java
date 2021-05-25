package com.avito.konveyor.util;

import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "Lcom/avito/konveyor/data_source/ListDataSource;", "toDataSource", "(Ljava/util/List;)Lcom/avito/konveyor/data_source/ListDataSource;", "konveyor_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Lists")
public final class Lists {
    @NotNull
    public static final <T> ListDataSource<T> toDataSource(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$toDataSource");
        return new ListDataSource<>(list);
    }
}
