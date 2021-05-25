package com.avito.android.user_favorites;

import android.os.Bundle;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "startTab", "", "subscriptionId", "Lcom/avito/android/user_favorites/UserFavoritesFragment;", "createUserFavoritesFragment", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/avito/android/user_favorites/UserFavoritesFragment;", "user-favorites_release"}, k = 2, mv = {1, 4, 2})
public final class UserFavoritesFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Integer num, String str) {
            super(1);
            this.a = num;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            Integer num = this.a;
            if (num != null) {
                bundle2.putInt("start_tab", num.intValue());
            }
            String str = this.b;
            if (str != null) {
                bundle2.putString("subscription_id", str);
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final UserFavoritesFragment createUserFavoritesFragment(@Nullable Integer num, @Nullable String str) {
        return (UserFavoritesFragment) FragmentsKt.arguments(new UserFavoritesFragment(), 1, new a(num, str));
    }

    public static /* synthetic */ UserFavoritesFragment createUserFavoritesFragment$default(Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return createUserFavoritesFragment(num, str);
    }
}
