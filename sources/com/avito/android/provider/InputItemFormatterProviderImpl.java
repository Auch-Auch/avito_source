package com.avito.android.provider;

import com.avito.android.common.InputFormatter;
import com.avito.android.phone.HyphenPhoneFormatter;
import com.avito.android.price.PriceInputFormatterImpl;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.category_parameters.FormatterType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/provider/InputItemFormatterProviderImpl;", "Lcom/avito/android/provider/InputItemFormatterProvider;", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "displayingOptions", "Lcom/avito/android/common/InputFormatter;", "provide", "(Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;)Lcom/avito/android/common/InputFormatter;", "<init>", "()V", "formatters-provider_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemFormatterProviderImpl implements InputItemFormatterProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FormatterType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            FormatterType formatterType = FormatterType.PHONE;
            iArr[0] = 1;
            FormatterType formatterType2 = FormatterType.PRICE;
            iArr[1] = 2;
        }
    }

    @Override // com.avito.android.provider.InputItemFormatterProvider
    @Nullable
    public InputFormatter provide(@Nullable DisplayingOptions displayingOptions) {
        FormatterType formatter;
        if (displayingOptions == null || (formatter = displayingOptions.getFormatter()) == null) {
            return null;
        }
        int ordinal = formatter.ordinal();
        if (ordinal == 0) {
            return new HyphenPhoneFormatter(displayingOptions.getLength());
        }
        if (ordinal == 1) {
            return new PriceInputFormatterImpl();
        }
        throw new NoWhenBranchMatchedException();
    }
}
