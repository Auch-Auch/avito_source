package com.avito.android.remote.model.messenger.message;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.f;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\b\b\u0002\u0010!\u001a\u00020\u0010\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0010\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0012J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015J\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010$\u001a\u00020\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020(HÖ\u0001¢\u0006\u0004\b/\u0010*J \u00104\u001a\u0002032\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020(HÖ\u0001¢\u0006\u0004\b4\u00105R\u0016\u0010$\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b$\u00106R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0019\u00107R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001b\u00107R\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001e\u00107R\u0016\u0010 \u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b \u00106R\u0018\u0010%\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b%\u00108R\u0016\u0010!\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b!\u00106R\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\"\u00108R\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b#\u00107R\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001d\u00107R\u0016\u0010\u001c\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001c\u00109R\u0016\u0010\u001f\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010:R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001a\u00107R\u001f\u0010<\u001a\u00020;8\u0006@\u0006¢\u0006\u0012\n\u0004\b<\u0010=\u0012\u0004\b@\u0010A\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "component4", "()Lcom/avito/android/remote/model/messenger/message/MessageBody;", "component5", "component6", "", "component7", "()J", "", "component8", "()Z", "component9", "component10", "()Ljava/lang/Long;", "component11", "component12", "component13", "localId", "remoteId", "channelId", SDKConstants.PARAM_A2U_BODY, ChannelContext.Item.USER_ID, "fromId", "created", "isRead", "isFailed", "readTimestamp", "preview", "isSupported", "readLocallyTimestamp", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody;Ljava/lang/String;Ljava/lang/String;JZZLjava/lang/Long;Ljava/lang/String;ZLjava/lang/Long;)Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "Ljava/lang/String;", "Ljava/lang/Long;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "J", "Lcom/avito/android/remote/model/messenger/message/StatusCode;", "deliveryStatus", "Lcom/avito/android/remote/model/messenger/message/StatusCode;", "getDeliveryStatus", "()Lcom/avito/android/remote/model/messenger/message/StatusCode;", "getDeliveryStatus$annotations", "()V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody;Ljava/lang/String;Ljava/lang/String;JZZLjava/lang/Long;Ljava/lang/String;ZLjava/lang/Long;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LocalMessage implements Parcelable {
    public static final Parcelable.Creator<LocalMessage> CREATOR = new Creator();
    @JvmField
    @NotNull
    public final MessageBody body;
    @JvmField
    @NotNull
    public final String channelId;
    @JvmField
    public final long created;
    @NotNull
    private final StatusCode deliveryStatus;
    @JvmField
    @NotNull
    public final String fromId;
    @JvmField
    public final boolean isFailed;
    @JvmField
    public final boolean isRead;
    @JvmField
    public final boolean isSupported;
    @JvmField
    @NotNull
    public final String localId;
    @JvmField
    @Nullable
    public final String preview;
    @JvmField
    @Nullable
    public final Long readLocallyTimestamp;
    @JvmField
    @Nullable
    public final Long readTimestamp;
    @JvmField
    @Nullable
    public final String remoteId;
    @JvmField
    @NotNull
    public final String userId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LocalMessage> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocalMessage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LocalMessage(parcel.readString(), parcel.readString(), parcel.readString(), (MessageBody) parcel.readParcelable(LocalMessage.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocalMessage[] newArray(int i) {
            return new LocalMessage[i];
        }
    }

    public LocalMessage(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull MessageBody messageBody, @NotNull String str4, @NotNull String str5, long j, boolean z, boolean z2, @Nullable Long l, @Nullable String str6, boolean z3, @Nullable Long l2) {
        StatusCode statusCode;
        Intrinsics.checkNotNullParameter(str, "localId");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        Intrinsics.checkNotNullParameter(messageBody, SDKConstants.PARAM_A2U_BODY);
        Intrinsics.checkNotNullParameter(str4, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str5, "fromId");
        this.localId = str;
        this.remoteId = str2;
        this.channelId = str3;
        this.body = messageBody;
        this.userId = str4;
        this.fromId = str5;
        this.created = j;
        this.isRead = z;
        this.isFailed = z2;
        this.readTimestamp = l;
        this.preview = str6;
        this.isSupported = z3;
        this.readLocallyTimestamp = l2;
        if (str2 == null && !z2) {
            statusCode = StatusCode.SENDING;
        } else if (str2 == null && z2) {
            statusCode = StatusCode.ERROR;
        } else if (l != null) {
            statusCode = StatusCode.READ;
        } else {
            statusCode = StatusCode.SENT;
        }
        this.deliveryStatus = statusCode;
    }

    public static /* synthetic */ LocalMessage copy$default(LocalMessage localMessage, String str, String str2, String str3, MessageBody messageBody, String str4, String str5, long j, boolean z, boolean z2, Long l, String str6, boolean z3, Long l2, int i, Object obj) {
        return localMessage.copy((i & 1) != 0 ? localMessage.localId : str, (i & 2) != 0 ? localMessage.remoteId : str2, (i & 4) != 0 ? localMessage.channelId : str3, (i & 8) != 0 ? localMessage.body : messageBody, (i & 16) != 0 ? localMessage.userId : str4, (i & 32) != 0 ? localMessage.fromId : str5, (i & 64) != 0 ? localMessage.created : j, (i & 128) != 0 ? localMessage.isRead : z, (i & 256) != 0 ? localMessage.isFailed : z2, (i & 512) != 0 ? localMessage.readTimestamp : l, (i & 1024) != 0 ? localMessage.preview : str6, (i & 2048) != 0 ? localMessage.isSupported : z3, (i & 4096) != 0 ? localMessage.readLocallyTimestamp : l2);
    }

    public static /* synthetic */ void getDeliveryStatus$annotations() {
    }

    @NotNull
    public final String component1() {
        return this.localId;
    }

    @Nullable
    public final Long component10() {
        return this.readTimestamp;
    }

    @Nullable
    public final String component11() {
        return this.preview;
    }

    public final boolean component12() {
        return this.isSupported;
    }

    @Nullable
    public final Long component13() {
        return this.readLocallyTimestamp;
    }

    @Nullable
    public final String component2() {
        return this.remoteId;
    }

    @NotNull
    public final String component3() {
        return this.channelId;
    }

    @NotNull
    public final MessageBody component4() {
        return this.body;
    }

    @NotNull
    public final String component5() {
        return this.userId;
    }

    @NotNull
    public final String component6() {
        return this.fromId;
    }

    public final long component7() {
        return this.created;
    }

    public final boolean component8() {
        return this.isRead;
    }

    public final boolean component9() {
        return this.isFailed;
    }

    @NotNull
    public final LocalMessage copy(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull MessageBody messageBody, @NotNull String str4, @NotNull String str5, long j, boolean z, boolean z2, @Nullable Long l, @Nullable String str6, boolean z3, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "localId");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        Intrinsics.checkNotNullParameter(messageBody, SDKConstants.PARAM_A2U_BODY);
        Intrinsics.checkNotNullParameter(str4, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str5, "fromId");
        return new LocalMessage(str, str2, str3, messageBody, str4, str5, j, z, z2, l, str6, z3, l2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalMessage)) {
            return false;
        }
        LocalMessage localMessage = (LocalMessage) obj;
        return Intrinsics.areEqual(this.localId, localMessage.localId) && Intrinsics.areEqual(this.remoteId, localMessage.remoteId) && Intrinsics.areEqual(this.channelId, localMessage.channelId) && Intrinsics.areEqual(this.body, localMessage.body) && Intrinsics.areEqual(this.userId, localMessage.userId) && Intrinsics.areEqual(this.fromId, localMessage.fromId) && this.created == localMessage.created && this.isRead == localMessage.isRead && this.isFailed == localMessage.isFailed && Intrinsics.areEqual(this.readTimestamp, localMessage.readTimestamp) && Intrinsics.areEqual(this.preview, localMessage.preview) && this.isSupported == localMessage.isSupported && Intrinsics.areEqual(this.readLocallyTimestamp, localMessage.readLocallyTimestamp);
    }

    @NotNull
    public final StatusCode getDeliveryStatus() {
        return this.deliveryStatus;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.localId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.remoteId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channelId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        MessageBody messageBody = this.body;
        int hashCode4 = (hashCode3 + (messageBody != null ? messageBody.hashCode() : 0)) * 31;
        String str4 = this.userId;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.fromId;
        int hashCode6 = (((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + c.a(this.created)) * 31;
        boolean z = this.isRead;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode6 + i3) * 31;
        boolean z2 = this.isFailed;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (i6 + i7) * 31;
        Long l = this.readTimestamp;
        int hashCode7 = (i10 + (l != null ? l.hashCode() : 0)) * 31;
        String str6 = this.preview;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z3 = this.isSupported;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        int i11 = (hashCode8 + i2) * 31;
        Long l2 = this.readLocallyTimestamp;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return i11 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("LocalMessage(\n            |localId='");
        L.append(this.localId);
        L.append("',\n            |remoteId=");
        L.append(this.remoteId);
        L.append(",\n            |channelId='");
        L.append(this.channelId);
        L.append("',\n            |body=");
        L.append(this.body);
        L.append(",\n            |userId='");
        L.append(this.userId);
        L.append("',\n            |fromId='");
        L.append(this.fromId);
        L.append("',\n            |created=");
        L.append(this.created);
        L.append(",\n            |isRead=");
        L.append(this.isRead);
        L.append(",\n            |isFailed=");
        L.append(this.isFailed);
        L.append(",\n            |readTimestamp=");
        L.append(this.readTimestamp);
        L.append(",\n            |preview=");
        L.append(this.preview);
        L.append(",\n            |isSupported=");
        L.append(this.isSupported);
        L.append("\n            |readLocallyTimestamp=");
        L.append(this.readLocallyTimestamp);
        L.append("\n        )");
        return f.trimMargin$default(L.toString(), null, 1, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.localId);
        parcel.writeString(this.remoteId);
        parcel.writeString(this.channelId);
        parcel.writeParcelable(this.body, i);
        parcel.writeString(this.userId);
        parcel.writeString(this.fromId);
        parcel.writeLong(this.created);
        parcel.writeInt(this.isRead ? 1 : 0);
        parcel.writeInt(this.isFailed ? 1 : 0);
        Long l = this.readTimestamp;
        if (l != null) {
            a.I0(parcel, 1, l);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.preview);
        parcel.writeInt(this.isSupported ? 1 : 0);
        Long l2 = this.readLocallyTimestamp;
        if (l2 != null) {
            a.I0(parcel, 1, l2);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalMessage(String str, String str2, String str3, MessageBody messageBody, String str4, String str5, long j, boolean z, boolean z2, Long l, String str6, boolean z3, Long l2, int i, j jVar) {
        this(str, str2, str3, messageBody, str4, str5, j, z, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? true : z3, (i & 4096) != 0 ? null : l2);
    }
}
