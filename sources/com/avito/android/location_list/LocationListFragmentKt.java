package com.avito.android.location_list;

import android.os.Bundle;
import com.avito.android.remote.model.Location;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u000b\u001a\u00020\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/Location;", "selectedLocation", "parentLocation", "", "hasRegion", "hasSearchArea", "showWholeLocation", "", "categoryId", "shouldTrackLocationEvents", "Lcom/avito/android/location_list/LocationListFragment;", "newLocationListFragmentInstance", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/Location;ZZZLjava/lang/String;Z)Lcom/avito/android/location_list/LocationListFragment;", "location-list_release"}, k = 2, mv = {1, 4, 2})
public final class LocationListFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ Location a;
        public final /* synthetic */ Location b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Location location, Location location2, boolean z, boolean z2, boolean z3, String str, boolean z4) {
            super(1);
            this.a = location;
            this.b = location2;
            this.c = z;
            this.d = z2;
            this.e = z3;
            this.f = str;
            this.g = z4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putParcelable("selected_location", this.a);
            bundle2.putParcelable("parent_location", this.b);
            bundle2.putBoolean("has_region", this.c);
            bundle2.putBoolean("has_search_area", this.d);
            bundle2.putBoolean("show_whole", this.e);
            bundle2.putString("extra_category_id", this.f);
            bundle2.putBoolean("track_location_events", this.g);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final LocationListFragment newLocationListFragmentInstance(@Nullable Location location, @Nullable Location location2, boolean z, boolean z2, boolean z3, @Nullable String str, boolean z4) {
        return (LocationListFragment) FragmentsKt.arguments$default(new LocationListFragment(), 0, new a(location, location2, z, z2, z3, str, z4), 1, null);
    }
}
