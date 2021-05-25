package com.avito.android.remote.model.location_picker;

import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressValidationResult;", "", "<init>", "()V", "Error", NativeProtocol.ERROR_NETWORK_ERROR, "Ok", "Lcom/avito/android/remote/model/location_picker/AddressValidationResult$Ok;", "Lcom/avito/android/remote/model/location_picker/AddressValidationResult$Error;", "Lcom/avito/android/remote/model/location_picker/AddressValidationResult$NetworkError;", "location_release"}, k = 1, mv = {1, 4, 2})
public abstract class AddressValidationResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressValidationResult$Error;", "Lcom/avito/android/remote/model/location_picker/AddressValidationResult;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends AddressValidationResult {
        @SerializedName("errorText")
        @NotNull
        private final String errorMessage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.errorMessage = str;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressValidationResult$NetworkError;", "Lcom/avito/android/remote/model/location_picker/AddressValidationResult;", "<init>", "()V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends AddressValidationResult {
        @NotNull
        public static final NetworkError INSTANCE = new NetworkError();

        private NetworkError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressValidationResult$Ok;", "Lcom/avito/android/remote/model/location_picker/AddressValidationResult;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "jsonWebToken", "getJsonWebToken", "", "isValid", "Z", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends AddressValidationResult {
        @SerializedName("errorText")
        @Nullable
        private final String errorMessage;
        @SerializedName("isValid")
        private final boolean isValid;
        @SerializedName(AddressParameter.Value.JSON_WEB_TOKEN)
        @Nullable
        private final String jsonWebToken;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ok(String str, String str2, boolean z, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, z);
        }

        @Nullable
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        @Nullable
        public final String getJsonWebToken() {
            return this.jsonWebToken;
        }

        public final boolean isValid() {
            return this.isValid;
        }

        public Ok(@Nullable String str, @Nullable String str2, boolean z) {
            super(null);
            this.jsonWebToken = str;
            this.errorMessage = str2;
            this.isValid = z;
        }
    }

    private AddressValidationResult() {
    }

    public /* synthetic */ AddressValidationResult(j jVar) {
        this();
    }
}
