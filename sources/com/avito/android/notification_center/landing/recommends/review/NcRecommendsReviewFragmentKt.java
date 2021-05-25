package com.avito.android.notification_center.landing.recommends.review;

import android.os.Bundle;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "id", "hint", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewFragment;", "createNcRecommendsReviewFragment", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewFragment;", "notification-center_release"}, k = 2, mv = {1, 4, 2})
public final class NcRecommendsReviewFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putString("key_id", this.a);
            bundle2.putString("key_hint", this.b);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final NcRecommendsReviewFragment createNcRecommendsReviewFragment(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "hint");
        return (NcRecommendsReviewFragment) FragmentsKt.arguments$default(new NcRecommendsReviewFragment(), 0, new a(str, str2), 1, null);
    }
}
