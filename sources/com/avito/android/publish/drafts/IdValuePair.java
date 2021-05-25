package com.avito.android.publish.drafts;

import a2.b.a.a.a;
import androidx.annotation.Keep;
import com.avito.android.remote.annotations.Field;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00028\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/drafts/IdValuePair;", "", "", "component1", "()Ljava/lang/String;", "component2", "id", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/publish/drafts/IdValuePair;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class IdValuePair {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String ID = "id";
    @NotNull
    public static final String VALUE = "value";
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("value")
    @NotNull
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/drafts/IdValuePair$Companion;", "", "", "ID", "Ljava/lang/String;", "VALUE", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public IdValuePair(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.id = str;
        this.value = str2;
    }

    public static /* synthetic */ IdValuePair copy$default(IdValuePair idValuePair, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = idValuePair.id;
        }
        if ((i & 2) != 0) {
            str2 = idValuePair.value;
        }
        return idValuePair.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final IdValuePair copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "value");
        return new IdValuePair(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdValuePair)) {
            return false;
        }
        IdValuePair idValuePair = (IdValuePair) obj;
        return Intrinsics.areEqual(this.id, idValuePair.id) && Intrinsics.areEqual(this.value, idValuePair.value);
    }

    @Field(name = "id")
    @NotNull
    public final String getId() {
        return this.id;
    }

    @Field(name = "value")
    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("IdValuePair(id=");
        L.append(this.id);
        L.append(", value=");
        return a.t(L, this.value, ")");
    }
}
