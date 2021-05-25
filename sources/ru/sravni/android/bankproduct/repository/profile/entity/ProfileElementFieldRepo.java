package ru.sravni.android.bankproduct.repository.profile.entity;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileElementFieldDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b'\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b5\u00106J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jf\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u0018\u0010\u000eR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010$\u001a\u0004\b0\u0010\u0007R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010$\u001a\u0004\b2\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u0010\u0007¨\u00067"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileElementFieldDomain;", "toDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/ProfileElementFieldDomain;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Z", "component7", "", "component8", "()Ljava/lang/Integer;", "fieldName", MessageMetaInfo.COLUMN_PATH, "value", "description", "label", "isEditable", "mask", "order", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPath", "h", "Ljava/lang/Integer;", "getOrder", g.a, "getMask", "d", "getDescription", "f", "Z", AuthSource.SEND_ABUSE, "getFieldName", "c", "getValue", "e", "getLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileElementFieldRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    public final boolean f;
    @Nullable
    public final String g;
    @Nullable
    public final Integer h;

    public ProfileElementFieldRepo(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, boolean z, @Nullable String str6, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "fieldName");
        Intrinsics.checkParameterIsNotNull(str2, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkParameterIsNotNull(str4, "description");
        Intrinsics.checkParameterIsNotNull(str5, "label");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = z;
        this.g = str6;
        this.h = num;
    }

    public static /* synthetic */ ProfileElementFieldRepo copy$default(ProfileElementFieldRepo profileElementFieldRepo, String str, String str2, String str3, String str4, String str5, boolean z, String str6, Integer num, int i, Object obj) {
        return profileElementFieldRepo.copy((i & 1) != 0 ? profileElementFieldRepo.a : str, (i & 2) != 0 ? profileElementFieldRepo.b : str2, (i & 4) != 0 ? profileElementFieldRepo.c : str3, (i & 8) != 0 ? profileElementFieldRepo.d : str4, (i & 16) != 0 ? profileElementFieldRepo.e : str5, (i & 32) != 0 ? profileElementFieldRepo.f : z, (i & 64) != 0 ? profileElementFieldRepo.g : str6, (i & 128) != 0 ? profileElementFieldRepo.h : num);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @Nullable
    public final Integer component8() {
        return this.h;
    }

    @NotNull
    public final ProfileElementFieldRepo copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, boolean z, @Nullable String str6, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "fieldName");
        Intrinsics.checkParameterIsNotNull(str2, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkParameterIsNotNull(str4, "description");
        Intrinsics.checkParameterIsNotNull(str5, "label");
        return new ProfileElementFieldRepo(str, str2, str3, str4, str5, z, str6, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileElementFieldRepo)) {
            return false;
        }
        ProfileElementFieldRepo profileElementFieldRepo = (ProfileElementFieldRepo) obj;
        return Intrinsics.areEqual(this.a, profileElementFieldRepo.a) && Intrinsics.areEqual(this.b, profileElementFieldRepo.b) && Intrinsics.areEqual(this.c, profileElementFieldRepo.c) && Intrinsics.areEqual(this.d, profileElementFieldRepo.d) && Intrinsics.areEqual(this.e, profileElementFieldRepo.e) && this.f == profileElementFieldRepo.f && Intrinsics.areEqual(this.g, profileElementFieldRepo.g) && Intrinsics.areEqual(this.h, profileElementFieldRepo.h);
    }

    @NotNull
    public final String getDescription() {
        return this.d;
    }

    @NotNull
    public final String getFieldName() {
        return this.a;
    }

    @NotNull
    public final String getLabel() {
        return this.e;
    }

    @Nullable
    public final String getMask() {
        return this.g;
    }

    @Nullable
    public final Integer getOrder() {
        return this.h;
    }

    @NotNull
    public final String getPath() {
        return this.b;
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
        boolean z = this.f;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode5 + i2) * 31;
        String str6 = this.g;
        int hashCode6 = (i5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num = this.h;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode6 + i;
    }

    public final boolean isEditable() {
        return this.f;
    }

    @NotNull
    public final ProfileElementFieldDomain toDomain() {
        return new ProfileElementFieldDomain(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileElementFieldRepo(fieldName=");
        L.append(this.a);
        L.append(", path=");
        L.append(this.b);
        L.append(", value=");
        L.append(this.c);
        L.append(", description=");
        L.append(this.d);
        L.append(", label=");
        L.append(this.e);
        L.append(", isEditable=");
        L.append(this.f);
        L.append(", mask=");
        L.append(this.g);
        L.append(", order=");
        return a.p(L, this.h, ")");
    }
}
