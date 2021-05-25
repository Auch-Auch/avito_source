package com.avito.android.app.task;

import a2.a.a.j.a.c;
import a2.a.a.j.a.d;
import a2.a.a.j.a.e;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.avito.android.app.SimpleActivityLifecycleCallbacks;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/app/task/CacheWarmUpTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "newAdvertInteractor", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "<init>", "(Lru/avito/component/floating_add_advert/AddAdvertInteractor;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CacheWarmUpTask implements ApplicationBlockingStartupTask {
    public final AddAdvertInteractor newAdvertInteractor;

    public CacheWarmUpTask(@NotNull AddAdvertInteractor addAdvertInteractor) {
        Intrinsics.checkNotNullParameter(addAdvertInteractor, "newAdvertInteractor");
        this.newAdvertInteractor = addAdvertInteractor;
    }

    public static final void access$loadShortcuts(CacheWarmUpTask cacheWarmUpTask) {
        cacheWarmUpTask.newAdvertInteractor.getAdvertShortcutsLoadingProgress().takeUntil(c.a).subscribe(d.a, e.a);
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        application.registerActivityLifecycleCallbacks(new SimpleActivityLifecycleCallbacks(this, application) { // from class: com.avito.android.app.task.CacheWarmUpTask$execute$callbacks$1
            public final /* synthetic */ CacheWarmUpTask a;
            public final /* synthetic */ Application b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.b.unregisterActivityLifecycleCallbacks(this);
                CacheWarmUpTask.access$loadShortcuts(this.a);
            }
        });
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
