package com.avito.android.photo_picker.legacy;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Rotation;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractorImpl;", "Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "", Tracker.Events.CREATIVE_START, "()V", "stop", "Lio/reactivex/Flowable;", "Lcom/avito/android/util/Rotation;", "getRotationFlowable", "()Lio/reactivex/Flowable;", "Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;", "orientationProvider", "<init>", "(Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class StoppableRotationInteractorImpl implements StoppableRotationInteractor {
    public final DeviceOrientationProvider a;

    public static final class a<T> implements Predicate<Integer> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullParameter(num2, "degree");
            return num2.intValue() != -1;
        }
    }

    public static final class b<T, R> implements Function<Integer, Integer> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullParameter(num2, "degree");
            return Integer.valueOf(360 - num2.intValue());
        }
    }

    public static final class c<T1, T2, R> implements BiFunction<Integer, Integer, Integer> {
        public final /* synthetic */ StoppableRotationInteractorImpl a;

        public c(StoppableRotationInteractorImpl stoppableRotationInteractorImpl) {
            this.a = stoppableRotationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiFunction
        public Integer apply(Integer num, Integer num2) {
            return Integer.valueOf(StoppableRotationInteractorImpl.access$foldDegree(this.a, num.intValue(), num2.intValue()));
        }
    }

    public static final class d<T, R> implements Function<Integer, Rotation> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Rotation apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullParameter(num2, "quarter");
            if (num2.intValue() == 0) {
                return new Rotation.Rotation_0();
            }
            if (num2.intValue() == 1) {
                return new Rotation.Rotation_90();
            }
            if (num2.intValue() == 2) {
                return new Rotation.Rotation_180();
            }
            if (num2.intValue() == 3) {
                return new Rotation.Rotation_270();
            }
            return new Rotation.Rotation_unknown();
        }
    }

    public static final class e<T> implements Predicate<Rotation> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Rotation rotation) {
            Rotation rotation2 = rotation;
            Intrinsics.checkNotNullParameter(rotation2, "it");
            return !Intrinsics.areEqual(rotation2, new Rotation.Rotation_unknown());
        }
    }

    public StoppableRotationInteractorImpl(@NotNull DeviceOrientationProvider deviceOrientationProvider) {
        Intrinsics.checkNotNullParameter(deviceOrientationProvider, "orientationProvider");
        this.a = deviceOrientationProvider;
    }

    public static final int access$foldDegree(StoppableRotationInteractorImpl stoppableRotationInteractorImpl, int i, int i2) {
        Objects.requireNonNull(stoppableRotationInteractorImpl);
        int i3 = i * 90;
        int i4 = ((i2 + 45) % 360) / 90;
        return (i4 != i && Math.min(Math.abs(i2 - StoppableRotationInteractorKt.access$normalize(i3 + -45)), Math.abs(i2 - StoppableRotationInteractorKt.access$normalize(i3 + 45))) > 20) ? i4 : i;
    }

    @Override // com.avito.android.photo_picker.legacy.RotationInteractor
    @NotNull
    public Flowable<Rotation> getRotationFlowable() {
        Flowable<R> filter = this.a.getOrientationObservable().toFlowable(BackpressureStrategy.DROP).filter(a.a).map(b.a).scan(-10, new c(this)).distinctUntilChanged().map(d.a).filter(e.a);
        Intrinsics.checkNotNullExpressionValue(filter, "orientationProvider.getO…tion.Rotation_unknown() }");
        return filter;
    }

    @Override // com.avito.android.photo_picker.legacy.StoppableRotationInteractor
    public void start() {
        this.a.start();
    }

    @Override // com.avito.android.photo_picker.legacy.StoppableRotationInteractor
    public void stop() {
        this.a.stop();
    }
}
