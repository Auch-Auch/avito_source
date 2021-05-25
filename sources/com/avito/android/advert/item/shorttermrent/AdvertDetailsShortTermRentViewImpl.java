package com.avito.android.advert.item.shorttermrent;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentView;
import com.avito.android.advert_details.R;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.util.ContextsKt;
import com.avito.android.remote.model.AdvertShortTermRent;
import com.avito.android.remote.model.SimpleAction;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView;", "Lcom/avito/android/remote/model/AdvertShortTermRent;", "shortTermRent", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", "buttonListener", "", "showShortTermRent", "(Lcom/avito/android/remote/model/AdvertShortTermRent;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "tagTextView", "Landroid/view/View;", "s", "Landroid/view/View;", "shortTermRentActionsView", "Lcom/avito/android/lib/design/button/Button;", "t", "Lcom/avito/android/lib/design/button/Button;", "primaryButton", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsShortTermRentViewImpl extends BaseViewHolder implements AdvertDetailsShortTermRentView {
    public View s;
    public Button t;
    public TextView u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsShortTermRentViewImpl a;
        public final /* synthetic */ DeepLinkFactory b;
        public final /* synthetic */ SimpleAction c;
        public final /* synthetic */ AdvertDetailsShortTermRentView.Listener d;

        public a(AdvertDetailsShortTermRentViewImpl advertDetailsShortTermRentViewImpl, DeepLinkFactory deepLinkFactory, SimpleAction simpleAction, AdvertDetailsShortTermRentView.Listener listener) {
            this.a = advertDetailsShortTermRentViewImpl;
            this.b = deepLinkFactory;
            this.c = simpleAction;
            this.d = listener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.b.createFromUri(this.c.getUri()) instanceof NoMatchLink) {
                AdvertDetailsShortTermRentViewImpl.access$hideAllContent(this.a);
                return;
            }
            AdvertDetailsShortTermRentView.Listener listener = this.d;
            if (listener != null) {
                listener.onClickShortTermRent(this.c.getUri());
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsShortTermRentViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        view.getContext();
        View findViewById = view.findViewById(R.id.layout_str_buttons);
        this.s = findViewById;
        TextView textView = null;
        this.t = findViewById != null ? (Button) findViewById.findViewById(R.id.primary_button) : null;
        View view2 = this.s;
        this.u = view2 != null ? (TextView) view2.findViewById(R.id.tag_text_view) : textView;
    }

    public static final void access$hideAllContent(AdvertDetailsShortTermRentViewImpl advertDetailsShortTermRentViewImpl) {
        Button button = advertDetailsShortTermRentViewImpl.t;
        if (button != null) {
            Views.hide(button);
        }
        View view = advertDetailsShortTermRentViewImpl.s;
        if (view != null) {
            Views.hide(view);
        }
        Views.hide(advertDetailsShortTermRentViewImpl.u);
    }

    @Override // com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentView
    public void showShortTermRent(@NotNull AdvertShortTermRent advertShortTermRent, @NotNull DeepLinkFactory deepLinkFactory, @Nullable AdvertDetailsShortTermRentView.Listener listener) {
        Button button;
        Intrinsics.checkNotNullParameter(advertShortTermRent, "shortTermRent");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        AdvertShortTermRent.Actions actions = advertShortTermRent.getActions();
        if (actions == null) {
            Button button2 = this.t;
            if (button2 != null) {
                Views.hide(button2);
            }
            View view = this.s;
            if (view != null) {
                Views.hide(view);
            }
            Views.hide(this.u);
            return;
        }
        SimpleAction requestBooking = actions.getRequestBooking();
        if (requestBooking == null) {
            Button button3 = this.t;
            if (button3 != null) {
                Views.hide(button3);
            }
        } else {
            Button button4 = this.t;
            if (button4 != null) {
                button4.setText(requestBooking.getTitle());
            }
            Button button5 = this.t;
            if (button5 != null) {
                button5.setOnClickListener(new a(this, deepLinkFactory, requestBooking, listener));
            }
            String style = requestBooking.getStyle();
            if (!(style == null || (button = this.t) == null)) {
                button.setAppearanceFromAttr(ContextsKt.getButtonStyleByAttrName(style));
            }
        }
        TextView textView = this.u;
        if (textView != null) {
            TextViews.bindText$default(textView, advertShortTermRent.getTag(), false, 2, null);
        }
    }
}
