package ru.avito.android.persistence.messenger;

import a2.b.a.a.a;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Entity(primaryKeys = {"local_user_id", "channel_id"}, tableName = AnalyticFieldsName.draft)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0004¨\u0006\""}, d2 = {"Lru/avito/android/persistence/messenger/DraftEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "localUserId", "channelId", "interlocutorId", "text", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/avito/android/persistence/messenger/DraftEntity;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLocalUserId", "c", "getInterlocutorId", AuthSource.BOOKING_ORDER, "getChannelId", "d", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DraftEntity {
    @NotNull
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    @NotNull
    public static final String COLUMN_INTERLOCUTOR_ID = "interlocutor_id";
    @NotNull
    public static final String COLUMN_LOCAL_USER_ID = "local_user_id";
    @NotNull
    public static final String COLUMN_TEXT = "text";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @ColumnInfo(name = "local_user_id")
    @NotNull
    public final String a;
    @ColumnInfo(name = "channel_id")
    @NotNull
    public final String b;
    @ColumnInfo(name = "interlocutor_id")
    @NotNull
    public final String c;
    @ColumnInfo(name = "text")
    @NotNull
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lru/avito/android/persistence/messenger/DraftEntity$Companion;", "", "", "COLUMN_CHANNEL_ID", "Ljava/lang/String;", "COLUMN_INTERLOCUTOR_ID", "COLUMN_LOCAL_USER_ID", "COLUMN_TEXT", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public DraftEntity(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a.b1(str, "localUserId", str2, "channelId", str3, "interlocutorId", str4, "text");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static /* synthetic */ DraftEntity copy$default(DraftEntity draftEntity, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = draftEntity.a;
        }
        if ((i & 2) != 0) {
            str2 = draftEntity.b;
        }
        if ((i & 4) != 0) {
            str3 = draftEntity.c;
        }
        if ((i & 8) != 0) {
            str4 = draftEntity.d;
        }
        return draftEntity.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final DraftEntity copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "interlocutorId");
        Intrinsics.checkNotNullParameter(str4, "text");
        return new DraftEntity(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DraftEntity)) {
            return false;
        }
        DraftEntity draftEntity = (DraftEntity) obj;
        return Intrinsics.areEqual(this.a, draftEntity.a) && Intrinsics.areEqual(this.b, draftEntity.b) && Intrinsics.areEqual(this.c, draftEntity.c) && Intrinsics.areEqual(this.d, draftEntity.d);
    }

    @NotNull
    public final String getChannelId() {
        return this.b;
    }

    @NotNull
    public final String getInterlocutorId() {
        return this.c;
    }

    @NotNull
    public final String getLocalUserId() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DraftEntity(localUserId=");
        L.append(this.a);
        L.append(", channelId=");
        L.append(this.b);
        L.append(", interlocutorId=");
        L.append(this.c);
        L.append(", text=");
        return a.t(L, this.d, ")");
    }
}
