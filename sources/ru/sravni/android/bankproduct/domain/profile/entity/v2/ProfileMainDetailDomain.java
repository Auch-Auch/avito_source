package ru.sravni.android.bankproduct.domain.profile.entity.v2;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001:\u00010BM\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b.\u0010/J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJd\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\f¨\u00061"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;", "component7", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;", "fullName", InternalConstsKt.PLACEHOLDER, "value", "description", "title", "mask", "validationError", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getValue", "e", "getTitle", "f", "getMask", AuthSource.SEND_ABUSE, "getFullName", AuthSource.BOOKING_ORDER, "getPlaceholder", "d", "getDescription", g.a, "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;", "getValidationError", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;)V", "ValidationErrorDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileMainDetailDomain {
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
    public final ValidationErrorDomain g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;", "", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain$ValidationErrorDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class ValidationErrorDomain {
        @NotNull
        public final String a;

        public ValidationErrorDomain(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.a = str;
        }

        public static /* synthetic */ ValidationErrorDomain copy$default(ValidationErrorDomain validationErrorDomain, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validationErrorDomain.a;
            }
            return validationErrorDomain.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final ValidationErrorDomain copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            return new ValidationErrorDomain(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ValidationErrorDomain) && Intrinsics.areEqual(this.a, ((ValidationErrorDomain) obj).a);
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
            return a.t(a.L("ValidationErrorDomain(message="), this.a, ")");
        }
    }

    public ProfileMainDetailDomain(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ValidationErrorDomain validationErrorDomain) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = validationErrorDomain;
    }

    public static /* synthetic */ ProfileMainDetailDomain copy$default(ProfileMainDetailDomain profileMainDetailDomain, String str, String str2, String str3, String str4, String str5, String str6, ValidationErrorDomain validationErrorDomain, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileMainDetailDomain.a;
        }
        if ((i & 2) != 0) {
            str2 = profileMainDetailDomain.b;
        }
        if ((i & 4) != 0) {
            str3 = profileMainDetailDomain.c;
        }
        if ((i & 8) != 0) {
            str4 = profileMainDetailDomain.d;
        }
        if ((i & 16) != 0) {
            str5 = profileMainDetailDomain.e;
        }
        if ((i & 32) != 0) {
            str6 = profileMainDetailDomain.f;
        }
        if ((i & 64) != 0) {
            validationErrorDomain = profileMainDetailDomain.g;
        }
        return profileMainDetailDomain.copy(str, str2, str3, str4, str5, str6, validationErrorDomain);
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
    public final ValidationErrorDomain component7() {
        return this.g;
    }

    @NotNull
    public final ProfileMainDetailDomain copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ValidationErrorDomain validationErrorDomain) {
        return new ProfileMainDetailDomain(str, str2, str3, str4, str5, str6, validationErrorDomain);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileMainDetailDomain)) {
            return false;
        }
        ProfileMainDetailDomain profileMainDetailDomain = (ProfileMainDetailDomain) obj;
        return Intrinsics.areEqual(this.a, profileMainDetailDomain.a) && Intrinsics.areEqual(this.b, profileMainDetailDomain.b) && Intrinsics.areEqual(this.c, profileMainDetailDomain.c) && Intrinsics.areEqual(this.d, profileMainDetailDomain.d) && Intrinsics.areEqual(this.e, profileMainDetailDomain.e) && Intrinsics.areEqual(this.f, profileMainDetailDomain.f) && Intrinsics.areEqual(this.g, profileMainDetailDomain.g);
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
    public final ValidationErrorDomain getValidationError() {
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
        ValidationErrorDomain validationErrorDomain = this.g;
        if (validationErrorDomain != null) {
            i = validationErrorDomain.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileMainDetailDomain(fullName=");
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
