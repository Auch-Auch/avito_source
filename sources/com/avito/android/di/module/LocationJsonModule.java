package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.remote.model.LocationByCoordsResult;
import com.avito.android.remote.model.location_picker.AddressByCoordinatesResult;
import com.avito.android.remote.model.location_picker.AddressCoordinates;
import com.avito.android.remote.model.location_picker.AddressCoordinatesByQueryResult;
import com.avito.android.remote.model.location_picker.CoordinatesVerificationResult;
import com.avito.android.remote.model.location_picker.RadiusListResult;
import com.avito.android.remote.parse.adapter.AddressCoordinatesAdapter;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import com.avito.android.util.TypeAdapterEntry;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/di/module/LocationJsonModule;", "", "Lcom/avito/android/Features;", "features", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "(Lcom/avito/android/Features;)Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "()Ljava/util/Set;", "<init>", "()V", "location_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class LocationJsonModule {
    @NotNull
    public static final LocationJsonModule INSTANCE = new LocationJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(new LinkedHashSet(), AddressCoordinatesByQueryResult.class, r.mapOf(TuplesKt.to("ok", AddressCoordinatesByQueryResult.Ok.class), TuplesKt.to("not-found", AddressCoordinatesByQueryResult.NotFoundError.class))), AddressByCoordinatesResult.class, r.mapOf(TuplesKt.to("ok", AddressByCoordinatesResult.Ok.class), TuplesKt.to("not-found", AddressByCoordinatesResult.NotFoundAddress.class))), CoordinatesVerificationResult.class, r.mapOf(TuplesKt.to("ok", CoordinatesVerificationResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, CoordinatesVerificationResult.Failure.class))), LocationByCoordsResult.class, r.mapOf(TuplesKt.to("ok", LocationByCoordsResult.Ok.class), TuplesKt.to("not-found", LocationByCoordsResult.NotFound.class))), RadiusListResult.class, q.mapOf(TuplesKt.to("ok", RadiusListResult.Ok.class)));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(AddressCoordinates.class, new AddressCoordinatesAdapter()));
        return linkedHashSet;
    }
}
