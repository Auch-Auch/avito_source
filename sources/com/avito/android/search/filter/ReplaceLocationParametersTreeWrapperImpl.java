package com.avito.android.search.filter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapperImpl;", "Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapper;", "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "tree", "Lcom/avito/android/search/filter/LocationInfo;", "locationInfo", "wrap", "(Lcom/avito/android/search/filter/ParametersTreeWithAdditional;Lcom/avito/android/search/filter/LocationInfo;)Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class ReplaceLocationParametersTreeWrapperImpl implements ReplaceLocationParametersTreeWrapper {
    @Override // com.avito.android.search.filter.ReplaceLocationParametersTreeWrapper
    @NotNull
    public ParametersTreeWithAdditional wrap(@NotNull ParametersTreeWithAdditional parametersTreeWithAdditional, @NotNull LocationInfo locationInfo) {
        Intrinsics.checkNotNullParameter(parametersTreeWithAdditional, "tree");
        Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        return new ReplaceLocationParametersTree(parametersTreeWithAdditional, locationInfo, null, 4, null);
    }
}
