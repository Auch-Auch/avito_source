package com.avito.android.contact_access;

import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Profile;
import com.avito.android.social.incomplete.IncompleteSocialInteractor;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/contact_access/IncompleteSocialInteractorImpl;", "Lcom/avito/android/social/incomplete/IncompleteSocialInteractor;", "Lio/reactivex/Observable;", "", "checkIncompleteProfile", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "profileApi", "<init>", "(Lcom/avito/android/remote/ProfileApi;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class IncompleteSocialInteractorImpl implements IncompleteSocialInteractor {
    public final ProfileApi a;

    public static final class a<T, R> implements Function<Profile, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(Profile profile) {
            Profile profile2 = profile;
            Intrinsics.checkNotNullParameter(profile2, "it");
            return Boolean.valueOf(profile2.isIncomplete());
        }
    }

    @Inject
    public IncompleteSocialInteractorImpl(@NotNull ProfileApi profileApi) {
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        this.a = profileApi;
    }

    @Override // com.avito.android.social.incomplete.IncompleteSocialInteractor
    @NotNull
    public Observable<Boolean> checkIncompleteProfile() {
        Observable<Boolean> map = InteropKt.toV2(this.a.getProfile()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "profileApi.getProfile().…map { it.isIncomplete() }");
        return map;
    }
}
