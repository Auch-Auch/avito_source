package com.avito.android.suggest_locations;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.suggest_locations.adapter.SuggestLocationItem;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "", "<init>", "()V", "Error", NativeProtocol.ERROR_NETWORK_ERROR, "Ok", "SilentError", "Lcom/avito/android/suggest_locations/SuggestLocationsResult$Ok;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult$Error;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult$NetworkError;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult$SilentError;", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public abstract class SuggestLocationsResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsResult$Error;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getError", "()Ljava/lang/String;", "error", "<init>", "(Ljava/lang/String;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends SuggestLocationsResult {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "error");
            this.a = str;
        }

        @NotNull
        public final String getError() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsResult$NetworkError;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "<init>", "()V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends SuggestLocationsResult {
        @NotNull
        public static final NetworkError INSTANCE = new NetworkError();

        public NetworkError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsResult$Ok;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "getFullMatchLocation", "()Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "query", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends SuggestLocationsResult {
        @NotNull
        public final List<SuggestLocationItem> a;
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull List<SuggestLocationItem> list, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "data");
            Intrinsics.checkNotNullParameter(str, "query");
            this.a = list;
            this.b = str;
        }

        @NotNull
        public final List<SuggestLocationItem> getData() {
            return this.a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x004c A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x000a A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.avito.android.suggest_locations.adapter.SuggestLocationItem getFullMatchLocation() {
            /*
                r11 = this;
                java.util.List<com.avito.android.suggest_locations.adapter.SuggestLocationItem> r0 = r11.a
                java.util.Iterator r0 = r0.iterator()
                r1 = 0
                r2 = 0
                r4 = r2
                r3 = 0
            L_0x000a:
                boolean r5 = r0.hasNext()
                if (r5 == 0) goto L_0x0052
                java.lang.Object r5 = r0.next()
                r6 = r5
                com.avito.android.suggest_locations.adapter.SuggestLocationItem r6 = (com.avito.android.suggest_locations.adapter.SuggestLocationItem) r6
                com.avito.android.suggest_locations.adapter.SuggestLocationItem$From r7 = r6.getFrom()
                r8 = 1
                if (r7 != 0) goto L_0x0049
                com.avito.android.remote.model.CaseText r6 = r6.getNames()
                java.lang.String r6 = r6.getName()
                java.lang.String r7 = "(this as java.lang.String).toLowerCase()"
                if (r6 == 0) goto L_0x0032
                java.lang.String r6 = r6.toLowerCase()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                goto L_0x0033
            L_0x0032:
                r6 = r2
            L_0x0033:
                java.lang.String r9 = r11.b
                java.lang.String r10 = "null cannot be cast to non-null type java.lang.String"
                java.util.Objects.requireNonNull(r9, r10)
                java.lang.String r9 = r9.toLowerCase()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r9)
                if (r6 == 0) goto L_0x0049
                r6 = 1
                goto L_0x004a
            L_0x0049:
                r6 = 0
            L_0x004a:
                if (r6 == 0) goto L_0x000a
                if (r3 == 0) goto L_0x004f
                goto L_0x0056
            L_0x004f:
                r4 = r5
                r3 = 1
                goto L_0x000a
            L_0x0052:
                if (r3 != 0) goto L_0x0055
                goto L_0x0056
            L_0x0055:
                r2 = r4
            L_0x0056:
                com.avito.android.suggest_locations.adapter.SuggestLocationItem r2 = (com.avito.android.suggest_locations.adapter.SuggestLocationItem) r2
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.suggest_locations.SuggestLocationsResult.Ok.getFullMatchLocation():com.avito.android.suggest_locations.adapter.SuggestLocationItem");
        }

        @NotNull
        public final String getQuery() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsResult$SilentError;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "<init>", "()V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class SilentError extends SuggestLocationsResult {
        @NotNull
        public static final SilentError INSTANCE = new SilentError();

        public SilentError() {
            super(null);
        }
    }

    public SuggestLocationsResult() {
    }

    public SuggestLocationsResult(j jVar) {
    }
}
