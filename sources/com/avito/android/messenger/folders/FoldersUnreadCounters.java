package com.avito.android.messenger.folders;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\t\u001a\u00020\u00002\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/folders/FoldersUnreadCounters;", "", "", "Lkotlin/Pair;", "Lcom/avito/android/messenger/folders/Folder;", "", "component1", "()Ljava/util/List;", "counters", "copy", "(Ljava/util/List;)Lcom/avito/android/messenger/folders/FoldersUnreadCounters;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getCounters", "<init>", "(Ljava/util/List;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FoldersUnreadCounters {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final List<Pair<Folder, Integer>> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/folders/FoldersUnreadCounters$Companion;", "", "", "Lcom/avito/android/messenger/folders/Folder;", "folders", "", "", "", "counters", "Lcom/avito/android/messenger/folders/FoldersUnreadCounters;", "from", "(Ljava/util/List;Ljava/util/Map;)Lcom/avito/android/messenger/folders/FoldersUnreadCounters;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final FoldersUnreadCounters from(@NotNull List<Folder> list, @NotNull Map<String, Integer> map) {
            Intrinsics.checkNotNullParameter(list, "folders");
            Intrinsics.checkNotNullParameter(map, "counters");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                Integer num = map.get(t.getId());
                arrayList.add(TuplesKt.to(t, Integer.valueOf(num != null ? num.intValue() : 0)));
            }
            return new FoldersUnreadCounters(arrayList);
        }

        public Companion(j jVar) {
        }
    }

    public FoldersUnreadCounters(@NotNull List<Pair<Folder, Integer>> list) {
        Intrinsics.checkNotNullParameter(list, "counters");
        this.a = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.folders.FoldersUnreadCounters */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FoldersUnreadCounters copy$default(FoldersUnreadCounters foldersUnreadCounters, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = foldersUnreadCounters.a;
        }
        return foldersUnreadCounters.copy(list);
    }

    @NotNull
    public final List<Pair<Folder, Integer>> component1() {
        return this.a;
    }

    @NotNull
    public final FoldersUnreadCounters copy(@NotNull List<Pair<Folder, Integer>> list) {
        Intrinsics.checkNotNullParameter(list, "counters");
        return new FoldersUnreadCounters(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof FoldersUnreadCounters) && Intrinsics.areEqual(this.a, ((FoldersUnreadCounters) obj).a);
        }
        return true;
    }

    @NotNull
    public final List<Pair<Folder, Integer>> getCounters() {
        return this.a;
    }

    public int hashCode() {
        List<Pair<Folder, Integer>> list = this.a;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.w(a.L("FoldersUnreadCounters(counters="), this.a, ")");
    }
}
