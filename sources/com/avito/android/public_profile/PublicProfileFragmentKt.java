package com.avito.android.public_profile;

import android.os.Bundle;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/public_profile/PublicProfileArguments;", "arguments", "Lcom/avito/android/public_profile/PublicProfileFragment;", "createPublicProfileFragment", "(Lcom/avito/android/public_profile/PublicProfileArguments;)Lcom/avito/android/public_profile/PublicProfileFragment;", "public-profile_release"}, k = 2, mv = {1, 4, 2})
public final class PublicProfileFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ PublicProfileArguments a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PublicProfileArguments publicProfileArguments) {
            super(1);
            this.a = publicProfileArguments;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putParcelable("arguments", this.a);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final PublicProfileFragment createPublicProfileFragment(@NotNull PublicProfileArguments publicProfileArguments) {
        Intrinsics.checkNotNullParameter(publicProfileArguments, "arguments");
        return (PublicProfileFragment) FragmentsKt.arguments$default(new PublicProfileFragment(), 0, new a(publicProfileArguments), 1, null);
    }
}
