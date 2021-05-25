package com.avito.android.favorites.adapter.advert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterImpl;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl;
import com.avito.android.favorites.R;
import com.avito.android.image_loader.Picture;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.CheckableImageButton;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010j\u001a\u00020J\u0012\u0006\u0010u\u001a\u00020t\u0012\u0006\u0010w\u001a\u00020v¢\u0006\u0004\bx\u0010yJ\u001f\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001b\u0010\rJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001d\u0010\rJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001f\u0010\rJ\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b!\u0010\rJ\u0019\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b'\u0010\rJ\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0016H\u0016¢\u0006\u0004\b)\u0010\u0019J\u001f\u0010*\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b*\u0010\u0007J\u001f\u0010+\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b+\u0010\u0007J\u001f\u0010-\u001a\u00020\u00042\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b-\u0010\u0007J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0016H\u0016¢\u0006\u0004\b/\u0010\u0019J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0016H\u0016¢\u0006\u0004\b1\u0010\u0019J\u0017\u00102\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0016H\u0016¢\u0006\u0004\b2\u0010\u0019J\u001f\u00103\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b3\u0010\u0007J\u0017\u00104\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0016H\u0016¢\u0006\u0004\b4\u0010\u0019J\u0017\u00106\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b6\u00107R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010C\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010>R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010>R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010LR\u0016\u0010Y\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010LR\u0016\u0010[\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010>R\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010]R\u0016\u0010`\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010>R\u0016\u0010b\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010>R\u0016\u0010d\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010TR\u0016\u0010f\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010LR\u0016\u0010h\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010>R\u0016\u0010j\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010LR\u0016\u0010l\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010LR\u0016\u0010n\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010>R\u0016\u0010p\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010>R\u001e\u0010s\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006z"}, d2 = {"Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "", "description", "setStatusDescription", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "title", "setTitle", "price", "setCurrentPrice", "", "isShowDelivery", "setDeliveryVisible", "(Z)V", "value", "setPreviousPrice", "shopName", "setShopName", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "location", "setLocation", "", "time", "setDate", "(Ljava/lang/Long;)V", VKAttachments.TYPE_NOTE, "setNote", "active", "setActive", "setOnFavoriteButtonClickListener", "setClickListener", "clickListener", "setMoreClickListener", "isVisible", "setMoreButtonVisible", "isFavorite", "setFavorite", "setViewedBadgeVisible", "setSimilarClickListener", "setSimilarButtonVisible", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", "z", "Landroid/widget/TextView;", "shopNameView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "locationView", "C", "dateView", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "K", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "formatter", "u", "titleView", "Landroid/view/View;", "w", "Landroid/view/View;", "priceContainer", "Lcom/google/android/material/internal/CheckableImageButton;", ExifInterface.LONGITUDE_EAST, "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", "", "M", "F", "inactiveAlpha", "J", "additionalFieldsContainer", "H", "viewedItemsBadge", "B", "addressView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "moreBtnView", "I", "similarBtnView", VKApiConst.VERSION, "currentPriceView", "L", "activeAlpha", "G", "fieldsContainer", "t", "statusDescriptionView", "O", "view", "y", "delivery", "x", "previousPriceView", "D", "noteView", "N", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertItemViewImpl extends BaseViewHolder implements FavoriteAdvertItemView {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final CheckableImageButton E;
    public final ImageView F;
    public final View G;
    public final View H;
    public final TextView I;
    public final View J;
    public final DateTimeFormatter K;
    public final float L;
    public final float M;
    public Function0<Unit> N;
    public final View O;
    public final SimpleDraweeView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final View w;
    public final TextView x;
    public final View y;
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

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavoriteAdvertItemViewImpl(@NotNull View view, @NotNull TimeSource timeSource, @NotNull Locale locale) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.O = view;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.statusDescription);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.price_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.w = findViewById5;
        View findViewById6 = view.findViewById(R.id.discount);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.delivery);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.y = findViewById7;
        View findViewById8 = view.findViewById(R.id.shop_name);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.z = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.A = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.address);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.B = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.date);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.C = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        this.E = (CheckableImageButton) findViewById12;
        View findViewById13 = view.findViewById(R.id.btn_more);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type android.widget.ImageView");
        this.F = (ImageView) findViewById13;
        View findViewById14 = view.findViewById(R.id.fields_container);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type android.view.View");
        this.G = findViewById14;
        View findViewById15 = view.findViewById(R.id.card_info_badge);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(fav_R.id.card_info_badge)");
        this.H = findViewById15;
        View findViewById16 = view.findViewById(R.id.btn_similar);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type android.widget.TextView");
        this.I = (TextView) findViewById16;
        View findViewById17 = view.findViewById(R.id.additional_fields_container);
        Objects.requireNonNull(findViewById17, "null cannot be cast to non-null type android.view.View");
        this.J = findViewById17;
        ((ViewStub) view.findViewById(com.avito.android.ui_components.R.id.advert_note_stub)).inflate();
        View findViewById18 = view.findViewById(com.avito.android.ui_components.R.id.note);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "view.findViewById(ui_R.id.note)");
        this.D = (TextView) findViewById18;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.context.resources");
        this.K = new DateTimeFormatterImpl(timeSource, new DateTimeFormatterResourceProviderImpl(resources), locale, 1);
        TypedValue typedValue = new TypedValue();
        view.getResources().getValue(com.avito.android.ui_components.R.dimen.inactive_alpha_old, typedValue, true);
        this.M = typedValue.getFloat();
        view.getResources().getValue(com.avito.android.ui_components.R.dimen.active_alpha, typedValue, true);
        this.L = typedValue.getFloat();
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return picture.getUri(this.s);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.N;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setActive(boolean z2) {
        if (z2) {
            this.s.setAlpha(this.L);
            this.u.setAlpha(this.L);
            this.w.setAlpha(this.L);
            this.x.setAlpha(this.L);
            this.J.setAlpha(this.L);
            this.C.setAlpha(this.L);
            this.D.setAlpha(this.L);
        } else {
            this.s.setAlpha(this.M);
            this.u.setAlpha(this.M);
            this.w.setAlpha(this.M);
            this.x.setAlpha(this.M);
            this.J.setAlpha(this.M);
            this.C.setAlpha(this.M);
            this.D.setAlpha(this.M);
        }
        this.I.setAlpha(this.L);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setAddress(@Nullable String str) {
        TextViews.bindText$default(this.B, str, false, 2, null);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.O.setOnClickListener(null);
        } else {
            this.O.setOnClickListener(new a(function0));
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setCurrentPrice(@Nullable String str) {
        TextViews.bindText$default(this.v, str, false, 2, null);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setDate(@Nullable Long l) {
        TextViews.bindText$default(this.C, this.K.format(l, TimeUnit.SECONDS), false, 2, null);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setDeliveryVisible(boolean z2) {
        Views.setVisible(this.y, z2);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setFavorite(boolean z2) {
        this.E.setChecked(z2);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setLocation(@Nullable String str) {
        TextViews.bindText$default(this.A, str, false, 2, null);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setMoreButtonVisible(boolean z2) {
        if (z2) {
            Views.show(this.F);
        } else {
            Views.hide(this.F);
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setMoreClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.F.setOnClickListener(null);
        } else {
            this.F.setOnClickListener(new b(function0));
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setNote(@Nullable String str) {
        TextViews.bindText$default(this.D, str, false, 2, null);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.E.setOnClickListener(null);
        } else {
            this.E.setOnClickListener(new c(function0));
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.s, picture);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setPreviousPrice(@Nullable String str) {
        if (str == null || str.length() == 0) {
            this.x.setText("");
            Views.hide(this.x);
            TextViews.setCompoundDrawables$default(this.v, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 11, (Object) null);
            return;
        }
        TextViews.setCompoundDrawables$default(this.v, 0, 0, com.avito.android.ui_components.R.drawable.markdown, 0, 11, (Object) null);
        TextView textView = this.x;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StrikethroughSpan(), 0, str.length(), 33);
        Unit unit = Unit.INSTANCE;
        textView.setText(spannableString);
        Views.show(this.x);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setShopName(@Nullable String str) {
        TextViews.bindText$default(this.z, str, false, 2, null);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setSimilarButtonVisible(boolean z2) {
        Views.setVisible(this.I, z2);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setSimilarClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.I.setOnClickListener(null);
        } else {
            this.I.setOnClickListener(new d(function0));
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setStatusDescription(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.N = function0;
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setViewedBadgeVisible(boolean z2) {
        Views.setVisible(this.H, z2);
    }
}
