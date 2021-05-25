package com.avito.android.vas_discount.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/vas_discount/di/PickerDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "", "discountContext", "()Ljava/lang/String;", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public interface PickerDependencies extends ComponentDependencies {
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @DiscountContext
    @Nullable
    String discountContext();

    @NotNull
    SchedulersFactory schedulersFactory();
}
