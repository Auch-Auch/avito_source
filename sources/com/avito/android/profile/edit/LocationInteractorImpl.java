package com.avito.android.profile.edit;

import a2.a.a.b2.e1.n;
import a2.a.a.b2.e1.o;
import a2.a.a.b2.e1.p;
import a2.a.a.b2.e1.q;
import a2.a.a.b2.e1.r;
import a2.g.r.g;
import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.Profile;
import com.avito.android.remote.model.Sublocation;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010,\u001a\u00020)\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006L"}, d2 = {"Lcom/avito/android/profile/edit/LocationInteractorImpl;", "Lcom/avito/android/profile/edit/LocationInteractor;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "invalidate", "()V", "", "hasLocation", "()Z", "Lcom/avito/android/remote/model/Profile;", "getProfile", "()Lcom/avito/android/remote/model/Profile;", "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "", "Lcom/avito/android/remote/model/NameIdEntity;", "getSubLocations", "()Ljava/util/List;", "getSubLocation", "()Lcom/avito/android/remote/model/NameIdEntity;", "", "getSubLocationType", "()I", "", "getSubLocationTitle", "()Ljava/lang/String;", "Lio/reactivex/Observable;", "Lcom/avito/android/profile/edit/LocationInteractor$Event;", "updateProfileLocation", "()Lio/reactivex/Observable;", "newLocation", "selectedSublocationId", "updateLocation", "(Lcom/avito/android/remote/model/Location;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/ProfileApi;", "h", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/profile/edit/LocationInteractorResourceProvider;", "j", "Lcom/avito/android/profile/edit/LocationInteractorResourceProvider;", "resourceProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/remote/LocationApi;", g.a, "Lcom/avito/android/remote/LocationApi;", "locationApi", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Profile;", "profile", "Lcom/avito/android/remote/model/Sublocation;", "e", "Ljava/util/List;", "subLocations", "f", "Ljava/lang/String;", "subLocationTitle", "d", "Lcom/avito/android/remote/model/Sublocation;", "subLocation", "Lcom/avito/android/remote/model/Sublocation$Type;", "c", "Lcom/avito/android/remote/model/Sublocation$Type;", "subLocationType", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "savedState", "<init>", "(Lcom/avito/android/remote/LocationApi;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/profile/edit/LocationInteractorResourceProvider;Lcom/avito/android/util/Kundle;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class LocationInteractorImpl implements LocationInteractor {
    public Profile a;
    public Location b;
    public Sublocation.Type c;
    public Sublocation d;
    public List<? extends Sublocation> e;
    public String f;
    public final LocationApi g;
    public final ProfileApi h;
    public final SchedulersFactory i;
    public final LocationInteractorResourceProvider j;

    public static final class a<T, R> implements Function<LocationInteractor.ProfileLocation, ObservableSource<? extends LocationInteractor.Event>> {
        public final /* synthetic */ LocationInteractorImpl a;

        public a(LocationInteractorImpl locationInteractorImpl) {
            this.a = locationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends LocationInteractor.Event> apply(LocationInteractor.ProfileLocation profileLocation) {
            LocationInteractor.ProfileLocation profileLocation2 = profileLocation;
            Intrinsics.checkNotNullParameter(profileLocation2, "it");
            Location location = profileLocation2.getLocation();
            Profile profile = profileLocation2.getProfile();
            String str = null;
            if (!(profile == null || location == null)) {
                if (location.getHasMetro()) {
                    str = String.valueOf(profile.getMetroId());
                } else if (location.getHasDistricts()) {
                    str = String.valueOf(profile.getDistrictId());
                } else if (location.getHasDirections()) {
                    str = String.valueOf(profile.getLocationId());
                }
            }
            this.a.a = profile;
            this.a.b = location;
            return this.a.updateLocation(location, str);
        }
    }

    public LocationInteractorImpl(@NotNull LocationApi locationApi, @NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull LocationInteractorResourceProvider locationInteractorResourceProvider, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(locationInteractorResourceProvider, "resourceProvider");
        this.g = locationApi;
        this.h = profileApi;
        this.i = schedulersFactory;
        this.j = locationInteractorResourceProvider;
        if (kundle != null) {
            this.a = (Profile) kundle.getParcelable("key_profile");
            this.b = (Location) kundle.getParcelable("key_location");
            this.c = (Sublocation.Type) kundle.getParcelable("key_sublocation_type");
            this.d = (Sublocation) kundle.getParcelable("key_sublocation");
            this.e = kundle.getParcelableList("key_sublocations");
            this.f = kundle.getString("key_sublocation_title");
        }
    }

    public static final Observable access$requestLocation(LocationInteractorImpl locationInteractorImpl, Profile profile, String str) {
        return InteropKt.toV2(locationInteractorImpl.g.getLocation(str)).flatMap(new q(profile));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$setSublocation(LocationInteractorImpl locationInteractorImpl, Sublocation.Type type, List list, String str) {
        String str2;
        LocationInteractorResourceProvider locationInteractorResourceProvider = locationInteractorImpl.j;
        if (type instanceof Sublocation.Type.Metro) {
            str2 = locationInteractorResourceProvider.getMetro();
        } else if (type instanceof Sublocation.Type.District) {
            str2 = locationInteractorResourceProvider.getDistricts();
        } else if (type instanceof Sublocation.Type.Direction) {
            str2 = locationInteractorResourceProvider.getDirection();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Sublocation sublocation = null;
        if (str != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual((String) ((Sublocation) next).getId(), str)) {
                    sublocation = next;
                    break;
                }
            }
            sublocation = sublocation;
        }
        locationInteractorImpl.b = locationInteractorImpl.b;
        locationInteractorImpl.c = type;
        locationInteractorImpl.d = sublocation;
        locationInteractorImpl.e = list;
        locationInteractorImpl.f = str2;
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    @Nullable
    public Location getLocation() {
        return this.b;
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    @Nullable
    public Profile getProfile() {
        return this.a;
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    @Nullable
    public NameIdEntity getSubLocation() {
        Sublocation sublocation = this.d;
        if (sublocation != null) {
            return new NameIdEntity((String) sublocation.getId(), sublocation.getName());
        }
        return null;
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    @NotNull
    public String getSubLocationTitle() {
        String str = this.f;
        return str != null ? str : "";
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    public int getSubLocationType() {
        Sublocation.Type type = this.c;
        if (type instanceof Sublocation.Type.Metro) {
            return 1;
        }
        if (type instanceof Sublocation.Type.District) {
            return 4;
        }
        return type instanceof Sublocation.Type.Direction ? 2 : 0;
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    @NotNull
    public List<NameIdEntity> getSubLocations() {
        ArrayList arrayList = new ArrayList();
        List<? extends Sublocation> list = this.e;
        if (list != null) {
            for (T t : list) {
                arrayList.add(new NameIdEntity((String) t.getId(), t.getName()));
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    public boolean hasLocation() {
        return this.b != null;
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    public void invalidate() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle putParcelable = new Kundle().putParcelable("key_profile", this.a).putParcelable("key_location", this.b).putParcelable("key_sublocation_type", this.c).putParcelable("key_sublocation", this.d);
        List<? extends Sublocation> list = this.e;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return putParcelable.putParcelableList("key_sublocations", list).putString("key_sublocation_title", this.f);
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    @NotNull
    public Observable<LocationInteractor.Event> updateLocation(@Nullable Location location, @Nullable String str) {
        Observable observable;
        Sublocation.Type type;
        io.reactivex.rxjava3.core.Observable observable2;
        List<? extends Sublocation> list;
        Location location2 = this.b;
        if (location == null) {
            location = location2;
        }
        if (location != null) {
            this.b = location;
            Sublocation.Type type2 = this.c;
            Sublocation sublocation = null;
            if (location.getHasMetro()) {
                type = new Sublocation.Type.Metro();
            } else if (location.getHasDistricts()) {
                type = new Sublocation.Type.District();
            } else {
                type = location.getHasDirections() ? new Sublocation.Type.Direction() : null;
            }
            if (type == null) {
                this.c = null;
                this.d = null;
                this.f = null;
                observable = Observable.just(new LocationInteractor.Event.Loaded());
                Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
            } else if (!Intrinsics.areEqual(location2, location) || !Intrinsics.areEqual(type2, type) || (list = this.e) == null) {
                this.c = null;
                this.d = null;
                this.f = null;
                String id = location.getId();
                if (type instanceof Sublocation.Type.Metro) {
                    observable2 = this.g.getMetro(id);
                } else if (type instanceof Sublocation.Type.District) {
                    observable2 = this.g.getDistricts(id);
                } else if (type instanceof Sublocation.Type.Direction) {
                    observable2 = this.g.getDirections(id);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                io.reactivex.rxjava3.core.Observable map = observable2.map(o.a).map(new p(this, type, str));
                Intrinsics.checkNotNullExpressionValue(map, "loadSublocations(newSubl…d, selectedSublocationId)");
                observable = InteropKt.toV2(map).subscribeOn(this.i.io()).map(n.a).startWith((Observable) new LocationInteractor.Event.Loading());
                Intrinsics.checkNotNullExpressionValue(observable, "loadSublocations(newSubl…tartWith(Event.Loading())");
            } else {
                if (str != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        if (Intrinsics.areEqual((String) next.getId(), str)) {
                            sublocation = next;
                            break;
                        }
                    }
                    sublocation = sublocation;
                }
                this.d = sublocation;
                observable = Observable.just(new LocationInteractor.Event.Loaded());
                Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
            }
        } else {
            observable = Observable.just(new LocationInteractor.Event.Loaded());
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
        }
        return a2.b.a.a.a.S1(this.i, observable, "applyNewLocation(newLoca…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.profile.edit.LocationInteractor
    @NotNull
    public Observable<LocationInteractor.Event> updateProfileLocation() {
        if (this.a != null) {
            Observable<LocationInteractor.Event> just = Observable.just(new LocationInteractor.Event.Loaded());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(Event.Loaded())");
            return just;
        }
        Observable flatMap = InteropKt.toV2(this.h.getProfile()).flatMap(new r(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "requestProfile().flatMap…)\n            }\n        }");
        Observable<LocationInteractor.Event> flatMap2 = flatMap.flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap2, "requestProfileLocation()…LocationId)\n            }");
        return flatMap2;
    }
}
