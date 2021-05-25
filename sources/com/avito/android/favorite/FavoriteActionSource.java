package com.avito.android.favorite;

import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0016\u0017\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\u0001\u0003\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/favorite/FavoriteActionSource;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContext", "()Ljava/lang/String;", "context", "c", "Z", "isMarketplace", "()Z", AuthSource.SEND_ABUSE, "getValue", "value", "Favorites", "Item", "Snippet", "Lcom/avito/android/favorite/FavoriteActionSource$Favorites;", "Lcom/avito/android/favorite/FavoriteActionSource$Item;", "Lcom/avito/android/favorite/FavoriteActionSource$Snippet;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class FavoriteActionSource {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    public final boolean c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/favorite/FavoriteActionSource$Favorites;", "Lcom/avito/android/favorite/FavoriteActionSource;", "", "context", "<init>", "(Ljava/lang/String;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Favorites extends FavoriteActionSource {
        public Favorites(@Nullable String str) {
            super("favourites", str, false, 4);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite/FavoriteActionSource$Item;", "Lcom/avito/android/favorite/FavoriteActionSource;", "", "context", "", "isMarketplace", "<init>", "(Ljava/lang/String;Z)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item extends FavoriteActionSource {
        public Item(@Nullable String str, boolean z) {
            super("item", str, z, (j) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/favorite/FavoriteActionSource$Snippet;", "Lcom/avito/android/favorite/FavoriteActionSource;", "", "context", "<init>", "(Ljava/lang/String;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Snippet extends FavoriteActionSource {
        public Snippet(@Nullable String str) {
            super("snippet", str, false, 4);
        }
    }

    public FavoriteActionSource(String str, String str2, boolean z, int i) {
        z = (i & 4) != 0 ? false : z;
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.favorite.FavoriteActionSource");
        FavoriteActionSource favoriteActionSource = (FavoriteActionSource) obj;
        return !(Intrinsics.areEqual(this.a, favoriteActionSource.a) ^ true) && !(Intrinsics.areEqual(this.b, favoriteActionSource.b) ^ true);
    }

    @Nullable
    public final String getContext() {
        return this.b;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean isMarketplace() {
        return this.c;
    }

    public FavoriteActionSource(String str, String str2, boolean z, j jVar) {
        this.a = str;
        this.b = str2;
        this.c = z;
    }
}
