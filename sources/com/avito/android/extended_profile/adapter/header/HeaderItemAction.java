package com.avito.android.extended_profile.adapter.header;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileRatingAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/HeaderItemAction;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "<init>", "()V", "AvatarClickAction", "RatingClickAction", "Lcom/avito/android/extended_profile/adapter/header/HeaderItemAction$AvatarClickAction;", "Lcom/avito/android/extended_profile/adapter/header/HeaderItemAction$RatingClickAction;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class HeaderItemAction implements ExtendedProfileItemAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/HeaderItemAction$AvatarClickAction;", "Lcom/avito/android/extended_profile/adapter/header/HeaderItemAction;", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class AvatarClickAction extends HeaderItemAction {
        @NotNull
        public static final AvatarClickAction INSTANCE = new AvatarClickAction();

        public AvatarClickAction() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/HeaderItemAction$RatingClickAction;", "Lcom/avito/android/extended_profile/adapter/header/HeaderItemAction;", "Lcom/avito/android/remote/model/ProfileRatingAction;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/ProfileRatingAction;", "getRatingAction", "()Lcom/avito/android/remote/model/ProfileRatingAction;", "ratingAction", "<init>", "(Lcom/avito/android/remote/model/ProfileRatingAction;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class RatingClickAction extends HeaderItemAction {
        @NotNull
        public final ProfileRatingAction a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RatingClickAction(@NotNull ProfileRatingAction profileRatingAction) {
            super(null);
            Intrinsics.checkNotNullParameter(profileRatingAction, "ratingAction");
            this.a = profileRatingAction;
        }

        @NotNull
        public final ProfileRatingAction getRatingAction() {
            return this.a;
        }
    }

    public HeaderItemAction() {
    }

    public HeaderItemAction(j jVar) {
    }
}
