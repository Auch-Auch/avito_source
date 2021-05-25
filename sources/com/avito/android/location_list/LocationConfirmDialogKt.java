package com.avito.android.location_list;

import android.os.Bundle;
import com.avito.android.remote.model.Location;
import com.avito.android.util.FragmentsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/location_list/LocationConfirmListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/location_list/LocationConfirmDialog;", "newLocationDialogInstance", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/location_list/LocationConfirmListener;)Lcom/avito/android/location_list/LocationConfirmDialog;", "location-list_release"}, k = 2, mv = {1, 4, 2})
public final class LocationConfirmDialogKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ Location a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Location location) {
            super(1);
            this.a = location;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putParcelable("key_location", this.a);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final LocationConfirmDialog newLocationDialogInstance(@Nullable Location location, @NotNull LocationConfirmListener locationConfirmListener) {
        Intrinsics.checkNotNullParameter(locationConfirmListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        LocationConfirmDialog locationConfirmDialog = (LocationConfirmDialog) FragmentsKt.arguments$default(new LocationConfirmDialog(), 0, new a(location), 1, null);
        locationConfirmDialog.setLocationListener(locationConfirmListener);
        return locationConfirmDialog;
    }
}
