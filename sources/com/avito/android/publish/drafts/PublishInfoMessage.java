package com.avito.android.publish.drafts;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/publish/drafts/PublishInfoMessage;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "component3", "()Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "draftId", "message", "dialogInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/DeepLinksDialogInfo;)Lcom/avito/android/publish/drafts/PublishInfoMessage;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "c", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "getDialogInfo", AuthSource.SEND_ABUSE, "getDraftId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/DeepLinksDialogInfo;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishInfoMessage {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final DeepLinksDialogInfo c;

    public PublishInfoMessage() {
        this(null, null, null, 7, null);
    }

    public PublishInfoMessage(@Nullable String str, @Nullable String str2, @Nullable DeepLinksDialogInfo deepLinksDialogInfo) {
        this.a = str;
        this.b = str2;
        this.c = deepLinksDialogInfo;
    }

    public static /* synthetic */ PublishInfoMessage copy$default(PublishInfoMessage publishInfoMessage, String str, String str2, DeepLinksDialogInfo deepLinksDialogInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publishInfoMessage.a;
        }
        if ((i & 2) != 0) {
            str2 = publishInfoMessage.b;
        }
        if ((i & 4) != 0) {
            deepLinksDialogInfo = publishInfoMessage.c;
        }
        return publishInfoMessage.copy(str, str2, deepLinksDialogInfo);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final DeepLinksDialogInfo component3() {
        return this.c;
    }

    @NotNull
    public final PublishInfoMessage copy(@Nullable String str, @Nullable String str2, @Nullable DeepLinksDialogInfo deepLinksDialogInfo) {
        return new PublishInfoMessage(str, str2, deepLinksDialogInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishInfoMessage)) {
            return false;
        }
        PublishInfoMessage publishInfoMessage = (PublishInfoMessage) obj;
        return Intrinsics.areEqual(this.a, publishInfoMessage.a) && Intrinsics.areEqual(this.b, publishInfoMessage.b) && Intrinsics.areEqual(this.c, publishInfoMessage.c);
    }

    @Nullable
    public final DeepLinksDialogInfo getDialogInfo() {
        return this.c;
    }

    @Nullable
    public final String getDraftId() {
        return this.a;
    }

    @Nullable
    public final String getMessage() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        DeepLinksDialogInfo deepLinksDialogInfo = this.c;
        if (deepLinksDialogInfo != null) {
            i = deepLinksDialogInfo.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PublishInfoMessage(draftId=");
        L.append(this.a);
        L.append(", message=");
        L.append(this.b);
        L.append(", dialogInfo=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishInfoMessage(String str, String str2, DeepLinksDialogInfo deepLinksDialogInfo, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : deepLinksDialogInfo);
    }
}
