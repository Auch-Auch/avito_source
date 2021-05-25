package com.avito.android.user_adverts.tab_screens;

import android.net.Uri;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.ShortcutBanner;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UserAdvertsResult;
import com.avito.android.user_adverts.di.IsFirstTab;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.util.Collections;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedSingleKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\b\u0001\u0010)\u001a\u00020&\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b+\u0010,J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n0\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n0\t2\u0006\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00020\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractorImpl;", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "", "bannerId", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "closeUserAdvertsBanner", "(Ljava/lang/String;)Lio/reactivex/Observable;", "shortcut", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Lcom/avito/android/remote/model/SerpElement;", "Landroid/net/Uri;", "loadUserAdverts", "(Ljava/lang/String;)Lio/reactivex/Single;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/Single;", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Ljava/util/HashSet;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/util/HashSet;", "closedBanners", "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "api", "", "d", "Z", "isFirstTab", "state", "<init>", "(Lcom/avito/android/user_adverts/remote/UserAdvertsApi;Lcom/avito/android/util/SchedulersFactory;ZLcom/avito/android/Features;Landroid/os/Bundle;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsListInteractorImpl implements UserAdvertsListInteractor {
    public final HashSet<String> a;
    public final UserAdvertsApi b;
    public final SchedulersFactory c;
    public final boolean d;
    public final Features e;

    public static final class a<T, R> implements Function<UserAdvertsResult, Pair<? extends List<? extends SerpElement>, ? extends Uri>> {
        public final /* synthetic */ UserAdvertsListInteractorImpl a;

        public a(UserAdvertsListInteractorImpl userAdvertsListInteractorImpl) {
            this.a = userAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends List<? extends SerpElement>, ? extends Uri> apply(UserAdvertsResult userAdvertsResult) {
            UserAdvertsResult userAdvertsResult2 = userAdvertsResult;
            Intrinsics.checkNotNullParameter(userAdvertsResult2, "it");
            return TuplesKt.to(UserAdvertsListInteractorImpl.access$filterClosed(this.a, userAdvertsResult2.getList()), userAdvertsResult2.getNextPage());
        }
    }

    public static final class b<T, R> implements Function<UserAdvertsResult, Pair<? extends List<? extends SerpElement>, ? extends Uri>> {
        public final /* synthetic */ UserAdvertsListInteractorImpl a;

        public b(UserAdvertsListInteractorImpl userAdvertsListInteractorImpl) {
            this.a = userAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends List<? extends SerpElement>, ? extends Uri> apply(UserAdvertsResult userAdvertsResult) {
            UserAdvertsResult userAdvertsResult2 = userAdvertsResult;
            Intrinsics.checkNotNullParameter(userAdvertsResult2, "it");
            return TuplesKt.to(UserAdvertsListInteractorImpl.access$filterClosed(this.a, userAdvertsResult2.getList()), userAdvertsResult2.getNextPage());
        }
    }

    @Inject
    public UserAdvertsListInteractorImpl(@NotNull UserAdvertsApi userAdvertsApi, @NotNull SchedulersFactory schedulersFactory, @IsFirstTab boolean z, @NotNull Features features, @Nullable Bundle bundle) {
        Collection emptyList;
        Intrinsics.checkNotNullParameter(userAdvertsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = userAdvertsApi;
        this.c = schedulersFactory;
        this.d = z;
        this.e = features;
        this.a = new HashSet<>((bundle == null || (emptyList = bundle.getStringArrayList("key_elements")) == null) ? CollectionsKt__CollectionsKt.emptyList() : emptyList);
    }

    public static final List access$filterClosed(UserAdvertsListInteractorImpl userAdvertsListInteractorImpl, List list) {
        Objects.requireNonNull(userAdvertsListInteractorImpl);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            SerpElement serpElement = (SerpElement) obj;
            if (!((serpElement instanceof ShortcutBanner) && userAdvertsListInteractorImpl.a.contains(((ShortcutBanner) serpElement).getId()))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractor
    @NotNull
    public Observable<SuccessResult> closeUserAdvertsBanner(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "bannerId");
        this.a.add(str);
        return a2.b.a.a.a.S1(this.c, InteropKt.toV2(this.b.closeInfoBanner(str)), "api.closeInfoBanner(bann…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractor
    @NotNull
    public Single<Pair<List<SerpElement>, Uri>> loadUserAdverts(@NotNull String str) {
        io.reactivex.rxjava3.core.Single<TypedResult<UserAdvertsResult>> single;
        Intrinsics.checkNotNullParameter(str, "shortcut");
        String str2 = this.d ? "1" : null;
        if (this.e.getIdentityVerification().invoke().booleanValue()) {
            single = this.b.getUserAdverts(str, str2);
        } else {
            single = this.b.getUserAdvertsV11(str, str2);
        }
        return a2.b.a.a.a.V1(this.c, TypedSingleKt.toTyped(InteropKt.toV2(single)).map(new a(this)), "if (features.identityVer…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractor
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("key_elements", Collections.asArrayList(this.a));
        return bundle;
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractor
    @NotNull
    public Single<Pair<List<SerpElement>, Uri>> loadUserAdverts(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        String uri2 = uri.buildUpon().appendQueryParameter("isRedesign", "1").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.buildUpon()\n   …)\n            .toString()");
        return a2.b.a.a.a.V1(this.c, TypedSingleKt.toTyped(InteropKt.toV2(this.b.getNextUserAdverts(uri2))).map(new b(this)), "api.getNextUserAdverts(n…scribeOn(schedulers.io())");
    }
}
