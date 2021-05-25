package com.avito.android.notification_center.landing.recommends.review_list;

import android.os.Bundle;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "id", "", ContextActionHandler.MethodCall.REACTION, "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListFragment;", "createNcRecommendsReviewListFragment", "(Ljava/lang/String;I)Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListFragment;", "notification-center_release"}, k = 2, mv = {1, 4, 2})
public final class NcRecommendsReviewListFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, int i) {
            super(1);
            this.a = str;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putString("key_id", this.a);
            bundle2.putInt("key_reaction", this.b);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final NcRecommendsReviewListFragment createNcRecommendsReviewListFragment(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        return (NcRecommendsReviewListFragment) FragmentsKt.arguments$default(new NcRecommendsReviewListFragment(), 0, new a(str, i), 1, null);
    }
}
