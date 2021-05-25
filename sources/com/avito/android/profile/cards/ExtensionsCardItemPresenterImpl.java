package com.avito.android.profile.cards;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.user_profile.items.ExtensionsItem;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/cards/ExtensionsCardItemPresenterImpl;", "Lcom/avito/android/profile/cards/ExtensionsCardItemPresenter;", "Lcom/avito/android/profile/cards/ExtensionsCardItemView;", "view", "Lcom/avito/android/profile/cards/CardItem$ExtensionsCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/ExtensionsCardItemView;Lcom/avito/android/profile/cards/CardItem$ExtensionsCardItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtensionsCardItemPresenterImpl implements ExtensionsCardItemPresenter {
    public final Lazy<OnDeepLinkClickListener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Action a;
        public final /* synthetic */ ExtensionsCardItemPresenterImpl b;
        public final /* synthetic */ ExtensionsCardItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Action action, ExtensionsCardItemPresenterImpl extensionsCardItemPresenterImpl, ExtensionsCardItemView extensionsCardItemView) {
            super(0);
            this.a = action;
            this.b = extensionsCardItemPresenterImpl;
            this.c = extensionsCardItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((OnDeepLinkClickListener) this.b.a.get()).onDeepLinkClick(this.a.getDeepLink());
            return Unit.INSTANCE;
        }
    }

    public ExtensionsCardItemPresenterImpl(@NotNull Lazy<OnDeepLinkClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public void bindView(@NotNull ExtensionsCardItemView extensionsCardItemView, @NotNull CardItem.ExtensionsCardItem extensionsCardItem, int i) {
        Intrinsics.checkNotNullParameter(extensionsCardItemView, "view");
        Intrinsics.checkNotNullParameter(extensionsCardItem, "item");
        extensionsCardItemView.setTitle(extensionsCardItem.getTitle());
        extensionsCardItemView.setDescription(extensionsCardItem.getDescription());
        List<ExtensionsItem.ExtensionInfo> extensionsInfo = extensionsCardItem.getExtensionsInfo();
        if (extensionsInfo != null) {
            for (T t : extensionsInfo) {
                extensionsCardItemView.addExtensionInfo(t.getTitle(), t.getDescription());
            }
        }
        List<Action> actions = extensionsCardItem.getActions();
        if (actions != null) {
            for (T t2 : actions) {
                extensionsCardItemView.addActionButton(t2.getTitle(), new a(t2, this, extensionsCardItemView));
            }
        }
    }
}
