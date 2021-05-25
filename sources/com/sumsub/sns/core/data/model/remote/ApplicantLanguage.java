package com.sumsub.sns.core.data.model.remote;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/ApplicantLanguage;", "", "", "component1", "()Ljava/lang/String;", "component2", "id", VKApiConst.LANG, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/remote/ApplicantLanguage;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getLang", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ApplicantLanguage {
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName(VKApiConst.LANG)
    @NotNull
    private final String lang;

    public ApplicantLanguage(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, VKApiConst.LANG);
        this.id = str;
        this.lang = str2;
    }

    public static /* synthetic */ ApplicantLanguage copy$default(ApplicantLanguage applicantLanguage, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = applicantLanguage.id;
        }
        if ((i & 2) != 0) {
            str2 = applicantLanguage.lang;
        }
        return applicantLanguage.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.lang;
    }

    @NotNull
    public final ApplicantLanguage copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, VKApiConst.LANG);
        return new ApplicantLanguage(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicantLanguage)) {
            return false;
        }
        ApplicantLanguage applicantLanguage = (ApplicantLanguage) obj;
        return Intrinsics.areEqual(this.id, applicantLanguage.id) && Intrinsics.areEqual(this.lang, applicantLanguage.lang);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getLang() {
        return this.lang;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lang;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ApplicantLanguage(id=");
        L.append(this.id);
        L.append(", lang=");
        return a.t(L, this.lang, ")");
    }
}
