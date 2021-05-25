package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/FieldModeration;", "", "Lcom/avito/android/remote/model/FieldModeration$Status;", "component1", "()Lcom/avito/android/remote/model/FieldModeration$Status;", "", "component2", "()Ljava/lang/String;", "component3", "status", "title", "description", "copy", "(Lcom/avito/android/remote/model/FieldModeration$Status;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/FieldModeration;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/remote/model/FieldModeration$Status;", "getStatus", "getDescription", "<init>", "(Lcom/avito/android/remote/model/FieldModeration$Status;Ljava/lang/String;Ljava/lang/String;)V", "Status", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class FieldModeration {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("status")
    @NotNull
    private final Status status;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/FieldModeration$Status;", "", "<init>", "(Ljava/lang/String;I)V", "ON_MODERATION", "REJECTED", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public enum Status {
        ON_MODERATION,
        REJECTED
    }

    public FieldModeration(@NotNull Status status2, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        this.status = status2;
        this.title = str;
        this.description = str2;
    }

    public static /* synthetic */ FieldModeration copy$default(FieldModeration fieldModeration, Status status2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            status2 = fieldModeration.status;
        }
        if ((i & 2) != 0) {
            str = fieldModeration.title;
        }
        if ((i & 4) != 0) {
            str2 = fieldModeration.description;
        }
        return fieldModeration.copy(status2, str, str2);
    }

    @NotNull
    public final Status component1() {
        return this.status;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final FieldModeration copy(@NotNull Status status2, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        return new FieldModeration(status2, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldModeration)) {
            return false;
        }
        FieldModeration fieldModeration = (FieldModeration) obj;
        return Intrinsics.areEqual(this.status, fieldModeration.status) && Intrinsics.areEqual(this.title, fieldModeration.title) && Intrinsics.areEqual(this.description, fieldModeration.description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Status status2 = this.status;
        int i = 0;
        int hashCode = (status2 != null ? status2.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FieldModeration(status=");
        L.append(this.status);
        L.append(", title=");
        L.append(this.title);
        L.append(", description=");
        return a.t(L, this.description, ")");
    }
}
