package com.avito.android.publish;

import com.avito.android.publish.analytics.PublishContactsTracker;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Profile;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish/ProfileSourceInteractorImpl;", "Lcom/avito/android/publish/ProfileSourceInteractor;", "Lcom/avito/android/remote/model/Profile;", "profile", "", "notifyProfileChanged", "(Lcom/avito/android/remote/model/Profile;)V", "Lio/reactivex/Single;", "getProfile", "()Lio/reactivex/Single;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Profile;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/publish/analytics/PublishContactsTracker;", "c", "Lcom/avito/android/publish/analytics/PublishContactsTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/publish/analytics/PublishContactsTracker;Lcom/avito/android/util/SchedulersFactory;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileSourceInteractorImpl implements ProfileSourceInteractor {
    public volatile Profile a;
    public final ProfileApi b;
    public final PublishContactsTracker c;
    public final SchedulersFactory d;

    public static final class a<T> implements Consumer<Profile> {
        public final /* synthetic */ ProfileSourceInteractorImpl a;

        public a(ProfileSourceInteractorImpl profileSourceInteractorImpl) {
            this.a = profileSourceInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Profile profile) {
            this.a.c.trackProfileLoaded();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileSourceInteractorImpl a;

        public b(ProfileSourceInteractorImpl profileSourceInteractorImpl) {
            this.a = profileSourceInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.c.trackProfileLoadError();
        }
    }

    public static final class c<T> implements Consumer<Profile> {
        public final /* synthetic */ ProfileSourceInteractorImpl a;

        public c(ProfileSourceInteractorImpl profileSourceInteractorImpl) {
            this.a = profileSourceInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Profile profile) {
            Profile profile2 = profile;
            ProfileSourceInteractorImpl profileSourceInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(profile2, "it");
            profileSourceInteractorImpl.notifyProfileChanged(profile2);
        }
    }

    public ProfileSourceInteractorImpl(@NotNull ProfileApi profileApi, @NotNull PublishContactsTracker publishContactsTracker, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(publishContactsTracker, "tracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = profileApi;
        this.c = publishContactsTracker;
        this.d = schedulersFactory;
    }

    @Override // com.avito.android.publish.ProfileSourceInteractor
    @NotNull
    public Single<Profile> getProfile() {
        this.c.startProfileServerLoading();
        Profile profile = this.a;
        if (profile != null) {
            Single<Profile> just = Single.just(profile);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(cachedProfile)");
            return just;
        }
        Single<Profile> doOnSuccess = InteropKt.toV2(this.b.getProfile()).firstOrError().doOnSuccess(new a(this)).doOnError(new b(this)).subscribeOn(this.d.io()).doOnSuccess(new c(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "profileApi.getProfile().…otifyProfileChanged(it) }");
        return doOnSuccess;
    }

    @Override // com.avito.android.publish.ProfileSourceInteractor
    public void notifyProfileChanged(@NotNull Profile profile) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        this.a = profile;
    }
}
