package ru.avito.android.persistence.messenger;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Entity(primaryKeys = {MessageEntity.COLUMN_LOCAL_ID, "channel_id", "user_id"}, tableName = "message")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b*\b\b\u0018\u0000 Y2\u00020\u0001:\u0001YB©\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u0012\b\b\u0002\u0010%\u001a\u00020\u000e\u0012\b\b\u0002\u0010&\u001a\u00020\u000e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\b\b\u0002\u0010*\u001a\u00020\u000e\u0012\b\b\u0002\u0010+\u001a\u00020\u0018\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bW\u0010XJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0014JÂ\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u00182\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b/\u0010\u0004J\u0010\u00101\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00104\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b4\u00105R\u001c\u0010%\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b%\u0010\u0010R\u001c\u0010*\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b8\u00107\u001a\u0004\b*\u0010\u0010R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0004R\u001c\u0010$\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b$\u0010\u0010R\u001c\u0010!\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b=\u0010:\u001a\u0004\b>\u0010\u0004R\u001c\u0010\"\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bA\u0010:\u001a\u0004\bB\u0010\u0004R\u001c\u0010 \u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bC\u0010:\u001a\u0004\bD\u0010\u0004R\u001e\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bE\u0010:\u001a\u0004\bF\u0010\u0004R\u001c\u0010)\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bG\u00107\u001a\u0004\b)\u0010\u0010R\u001c\u0010\u001f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\tR\u001c\u0010#\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bK\u0010:\u001a\u0004\bL\u0010\u0004R\u001c\u0010&\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bM\u00107\u001a\u0004\b&\u0010\u0010R\u001e\u0010,\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\u0014R\u001e\u0010'\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bQ\u0010O\u001a\u0004\bR\u0010\u0014R\u001c\u0010+\u001a\u00020\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\b+\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bU\u0010:\u001a\u0004\bV\u0010\u0004¨\u0006Z"}, d2 = {"Lru/avito/android/persistence/messenger/MessageEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()J", "component5", "component6", "component7", "component8", "", "component9", "()Z", "component10", "component11", "component12", "()Ljava/lang/Long;", "component13", "component14", "component15", "Lru/avito/android/persistence/messenger/IsReadStatus;", "component16", "()Lru/avito/android/persistence/messenger/IsReadStatus;", "component17", "localId", "channelId", "remoteId", "created", "type", ChannelContext.Item.USER_ID, "fromId", "jsonBody", "isRead", "isSpam", "isFailed", "readTimestamp", "preview", "isSupported", "isCompleteBody", "isReadStatus", "readLocallyTimestamp", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/Long;Ljava/lang/String;ZZLru/avito/android/persistence/messenger/IsReadStatus;Ljava/lang/Long;)Lru/avito/android/persistence/messenger/MessageEntity;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "j", "Z", "o", "c", "Ljava/lang/String;", "getRemoteId", "i", "f", "getUserId", g.a, "getFromId", AuthSource.BOOKING_ORDER, "getChannelId", "e", "getType", AuthSource.OPEN_CHANNEL_LIST, "getPreview", "n", "d", "J", "getCreated", "h", "getJsonBody", "k", VKApiConst.Q, "Ljava/lang/Long;", "getReadLocallyTimestamp", "l", "getReadTimestamp", "p", "Lru/avito/android/persistence/messenger/IsReadStatus;", AuthSource.SEND_ABUSE, "getLocalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/Long;Ljava/lang/String;ZZLru/avito/android/persistence/messenger/IsReadStatus;Ljava/lang/Long;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageEntity {
    @NotNull
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    @NotNull
    public static final String COLUMN_CREATED = "created";
    @NotNull
    public static final String COLUMN_LOCAL_ID = "local_id";
    @NotNull
    public static final String COLUMN_REMOTE_ID = "remote_id";
    @NotNull
    public static final String COLUMN_USER_ID = "user_id";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @ColumnInfo(name = COLUMN_LOCAL_ID)
    @NotNull
    public final String a;
    @ColumnInfo(name = "channel_id")
    @NotNull
    public final String b;
    @ColumnInfo(index = true, name = COLUMN_REMOTE_ID)
    @Nullable
    public final String c;
    @ColumnInfo(index = true, name = "created")
    public final long d;
    @ColumnInfo(name = "type")
    @NotNull
    public final String e;
    @ColumnInfo(name = "user_id")
    @NotNull
    public final String f;
    @ColumnInfo(name = "from_id")
    @NotNull
    public final String g;
    @ColumnInfo(name = "json_body")
    @NotNull
    public final String h;
    @ColumnInfo(name = ChannelEntity.COLUMN_IS_READ)
    public final boolean i;
    @ColumnInfo(name = ChannelEntity.COLUMN_IS_SPAM)
    public final boolean j;
    @ColumnInfo(name = "is_failed")
    public final boolean k;
    @ColumnInfo(name = "read_timestamp")
    @Nullable
    public final Long l;
    @ColumnInfo(name = "preview_text")
    @Nullable
    public final String m;
    @ColumnInfo(name = "is_supported")
    public final boolean n;
    @ColumnInfo(name = "is_complete")
    public final boolean o;
    @ColumnInfo(name = "is_read_status")
    @NotNull
    public final IsReadStatus p;
    @ColumnInfo(name = "read_locally_timestamp")
    @Nullable
    public final Long q;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lru/avito/android/persistence/messenger/MessageEntity$Companion;", "", "", "COLUMN_CHANNEL_ID", "Ljava/lang/String;", "COLUMN_CREATED", "COLUMN_LOCAL_ID", "COLUMN_REMOTE_ID", "COLUMN_USER_ID", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public MessageEntity(@NotNull String str, @NotNull String str2, @Nullable String str3, long j2, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z, boolean z2, boolean z3, @Nullable Long l2, @Nullable String str8, boolean z4, boolean z5, @NotNull IsReadStatus isReadStatus, @Nullable Long l3) {
        Intrinsics.checkNotNullParameter(str, "localId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str4, "type");
        Intrinsics.checkNotNullParameter(str5, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str6, "fromId");
        Intrinsics.checkNotNullParameter(str7, "jsonBody");
        Intrinsics.checkNotNullParameter(isReadStatus, "isReadStatus");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j2;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = z;
        this.j = z2;
        this.k = z3;
        this.l = l2;
        this.m = str8;
        this.n = z4;
        this.o = z5;
        this.p = isReadStatus;
        this.q = l3;
    }

    public static /* synthetic */ MessageEntity copy$default(MessageEntity messageEntity, String str, String str2, String str3, long j2, String str4, String str5, String str6, String str7, boolean z, boolean z2, boolean z3, Long l2, String str8, boolean z4, boolean z5, IsReadStatus isReadStatus, Long l3, int i2, Object obj) {
        return messageEntity.copy((i2 & 1) != 0 ? messageEntity.a : str, (i2 & 2) != 0 ? messageEntity.b : str2, (i2 & 4) != 0 ? messageEntity.c : str3, (i2 & 8) != 0 ? messageEntity.d : j2, (i2 & 16) != 0 ? messageEntity.e : str4, (i2 & 32) != 0 ? messageEntity.f : str5, (i2 & 64) != 0 ? messageEntity.g : str6, (i2 & 128) != 0 ? messageEntity.h : str7, (i2 & 256) != 0 ? messageEntity.i : z, (i2 & 512) != 0 ? messageEntity.j : z2, (i2 & 1024) != 0 ? messageEntity.k : z3, (i2 & 2048) != 0 ? messageEntity.l : l2, (i2 & 4096) != 0 ? messageEntity.m : str8, (i2 & 8192) != 0 ? messageEntity.n : z4, (i2 & 16384) != 0 ? messageEntity.o : z5, (i2 & 32768) != 0 ? messageEntity.p : isReadStatus, (i2 & 65536) != 0 ? messageEntity.q : l3);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    public final boolean component11() {
        return this.k;
    }

    @Nullable
    public final Long component12() {
        return this.l;
    }

    @Nullable
    public final String component13() {
        return this.m;
    }

    public final boolean component14() {
        return this.n;
    }

    public final boolean component15() {
        return this.o;
    }

    @NotNull
    public final IsReadStatus component16() {
        return this.p;
    }

    @Nullable
    public final Long component17() {
        return this.q;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final String component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final MessageEntity copy(@NotNull String str, @NotNull String str2, @Nullable String str3, long j2, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z, boolean z2, boolean z3, @Nullable Long l2, @Nullable String str8, boolean z4, boolean z5, @NotNull IsReadStatus isReadStatus, @Nullable Long l3) {
        Intrinsics.checkNotNullParameter(str, "localId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str4, "type");
        Intrinsics.checkNotNullParameter(str5, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str6, "fromId");
        Intrinsics.checkNotNullParameter(str7, "jsonBody");
        Intrinsics.checkNotNullParameter(isReadStatus, "isReadStatus");
        return new MessageEntity(str, str2, str3, j2, str4, str5, str6, str7, z, z2, z3, l2, str8, z4, z5, isReadStatus, l3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageEntity)) {
            return false;
        }
        MessageEntity messageEntity = (MessageEntity) obj;
        return Intrinsics.areEqual(this.a, messageEntity.a) && Intrinsics.areEqual(this.b, messageEntity.b) && Intrinsics.areEqual(this.c, messageEntity.c) && this.d == messageEntity.d && Intrinsics.areEqual(this.e, messageEntity.e) && Intrinsics.areEqual(this.f, messageEntity.f) && Intrinsics.areEqual(this.g, messageEntity.g) && Intrinsics.areEqual(this.h, messageEntity.h) && this.i == messageEntity.i && this.j == messageEntity.j && this.k == messageEntity.k && Intrinsics.areEqual(this.l, messageEntity.l) && Intrinsics.areEqual(this.m, messageEntity.m) && this.n == messageEntity.n && this.o == messageEntity.o && Intrinsics.areEqual(this.p, messageEntity.p) && Intrinsics.areEqual(this.q, messageEntity.q);
    }

    @NotNull
    public final String getChannelId() {
        return this.b;
    }

    public final long getCreated() {
        return this.d;
    }

    @NotNull
    public final String getFromId() {
        return this.g;
    }

    @NotNull
    public final String getJsonBody() {
        return this.h;
    }

    @NotNull
    public final String getLocalId() {
        return this.a;
    }

    @Nullable
    public final String getPreview() {
        return this.m;
    }

    @Nullable
    public final Long getReadLocallyTimestamp() {
        return this.q;
    }

    @Nullable
    public final Long getReadTimestamp() {
        return this.l;
    }

    @Nullable
    public final String getRemoteId() {
        return this.c;
    }

    @NotNull
    public final String getType() {
        return this.e;
    }

    @NotNull
    public final String getUserId() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + c.a(this.d)) * 31;
        String str4 = this.e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.g;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.h;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z = this.i;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode7 + i4) * 31;
        boolean z2 = this.j;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean z3 = this.k;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i11 + i12) * 31;
        Long l2 = this.l;
        int hashCode8 = (i15 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str8 = this.m;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z4 = this.n;
        if (z4) {
            z4 = true;
        }
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int i19 = (hashCode9 + i16) * 31;
        boolean z5 = this.o;
        if (!z5) {
            i3 = z5 ? 1 : 0;
        }
        int i20 = (i19 + i3) * 31;
        IsReadStatus isReadStatus = this.p;
        int hashCode10 = (i20 + (isReadStatus != null ? isReadStatus.hashCode() : 0)) * 31;
        Long l3 = this.q;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        return hashCode10 + i2;
    }

    public final boolean isCompleteBody() {
        return this.o;
    }

    public final boolean isFailed() {
        return this.k;
    }

    public final boolean isRead() {
        return this.i;
    }

    @NotNull
    public final IsReadStatus isReadStatus() {
        return this.p;
    }

    public final boolean isSpam() {
        return this.j;
    }

    public final boolean isSupported() {
        return this.n;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MessageEntity(localId=");
        L.append(this.a);
        L.append(", channelId=");
        L.append(this.b);
        L.append(", remoteId=");
        L.append(this.c);
        L.append(", created=");
        L.append(this.d);
        L.append(", type=");
        L.append(this.e);
        L.append(", userId=");
        L.append(this.f);
        L.append(", fromId=");
        L.append(this.g);
        L.append(", jsonBody=");
        L.append(this.h);
        L.append(", isRead=");
        L.append(this.i);
        L.append(", isSpam=");
        L.append(this.j);
        L.append(", isFailed=");
        L.append(this.k);
        L.append(", readTimestamp=");
        L.append(this.l);
        L.append(", preview=");
        L.append(this.m);
        L.append(", isSupported=");
        L.append(this.n);
        L.append(", isCompleteBody=");
        L.append(this.o);
        L.append(", isReadStatus=");
        L.append(this.p);
        L.append(", readLocallyTimestamp=");
        L.append(this.q);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageEntity(String str, String str2, String str3, long j2, String str4, String str5, String str6, String str7, boolean z, boolean z2, boolean z3, Long l2, String str8, boolean z4, boolean z5, IsReadStatus isReadStatus, Long l3, int i2, j jVar) {
        this(str, str2, str3, j2, str4, str5, str6, str7, (i2 & 256) != 0 ? false : z, (i2 & 512) != 0 ? false : z2, (i2 & 1024) != 0 ? false : z3, (i2 & 2048) != 0 ? null : l2, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? true : z4, (i2 & 16384) != 0 ? true : z5, (32768 & i2) != 0 ? IsReadStatus.IS_NOT_READ : isReadStatus, (i2 & 65536) != 0 ? null : l3);
    }
}
