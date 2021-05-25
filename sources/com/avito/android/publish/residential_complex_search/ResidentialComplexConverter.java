package com.avito.android.publish.residential_complex_search;

import com.avito.android.remote.model.ResidentialComplexSuggest;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\nJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", "", "", "Lcom/avito/android/remote/model/ResidentialComplexSuggest;", "suggests", "", "searchValue", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/konveyor/blueprint/Item;", "convert", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "convertValues", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ResidentialComplexConverter {
    @NotNull
    ListDataSource<Item> convert(@NotNull List<ResidentialComplexSuggest> list, @Nullable String str);

    @NotNull
    ListDataSource<Item> convertValues(@NotNull List<SelectParameter.Value> list, @Nullable String str);
}
