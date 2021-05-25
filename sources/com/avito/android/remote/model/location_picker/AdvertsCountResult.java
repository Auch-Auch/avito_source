package com.avito.android.remote.model.location_picker;

import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AdvertsCountResult;", "", "<init>", "()V", "Error", NativeProtocol.ERROR_NETWORK_ERROR, "Ok", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult$Ok;", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult$Error;", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult$NetworkError;", "location_release"}, k = 1, mv = {1, 4, 2})
public abstract class AdvertsCountResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AdvertsCountResult$Error;", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends AdvertsCountResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AdvertsCountResult$NetworkError;", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult;", "<init>", "()V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends AdvertsCountResult {
        public NetworkError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AdvertsCountResult$Ok;", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult;", "", "advertCount", "J", "getAdvertCount", "()J", "<init>", "(J)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends AdvertsCountResult {
        @SerializedName("totalCount")
        private final long advertCount;

        public Ok(long j) {
            super(null);
            this.advertCount = j;
        }

        public final long getAdvertCount() {
            return this.advertCount;
        }
    }

    private AdvertsCountResult() {
    }

    public /* synthetic */ AdvertsCountResult(j jVar) {
        this();
    }
}
