package com.avito.android.profile.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.component.user_hat.UserHat;
import com.avito.android.component.user_hat.UserHatImpl;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.InfoCardItemView;
import com.avito.android.remote.model.Avatar;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010V\u001a\u000203¢\u0006\u0004\bW\u0010XJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\rJ#\u0010\u0018\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\nJ\u0019\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b \u0010\rJ\u0019\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\"\u0010\rJ\u0019\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b$\u0010\rJ\u0019\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b&\u0010\rJ\u0019\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b(\u0010\rJ\u001d\u0010+\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0016¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0016¢\u0006\u0004\b-\u0010,J\u001d\u0010.\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0016¢\u0006\u0004\b.\u0010,R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010B\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010D\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010=R\u001e\u0010I\u001a\n F*\u0004\u0018\u00010E0E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u00105R\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010=R\u0016\u0010S\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010=R\u0016\u0010U\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u00109¨\u0006Y"}, d2 = {"Lcom/avito/android/profile/cards/InfoCardItemViewHolder;", "Lcom/avito/android/profile/cards/InfoCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "description", "", "showAvatarAlert", "(Ljava/lang/String;Ljava/lang/String;)V", "hideAvatarAlert", "()V", "info", "showAvatarInfo", "(Ljava/lang/String;)V", "hideAvatarInfo", "Lcom/avito/android/remote/model/Avatar;", "avatar", "showAvatar", "(Lcom/avito/android/remote/model/Avatar;)V", "name", "setName", "", "score", "text", "setRating", "(Ljava/lang/Float;Ljava/lang/String;)V", "contactId", "showDescription", "hideDescription", "setProfileIncomplete", "setProfileNormal", "email", "setEmail", "manager", "setManager", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "website", "setWebsite", "registered", "setRegistered", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "setAvatarClickListener", "setRatingClickListener", "Lru/avito/component/button/Button;", ExifInterface.LONGITUDE_EAST, "Lru/avito/component/button/Button;", "actionButtonView", "Landroid/view/View;", "y", "Landroid/view/View;", "incompleteProfileNoteView", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "avatarTitleView", "Lcom/avito/android/component/info_block/InfoBlock;", "C", "Lcom/avito/android/component/info_block/InfoBlock;", "websiteView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "managerView", "w", "avatarInfoView", "z", "emailView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "t", "avatarAlertView", "Lcom/avito/android/component/user_hat/UserHat;", "x", "Lcom/avito/android/component/user_hat/UserHat;", "userHat", "D", "registeredView", "B", "addressView", VKApiConst.VERSION, "avatarDescriptionView", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class InfoCardItemViewHolder extends BaseViewHolder implements InfoCardItemView {
    public final InfoBlock A;
    public final InfoBlock B;
    public final InfoBlock C;
    public final InfoBlock D;
    public final Button E;
    public final Context s;
    public final View t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final UserHat x;
    public final View y;
    public final InfoBlock z;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoCardItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Context context = view.getContext();
        this.s = context;
        View findViewById = view.findViewById(R.id.avatar_alert);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById;
        View findViewById2 = view.findViewById(R.id.avatar_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.avatar_description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.avatar_info);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.user_hat);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.x = new UserHatImpl(findViewById5);
        View findViewById6 = view.findViewById(R.id.incomplete_profile_note);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.y = findViewById6;
        InfoBlock findInfoBlock = findInfoBlock(view, R.id.email);
        Drawable drawable = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_block_mail_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int i = com.avito.android.lib.design.R.attr.gray28;
        setIcon(findInfoBlock, Contexts.getTintedDrawable(drawable, Contexts.getColorByAttr(context, i)));
        Unit unit = Unit.INSTANCE;
        this.z = findInfoBlock;
        InfoBlock findInfoBlock2 = findInfoBlock(view, R.id.manager);
        Drawable drawable2 = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_block_user_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(findInfoBlock2, Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context, i)));
        this.A = findInfoBlock2;
        InfoBlock findInfoBlock3 = findInfoBlock(view, R.id.address);
        Drawable drawable3 = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_geo_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(findInfoBlock3, Contexts.getTintedDrawable(drawable3, Contexts.getColorByAttr(context, i)));
        this.B = findInfoBlock3;
        InfoBlock findInfoBlock4 = findInfoBlock(view, R.id.website);
        Drawable drawable4 = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_site_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(findInfoBlock4, Contexts.getTintedDrawable(drawable4, Contexts.getColorByAttr(context, i)));
        this.C = findInfoBlock4;
        InfoBlock findInfoBlock5 = findInfoBlock(view, R.id.registered);
        Drawable drawable5 = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_date_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(findInfoBlock5, Contexts.getTintedDrawable(drawable5, Contexts.getColorByAttr(context, i)));
        this.D = findInfoBlock5;
        Button findButton = findButton(view, R.id.edit_profile);
        findButton.setText(R.string.edit_profile);
        this.E = findButton;
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return InfoCardItemView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return InfoCardItemView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return InfoCardItemView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void hideAvatarAlert() {
        Views.hide(this.t);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void hideAvatarInfo() {
        Views.hide(this.w);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void hideDescription() {
        this.x.setSubtitle(null);
        this.x.setDescription(null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        InfoCardItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.E.setClickListener(new a(function0));
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setAddress(@Nullable String str) {
        this.B.bindText(str);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setAvatarClickListener(new b(function0));
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setEmail(@Nullable String str) {
        this.z.bindText(str);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        InfoCardItemView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setManager(@Nullable String str) {
        this.A.bindText(str);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setName(@Nullable String str) {
        this.x.setName(str);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setProfileIncomplete() {
        Views.show(this.y);
        this.E.setText(R.string.add_info);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setProfileNormal() {
        Views.hide(this.y);
        this.E.setText(R.string.edit_profile);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setRating(@Nullable Float f, @Nullable String str) {
        UserHat.DefaultImpls.setRating$default(this.x, f, true, str, 0, 8, null);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setRatingClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setRatingClickListener(new c(function0));
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setRegistered(@Nullable String str) {
        this.D.bindText(str);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void setWebsite(@Nullable String str) {
        this.C.bindText(str);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void showAvatar(@Nullable Avatar avatar) {
        Image image;
        this.x.setAvatar((avatar == null || (image = avatar.getImage()) == null) ? null : AvitoPictureKt.pictureOf$default(image, true, 0.0f, 0.0f, null, 28, null));
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void showAvatarAlert(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Views.show(this.t);
        TextViews.bindText$default(this.u, str, false, 2, null);
        TextViews.bindText$default(this.v, str2, false, 2, null);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void showAvatarInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "info");
        TextViews.bindText$default(this.w, str, false, 2, null);
    }

    @Override // com.avito.android.profile.cards.InfoCardItemView
    public void showDescription(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.x.setSubtitle(str);
        this.x.setDescription(str2);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return InfoCardItemView.DefaultImpls.withCardPaddings(this, view);
    }
}
