package com.avito.android.advert.consultation_form.data;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.ConsultationRequestResult;
import com.avito.android.remote.model.ContactInfoResponse;
import com.avito.android.remote.model.FormCategory;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.VerifiedByAvitoSuccessRequested;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JI\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepositoryImpl;", "Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepository;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ContactInfoResponse;", "getContactInfo", "()Lio/reactivex/rxjava3/core/Observable;", "", "phone", "name", "url", BookingInfoActivity.EXTRA_ITEM_ID, "developmentId", "Lcom/avito/android/remote/model/ConsultationRequestResult;", "requestConsultation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "api", "Lcom/avito/android/remote/model/ConsultationFormData;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/ConsultationFormData;", "formData", "Lcom/avito/android/remote/ShortTermRentApi;", "c", "Lcom/avito/android/remote/ShortTermRentApi;", "shortTimeRentApi", "<init>", "(Lcom/avito/android/advert_details/remote/AdvertDetailsApi;Lcom/avito/android/remote/model/ConsultationFormData;Lcom/avito/android/remote/ShortTermRentApi;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationFormRepositoryImpl implements ConsultationFormRepository {
    public final AdvertDetailsApi a;
    public final ConsultationFormData b;
    public final ShortTermRentApi c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FormCategory.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            FormCategory formCategory = FormCategory.FindOfficeOffer;
            iArr[1] = 1;
            FormCategory formCategory2 = FormCategory.VerifiedByAvito;
            iArr[2] = 2;
        }
    }

    public static final class a<T, R> implements Function<TypedResult<Unit>, TypedResult<ConsultationRequestResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public TypedResult<ConsultationRequestResult> apply(TypedResult<Unit> typedResult) {
            TypedResult<Unit> typedResult2 = typedResult;
            if ((typedResult2 instanceof TypedResult.OfResult) || typedResult2 == null) {
                return new TypedResult.OfResult(new ConsultationRequestResult.Ok(null, 1, null));
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new TypedResult.OfError(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<TypedResult<VerifiedByAvitoSuccessRequested>, TypedResult<ConsultationRequestResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public TypedResult<ConsultationRequestResult> apply(TypedResult<VerifiedByAvitoSuccessRequested> typedResult) {
            TypedResult<VerifiedByAvitoSuccessRequested> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new TypedResult.OfResult(new ConsultationRequestResult.Ok(((VerifiedByAvitoSuccessRequested) ((TypedResult.OfResult) typedResult2).getResult()).getMessage()));
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new TypedResult.OfError(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public ConsultationFormRepositoryImpl(@NotNull AdvertDetailsApi advertDetailsApi, @Nullable ConsultationFormData consultationFormData, @NotNull ShortTermRentApi shortTermRentApi) {
        Intrinsics.checkNotNullParameter(advertDetailsApi, "api");
        Intrinsics.checkNotNullParameter(shortTermRentApi, "shortTimeRentApi");
        this.a = advertDetailsApi;
        this.b = consultationFormData;
        this.c = shortTermRentApi;
    }

    @Override // com.avito.android.advert.consultation_form.data.ConsultationFormRepository
    @NotNull
    public Observable<TypedResult<ContactInfoResponse>> getContactInfo() {
        return this.a.getContactInfo();
    }

    @Override // com.avito.android.advert.consultation_form.data.ConsultationFormRepository
    @NotNull
    public Observable<TypedResult<ConsultationRequestResult>> requestConsultation(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "name");
        ConsultationFormData consultationFormData = this.b;
        FormCategory category = consultationFormData != null ? consultationFormData.getCategory() : null;
        if (category != null) {
            int ordinal = category.ordinal();
            if (ordinal == 1) {
                Observable<R> map = this.a.sendCreReportsData(str4, str2, str, "findOfficeOffer").map(a.a);
                Intrinsics.checkNotNullExpressionValue(map, "api.sendCreReportsData(\n…      }\n                }");
                return map;
            } else if (ordinal == 2) {
                Observable<R> map2 = this.c.requestAvitoVerification(str2, str).map(b.a);
                Intrinsics.checkNotNullExpressionValue(map2, "shortTimeRentApi.request…      }\n                }");
                return map2;
            }
        }
        return this.a.getAdvice(str, str2, str3, str4, str5);
    }
}
