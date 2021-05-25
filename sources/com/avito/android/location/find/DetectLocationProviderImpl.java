package com.avito.android.location.find;

import android.location.Location;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/location/find/DetectLocationProviderImpl;", "Lcom/avito/android/location/find/DetectLocationProvider;", "", "showDialog", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/location/Location;", "locationStream", "(Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location/find/DetectLocationInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/location/find/DetectLocationInteractor;", "detectLocationInteractor", "<init>", "(Lcom/avito/android/location/find/DetectLocationInteractor;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class DetectLocationProviderImpl implements DetectLocationProvider {
    public DetectLocationInteractor a;

    @Inject
    public DetectLocationProviderImpl(@NotNull DetectLocationInteractor detectLocationInteractor) {
        Intrinsics.checkNotNullParameter(detectLocationInteractor, "detectLocationInteractor");
        this.a = detectLocationInteractor;
    }

    @Override // com.avito.android.location.find.DetectLocationProvider
    @NotNull
    public Observable<Location> locationStream(boolean z) {
        return InteropKt.toV3(this.a.detectLocation(z));
    }
}
