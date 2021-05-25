package com.avito.android.favorites;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsUploadInteractorImpl;", "Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "", "upload", "()V", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "Landroid/os/Handler;", AuthSource.SEND_ABUSE, "Landroid/os/Handler;", "handler", "Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "c", "Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "favoriteAdvertsSyncRunner", "<init>", "(Landroid/content/Context;Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsUploadInteractorImpl implements FavoriteAdvertsUploadInteractor {
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Context b;
    public final FavoriteAdvertsSyncRunner c;

    public static final class a implements Runnable {
        public final /* synthetic */ FavoriteAdvertsUploadInteractorImpl a;

        public a(FavoriteAdvertsUploadInteractorImpl favoriteAdvertsUploadInteractorImpl) {
            this.a = favoriteAdvertsUploadInteractorImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.startUpload(this.a.b);
        }
    }

    public FavoriteAdvertsUploadInteractorImpl(@NotNull Context context, @NotNull FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncRunner, "favoriteAdvertsSyncRunner");
        this.b = context;
        this.c = favoriteAdvertsSyncRunner;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsUploadInteractor
    public void upload() {
        this.a.removeCallbacksAndMessages(null);
        this.a.postDelayed(new a(this), FavoriteAdvertsUploadInteractorKt.a);
    }
}
