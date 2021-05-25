package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJR\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\fR!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\fR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationParamsRepo;", "component3", "()Lru/sravni/android/bankproduct/repository/chat/entity/ConversationParamsRepo;", "", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageRepo;", "component4", "()Ljava/util/List;", "", "component5", "id", "status", "params", "diffMessages", "hiddenMessagesOrder", "copy", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/repository/chat/entity/ConversationParamsRepo;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/util/List;", "getDiffMessages", "e", "getHiddenMessagesOrder", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "c", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationParamsRepo;", "getParams", AuthSource.BOOKING_ORDER, "getStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/repository/chat/entity/ConversationParamsRepo;Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final ConversationParamsRepo c;
    @NotNull
    public final List<ConversationMessageRepo> d;
    @Nullable
    public final List<Integer> e;

    public ConversationRepo(@NotNull String str, @NotNull String str2, @Nullable ConversationParamsRepo conversationParamsRepo, @NotNull List<ConversationMessageRepo> list, @Nullable List<Integer> list2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "status");
        Intrinsics.checkParameterIsNotNull(list, "diffMessages");
        this.a = str;
        this.b = str2;
        this.c = conversationParamsRepo;
        this.d = list;
        this.e = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationRepo copy$default(ConversationRepo conversationRepo, String str, String str2, ConversationParamsRepo conversationParamsRepo, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversationRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = conversationRepo.b;
        }
        if ((i & 4) != 0) {
            conversationParamsRepo = conversationRepo.c;
        }
        if ((i & 8) != 0) {
            list = conversationRepo.d;
        }
        if ((i & 16) != 0) {
            list2 = conversationRepo.e;
        }
        return conversationRepo.copy(str, str2, conversationParamsRepo, list, list2);
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
    public final ConversationParamsRepo component3() {
        return this.c;
    }

    @NotNull
    public final List<ConversationMessageRepo> component4() {
        return this.d;
    }

    @Nullable
    public final List<Integer> component5() {
        return this.e;
    }

    @NotNull
    public final ConversationRepo copy(@NotNull String str, @NotNull String str2, @Nullable ConversationParamsRepo conversationParamsRepo, @NotNull List<ConversationMessageRepo> list, @Nullable List<Integer> list2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "status");
        Intrinsics.checkParameterIsNotNull(list, "diffMessages");
        return new ConversationRepo(str, str2, conversationParamsRepo, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationRepo)) {
            return false;
        }
        ConversationRepo conversationRepo = (ConversationRepo) obj;
        return Intrinsics.areEqual(this.a, conversationRepo.a) && Intrinsics.areEqual(this.b, conversationRepo.b) && Intrinsics.areEqual(this.c, conversationRepo.c) && Intrinsics.areEqual(this.d, conversationRepo.d) && Intrinsics.areEqual(this.e, conversationRepo.e);
    }

    @NotNull
    public final List<ConversationMessageRepo> getDiffMessages() {
        return this.d;
    }

    @Nullable
    public final List<Integer> getHiddenMessagesOrder() {
        return this.e;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @Nullable
    public final ConversationParamsRepo getParams() {
        return this.c;
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
        ConversationParamsRepo conversationParamsRepo = this.c;
        int hashCode3 = (hashCode2 + (conversationParamsRepo != null ? conversationParamsRepo.hashCode() : 0)) * 31;
        List<ConversationMessageRepo> list = this.d;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<Integer> list2 = this.e;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ConversationRepo(id=");
        L.append(this.a);
        L.append(", status=");
        L.append(this.b);
        L.append(", params=");
        L.append(this.c);
        L.append(", diffMessages=");
        L.append(this.d);
        L.append(", hiddenMessagesOrder=");
        return a.w(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationRepo(String str, String str2, ConversationParamsRepo conversationParamsRepo, List list, List list2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : conversationParamsRepo, list, (i & 16) != 0 ? null : list2);
    }
}
