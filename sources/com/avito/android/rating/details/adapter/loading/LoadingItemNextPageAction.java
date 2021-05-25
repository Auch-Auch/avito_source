package com.avito.android.rating.details.adapter.loading;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/rating/details/adapter/loading/LoadingItemNextPageAction;", "", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getNextPage", "()Landroid/net/Uri;", "nextPage", "<init>", "(Landroid/net/Uri;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class LoadingItemNextPageAction {
    @NotNull
    public final Uri a;

    public LoadingItemNextPageAction(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        this.a = uri;
    }

    @NotNull
    public final Uri getNextPage() {
        return this.a;
    }
}
