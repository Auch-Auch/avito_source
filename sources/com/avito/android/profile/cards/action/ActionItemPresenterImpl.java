package com.avito.android.profile.cards.action;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/cards/action/ActionItemPresenterImpl;", "Lcom/avito/android/profile/cards/action/ActionItemPresenter;", "Lcom/avito/android/profile/cards/action/ActionItemView;", "view", "Lcom/avito/android/profile/cards/CardItem$ActionCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/action/ActionItemView;Lcom/avito/android/profile/cards/CardItem$ActionCardItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clicksConsumer", "<init>", "(Lcom/jakewharton/rxrelay2/PublishRelay;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ActionItemPresenterImpl implements ActionItemPresenter {
    public final PublishRelay<DeepLink> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ActionItemPresenterImpl a;
        public final /* synthetic */ CardItem.ActionCardItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ActionItemPresenterImpl actionItemPresenterImpl, CardItem.ActionCardItem actionCardItem) {
            super(0);
            this.a = actionItemPresenterImpl;
            this.b = actionCardItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b.getAction().getDeepLink());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ActionItemPresenterImpl(@NotNull PublishRelay<DeepLink> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "clicksConsumer");
        this.a = publishRelay;
    }

    public void bindView(@NotNull ActionItemView actionItemView, @NotNull CardItem.ActionCardItem actionCardItem, int i) {
        Intrinsics.checkNotNullParameter(actionItemView, "view");
        Intrinsics.checkNotNullParameter(actionCardItem, "item");
        actionItemView.setTitle(actionCardItem.getAction().getTitle());
        actionItemView.setActionListener(new a(this, actionCardItem));
    }
}
