package com.avito.android.location_picker.entities;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/location_picker/entities/SendLocationResponse;", "", "<init>", "()V", "Error", "Success", "Lcom/avito/android/location_picker/entities/SendLocationResponse$Success;", "Lcom/avito/android/location_picker/entities/SendLocationResponse$Error;", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public abstract class SendLocationResponse {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/location_picker/entities/SendLocationResponse$Error;", "Lcom/avito/android/location_picker/entities/SendLocationResponse;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends SendLocationResponse {
        @NotNull
        public final String a;

        public Error() {
            this(null, 1, null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(String str, int i, j jVar) {
            this((i & 1) != 0 ? "" : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/location_picker/entities/SendLocationResponse$Success;", "Lcom/avito/android/location_picker/entities/SendLocationResponse;", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success extends SendLocationResponse {
        @NotNull
        public static final Success INSTANCE = new Success();

        public Success() {
            super(null);
        }
    }

    public SendLocationResponse() {
    }

    public SendLocationResponse(j jVar) {
    }
}
