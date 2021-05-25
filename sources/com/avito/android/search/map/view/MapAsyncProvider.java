package com.avito.android.search.map.view;

import com.avito.android.avito_map.AvitoMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/search/map/view/MapAsyncProvider;", "", "Lkotlin/Function1;", "Lcom/avito/android/avito_map/AvitoMap;", "", "callback", "provideMap", "(Lkotlin/jvm/functions/Function1;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public interface MapAsyncProvider {
    void provideMap(@NotNull Function1<? super AvitoMap, Unit> function1);
}
