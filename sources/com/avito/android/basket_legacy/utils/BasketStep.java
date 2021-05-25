package com.avito.android.basket_legacy.utils;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.remote.model.SingleFee;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/basket_legacy/utils/BasketStep;", "", "<init>", "()V", "Checkout", "LfSingleChoice", "PackageChoice", "Skip", "VasChoice", "Lcom/avito/android/basket_legacy/utils/BasketStep$PackageChoice;", "Lcom/avito/android/basket_legacy/utils/BasketStep$LfSingleChoice;", "Lcom/avito/android/basket_legacy/utils/BasketStep$VasChoice;", "Lcom/avito/android/basket_legacy/utils/BasketStep$Checkout;", "Lcom/avito/android/basket_legacy/utils/BasketStep$Skip;", "basket_release"}, k = 1, mv = {1, 4, 2})
public abstract class BasketStep {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/basket_legacy/utils/BasketStep$Checkout;", "Lcom/avito/android/basket_legacy/utils/BasketStep;", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Checkout extends BasketStep {
        public Checkout() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/basket_legacy/utils/BasketStep$LfSingleChoice;", "Lcom/avito/android/basket_legacy/utils/BasketStep;", "Lcom/avito/android/remote/model/SingleFee;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SingleFee;", "getSingleFee", "()Lcom/avito/android/remote/model/SingleFee;", "singleFee", "Lcom/avito/android/remote/model/Action;", "c", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Lcom/avito/android/remote/model/SingleFee;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class LfSingleChoice extends BasketStep {
        @NotNull
        public final SingleFee a;
        @Nullable
        public final String b;
        @NotNull
        public final Action c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LfSingleChoice(@NotNull SingleFee singleFee, @Nullable String str, @NotNull Action action) {
            super(null);
            Intrinsics.checkNotNullParameter(singleFee, "singleFee");
            Intrinsics.checkNotNullParameter(action, "action");
            this.a = singleFee;
            this.b = str;
            this.c = action;
        }

        @NotNull
        public final Action getAction() {
            return this.c;
        }

        @Nullable
        public final String getMessage() {
            return this.b;
        }

        @NotNull
        public final SingleFee getSingleFee() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/basket_legacy/utils/BasketStep$PackageChoice;", "Lcom/avito/android/basket_legacy/utils/BasketStep;", "", "Lcom/avito/android/remote/model/OwnedPackage;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getPackages", "()Ljava/util/List;", "packages", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class PackageChoice extends BasketStep {
        @Nullable
        public final String a;
        @NotNull
        public final List<OwnedPackage> b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PackageChoice(@Nullable String str, @NotNull List<OwnedPackage> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "packages");
            this.a = str;
            this.b = list;
        }

        @Nullable
        public final String getMessage() {
            return this.a;
        }

        @NotNull
        public final List<OwnedPackage> getPackages() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/basket_legacy/utils/BasketStep$Skip;", "Lcom/avito/android/basket_legacy/utils/BasketStep;", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Skip extends BasketStep {
        public Skip() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/basket_legacy/utils/BasketStep$VasChoice;", "Lcom/avito/android/basket_legacy/utils/BasketStep;", "Lcom/avito/android/basket_legacy/utils/VasType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/basket_legacy/utils/VasType;", "getType", "()Lcom/avito/android/basket_legacy/utils/VasType;", "type", "", AuthSource.BOOKING_ORDER, "Z", "getCanGoBack", "()Z", "canGoBack", "<init>", "(Lcom/avito/android/basket_legacy/utils/VasType;Z)V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class VasChoice extends BasketStep {
        @NotNull
        public final VasType a;
        public final boolean b;

        public VasChoice() {
            this(null, false, 3, null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VasChoice(@NotNull VasType vasType, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(vasType, "type");
            this.a = vasType;
            this.b = z;
        }

        public final boolean getCanGoBack() {
            return this.b;
        }

        @NotNull
        public final VasType getType() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VasChoice(VasType vasType, boolean z, int i, j jVar) {
            this((i & 1) != 0 ? VasType.PERFORMANCE : vasType, (i & 2) != 0 ? false : z);
        }
    }

    public BasketStep() {
    }

    public BasketStep(j jVar) {
    }
}
