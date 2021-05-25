package com.avito.android.short_term_rent.hotels.dialogs.location;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemView;", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemView;Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItem;I)V", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemClickListener;", "clickListener", "<init>", "(Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemClickListener;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsLocationDialogItemPresenter implements ItemPresenter<HotelsLocationDialogItemView, HotelsLocationDialogItem> {
    public final HotelsLocationDialogItemClickListener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ HotelsLocationDialogItemPresenter a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HotelsLocationDialogItemPresenter hotelsLocationDialogItemPresenter, int i) {
            super(0);
            this.a = hotelsLocationDialogItemPresenter;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onItemClicked(this.b);
            return Unit.INSTANCE;
        }
    }

    public HotelsLocationDialogItemPresenter(@NotNull HotelsLocationDialogItemClickListener hotelsLocationDialogItemClickListener) {
        Intrinsics.checkNotNullParameter(hotelsLocationDialogItemClickListener, "clickListener");
        this.a = hotelsLocationDialogItemClickListener;
    }

    public void bindView(@NotNull HotelsLocationDialogItemView hotelsLocationDialogItemView, @NotNull HotelsLocationDialogItem hotelsLocationDialogItem, int i) {
        Intrinsics.checkNotNullParameter(hotelsLocationDialogItemView, "view");
        Intrinsics.checkNotNullParameter(hotelsLocationDialogItem, "item");
        hotelsLocationDialogItemView.setText(hotelsLocationDialogItem.getLocation().getName());
        hotelsLocationDialogItemView.bindSubtitle(hotelsLocationDialogItem.getLocation().getRegion());
        hotelsLocationDialogItemView.setOnClickListener(new a(this, i));
    }
}
