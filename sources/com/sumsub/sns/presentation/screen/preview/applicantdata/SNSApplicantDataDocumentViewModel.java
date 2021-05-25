package com.sumsub.sns.presentation.screen.preview.applicantdata;

import android.util.Patterns;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.integrity.IntegrityManager;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.ApplicantDataField;
import com.sumsub.sns.core.data.model.FieldName;
import com.sumsub.sns.core.data.model.remote.Metavalue;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.GetApplicantUseCase;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.domain.UploadApplicantDataUseCase;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002>?B/\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00160\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R%\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001d0\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R%\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001d0\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\u0018R\"\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00160$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R(\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001d0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010&R(\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001d0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010&¨\u0006@"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel;", "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel;", "", "onDataLoaded", "()V", "onTakeAnotherDataClicked", "", "rotation", "onDataIsReadableClicked", "(I)V", "Lkotlin/sequences/Sequence;", "Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel$ApplicantData;", "data", "submitApplicantData", "(Lkotlin/sequences/Sequence;)V", "Lcom/sumsub/sns/core/data/model/Applicant;", "Lcom/sumsub/sns/core/data/model/ApplicantDataField$Field;", AnalyticFieldsName.field, "", "d", "(Lcom/sumsub/sns/core/data/model/Applicant;Lcom/sumsub/sns/core/data/model/ApplicantDataField$Field;)Ljava/lang/String;", "Landroidx/lifecycle/LiveData;", "", "getFields", "()Landroidx/lifecycle/LiveData;", "fields", "Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel$ApplicantDataError;", "getErrors", "errors", "", "getCountries", "countries", "Lcom/sumsub/sns/domain/UploadApplicantDataUseCase;", "C", "Lcom/sumsub/sns/domain/UploadApplicantDataUseCase;", "uploadApplicantDataUseCase", "Landroidx/lifecycle/MutableLiveData;", "y", "Landroidx/lifecycle/MutableLiveData;", "_fieldErrorLiveData", "getGenders", "genders", "x", "_fieldsLiveData", "Ljava/text/SimpleDateFormat;", "B", "Ljava/text/SimpleDateFormat;", "backEndDateFormat", "z", "_gendersLiveData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "_countriesLiveData", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "getApplicantUseCase", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/sumsub/sns/core/domain/GetApplicantUseCase;Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/domain/UploadApplicantDataUseCase;)V", "ApplicantData", "ApplicantDataError", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSApplicantDataDocumentViewModel extends SNSBaseDocumentPreviewViewModel {
    public final MutableLiveData<Map<String, String>> A = new MutableLiveData<>();
    public final SimpleDateFormat B;
    public final UploadApplicantDataUseCase C;
    public final MutableLiveData<List<ApplicantData>> x = new MutableLiveData<>();
    public final MutableLiveData<List<ApplicantDataError>> y = new MutableLiveData<>();
    public final MutableLiveData<Map<String, String>> z = new MutableLiveData<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel$ApplicantData;", "", "Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "component1", "()Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "", "component2", "()Ljava/lang/String;", AnalyticFieldsName.field, "value", "copy", "(Lcom/sumsub/sns/core/data/model/ApplicantDataField;Ljava/lang/String;)Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel$ApplicantData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "getField", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getValue", "<init>", "(Lcom/sumsub/sns/core/data/model/ApplicantDataField;Ljava/lang/String;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class ApplicantData {
        @NotNull
        public final ApplicantDataField a;
        @NotNull
        public final String b;

        public ApplicantData(@NotNull ApplicantDataField applicantDataField, @NotNull String str) {
            Intrinsics.checkNotNullParameter(applicantDataField, AnalyticFieldsName.field);
            Intrinsics.checkNotNullParameter(str, "value");
            this.a = applicantDataField;
            this.b = str;
        }

        public static /* synthetic */ ApplicantData copy$default(ApplicantData applicantData, ApplicantDataField applicantDataField, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                applicantDataField = applicantData.a;
            }
            if ((i & 2) != 0) {
                str = applicantData.b;
            }
            return applicantData.copy(applicantDataField, str);
        }

        @NotNull
        public final ApplicantDataField component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final ApplicantData copy(@NotNull ApplicantDataField applicantDataField, @NotNull String str) {
            Intrinsics.checkNotNullParameter(applicantDataField, AnalyticFieldsName.field);
            Intrinsics.checkNotNullParameter(str, "value");
            return new ApplicantData(applicantDataField, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApplicantData)) {
                return false;
            }
            ApplicantData applicantData = (ApplicantData) obj;
            return Intrinsics.areEqual(this.a, applicantData.a) && Intrinsics.areEqual(this.b, applicantData.b);
        }

        @NotNull
        public final ApplicantDataField getField() {
            return this.a;
        }

        @NotNull
        public final String getValue() {
            return this.b;
        }

        public int hashCode() {
            ApplicantDataField applicantDataField = this.a;
            int i = 0;
            int hashCode = (applicantDataField != null ? applicantDataField.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ApplicantData(field=");
            L.append(this.a);
            L.append(", value=");
            return a2.b.a.a.a.t(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel$ApplicantDataError;", "", "Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "component1", "()Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "", "component2", "()I", AnalyticFieldsName.field, "error", "copy", "(Lcom/sumsub/sns/core/data/model/ApplicantDataField;I)Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel$ApplicantDataError;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "getField", AuthSource.BOOKING_ORDER, "I", "getError", "<init>", "(Lcom/sumsub/sns/core/data/model/ApplicantDataField;I)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class ApplicantDataError {
        @NotNull
        public final ApplicantDataField a;
        public final int b;

        public ApplicantDataError(@NotNull ApplicantDataField applicantDataField, int i) {
            Intrinsics.checkNotNullParameter(applicantDataField, AnalyticFieldsName.field);
            this.a = applicantDataField;
            this.b = i;
        }

        public static /* synthetic */ ApplicantDataError copy$default(ApplicantDataError applicantDataError, ApplicantDataField applicantDataField, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                applicantDataField = applicantDataError.a;
            }
            if ((i2 & 2) != 0) {
                i = applicantDataError.b;
            }
            return applicantDataError.copy(applicantDataField, i);
        }

        @NotNull
        public final ApplicantDataField component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final ApplicantDataError copy(@NotNull ApplicantDataField applicantDataField, int i) {
            Intrinsics.checkNotNullParameter(applicantDataField, AnalyticFieldsName.field);
            return new ApplicantDataError(applicantDataField, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApplicantDataError)) {
                return false;
            }
            ApplicantDataError applicantDataError = (ApplicantDataError) obj;
            return Intrinsics.areEqual(this.a, applicantDataError.a) && this.b == applicantDataError.b;
        }

        public final int getError() {
            return this.b;
        }

        @NotNull
        public final ApplicantDataField getField() {
            return this.a;
        }

        public int hashCode() {
            ApplicantDataField applicantDataField = this.a;
            return ((applicantDataField != null ? applicantDataField.hashCode() : 0) * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ApplicantDataError(field=");
            L.append(this.a);
            L.append(", error=");
            return a2.b.a.a.a.j(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FieldName.values();
            int[] iArr = new int[25];
            $EnumSwitchMapping$0 = iArr;
            FieldName fieldName = FieldName.firstName;
            iArr[0] = 1;
            FieldName fieldName2 = FieldName.lastName;
            iArr[1] = 2;
            FieldName fieldName3 = FieldName.middleName;
            iArr[2] = 3;
            FieldName fieldName4 = FieldName.phone;
            iArr[4] = 4;
            FieldName fieldName5 = FieldName.countryOfBirth;
            iArr[5] = 5;
            FieldName fieldName6 = FieldName.stateOfBirth;
            iArr[6] = 6;
            FieldName fieldName7 = FieldName.placeOfBirth;
            iArr[8] = 7;
            FieldName fieldName8 = FieldName.legalName;
            iArr[9] = 8;
            FieldName fieldName9 = FieldName.gender;
            iArr[10] = 9;
            FieldName fieldName10 = FieldName.nationality;
            iArr[11] = 10;
            FieldName fieldName11 = FieldName.country;
            iArr[12] = 11;
            FieldName fieldName12 = FieldName.dob;
            iArr[7] = 12;
            FieldName fieldName13 = FieldName.email;
            iArr[3] = 13;
            FieldName fieldName14 = FieldName.buildingNumber;
            iArr[15] = 14;
            FieldName fieldName15 = FieldName.flatNumber;
            iArr[16] = 15;
            FieldName fieldName16 = FieldName.postCode;
            iArr[19] = 16;
            FieldName fieldName17 = FieldName.state;
            iArr[18] = 17;
            FieldName fieldName18 = FieldName.street;
            iArr[13] = 18;
            FieldName fieldName19 = FieldName.subStreet;
            iArr[14] = 19;
            FieldName fieldName20 = FieldName.town;
            iArr[17] = 20;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$submitApplicantData$1", f = "SNSApplicantDataDocumentViewModel.kt", i = {0, 0, 0, 0, 0, 0, 1}, l = {108, 130}, m = "invokeSuspend", n = {"$this$launch", "this_$iv", "fields", "customFields", "fieldsValues", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "this_$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public int h;
        public final /* synthetic */ SNSApplicantDataDocumentViewModel i;
        public final /* synthetic */ Sequence j;

        /* compiled from: kotlin-style lambda group */
        /* renamed from: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$a$a  reason: collision with other inner class name */
        public static final class C0319a extends Lambda implements Function1<ApplicantData, String> {
            public static final C0319a b = new C0319a(0);
            public static final C0319a c = new C0319a(1);
            public final /* synthetic */ int a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0319a(int i) {
                super(1);
                this.a = i;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ApplicantData applicantData) {
                int i = this.a;
                if (i == 0) {
                    ApplicantData applicantData2 = applicantData;
                    Intrinsics.checkNotNullParameter(applicantData2, "it");
                    ApplicantDataField field = applicantData2.getField();
                    Objects.requireNonNull(field, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.ApplicantDataField.Field");
                    return ((ApplicantDataField.Field) field).getName().getValue();
                } else if (i == 1) {
                    ApplicantData applicantData3 = applicantData;
                    Intrinsics.checkNotNullParameter(applicantData3, "it");
                    ApplicantDataField field2 = applicantData3.getField();
                    Objects.requireNonNull(field2, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.ApplicantDataField.Field");
                    return ((ApplicantDataField.Field) field2).getName().getValue();
                } else {
                    throw null;
                }
            }
        }

        /* compiled from: kotlin-style lambda group */
        public static final class b extends Lambda implements Function1<ApplicantData, Boolean> {
            public static final b b = new b(0);
            public static final b c = new b(1);
            public final /* synthetic */ int a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(int i) {
                super(1);
                this.a = i;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ApplicantData applicantData) {
                int i = this.a;
                boolean z = false;
                if (i == 0) {
                    ApplicantData applicantData2 = applicantData;
                    Intrinsics.checkNotNullParameter(applicantData2, "it");
                    if (applicantData2.getValue().length() > 0) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                } else if (i == 1) {
                    ApplicantData applicantData3 = applicantData;
                    Intrinsics.checkNotNullParameter(applicantData3, "it");
                    if (applicantData3.getValue().length() > 0) {
                        ApplicantDataField field = applicantData3.getField();
                        Objects.requireNonNull(field, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.ApplicantDataField.Field");
                        if (((ApplicantDataField.Field) field).isAddressRelated()) {
                            z = true;
                        }
                    }
                    return Boolean.valueOf(z);
                } else {
                    throw null;
                }
            }
        }

        /* compiled from: kotlin-style lambda group */
        public static final class c extends Lambda implements Function1<ApplicantData, Boolean> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;
            public final /* synthetic */ Object c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(int i, Object obj, Object obj2) {
                super(1);
                this.a = i;
                this.b = obj;
                this.c = obj2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ApplicantData applicantData) {
                int i = this.a;
                if (i == 0) {
                    ApplicantData applicantData2 = applicantData;
                    Intrinsics.checkNotNullParameter(applicantData2, "it");
                    return Boolean.valueOf(SNSApplicantDataDocumentViewModel.access$isInfoRelatedAndNeedsUnset(((a) this.b).i, applicantData2.getField(), ((a) this.b).i.getApplicant(), applicantData2.getValue()));
                } else if (i == 1) {
                    ApplicantData applicantData3 = applicantData;
                    Intrinsics.checkNotNullParameter(applicantData3, "it");
                    return Boolean.valueOf(SNSApplicantDataDocumentViewModel.access$isCoreRelatedAndNeedsUnset(((a) this.b).i, applicantData3.getField(), ((a) this.b).i.getApplicant(), applicantData3.getValue()));
                } else {
                    throw null;
                }
            }
        }

        public static final class d extends Lambda implements Function1<ApplicantData, Pair<? extends String, ? extends String>> {
            public static final d a = new d();

            public d() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Pair<? extends String, ? extends String> invoke(ApplicantData applicantData) {
                ApplicantData applicantData2 = applicantData;
                Intrinsics.checkNotNullParameter(applicantData2, "it");
                ApplicantDataField field = applicantData2.getField();
                Objects.requireNonNull(field, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.ApplicantDataField.Field");
                return TuplesKt.to(((ApplicantDataField.Field) field).getName().getValue(), applicantData2.getValue());
            }
        }

        public static final class e extends Lambda implements Function1<ApplicantData, Metavalue> {
            public static final e a = new e();

            public e() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Metavalue invoke(ApplicantData applicantData) {
                ApplicantData applicantData2 = applicantData;
                Intrinsics.checkNotNullParameter(applicantData2, "it");
                ApplicantDataField field = applicantData2.getField();
                Objects.requireNonNull(field, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.ApplicantDataField.CustomField");
                return new Metavalue(((ApplicantDataField.CustomField) field).getName(), applicantData2.getValue());
            }
        }

        public static final class f extends Lambda implements Function1<ApplicantData, ApplicantDataError> {
            public final /* synthetic */ a a;
            public final /* synthetic */ CoroutineScope b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(a aVar, CoroutineScope coroutineScope) {
                super(1);
                this.a = aVar;
                this.b = coroutineScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public ApplicantDataError invoke(ApplicantData applicantData) {
                ApplicantData applicantData2 = applicantData;
                Intrinsics.checkNotNullParameter(applicantData2, "data");
                Integer access$isValid = SNSApplicantDataDocumentViewModel.access$isValid(this.a.i, applicantData2.getField(), applicantData2.getValue());
                if (access$isValid == null) {
                    return null;
                }
                return new ApplicantDataError(applicantData2.getField(), access$isValid.intValue());
            }
        }

        public static final class g extends Lambda implements Function1<ApplicantData, Pair<? extends String, ? extends String>> {
            public final /* synthetic */ a a;
            public final /* synthetic */ CoroutineScope b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(a aVar, CoroutineScope coroutineScope) {
                super(1);
                this.a = aVar;
                this.b = coroutineScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Pair<? extends String, ? extends String> invoke(ApplicantData applicantData) {
                ApplicantData applicantData2 = applicantData;
                Intrinsics.checkNotNullParameter(applicantData2, "it");
                ApplicantDataField field = applicantData2.getField();
                Objects.requireNonNull(field, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.ApplicantDataField.Field");
                String value = ((ApplicantDataField.Field) field).getName().getValue();
                String access$toBackendFormat = SNSApplicantDataDocumentViewModel.access$toBackendFormat(this.a.i, (ApplicantDataField.Field) applicantData2.getField(), applicantData2.getValue());
                if (access$toBackendFormat == null) {
                    access$toBackendFormat = "";
                }
                return TuplesKt.to(value, access$toBackendFormat);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSApplicantDataDocumentViewModel sNSApplicantDataDocumentViewModel, Sequence sequence, Continuation continuation) {
            super(2, continuation);
            this.i = sNSApplicantDataDocumentViewModel;
            this.j = sequence;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.i, this.j, continuation);
            aVar.b = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            a aVar = new a(this.i, this.j, continuation2);
            aVar.b = coroutineScope;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:66:0x0228  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x022e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
            /*
            // Method dump skipped, instructions count: 634
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSApplicantDataDocumentViewModel(@NotNull SavedStateHandle savedStateHandle, @NotNull GetConfigUseCase getConfigUseCase, @NotNull GetApplicantUseCase getApplicantUseCase, @NotNull CommonRepository commonRepository, @NotNull UploadApplicantDataUseCase uploadApplicantDataUseCase) {
        super(savedStateHandle, getConfigUseCase, getApplicantUseCase, commonRepository);
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(getApplicantUseCase, "getApplicantUseCase");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(uploadApplicantDataUseCase, "uploadApplicantDataUseCase");
        this.C = uploadApplicantDataUseCase;
        onLoad();
        this.B = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static final boolean access$isCoreRelatedAndNeedsUnset(SNSApplicantDataDocumentViewModel sNSApplicantDataDocumentViewModel, ApplicantDataField applicantDataField, Applicant applicant, String str) {
        String d;
        Objects.requireNonNull(sNSApplicantDataDocumentViewModel);
        if (!(applicantDataField instanceof ApplicantDataField.Field)) {
            applicantDataField = null;
        }
        ApplicantDataField.Field field = (ApplicantDataField.Field) applicantDataField;
        if (field == null || !field.isCoreRelated()) {
            return false;
        }
        if (!(str.length() == 0) || (d = sNSApplicantDataDocumentViewModel.d(applicant, field)) == null) {
            return false;
        }
        if (d.length() > 0) {
            return true;
        }
        return false;
    }

    public static final boolean access$isInfoRelatedAndNeedsUnset(SNSApplicantDataDocumentViewModel sNSApplicantDataDocumentViewModel, ApplicantDataField applicantDataField, Applicant applicant, String str) {
        String d;
        Objects.requireNonNull(sNSApplicantDataDocumentViewModel);
        if (!(applicantDataField instanceof ApplicantDataField.Field)) {
            applicantDataField = null;
        }
        ApplicantDataField.Field field = (ApplicantDataField.Field) applicantDataField;
        if (field == null || !field.isInfoRelated()) {
            return false;
        }
        if (!(str.length() == 0) || (d = sNSApplicantDataDocumentViewModel.d(applicant, field)) == null) {
            return false;
        }
        if (d.length() > 0) {
            return true;
        }
        return false;
    }

    public static final Integer access$isValid(SNSApplicantDataDocumentViewModel sNSApplicantDataDocumentViewModel, ApplicantDataField applicantDataField, String str) {
        Objects.requireNonNull(sNSApplicantDataDocumentViewModel);
        boolean z2 = true;
        if (applicantDataField instanceof ApplicantDataField.Field) {
            ApplicantDataField.Field field = (ApplicantDataField.Field) applicantDataField;
            boolean z3 = false;
            if (field.isRequired()) {
                if (str.length() == 0) {
                    return Integer.valueOf(R.string.sns_data_error_fieldIsRequired);
                }
            }
            if (field.getName() == FieldName.dob) {
                if (str.length() > 0) {
                    try {
                        Date parse = SimpleDateFormat.getDateInstance().parse(str);
                        if (parse == null) {
                            return null;
                        }
                        Calendar instance = Calendar.getInstance();
                        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
                        if (parse.compareTo(instance.getTime()) < 0) {
                            z2 = false;
                        }
                        if (!z2) {
                            parse = null;
                        }
                        if (parse != null) {
                            return Integer.valueOf(R.string.sns_data_error_fieldIsMalformed);
                        }
                        return null;
                    } catch (Exception unused) {
                        return Integer.valueOf(R.string.sns_data_error_fieldIsMalformed);
                    }
                }
            }
            if (field.getName() != FieldName.email) {
                return null;
            }
            if (str.length() > 0) {
                z3 = true;
            }
            if (!z3) {
                return null;
            }
            Boolean valueOf = Boolean.valueOf(Patterns.EMAIL_ADDRESS.matcher(str).matches());
            if (!(!valueOf.booleanValue())) {
                valueOf = null;
            }
            if (valueOf == null) {
                return null;
            }
            valueOf.booleanValue();
            return Integer.valueOf(R.string.sns_data_error_fieldIsMalformed);
        } else if (applicantDataField instanceof ApplicantDataField.CustomField) {
            ApplicantDataField.CustomField customField = (ApplicantDataField.CustomField) applicantDataField;
            if ((!m.isBlank(str)) || !customField.isRequired()) {
                return null;
            }
            return Integer.valueOf(R.string.sns_data_error_fieldIsRequired);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final String access$toBackendFormat(SNSApplicantDataDocumentViewModel sNSApplicantDataDocumentViewModel, ApplicantDataField.Field field, String str) {
        Objects.requireNonNull(sNSApplicantDataDocumentViewModel);
        if (field.getName() != FieldName.dob) {
            return str;
        }
        Date parse = SimpleDateFormat.getDateInstance().parse(str);
        if (parse != null) {
            return sNSApplicantDataDocumentViewModel.B.format(parse);
        }
        return null;
    }

    public final String d(Applicant applicant, ApplicantDataField.Field field) {
        List<Map<String, String>> addresses;
        Map map;
        String country;
        String dob;
        List<Map<String, String>> addresses2;
        Map map2;
        switch (field.getName().ordinal()) {
            case 0:
                Applicant.Info info = applicant.getInfo();
                if (info != null) {
                    return info.getFirstName();
                }
                return null;
            case 1:
                Applicant.Info info2 = applicant.getInfo();
                if (info2 != null) {
                    return info2.getLastName();
                }
                return null;
            case 2:
                Applicant.Info info3 = applicant.getInfo();
                if (info3 != null) {
                    return info3.getMiddleName();
                }
                return null;
            case 3:
                return applicant.getEmail();
            case 4:
                Applicant.Info info4 = applicant.getInfo();
                if (info4 != null) {
                    return info4.getPhone();
                }
                return null;
            case 5:
                Applicant.Info info5 = applicant.getInfo();
                if (info5 != null) {
                    return info5.getCountryOfBirth();
                }
                return null;
            case 6:
                Applicant.Info info6 = applicant.getInfo();
                if (info6 != null) {
                    return info6.getStateOfBirth();
                }
                return null;
            case 7:
                Applicant.Info info7 = applicant.getInfo();
                if (info7 == null || (dob = info7.getDob()) == null) {
                    return null;
                }
                try {
                    Date parse = this.B.parse(dob);
                    if (parse != null) {
                        return SimpleDateFormat.getDateInstance().format(parse);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            case 8:
                Applicant.Info info8 = applicant.getInfo();
                if (info8 != null) {
                    return info8.getPlaceOfBirth();
                }
                return null;
            case 9:
                Applicant.Info info9 = applicant.getInfo();
                if (info9 != null) {
                    return info9.getLegalName();
                }
                return null;
            case 10:
                Applicant.Info info10 = applicant.getInfo();
                if (info10 != null) {
                    return info10.getGender();
                }
                return null;
            case 11:
                Applicant.Info info11 = applicant.getInfo();
                if (info11 != null) {
                    return info11.getNationality();
                }
                return null;
            case 12:
                Applicant.Info info12 = applicant.getInfo();
                if (info12 != null && (country = info12.getCountry()) != null) {
                    return country;
                }
                Applicant.Info info13 = applicant.getInfo();
                if (info13 == null || (addresses = info13.getAddresses()) == null || (map = (Map) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) addresses)) == null) {
                    return null;
                }
                return (String) map.get(field.getName().getValue());
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                Applicant.Info info14 = applicant.getInfo();
                if (info14 == null || (addresses2 = info14.getAddresses()) == null || (map2 = (Map) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) addresses2)) == null) {
                    return null;
                }
                return (String) map2.get(field.getName().getValue());
            default:
                return null;
        }
    }

    @NotNull
    public final LiveData<Map<String, String>> getCountries() {
        return this.A;
    }

    @NotNull
    public final LiveData<List<ApplicantDataError>> getErrors() {
        return this.y;
    }

    @NotNull
    public final LiveData<List<ApplicantData>> getFields() {
        return this.x;
    }

    @NotNull
    public final LiveData<Map<String, String>> getGenders() {
        return this.z;
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onDataIsReadableClicked(int i) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x018c A[SYNTHETIC] */
    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDataLoaded() {
        /*
        // Method dump skipped, instructions count: 429
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel.onDataLoaded():void");
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onTakeAnotherDataClicked() {
    }

    public final void submitApplicantData(@NotNull Sequence<ApplicantData> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "data");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a(this, sequence, null), 3, null);
    }
}
