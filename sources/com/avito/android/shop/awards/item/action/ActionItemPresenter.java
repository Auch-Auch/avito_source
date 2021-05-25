package com.avito.android.shop.awards.item.action;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/shop/awards/item/action/ActionItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/shop/awards/item/action/ActionItemView;", "Lcom/avito/android/shop/awards/item/action/ActionItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop/awards/item/action/ActionItemView;Lcom/avito/android/shop/awards/item/action/ActionItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ActionItemPresenter implements ItemPresenter<ActionItemView, ActionItem> {
    public final Consumer<DeepLink> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ActionItemPresenter a;
        public final /* synthetic */ ActionItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ActionItemPresenter actionItemPresenter, ActionItem actionItem) {
            super(0);
            this.a = actionItemPresenter;
            this.b = actionItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b.getDeepLink());
            return Unit.INSTANCE;
        }
    }

    public ActionItemPresenter(@NotNull Consumer<DeepLink> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ActionItemView actionItemView, @NotNull ActionItem actionItem, int i) {
        Intrinsics.checkNotNullParameter(actionItemView, "view");
        Intrinsics.checkNotNullParameter(actionItem, "item");
        actionItemView.setTitle(actionItem.getTitle());
        actionItemView.setOnClickListener(new a(this, actionItem));
    }
}
