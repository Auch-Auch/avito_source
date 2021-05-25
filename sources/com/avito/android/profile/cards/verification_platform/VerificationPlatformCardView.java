package com.avito.android.profile.cards.verification_platform;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.CardItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardView;", "Lcom/avito/android/profile/cards/CardItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "removeAllStatuses", "()V", "message", "", "iconRes", "iconTintRes", "addStatusInfo", "(Ljava/lang/String;II)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface VerificationPlatformCardView extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull VerificationPlatformCardView verificationPlatformCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(verificationPlatformCardView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull VerificationPlatformCardView verificationPlatformCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(verificationPlatformCardView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull VerificationPlatformCardView verificationPlatformCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(verificationPlatformCardView, view, i);
        }

        public static void onUnbind(@NotNull VerificationPlatformCardView verificationPlatformCardView) {
            CardItemView.DefaultImpls.onUnbind(verificationPlatformCardView);
        }

        public static void setIcon(@NotNull VerificationPlatformCardView verificationPlatformCardView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(verificationPlatformCardView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull VerificationPlatformCardView verificationPlatformCardView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(verificationPlatformCardView, view);
        }
    }

    void addStatusInfo(@NotNull String str, @AttrRes int i, @AttrRes int i2);

    void removeAllStatuses();

    void setAction(@NotNull String str, @NotNull Function0<Unit> function0);

    void setTitle(@NotNull String str);
}
