package com.avito.android.user_adverts.tab_screens.converters;

import com.avito.android.remote.model.Disclaimer;
import com.avito.android.user_adverts.tab_screens.advert_list.disclaimer.DisclaimerItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverter;", "Lcom/avito/android/remote/model/Disclaimer;", "disclaimer", "Lcom/avito/android/user_adverts/tab_screens/advert_list/disclaimer/DisclaimerItem;", "convert", "(Lcom/avito/android/remote/model/Disclaimer;)Lcom/avito/android/user_adverts/tab_screens/advert_list/disclaimer/DisclaimerItem;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class DisclaimerConverterImpl implements DisclaimerConverter {
    @Override // com.avito.android.user_adverts.tab_screens.converters.DisclaimerConverter
    @NotNull
    public DisclaimerItem convert(@NotNull Disclaimer disclaimer) {
        Intrinsics.checkNotNullParameter(disclaimer, "disclaimer");
        return new DisclaimerItem(disclaimer.getValue());
    }
}
