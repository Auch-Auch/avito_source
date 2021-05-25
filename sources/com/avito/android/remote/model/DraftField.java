package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/DraftField;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", "id", "tags", "value", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/DraftField;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Ljava/util/List;", "getTags", "getValue", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DraftField {
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("tags")
    @Nullable
    private final List<String> tags;
    @SerializedName("value")
    @Nullable
    private final String value;

    public DraftField(@NotNull String str, @Nullable List<String> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.tags = list;
        this.value = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.DraftField */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DraftField copy$default(DraftField draftField, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = draftField.id;
        }
        if ((i & 2) != 0) {
            list = draftField.tags;
        }
        if ((i & 4) != 0) {
            str2 = draftField.value;
        }
        return draftField.copy(str, list, str2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final List<String> component2() {
        return this.tags;
    }

    @Nullable
    public final String component3() {
        return this.value;
    }

    @NotNull
    public final DraftField copy(@NotNull String str, @Nullable List<String> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new DraftField(str, list, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DraftField)) {
            return false;
        }
        DraftField draftField = (DraftField) obj;
        return Intrinsics.areEqual(this.id, draftField.id) && Intrinsics.areEqual(this.tags, draftField.tags) && Intrinsics.areEqual(this.value, draftField.value);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.tags;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DraftField(id=");
        L.append(this.id);
        L.append(", tags=");
        L.append(this.tags);
        L.append(", value=");
        return a.t(L, this.value, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DraftField(String str, List list, String str2, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : list, str2);
    }
}
