package com.avito.android.profile.cards.verification;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile/cards/verification/VerificationCardPresenterImpl;", "Lcom/avito/android/profile/cards/verification/VerificationCardPresenter;", "Lcom/avito/android/profile/cards/verification/VerificationCardView;", "view", "Lcom/avito/android/profile/cards/CardItem$VerificationCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/verification/VerificationCardView;Lcom/avito/android/profile/cards/CardItem$VerificationCardItem;I)V", "Lio/reactivex/functions/Consumer;", "", AuthSource.BOOKING_ORDER, "Lio/reactivex/functions/Consumer;", "urlClicksStream", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "clicksConsumer", "<init>", "(Lio/reactivex/functions/Consumer;Lio/reactivex/functions/Consumer;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationCardPresenterImpl implements VerificationCardPresenter {
    public final Consumer<DeepLink> a;
    public final Consumer<String> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CardItem.VerificationCardItem.VerificationWay a;
        public final /* synthetic */ VerificationCardPresenterImpl b;
        public final /* synthetic */ VerificationCardView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CardItem.VerificationCardItem.VerificationWay verificationWay, VerificationCardPresenterImpl verificationCardPresenterImpl, VerificationCardView verificationCardView) {
            super(0);
            this.a = verificationWay;
            this.b = verificationCardPresenterImpl;
            this.c = verificationCardView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.a.accept(this.a.getDeepLink());
            return Unit.INSTANCE;
        }
    }

    public VerificationCardPresenterImpl(@NotNull Consumer<DeepLink> consumer, @NotNull Consumer<String> consumer2) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        Intrinsics.checkNotNullParameter(consumer2, "urlClicksStream");
        this.a = consumer;
        this.b = consumer2;
    }

    public void bindView(@NotNull VerificationCardView verificationCardView, @NotNull CardItem.VerificationCardItem verificationCardItem, int i) {
        Intrinsics.checkNotNullParameter(verificationCardView, "view");
        Intrinsics.checkNotNullParameter(verificationCardItem, "item");
        CardItem.VerificationCardItem.VerificationBanner banner = verificationCardItem.getBanner();
        if (banner != null) {
            AttributedText detailsText = banner.getDetailsText();
            if (detailsText != null) {
                detailsText.setOnUrlClickListener(new OnUrlClickListener(this, verificationCardView) { // from class: com.avito.android.profile.cards.verification.VerificationCardPresenterImpl$bindView$$inlined$let$lambda$1
                    public final /* synthetic */ VerificationCardPresenterImpl a;
                    public final /* synthetic */ VerificationCardView b;

                    {
                        this.a = r1;
                        this.b = r2;
                    }

                    @Override // com.avito.android.deep_linking.links.OnUrlClickListener
                    public boolean onUrlClick(@NotNull String str) {
                        Intrinsics.checkNotNullParameter(str, "url");
                        VerificationCardPresenterImpl.access$getUrlClicksStream$p(this.a).accept(str);
                        return true;
                    }
                });
            }
            verificationCardView.setBannerTexts(banner.getTitle(), banner.getDescription(), banner.getDetailsText());
            verificationCardView.setBannerIcon(banner.getIconRes(), banner.getIconTintColor());
            verificationCardView.setBannerBackgroundTint(banner.getBackgroundTintColor());
            verificationCardView.setBannerVisibility(true);
        } else {
            verificationCardView.setBannerVisibility(false);
        }
        verificationCardView.setTitle(verificationCardItem.getTitle());
        verificationCardView.setDescription(verificationCardItem.getDescription());
        verificationCardView.removeVerificationWays();
        for (T t : verificationCardItem.getItems()) {
            verificationCardView.addVerificationWay(t.getTitle(), t.getDescription(), t.getButtonText(), t.getButtonStyleAttr(), t.getButtonEnabled(), new a(t, this, verificationCardView));
        }
    }
}
