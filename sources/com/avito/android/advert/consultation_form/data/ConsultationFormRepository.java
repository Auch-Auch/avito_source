package com.avito.android.advert.consultation_form.data;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.ConsultationRequestResult;
import com.avito.android.remote.model.ContactInfoResponse;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JI\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepository;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ContactInfoResponse;", "getContactInfo", "()Lio/reactivex/rxjava3/core/Observable;", "", "phone", "name", "url", BookingInfoActivity.EXTRA_ITEM_ID, "developmentId", "Lcom/avito/android/remote/model/ConsultationRequestResult;", "requestConsultation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface ConsultationFormRepository {
    @NotNull
    Observable<TypedResult<ContactInfoResponse>> getContactInfo();

    @NotNull
    Observable<TypedResult<ConsultationRequestResult>> requestConsultation(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5);
}
