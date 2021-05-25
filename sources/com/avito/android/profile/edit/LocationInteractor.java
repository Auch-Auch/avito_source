package com.avito.android.profile.edit;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.Profile;
import com.avito.android.util.Kundle;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0002%&J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001aH&¢\u0006\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/avito/android/profile/edit/LocationInteractor;", "", "", "invalidate", "()V", "", "hasLocation", "()Z", "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "Lcom/avito/android/remote/model/Profile;", "getProfile", "()Lcom/avito/android/remote/model/Profile;", "", "Lcom/avito/android/remote/model/NameIdEntity;", "getSubLocations", "()Ljava/util/List;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lio/reactivex/Observable;", "Lcom/avito/android/profile/edit/LocationInteractor$Event;", "updateProfileLocation", "()Lio/reactivex/Observable;", "newLocation", "", "selectedSublocationId", "updateLocation", "(Lcom/avito/android/remote/model/Location;Ljava/lang/String;)Lio/reactivex/Observable;", "getSubLocation", "()Lcom/avito/android/remote/model/NameIdEntity;", "", "getSubLocationType", "()I", "getSubLocationTitle", "()Ljava/lang/String;", "Event", "ProfileLocation", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface LocationInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable updateLocation$default(LocationInteractor locationInteractor, Location location, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    location = null;
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                return locationInteractor.updateLocation(location, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLocation");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/edit/LocationInteractor$Event;", "", "<init>", "()V", "Error", "Loaded", "Loading", "Lcom/avito/android/profile/edit/LocationInteractor$Event$Loaded;", "Lcom/avito/android/profile/edit/LocationInteractor$Event$Loading;", "Lcom/avito/android/profile/edit/LocationInteractor$Event$Error;", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile/edit/LocationInteractor$Event$Error;", "Lcom/avito/android/profile/edit/LocationInteractor$Event;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Event {
            public Error() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile/edit/LocationInteractor$Event$Loaded;", "Lcom/avito/android/profile/edit/LocationInteractor$Event;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends Event {
            public Loaded() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile/edit/LocationInteractor$Event$Loading;", "Lcom/avito/android/profile/edit/LocationInteractor$Event;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends Event {
            public Loading() {
                super(null);
            }
        }

        public Event() {
        }

        public Event(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/edit/LocationInteractor$ProfileLocation;", "", "Lcom/avito/android/remote/model/Location;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "setLocation", "(Lcom/avito/android/remote/model/Location;)V", "location", "Lcom/avito/android/remote/model/Profile;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Profile;", "getProfile", "()Lcom/avito/android/remote/model/Profile;", "setProfile", "(Lcom/avito/android/remote/model/Profile;)V", "profile", "<init>", "(Lcom/avito/android/remote/model/Profile;Lcom/avito/android/remote/model/Location;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ProfileLocation {
        @Nullable
        public Profile a;
        @Nullable
        public Location b;

        public ProfileLocation(@Nullable Profile profile, @Nullable Location location) {
            this.a = profile;
            this.b = location;
        }

        @Nullable
        public final Location getLocation() {
            return this.b;
        }

        @Nullable
        public final Profile getProfile() {
            return this.a;
        }

        public final void setLocation(@Nullable Location location) {
            this.b = location;
        }

        public final void setProfile(@Nullable Profile profile) {
            this.a = profile;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ProfileLocation(Profile profile, Location location, int i, j jVar) {
            this((i & 1) != 0 ? null : profile, location);
        }
    }

    @Nullable
    Location getLocation();

    @Nullable
    Profile getProfile();

    @Nullable
    NameIdEntity getSubLocation();

    @NotNull
    String getSubLocationTitle();

    int getSubLocationType();

    @NotNull
    List<NameIdEntity> getSubLocations();

    boolean hasLocation();

    void invalidate();

    @NotNull
    Kundle onSaveState();

    @NotNull
    Observable<Event> updateLocation(@Nullable Location location, @Nullable String str);

    @NotNull
    Observable<Event> updateProfileLocation();
}
