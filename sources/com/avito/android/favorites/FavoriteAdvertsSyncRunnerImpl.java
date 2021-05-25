package com.avito.android.favorites;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsSyncRunnerImpl;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "Landroid/content/Context;", "context", "", "startSync", "(Landroid/content/Context;)V", "startUpload", "startUploadRemoved", "startWipeLocal", "Landroid/content/Intent;", "intent", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsSyncRunnerImpl implements FavoriteAdvertsSyncRunner {
    public final void a(Context context, Intent intent) {
        JobIntentService.enqueueWork(context.getApplicationContext(), FavoriteAdvertsService.class, 586, intent);
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsSyncRunner
    public void startSync(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        a(applicationContext, FavoriteAdvertsService.Companion.getSYNC_INTENT$favorite_core_release());
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsSyncRunner
    public void startUpload(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        a(applicationContext, FavoriteAdvertsService.Companion.getUPLOAD_ONLY_INTENT$favorite_core_release());
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsSyncRunner
    public void startUploadRemoved(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        a(applicationContext, FavoriteAdvertsService.Companion.getUPLOAD_REMOVED_INTENT$favorite_core_release());
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsSyncRunner
    public void startWipeLocal(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        a(applicationContext, FavoriteAdvertsService.Companion.getWIPE_LOCAL_ONLY_INTENT$favorite_core_release());
    }
}
