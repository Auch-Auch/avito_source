package ru.sravni.android.bankproduct.network.profile.response.v2;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileMainDetailRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0001,BM\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b*\u0010+J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJd\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010\u0007R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b#\u0010\u0007R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b$\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b%\u0010\u0007R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b(\u0010\u0007R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b)\u0010\u0007¨\u0006-"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo;", "toProfileMainDetailRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse$ValidationErrorResponse;", "component7", "()Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse$ValidationErrorResponse;", "fullName", InternalConstsKt.PLACEHOLDER, "value", "description", "title", "mask", "validationError", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse$ValidationErrorResponse;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMask", "getValue", "getPlaceholder", "getTitle", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse$ValidationErrorResponse;", "getValidationError", "getFullName", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse$ValidationErrorResponse;)V", "ValidationErrorResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileMainInfoResponse {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("fullName")
    @Nullable
    private final String fullName;
    @SerializedName("mask")
    @Nullable
    private final String mask;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("validationError")
    @Nullable
    private final ValidationErrorResponse validationError;
    @SerializedName("value")
    @Nullable
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse$ValidationErrorResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;", "toValidationErrorRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse$ValidationErrorResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class ValidationErrorResponse {
        @SerializedName("message")
        @NotNull
        private final String message;

        public ValidationErrorResponse(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.message = str;
        }

        public static /* synthetic */ ValidationErrorResponse copy$default(ValidationErrorResponse validationErrorResponse, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validationErrorResponse.message;
            }
            return validationErrorResponse.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final ValidationErrorResponse copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            return new ValidationErrorResponse(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ValidationErrorResponse) && Intrinsics.areEqual(this.message, ((ValidationErrorResponse) obj).message);
            }
            return true;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            String str = this.message;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("ValidationErrorResponse(message="), this.message, ")");
        }

        @NotNull
        public final ProfileMainDetailRepo.ValidationErrorRepo toValidationErrorRepo() {
            return new ProfileMainDetailRepo.ValidationErrorRepo(this.message);
        }
    }

    public ProfileMainInfoResponse(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ValidationErrorResponse validationErrorResponse) {
        this.fullName = str;
        this.placeholder = str2;
        this.value = str3;
        this.description = str4;
        this.title = str5;
        this.mask = str6;
        this.validationError = validationErrorResponse;
    }

    public static /* synthetic */ ProfileMainInfoResponse copy$default(ProfileMainInfoResponse profileMainInfoResponse, String str, String str2, String str3, String str4, String str5, String str6, ValidationErrorResponse validationErrorResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileMainInfoResponse.fullName;
        }
        if ((i & 2) != 0) {
            str2 = profileMainInfoResponse.placeholder;
        }
        if ((i & 4) != 0) {
            str3 = profileMainInfoResponse.value;
        }
        if ((i & 8) != 0) {
            str4 = profileMainInfoResponse.description;
        }
        if ((i & 16) != 0) {
            str5 = profileMainInfoResponse.title;
        }
        if ((i & 32) != 0) {
            str6 = profileMainInfoResponse.mask;
        }
        if ((i & 64) != 0) {
            validationErrorResponse = profileMainInfoResponse.validationError;
        }
        return profileMainInfoResponse.copy(str, str2, str3, str4, str5, str6, validationErrorResponse);
    }

    @Nullable
    public final String component1() {
        return this.fullName;
    }

    @Nullable
    public final String component2() {
        return this.placeholder;
    }

    @Nullable
    public final String component3() {
        return this.value;
    }

    @Nullable
    public final String component4() {
        return this.description;
    }

    @Nullable
    public final String component5() {
        return this.title;
    }

    @Nullable
    public final String component6() {
        return this.mask;
    }

    @Nullable
    public final ValidationErrorResponse component7() {
        return this.validationError;
    }

    @NotNull
    public final ProfileMainInfoResponse copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ValidationErrorResponse validationErrorResponse) {
        return new ProfileMainInfoResponse(str, str2, str3, str4, str5, str6, validationErrorResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileMainInfoResponse)) {
            return false;
        }
        ProfileMainInfoResponse profileMainInfoResponse = (ProfileMainInfoResponse) obj;
        return Intrinsics.areEqual(this.fullName, profileMainInfoResponse.fullName) && Intrinsics.areEqual(this.placeholder, profileMainInfoResponse.placeholder) && Intrinsics.areEqual(this.value, profileMainInfoResponse.value) && Intrinsics.areEqual(this.description, profileMainInfoResponse.description) && Intrinsics.areEqual(this.title, profileMainInfoResponse.title) && Intrinsics.areEqual(this.mask, profileMainInfoResponse.mask) && Intrinsics.areEqual(this.validationError, profileMainInfoResponse.validationError);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getFullName() {
        return this.fullName;
    }

    @Nullable
    public final String getMask() {
        return this.mask;
    }

    @Nullable
    public final String getPlaceholder() {
        return this.placeholder;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final ValidationErrorResponse getValidationError() {
        return this.validationError;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.fullName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.placeholder;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.value;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.title;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mask;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ValidationErrorResponse validationErrorResponse = this.validationError;
        if (validationErrorResponse != null) {
            i = validationErrorResponse.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public final ProfileMainDetailRepo toProfileMainDetailRepo() {
        String str = this.fullName;
        String str2 = this.placeholder;
        String str3 = this.value;
        String str4 = this.description;
        String str5 = this.title;
        String str6 = this.mask;
        ValidationErrorResponse validationErrorResponse = this.validationError;
        return new ProfileMainDetailRepo(str, str2, str3, str4, str5, str6, validationErrorResponse != null ? validationErrorResponse.toValidationErrorRepo() : null);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileMainInfoResponse(fullName=");
        L.append(this.fullName);
        L.append(", placeholder=");
        L.append(this.placeholder);
        L.append(", value=");
        L.append(this.value);
        L.append(", description=");
        L.append(this.description);
        L.append(", title=");
        L.append(this.title);
        L.append(", mask=");
        L.append(this.mask);
        L.append(", validationError=");
        L.append(this.validationError);
        L.append(")");
        return L.toString();
    }
}
