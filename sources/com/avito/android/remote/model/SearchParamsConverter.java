package com.avito.android.remote.model;

import com.avito.android.util.UrlParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\\\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0003\u001a\u00020\u00022#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/SearchParamsConverter;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "key", "keyWrapper", "", "isSubscribeSearch", UrlParams.SIMPLE_MAP, "", "convertToMap", "(Lcom/avito/android/remote/model/SearchParams;Lkotlin/jvm/functions/Function1;ZZ)Ljava/util/Map;", "api_release"}, k = 1, mv = {1, 4, 2})
public interface SearchParamsConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.remote.model.SearchParamsConverter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Map convertToMap$default(SearchParamsConverter searchParamsConverter, SearchParams searchParams, Function1 function1, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function1 = SearchParamsConverter$convertToMap$1.INSTANCE;
                }
                if ((i & 4) != 0) {
                    z = false;
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                return searchParamsConverter.convertToMap(searchParams, function1, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertToMap");
        }
    }

    @NotNull
    Map<String, String> convertToMap(@NotNull SearchParams searchParams, @NotNull Function1<? super String, String> function1, boolean z, boolean z2);
}
