package ru.sravni.android.bankproduct.utils.navigation.entity;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/entity/DataForOpenWeb;", "", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Ljava/lang/Runnable;", AuthSource.BOOKING_ORDER, "Ljava/lang/Runnable;", "getCompletionCallback", "()Ljava/lang/Runnable;", "completionCallback", "<init>", "(Landroid/net/Uri;Ljava/lang/Runnable;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DataForOpenWeb {
    @NotNull
    public final Uri a;
    @Nullable
    public final Runnable b;

    public DataForOpenWeb(@NotNull Uri uri, @Nullable Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(uri, ShareConstants.MEDIA_URI);
        this.a = uri;
        this.b = runnable;
    }

    @Nullable
    public final Runnable getCompletionCallback() {
        return this.b;
    }

    @NotNull
    public final Uri getUri() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataForOpenWeb(Uri uri, Runnable runnable, int i, j jVar) {
        this(uri, (i & 2) != 0 ? null : runnable);
    }
}
