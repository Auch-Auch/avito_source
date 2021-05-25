package com.avito.android.profile.cards.verification;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.CardItemView;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u000eH&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u001cJI\u0010\"\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 H&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/profile/cards/verification/VerificationCardView;", "Lcom/avito/android/profile/cards/CardItemView;", "", "visible", "", "setBannerVisibility", "(Z)V", "", "title", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", ErrorBundle.DETAIL_ENTRY, "setBannerTexts", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/avito/android/remote/model/text/AttributedText;)V", "", "iconRes", "iconTint", "setBannerIcon", "(II)V", "backgroundTint", "setBannerBackgroundTint", "(I)V", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "removeVerificationWays", "()V", "buttonText", "buttonStyleAttr", "buttonEnabled", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addVerificationWay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLkotlin/jvm/functions/Function0;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface VerificationCardView extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull VerificationCardView verificationCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(verificationCardView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull VerificationCardView verificationCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(verificationCardView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull VerificationCardView verificationCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(verificationCardView, view, i);
        }

        public static void onUnbind(@NotNull VerificationCardView verificationCardView) {
            CardItemView.DefaultImpls.onUnbind(verificationCardView);
        }

        public static void setIcon(@NotNull VerificationCardView verificationCardView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(verificationCardView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull VerificationCardView verificationCardView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(verificationCardView, view);
        }
    }

    void addVerificationWay(@Nullable String str, @Nullable String str2, @NotNull String str3, int i, boolean z, @NotNull Function0<Unit> function0);

    void removeVerificationWays();

    void setBannerBackgroundTint(@AttrRes int i);

    void setBannerIcon(@DrawableRes int i, @AttrRes int i2);

    void setBannerTexts(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable AttributedText attributedText);

    void setBannerVisibility(boolean z);

    void setDescription(@Nullable String str);

    void setTitle(@NotNull String str);
}
