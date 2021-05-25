package com.avito.android.component.user_advert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.component.icons_view.IconsView;
import com.avito.android.db.FavoritesContract;
import com.avito.android.image_loader.ForegroundConverter;
import com.avito.android.image_loader.ForegroundConverterImpl;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.BadgesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010t\u001a\u00020\\¢\u0006\u0004\bx\u0010yJ#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u0019\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0018J\u0019\u0010\"\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0010J!\u0010&\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\u0018J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020$H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020$H\u0016¢\u0006\u0004\b0\u0010.J\u0017\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020$H\u0016¢\u0006\u0004\b6\u0010.J\u001f\u00109\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u000201H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0007H\u0016¢\u0006\u0004\b;\u0010\u0018J\u001f\u0010<\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u000201H\u0016¢\u0006\u0004\b<\u0010:J\u000f\u0010=\u001a\u00020\u0007H\u0016¢\u0006\u0004\b=\u0010\u0018J\u0017\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020$H\u0016¢\u0006\u0004\b?\u0010.J\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010\u0018J\u000f\u0010A\u001a\u00020\u0007H\u0016¢\u0006\u0004\bA\u0010\u0018J#\u0010D\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010\u00042\b\u0010C\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bD\u0010\u001cJ#\u0010E\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010N\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010IR\u0016\u0010P\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010IR\u0016\u0010S\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010IR\u0016\u0010[\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010IR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010IR\u0016\u0010d\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010cR\u0016\u0010f\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010IR\u0016\u0010h\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010IR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010IR\u0016\u0010t\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010^R\u0016\u0010w\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010v¨\u0006z"}, d2 = {"Lcom/avito/android/component/user_advert/UserAdvertItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/user_advert/UserAdvertItemView;", "", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "", "setServiceIcons", "(Ljava/util/Map;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "title", "setTitle", "(Ljava/lang/String;)V", "price", "setPrice", "Lcom/avito/android/remote/model/badge/Badge;", "priceBadge", "setPriceBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hidePriceBadge", "()V", "watchesTotal", "watchesToday", "showViewsStats", "(Ljava/lang/String;Ljava/lang/String;)V", "showViewsStatsNoViews", FavoritesContract.TABLE_NAME, "showFavoritesStats", "hideStats", Constants.FirelogAnalytics.PARAM_TTL, "setTimeToLive", "declineReason", "", "isCritical", "setDeclineReason", "(Ljava/lang/String;Z)V", "hideServices", "picture", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "isModerated", "setModerationStatus", "(Z)V", "active", "setActive", "", "widthPx", "setWidth", "(I)V", "isShowDelivery", "setDeliveryVisible", "text", "colorAttr", "showStatus", "(Ljava/lang/String;I)V", "hideStatus", "showOrderStatus", "hideOrderStatus", "visible", "setAutoPublishVisibility", "hideContactStats", "showContactStatsNoViews", "contactsTotal", "contactsToday", "showContactStats", "t", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "priceBadgeView", "u", "titleView", "H", "contactsStatsView", "D", "statusView", "G", "I", "darkGreyColor", "Landroid/graphics/drawable/Drawable;", "s", "Landroid/graphics/drawable/Drawable;", "autoPublishDrawable", "x", "watchesStatsView", "B", "moderationBadge", "Landroid/view/View;", "F", "Landroid/view/View;", "deliveryIcon", "y", "favoritesStatsView", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "z", "ttlView", VKApiConst.VERSION, "priceView", "Lcom/facebook/drawee/view/SimpleDraweeView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Lcom/avito/android/component/icons_view/IconsView;", "C", "Lcom/avito/android/component/icons_view/IconsView;", "serviceIcons", ExifInterface.LONGITUDE_EAST, "orderStatusView", "J", "view", "Lcom/avito/android/image_loader/ForegroundConverter;", "Lcom/avito/android/image_loader/ForegroundConverter;", "foregroundImageConverter", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertItemViewImpl extends BaseViewHolder implements UserAdvertItemView {
    public final SimpleDraweeView A;
    public final TextView B;
    public final IconsView C;
    public final TextView D;
    public final TextView E;
    public final View F;
    public final int G;
    public final TextView H;
    public final ForegroundConverter I = new ForegroundConverterImpl(new AttributedTextFormatterImpl());
    public final View J;
    public final Drawable s;
    public final Resources t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAdvertItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.J = view;
        this.s = view.getContext().getDrawable(R.drawable.ic_advert_autopublish);
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        this.t = resources;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.price_badge);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.watch_stats);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.favorites_stats);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.y = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.date);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.z = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.A = (SimpleDraweeView) findViewById7;
        View findViewById8 = view.findViewById(R.id.internal_status);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.B = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.icons);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type com.avito.android.component.icons_view.IconsView");
        this.C = (IconsView) findViewById9;
        View findViewById10 = view.findViewById(R.id.status);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.status)");
        this.D = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.order_status);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.order_status)");
        this.E = (TextView) findViewById11;
        this.F = view.findViewById(R.id.icon_delivery);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.G = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48);
        View findViewById12 = view.findViewById(R.id.contact_stats);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.contact_stats)");
        this.H = (TextView) findViewById12;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void hideContactStats() {
        Views.hide(this.H);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void hideOrderStatus() {
        Views.hide(this.E);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void hidePriceBadge() {
        Views.setVisible(this.w, false);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void hideServices() {
        Views.hide(this.C);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void hideStats() {
        Views.hide(this.x);
        Views.hide(this.y);
        Views.hide(this.H);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void hideStatus() {
        Views.hide(this.D);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setActive(boolean z2) {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        view.setClickable(z2);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setAutoPublishVisibility(boolean z2) {
        this.z.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, z2 ? this.s : null, (Drawable) null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.itemView.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setDeclineReason(@Nullable String str, boolean z2) {
        int i;
        TextView textView = this.z;
        Context context = this.J.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (z2) {
            i = com.avito.android.lib.design.R.attr.red600;
        } else {
            i = com.avito.android.lib.design.R.attr.orange800;
        }
        textView.setTextColor(Contexts.getColorByAttr(context, i));
        TextViews.bindText$default(this.z, str, false, 2, null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setDeliveryVisible(boolean z2) {
        if (z2) {
            Views.show(this.F);
        } else {
            Views.hide(this.F);
        }
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setImage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        ForegroundConverter foregroundConverter = this.I;
        Context context = this.A.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
        SimpleDraweeViewsKt.getRequestBuilder(this.A).picture(picture).foreground(ForegroundConverter.DefaultImpls.convert$default(foregroundConverter, context, picture, null, 4, null)).sourcePlace(ImageRequest.SourcePlace.SNIPPET).load();
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setModerationStatus(boolean z2) {
        Views.setVisible(this.B, z2);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setPrice(@Nullable String str) {
        TextViews.bindText$default(this.v, str, false, 2, null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setPriceBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "priceBadge");
        Views.setVisible(this.w, true);
        BadgesKt.setBadge(this.w, badge);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setServiceIcons(@NotNull Map<String, ? extends Picture> map) {
        Intrinsics.checkNotNullParameter(map, "pictures");
        this.C.setIcons(map);
        Views.show(this.C);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setTimeToLive(@Nullable String str) {
        this.z.setTextColor(this.G);
        TextViews.bindText$default(this.z, str, false, 2, null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void setWidth(int i) {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        view2.setLayoutParams(layoutParams);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void showContactStats(@Nullable String str, @Nullable String str2) {
        TextViews.bindText$default(this.H, t(str2, str), false, 2, null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void showContactStatsNoViews() {
        TextViews.bindText$default(this.H, this.t.getString(R.string.rds_my_adverts_list_no_watch), false, 2, null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void showFavoritesStats(@Nullable String str) {
        TextViews.bindText$default(this.y, str, false, 2, null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void showOrderStatus(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText$default(this.E, str, false, 2, null);
        Drawable drawable = ContextCompat.getDrawable(this.E.getContext(), R.drawable.bg_order_status);
        if (drawable != null) {
            Context context = this.E.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "orderStatusView.context");
            drawable.setColorFilter(Contexts.getColorByAttr(context, i), PorterDuff.Mode.SRC_ATOP);
        }
        this.E.setBackground(drawable);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void showStatus(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText$default(this.D, str, false, 2, null);
        TextView textView = this.D;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "statusView.context");
        textView.setTextColor(Contexts.getColorByAttr(context, i));
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void showViewsStats(@Nullable String str, @Nullable String str2) {
        TextViews.bindText$default(this.x, t(str2, str), false, 2, null);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemView
    public void showViewsStatsNoViews() {
        TextViews.bindText$default(this.x, this.t.getString(R.string.rds_my_adverts_list_no_watch), false, 2, null);
    }

    public final String t(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = this.t.getString(R.string.rds_my_adverts_list_watch_stats, str2, str);
        } else {
            str3 = this.t.getString(R.string.rds_my_adverts_list_watch_stats_only_total, str2);
        }
        Intrinsics.checkNotNullExpressionValue(str3, "when {\n        watchesTo…chesTotal\n        )\n    }");
        return str3;
    }
}
