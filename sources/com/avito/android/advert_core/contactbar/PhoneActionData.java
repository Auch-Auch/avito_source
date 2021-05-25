package com.avito.android.advert_core.contactbar;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/contactbar/PhoneActionData;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Success", "Lcom/avito/android/advert_core/contactbar/PhoneActionData$Success;", "Lcom/avito/android/advert_core/contactbar/PhoneActionData$Failed;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class PhoneActionData {
    @NotNull
    public final DeepLink a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/advert_core/contactbar/PhoneActionData$Failed;", "Lcom/avito/android/advert_core/contactbar/PhoneActionData;", "Lcom/avito/android/deep_linking/links/DeepLink;", "action", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failed extends PhoneActionData {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(@NotNull DeepLink deepLink) {
            super(deepLink, null);
            Intrinsics.checkNotNullParameter(deepLink, "action");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/advert_core/contactbar/PhoneActionData$Success;", "Lcom/avito/android/advert_core/contactbar/PhoneActionData;", "Lcom/avito/android/remote/model/Action;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "<init>", "(Lcom/avito/android/remote/model/Action;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success extends PhoneActionData {
        @NotNull
        public final Action b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull Action action) {
            super(action.getDeepLink(), null);
            Intrinsics.checkNotNullParameter(action, "action");
            this.b = action;
        }

        @NotNull
        public final Action getAction() {
            return this.b;
        }
    }

    public PhoneActionData(DeepLink deepLink, j jVar) {
        this.a = deepLink;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.a;
    }
}
