package com.avito.android.component.search.list;

import com.avito.android.component.search.BubblesSearchItem;
import com.avito.android.component.search.SuggestItemListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.suggest.BubblesSuggestItem;
import com.avito.android.remote.model.search.suggest.Padding;
import com.avito.android.remote.model.search.suggest.SuggestBubbleItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/component/search/list/BubblesItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/component/search/list/BubblesItemView;", "Lcom/avito/android/component/search/BubblesSearchItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/search/list/BubblesItemView;Lcom/avito/android/component/search/BubblesSearchItem;I)V", "Lcom/avito/android/component/search/SuggestItemListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/component/search/SuggestItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/component/search/SuggestItemListener;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BubblesItemPresenter implements ItemPresenter<BubblesItemView, BubblesSearchItem> {
    public final SuggestItemListener a;

    public static final class a extends Lambda implements Function1<SuggestBubbleItem.ColorConfiguration, Unit> {
        public final /* synthetic */ BubblesSuggestItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BubblesSuggestItem bubblesSuggestItem) {
            super(1);
            this.a = bubblesSuggestItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SuggestBubbleItem.ColorConfiguration colorConfiguration) {
            SuggestBubbleItem.ColorConfiguration colorConfiguration2 = colorConfiguration;
            Intrinsics.checkNotNullParameter(colorConfiguration2, "defaultConfiguration");
            for (T t : this.a.getBubbles()) {
                if (!BubblesItemPresenterKt.a(t.getColorConfiguration(), null)) {
                    t.setColorConfiguration(colorConfiguration2);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public BubblesItemPresenter(@NotNull SuggestItemListener suggestItemListener) {
        Intrinsics.checkNotNullParameter(suggestItemListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = suggestItemListener;
    }

    public void bindView(@NotNull BubblesItemView bubblesItemView, @NotNull BubblesSearchItem bubblesSearchItem, int i) {
        Intrinsics.checkNotNullParameter(bubblesItemView, "view");
        Intrinsics.checkNotNullParameter(bubblesSearchItem, "item");
        BubblesSuggestItem bubblesItem = bubblesSearchItem.getBubblesItem();
        BubblesItemPresenterKt.access$checkValid(bubblesItem.getColorConfiguration(), new a(bubblesItem));
        bubblesItemView.setBubbles(bubblesItem.getBubbles(), this.a);
        Padding padding = bubblesItem.getPadding();
        Integer num = null;
        Integer valueOf = padding != null ? Integer.valueOf(padding.getTop()) : null;
        if (padding != null) {
            num = Integer.valueOf(padding.getBottom());
        }
        bubblesItemView.setPadding(valueOf, num);
    }
}
