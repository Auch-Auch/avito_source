package com.avito.android.profile.cards;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.CardItemView;
import com.avito.android.remote.model.Avatar;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\tJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0013\u0010\fJ#\u0010\u0017\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u0005H&¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001d\u001a\u00020\u0005H&¢\u0006\u0004\b\u001d\u0010\tJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001f\u0010\fJ\u0019\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b!\u0010\fJ\u0019\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b#\u0010\fJ\u0019\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b%\u0010\fJ\u0019\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b'\u0010\fJ\u001d\u0010*\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050(H&¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050(H&¢\u0006\u0004\b,\u0010+J\u001d\u0010-\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050(H&¢\u0006\u0004\b-\u0010+¨\u0006."}, d2 = {"Lcom/avito/android/profile/cards/InfoCardItemView;", "Lcom/avito/android/profile/cards/CardItemView;", "", "title", "description", "", "showAvatarAlert", "(Ljava/lang/String;Ljava/lang/String;)V", "hideAvatarAlert", "()V", "info", "showAvatarInfo", "(Ljava/lang/String;)V", "hideAvatarInfo", "Lcom/avito/android/remote/model/Avatar;", "avatar", "showAvatar", "(Lcom/avito/android/remote/model/Avatar;)V", "name", "setName", "", "score", "text", "setRating", "(Ljava/lang/Float;Ljava/lang/String;)V", "contactId", "showDescription", "hideDescription", "setProfileIncomplete", "setProfileNormal", "email", "setEmail", "manager", "setManager", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "website", "setWebsite", "registered", "setRegistered", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "setAvatarClickListener", "setRatingClickListener", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface InfoCardItemView extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull InfoCardItemView infoCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(infoCardItemView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull InfoCardItemView infoCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(infoCardItemView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull InfoCardItemView infoCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(infoCardItemView, view, i);
        }

        public static void onUnbind(@NotNull InfoCardItemView infoCardItemView) {
            CardItemView.DefaultImpls.onUnbind(infoCardItemView);
        }

        public static void setIcon(@NotNull InfoCardItemView infoCardItemView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(infoCardItemView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull InfoCardItemView infoCardItemView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(infoCardItemView, view);
        }
    }

    void hideAvatarAlert();

    void hideAvatarInfo();

    void hideDescription();

    void setActionListener(@NotNull Function0<Unit> function0);

    void setAddress(@Nullable String str);

    void setAvatarClickListener(@NotNull Function0<Unit> function0);

    void setEmail(@Nullable String str);

    void setManager(@Nullable String str);

    void setName(@Nullable String str);

    void setProfileIncomplete();

    void setProfileNormal();

    void setRating(@Nullable Float f, @Nullable String str);

    void setRatingClickListener(@NotNull Function0<Unit> function0);

    void setRegistered(@Nullable String str);

    void setWebsite(@Nullable String str);

    void showAvatar(@Nullable Avatar avatar);

    void showAvatarAlert(@NotNull String str, @NotNull String str2);

    void showAvatarInfo(@NotNull String str);

    void showDescription(@NotNull String str, @Nullable String str2);
}
