package com.avito.android.advert.consultation_form.di;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.ShortTermRentApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/consultation_form/di/ConsultationFormDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "advertDetailsApi", "()Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "Lcom/avito/android/remote/ShortTermRentApi;", "shortTermRentApi", "()Lcom/avito/android/remote/ShortTermRentApi;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface ConsultationFormDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AdvertDetailsApi advertDetailsApi();

    @NotNull
    DeepLinkIntentFactory getDeepLinkIntentFactory();

    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies
    @NotNull
    ShortTermRentApi shortTermRentApi();
}
