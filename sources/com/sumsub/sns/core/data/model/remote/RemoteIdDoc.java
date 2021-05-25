package com.sumsub.sns.core.data.model.remote;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import com.sumsub.sns.core.data.model.IdentitySide;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJX\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u00020\u00198F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\bR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u000bR\u0013\u0010%\u001a\u00020\u00198F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010\u001dR$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b&\u0010\u000bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "component3", "()Lcom/sumsub/sns/core/data/model/IdentitySide;", "", "component4", "()Ljava/util/List;", "component5", "idDocType", "country", "idDocSubType", "warnings", "errors", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;Ljava/util/List;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "isFatal", "()Z", "Ljava/lang/String;", "getIdDocType", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "getIdDocSubType", "Ljava/util/List;", "getWarnings", "getHasErrors", "hasErrors", "getErrors", "getCountry", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;Ljava/util/List;Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteIdDoc {
    @SerializedName("country")
    @Nullable
    private final String country;
    @SerializedName("errors")
    @Nullable
    private final List<String> errors;
    @SerializedName("idDocSubType")
    @Nullable
    private final IdentitySide idDocSubType;
    @SerializedName("idDocType")
    @Nullable
    private final String idDocType;
    @SerializedName("warnings")
    @Nullable
    private final List<String> warnings;

    public RemoteIdDoc(@Nullable String str, @Nullable String str2, @Nullable IdentitySide identitySide, @Nullable List<String> list, @Nullable List<String> list2) {
        this.idDocType = str;
        this.country = str2;
        this.idDocSubType = identitySide;
        this.warnings = list;
        this.errors = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.sumsub.sns.core.data.model.remote.RemoteIdDoc */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoteIdDoc copy$default(RemoteIdDoc remoteIdDoc, String str, String str2, IdentitySide identitySide, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteIdDoc.idDocType;
        }
        if ((i & 2) != 0) {
            str2 = remoteIdDoc.country;
        }
        if ((i & 4) != 0) {
            identitySide = remoteIdDoc.idDocSubType;
        }
        if ((i & 8) != 0) {
            list = remoteIdDoc.warnings;
        }
        if ((i & 16) != 0) {
            list2 = remoteIdDoc.errors;
        }
        return remoteIdDoc.copy(str, str2, identitySide, list, list2);
    }

    @Nullable
    public final String component1() {
        return this.idDocType;
    }

    @Nullable
    public final String component2() {
        return this.country;
    }

    @Nullable
    public final IdentitySide component3() {
        return this.idDocSubType;
    }

    @Nullable
    public final List<String> component4() {
        return this.warnings;
    }

    @Nullable
    public final List<String> component5() {
        return this.errors;
    }

    @NotNull
    public final RemoteIdDoc copy(@Nullable String str, @Nullable String str2, @Nullable IdentitySide identitySide, @Nullable List<String> list, @Nullable List<String> list2) {
        return new RemoteIdDoc(str, str2, identitySide, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteIdDoc)) {
            return false;
        }
        RemoteIdDoc remoteIdDoc = (RemoteIdDoc) obj;
        return Intrinsics.areEqual(this.idDocType, remoteIdDoc.idDocType) && Intrinsics.areEqual(this.country, remoteIdDoc.country) && Intrinsics.areEqual(this.idDocSubType, remoteIdDoc.idDocSubType) && Intrinsics.areEqual(this.warnings, remoteIdDoc.warnings) && Intrinsics.areEqual(this.errors, remoteIdDoc.errors);
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    public final boolean getHasErrors() {
        List<String> list = this.errors;
        boolean z = false;
        boolean z2 = list == null || list.isEmpty();
        List<String> list2 = this.warnings;
        if (list2 == null || list2.isEmpty()) {
            z = true;
        }
        return !(z2 & z);
    }

    @Nullable
    public final IdentitySide getIdDocSubType() {
        return this.idDocSubType;
    }

    @Nullable
    public final String getIdDocType() {
        return this.idDocType;
    }

    @Nullable
    public final List<String> getWarnings() {
        return this.warnings;
    }

    public int hashCode() {
        String str = this.idDocType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        IdentitySide identitySide = this.idDocSubType;
        int hashCode3 = (hashCode2 + (identitySide != null ? identitySide.hashCode() : 0)) * 31;
        List<String> list = this.warnings;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.errors;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    public final boolean isFatal() {
        List<String> list = this.errors;
        return !(list == null || list.isEmpty());
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RemoteIdDoc(idDocType=");
        L.append(this.idDocType);
        L.append(", country=");
        L.append(this.country);
        L.append(", idDocSubType=");
        L.append(this.idDocSubType);
        L.append(", warnings=");
        L.append(this.warnings);
        L.append(", errors=");
        return a.w(L, this.errors, ")");
    }
}
