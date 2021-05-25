package ru.sravni.android.bankproduct.presentation.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ`\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\u0004R'\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\nR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010\u0004¨\u0006-"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/util/Map;", "", "component6", "()Z", "chatName", "conversationID", "title", AnalyticFieldsName.draft, "requestParams", "isPush", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "getConversationID", "d", "getDraft", "e", "Ljava/util/Map;", "getRequestParams", "f", "Z", AuthSource.SEND_ABUSE, "getChatName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatInfo {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final Map<String, String> e;
    public final boolean f;

    public ChatInfo(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, String> map, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "chatName");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = map;
        this.f = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatInfo copy$default(ChatInfo chatInfo, String str, String str2, String str3, String str4, Map map, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = chatInfo.b;
        }
        if ((i & 4) != 0) {
            str3 = chatInfo.c;
        }
        if ((i & 8) != 0) {
            str4 = chatInfo.d;
        }
        if ((i & 16) != 0) {
            map = chatInfo.e;
        }
        if ((i & 32) != 0) {
            z = chatInfo.f;
        }
        return chatInfo.copy(str, str2, str3, str4, map, z);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final Map<String, String> component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @NotNull
    public final ChatInfo copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, String> map, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "chatName");
        return new ChatInfo(str, str2, str3, str4, map, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatInfo)) {
            return false;
        }
        ChatInfo chatInfo = (ChatInfo) obj;
        return Intrinsics.areEqual(this.a, chatInfo.a) && Intrinsics.areEqual(this.b, chatInfo.b) && Intrinsics.areEqual(this.c, chatInfo.c) && Intrinsics.areEqual(this.d, chatInfo.d) && Intrinsics.areEqual(this.e, chatInfo.e) && this.f == chatInfo.f;
    }

    @NotNull
    public final String getChatName() {
        return this.a;
    }

    @Nullable
    public final String getConversationID() {
        return this.b;
    }

    @Nullable
    public final String getDraft() {
        return this.d;
    }

    @Nullable
    public final Map<String, String> getRequestParams() {
        return this.e;
    }

    @Nullable
    public final String getTitle() {
        return this.c;
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
        Map<String, String> map = this.e;
        if (map != null) {
            i = map.hashCode();
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z = this.f;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isPush() {
        return this.f;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChatInfo(chatName=");
        L.append(this.a);
        L.append(", conversationID=");
        L.append(this.b);
        L.append(", title=");
        L.append(this.c);
        L.append(", draft=");
        L.append(this.d);
        L.append(", requestParams=");
        L.append(this.e);
        L.append(", isPush=");
        return a.B(L, this.f, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatInfo(String str, String str2, String str3, String str4, Map map, boolean z, int i, j jVar) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : map, (i & 32) != 0 ? false : z);
    }
}
