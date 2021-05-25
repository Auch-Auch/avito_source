package com.avito.android.favorites;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import androidx.core.app.JobIntentService;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.favorites.di.DaggerFavoriteAdvertsServiceComponent;
import com.avito.android.favorites.di.FavoriteAdvertsServiceComponent;
import com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsService;", "Landroidx/core/app/JobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractor;", "interactor", "Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractor;", "getInteractor", "()Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractor;", "setInteractor", "(Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractor;)V", "<init>", "Companion", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsService extends JobIntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int JOB_ID = 586;
    @NotNull
    public static final String TAG = "FavoriteAdvertsService";
    @NotNull
    public static final Intent j = new Intent();
    @NotNull
    public static final Intent k;
    @NotNull
    public static final Intent l;
    @NotNull
    public static final Intent m;
    @Inject
    public FavoriteAdvertsServiceInteractor interactor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\u000e\u001a\u00020\r8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsService$Companion;", "", "Landroid/content/Intent;", "SYNC_INTENT", "Landroid/content/Intent;", "getSYNC_INTENT$favorite_core_release", "()Landroid/content/Intent;", "UPLOAD_ONLY_INTENT", "getUPLOAD_ONLY_INTENT$favorite_core_release", "WIPE_LOCAL_ONLY_INTENT", "getWIPE_LOCAL_ONLY_INTENT$favorite_core_release", "UPLOAD_REMOVED_INTENT", "getUPLOAD_REMOVED_INTENT$favorite_core_release", "", "JOB_ID", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent getSYNC_INTENT$favorite_core_release() {
            return FavoriteAdvertsService.j;
        }

        @NotNull
        public final Intent getUPLOAD_ONLY_INTENT$favorite_core_release() {
            return FavoriteAdvertsService.k;
        }

        @NotNull
        public final Intent getUPLOAD_REMOVED_INTENT$favorite_core_release() {
            return FavoriteAdvertsService.l;
        }

        @NotNull
        public final Intent getWIPE_LOCAL_ONLY_INTENT$favorite_core_release() {
            return FavoriteAdvertsService.m;
        }

        public Companion(j jVar) {
        }
    }

    static {
        Intent putExtra = new Intent().putExtra("upload_only", true);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(KEY_UPLOAD_ONLY, true)");
        k = putExtra;
        Intent putExtra2 = new Intent().putExtra("upload_removed", true);
        Intrinsics.checkNotNullExpressionValue(putExtra2, "Intent().putExtra(KEY_UPLOAD_REMOVED, true)");
        l = putExtra2;
        Intent putExtra3 = new Intent().putExtra("wipe_local_only", true);
        Intrinsics.checkNotNullExpressionValue(putExtra3, "Intent().putExtra(KEY_WIPE_LOCAL_ONLY, true)");
        m = putExtra3;
    }

    @NotNull
    public final FavoriteAdvertsServiceInteractor getInteractor() {
        FavoriteAdvertsServiceInteractor favoriteAdvertsServiceInteractor = this.interactor;
        if (favoriteAdvertsServiceInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return favoriteAdvertsServiceInteractor;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        FavoriteAdvertsServiceComponent.Builder dependentOn = DaggerFavoriteAdvertsServiceComponent.builder().dependentOn((FavoriteAdvertsServiceDependencies) ComponentDependenciesKt.getDependencies(FavoriteAdvertsServiceDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        dependentOn.withResources(resources).build().inject(this);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getBooleanExtra("wipe_local_only", false)) {
            FavoriteAdvertsServiceInteractor favoriteAdvertsServiceInteractor = this.interactor;
            if (favoriteAdvertsServiceInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactor");
            }
            favoriteAdvertsServiceInteractor.onWipe();
        } else if (intent.getBooleanExtra("upload_only", false)) {
            FavoriteAdvertsServiceInteractor favoriteAdvertsServiceInteractor2 = this.interactor;
            if (favoriteAdvertsServiceInteractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactor");
            }
            favoriteAdvertsServiceInteractor2.onUpload();
        } else if (intent.getBooleanExtra("upload_removed", false)) {
            FavoriteAdvertsServiceInteractor favoriteAdvertsServiceInteractor3 = this.interactor;
            if (favoriteAdvertsServiceInteractor3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactor");
            }
            favoriteAdvertsServiceInteractor3.onUploadRemovedItems();
        } else {
            FavoriteAdvertsServiceInteractor favoriteAdvertsServiceInteractor4 = this.interactor;
            if (favoriteAdvertsServiceInteractor4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactor");
            }
            favoriteAdvertsServiceInteractor4.onSynchronize();
        }
    }

    public final void setInteractor(@NotNull FavoriteAdvertsServiceInteractor favoriteAdvertsServiceInteractor) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsServiceInteractor, "<set-?>");
        this.interactor = favoriteAdvertsServiceInteractor;
    }
}
