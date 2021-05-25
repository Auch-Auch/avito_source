package com.avito.android.permissions;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012RD\u0010\u001a\u001a0\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0017\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u0014¢\u0006\u0002\b\u00170\u0014¢\u0006\u0002\b\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/avito/android/permissions/PermissionStateProviderImpl;", "Lcom/avito/android/permissions/PermissionStateProvider;", "", "permission", "Lcom/avito/android/permissions/PermissionState;", "state", "", "updatePermissionState", "(Ljava/lang/String;Lcom/avito/android/permissions/PermissionState;)V", "Lio/reactivex/rxjava3/core/Observable;", "observePermissionState", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/permissions/PermissionChecker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "Lcom/avito/android/permissions/PermissionStorage;", "c", "Lcom/avito/android/permissions/PermissionStorage;", "permissionStorage", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/permissions/PermissionStateProviderImpl$PermissionWithState;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "permissionStateStream", "<init>", "(Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/permissions/PermissionStorage;)V", "PermissionWithState", "permissions_release"}, k = 1, mv = {1, 4, 2})
public final class PermissionStateProviderImpl implements PermissionStateProvider {
    public final PublishRelay<PermissionWithState> a = PublishRelay.create();
    public final PermissionChecker b;
    public final PermissionStorage c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/permissions/PermissionStateProviderImpl$PermissionWithState;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/permissions/PermissionState;", "component2", "()Lcom/avito/android/permissions/PermissionState;", "permission", "state", "copy", "(Ljava/lang/String;Lcom/avito/android/permissions/PermissionState;)Lcom/avito/android/permissions/PermissionStateProviderImpl$PermissionWithState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPermission", AuthSource.BOOKING_ORDER, "Lcom/avito/android/permissions/PermissionState;", "getState", "<init>", "(Ljava/lang/String;Lcom/avito/android/permissions/PermissionState;)V", "permissions_release"}, k = 1, mv = {1, 4, 2})
    public static final class PermissionWithState {
        @NotNull
        public final String a;
        @NotNull
        public final PermissionState b;

        public PermissionWithState(@NotNull String str, @NotNull PermissionState permissionState) {
            Intrinsics.checkNotNullParameter(str, "permission");
            Intrinsics.checkNotNullParameter(permissionState, "state");
            this.a = str;
            this.b = permissionState;
        }

        public static /* synthetic */ PermissionWithState copy$default(PermissionWithState permissionWithState, String str, PermissionState permissionState, int i, Object obj) {
            if ((i & 1) != 0) {
                str = permissionWithState.a;
            }
            if ((i & 2) != 0) {
                permissionState = permissionWithState.b;
            }
            return permissionWithState.copy(str, permissionState);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final PermissionState component2() {
            return this.b;
        }

        @NotNull
        public final PermissionWithState copy(@NotNull String str, @NotNull PermissionState permissionState) {
            Intrinsics.checkNotNullParameter(str, "permission");
            Intrinsics.checkNotNullParameter(permissionState, "state");
            return new PermissionWithState(str, permissionState);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PermissionWithState)) {
                return false;
            }
            PermissionWithState permissionWithState = (PermissionWithState) obj;
            return Intrinsics.areEqual(this.a, permissionWithState.a) && Intrinsics.areEqual(this.b, permissionWithState.b);
        }

        @NotNull
        public final String getPermission() {
            return this.a;
        }

        @NotNull
        public final PermissionState getState() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            PermissionState permissionState = this.b;
            if (permissionState != null) {
                i = permissionState.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("PermissionWithState(permission=");
            L.append(this.a);
            L.append(", state=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public static final class a<T> implements Predicate<PermissionWithState> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(PermissionWithState permissionWithState) {
            return Intrinsics.areEqual(permissionWithState.getPermission(), this.a);
        }
    }

    public static final class b<T, R> implements Function<PermissionWithState, PermissionState> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public PermissionState apply(PermissionWithState permissionWithState) {
            return permissionWithState.getState();
        }
    }

    @Inject
    public PermissionStateProviderImpl(@NotNull PermissionChecker permissionChecker, @NotNull PermissionStorage permissionStorage) {
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        Intrinsics.checkNotNullParameter(permissionStorage, "permissionStorage");
        this.b = permissionChecker;
        this.c = permissionStorage;
    }

    @Override // com.avito.android.permissions.PermissionStateProvider
    @NotNull
    public Observable<PermissionState> observePermissionState(@NotNull String str) {
        PermissionState permissionState;
        Intrinsics.checkNotNullParameter(str, "permission");
        if (this.b.checkPermission(str)) {
            permissionState = PermissionState.GRANTED;
        } else if (str.hashCode() == 1831139720 && str.equals("android.permission.RECORD_AUDIO")) {
            permissionState = this.c.getWasMicPermissionForeverDenied() ? PermissionState.FOREVER_DENIED : PermissionState.DENIED;
        } else {
            permissionState = PermissionState.DENIED;
        }
        Observable<PermissionState> map = Observable.just(new PermissionWithState(str, permissionState)).concatWith(this.a).filter(new a(str)).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "Observable.just(Permissi…   it.state\n            }");
        return map;
    }

    @Override // com.avito.android.permissions.PermissionStateProvider
    public void updatePermissionState(@NotNull String str, @NotNull PermissionState permissionState) {
        Intrinsics.checkNotNullParameter(str, "permission");
        Intrinsics.checkNotNullParameter(permissionState, "state");
        Logs.debug$default("PermissionStateProvider", "Update state for permission=[" + str + "] to state=[" + permissionState + ']', null, 4, null);
        if (str.hashCode() == 1831139720 && str.equals("android.permission.RECORD_AUDIO")) {
            this.c.setWasMicPermissionForeverDenied(permissionState == PermissionState.FOREVER_DENIED);
        }
        this.a.accept(new PermissionWithState(str, permissionState));
    }
}
