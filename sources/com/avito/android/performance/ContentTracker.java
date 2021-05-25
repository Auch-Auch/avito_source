package com.avito.android.performance;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0002\u0015\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\fJ1\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u000f*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\r\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0004J\u0019\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\fJ1\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u000f*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/performance/ContentTracker;", "", "", "stop", "()V", "Lcom/avito/android/performance/ContentTracker$StorageType;", "storageType", "loading", "(Lcom/avito/android/performance/ContentTracker$StorageType;)V", "Lcom/avito/android/performance/ContentTracker$State;", "state", "loaded", "(Lcom/avito/android/performance/ContentTracker$State;)V", "preparing", "prepared", "T", "Lkotlin/Function0;", "func", "(Lcom/avito/android/performance/ContentTracker$State;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "drawing", "drawn", "State", "StorageType", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public interface ContentTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static <T> T drawing(@NotNull ContentTracker contentTracker, @NotNull State state, @NotNull Function0<? extends T> function0) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(function0, "func");
            contentTracker.drawing();
            T t = (T) function0.invoke();
            contentTracker.drawn(state);
            return t;
        }

        public static /* synthetic */ Object drawing$default(ContentTracker contentTracker, State state, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    state = State.Success;
                }
                return contentTracker.drawing(state, function0);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawing");
        }

        public static /* synthetic */ void drawn$default(ContentTracker contentTracker, State state, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    state = State.Success;
                }
                contentTracker.drawn(state);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawn");
        }

        public static /* synthetic */ void loaded$default(ContentTracker contentTracker, State state, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    state = State.Success;
                }
                contentTracker.loaded(state);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loaded");
        }

        public static /* synthetic */ void loading$default(ContentTracker contentTracker, StorageType storageType, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    storageType = StorageType.Remote;
                }
                contentTracker.loading(storageType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loading");
        }

        public static /* synthetic */ void prepared$default(ContentTracker contentTracker, State state, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    state = State.Success;
                }
                contentTracker.prepared(state);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepared");
        }

        @NotNull
        public static <T> T preparing(@NotNull ContentTracker contentTracker, @NotNull State state, @NotNull Function0<? extends T> function0) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(function0, "func");
            contentTracker.preparing();
            T t = (T) function0.invoke();
            contentTracker.prepared(state);
            return t;
        }

        public static /* synthetic */ Object preparing$default(ContentTracker contentTracker, State state, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    state = State.Success;
                }
                return contentTracker.preparing(state, function0);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preparing");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/performance/ContentTracker$State;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "stringValue", "", AuthSource.BOOKING_ORDER, "Z", "getBooleanValue", "()Z", "booleanValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "Success", "Failure", "tns-core_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        Success("success", false),
        Failure(PublicConstantsKt.FAILURE, true);
        
        @NotNull
        public final String a;
        public final boolean b;

        State(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public final boolean getBooleanValue() {
            return this.b;
        }

        @NotNull
        public final String getStringValue() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/performance/ContentTracker$StorageType;", "", "<init>", "(Ljava/lang/String;I)V", "Local", "Remote", "tns-core_release"}, k = 1, mv = {1, 4, 2})
    public enum StorageType {
        Local,
        Remote
    }

    @NotNull
    <T> T drawing(@NotNull State state, @NotNull Function0<? extends T> function0);

    void drawing();

    void drawn(@NotNull State state);

    void loaded(@NotNull State state);

    void loading(@NotNull StorageType storageType);

    void prepared(@NotNull State state);

    @NotNull
    <T> T preparing(@NotNull State state, @NotNull Function0<? extends T> function0);

    void preparing();

    void stop();
}
