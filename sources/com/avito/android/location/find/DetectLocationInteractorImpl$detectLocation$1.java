package com.avito.android.location.find;

import android.location.Location;
import com.avito.android.location.find.DetectLocationInteractor;
import com.avito.android.location.find.util.DetectLocationHelper;
import com.avito.android.util.Logs;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class DetectLocationInteractorImpl$detectLocation$1<T> implements ObservableOnSubscribe<Location> {
    public final /* synthetic */ DetectLocationInteractorImpl a;
    public final /* synthetic */ boolean b;

    public static final class a implements Cancellable {
        public final /* synthetic */ DetectLocationInteractorImpl$detectLocation$1 a;

        public a(DetectLocationInteractorImpl$detectLocation$1 detectLocationInteractorImpl$detectLocation$1) {
            this.a = detectLocationInteractorImpl$detectLocation$1;
        }

        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            this.a.a.a.cancelDetecting();
        }
    }

    public DetectLocationInteractorImpl$detectLocation$1(DetectLocationInteractorImpl detectLocationInteractorImpl, boolean z) {
        this.a = detectLocationInteractorImpl;
        this.b = z;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(@NotNull ObservableEmitter<Location> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        DetectLocationInteractorImpl$detectLocation$1$listener$1 detectLocationInteractorImpl$detectLocation$1$listener$1 = new DetectLocationHelper.OnLocationAvailableListener(this, observableEmitter) { // from class: com.avito.android.location.find.DetectLocationInteractorImpl$detectLocation$1$listener$1
            public final /* synthetic */ DetectLocationInteractorImpl$detectLocation$1 a;
            public final /* synthetic */ ObservableEmitter b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.location.find.util.DetectLocationHelper.OnLocationAvailableListener
            public void onLocationAvailable(@NotNull Location location) {
                Intrinsics.checkNotNullParameter(location, "location");
                ObservableEmitter observableEmitter2 = this.b;
                Intrinsics.checkNotNullExpressionValue(observableEmitter2, "emitter");
                if (!observableEmitter2.isDisposed()) {
                    this.a.a.d.saveLocation(location);
                    Logs.debug$default("Get network Coordinates: " + location, null, 2, null);
                    this.b.onNext(location);
                    this.b.onComplete();
                }
            }

            @Override // com.avito.android.location.find.util.DetectLocationHelper.OnLocationAvailableListener
            public void onLocationDetectTimeout() {
                ObservableEmitter observableEmitter2 = this.b;
                Intrinsics.checkNotNullExpressionValue(observableEmitter2, "emitter");
                if (!observableEmitter2.isDisposed()) {
                    this.b.onComplete();
                }
            }
        };
        observableEmitter.setCancellable(new a(this));
        if (this.a.a.checkLocationSettings(false, true, this.b)) {
            this.a.a.detectLocation(detectLocationInteractorImpl$detectLocation$1$listener$1, false, true, this.a.b);
        } else {
            observableEmitter.tryOnError(new DetectLocationInteractor.LocationDisabledException());
        }
    }
}
