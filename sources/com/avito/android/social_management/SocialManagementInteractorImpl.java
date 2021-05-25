package com.avito.android.social_management;

import com.avito.android.Features;
import com.avito.android.preferences.SocialNotificationStateStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Social;
import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.remote.model.social.SocialNotification;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b#\u0010$J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/social_management/SocialManagementInteractorImpl;", "Lcom/avito/android/social_management/SocialManagementInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/social_management/SocialManagementContent;", "loadSocialNetworks", "()Lio/reactivex/Observable;", "", "type", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "", "Lcom/avito/android/remote/model/social/SocialNetwork;", "addSocialNetwork", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "removeSocialNetwork", "(Ljava/lang/String;)Lio/reactivex/Observable;", "id", "Lio/reactivex/Completable;", "removeNotification", "(Ljava/lang/String;)Lio/reactivex/Completable;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/preferences/SocialNotificationStateStorage;", "d", "Lcom/avito/android/preferences/SocialNotificationStateStorage;", "socialNotificationStateStorage", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/preferences/SocialNotificationStateStorage;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class SocialManagementInteractorImpl implements SocialManagementInteractor {
    public final ProfileApi a;
    public final SchedulersFactory b;
    public final Features c;
    public final SocialNotificationStateStorage d;

    public static final class a<T, R> implements Function<Social, List<? extends SocialNetwork>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends SocialNetwork> apply(Social social) {
            Social social2 = social;
            Intrinsics.checkNotNullParameter(social2, "it");
            return social2.getSocialNetworks();
        }
    }

    public static final class b<T, R> implements Function<Social, SocialManagementContent> {
        public final /* synthetic */ SocialManagementInteractorImpl a;

        public b(SocialManagementInteractorImpl socialManagementInteractorImpl) {
            this.a = socialManagementInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SocialManagementContent apply(Social social) {
            Social social2 = social;
            Intrinsics.checkNotNullParameter(social2, "it");
            return SocialManagementInteractorImpl.access$filterNotifications(this.a, social2);
        }
    }

    public static final class c<V> implements Callable<Object> {
        public final /* synthetic */ SocialManagementInteractorImpl a;
        public final /* synthetic */ String b;

        public c(SocialManagementInteractorImpl socialManagementInteractorImpl, String str) {
            this.a = socialManagementInteractorImpl;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.d.closeNotification(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T, R> implements Function<Social, List<? extends SocialNetwork>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends SocialNetwork> apply(Social social) {
            Social social2 = social;
            Intrinsics.checkNotNullParameter(social2, "it");
            return social2.getSocialNetworks();
        }
    }

    @Inject
    public SocialManagementInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull SocialNotificationStateStorage socialNotificationStateStorage) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(socialNotificationStateStorage, "socialNotificationStateStorage");
        this.a = profileApi;
        this.b = schedulersFactory;
        this.c = features;
        this.d = socialNotificationStateStorage;
    }

    public static final SocialManagementContent access$filterNotifications(SocialManagementInteractorImpl socialManagementInteractorImpl, Social social) {
        if (!socialManagementInteractorImpl.c.getEsiaInProfile().invoke().booleanValue()) {
            return new SocialManagementContent(social.getSocialNetworks(), null, 2, null);
        }
        List<SocialNotification> notifications = social.getNotifications();
        if (notifications == null) {
            notifications = CollectionsKt__CollectionsKt.emptyList();
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) notifications);
        h.removeAll(mutableList, (Function1) new a2.a.a.y2.a(socialManagementInteractorImpl.d.getClosedNotificationIds()));
        return new SocialManagementContent(social.getSocialNetworks(), mutableList);
    }

    @Override // com.avito.android.social_management.SocialManagementInteractor
    @NotNull
    public Observable<List<SocialNetwork>> addSocialNetwork(@NotNull String str, @NotNull String str2) {
        Observable observable;
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        int hashCode = str.hashCode();
        if (hashCode != 3122758) {
            if (hashCode == 93029210 && str.equals("apple")) {
                observable = InteropKt.toV2(ProfileApi.DefaultImpls.addSocialNetwork$default(this.a, str, null, str2, 2, null));
                Observable<List<SocialNetwork>> map = TypedObservablesKt.toTyped(observable).subscribeOn(this.b.io()).map(a.a);
                Intrinsics.checkNotNullExpressionValue(map, "when (type) {\n          …map { it.socialNetworks }");
                return map;
            }
        } else if (str.equals("esia")) {
            observable = InteropKt.toV2(ProfileApi.DefaultImpls.addSocialNetwork$default(this.a, str, null, str2, 2, null));
            Observable<List<SocialNetwork>> map = TypedObservablesKt.toTyped(observable).subscribeOn(this.b.io()).map(a.a);
            Intrinsics.checkNotNullExpressionValue(map, "when (type) {\n          …map { it.socialNetworks }");
            return map;
        }
        observable = InteropKt.toV2(ProfileApi.DefaultImpls.addSocialNetwork$default(this.a, str, str2, null, 4, null));
        Observable<List<SocialNetwork>> map = TypedObservablesKt.toTyped(observable).subscribeOn(this.b.io()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "when (type) {\n          …map { it.socialNetworks }");
        return map;
    }

    @Override // com.avito.android.social_management.SocialManagementInteractor
    @NotNull
    public Observable<SocialManagementContent> loadSocialNetworks() {
        return a2.b.a.a.a.S1(this.b, TypedObservablesKt.toTyped(InteropKt.toV2(this.a.getSocialNetworks())).map(new b(this)), "api.getSocialNetworks().…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.social_management.SocialManagementInteractor
    @NotNull
    public Completable removeNotification(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Completable fromCallable = Completable.fromCallable(new c(this, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…otification(id)\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.social_management.SocialManagementInteractor
    @NotNull
    public Observable<List<SocialNetwork>> removeSocialNetwork(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Observable<List<SocialNetwork>> map = TypedObservablesKt.toTyped(InteropKt.toV2(this.a.removeSocialNetwork(str))).subscribeOn(this.b.io()).map(d.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.removeSocialNetwork(…map { it.socialNetworks }");
        return map;
    }
}
