package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.Completable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/app/task/SerpDbDeleteTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "<init>", "(Lcom/avito/android/util/SchedulersFactory;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SerpDbDeleteTask implements ApplicationBackgroundStartupTask {
    public final SchedulersFactory schedulers;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ Application a;

        public a(Application application) {
            this.a = application;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Boolean.valueOf(this.a.deleteDatabase("avito_brite.db"));
        }
    }

    @Inject
    public SerpDbDeleteTask(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.schedulers = schedulersFactory;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Completable.fromCallable(new a(application)).subscribeOn(this.schedulers.io()).subscribe();
    }
}
