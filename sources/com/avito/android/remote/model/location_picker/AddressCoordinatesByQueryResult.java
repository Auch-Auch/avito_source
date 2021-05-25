package com.avito.android.remote.model.location_picker;

import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult;", "", "<init>", "()V", NativeProtocol.ERROR_NETWORK_ERROR, "NotFoundError", "Ok", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult$Ok;", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult$NotFoundError;", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult$NetworkError;", "location_release"}, k = 1, mv = {1, 4, 2})
public abstract class AddressCoordinatesByQueryResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult$NetworkError;", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult;", "<init>", "()V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends AddressCoordinatesByQueryResult {
        public NetworkError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult$NotFoundError;", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotFoundError extends AddressCoordinatesByQueryResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotFoundError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult$Ok;", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult;", "", "jsonWebToken", "Ljava/lang/String;", "getJsonWebToken", "()Ljava/lang/String;", "formattedAddress", "getFormattedAddress", "Lcom/avito/android/remote/model/Coordinates;", ParameterId.COORDS, "Lcom/avito/android/remote/model/Coordinates;", "getCoords", "()Lcom/avito/android/remote/model/Coordinates;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends AddressCoordinatesByQueryResult {
        @SerializedName("coordinates")
        @NotNull
        private final Coordinates coords;
        @SerializedName("formattedAddress")
        @Nullable
        private final String formattedAddress;
        @SerializedName(AddressParameter.Value.JSON_WEB_TOKEN)
        @Nullable
        private final String jsonWebToken;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ok(String str, Coordinates coordinates, String str2, int i, j jVar) {
            this((i & 1) != 0 ? "" : str, coordinates, str2);
        }

        @NotNull
        public final Coordinates getCoords() {
            return this.coords;
        }

        @Nullable
        public final String getFormattedAddress() {
            return this.formattedAddress;
        }

        @Nullable
        public final String getJsonWebToken() {
            return this.jsonWebToken;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@Nullable String str, @NotNull Coordinates coordinates, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(coordinates, ParameterId.COORDS);
            this.formattedAddress = str;
            this.coords = coordinates;
            this.jsonWebToken = str2;
        }
    }

    private AddressCoordinatesByQueryResult() {
    }

    public /* synthetic */ AddressCoordinatesByQueryResult(j jVar) {
        this();
    }
}
