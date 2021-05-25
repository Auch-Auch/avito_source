package com.avito.android.advert_core.task;

import android.app.Application;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert_core/task/FirstTimeRunTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulerFactory", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/util/preferences/Preferences;", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class FirstTimeRunTask implements ApplicationBackgroundStartupTask {
    public final Preferences preferences;
    public final SchedulersFactory3 schedulerFactory;

    public static final class a implements Action {
        public final /* synthetic */ FirstTimeRunTask a;

        public a(FirstTimeRunTask firstTimeRunTask) {
            this.a = firstTimeRunTask;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            if (!this.a.preferences.contains(FirstTimeRunTaskKt.FIRST_TIME_RUN)) {
                this.a.preferences.putLong(FirstTimeRunTaskKt.FIRST_TIME_RUN, System.currentTimeMillis());
            }
        }
    }

    public static final class b implements Action {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.warning("FirstTimeRunTask", "fail to execute", th);
        }
    }

    @Inject
    public FirstTimeRunTask(@NotNull Preferences preferences2, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(preferences2, "preferences");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulerFactory");
        this.preferences = preferences2;
        this.schedulerFactory = schedulersFactory3;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Completable.fromAction(new a(this)).subscribeOn(this.schedulerFactory.io()).subscribe(b.a, c.a);
    }
}
