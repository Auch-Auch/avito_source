package com.avito.android.location_list;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/location_list/LocationConfirmPresenterImpl;", "Lcom/avito/android/location_list/LocationConfirmPresenter;", "", "handleShow", "()V", "Lcom/avito/android/remote/model/Location;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/location_list/LocationConfirmListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/location_list/LocationConfirmListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/location_list/LocationConfirmResourceProvider;", "c", "Lcom/avito/android/location_list/LocationConfirmResourceProvider;", "resProvider", "Lcom/avito/android/location_list/LocationConfirmView;", "d", "Lcom/avito/android/location_list/LocationConfirmView;", "view", "<init>", "(Lcom/avito/android/location_list/LocationConfirmListener;Lcom/avito/android/remote/model/Location;Lcom/avito/android/location_list/LocationConfirmResourceProvider;Lcom/avito/android/location_list/LocationConfirmView;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationConfirmPresenterImpl implements LocationConfirmPresenter {
    public final LocationConfirmListener a;
    public final Location b;
    public final LocationConfirmResourceProvider c;
    public final LocationConfirmView d;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ LocationConfirmPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LocationConfirmPresenterImpl locationConfirmPresenterImpl) {
            super(0);
            this.a = locationConfirmPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onLocationSelected(this.a.b);
            return Unit.INSTANCE;
        }
    }

    public LocationConfirmPresenterImpl(@NotNull LocationConfirmListener locationConfirmListener, @Nullable Location location, @NotNull LocationConfirmResourceProvider locationConfirmResourceProvider, @NotNull LocationConfirmView locationConfirmView) {
        Intrinsics.checkNotNullParameter(locationConfirmListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(locationConfirmResourceProvider, "resProvider");
        Intrinsics.checkNotNullParameter(locationConfirmView, "view");
        this.a = locationConfirmListener;
        this.b = location;
        this.c = locationConfirmResourceProvider;
        this.d = locationConfirmView;
    }

    @Override // com.avito.android.location_list.LocationConfirmPresenter
    public void handleShow() {
        Location location = this.b;
        if (location == null) {
            this.d.setMessage(this.c.getNotFoundMessage());
            this.d.setConfirm(this.c.getConfirm(), null);
        } else {
            String name = location.getName(6);
            if (name == null) {
                name = "";
            }
            this.d.setMessage(this.c.getYouLocationMessage(name));
            this.d.setConfirm(this.c.getConfirm(), new a(this));
        }
        this.d.setDecline(this.c.getDecline());
    }
}
