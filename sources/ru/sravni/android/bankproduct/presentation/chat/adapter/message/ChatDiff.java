package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ@\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\nR\u0013\u0010 \u001a\u00020\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\n¨\u0006&"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatDiff;", "", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "replacedElement", "newElement", "replaceAddedElement", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;)Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatDiff;", "", "", "component1", "()Ljava/util/List;", "component2", "component3", AdvertStatus.REMOVED, "addedToEnd", "mutated", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatDiff;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/util/List;", "getMutated", AuthSource.BOOKING_ORDER, "getAddedToEnd", "isEmpty", "()Z", AuthSource.SEND_ABUSE, "getRemoved", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatDiff {
    @NotNull
    public final List<Integer> a;
    @NotNull
    public final List<ChatViewCard> b;
    @NotNull
    public final List<ChatViewCard> c;

    public ChatDiff() {
        this(null, null, null, 7, null);
    }

    public ChatDiff(@NotNull List<Integer> list, @NotNull List<ChatViewCard> list2, @NotNull List<ChatViewCard> list3) {
        Intrinsics.checkParameterIsNotNull(list, AdvertStatus.REMOVED);
        Intrinsics.checkParameterIsNotNull(list2, "addedToEnd");
        Intrinsics.checkParameterIsNotNull(list3, "mutated");
        this.a = list;
        this.b = list2;
        this.c = list3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.presentation.chat.adapter.message.ChatDiff */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatDiff copy$default(ChatDiff chatDiff, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = chatDiff.a;
        }
        if ((i & 2) != 0) {
            list2 = chatDiff.b;
        }
        if ((i & 4) != 0) {
            list3 = chatDiff.c;
        }
        return chatDiff.copy(list, list2, list3);
    }

    @NotNull
    public final List<Integer> component1() {
        return this.a;
    }

    @NotNull
    public final List<ChatViewCard> component2() {
        return this.b;
    }

    @NotNull
    public final List<ChatViewCard> component3() {
        return this.c;
    }

    @NotNull
    public final ChatDiff copy(@NotNull List<Integer> list, @NotNull List<ChatViewCard> list2, @NotNull List<ChatViewCard> list3) {
        Intrinsics.checkParameterIsNotNull(list, AdvertStatus.REMOVED);
        Intrinsics.checkParameterIsNotNull(list2, "addedToEnd");
        Intrinsics.checkParameterIsNotNull(list3, "mutated");
        return new ChatDiff(list, list2, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatDiff)) {
            return false;
        }
        ChatDiff chatDiff = (ChatDiff) obj;
        return Intrinsics.areEqual(this.a, chatDiff.a) && Intrinsics.areEqual(this.b, chatDiff.b) && Intrinsics.areEqual(this.c, chatDiff.c);
    }

    @NotNull
    public final List<ChatViewCard> getAddedToEnd() {
        return this.b;
    }

    @NotNull
    public final List<ChatViewCard> getMutated() {
        return this.c;
    }

    @NotNull
    public final List<Integer> getRemoved() {
        return this.a;
    }

    public int hashCode() {
        List<Integer> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<ChatViewCard> list2 = this.b;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ChatViewCard> list3 = this.c;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode2 + i;
    }

    public final boolean isEmpty() {
        return this.a.isEmpty() && this.b.isEmpty() && this.c.isEmpty();
    }

    @NotNull
    public final ChatDiff replaceAddedElement(@NotNull ChatViewCard chatViewCard, @NotNull ChatViewCard chatViewCard2) {
        Intrinsics.checkParameterIsNotNull(chatViewCard, "replacedElement");
        Intrinsics.checkParameterIsNotNull(chatViewCard2, "newElement");
        List<ChatViewCard> list = this.b;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            if (Intrinsics.areEqual(t, chatViewCard)) {
                t = chatViewCard2;
            }
            arrayList.add(t);
        }
        return copy$default(this, null, arrayList, null, 5, null);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChatDiff(removed=");
        L.append(this.a);
        L.append(", addedToEnd=");
        L.append(this.b);
        L.append(", mutated=");
        return a.w(L, this.c, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatDiff(List list, List list2, List list3, int i, j jVar) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3);
    }
}
