package com.avito.android.favorite;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "", "<init>", "()V", "AddedToFavorites", "FavoritesFull", "RemovedFromFavorites", "Lcom/avito/android/favorite/FavoriteAdvertsEvent$AddedToFavorites;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent$RemovedFromFavorites;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent$FavoritesFull;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class FavoriteAdvertsEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0012R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsEvent$AddedToFavorites;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getIds", "()Ljava/util/List;", "ids", "Lcom/avito/android/favorite/FavoriteActionSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite/FavoriteActionSource;", "getSrc", "()Lcom/avito/android/favorite/FavoriteActionSource;", "src", "<init>", "(Ljava/util/List;Lcom/avito/android/favorite/FavoriteActionSource;)V", "id", "(Ljava/lang/String;Lcom/avito/android/favorite/FavoriteActionSource;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class AddedToFavorites extends FavoriteAdvertsEvent {
        @NotNull
        public final List<String> a;
        @NotNull
        public final FavoriteActionSource b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddedToFavorites(@NotNull List<String> list, @NotNull FavoriteActionSource favoriteActionSource) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "ids");
            Intrinsics.checkNotNullParameter(favoriteActionSource, "src");
            this.a = list;
            this.b = favoriteActionSource;
        }

        @NotNull
        public final List<String> getIds() {
            return this.a;
        }

        @NotNull
        public final FavoriteActionSource getSrc() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public AddedToFavorites(@NotNull String str, @NotNull FavoriteActionSource favoriteActionSource) {
            this(d.listOf(str), favoriteActionSource);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(favoriteActionSource, "src");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsEvent$FavoritesFull;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class FavoritesFull extends FavoriteAdvertsEvent {
        public FavoritesFull() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsEvent$RemovedFromFavorites;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "Lcom/avito/android/favorite/FavoriteActionSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite/FavoriteActionSource;", "getSrc", "()Lcom/avito/android/favorite/FavoriteActionSource;", "src", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getIds", "()Ljava/util/List;", "ids", "<init>", "(Ljava/util/List;Lcom/avito/android/favorite/FavoriteActionSource;)V", "id", "(Ljava/lang/String;Lcom/avito/android/favorite/FavoriteActionSource;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class RemovedFromFavorites extends FavoriteAdvertsEvent {
        @NotNull
        public final List<String> a;
        @NotNull
        public final FavoriteActionSource b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RemovedFromFavorites(@NotNull List<String> list, @NotNull FavoriteActionSource favoriteActionSource) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "ids");
            Intrinsics.checkNotNullParameter(favoriteActionSource, "src");
            this.a = list;
            this.b = favoriteActionSource;
        }

        @NotNull
        public final List<String> getIds() {
            return this.a;
        }

        @NotNull
        public final FavoriteActionSource getSrc() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public RemovedFromFavorites(@NotNull String str, @NotNull FavoriteActionSource favoriteActionSource) {
            this(d.listOf(str), favoriteActionSource);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(favoriteActionSource, "src");
        }
    }

    public FavoriteAdvertsEvent() {
    }

    public FavoriteAdvertsEvent(j jVar) {
    }
}
