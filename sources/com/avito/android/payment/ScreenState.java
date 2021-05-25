package com.avito.android.payment;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/ScreenState;", "", "<init>", "()V", "Content", "FullScreenError", "FullScreenLoading", "Lcom/avito/android/payment/ScreenState$Content;", "Lcom/avito/android/payment/ScreenState$FullScreenLoading;", "Lcom/avito/android/payment/ScreenState$FullScreenError;", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class ScreenState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/avito/android/payment/ScreenState$Content;", "Lcom/avito/android/payment/ScreenState;", "Lcom/avito/android/payment/DecoratedItems;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/DecoratedItems;", "getDecoratedItems", "()Lcom/avito/android/payment/DecoratedItems;", "decoratedItems", "", "e", "Z", "getGooglePayEnabled", "()Z", "googlePayEnabled", "", "c", "Ljava/lang/String;", "getButtonTitle", "()Ljava/lang/String;", "buttonTitle", AuthSource.BOOKING_ORDER, "getCheckedMethodSignature", "checkedMethodSignature", "d", "getTitle", "title", "<init>", "(Lcom/avito/android/payment/DecoratedItems;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends ScreenState {
        @NotNull
        public final DecoratedItems a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final String d;
        public final boolean e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(@NotNull DecoratedItems decoratedItems, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(decoratedItems, "decoratedItems");
            Intrinsics.checkNotNullParameter(str, "checkedMethodSignature");
            Intrinsics.checkNotNullParameter(str2, "buttonTitle");
            Intrinsics.checkNotNullParameter(str3, "title");
            this.a = decoratedItems;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = z;
        }

        @NotNull
        public final String getButtonTitle() {
            return this.c;
        }

        @NotNull
        public final String getCheckedMethodSignature() {
            return this.b;
        }

        @NotNull
        public final DecoratedItems getDecoratedItems() {
            return this.a;
        }

        public final boolean getGooglePayEnabled() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/ScreenState$FullScreenError;", "Lcom/avito/android/payment/ScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "<init>", "(Ljava/lang/String;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class FullScreenError extends ScreenState {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FullScreenError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.a = str;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/ScreenState$FullScreenLoading;", "Lcom/avito/android/payment/ScreenState;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class FullScreenLoading extends ScreenState {
        public FullScreenLoading() {
            super(null);
        }
    }

    public ScreenState() {
    }

    public ScreenState(j jVar) {
    }
}
