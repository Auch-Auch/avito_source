package com.avito.android.notification_center.landing.unified.pair_button;

import com.avito.android.notification_center.landing.unified.di.ButtonFirst;
import com.avito.android.notification_center.landing.unified.di.ButtonSecond;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonPresenter;", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonView;", "view", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonView;Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonItem;I)V", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/Relay;", "secondConsumer", AuthSource.SEND_ABUSE, "firstConsumer", "<init>", "(Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedPairButtonPresenterImpl implements UnifiedPairButtonPresenter {
    public final Relay<UnifiedPairButtonItem> a;
    public final Relay<UnifiedPairButtonItem> b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((UnifiedPairButtonPresenterImpl) this.b).a.accept((UnifiedPairButtonItem) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((UnifiedPairButtonPresenterImpl) this.b).b.accept((UnifiedPairButtonItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UnifiedPairButtonView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(UnifiedPairButtonView unifiedPairButtonView) {
            super(0);
            this.a = unifiedPairButtonView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setFirstClickListener(null);
            this.a.setSecondClickListener(null);
            this.a.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public UnifiedPairButtonPresenterImpl(@ButtonFirst @NotNull Relay<UnifiedPairButtonItem> relay, @ButtonSecond @NotNull Relay<UnifiedPairButtonItem> relay2) {
        Intrinsics.checkNotNullParameter(relay, "firstConsumer");
        Intrinsics.checkNotNullParameter(relay2, "secondConsumer");
        this.a = relay;
        this.b = relay2;
    }

    public void bindView(@NotNull UnifiedPairButtonView unifiedPairButtonView, @NotNull UnifiedPairButtonItem unifiedPairButtonItem, int i) {
        Intrinsics.checkNotNullParameter(unifiedPairButtonView, "view");
        Intrinsics.checkNotNullParameter(unifiedPairButtonItem, "item");
        unifiedPairButtonView.setFirstText(unifiedPairButtonItem.getFirstText());
        unifiedPairButtonView.setSecondText(unifiedPairButtonItem.getSecondText());
        unifiedPairButtonView.setFirstClickListener(new a(0, this, unifiedPairButtonItem));
        unifiedPairButtonView.setSecondClickListener(new a(1, this, unifiedPairButtonItem));
        unifiedPairButtonView.setUnbindListener(new b(unifiedPairButtonView));
    }
}
