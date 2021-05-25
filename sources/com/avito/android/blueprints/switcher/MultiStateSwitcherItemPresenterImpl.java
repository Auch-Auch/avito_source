package com.avito.android.blueprints.switcher;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.items.ItemWithState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR:\u0010\u0010\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R:\u0010\u0018\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemPresenterImpl;", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemPresenter;", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "view", "Lcom/avito/android/items/CheckBoxItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;Lcom/avito/android/items/CheckBoxItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "deepLinkClickStream", "Lio/reactivex/Observable;", "d", "Lio/reactivex/Observable;", "getDeepLinkClicksObservable", "()Lio/reactivex/Observable;", "deepLinkClicksObservable", AuthSource.SEND_ABUSE, "valueChangesStream", "c", "getValueChangesObservable", "valueChangesObservable", "Lcom/avito/android/util/text/AttributedTextFormatter;", "e", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateSwitcherItemPresenterImpl implements MultiStateSwitcherItemPresenter {
    public final PublishRelay<CheckBoxItem> a;
    public final PublishRelay<DeepLink> b;
    @NotNull
    public final Observable<CheckBoxItem> c;
    @NotNull
    public final Observable<DeepLink> d;
    public final AttributedTextFormatter e;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MultiStateSwitcherItemPresenterImpl a;
        public final /* synthetic */ CheckBoxItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MultiStateSwitcherItemPresenterImpl multiStateSwitcherItemPresenterImpl, CheckBoxItem checkBoxItem) {
            super(1);
            this.a = multiStateSwitcherItemPresenterImpl;
            this.b = checkBoxItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.b.setChecked(bool.booleanValue());
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public MultiStateSwitcherItemPresenterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.e = attributedTextFormatter;
        PublishRelay<CheckBoxItem> create = PublishRelay.create();
        this.a = create;
        PublishRelay<DeepLink> create2 = PublishRelay.create();
        this.b = create2;
        Observable<CheckBoxItem> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "valueChangesStream.hide()");
        this.c = hide;
        Observable<DeepLink> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "deepLinkClickStream.hide()");
        this.d = hide2;
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter
    @NotNull
    public Observable<DeepLink> getDeepLinkClicksObservable() {
        return this.d;
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter
    @NotNull
    public Observable<CheckBoxItem> getValueChangesObservable() {
        return this.c;
    }

    public void bindView(@NotNull MultiStateSwitcherItemView multiStateSwitcherItemView, @NotNull CheckBoxItem checkBoxItem, int i) {
        Intrinsics.checkNotNullParameter(multiStateSwitcherItemView, "view");
        Intrinsics.checkNotNullParameter(checkBoxItem, "item");
        multiStateSwitcherItemView.bindHeader(checkBoxItem.getHideTitle() ? "" : checkBoxItem.getHeader());
        multiStateSwitcherItemView.setTitle(checkBoxItem.getText());
        AttributedText subTitle = checkBoxItem.getSubTitle();
        CharSequence charSequence = null;
        multiStateSwitcherItemView.setSubTitle(subTitle != null ? this.e.format(subTitle) : null);
        multiStateSwitcherItemView.setChecked(checkBoxItem.isChecked());
        AttributedText subTitle2 = checkBoxItem.getSubTitle();
        if (subTitle2 != null) {
            subTitle2.setOnDeepLinkClickListener(new OnDeepLinkClickListener(this, checkBoxItem) { // from class: com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenterImpl$bindView$$inlined$with$lambda$1
                public final /* synthetic */ MultiStateSwitcherItemPresenterImpl a;

                {
                    this.a = r1;
                }

                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                    Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                    MultiStateSwitcherItemPresenterImpl.access$getDeepLinkClickStream$p(this.a).accept(deepLink);
                }
            });
        }
        ItemWithState.State state = checkBoxItem.getState();
        if (state instanceof ItemWithState.State.Error) {
            multiStateSwitcherItemView.setErrorState(((ItemWithState.State.Error) state).getMessage());
        } else if (state instanceof ItemWithState.State.Warning) {
            multiStateSwitcherItemView.setWarningState(((ItemWithState.State.Warning) state).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            CharSequence message = ((ItemWithState.State.Normal) state).getMessage();
            if (message != null) {
                charSequence = message;
            } else {
                AttributedText motivation = checkBoxItem.getMotivation();
                if (motivation != null) {
                    charSequence = this.e.format(motivation);
                }
            }
            multiStateSwitcherItemView.setNormalState(charSequence);
        }
        multiStateSwitcherItemView.setCheckListener(new a(this, checkBoxItem));
    }
}
