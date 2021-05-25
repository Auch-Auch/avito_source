package com.avito.android.favorite_sellers.adapter.error.action;

import android.net.Uri;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/error/action/ErrorItemAction;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "<init>", "()V", "Retry", "Lcom/avito/android/favorite_sellers/adapter/error/action/ErrorItemAction$Retry;", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public abstract class ErrorItemAction implements FavoriteSellersItemAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/error/action/ErrorItemAction$Retry;", "Lcom/avito/android/favorite_sellers/adapter/error/action/ErrorItemAction;", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getFailedUri", "()Landroid/net/Uri;", "failedUri", "<init>", "(Landroid/net/Uri;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Retry extends ErrorItemAction {
        @NotNull
        public final Uri a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Retry(@NotNull Uri uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "failedUri");
            this.a = uri;
        }

        @NotNull
        public final Uri getFailedUri() {
            return this.a;
        }
    }

    public ErrorItemAction() {
    }

    public ErrorItemAction(j jVar) {
    }
}
