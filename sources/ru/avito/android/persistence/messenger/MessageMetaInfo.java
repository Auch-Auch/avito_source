package ru.avito.android.persistence.messenger;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Entity(primaryKeys = {"local_user_id", "channel_id", MessageMetaInfo.COLUMN_LOCAL_MESSAGE_ID}, tableName = MessageMetaInfo.TABLE_NAME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u0000 32\u00020\u0001:\u00013BE\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJZ\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010\u0004R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010!\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u000e¨\u00064"}, d2 = {"Lru/avito/android/persistence/messenger/MessageMetaInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()J", "Lru/avito/android/persistence/messenger/TransferStatus;", "component7", "()Lru/avito/android/persistence/messenger/TransferStatus;", "localUserId", "channelId", "localMessageId", MessageMetaInfo.COLUMN_PATH, "internalPath", "progress", "transferStatus", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLru/avito/android/persistence/messenger/TransferStatus;)Lru/avito/android/persistence/messenger/MessageMetaInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getChannelId", "d", "getPath", AuthSource.SEND_ABUSE, "getLocalUserId", "e", "getInternalPath", "f", "J", "getProgress", "c", "getLocalMessageId", g.a, "Lru/avito/android/persistence/messenger/TransferStatus;", "getTransferStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLru/avito/android/persistence/messenger/TransferStatus;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageMetaInfo {
    @NotNull
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    @NotNull
    public static final String COLUMN_INTERNAL_PATH = "internal_path";
    @NotNull
    public static final String COLUMN_LOCAL_MESSAGE_ID = "local_message_id";
    @NotNull
    public static final String COLUMN_LOCAL_USER_ID = "local_user_id";
    @NotNull
    public static final String COLUMN_PATH = "path";
    @NotNull
    public static final String COLUMN_PROGRESS = "progress";
    @NotNull
    public static final String COLUMN_TRANSFER_STATUS = "transfer_status";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TABLE_NAME = "message_meta_info";
    @ColumnInfo(name = "local_user_id")
    @NotNull
    public final String a;
    @ColumnInfo(name = "channel_id")
    @NotNull
    public final String b;
    @ColumnInfo(name = COLUMN_LOCAL_MESSAGE_ID)
    @NotNull
    public final String c;
    @ColumnInfo(name = COLUMN_PATH)
    @Nullable
    public final String d;
    @ColumnInfo(name = COLUMN_INTERNAL_PATH)
    @Nullable
    public final String e;
    @ColumnInfo(name = "progress")
    public final long f;
    @ColumnInfo(name = COLUMN_TRANSFER_STATUS)
    @NotNull
    public final TransferStatus g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lru/avito/android/persistence/messenger/MessageMetaInfo$Companion;", "", "", "COLUMN_CHANNEL_ID", "Ljava/lang/String;", "COLUMN_INTERNAL_PATH", "COLUMN_LOCAL_MESSAGE_ID", "COLUMN_LOCAL_USER_ID", "COLUMN_PATH", "COLUMN_PROGRESS", "COLUMN_TRANSFER_STATUS", "TABLE_NAME", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public MessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, long j, @NotNull TransferStatus transferStatus) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localMessageId");
        Intrinsics.checkNotNullParameter(transferStatus, "transferStatus");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = j;
        this.g = transferStatus;
    }

    public static /* synthetic */ MessageMetaInfo copy$default(MessageMetaInfo messageMetaInfo, String str, String str2, String str3, String str4, String str5, long j, TransferStatus transferStatus, int i, Object obj) {
        return messageMetaInfo.copy((i & 1) != 0 ? messageMetaInfo.a : str, (i & 2) != 0 ? messageMetaInfo.b : str2, (i & 4) != 0 ? messageMetaInfo.c : str3, (i & 8) != 0 ? messageMetaInfo.d : str4, (i & 16) != 0 ? messageMetaInfo.e : str5, (i & 32) != 0 ? messageMetaInfo.f : j, (i & 64) != 0 ? messageMetaInfo.g : transferStatus);
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

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    public final long component6() {
        return this.f;
    }

    @NotNull
    public final TransferStatus component7() {
        return this.g;
    }

    @NotNull
    public final MessageMetaInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, long j, @NotNull TransferStatus transferStatus) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localMessageId");
        Intrinsics.checkNotNullParameter(transferStatus, "transferStatus");
        return new MessageMetaInfo(str, str2, str3, str4, str5, j, transferStatus);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageMetaInfo)) {
            return false;
        }
        MessageMetaInfo messageMetaInfo = (MessageMetaInfo) obj;
        return Intrinsics.areEqual(this.a, messageMetaInfo.a) && Intrinsics.areEqual(this.b, messageMetaInfo.b) && Intrinsics.areEqual(this.c, messageMetaInfo.c) && Intrinsics.areEqual(this.d, messageMetaInfo.d) && Intrinsics.areEqual(this.e, messageMetaInfo.e) && this.f == messageMetaInfo.f && Intrinsics.areEqual(this.g, messageMetaInfo.g);
    }

    @NotNull
    public final String getChannelId() {
        return this.b;
    }

    @Nullable
    public final String getInternalPath() {
        return this.e;
    }

    @NotNull
    public final String getLocalMessageId() {
        return this.c;
    }

    @NotNull
    public final String getLocalUserId() {
        return this.a;
    }

    @Nullable
    public final String getPath() {
        return this.d;
    }

    public final long getProgress() {
        return this.f;
    }

    @NotNull
    public final TransferStatus getTransferStatus() {
        return this.g;
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
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + c.a(this.f)) * 31;
        TransferStatus transferStatus = this.g;
        if (transferStatus != null) {
            i = transferStatus.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MessageMetaInfo(localUserId=");
        L.append(this.a);
        L.append(", channelId=");
        L.append(this.b);
        L.append(", localMessageId=");
        L.append(this.c);
        L.append(", path=");
        L.append(this.d);
        L.append(", internalPath=");
        L.append(this.e);
        L.append(", progress=");
        L.append(this.f);
        L.append(", transferStatus=");
        L.append(this.g);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageMetaInfo(String str, String str2, String str3, String str4, String str5, long j, TransferStatus transferStatus, int i, j jVar) {
        this(str, str2, str3, str4, str5, j, (i & 64) != 0 ? TransferStatus.NONE : transferStatus);
    }
}
