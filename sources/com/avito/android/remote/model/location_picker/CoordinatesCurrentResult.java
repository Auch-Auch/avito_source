package com.avito.android.remote.model.location_picker;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult;", "", "<init>", "()V", "NetWorkError", "Ok", NativeProtocol.ERROR_UNKNOWN_ERROR, "Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult$Ok;", "Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult$NetWorkError;", "Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult$UnknownError;", "location_release"}, k = 1, mv = {1, 4, 2})
public abstract class CoordinatesCurrentResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult$NetWorkError;", "Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult;", "<init>", "()V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetWorkError extends CoordinatesCurrentResult {
        public NetWorkError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult$Ok;", "Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult;", "Lcom/avito/android/remote/model/location_picker/CurrentCoordinates;", "currentCoordinates", "Lcom/avito/android/remote/model/location_picker/CurrentCoordinates;", "getCurrentCoordinates", "()Lcom/avito/android/remote/model/location_picker/CurrentCoordinates;", "<init>", "(Lcom/avito/android/remote/model/location_picker/CurrentCoordinates;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends CoordinatesCurrentResult {
        @NotNull
        private final CurrentCoordinates currentCoordinates;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull CurrentCoordinates currentCoordinates2) {
            super(null);
            Intrinsics.checkNotNullParameter(currentCoordinates2, "currentCoordinates");
            this.currentCoordinates = currentCoordinates2;
        }

        @NotNull
        public final CurrentCoordinates getCurrentCoordinates() {
            return this.currentCoordinates;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult$UnknownError;", "Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnknownError extends CoordinatesCurrentResult {
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnknownError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    private CoordinatesCurrentResult() {
    }

    public /* synthetic */ CoordinatesCurrentResult(j jVar) {
        this();
    }
}
