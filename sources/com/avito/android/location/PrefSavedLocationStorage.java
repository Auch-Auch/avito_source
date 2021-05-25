package com.avito.android.location;

import a2.g.r.g;
import android.content.SharedPreferences;
import androidx.collection.ArrayMap;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationKt;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.preferences.Preferences;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\bA\u0010BJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0011J\u001f\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ+\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d`\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020/078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/avito/android/location/PrefSavedLocationStorage;", "Lcom/avito/android/location/SavedLocationStorage;", "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/location/LocationSource;", "source", "", "locationForcedByUser", "", "saveLocation", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/location/LocationSource;Z)V", "removeLocation", "()V", "silently", "Lcom/avito/android/location/SavedLocation;", "getLocation", "(Lcom/avito/android/location/LocationSource;Z)Lcom/avito/android/location/SavedLocation;", "()Lcom/avito/android/location/SavedLocation;", "Lkotlin/Pair;", "getLocationByPriority", "()Lkotlin/Pair;", "hasLocationFromFilters", "()Z", "Lcom/avito/android/location/SavedLocationStorage$OnLocationChangedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addLocationChangedListener", "(Lcom/avito/android/location/SavedLocationStorage$OnLocationChangedListener;)V", "removeLocationChangedListener", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getStorageTypesInfo", "()Ljava/util/HashMap;", "key", AuthSource.SEND_ABUSE, "(Ljava/lang/String;Lcom/avito/android/remote/model/Location;)V", "", "d", "Ljava/util/List;", "priorityList", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lcom/avito/android/location/LocationInfoProvider;", g.a, "Lcom/avito/android/location/LocationInfoProvider;", "locationInfoProvider", "Lcom/avito/android/location/PrefSavedLocationStorage$a;", "e", "Lcom/avito/android/location/PrefSavedLocationStorage$a;", "sharedPreferencesListener", "Lcom/google/gson/Gson;", "c", "Lcom/google/gson/Gson;", "gson", "Landroidx/collection/ArrayMap;", AuthSource.BOOKING_ORDER, "Landroidx/collection/ArrayMap;", "listeners", "Lcom/avito/android/util/preferences/Preferences;", "f", "Lcom/avito/android/util/preferences/Preferences;", "prefs", "Lcom/avito/android/location/SavedLocationMigrationHelper;", "migrationHelper", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/location/SavedLocationMigrationHelper;Lcom/avito/android/location/LocationInfoProvider;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class PrefSavedLocationStorage implements SavedLocationStorage {
    public final SharedPreferences a;
    public final ArrayMap<SavedLocationStorage.OnLocationChangedListener, a> b = new ArrayMap<>();
    public final Gson c = new Gson();
    public final List<LocationSource> d = CollectionsKt__CollectionsKt.listOf((Object[]) new LocationSource[]{LocationSource.LOCATION_FROM_LIST, LocationSource.LOCATION_FROM_COORDS});
    public a e;
    public final Preferences f;
    public final LocationInfoProvider g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LocationSource.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[5] = 1;
        }
    }

    public static final class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        public final SavedLocationStorage.OnLocationChangedListener a;

        public a(@NotNull SavedLocationStorage.OnLocationChangedListener onLocationChangedListener) {
            Intrinsics.checkNotNullParameter(onLocationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.a = onLocationChangedListener;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(@NotNull SharedPreferences sharedPreferences, @NotNull String str) {
            Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
            Intrinsics.checkNotNullParameter(str, "key");
            if (Intrinsics.areEqual(str, LocationSource.LOCATION_FROM_COORDS.getValue()) || Intrinsics.areEqual(str, LocationSource.LOCATION_FROM_LIST.getValue())) {
                this.a.onLocationChanged();
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PrefSavedLocationStorage a;
        public final /* synthetic */ Location b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PrefSavedLocationStorage prefSavedLocationStorage, Location location) {
            super(0);
            this.a = prefSavedLocationStorage;
            this.b = location;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a(LocationSource.LOCATION_FROM_LIST.getValue(), this.b);
            return Unit.INSTANCE;
        }
    }

    public PrefSavedLocationStorage(@NotNull Preferences preferences, @NotNull SavedLocationMigrationHelper savedLocationMigrationHelper, @NotNull LocationInfoProvider locationInfoProvider) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        Intrinsics.checkNotNullParameter(savedLocationMigrationHelper, "migrationHelper");
        Intrinsics.checkNotNullParameter(locationInfoProvider, "locationInfoProvider");
        this.f = preferences;
        this.g = locationInfoProvider;
        this.a = preferences.getSharedPreferences();
        if (preferences.getInt(Preference.LOCATION_VERSION, 0) == 2) {
            savedLocationMigrationHelper.migrateFrom2to3version();
        }
    }

    public final void a(String str, Location location) {
        this.a.edit().putInt(Preference.LOCATION_VERSION, 3).putString(str, this.c.toJson(FileLocationKt.convertToSave(location, System.currentTimeMillis()))).apply();
    }

    @Override // com.avito.android.location.SavedLocationStorage
    public void addLocationChangedListener(@NotNull SavedLocationStorage.OnLocationChangedListener onLocationChangedListener) {
        Intrinsics.checkNotNullParameter(onLocationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a aVar = new a(onLocationChangedListener);
        this.b.put(onLocationChangedListener, aVar);
        this.a.registerOnSharedPreferenceChangeListener(aVar);
        this.e = aVar;
    }

    @Override // com.avito.android.location.SavedLocationStorage
    @Nullable
    public SavedLocation getLocation(@NotNull LocationSource locationSource, boolean z) {
        Intrinsics.checkNotNullParameter(locationSource, "source");
        String string = this.f.getString(locationSource.getValue());
        if (string != null) {
            try {
                FileLocation fileLocation = (FileLocation) this.c.fromJson(string, (Class<Object>) FileLocation.class);
                if (fileLocation != null) {
                    Location convertFromSaved = FileLocationKt.convertFromSaved(fileLocation);
                    LocationInfoProvider locationInfoProvider = this.g;
                    LocationParameter locationParameter = LocationParameter.USER_FORCED_LOCATION_IN_SETTINGS;
                    Boolean parameter = locationInfoProvider.getParameter(locationParameter);
                    boolean z2 = false;
                    boolean booleanValue = parameter != null ? parameter.booleanValue() : false;
                    if (!z) {
                        this.g.setParameter(locationParameter, false);
                    }
                    if (convertFromSaved.getId().length() > 0) {
                        z2 = true;
                    }
                    if (z2 || convertFromSaved.getCoordinates() != null) {
                        return new SavedLocation(convertFromSaved, true, booleanValue);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        String asString = this.f.getAsString("location_id");
        String str = "";
        if (asString == null) {
            asString = str;
        }
        String string2 = this.f.getString("location_name");
        if (string2 != null) {
            str = string2;
        }
        return new SavedLocation(LocationKt.createLocation(asString, str), false, false, 4, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[EDGE_INSN: B:20:0x0033->B:13:0x0033 ?: BREAK  , SYNTHETIC] */
    @Override // com.avito.android.location.SavedLocationStorage
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.Pair<com.avito.android.location.SavedLocation, com.avito.android.location.LocationSource> getLocationByPriority() {
        /*
            r6 = this;
            java.util.List<com.avito.android.location.LocationSource> r0 = r6.d
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            r4 = r1
            com.avito.android.location.LocationSource r4 = (com.avito.android.location.LocationSource) r4
            com.avito.android.util.preferences.Preferences r5 = r6.f
            java.lang.String r4 = r4.getValue()
            java.lang.String r4 = r5.getString(r4)
            r5 = 1
            if (r4 == 0) goto L_0x002e
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            if (r5 == 0) goto L_0x0006
            goto L_0x0033
        L_0x0032:
            r1 = r3
        L_0x0033:
            com.avito.android.location.LocationSource r1 = (com.avito.android.location.LocationSource) r1
            if (r1 == 0) goto L_0x0042
            kotlin.Pair r0 = new kotlin.Pair
            r4 = 2
            com.avito.android.location.SavedLocation r2 = com.avito.android.location.SavedLocationStorage.DefaultImpls.getLocation$default(r6, r1, r2, r4, r3)
            r0.<init>(r2, r1)
            return r0
        L_0x0042:
            kotlin.Pair r0 = new kotlin.Pair
            r0.<init>(r3, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location.PrefSavedLocationStorage.getLocationByPriority():kotlin.Pair");
    }

    @Override // com.avito.android.location.SavedLocationStorage
    @NotNull
    public HashMap<LocationSource, String> getStorageTypesInfo() {
        String str;
        Location location;
        HashMap<LocationSource, String> hashMap = new HashMap<>();
        for (T t : this.d) {
            SavedLocation location$default = SavedLocationStorage.DefaultImpls.getLocation$default(this, t, false, 2, null);
            if (location$default == null || (location = location$default.getLocation()) == null || (str = location.getId()) == null) {
                str = "0";
            }
            hashMap.put(t, str);
        }
        return hashMap;
    }

    @Override // com.avito.android.location.SavedLocationStorage
    public boolean hasLocationFromFilters() {
        return this.f.contains(LocationSource.LOCATION_FROM_COORDS.getValue());
    }

    @Override // com.avito.android.location.SavedLocationStorage
    public void removeLocation() {
        SharedPreferences.Editor edit = this.a.edit();
        edit.remove(Preference.LOCATION_VERSION);
        Iterator<T> it = this.d.iterator();
        while (it.hasNext()) {
            edit.remove(it.next().getValue());
        }
        edit.apply();
    }

    @Override // com.avito.android.location.SavedLocationStorage
    public void removeLocationChangedListener(@NotNull SavedLocationStorage.OnLocationChangedListener onLocationChangedListener) {
        Intrinsics.checkNotNullParameter(onLocationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a aVar = this.b.get(onLocationChangedListener);
        if (aVar != null) {
            this.a.unregisterOnSharedPreferenceChangeListener(aVar);
        }
    }

    @Override // com.avito.android.location.SavedLocationStorage
    public void saveLocation(@NotNull Location location, @Nullable LocationSource locationSource, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(location, "location");
        this.g.setParameter(LocationParameter.USER_FORCED_LOCATION_IN_SETTINGS, z);
        if (locationSource != null && locationSource.ordinal() == 5) {
            b bVar = new b(this, location);
            ArrayMap<SavedLocationStorage.OnLocationChangedListener, a> arrayMap = this.b;
            a aVar = this.e;
            a aVar2 = arrayMap.get(aVar != null ? aVar.a : null);
            if (aVar2 != null) {
                this.a.unregisterOnSharedPreferenceChangeListener(aVar2);
            }
            bVar.invoke();
            this.a.registerOnSharedPreferenceChangeListener(aVar2);
            return;
        }
        if (locationSource == null || (str = locationSource.getValue()) == null) {
            str = LocationSource.LOCATION_FROM_LIST.getValue();
        }
        a(str, location);
    }

    @Override // com.avito.android.location.SavedLocationStorage
    @Nullable
    public SavedLocation getLocation() {
        return SavedLocationStorage.DefaultImpls.getLocation$default(this, LocationSource.LOCATION_FROM_LIST, false, 2, null);
    }
}
