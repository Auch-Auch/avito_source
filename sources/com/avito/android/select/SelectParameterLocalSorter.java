package com.avito.android.select;

import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.SortDirection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J7\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/select/SelectParameterLocalSorter;", "", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "unsorted", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", "direction", "sort", "(Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SortDirection;)Ljava/util/List;", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectParameterLocalSorter {
    @NotNull
    List<ParcelableEntity<String>> sort(@NotNull List<? extends ParcelableEntity<String>> list, @NotNull SortDirection sortDirection);
}
