package com.avito.android.user_adverts;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/user_adverts/SoaData;", "", "<init>", "()V", "Failure", "Value", "Lcom/avito/android/user_adverts/SoaData$Value;", "Lcom/avito/android/user_adverts/SoaData$Failure;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public abstract class SoaData {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/SoaData$Failure;", "Lcom/avito/android/user_adverts/SoaData;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends SoaData {
        @NotNull
        public static final Failure INSTANCE = new Failure();

        public Failure() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/user_adverts/SoaData$Value;", "Lcom/avito/android/user_adverts/SoaData;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Value extends SoaData {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        public Value() {
            this(null, null, 3, null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Value(@NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.a = str;
            this.b = str2;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        @NotNull
        public final String getValue() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Value(String str, String str2, int i, j jVar) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }
    }

    public SoaData() {
    }

    public SoaData(j jVar) {
    }
}
