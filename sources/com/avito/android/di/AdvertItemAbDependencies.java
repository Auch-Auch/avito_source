package com.avito.android.di;

import com.avito.android.ab_tests.PriceOnTop;
import com.avito.android.ab_tests.SellerInfoInRichSnippet;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/di/AdvertItemAbDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/PriceOnTopTestGroup;", "priceOnTop", "()Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/SellerInfoInRichSnippetTestGroup;", "sellerInfoInRichSnippet", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "prefetchTestGroup", "()Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertItemAbDependencies extends ComponentDependencies {
    @NotNull
    SerpItemsPrefetchTestGroup prefetchTestGroup();

    @PriceOnTop
    @NotNull
    ExposedAbTestGroup<PriceOnTopTestGroup> priceOnTop();

    @SellerInfoInRichSnippet
    @NotNull
    SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> sellerInfoInRichSnippet();
}
