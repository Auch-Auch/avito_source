package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "", "<init>", "()V", "ListExpiredError", "Ok", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult$Ok;", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult$ListExpiredError;", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public abstract class FavoriteSellersLoadingResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/FavoriteSellersLoadingResult$ListExpiredError;", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class ListExpiredError extends FavoriteSellersLoadingResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ListExpiredError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/FavoriteSellersLoadingResult$Ok;", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "Lcom/avito/android/remote/model/FavoriteSellersResult;", "result", "Lcom/avito/android/remote/model/FavoriteSellersResult;", "getResult", "()Lcom/avito/android/remote/model/FavoriteSellersResult;", "<init>", "(Lcom/avito/android/remote/model/FavoriteSellersResult;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends FavoriteSellersLoadingResult {
        @NotNull
        private final FavoriteSellersResult result;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull FavoriteSellersResult favoriteSellersResult) {
            super(null);
            Intrinsics.checkNotNullParameter(favoriteSellersResult, "result");
            this.result = favoriteSellersResult;
        }

        @NotNull
        public final FavoriteSellersResult getResult() {
            return this.result;
        }
    }

    private FavoriteSellersLoadingResult() {
    }

    public /* synthetic */ FavoriteSellersLoadingResult(j jVar) {
        this();
    }
}
