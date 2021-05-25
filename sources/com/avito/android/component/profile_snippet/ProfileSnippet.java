package com.avito.android.component.profile_snippet;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\u0006J%\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/component/profile_snippet/ProfileSnippet;", "", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "text", "setVerification", ErrorBundle.SUMMARY_ENTRY, "setSummary", "setContact", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "score", "", "enableFloatingRating", "setRating", "(Ljava/lang/Float;ZLjava/lang/CharSequence;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "userIconType", "setAvatar", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "show", "()V", "hide", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileSnippet {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setContact$default(ProfileSnippet profileSnippet, CharSequence charSequence, CharSequence charSequence2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    charSequence2 = null;
                }
                profileSnippet.setContact(charSequence, charSequence2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContact");
        }

        public static /* synthetic */ void setRating$default(ProfileSnippet profileSnippet, Float f, boolean z, CharSequence charSequence, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    charSequence = null;
                }
                profileSnippet.setRating(f, z, charSequence);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRating");
        }
    }

    void hide();

    void setAvatar(@Nullable Picture picture, @NotNull UserIconType userIconType);

    void setContact(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2);

    void setOnClickListener(@Nullable Function0<Unit> function0);

    void setRating(@Nullable Float f, boolean z, @Nullable CharSequence charSequence);

    void setSubtitle(@Nullable CharSequence charSequence);

    void setSummary(@Nullable CharSequence charSequence);

    void setTitle(@Nullable CharSequence charSequence);

    void setVerification(@Nullable CharSequence charSequence);

    void show();
}
