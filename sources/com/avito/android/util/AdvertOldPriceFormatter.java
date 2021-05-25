package com.avito.android.util;

import com.avito.android.remote.model.AdvertPrice;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/util/AdvertOldPriceFormatter;", "Lcom/avito/android/util/AdvertPriceFormatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "", "getRawValue", "(Lcom/avito/android/remote/model/AdvertPrice;)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "<init>", "(Ljava/util/Locale;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public class AdvertOldPriceFormatter extends AdvertPriceFormatter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public AdvertOldPriceFormatter(@NotNull Locale locale) {
        super(locale);
        Intrinsics.checkNotNullParameter(locale, "locale");
    }

    @Override // com.avito.android.util.AdvertPriceFormatter
    @Nullable
    public String getRawValue(@NotNull AdvertPrice advertPrice) {
        Intrinsics.checkNotNullParameter(advertPrice, "$this$getRawValue");
        return advertPrice.getOldValue();
    }
}
