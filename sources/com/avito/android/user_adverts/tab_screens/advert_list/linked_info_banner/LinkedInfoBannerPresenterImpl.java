package com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.BannerEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LinkedInfoBannerButton;
import com.avito.android.remote.model.LinkedInfoBannerIcon;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.Attribute;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b \u0010!J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R:\u0010\u0016\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00040\u0004 \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R:\u0010\u001c\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\f0\f \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\f0\f\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010¨\u0006\""}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenterImpl;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenter;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItemView;", "view", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItemView;Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItem;I)V", "Lio/reactivex/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lio/reactivex/Observable;", "getDeeplinkClicks", "()Lio/reactivex/Observable;", "deeplinkClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "closeRelay", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.SEND_ABUSE, "deeplinkRelay", "d", "getCloseBannerClicks", "closeBannerClicks", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class LinkedInfoBannerPresenterImpl implements LinkedInfoBannerPresenter {
    public final PublishRelay<DeepLink> a;
    public final PublishRelay<LinkedInfoBannerItem> b;
    @NotNull
    public final Observable<DeepLink> c;
    @NotNull
    public final Observable<LinkedInfoBannerItem> d;
    public final Analytics e;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            DeepLink action;
            int i = this.a;
            if (i == 0) {
                DeepLink access$getDeepLink = LinkedInfoBannerPresenterImpl.access$getDeepLink((LinkedInfoBannerPresenterImpl) this.b, (LinkedInfoBannerItem) this.c);
                if (access$getDeepLink != null) {
                    LinkedInfoBannerPresenterImpl.access$handleClick((LinkedInfoBannerPresenterImpl) this.b, access$getDeepLink, ((LinkedInfoBannerItem) this.c).getStringId(), "click");
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                LinkedInfoBannerButton button = ((LinkedInfoBannerItem) this.c).getButton();
                if (!(button == null || (action = button.getAction()) == null)) {
                    LinkedInfoBannerPresenterImpl.access$handleClick((LinkedInfoBannerPresenterImpl) this.b, action, ((LinkedInfoBannerItem) this.c).getStringId(), BannerEvent.ACTION_BUTTON_CLICK);
                }
                return Unit.INSTANCE;
            } else if (i == 2) {
                LinkedInfoBannerPresenterImpl.access$handleClose((LinkedInfoBannerPresenterImpl) this.b, (LinkedInfoBannerItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public LinkedInfoBannerPresenterImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.e = analytics;
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.a = create;
        PublishRelay<LinkedInfoBannerItem> create2 = PublishRelay.create();
        this.b = create2;
        Intrinsics.checkNotNullExpressionValue(create, "deeplinkRelay");
        this.c = create;
        Intrinsics.checkNotNullExpressionValue(create2, "closeRelay");
        this.d = create2;
    }

    public static final DeepLink access$getDeepLink(LinkedInfoBannerPresenterImpl linkedInfoBannerPresenterImpl, LinkedInfoBannerItem linkedInfoBannerItem) {
        List<Attribute> attributes;
        Objects.requireNonNull(linkedInfoBannerPresenterImpl);
        AttributedText detailsLink = linkedInfoBannerItem.getDetailsLink();
        Attribute attribute = (detailsLink == null || (attributes = detailsLink.getAttributes()) == null) ? null : (Attribute) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) attributes);
        if (!(attribute instanceof DeepLinkAttribute)) {
            attribute = null;
        }
        DeepLinkAttribute deepLinkAttribute = (DeepLinkAttribute) attribute;
        if (deepLinkAttribute != null) {
            return deepLinkAttribute.getDeepLink();
        }
        return null;
    }

    public static final void access$handleClick(LinkedInfoBannerPresenterImpl linkedInfoBannerPresenterImpl, DeepLink deepLink, String str, String str2) {
        Objects.requireNonNull(linkedInfoBannerPresenterImpl);
        if (!(deepLink instanceof NoMatchLink)) {
            linkedInfoBannerPresenterImpl.e.track(new BannerEvent.Action(str, "profile", "top", str2));
            linkedInfoBannerPresenterImpl.a.accept(deepLink);
        }
    }

    public static final void access$handleClose(LinkedInfoBannerPresenterImpl linkedInfoBannerPresenterImpl, LinkedInfoBannerItem linkedInfoBannerItem) {
        linkedInfoBannerPresenterImpl.e.track(new BannerEvent.ProfileBannerClosed(linkedInfoBannerItem.getStringId(), "profile", "top"));
        linkedInfoBannerPresenterImpl.b.accept(linkedInfoBannerItem);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenter
    @NotNull
    public Observable<LinkedInfoBannerItem> getCloseBannerClicks() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.DeeplinkClickStreamProvider
    @NotNull
    public Observable<DeepLink> getDeeplinkClicks() {
        return this.c;
    }

    public void bindView(@NotNull LinkedInfoBannerItemView linkedInfoBannerItemView, @NotNull LinkedInfoBannerItem linkedInfoBannerItem, int i) {
        Intrinsics.checkNotNullParameter(linkedInfoBannerItemView, "view");
        Intrinsics.checkNotNullParameter(linkedInfoBannerItem, "item");
        this.e.track(new BannerEvent.Shown(linkedInfoBannerItem.getStringId(), "profile", "top"));
        linkedInfoBannerItemView.setClickListener(new a(0, this, linkedInfoBannerItem));
        linkedInfoBannerItemView.setTitle(linkedInfoBannerItem.getTitle());
        linkedInfoBannerItemView.setMessage(linkedInfoBannerItem.getMessage());
        linkedInfoBannerItemView.setDetailsLink(linkedInfoBannerItem.getDetailsLink(), new OnDeepLinkClickListener(this, linkedInfoBannerItem) { // from class: com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenterImpl$bindView$$inlined$with$lambda$2
            public final /* synthetic */ LinkedInfoBannerPresenterImpl a;
            public final /* synthetic */ LinkedInfoBannerItem b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
            public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                LinkedInfoBannerPresenterImpl.access$handleClick(this.a, deepLink, this.b.getStringId(), "click");
            }
        });
        LinkedInfoBannerButton button = linkedInfoBannerItem.getButton();
        linkedInfoBannerItemView.setButton(button != null ? button.getTitle() : null, new a(1, this, linkedInfoBannerItem));
        UniversalColor background = linkedInfoBannerItem.getBackground();
        if (background != null) {
            linkedInfoBannerItemView.setBackground(background);
        } else {
            linkedInfoBannerItemView.setDefaultBackground();
        }
        LinkedInfoBannerIcon icon = linkedInfoBannerItem.getIcon();
        if (icon != null) {
            linkedInfoBannerItemView.setIcon(icon);
        } else {
            linkedInfoBannerItemView.hideIcon();
        }
        linkedInfoBannerItemView.showCloseButton(linkedInfoBannerItem.getCloseBtnVisible());
        linkedInfoBannerItemView.setCloseButtonListener(new a(2, this, linkedInfoBannerItem));
    }
}
