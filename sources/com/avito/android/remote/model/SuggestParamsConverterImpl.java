package com.avito.android.remote.model;

import com.avito.android.remote.model.SearchParamsConverter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/SuggestParamsConverterImpl;", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "", "convertToMap", "(Lcom/avito/android/remote/model/SearchParams;)Ljava/util/Map;", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "<init>", "(Lcom/avito/android/remote/model/SearchParamsConverter;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestParamsConverterImpl implements SuggestParamsConverter {
    private final SearchParamsConverter searchParamsConverter;

    @Inject
    public SuggestParamsConverterImpl(@NotNull SearchParamsConverter searchParamsConverter2) {
        Intrinsics.checkNotNullParameter(searchParamsConverter2, "searchParamsConverter");
        this.searchParamsConverter = searchParamsConverter2;
    }

    @Override // com.avito.android.remote.model.SuggestParamsConverter
    @NotNull
    public Map<String, String> convertToMap(@NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        HashMap hashMap = new HashMap(SearchParamsConverter.DefaultImpls.convertToMap$default(this.searchParamsConverter, searchParams, null, false, false, 14, null));
        hashMap.remove("query");
        return hashMap;
    }
}
