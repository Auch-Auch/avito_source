package com.avito.android.user_advert.soa_with_price;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseReason;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo;", "", "<init>", "()V", "CancelDialog", "ChooseReasonRoutingInfo", "EnterPriceRoutingInfo", "ExitWithSuccess", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo$ChooseReasonRoutingInfo;", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo$EnterPriceRoutingInfo;", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo$CancelDialog;", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo$ExitWithSuccess;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public abstract class RoutingEventInfo {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo$CancelDialog;", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class CancelDialog extends RoutingEventInfo {
        @NotNull
        public static final CancelDialog INSTANCE = new CancelDialog();

        public CancelDialog() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo$ChooseReasonRoutingInfo;", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo;", "Lcom/avito/android/user_advert/soa_with_price/StepInfo;", "Lcom/avito/android/user_advert/soa_with_price/NavigationButtonType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_advert/soa_with_price/NavigationButtonType;", "getNavigationButtonType", "()Lcom/avito/android/user_advert/soa_with_price/NavigationButtonType;", "navigationButtonType", "", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "title", "<init>", "(Ljava/lang/CharSequence;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChooseReasonRoutingInfo extends RoutingEventInfo implements StepInfo {
        @NotNull
        public final NavigationButtonType a = NavigationButtonType.CLOSE;
        @NotNull
        public final CharSequence b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChooseReasonRoutingInfo(@NotNull CharSequence charSequence) {
            super(null);
            Intrinsics.checkNotNullParameter(charSequence, "title");
            this.b = charSequence;
        }

        @Override // com.avito.android.user_advert.soa_with_price.StepInfo
        @NotNull
        public NavigationButtonType getNavigationButtonType() {
            return this.a;
        }

        @Override // com.avito.android.user_advert.soa_with_price.StepInfo
        @NotNull
        public CharSequence getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo$EnterPriceRoutingInfo;", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo;", "Lcom/avito/android/user_advert/soa_with_price/StepInfo;", "Lcom/avito/android/user_advert/soa_with_price/NavigationButtonType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_advert/soa_with_price/NavigationButtonType;", "getNavigationButtonType", "()Lcom/avito/android/user_advert/soa_with_price/NavigationButtonType;", "navigationButtonType", "", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "title", "<init>", "(Ljava/lang/CharSequence;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class EnterPriceRoutingInfo extends RoutingEventInfo implements StepInfo {
        @NotNull
        public final NavigationButtonType a = NavigationButtonType.BACK;
        @NotNull
        public final CharSequence b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnterPriceRoutingInfo(@NotNull CharSequence charSequence) {
            super(null);
            Intrinsics.checkNotNullParameter(charSequence, "title");
            this.b = charSequence;
        }

        @Override // com.avito.android.user_advert.soa_with_price.StepInfo
        @NotNull
        public NavigationButtonType getNavigationButtonType() {
            return this.a;
        }

        @Override // com.avito.android.user_advert.soa_with_price.StepInfo
        @NotNull
        public CharSequence getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo$ExitWithSuccess;", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo;", "Lcom/avito/android/remote/model/CloseReason;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/CloseReason;", "getReason", "()Lcom/avito/android/remote/model/CloseReason;", "reason", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "price", "<init>", "(Lcom/avito/android/remote/model/CloseReason;Ljava/lang/String;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class ExitWithSuccess extends RoutingEventInfo {
        @NotNull
        public final CloseReason a;
        @Nullable
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ExitWithSuccess(@NotNull CloseReason closeReason, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(closeReason, "reason");
            this.a = closeReason;
            this.b = str;
        }

        @Nullable
        public final String getPrice() {
            return this.b;
        }

        @NotNull
        public final CloseReason getReason() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExitWithSuccess(CloseReason closeReason, String str, int i, j jVar) {
            this(closeReason, (i & 2) != 0 ? null : str);
        }
    }

    public RoutingEventInfo() {
    }

    public RoutingEventInfo(j jVar) {
    }
}
