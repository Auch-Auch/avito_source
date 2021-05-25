package com.avito.android.short_term_rent.start_booking.items.guest_count;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemPresenterImpl;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemPresenter;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemView;", "view", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemView;Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountClickListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class GuestsCountItemPresenterImpl implements GuestsCountItemPresenter {
    public final Lazy<GuestsCountClickListener> a;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ GuestsCountItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GuestsCountItemPresenterImpl guestsCountItemPresenterImpl) {
            super(1);
            this.a = guestsCountItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            ((GuestsCountClickListener) this.a.a.get()).onGuestsCountClick(num.intValue());
            return Unit.INSTANCE;
        }
    }

    public GuestsCountItemPresenterImpl(@NotNull Lazy<GuestsCountClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public void bindView(@NotNull GuestsCountItemView guestsCountItemView, @NotNull GuestsCountItem guestsCountItem, int i) {
        Intrinsics.checkNotNullParameter(guestsCountItemView, "view");
        Intrinsics.checkNotNullParameter(guestsCountItem, "item");
        Integer selectedItem = guestsCountItem.getSelectedItem();
        if (selectedItem != null) {
            guestsCountItemView.setSelectedItem(selectedItem.intValue());
        }
        guestsCountItemView.setActionClickListener(new a(this));
    }
}
