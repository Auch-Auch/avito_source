package com.avito.android.payment.top_up.form;

import com.avito.android.payment.DecoratedItems;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/top_up/form/ScreenState;", "", "<init>", "()V", "Content", "FullScreenError", "FullScreenLoading", "Lcom/avito/android/payment/top_up/form/ScreenState$Content;", "Lcom/avito/android/payment/top_up/form/ScreenState$FullScreenLoading;", "Lcom/avito/android/payment/top_up/form/ScreenState$FullScreenError;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class ScreenState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/top_up/form/ScreenState$Content;", "Lcom/avito/android/payment/top_up/form/ScreenState;", "", "c", "Z", "getForceKeyboard", "()Z", "forceKeyboard", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/payment/DecoratedItems;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/DecoratedItems;", "getDecoratedItems", "()Lcom/avito/android/payment/DecoratedItems;", "decoratedItems", "<init>", "(Ljava/lang/String;Lcom/avito/android/payment/DecoratedItems;Z)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends ScreenState {
        @NotNull
        public final String a;
        @NotNull
        public final DecoratedItems b;
        public final boolean c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Content(String str, DecoratedItems decoratedItems, boolean z, int i, j jVar) {
            this(str, decoratedItems, (i & 4) != 0 ? false : z);
        }

        @NotNull
        public final DecoratedItems getDecoratedItems() {
            return this.b;
        }

        public final boolean getForceKeyboard() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(@NotNull String str, @NotNull DecoratedItems decoratedItems, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(decoratedItems, "decoratedItems");
            this.a = str;
            this.b = decoratedItems;
            this.c = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/top_up/form/ScreenState$FullScreenError;", "Lcom/avito/android/payment/top_up/form/ScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/top_up/form/ScreenState$FullScreenLoading;", "Lcom/avito/android/payment/top_up/form/ScreenState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
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
