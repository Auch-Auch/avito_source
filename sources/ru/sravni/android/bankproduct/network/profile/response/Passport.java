package ru.sravni.android.bankproduct.network.profile.response;

import a2.b.a.a.a;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileDocumentRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileElementFieldRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b0\u00101J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ`\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0013\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u000bR\u001c\u0010\u0015\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b)\u0010\u000bR\u001c\u0010\u0018\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b*\u0010\u000bR\u001c\u0010\u001a\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b+\u0010\u000bR\u001c\u0010\u0014\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b,\u0010\u000bR\u001c\u0010\u0016\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b-\u0010\u000bR\u001c\u0010\u0019\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b.\u0010\u000bR\u001c\u0010\u0017\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b/\u0010\u000b¨\u00062"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/Passport;", "", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "toRepoElementList", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileDocumentRepo;", "toProfileDocumentRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/ProfileDocumentRepo;", "Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "fio", "issueDate", "unitCode", "issueTitle", "birthDay", "birthCity", "code", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "copy", "(Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;)Lru/sravni/android/bankproduct/network/profile/response/Passport;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "getFio", "getUnitCode", "getBirthCity", "getAddress", "getIssueDate", "getIssueTitle", "getCode", "getBirthDay", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Passport {
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @NotNull
    private final AccountElementResponse address;
    @SerializedName("birthCity")
    @NotNull
    private final AccountElementResponse birthCity;
    @SerializedName("birthDay")
    @NotNull
    private final AccountElementResponse birthDay;
    @SerializedName("code")
    @NotNull
    private final AccountElementResponse code;
    @SerializedName("FIO")
    @NotNull
    private final AccountElementResponse fio;
    @SerializedName("issueDate")
    @NotNull
    private final AccountElementResponse issueDate;
    @SerializedName("issueTitle")
    @NotNull
    private final AccountElementResponse issueTitle;
    @SerializedName("unitCode")
    @NotNull
    private final AccountElementResponse unitCode;

    public Passport(@NotNull AccountElementResponse accountElementResponse, @NotNull AccountElementResponse accountElementResponse2, @NotNull AccountElementResponse accountElementResponse3, @NotNull AccountElementResponse accountElementResponse4, @NotNull AccountElementResponse accountElementResponse5, @NotNull AccountElementResponse accountElementResponse6, @NotNull AccountElementResponse accountElementResponse7, @NotNull AccountElementResponse accountElementResponse8) {
        Intrinsics.checkParameterIsNotNull(accountElementResponse, "fio");
        Intrinsics.checkParameterIsNotNull(accountElementResponse2, "issueDate");
        Intrinsics.checkParameterIsNotNull(accountElementResponse3, "unitCode");
        Intrinsics.checkParameterIsNotNull(accountElementResponse4, "issueTitle");
        Intrinsics.checkParameterIsNotNull(accountElementResponse5, "birthDay");
        Intrinsics.checkParameterIsNotNull(accountElementResponse6, "birthCity");
        Intrinsics.checkParameterIsNotNull(accountElementResponse7, "code");
        Intrinsics.checkParameterIsNotNull(accountElementResponse8, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        this.fio = accountElementResponse;
        this.issueDate = accountElementResponse2;
        this.unitCode = accountElementResponse3;
        this.issueTitle = accountElementResponse4;
        this.birthDay = accountElementResponse5;
        this.birthCity = accountElementResponse6;
        this.code = accountElementResponse7;
        this.address = accountElementResponse8;
    }

    public static /* synthetic */ Passport copy$default(Passport passport, AccountElementResponse accountElementResponse, AccountElementResponse accountElementResponse2, AccountElementResponse accountElementResponse3, AccountElementResponse accountElementResponse4, AccountElementResponse accountElementResponse5, AccountElementResponse accountElementResponse6, AccountElementResponse accountElementResponse7, AccountElementResponse accountElementResponse8, int i, Object obj) {
        return passport.copy((i & 1) != 0 ? passport.fio : accountElementResponse, (i & 2) != 0 ? passport.issueDate : accountElementResponse2, (i & 4) != 0 ? passport.unitCode : accountElementResponse3, (i & 8) != 0 ? passport.issueTitle : accountElementResponse4, (i & 16) != 0 ? passport.birthDay : accountElementResponse5, (i & 32) != 0 ? passport.birthCity : accountElementResponse6, (i & 64) != 0 ? passport.code : accountElementResponse7, (i & 128) != 0 ? passport.address : accountElementResponse8);
    }

    private final List<ProfileElementFieldRepo> toRepoElementList() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new ProfileElementFieldRepo[]{this.fio.toProfileElementFieldRepo("FIO"), this.issueDate.toProfileElementFieldRepo("issueDate"), this.unitCode.toProfileElementFieldRepo("unitCode"), this.issueTitle.toProfileElementFieldRepo("issueTitle"), this.birthDay.toProfileElementFieldRepo("birthDay"), this.birthCity.toProfileElementFieldRepo("birthCity"), this.code.toProfileElementFieldRepo("code"), this.address.toProfileElementFieldRepo(IntegrityManager.INTEGRITY_TYPE_ADDRESS)});
    }

    @NotNull
    public final AccountElementResponse component1() {
        return this.fio;
    }

    @NotNull
    public final AccountElementResponse component2() {
        return this.issueDate;
    }

    @NotNull
    public final AccountElementResponse component3() {
        return this.unitCode;
    }

    @NotNull
    public final AccountElementResponse component4() {
        return this.issueTitle;
    }

    @NotNull
    public final AccountElementResponse component5() {
        return this.birthDay;
    }

    @NotNull
    public final AccountElementResponse component6() {
        return this.birthCity;
    }

    @NotNull
    public final AccountElementResponse component7() {
        return this.code;
    }

    @NotNull
    public final AccountElementResponse component8() {
        return this.address;
    }

    @NotNull
    public final Passport copy(@NotNull AccountElementResponse accountElementResponse, @NotNull AccountElementResponse accountElementResponse2, @NotNull AccountElementResponse accountElementResponse3, @NotNull AccountElementResponse accountElementResponse4, @NotNull AccountElementResponse accountElementResponse5, @NotNull AccountElementResponse accountElementResponse6, @NotNull AccountElementResponse accountElementResponse7, @NotNull AccountElementResponse accountElementResponse8) {
        Intrinsics.checkParameterIsNotNull(accountElementResponse, "fio");
        Intrinsics.checkParameterIsNotNull(accountElementResponse2, "issueDate");
        Intrinsics.checkParameterIsNotNull(accountElementResponse3, "unitCode");
        Intrinsics.checkParameterIsNotNull(accountElementResponse4, "issueTitle");
        Intrinsics.checkParameterIsNotNull(accountElementResponse5, "birthDay");
        Intrinsics.checkParameterIsNotNull(accountElementResponse6, "birthCity");
        Intrinsics.checkParameterIsNotNull(accountElementResponse7, "code");
        Intrinsics.checkParameterIsNotNull(accountElementResponse8, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        return new Passport(accountElementResponse, accountElementResponse2, accountElementResponse3, accountElementResponse4, accountElementResponse5, accountElementResponse6, accountElementResponse7, accountElementResponse8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Passport)) {
            return false;
        }
        Passport passport = (Passport) obj;
        return Intrinsics.areEqual(this.fio, passport.fio) && Intrinsics.areEqual(this.issueDate, passport.issueDate) && Intrinsics.areEqual(this.unitCode, passport.unitCode) && Intrinsics.areEqual(this.issueTitle, passport.issueTitle) && Intrinsics.areEqual(this.birthDay, passport.birthDay) && Intrinsics.areEqual(this.birthCity, passport.birthCity) && Intrinsics.areEqual(this.code, passport.code) && Intrinsics.areEqual(this.address, passport.address);
    }

    @NotNull
    public final AccountElementResponse getAddress() {
        return this.address;
    }

    @NotNull
    public final AccountElementResponse getBirthCity() {
        return this.birthCity;
    }

    @NotNull
    public final AccountElementResponse getBirthDay() {
        return this.birthDay;
    }

    @NotNull
    public final AccountElementResponse getCode() {
        return this.code;
    }

    @NotNull
    public final AccountElementResponse getFio() {
        return this.fio;
    }

    @NotNull
    public final AccountElementResponse getIssueDate() {
        return this.issueDate;
    }

    @NotNull
    public final AccountElementResponse getIssueTitle() {
        return this.issueTitle;
    }

    @NotNull
    public final AccountElementResponse getUnitCode() {
        return this.unitCode;
    }

    public int hashCode() {
        AccountElementResponse accountElementResponse = this.fio;
        int i = 0;
        int hashCode = (accountElementResponse != null ? accountElementResponse.hashCode() : 0) * 31;
        AccountElementResponse accountElementResponse2 = this.issueDate;
        int hashCode2 = (hashCode + (accountElementResponse2 != null ? accountElementResponse2.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse3 = this.unitCode;
        int hashCode3 = (hashCode2 + (accountElementResponse3 != null ? accountElementResponse3.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse4 = this.issueTitle;
        int hashCode4 = (hashCode3 + (accountElementResponse4 != null ? accountElementResponse4.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse5 = this.birthDay;
        int hashCode5 = (hashCode4 + (accountElementResponse5 != null ? accountElementResponse5.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse6 = this.birthCity;
        int hashCode6 = (hashCode5 + (accountElementResponse6 != null ? accountElementResponse6.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse7 = this.code;
        int hashCode7 = (hashCode6 + (accountElementResponse7 != null ? accountElementResponse7.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse8 = this.address;
        if (accountElementResponse8 != null) {
            i = accountElementResponse8.hashCode();
        }
        return hashCode7 + i;
    }

    @NotNull
    public final ProfileDocumentRepo toProfileDocumentRepo() {
        return new ProfileDocumentRepo(toRepoElementList());
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Passport(fio=");
        L.append(this.fio);
        L.append(", issueDate=");
        L.append(this.issueDate);
        L.append(", unitCode=");
        L.append(this.unitCode);
        L.append(", issueTitle=");
        L.append(this.issueTitle);
        L.append(", birthDay=");
        L.append(this.birthDay);
        L.append(", birthCity=");
        L.append(this.birthCity);
        L.append(", code=");
        L.append(this.code);
        L.append(", address=");
        L.append(this.address);
        L.append(")");
        return L.toString();
    }
}
