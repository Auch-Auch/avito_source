package com.avito.android.search.filter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.common.InputFormatter;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/search/filter/InputItemFormatterProviderImpl;", "Lcom/avito/android/search/filter/InputItemFormatterProvider;", "Lcom/avito/android/category_parameters/ParameterElement$Format;", "format", "Lcom/avito/android/common/InputFormatter;", "provide", "(Lcom/avito/android/category_parameters/ParameterElement$Format;)Lcom/avito/android/common/InputFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/common/InputFormatter;", "priceFormatter", "<init>", "(Lcom/avito/android/common/InputFormatter;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemFormatterProviderImpl implements InputItemFormatterProvider {
    public final InputFormatter a;

    @Inject
    public InputItemFormatterProviderImpl(@NotNull InputFormatter inputFormatter) {
        Intrinsics.checkNotNullParameter(inputFormatter, "priceFormatter");
        this.a = inputFormatter;
    }

    @Override // com.avito.android.search.filter.InputItemFormatterProvider
    @Nullable
    public InputFormatter provide(@Nullable ParameterElement.Format format) {
        if (format instanceof ParameterElement.Format.Price) {
            return this.a;
        }
        if (format == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
