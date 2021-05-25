package com.avito.android.user_adverts.expired_count;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.user_adverts.expired_count.di.DaggerUserAdvertsInfoComponent;
import com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoDependencies;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoService;", "Landroidx/core/app/JobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "onDestroy", "Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoInteractor;", "interactor", "Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoInteractor;", "getInteractor", "()Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoInteractor;", "setInteractor", "(Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoInteractor;)V", "Lio/reactivex/disposables/Disposable;", "j", "Lio/reactivex/disposables/Disposable;", "disposable", "<init>", "Companion", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsInfoService extends JobIntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public UserAdvertsInfoInteractor interactor;
    public Disposable j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoService$Companion;", "", "Landroid/content/Context;", "context", "", "forceUpdate", "", "requestUpdate$user_adverts_release", "(Landroid/content/Context;Z)V", "requestUpdate", "", "JOB_ID", "I", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ void requestUpdate$user_adverts_release$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.requestUpdate$user_adverts_release(context, z);
        }

        public final void requestUpdate$user_adverts_release(@NotNull Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            Intent intent = new Intent();
            intent.putExtra("extra_force_update", z);
            JobIntentService.enqueueWork(applicationContext.getApplicationContext(), UserAdvertsInfoService.class, 1200, intent);
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final UserAdvertsInfoInteractor getInteractor() {
        UserAdvertsInfoInteractor userAdvertsInfoInteractor = this.interactor;
        if (userAdvertsInfoInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return userAdvertsInfoInteractor;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerUserAdvertsInfoComponent.builder().dependentOn((UserAdvertsInfoDependencies) ComponentDependenciesKt.getDependencies(UserAdvertsInfoDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).build().inject(this);
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onDestroy() {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean booleanExtra = intent.getBooleanExtra("extra_force_update", false);
        UserAdvertsInfoInteractor userAdvertsInfoInteractor = this.interactor;
        if (userAdvertsInfoInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        this.j = userAdvertsInfoInteractor.updateExpiredCount(booleanExtra);
    }

    public final void setInteractor(@NotNull UserAdvertsInfoInteractor userAdvertsInfoInteractor) {
        Intrinsics.checkNotNullParameter(userAdvertsInfoInteractor, "<set-?>");
        this.interactor = userAdvertsInfoInteractor;
    }
}
