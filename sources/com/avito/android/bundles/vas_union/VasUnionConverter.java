package com.avito.android.bundles.vas_union;

import com.avito.android.bundles.vas_union.item.VasUnionConvertInfo;
import com.avito.android.remote.model.VasUnionResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/bundles/vas_union/VasUnionConverter;", "", "Lcom/avito/android/remote/model/VasUnionResult;", "vasUnionResult", "Lcom/avito/android/bundles/vas_union/item/VasUnionConvertInfo;", "convert", "(Lcom/avito/android/remote/model/VasUnionResult;)Lcom/avito/android/bundles/vas_union/item/VasUnionConvertInfo;", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public interface VasUnionConverter {
    @NotNull
    VasUnionConvertInfo convert(@NotNull VasUnionResult vasUnionResult);
}
