package com.avito.android.delivery.suggest.konveyor.suggest;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItemPresenterImpl;", "Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItemPresenter;", "Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItemView;", "view", "Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItemView;Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/remote/model/Coordinates;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestItemPresenterImpl implements SuggestItemPresenter {
    public final Consumer<Coordinates> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SuggestItemPresenterImpl a;
        public final /* synthetic */ SuggestItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SuggestItemPresenterImpl suggestItemPresenterImpl, SuggestItem suggestItem) {
            super(0);
            this.a = suggestItemPresenterImpl;
            this.b = suggestItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b.getCoordinates());
            return Unit.INSTANCE;
        }
    }

    public SuggestItemPresenterImpl(@NotNull Consumer<Coordinates> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull SuggestItemView suggestItemView, @NotNull SuggestItem suggestItem, int i) {
        Intrinsics.checkNotNullParameter(suggestItemView, "view");
        Intrinsics.checkNotNullParameter(suggestItem, "item");
        suggestItemView.setData(suggestItem.getTitle(), suggestItem.getSubTitle());
        suggestItemView.setActionClickListener(new a(this, suggestItem));
    }
}
