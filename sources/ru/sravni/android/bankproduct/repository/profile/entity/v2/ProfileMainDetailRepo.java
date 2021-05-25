package ru.sravni.android.bankproduct.repository.profile.entity.v2;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileMainDetailDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001:\u00013BM\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b1\u00102J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJd\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0007R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010\u0007R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b.\u0010\u0007R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b0\u0010\u0007¨\u00064"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain;", "toProfileMainDetailDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;", "component7", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;", "fullName", InternalConstsKt.PLACEHOLDER, "value", "description", "title", "mask", "validationError", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;)Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", g.a, "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;", "getValidationError", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPlaceholder", "c", "getValue", AuthSource.SEND_ABUSE, "getFullName", "e", "getTitle", "f", "getMask", "d", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;)V", "ValidationErrorRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileMainDetailRepo {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final ValidationErrorRepo g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;", "toValidationErrorDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo$ValidationErrorRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class ValidationErrorRepo {
        @NotNull
        public final String a;

        public ValidationErrorRepo(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.a = str;
        }

        public static /* synthetic */ ValidationErrorRepo copy$default(ValidationErrorRepo validationErrorRepo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validationErrorRepo.a;
            }
            return validationErrorRepo.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final ValidationErrorRepo copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            return new ValidationErrorRepo(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ValidationErrorRepo) && Intrinsics.areEqual(this.a, ((ValidationErrorRepo) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("ValidationErrorRepo(message="), this.a, ")");
        }

        @NotNull
        public final ProfileMainDetailDomain.ValidationErrorDomain toValidationErrorDomain() {
            return new ProfileMainDetailDomain.ValidationErrorDomain(this.a);
        }
    }

    public ProfileMainDetailRepo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ValidationErrorRepo validationErrorRepo) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = validationErrorRepo;
    }

    public static /* synthetic */ ProfileMainDetailRepo copy$default(ProfileMainDetailRepo profileMainDetailRepo, String str, String str2, String str3, String str4, String str5, String str6, ValidationErrorRepo validationErrorRepo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileMainDetailRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = profileMainDetailRepo.b;
        }
        if ((i & 4) != 0) {
            str3 = profileMainDetailRepo.c;
        }
        if ((i & 8) != 0) {
            str4 = profileMainDetailRepo.d;
        }
        if ((i & 16) != 0) {
            str5 = profileMainDetailRepo.e;
        }
        if ((i & 32) != 0) {
            str6 = profileMainDetailRepo.f;
        }
        if ((i & 64) != 0) {
            validationErrorRepo = profileMainDetailRepo.g;
        }
        return profileMainDetailRepo.copy(str, str2, str3, str4, str5, str6, validationErrorRepo);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final ValidationErrorRepo component7() {
        return this.g;
    }

    @NotNull
    public final ProfileMainDetailRepo copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ValidationErrorRepo validationErrorRepo) {
        return new ProfileMainDetailRepo(str, str2, str3, str4, str5, str6, validationErrorRepo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileMainDetailRepo)) {
            return false;
        }
        ProfileMainDetailRepo profileMainDetailRepo = (ProfileMainDetailRepo) obj;
        return Intrinsics.areEqual(this.a, profileMainDetailRepo.a) && Intrinsics.areEqual(this.b, profileMainDetailRepo.b) && Intrinsics.areEqual(this.c, profileMainDetailRepo.c) && Intrinsics.areEqual(this.d, profileMainDetailRepo.d) && Intrinsics.areEqual(this.e, profileMainDetailRepo.e) && Intrinsics.areEqual(this.f, profileMainDetailRepo.f) && Intrinsics.areEqual(this.g, profileMainDetailRepo.g);
    }

    @Nullable
    public final String getDescription() {
        return this.d;
    }

    @Nullable
    public final String getFullName() {
        return this.a;
    }

    @Nullable
    public final String getMask() {
        return this.f;
    }

    @Nullable
    public final String getPlaceholder() {
        return this.b;
    }

    @Nullable
    public final String getTitle() {
        return this.e;
    }

    @Nullable
    public final ValidationErrorRepo getValidationError() {
        return this.g;
    }

    @Nullable
    public final String getValue() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ValidationErrorRepo validationErrorRepo = this.g;
        if (validationErrorRepo != null) {
            i = validationErrorRepo.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public final ProfileMainDetailDomain toProfileMainDetailDomain() {
        String str = this.a;
        String str2 = this.b;
        String str3 = this.c;
        String str4 = this.d;
        String str5 = this.e;
        String str6 = this.f;
        ValidationErrorRepo validationErrorRepo = this.g;
        return new ProfileMainDetailDomain(str, str2, str3, str4, str5, str6, validationErrorRepo != null ? validationErrorRepo.toValidationErrorDomain() : null);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileMainDetailRepo(fullName=");
        L.append(this.a);
        L.append(", placeholder=");
        L.append(this.b);
        L.append(", value=");
        L.append(this.c);
        L.append(", description=");
        L.append(this.d);
        L.append(", title=");
        L.append(this.e);
        L.append(", mask=");
        L.append(this.f);
        L.append(", validationError=");
        L.append(this.g);
        L.append(")");
        return L.toString();
    }
}
