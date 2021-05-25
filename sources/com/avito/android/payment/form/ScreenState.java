package com.avito.android.payment.form;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/form/ScreenState;", "", "<init>", "()V", "Content", "FullScreenError", "FullScreenLoading", "Lcom/avito/android/payment/form/ScreenState$Content;", "Lcom/avito/android/payment/form/ScreenState$FullScreenLoading;", "Lcom/avito/android/payment/form/ScreenState$FullScreenError;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class ScreenState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/payment/form/ScreenState$Content;", "Lcom/avito/android/payment/form/ScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "Lcom/avito/konveyor/blueprint/Item;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "", "c", "Z", "getForceKeyboard", "()Z", "forceKeyboard", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends ScreenState {
        @NotNull
        public final String a;
        @NotNull
        public final List<Item> b;
        public final boolean c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Content(String str, List list, boolean z, int i, j jVar) {
            this(str, list, (i & 4) != 0 ? false : z);
        }

        public final boolean getForceKeyboard() {
            return this.c;
        }

        @NotNull
        public final List<Item> getItems() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.Item> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(@NotNull String str, @NotNull List<? extends Item> list, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "items");
            this.a = str;
            this.b = list;
            this.c = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/form/ScreenState$FullScreenError;", "Lcom/avito/android/payment/form/ScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/form/ScreenState$FullScreenLoading;", "Lcom/avito/android/payment/form/ScreenState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
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
