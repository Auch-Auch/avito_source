package com.avito.android.cart.summary;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.cart.model.CartSummary;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryView;", "", "Lcom/avito/android/cart/summary/CartSummaryViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/cart/summary/CartSummaryViewModel;)V", "Lio/reactivex/rxjava3/core/Observable;", "getToolbarNavigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "toolbarNavigationClicks", "SubmitButton", "cart_release"}, k = 1, mv = {1, 4, 2})
public interface CartSummaryView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryView$SubmitButton;", "", "Lcom/avito/android/remote/cart/model/CartSummary$Button;", "component1", "()Lcom/avito/android/remote/cart/model/CartSummary$Button;", "", "component2", "()Z", "data", "isLoading", "copy", "(Lcom/avito/android/remote/cart/model/CartSummary$Button;Z)Lcom/avito/android/cart/summary/CartSummaryView$SubmitButton;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/cart/model/CartSummary$Button;", "getData", "<init>", "(Lcom/avito/android/remote/cart/model/CartSummary$Button;Z)V", "cart_release"}, k = 1, mv = {1, 4, 2})
    public static final class SubmitButton {
        @Nullable
        public final CartSummary.Button a;
        public final boolean b;

        public SubmitButton(@Nullable CartSummary.Button button, boolean z) {
            this.a = button;
            this.b = z;
        }

        public static /* synthetic */ SubmitButton copy$default(SubmitButton submitButton, CartSummary.Button button, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                button = submitButton.a;
            }
            if ((i & 2) != 0) {
                z = submitButton.b;
            }
            return submitButton.copy(button, z);
        }

        @Nullable
        public final CartSummary.Button component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final SubmitButton copy(@Nullable CartSummary.Button button, boolean z) {
            return new SubmitButton(button, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubmitButton)) {
                return false;
            }
            SubmitButton submitButton = (SubmitButton) obj;
            return Intrinsics.areEqual(this.a, submitButton.a) && this.b == submitButton.b;
        }

        @Nullable
        public final CartSummary.Button getData() {
            return this.a;
        }

        public int hashCode() {
            CartSummary.Button button = this.a;
            int hashCode = (button != null ? button.hashCode() : 0) * 31;
            boolean z = this.b;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        public final boolean isLoading() {
            return this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SubmitButton(data=");
            L.append(this.a);
            L.append(", isLoading=");
            return a.B(L, this.b, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SubmitButton(CartSummary.Button button, boolean z, int i, j jVar) {
            this(button, (i & 2) != 0 ? false : z);
        }
    }

    void bindTo(@NotNull CartSummaryViewModel cartSummaryViewModel);

    @NotNull
    Observable<Unit> getToolbarNavigationClicks();
}
