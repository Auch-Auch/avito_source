package com.sumsub.sns.core.data.model.remote;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/Metadata;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/sumsub/sns/core/data/model/remote/Metavalue;", "component3", "()Ljava/util/List;", "id", "email", "metadata", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/remote/Metadata;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEmail", "Ljava/util/List;", "getMetadata", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class Metadata {
    @SerializedName("email")
    @Nullable
    private final String email;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("metadata")
    @NotNull
    private final List<Metavalue> metadata;

    public Metadata(@NotNull String str, @Nullable String str2, @NotNull List<Metavalue> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "metadata");
        this.id = str;
        this.email = str2;
        this.metadata = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.remote.Metadata */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Metadata copy$default(Metadata metadata2, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metadata2.id;
        }
        if ((i & 2) != 0) {
            str2 = metadata2.email;
        }
        if ((i & 4) != 0) {
            list = metadata2.metadata;
        }
        return metadata2.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.email;
    }

    @NotNull
    public final List<Metavalue> component3() {
        return this.metadata;
    }

    @NotNull
    public final Metadata copy(@NotNull String str, @Nullable String str2, @NotNull List<Metavalue> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "metadata");
        return new Metadata(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Metadata)) {
            return false;
        }
        Metadata metadata2 = (Metadata) obj;
        return Intrinsics.areEqual(this.id, metadata2.id) && Intrinsics.areEqual(this.email, metadata2.email) && Intrinsics.areEqual(this.metadata, metadata2.metadata);
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<Metavalue> getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.email;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Metavalue> list = this.metadata;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Metadata(id=");
        L.append(this.id);
        L.append(", email=");
        L.append(this.email);
        L.append(", metadata=");
        return a.w(L, this.metadata, ")");
    }
}
