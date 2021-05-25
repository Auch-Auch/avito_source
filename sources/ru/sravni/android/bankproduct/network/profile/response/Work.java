package ru.sravni.android.bankproduct.network.profile.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileElementFieldRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileNoteRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b6\u00107J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJt\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0015\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u000bR\u001c\u0010\u0017\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b-\u0010\u000bR\u001c\u0010\u0018\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b.\u0010\u000bR\u001c\u0010\u0019\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b/\u0010\u000bR\u001c\u0010\u001b\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b0\u0010\u000bR\u001c\u0010\u001d\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b1\u0010\u000bR\u001c\u0010\u001e\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b2\u0010\u000bR\u001c\u0010\u0016\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b3\u0010\u000bR\u001c\u0010\u001c\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b4\u0010\u000bR\u001c\u0010\u001a\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b5\u0010\u000b¨\u00068"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/Work;", "", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "toRepoElementList", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileNoteRepo;", "toProfileNoteRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/ProfileNoteRepo;", "Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "employmentType", AnalyticFieldsName.organizationName, "employerInn", "organizationType", "activityField", "startWork", VKApiConst.POSITION, "organizationPosition", "workPlace", "workPhone", "copy", "(Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;)Lru/sravni/android/bankproduct/network/profile/response/Work;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "getEmploymentType", "getEmployerInn", "getOrganizationType", "getActivityField", "getPosition", "getWorkPlace", "getWorkPhone", "getOrganizationName", "getOrganizationPosition", "getStartWork", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Work {
    @SerializedName("activity_field")
    @NotNull
    private final AccountElementResponse activityField;
    @SerializedName("employer_inn")
    @NotNull
    private final AccountElementResponse employerInn;
    @SerializedName("employment_type")
    @NotNull
    private final AccountElementResponse employmentType;
    @SerializedName("organization_name")
    @NotNull
    private final AccountElementResponse organizationName;
    @SerializedName("organization_position")
    @NotNull
    private final AccountElementResponse organizationPosition;
    @SerializedName("organization_type")
    @NotNull
    private final AccountElementResponse organizationType;
    @SerializedName("work_position")
    @NotNull
    private final AccountElementResponse position;
    @SerializedName("start_work")
    @NotNull
    private final AccountElementResponse startWork;
    @SerializedName("work_phone")
    @NotNull
    private final AccountElementResponse workPhone;
    @SerializedName("work_address")
    @NotNull
    private final AccountElementResponse workPlace;

    public Work(@NotNull AccountElementResponse accountElementResponse, @NotNull AccountElementResponse accountElementResponse2, @NotNull AccountElementResponse accountElementResponse3, @NotNull AccountElementResponse accountElementResponse4, @NotNull AccountElementResponse accountElementResponse5, @NotNull AccountElementResponse accountElementResponse6, @NotNull AccountElementResponse accountElementResponse7, @NotNull AccountElementResponse accountElementResponse8, @NotNull AccountElementResponse accountElementResponse9, @NotNull AccountElementResponse accountElementResponse10) {
        Intrinsics.checkParameterIsNotNull(accountElementResponse, "employmentType");
        Intrinsics.checkParameterIsNotNull(accountElementResponse2, AnalyticFieldsName.organizationName);
        Intrinsics.checkParameterIsNotNull(accountElementResponse3, "employerInn");
        Intrinsics.checkParameterIsNotNull(accountElementResponse4, "organizationType");
        Intrinsics.checkParameterIsNotNull(accountElementResponse5, "activityField");
        Intrinsics.checkParameterIsNotNull(accountElementResponse6, "startWork");
        Intrinsics.checkParameterIsNotNull(accountElementResponse7, VKApiConst.POSITION);
        Intrinsics.checkParameterIsNotNull(accountElementResponse8, "organizationPosition");
        Intrinsics.checkParameterIsNotNull(accountElementResponse9, "workPlace");
        Intrinsics.checkParameterIsNotNull(accountElementResponse10, "workPhone");
        this.employmentType = accountElementResponse;
        this.organizationName = accountElementResponse2;
        this.employerInn = accountElementResponse3;
        this.organizationType = accountElementResponse4;
        this.activityField = accountElementResponse5;
        this.startWork = accountElementResponse6;
        this.position = accountElementResponse7;
        this.organizationPosition = accountElementResponse8;
        this.workPlace = accountElementResponse9;
        this.workPhone = accountElementResponse10;
    }

    public static /* synthetic */ Work copy$default(Work work, AccountElementResponse accountElementResponse, AccountElementResponse accountElementResponse2, AccountElementResponse accountElementResponse3, AccountElementResponse accountElementResponse4, AccountElementResponse accountElementResponse5, AccountElementResponse accountElementResponse6, AccountElementResponse accountElementResponse7, AccountElementResponse accountElementResponse8, AccountElementResponse accountElementResponse9, AccountElementResponse accountElementResponse10, int i, Object obj) {
        return work.copy((i & 1) != 0 ? work.employmentType : accountElementResponse, (i & 2) != 0 ? work.organizationName : accountElementResponse2, (i & 4) != 0 ? work.employerInn : accountElementResponse3, (i & 8) != 0 ? work.organizationType : accountElementResponse4, (i & 16) != 0 ? work.activityField : accountElementResponse5, (i & 32) != 0 ? work.startWork : accountElementResponse6, (i & 64) != 0 ? work.position : accountElementResponse7, (i & 128) != 0 ? work.organizationPosition : accountElementResponse8, (i & 256) != 0 ? work.workPlace : accountElementResponse9, (i & 512) != 0 ? work.workPhone : accountElementResponse10);
    }

    private final List<ProfileElementFieldRepo> toRepoElementList() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new ProfileElementFieldRepo[]{this.employmentType.toProfileElementFieldRepo("employment_type"), this.organizationName.toProfileElementFieldRepo("organization_name"), this.employerInn.toProfileElementFieldRepo("employer_inn"), this.organizationType.toProfileElementFieldRepo("organization_type"), this.activityField.toProfileElementFieldRepo("activity_field"), this.startWork.toProfileElementFieldRepo("start_work"), this.position.toProfileElementFieldRepo("work_position"), this.organizationPosition.toProfileElementFieldRepo("organization_position"), this.workPlace.toProfileElementFieldRepo("work_address"), this.workPhone.toProfileElementFieldRepo("work_phone")});
    }

    @NotNull
    public final AccountElementResponse component1() {
        return this.employmentType;
    }

    @NotNull
    public final AccountElementResponse component10() {
        return this.workPhone;
    }

    @NotNull
    public final AccountElementResponse component2() {
        return this.organizationName;
    }

    @NotNull
    public final AccountElementResponse component3() {
        return this.employerInn;
    }

    @NotNull
    public final AccountElementResponse component4() {
        return this.organizationType;
    }

    @NotNull
    public final AccountElementResponse component5() {
        return this.activityField;
    }

    @NotNull
    public final AccountElementResponse component6() {
        return this.startWork;
    }

    @NotNull
    public final AccountElementResponse component7() {
        return this.position;
    }

    @NotNull
    public final AccountElementResponse component8() {
        return this.organizationPosition;
    }

    @NotNull
    public final AccountElementResponse component9() {
        return this.workPlace;
    }

    @NotNull
    public final Work copy(@NotNull AccountElementResponse accountElementResponse, @NotNull AccountElementResponse accountElementResponse2, @NotNull AccountElementResponse accountElementResponse3, @NotNull AccountElementResponse accountElementResponse4, @NotNull AccountElementResponse accountElementResponse5, @NotNull AccountElementResponse accountElementResponse6, @NotNull AccountElementResponse accountElementResponse7, @NotNull AccountElementResponse accountElementResponse8, @NotNull AccountElementResponse accountElementResponse9, @NotNull AccountElementResponse accountElementResponse10) {
        Intrinsics.checkParameterIsNotNull(accountElementResponse, "employmentType");
        Intrinsics.checkParameterIsNotNull(accountElementResponse2, AnalyticFieldsName.organizationName);
        Intrinsics.checkParameterIsNotNull(accountElementResponse3, "employerInn");
        Intrinsics.checkParameterIsNotNull(accountElementResponse4, "organizationType");
        Intrinsics.checkParameterIsNotNull(accountElementResponse5, "activityField");
        Intrinsics.checkParameterIsNotNull(accountElementResponse6, "startWork");
        Intrinsics.checkParameterIsNotNull(accountElementResponse7, VKApiConst.POSITION);
        Intrinsics.checkParameterIsNotNull(accountElementResponse8, "organizationPosition");
        Intrinsics.checkParameterIsNotNull(accountElementResponse9, "workPlace");
        Intrinsics.checkParameterIsNotNull(accountElementResponse10, "workPhone");
        return new Work(accountElementResponse, accountElementResponse2, accountElementResponse3, accountElementResponse4, accountElementResponse5, accountElementResponse6, accountElementResponse7, accountElementResponse8, accountElementResponse9, accountElementResponse10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Work)) {
            return false;
        }
        Work work = (Work) obj;
        return Intrinsics.areEqual(this.employmentType, work.employmentType) && Intrinsics.areEqual(this.organizationName, work.organizationName) && Intrinsics.areEqual(this.employerInn, work.employerInn) && Intrinsics.areEqual(this.organizationType, work.organizationType) && Intrinsics.areEqual(this.activityField, work.activityField) && Intrinsics.areEqual(this.startWork, work.startWork) && Intrinsics.areEqual(this.position, work.position) && Intrinsics.areEqual(this.organizationPosition, work.organizationPosition) && Intrinsics.areEqual(this.workPlace, work.workPlace) && Intrinsics.areEqual(this.workPhone, work.workPhone);
    }

    @NotNull
    public final AccountElementResponse getActivityField() {
        return this.activityField;
    }

    @NotNull
    public final AccountElementResponse getEmployerInn() {
        return this.employerInn;
    }

    @NotNull
    public final AccountElementResponse getEmploymentType() {
        return this.employmentType;
    }

    @NotNull
    public final AccountElementResponse getOrganizationName() {
        return this.organizationName;
    }

    @NotNull
    public final AccountElementResponse getOrganizationPosition() {
        return this.organizationPosition;
    }

    @NotNull
    public final AccountElementResponse getOrganizationType() {
        return this.organizationType;
    }

    @NotNull
    public final AccountElementResponse getPosition() {
        return this.position;
    }

    @NotNull
    public final AccountElementResponse getStartWork() {
        return this.startWork;
    }

    @NotNull
    public final AccountElementResponse getWorkPhone() {
        return this.workPhone;
    }

    @NotNull
    public final AccountElementResponse getWorkPlace() {
        return this.workPlace;
    }

    public int hashCode() {
        AccountElementResponse accountElementResponse = this.employmentType;
        int i = 0;
        int hashCode = (accountElementResponse != null ? accountElementResponse.hashCode() : 0) * 31;
        AccountElementResponse accountElementResponse2 = this.organizationName;
        int hashCode2 = (hashCode + (accountElementResponse2 != null ? accountElementResponse2.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse3 = this.employerInn;
        int hashCode3 = (hashCode2 + (accountElementResponse3 != null ? accountElementResponse3.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse4 = this.organizationType;
        int hashCode4 = (hashCode3 + (accountElementResponse4 != null ? accountElementResponse4.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse5 = this.activityField;
        int hashCode5 = (hashCode4 + (accountElementResponse5 != null ? accountElementResponse5.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse6 = this.startWork;
        int hashCode6 = (hashCode5 + (accountElementResponse6 != null ? accountElementResponse6.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse7 = this.position;
        int hashCode7 = (hashCode6 + (accountElementResponse7 != null ? accountElementResponse7.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse8 = this.organizationPosition;
        int hashCode8 = (hashCode7 + (accountElementResponse8 != null ? accountElementResponse8.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse9 = this.workPlace;
        int hashCode9 = (hashCode8 + (accountElementResponse9 != null ? accountElementResponse9.hashCode() : 0)) * 31;
        AccountElementResponse accountElementResponse10 = this.workPhone;
        if (accountElementResponse10 != null) {
            i = accountElementResponse10.hashCode();
        }
        return hashCode9 + i;
    }

    @NotNull
    public final ProfileNoteRepo toProfileNoteRepo() {
        String value = this.organizationName.getValue();
        if (value == null) {
            value = "";
        }
        return new ProfileNoteRepo(value, toRepoElementList());
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Work(employmentType=");
        L.append(this.employmentType);
        L.append(", organizationName=");
        L.append(this.organizationName);
        L.append(", employerInn=");
        L.append(this.employerInn);
        L.append(", organizationType=");
        L.append(this.organizationType);
        L.append(", activityField=");
        L.append(this.activityField);
        L.append(", startWork=");
        L.append(this.startWork);
        L.append(", position=");
        L.append(this.position);
        L.append(", organizationPosition=");
        L.append(this.organizationPosition);
        L.append(", workPlace=");
        L.append(this.workPlace);
        L.append(", workPhone=");
        L.append(this.workPhone);
        L.append(")");
        return L.toString();
    }
}
