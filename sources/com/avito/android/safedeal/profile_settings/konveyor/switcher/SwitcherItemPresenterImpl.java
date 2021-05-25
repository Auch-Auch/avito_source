package com.avito.android.safedeal.profile_settings.konveyor.switcher;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.remote.model.ProfileDeliverySettings;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR(\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemPresenterImpl;", "Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemPresenter;", "Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemView;", "view", "Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemView;Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "linkClicksConsumer", AuthSource.BOOKING_ORDER, "clicksConsumer", "Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "", "", "c", "Lio/reactivex/rxjava3/core/Observable;", "loadingStateObservable", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;Lio/reactivex/rxjava3/functions/Consumer;Lio/reactivex/rxjava3/core/Observable;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SwitcherItemPresenterImpl implements SwitcherItemPresenter {
    public final Consumer<DeepLink> a;
    public final Consumer<SwitcherItem> b;
    public final Observable<Pair<String, Boolean>> c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SwitcherItemPresenterImpl a;
        public final /* synthetic */ SwitcherItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SwitcherItemPresenterImpl switcherItemPresenterImpl, SwitcherItem switcherItem) {
            super(0);
            this.a = switcherItemPresenterImpl;
            this.b = switcherItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<Pair<? extends String, ? extends Boolean>> {
        public final /* synthetic */ SwitcherItemView a;
        public final /* synthetic */ SwitcherItem b;

        public b(SwitcherItemView switcherItemView, SwitcherItemPresenterImpl switcherItemPresenterImpl, SwitcherItem switcherItem) {
            this.a = switcherItemView;
            this.b = switcherItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Pair<? extends String, ? extends Boolean> pair) {
            Pair<? extends String, ? extends Boolean> pair2 = pair;
            boolean booleanValue = ((Boolean) pair2.component2()).booleanValue();
            if (!(!Intrinsics.areEqual((String) pair2.component1(), this.b.getStringId()))) {
                this.a.setLoading(booleanValue);
                if (!booleanValue) {
                    this.a.setChecked(this.b.isChecked());
                }
            }
        }
    }

    public SwitcherItemPresenterImpl(@NotNull Consumer<DeepLink> consumer, @NotNull Consumer<SwitcherItem> consumer2, @NotNull Observable<Pair<String, Boolean>> observable) {
        Intrinsics.checkNotNullParameter(consumer, "linkClicksConsumer");
        Intrinsics.checkNotNullParameter(consumer2, "clicksConsumer");
        Intrinsics.checkNotNullParameter(observable, "loadingStateObservable");
        this.a = consumer;
        this.b = consumer2;
        this.c = observable;
    }

    public void bindView(@NotNull SwitcherItemView switcherItemView, @NotNull SwitcherItem switcherItem, int i) {
        Intrinsics.checkNotNullParameter(switcherItemView, "view");
        Intrinsics.checkNotNullParameter(switcherItem, "item");
        switcherItemView.setTitle(switcherItem.getTitle());
        switcherItemView.setSubtitle(switcherItem.getSubtitle());
        ProfileDeliverySettings.Service.Content.Link link = switcherItem.getLink();
        if (link != null) {
            switcherItemView.setLink(link.getText(), link.getDeepLink(), new Function1<DeepLink, Unit>(this.a) { // from class: com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemPresenterImpl.c
                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(DeepLink deepLink) {
                    ((Consumer) this.receiver).accept(deepLink);
                    return Unit.INSTANCE;
                }
            });
        }
        switcherItemView.setChecked(switcherItem.isChecked());
        switcherItemView.setImageDrawable(switcherItem.getImageRes());
        switcherItemView.setOnClickListener(new a(this, switcherItem));
        this.c.subscribe(new b(switcherItemView, this, switcherItem));
    }
}
