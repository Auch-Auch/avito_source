package com.avito.android.messenger.conversation.mvi.file_upload;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J.\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo;", "", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "localId", ChannelContext.Item.USER_ID, "channelId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getChannelId", AuthSource.BOOKING_ORDER, "getUserId", AuthSource.SEND_ABUSE, "getLocalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UploadUniqueInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo$Companion;", "", "", "uniqueInfoStr", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo;", "fromString", "(Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo;", "DELIMITER", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @Nullable
        public final UploadUniqueInfo fromString(@NotNull String str) {
            boolean z;
            Intrinsics.checkNotNullParameter(str, "uniqueInfoStr");
            List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"||"}, false, 0, 6, (Object) null);
            if (!(split$default instanceof Collection) || !split$default.isEmpty()) {
                Iterator it = split$default.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    if (!(!(str2 == null || m.isBlank(str2)))) {
                        z = false;
                        break;
                    }
                }
                if (!z && split$default.size() == 3) {
                    return new UploadUniqueInfo((String) split$default.get(0), (String) split$default.get(1), (String) split$default.get(2));
                }
            }
            z = true;
            return !z ? null : null;
        }

        public Companion(j jVar) {
        }
    }

    public UploadUniqueInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "localId", str2, ChannelContext.Item.USER_ID, str3, "channelId");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static /* synthetic */ UploadUniqueInfo copy$default(UploadUniqueInfo uploadUniqueInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadUniqueInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = uploadUniqueInfo.b;
        }
        if ((i & 4) != 0) {
            str3 = uploadUniqueInfo.c;
        }
        return uploadUniqueInfo.copy(str, str2, str3);
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
    public final UploadUniqueInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "localId");
        Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str3, "channelId");
        return new UploadUniqueInfo(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadUniqueInfo)) {
            return false;
        }
        UploadUniqueInfo uploadUniqueInfo = (UploadUniqueInfo) obj;
        return Intrinsics.areEqual(this.a, uploadUniqueInfo.a) && Intrinsics.areEqual(this.b, uploadUniqueInfo.b) && Intrinsics.areEqual(this.c, uploadUniqueInfo.c);
    }

    @NotNull
    public final String getChannelId() {
        return this.c;
    }

    @NotNull
    public final String getLocalId() {
        return this.a;
    }

    @NotNull
    public final String getUserId() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return this.a + "||" + this.b + "||" + this.c;
    }
}
