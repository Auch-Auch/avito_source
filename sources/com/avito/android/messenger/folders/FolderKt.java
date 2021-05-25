package com.avito.android.messenger.folders;

import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aH\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\u0004j\u0002`\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0007\":\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\u0004j\u0002`\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\t\":\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\u0004j\u0002`\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\t\"\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f*:\u0010\r\"\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\u00042\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\u0004¨\u0006\u000e"}, d2 = {"Ljava/util/SortedSet;", "", "include", "exclude", "Lkotlin/Pair;", "Lcom/avito/android/messenger/folders/ChatListTags;", "chatListTags", "(Ljava/util/SortedSet;Ljava/util/SortedSet;)Lkotlin/Pair;", "getInclude", "(Lkotlin/Pair;)Ljava/util/SortedSet;", "getExclude", "TAG_SUPPORT", "Ljava/lang/String;", "ChatListTags", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class FolderKt {
    @NotNull
    public static final String TAG_SUPPORT = "s";

    @NotNull
    public static final Pair<SortedSet<String>, SortedSet<String>> chatListTags(@NotNull SortedSet<String> sortedSet, @NotNull SortedSet<String> sortedSet2) {
        Intrinsics.checkNotNullParameter(sortedSet, "include");
        Intrinsics.checkNotNullParameter(sortedSet2, "exclude");
        return TuplesKt.to(sortedSet, sortedSet2);
    }

    @NotNull
    public static final SortedSet<String> getExclude(@NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$exclude");
        return (SortedSet) pair.getSecond();
    }

    @NotNull
    public static final SortedSet<String> getInclude(@NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$include");
        return (SortedSet) pair.getFirst();
    }
}
