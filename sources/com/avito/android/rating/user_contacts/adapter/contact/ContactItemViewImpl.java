package com.avito.android.rating.user_contacts.adapter.contact;

import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.button.Button;
import com.avito.android.rating.R;
import com.avito.android.rating.user_contacts.UserContactRatingSelectView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00052\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0011R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00102\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010%¨\u00067"}, d2 = {"Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItemView;", "", "name", "", "setContactName", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "image", "setItemImage", "(Lcom/avito/android/image_loader/Picture;)V", "title", "setItemTitle", "price", "setItemPrice", "resetRating", "()V", "Lio/reactivex/rxjava3/core/Observable;", "removeClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "ratingClicks", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "y", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/avito/android/rating/user_contacts/UserContactRatingSelectView;", "w", "Lcom/avito/android/rating/user_contacts/UserContactRatingSelectView;", "itemScoreView", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "itemPriceView", "Lcom/avito/android/lib/design/button/Button;", "x", "Lcom/avito/android/lib/design/button/Button;", "removeContactButton", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "itemImageView", "u", "itemTitleView", "s", "contactNameView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ContactItemViewImpl extends BaseViewHolder implements ContactItemView {
    public final TextView s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public final UserContactRatingSelectView w;
    public final Button x;
    public Function0<Unit> y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContactItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.contact_name);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.item_image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.item_title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.item_price);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.item_score);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.rating.user_contacts.UserContactRatingSelectView");
        this.w = (UserContactRatingSelectView) findViewById5;
        View findViewById6 = view.findViewById(R.id.btn_remove_contact);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.x = (Button) findViewById6;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.y;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.rating.user_contacts.adapter.contact.ContactItemView
    @NotNull
    public Observable<Integer> ratingClicks() {
        Observable<Integer> create = Observable.create(new ObservableOnSubscribe<Integer>(this) { // from class: com.avito.android.rating.user_contacts.adapter.contact.ContactItemViewImpl$ratingClicks$1
            public final /* synthetic */ ContactItemViewImpl a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<Integer> observableEmitter) {
                this.a.w.setOnRatingSelectListener(new UserContactRatingSelectView.OnRatingSelectListener() { // from class: com.avito.android.rating.user_contacts.adapter.contact.ContactItemViewImpl$ratingClicks$1.1
                    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.avito.android.rating.user_contacts.UserContactRatingSelectView.OnRatingSelectListener
                    public void onRatingSelect(int i) {
                        observableEmitter.onNext(Integer.valueOf(i));
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.rating.user_contacts.adapter.contact.ContactItemView
    @NotNull
    public Observable<Unit> removeClicks() {
        return RxView.clicks(this.x);
    }

    @Override // com.avito.android.rating.user_contacts.adapter.contact.ContactItemView
    public void resetRating() {
        this.w.resetSelectedRating();
    }

    @Override // com.avito.android.rating.user_contacts.adapter.contact.ContactItemView
    public void setContactName(@Nullable String str) {
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.android.rating.user_contacts.adapter.contact.ContactItemView
    public void setItemImage(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.t, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.user_contacts.adapter.contact.ContactItemView
    public void setItemPrice(@Nullable String str) {
        TextViews.bindText$default(this.v, str, false, 2, null);
    }

    @Override // com.avito.android.rating.user_contacts.adapter.contact.ContactItemView
    public void setItemTitle(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.rating.user_contacts.adapter.contact.ContactItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.y = function0;
    }
}
