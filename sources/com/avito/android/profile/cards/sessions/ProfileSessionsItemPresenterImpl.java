package com.avito.android.profile.cards.sessions;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/cards/sessions/ProfileSessionsItemPresenterImpl;", "Lcom/avito/android/profile/cards/sessions/ProfileSessionsItemPresenter;", "Lcom/avito/android/profile/cards/sessions/ProfileSessionsItemView;", "view", "Lcom/avito/android/profile/cards/CardItem$SessionsCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/sessions/ProfileSessionsItemView;Lcom/avito/android/profile/cards/CardItem$SessionsCardItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileSessionsItemPresenterImpl implements ProfileSessionsItemPresenter {
    public final Consumer<DeepLink> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ProfileSessionsItemPresenterImpl a;
        public final /* synthetic */ CardItem.SessionsCardItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ProfileSessionsItemPresenterImpl profileSessionsItemPresenterImpl, CardItem.SessionsCardItem sessionsCardItem) {
            super(0);
            this.a = profileSessionsItemPresenterImpl;
            this.b = sessionsCardItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeepLink deeplink = this.b.getDeeplink();
            if (deeplink != null) {
                this.a.a.accept(deeplink);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ProfileSessionsItemPresenterImpl(@NotNull Consumer<DeepLink> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ProfileSessionsItemView profileSessionsItemView, @NotNull CardItem.SessionsCardItem sessionsCardItem, int i) {
        Intrinsics.checkNotNullParameter(profileSessionsItemView, "view");
        Intrinsics.checkNotNullParameter(sessionsCardItem, "item");
        profileSessionsItemView.bind(sessionsCardItem.getTitle(), sessionsCardItem.getSubtitle(), new a(this, sessionsCardItem));
    }
}
