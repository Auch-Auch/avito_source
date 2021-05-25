package com.avito.android.remote.error;

import com.avito.android.remote.model.Error;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R.\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/error/SpecialCase;", "", "", "", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/Error;", "Lcom/avito/android/remote/error/TypedError;", "getSpecialCases", "()Ljava/util/Map;", "specialCases", "api_release"}, k = 1, mv = {1, 4, 2})
public interface SpecialCase {
    @NotNull
    Map<Integer, Function1<Error, TypedError>> getSpecialCases();
}
