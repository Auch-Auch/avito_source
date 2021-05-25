package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/LocationByCoordsResult;", "", "<init>", "()V", "NotFound", "Ok", "Lcom/avito/android/remote/model/LocationByCoordsResult$Ok;", "Lcom/avito/android/remote/model/LocationByCoordsResult$NotFound;", "location_release"}, k = 1, mv = {1, 4, 2})
public abstract class LocationByCoordsResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/LocationByCoordsResult$NotFound;", "Lcom/avito/android/remote/model/LocationByCoordsResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotFound extends LocationByCoordsResult {
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotFound(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/LocationByCoordsResult$Ok;", "Lcom/avito/android/remote/model/LocationByCoordsResult;", "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "<init>", "(Lcom/avito/android/remote/model/Location;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends LocationByCoordsResult {
        @NotNull
        private final Location location;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull Location location2) {
            super(null);
            Intrinsics.checkNotNullParameter(location2, "location");
            this.location = location2;
        }

        @NotNull
        public final Location getLocation() {
            return this.location;
        }
    }

    private LocationByCoordsResult() {
    }

    public /* synthetic */ LocationByCoordsResult(j jVar) {
        this();
    }
}
