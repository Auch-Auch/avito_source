package ru.sravni.android.bankproduct.network.profile.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileElementFieldRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b.\u0010/J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jj\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\bJ\u0010\u0010\u001f\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b'\u0010\u0013R\u001c\u0010\u0018\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b(\u0010\bR\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b)\u0010\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b*\u0010\bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b\u0019\u0010\u000fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010$\u001a\u0004\b,\u0010\bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b-\u0010\b¨\u00060"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "", "", "fieldName", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "toProfileElementFieldRepo", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "component7", "", "component8", "()Ljava/lang/Integer;", "default", MessageMetaInfo.COLUMN_PATH, "value", "description", "label", "isEditable", "mask", "order", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "Ljava/lang/Integer;", "getOrder", "getLabel", "getPath", "getValue", "Ljava/lang/Boolean;", "getMask", "getDefault", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AccountElementResponse {
    @SerializedName("default")
    @Nullable

    /* renamed from: default  reason: not valid java name */
    private final String f13default;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("isEditable")
    @Nullable
    private final Boolean isEditable;
    @SerializedName("label")
    @NotNull
    private final String label;
    @SerializedName("mask")
    @Nullable
    private final String mask;
    @SerializedName("order")
    @Nullable
    private final Integer order;
    @SerializedName(MessageMetaInfo.COLUMN_PATH)
    @NotNull
    private final String path;
    @SerializedName("value")
    @Nullable
    private final String value;

    public AccountElementResponse(@Nullable String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable Boolean bool, @Nullable String str6, @Nullable Integer num) {
        a.a1(str2, MessageMetaInfo.COLUMN_PATH, str4, "description", str5, "label");
        this.f13default = str;
        this.path = str2;
        this.value = str3;
        this.description = str4;
        this.label = str5;
        this.isEditable = bool;
        this.mask = str6;
        this.order = num;
    }

    public static /* synthetic */ AccountElementResponse copy$default(AccountElementResponse accountElementResponse, String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, Integer num, int i, Object obj) {
        return accountElementResponse.copy((i & 1) != 0 ? accountElementResponse.f13default : str, (i & 2) != 0 ? accountElementResponse.path : str2, (i & 4) != 0 ? accountElementResponse.value : str3, (i & 8) != 0 ? accountElementResponse.description : str4, (i & 16) != 0 ? accountElementResponse.label : str5, (i & 32) != 0 ? accountElementResponse.isEditable : bool, (i & 64) != 0 ? accountElementResponse.mask : str6, (i & 128) != 0 ? accountElementResponse.order : num);
    }

    @Nullable
    public final String component1() {
        return this.f13default;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    @Nullable
    public final String component3() {
        return this.value;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.label;
    }

    @Nullable
    public final Boolean component6() {
        return this.isEditable;
    }

    @Nullable
    public final String component7() {
        return this.mask;
    }

    @Nullable
    public final Integer component8() {
        return this.order;
    }

    @NotNull
    public final AccountElementResponse copy(@Nullable String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable Boolean bool, @Nullable String str6, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str2, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkParameterIsNotNull(str4, "description");
        Intrinsics.checkParameterIsNotNull(str5, "label");
        return new AccountElementResponse(str, str2, str3, str4, str5, bool, str6, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountElementResponse)) {
            return false;
        }
        AccountElementResponse accountElementResponse = (AccountElementResponse) obj;
        return Intrinsics.areEqual(this.f13default, accountElementResponse.f13default) && Intrinsics.areEqual(this.path, accountElementResponse.path) && Intrinsics.areEqual(this.value, accountElementResponse.value) && Intrinsics.areEqual(this.description, accountElementResponse.description) && Intrinsics.areEqual(this.label, accountElementResponse.label) && Intrinsics.areEqual(this.isEditable, accountElementResponse.isEditable) && Intrinsics.areEqual(this.mask, accountElementResponse.mask) && Intrinsics.areEqual(this.order, accountElementResponse.order);
    }

    @Nullable
    public final String getDefault() {
        return this.f13default;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getMask() {
        return this.mask;
    }

    @Nullable
    public final Integer getOrder() {
        return this.order;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.f13default;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.path;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.value;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.label;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Boolean bool = this.isEditable;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str6 = this.mask;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num = this.order;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode7 + i;
    }

    @Nullable
    public final Boolean isEditable() {
        return this.isEditable;
    }

    @NotNull
    public final ProfileElementFieldRepo toProfileElementFieldRepo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "fieldName");
        String str2 = this.path;
        String str3 = this.value;
        if (str3 == null) {
            str3 = this.f13default;
        }
        String str4 = this.description;
        Boolean bool = this.isEditable;
        return new ProfileElementFieldRepo(str, str2, str3, str4, this.label, bool != null ? bool.booleanValue() : true, this.mask, this.order);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AccountElementResponse(default=");
        L.append(this.f13default);
        L.append(", path=");
        L.append(this.path);
        L.append(", value=");
        L.append(this.value);
        L.append(", description=");
        L.append(this.description);
        L.append(", label=");
        L.append(this.label);
        L.append(", isEditable=");
        L.append(this.isEditable);
        L.append(", mask=");
        L.append(this.mask);
        L.append(", order=");
        return a.p(L, this.order, ")");
    }
}
