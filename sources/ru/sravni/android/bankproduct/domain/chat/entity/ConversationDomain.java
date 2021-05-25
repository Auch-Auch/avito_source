package ru.sravni.android.bankproduct.domain.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\fR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/ConversationDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "component3", "()Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageDomain;", "component4", "()Ljava/util/List;", "id", "status", "contentCard", "messages", "copy", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/chat/entity/ConversationDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "getContentCard", "d", "Ljava/util/List;", "getMessages", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStatus", AuthSource.SEND_ABUSE, "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationDomain {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final IContentCardDomain c;
    @NotNull
    public final List<ConversationMessageDomain> d;

    public ConversationDomain(@NotNull String str, @NotNull String str2, @Nullable IContentCardDomain iContentCardDomain, @NotNull List<ConversationMessageDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "status");
        Intrinsics.checkParameterIsNotNull(list, "messages");
        this.a = str;
        this.b = str2;
        this.c = iContentCardDomain;
        this.d = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationDomain copy$default(ConversationDomain conversationDomain, String str, String str2, IContentCardDomain iContentCardDomain, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversationDomain.a;
        }
        if ((i & 2) != 0) {
            str2 = conversationDomain.b;
        }
        if ((i & 4) != 0) {
            iContentCardDomain = conversationDomain.c;
        }
        if ((i & 8) != 0) {
            list = conversationDomain.d;
        }
        return conversationDomain.copy(str, str2, iContentCardDomain, list);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final IContentCardDomain component3() {
        return this.c;
    }

    @NotNull
    public final List<ConversationMessageDomain> component4() {
        return this.d;
    }

    @NotNull
    public final ConversationDomain copy(@NotNull String str, @NotNull String str2, @Nullable IContentCardDomain iContentCardDomain, @NotNull List<ConversationMessageDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "status");
        Intrinsics.checkParameterIsNotNull(list, "messages");
        return new ConversationDomain(str, str2, iContentCardDomain, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationDomain)) {
            return false;
        }
        ConversationDomain conversationDomain = (ConversationDomain) obj;
        return Intrinsics.areEqual(this.a, conversationDomain.a) && Intrinsics.areEqual(this.b, conversationDomain.b) && Intrinsics.areEqual(this.c, conversationDomain.c) && Intrinsics.areEqual(this.d, conversationDomain.d);
    }

    @Nullable
    public final IContentCardDomain getContentCard() {
        return this.c;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final List<ConversationMessageDomain> getMessages() {
        return this.d;
    }

    @NotNull
    public final String getStatus() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        IContentCardDomain iContentCardDomain = this.c;
        int hashCode3 = (hashCode2 + (iContentCardDomain != null ? iContentCardDomain.hashCode() : 0)) * 31;
        List<ConversationMessageDomain> list = this.d;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ConversationDomain(id=");
        L.append(this.a);
        L.append(", status=");
        L.append(this.b);
        L.append(", contentCard=");
        L.append(this.c);
        L.append(", messages=");
        return a.w(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationDomain(String str, String str2, IContentCardDomain iContentCardDomain, List list, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : iContentCardDomain, (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
