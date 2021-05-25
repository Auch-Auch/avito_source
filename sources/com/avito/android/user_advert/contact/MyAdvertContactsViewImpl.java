package com.avito.android.user_advert.contact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_advert/contact/MyAdvertContactsViewImpl;", "Lcom/avito/android/user_advert/contact/MyAdvertContactsView;", "", "Lcom/avito/android/user_advert/contact/MyAdvertContact;", "contacts", "", "showContacts", "(Ljava/util/List;)V", "Landroid/view/ViewStub;", "c", "Landroid/view/ViewStub;", "rootView", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "container", "Landroid/view/LayoutInflater;", AuthSource.BOOKING_ORDER, "Landroid/view/LayoutInflater;", "inflater", "<init>", "(Landroid/view/ViewStub;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertContactsViewImpl implements MyAdvertContactsView {
    public ViewGroup a;
    public final LayoutInflater b;
    public final ViewStub c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UserIconType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            UserIconType userIconType = UserIconType.PRIVATE;
            iArr[0] = 1;
            UserIconType userIconType2 = UserIconType.COMPANY;
            iArr[1] = 2;
            UserIconType userIconType3 = UserIconType.SHOP;
            iArr[2] = 3;
        }
    }

    public MyAdvertContactsViewImpl(@NotNull ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(viewStub, "rootView");
        this.c = viewStub;
        LayoutInflater from = LayoutInflater.from(viewStub.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(rootView.context)");
        this.b = from;
    }

    @Override // com.avito.android.user_advert.contact.MyAdvertContactsView
    public void showContacts(@NotNull List<MyAdvertContact> list) {
        int i;
        Intrinsics.checkNotNullParameter(list, "contacts");
        if (this.a == null) {
            View inflate = this.c.inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            View findViewById = ((ViewGroup) inflate).findViewById(R.id.contacts_container);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            this.a = (ViewGroup) findViewById;
        }
        ViewGroup viewGroup = this.a;
        Intrinsics.checkNotNull(viewGroup);
        viewGroup.removeAllViews();
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (i2 > 0) {
                View inflate2 = this.b.inflate(com.avito.android.deprecated_design.R.layout.divider_1_0, this.a, false);
                ViewGroup.LayoutParams layoutParams = inflate2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = inflate2.getResources().getDimensionPixelSize(com.avito.android.user_advert.R.dimen.advert_contacts_left_margin) + inflate2.getResources().getDimensionPixelSize(R.dimen.content_horizontal_padding);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflater.inflate(depreca…ts_left_margin)\n        }");
                viewGroup.addView(inflate2);
            }
            View inflate3 = this.b.inflate(com.avito.android.user_advert.R.layout.advert_seller_contact_with_social, this.a, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            View findViewById2 = inflate3.findViewById(com.avito.android.user_advert.R.id.icon);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById2;
            UserIconType icon = t2.getIcon();
            if (icon == null) {
                Views.conceal(simpleDraweeView);
            } else {
                int ordinal = icon.ordinal();
                if (ordinal == 0) {
                    i = R.drawable.ic_user_24;
                } else if (ordinal == 1) {
                    i = R.drawable.ic_company_24;
                } else if (ordinal == 2) {
                    i = R.drawable.ic_shop_24;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                Drawable drawable = simpleDraweeView.getContext().getDrawable(i);
                Drawable drawable2 = simpleDraweeView.getContext().getDrawable(R.drawable.bg_btn_circle_gray);
                Context context = simpleDraweeView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                int colorByAttr = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28);
                Intrinsics.checkNotNull(drawable);
                DrawablesKt.wrapForTinting(drawable, colorByAttr);
                ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setBackgroundImage(drawable2);
                ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setPlaceholderImage(drawable);
            }
            Image avatar = t2.getAvatar();
            if (avatar != null) {
                SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture(AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null)).load();
            }
            View findViewById3 = inflate3.findViewById(com.avito.android.user_advert.R.id.title);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            TextViews.bindText$default((TextView) findViewById3, t2.getTitle(), false, 2, null);
            View findViewById4 = inflate3.findViewById(com.avito.android.user_advert.R.id.subtitle);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextViews.bindText$default((TextView) findViewById4, t2.getSubTitle(), false, 2, null);
            viewGroup.addView(inflate3);
            i2 = i3;
        }
    }
}
