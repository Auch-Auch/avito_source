package com.avito.android.remote.model;

import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/SuggestLocationsResponse;", "", "<init>", "()V", "Error", NativeProtocol.ERROR_NETWORK_ERROR, "Ok", "Lcom/avito/android/remote/model/SuggestLocationsResponse$Ok;", "Lcom/avito/android/remote/model/SuggestLocationsResponse$Error;", "Lcom/avito/android/remote/model/SuggestLocationsResponse$NetworkError;", "location_release"}, k = 1, mv = {1, 4, 2})
public abstract class SuggestLocationsResponse {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/SuggestLocationsResponse$Error;", "Lcom/avito/android/remote/model/SuggestLocationsResponse;", "", "error", "Ljava/lang/String;", "getError", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends SuggestLocationsResponse {
        @NotNull
        private final String error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "error");
            this.error = str;
        }

        @NotNull
        public final String getError() {
            return this.error;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/SuggestLocationsResponse$NetworkError;", "Lcom/avito/android/remote/model/SuggestLocationsResponse;", "<init>", "()V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends SuggestLocationsResponse {
        public NetworkError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/SuggestLocationsResponse$Ok;", "Lcom/avito/android/remote/model/SuggestLocationsResponse;", "", "Lcom/avito/android/remote/model/SuggestLocation;", "locations", "Ljava/util/List;", "getLocations", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends SuggestLocationsResponse {
        @SerializedName("locations")
        @NotNull
        private final List<SuggestLocation> locations;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull List<SuggestLocation> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "locations");
            this.locations = list;
        }

        @NotNull
        public final List<SuggestLocation> getLocations() {
            return this.locations;
        }
    }

    private SuggestLocationsResponse() {
    }

    public /* synthetic */ SuggestLocationsResponse(j jVar) {
        this();
    }
}
