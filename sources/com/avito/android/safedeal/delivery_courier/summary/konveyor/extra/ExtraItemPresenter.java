package com.avito.android.safedeal.delivery_courier.summary.konveyor.extra;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemView;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemView;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", AuthSource.BOOKING_ORDER, "Lio/reactivex/functions/Consumer;", "dialogStateConsumer", AuthSource.SEND_ABUSE, "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", "dialogState", "<init>", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;Lio/reactivex/functions/Consumer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ExtraItemPresenter implements ItemPresenter<ExtraItemView, ExtraItem> {
    public final DialogState a;
    public final Consumer<DialogState> b;

    public static final class a extends Lambda implements Function1<DialogState, Unit> {
        public final /* synthetic */ ExtraItemPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ExtraItemPresenter extraItemPresenter, ExtraItem extraItem) {
            super(1);
            this.a = extraItemPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DialogState dialogState) {
            DialogState dialogState2 = dialogState;
            Intrinsics.checkNotNullParameter(dialogState2, "it");
            this.a.b.accept(dialogState2);
            return Unit.INSTANCE;
        }
    }

    public ExtraItemPresenter(@NotNull DialogState dialogState, @NotNull Consumer<DialogState> consumer) {
        Intrinsics.checkNotNullParameter(dialogState, "dialogState");
        Intrinsics.checkNotNullParameter(consumer, "dialogStateConsumer");
        this.a = dialogState;
        this.b = consumer;
    }

    public void bindView(@NotNull ExtraItemView extraItemView, @NotNull ExtraItem extraItem, int i) {
        Intrinsics.checkNotNullParameter(extraItemView, "view");
        Intrinsics.checkNotNullParameter(extraItem, "item");
        extraItemView.setTitle(extraItem.getTitle());
        extraItemView.setExtraInfo(extraItem.getExtraInfoTitle(), extraItem.getExtraInfoText());
        if (this.a == DialogState.SHOWN) {
            extraItemView.showDialog();
        }
        extraItemView.setDialogStateChangeListener(new a(this, extraItem));
    }
}
