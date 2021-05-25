package com.avito.android.short_term_rent.start_booking.items.enter_departure;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemView;", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemView;Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemClickListenter;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "clickListener", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemClearListenter;", AuthSource.BOOKING_ORDER, "clearListener", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class SelectItemPresenter implements ItemPresenter<SelectItemView, SelectItem> {
    public final Lazy<SelectItemClickListenter> a;
    public final Lazy<SelectItemClearListenter> b;

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
                ((SelectItemClickListenter) ((SelectItemPresenter) this.b).a.get()).onClick();
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((SelectItemClearListenter) ((SelectItemPresenter) this.b).b.get()).onClear();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public SelectItemPresenter(@NotNull Lazy<SelectItemClickListenter> lazy, @NotNull Lazy<SelectItemClearListenter> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "clickListener");
        Intrinsics.checkNotNullParameter(lazy2, "clearListener");
        this.a = lazy;
        this.b = lazy2;
    }

    public void bindView(@NotNull SelectItemView selectItemView, @NotNull SelectItem selectItem, int i) {
        Intrinsics.checkNotNullParameter(selectItemView, "view");
        Intrinsics.checkNotNullParameter(selectItem, "item");
        String value = selectItem.getValue();
        selectItemView.setClearButtonVisible(!(value == null || value.length() == 0));
        selectItemView.setTitle(selectItem.getTitle());
        selectItemView.setValue(selectItem.getValue());
        selectItemView.setOnClickListener(new a(0, this, selectItem));
        selectItemView.setOnClearListener(new a(1, this, selectItem));
    }
}
