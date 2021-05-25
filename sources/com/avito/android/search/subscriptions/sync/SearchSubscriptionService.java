package com.avito.android.search.subscriptions.sync;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.subscriptions.di.DaggerSearchSubscriptionSyncComponent;
import com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionService;", "Landroidx/core/app/JobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncInteractor;", "interactor", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncInteractor;", "getInteractor", "()Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncInteractor;", "setInteractor", "(Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncInteractor;)V", "<init>", "Companion", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionService extends JobIntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public SearchSubscriptionSyncInteractor interactor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionService$Companion;", "", "Landroid/content/Context;", "context", "", "requestUpdate$subscriptions_release", "(Landroid/content/Context;)V", "requestUpdate", "startUpdate$subscriptions_release", "startUpdate", "", "updateMode", AuthSource.SEND_ABUSE, "(Landroid/content/Context;J)V", "", "JOB_ID", "I", "", "KEY_UPDATE_MODE", "Ljava/lang/String;", "<init>", "()V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final void a(Context context, long j) {
            Intent putExtra = new Intent().putExtra("updateMode", j);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(KEY_UPDATE_MODE, updateMode)");
            JobIntentService.enqueueWork(context.getApplicationContext(), SearchSubscriptionService.class, 926, putExtra);
        }

        public final void requestUpdate$subscriptions_release(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            a(applicationContext, 1);
        }

        public final void startUpdate$subscriptions_release(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            a(applicationContext, 2);
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final SearchSubscriptionSyncInteractor getInteractor() {
        SearchSubscriptionSyncInteractor searchSubscriptionSyncInteractor = this.interactor;
        if (searchSubscriptionSyncInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return searchSubscriptionSyncInteractor;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerSearchSubscriptionSyncComponent.builder().dependentOn((SearchSubscriptionDependencies) ComponentDependenciesKt.getDependencies(SearchSubscriptionDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).build().inject(this);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        long longExtra = intent.getLongExtra("updateMode", 1);
        SearchSubscriptionSyncInteractor searchSubscriptionSyncInteractor = this.interactor;
        if (searchSubscriptionSyncInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        searchSubscriptionSyncInteractor.updateIfNeeded(longExtra);
    }

    public final void setInteractor(@NotNull SearchSubscriptionSyncInteractor searchSubscriptionSyncInteractor) {
        Intrinsics.checkNotNullParameter(searchSubscriptionSyncInteractor, "<set-?>");
        this.interactor = searchSubscriptionSyncInteractor;
    }
}
