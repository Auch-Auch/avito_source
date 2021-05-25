package com.avito.android.booking.order;

import com.avito.android.booking.remote.model.BookingOrderResponse;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderScreenState;", "", "<init>", "()V", "Content", "InputError", "InputNormal", "Loading", "LoadingError", "Message", "OrderInfoLoaded", "Lcom/avito/android/booking/order/BookingOrderScreenState$OrderInfoLoaded;", "Lcom/avito/android/booking/order/BookingOrderScreenState$Loading;", "Lcom/avito/android/booking/order/BookingOrderScreenState$Content;", "Lcom/avito/android/booking/order/BookingOrderScreenState$LoadingError;", "Lcom/avito/android/booking/order/BookingOrderScreenState$Message;", "Lcom/avito/android/booking/order/BookingOrderScreenState$InputError;", "Lcom/avito/android/booking/order/BookingOrderScreenState$InputNormal;", "booking_release"}, k = 1, mv = {1, 4, 2})
public abstract class BookingOrderScreenState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderScreenState$Content;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "<init>", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends BookingOrderScreenState {
        @NotNull
        public static final Content INSTANCE = new Content();

        public Content() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderScreenState$InputError;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "<init>", "(Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class InputError extends BookingOrderScreenState {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InputError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.a = str;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderScreenState$InputNormal;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "<init>", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class InputNormal extends BookingOrderScreenState {
        @NotNull
        public static final InputNormal INSTANCE = new InputNormal();

        public InputNormal() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderScreenState$Loading;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "<init>", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends BookingOrderScreenState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderScreenState$LoadingError;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "<init>", "(Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingError extends BookingOrderScreenState {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadingError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.a = str;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderScreenState$Message;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class Message extends BookingOrderScreenState {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Message(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderScreenState$OrderInfoLoaded;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "Lcom/avito/android/booking/remote/model/BookingOrderResponse;", AuthSource.SEND_ABUSE, "Lcom/avito/android/booking/remote/model/BookingOrderResponse;", "getData", "()Lcom/avito/android/booking/remote/model/BookingOrderResponse;", "data", "<init>", "(Lcom/avito/android/booking/remote/model/BookingOrderResponse;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class OrderInfoLoaded extends BookingOrderScreenState {
        @NotNull
        public final BookingOrderResponse a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OrderInfoLoaded(@NotNull BookingOrderResponse bookingOrderResponse) {
            super(null);
            Intrinsics.checkNotNullParameter(bookingOrderResponse, "data");
            this.a = bookingOrderResponse;
        }

        @NotNull
        public final BookingOrderResponse getData() {
            return this.a;
        }
    }

    public BookingOrderScreenState() {
    }

    public BookingOrderScreenState(j jVar) {
    }
}
