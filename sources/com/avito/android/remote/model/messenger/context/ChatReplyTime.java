package com.avito.android.remote.model.messenger.context;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 )2\u00020\u0001:\u0002*)B!\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b&\u0010'B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b&\u0010(J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J0\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\u0010R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\r¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/messenger/context/ChatReplyTime$ActionType;", "component1", "()Lcom/avito/android/remote/model/messenger/context/ChatReplyTime$ActionType;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/lang/Long;", "actionType", "text", "time", "copy", "(Lcom/avito/android/remote/model/messenger/context/ChatReplyTime$ActionType;Ljava/lang/String;Ljava/lang/Long;)Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Ljava/lang/Long;", "getTime", "Lcom/avito/android/remote/model/messenger/context/ChatReplyTime$ActionType;", "getActionType", "<init>", "(Lcom/avito/android/remote/model/messenger/context/ChatReplyTime$ActionType;Ljava/lang/String;Ljava/lang/Long;)V", "(Landroid/os/Parcel;)V", "CREATOR", "ActionType", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ChatReplyTime implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @NotNull
    private final ActionType actionType;
    @NotNull
    private final String text;
    @Nullable
    private final Long time;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChatReplyTime$ActionType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CALL", MessengerShareContentUtility.PREVIEW_DEFAULT, "models_release"}, k = 1, mv = {1, 4, 2})
    public enum ActionType {
        CALL("call"),
        DEFAULT("default");
        
        @NotNull
        private final String key;

        private ActionType(String str) {
            this.key = str;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChatReplyTime$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<ChatReplyTime> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public ChatReplyTime createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChatReplyTime(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public ChatReplyTime[] newArray(int i) {
            return new ChatReplyTime[i];
        }
    }

    public /* synthetic */ ChatReplyTime(Parcel parcel, j jVar) {
        this(parcel);
    }

    public static /* synthetic */ ChatReplyTime copy$default(ChatReplyTime chatReplyTime, ActionType actionType2, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            actionType2 = chatReplyTime.actionType;
        }
        if ((i & 2) != 0) {
            str = chatReplyTime.text;
        }
        if ((i & 4) != 0) {
            l = chatReplyTime.time;
        }
        return chatReplyTime.copy(actionType2, str, l);
    }

    @NotNull
    public final ActionType component1() {
        return this.actionType;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @Nullable
    public final Long component3() {
        return this.time;
    }

    @NotNull
    public final ChatReplyTime copy(@NotNull ActionType actionType2, @NotNull String str, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(actionType2, "actionType");
        Intrinsics.checkNotNullParameter(str, "text");
        return new ChatReplyTime(actionType2, str, l);
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
        if (!(obj instanceof ChatReplyTime)) {
            return false;
        }
        ChatReplyTime chatReplyTime = (ChatReplyTime) obj;
        return Intrinsics.areEqual(this.actionType, chatReplyTime.actionType) && Intrinsics.areEqual(this.text, chatReplyTime.text) && Intrinsics.areEqual(this.time, chatReplyTime.time);
    }

    @NotNull
    public final ActionType getActionType() {
        return this.actionType;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final Long getTime() {
        return this.time;
    }

    @Override // java.lang.Object
    public int hashCode() {
        ActionType actionType2 = this.actionType;
        int i = 0;
        int hashCode = (actionType2 != null ? actionType2.hashCode() : 0) * 31;
        String str = this.text;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.time;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChatReplyTime(actionType=");
        L.append(this.actionType);
        L.append(", text=");
        L.append(this.text);
        L.append(", time=");
        L.append(this.time);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ParcelsKt.writeEnum(parcel, this.actionType);
        parcel.writeString(this.text);
        parcel.writeValue(this.time);
    }

    public ChatReplyTime(@NotNull ActionType actionType2, @NotNull String str, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(actionType2, "actionType");
        Intrinsics.checkNotNullParameter(str, "text");
        this.actionType = actionType2;
        this.text = str;
        this.time = l;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ChatReplyTime(android.os.Parcel r4) {
        /*
            r3 = this;
            com.avito.android.remote.model.messenger.context.ChatReplyTime$ActionType[] r0 = com.avito.android.remote.model.messenger.context.ChatReplyTime.ActionType.values()
            java.lang.Enum r0 = com.avito.android.util.ParcelsKt.readEnum(r4, r0)
            com.avito.android.remote.model.messenger.context.ChatReplyTime$ActionType r0 = (com.avito.android.remote.model.messenger.context.ChatReplyTime.ActionType) r0
            java.lang.String r1 = "parcel.readString()!!"
            java.lang.String r1 = a2.b.a.a.a.u2(r4, r1)
            java.lang.Class r2 = java.lang.Long.TYPE
            java.lang.ClassLoader r2 = r2.getClassLoader()
            java.lang.Object r4 = r4.readValue(r2)
            boolean r2 = r4 instanceof java.lang.Long
            if (r2 != 0) goto L_0x001f
            r4 = 0
        L_0x001f:
            java.lang.Long r4 = (java.lang.Long) r4
            r3.<init>(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.messenger.context.ChatReplyTime.<init>(android.os.Parcel):void");
    }
}
