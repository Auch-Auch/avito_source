package ru.avito.messenger.internal.gson;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lru/avito/messenger/internal/gson/TypeId;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSubtype", "()Ljava/lang/String;", "subtype", AuthSource.SEND_ABUSE, "getType", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class TypeId {
    @NotNull
    public final String a;
    @Nullable
    public final String b;

    public TypeId(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.a = str;
        this.b = str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeId)) {
            return false;
        }
        TypeId typeId = (TypeId) obj;
        return !(Intrinsics.areEqual(this.a, typeId.a) ^ true) && !(Intrinsics.areEqual(this.b, typeId.b) ^ true);
    }

    @Nullable
    public final String getSubtype() {
        return this.b;
    }

    @NotNull
    public final String getType() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeId(String str, String str2, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}
