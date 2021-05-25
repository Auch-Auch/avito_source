package com.avito.android.search.filter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/search/filter/SimpleAdditionalParameterProvider;", "Lcom/avito/android/search/filter/AdditionalParameterProvider;", "", "id", "Lcom/avito/android/remote/model/category_parameters/AdditionalCategoryParameter;", "findAdditionalParameter", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/AdditionalCategoryParameter;", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "additionalParameters", "<init>", "(Ljava/util/List;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleAdditionalParameterProvider implements AdditionalParameterProvider {
    public final List<AdditionalCategoryParameter> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter> */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleAdditionalParameterProvider(@NotNull List<? extends AdditionalCategoryParameter> list) {
        Intrinsics.checkNotNullParameter(list, "additionalParameters");
        this.a = list;
    }

    @Override // com.avito.android.search.filter.AdditionalParameterProvider
    @Nullable
    public AdditionalCategoryParameter findAdditionalParameter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        for (AdditionalCategoryParameter additionalCategoryParameter : this.a) {
            if (Intrinsics.areEqual(additionalCategoryParameter.getId(), str)) {
                return additionalCategoryParameter;
            }
        }
        return null;
    }
}
