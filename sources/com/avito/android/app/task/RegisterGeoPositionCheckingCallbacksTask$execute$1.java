package com.avito.android.app.task;

import android.app.Activity;
import android.app.Application;
import com.avito.android.app.SimpleActivityLifecycleCallbacks;
import com.avito.android.geo.GeoService;
import com.avito.android.util.Logs;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/avito/android/app/task/RegisterGeoPositionCheckingCallbacksTask$execute$1", "Lcom/avito/android/app/SimpleActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityStopped", "geo_release"}, k = 1, mv = {1, 4, 2})
public final class RegisterGeoPositionCheckingCallbacksTask$execute$1 extends SimpleActivityLifecycleCallbacks {
    public final /* synthetic */ RegisterGeoPositionCheckingCallbacksTask a;
    public final /* synthetic */ Application b;

    public static final class a<V> implements Callable<Boolean> {
        public final /* synthetic */ RegisterGeoPositionCheckingCallbacksTask$execute$1 a;

        public a(RegisterGeoPositionCheckingCallbacksTask$execute$1 registerGeoPositionCheckingCallbacksTask$execute$1) {
            this.a = registerGeoPositionCheckingCallbacksTask$execute$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(this.a.a.getModel().isLocationExpired());
        }
    }

    public static final class b<T> implements Consumer<Boolean> {
        public final /* synthetic */ RegisterGeoPositionCheckingCallbacksTask$execute$1 a;

        public b(RegisterGeoPositionCheckingCallbacksTask$execute$1 registerGeoPositionCheckingCallbacksTask$execute$1) {
            this.a = registerGeoPositionCheckingCallbacksTask$execute$1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isLocationExpired");
            if (bool2.booleanValue() && this.a.a.getPermissionChecker().checkPermission("android.permission.ACCESS_FINE_LOCATION")) {
                this.a.b.startService(GeoService.createIntent(this.a.b));
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public RegisterGeoPositionCheckingCallbacksTask$execute$1(RegisterGeoPositionCheckingCallbacksTask registerGeoPositionCheckingCallbacksTask, Application application) {
        this.a = registerGeoPositionCheckingCallbacksTask;
        this.b = application;
    }

    @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.disposable = Observable.fromCallable(new a(this)).observeOn(this.a.getSchedulers().mainThread()).subscribeOn(this.a.getSchedulers().io()).subscribe(new b(this), c.a);
    }

    @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Disposable disposable = this.a.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
