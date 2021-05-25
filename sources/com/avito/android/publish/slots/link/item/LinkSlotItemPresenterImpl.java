package com.avito.android.publish.slots.link.item;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.slot.link.LinkSlotAlert;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b)\u0010*J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR:\u0010 \u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\f0\f \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\f0\f\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR:\u0010\"\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00120\u0012 \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR:\u0010%\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010#0# \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010#0#\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001fR\"\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u0010¨\u0006+"}, d2 = {"Lcom/avito/android/publish/slots/link/item/LinkSlotItemPresenterImpl;", "Lcom/avito/android/publish/slots/link/item/LinkSlotItemPresenter;", "Lcom/avito/android/publish/slots/link/item/LinkSlotView;", "view", "Lcom/avito/android/publish/slots/link/item/LinkSlotItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/slots/link/item/LinkSlotView;Lcom/avito/android/publish/slots/link/item/LinkSlotItem;I)V", "Lio/reactivex/Observable;", "", "d", "Lio/reactivex/Observable;", "getUrlClickStream", "()Lio/reactivex/Observable;", "urlClickStream", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "getDeepLinkClickStream", "deepLinkClickStream", "Lcom/avito/android/util/text/AttributedTextFormatter;", g.a, "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "c", "Lcom/jakewharton/rxrelay2/PublishRelay;", "urlClickRelay", "e", "deepLinkClickRelay", "Lcom/avito/android/publish/slots/link/item/LinkAlertParams;", AuthSource.SEND_ABUSE, "alertRelay", AuthSource.BOOKING_ORDER, "getAlertEvents", "alertEvents", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class LinkSlotItemPresenterImpl implements LinkSlotItemPresenter {
    public final PublishRelay<LinkAlertParams> a;
    @NotNull
    public final Observable<LinkAlertParams> b;
    public final PublishRelay<String> c;
    @NotNull
    public final Observable<String> d;
    public final PublishRelay<DeepLink> e;
    @NotNull
    public final Observable<DeepLink> f;
    @NotNull
    public final AttributedTextFormatter g;

    @Inject
    public LinkSlotItemPresenterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.g = attributedTextFormatter;
        PublishRelay<LinkAlertParams> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "alertRelay");
        this.b = create;
        PublishRelay<String> create2 = PublishRelay.create();
        this.c = create2;
        Intrinsics.checkNotNullExpressionValue(create2, "urlClickRelay");
        this.d = create2;
        PublishRelay<DeepLink> create3 = PublishRelay.create();
        this.e = create3;
        Intrinsics.checkNotNullExpressionValue(create3, "deepLinkClickRelay");
        this.f = create3;
    }

    public static final LinkAlertParams access$createLinkAlertParams(LinkSlotItemPresenterImpl linkSlotItemPresenterImpl, LinkSlotAlert linkSlotAlert, Function0 function0) {
        Objects.requireNonNull(linkSlotItemPresenterImpl);
        return new LinkAlertParams(linkSlotAlert.getTitle(), linkSlotAlert.getSubtitle(), linkSlotAlert.getConfirmText(), linkSlotAlert.getCancelText(), function0);
    }

    @Override // com.avito.android.publish.slots.link.item.LinkSlotItemPresenter
    @NotNull
    public Observable<LinkAlertParams> getAlertEvents() {
        return this.b;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        return this.g;
    }

    @Override // com.avito.android.publish.slots.link.item.LinkSlotItemPresenter
    @NotNull
    public Observable<DeepLink> getDeepLinkClickStream() {
        return this.f;
    }

    @Override // com.avito.android.publish.slots.link.item.LinkSlotItemPresenter
    @NotNull
    public Observable<String> getUrlClickStream() {
        return this.d;
    }

    public void bindView(@NotNull LinkSlotView linkSlotView, @NotNull LinkSlotItem linkSlotItem, int i) {
        Intrinsics.checkNotNullParameter(linkSlotView, "view");
        Intrinsics.checkNotNullParameter(linkSlotItem, "item");
        linkSlotItem.getText().setOnUrlClickListener(new LinkSlotItemPresenterImpl$bindView$1(this, linkSlotItem));
        linkSlotItem.getText().setOnDeepLinkClickListener(new LinkSlotItemPresenterImpl$bindView$2(this, linkSlotItem));
        linkSlotView.setText(this.g.format(linkSlotItem.getText()));
    }
}
