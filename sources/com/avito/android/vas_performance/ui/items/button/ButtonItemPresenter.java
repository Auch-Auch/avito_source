package com.avito.android.vas_performance.ui.items.button;

import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR:\u0010\u0011\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/button/ButtonItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/button/ButtonItemView;", "Lcom/avito/android/vas_performance/ui/items/button/ButtonItem;", "Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/vas_performance/ui/items/button/ButtonItemView;Lcom/avito/android/vas_performance/ui/items/button/ButtonItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "deeplinkRelay", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getDeeplinkClicks", "()Lio/reactivex/Observable;", "deeplinkClicks", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItemPresenter implements ItemPresenter<ButtonItemView, ButtonItem>, DeeplinkClickStreamProvider {
    public final PublishRelay<DeepLink> a;
    @NotNull
    public final Observable<DeepLink> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ButtonItemPresenter a;
        public final /* synthetic */ ButtonItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ButtonItemPresenter buttonItemPresenter, ButtonItem buttonItem) {
            super(0);
            this.a = buttonItemPresenter;
            this.b = buttonItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b.getDeeplink());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ButtonItemPresenter() {
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "deeplinkRelay");
        this.b = create;
    }

    @Override // com.avito.android.deep_linking.DeeplinkClickStreamProvider
    @NotNull
    public Observable<DeepLink> getDeeplinkClicks() {
        return this.b;
    }

    public void bindView(@NotNull ButtonItemView buttonItemView, @NotNull ButtonItem buttonItem, int i) {
        Intrinsics.checkNotNullParameter(buttonItemView, "view");
        Intrinsics.checkNotNullParameter(buttonItem, "item");
        buttonItemView.setTitle(buttonItem.getTitle());
        buttonItemView.setClickListener(new a(this, buttonItem));
    }
}
