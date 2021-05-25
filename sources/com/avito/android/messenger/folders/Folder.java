package com.avito.android.messenger.folders;

import a2.b.a.a.a;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0005\u0012\"\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bj\u0002`\n\u0012&\u0010\u0012\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n\u0012\"\u0010\u0013\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bj\u0002`\n¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bj\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\r\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ,\u0010\u000e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bj\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0001\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0003\u0010\u0010\u001a\u00020\u00052$\b\u0002\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bj\u0002`\n2(\b\u0002\u0010\u0012\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n2$\b\u0002\u0010\u0013\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bj\u0002`\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R5\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bj\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R5\u0010\u0013\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bj\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\fR9\u0010\u0012\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\f¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/folders/Folder;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "Lkotlin/Pair;", "Ljava/util/SortedSet;", "Lcom/avito/android/messenger/folders/ChatListTags;", "component3", "()Lkotlin/Pair;", "component4", "component5", "id", "displayName", "mainTags", "pinnedTags", "mergedTags", "copy", "(Ljava/lang/String;ILkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)Lcom/avito/android/messenger/folders/Folder;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "c", "Lkotlin/Pair;", "getMainTags", AuthSource.BOOKING_ORDER, "I", "getDisplayName", "e", "getMergedTags", "d", "getPinnedTags", "<init>", "(Ljava/lang/String;ILkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Folder {
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final Pair<SortedSet<String>, SortedSet<String>> c;
    @Nullable
    public final Pair<SortedSet<String>, SortedSet<String>> d;
    @NotNull
    public final Pair<SortedSet<String>, SortedSet<String>> e;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public Folder(@NotNull String str, @StringRes int i, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, @Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(pair, "mainTags");
        Intrinsics.checkNotNullParameter(pair3, "mergedTags");
        this.a = str;
        this.b = i;
        this.c = pair;
        this.d = pair2;
        this.e = pair3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.messenger.folders.Folder */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Folder copy$default(Folder folder, String str, int i, Pair pair, Pair pair2, Pair pair3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = folder.a;
        }
        if ((i2 & 2) != 0) {
            i = folder.b;
        }
        if ((i2 & 4) != 0) {
            pair = folder.c;
        }
        if ((i2 & 8) != 0) {
            pair2 = folder.d;
        }
        if ((i2 & 16) != 0) {
            pair3 = folder.e;
        }
        return folder.copy(str, i, pair, pair2, pair3);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final Pair<SortedSet<String>, SortedSet<String>> component3() {
        return this.c;
    }

    @Nullable
    public final Pair<SortedSet<String>, SortedSet<String>> component4() {
        return this.d;
    }

    @NotNull
    public final Pair<SortedSet<String>, SortedSet<String>> component5() {
        return this.e;
    }

    @NotNull
    public final Folder copy(@NotNull String str, @StringRes int i, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, @Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(pair, "mainTags");
        Intrinsics.checkNotNullParameter(pair3, "mergedTags");
        return new Folder(str, i, pair, pair2, pair3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Folder)) {
            return false;
        }
        Folder folder = (Folder) obj;
        return Intrinsics.areEqual(this.a, folder.a) && this.b == folder.b && Intrinsics.areEqual(this.c, folder.c) && Intrinsics.areEqual(this.d, folder.d) && Intrinsics.areEqual(this.e, folder.e);
    }

    public final int getDisplayName() {
        return this.b;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final Pair<SortedSet<String>, SortedSet<String>> getMainTags() {
        return this.c;
    }

    @NotNull
    public final Pair<SortedSet<String>, SortedSet<String>> getMergedTags() {
        return this.e;
    }

    @Nullable
    public final Pair<SortedSet<String>, SortedSet<String>> getPinnedTags() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
        Pair<SortedSet<String>, SortedSet<String>> pair = this.c;
        int hashCode2 = (hashCode + (pair != null ? pair.hashCode() : 0)) * 31;
        Pair<SortedSet<String>, SortedSet<String>> pair2 = this.d;
        int hashCode3 = (hashCode2 + (pair2 != null ? pair2.hashCode() : 0)) * 31;
        Pair<SortedSet<String>, SortedSet<String>> pair3 = this.e;
        if (pair3 != null) {
            i = pair3.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Folder(id=");
        L.append(this.a);
        L.append(", displayName=");
        L.append(this.b);
        L.append(", mainTags=");
        L.append(this.c);
        L.append(", pinnedTags=");
        L.append(this.d);
        L.append(", mergedTags=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }
}
