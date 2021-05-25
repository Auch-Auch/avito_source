package com.avito.android.authorization.select_profile;

import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.registration.ListProfilesResult;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.Observables;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/authorization/select_profile/SelectProfileInteractorImpl;", "Lcom/avito/android/authorization/select_profile/SelectProfileInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "loadItems", "()Lio/reactivex/rxjava3/core/Observable;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "hash", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/authorization/select_profile/SelectProfileResourceProvider;", "d", "Lcom/avito/android/authorization/select_profile/SelectProfileResourceProvider;", "resourceProvider", "Lcom/avito/android/remote/ProfileApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/ProfileApi;", "api", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/authorization/select_profile/SelectProfileResourceProvider;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectProfileInteractorImpl implements SelectProfileInteractor {
    public final String a;
    public final ProfileApi b;
    public final SchedulersFactory3 c;
    public final SelectProfileResourceProvider d;

    public static final class a<T, R> implements Function<ListProfilesResult, ObservableSource<? extends List<? extends RegisteredProfile>>> {
        public final /* synthetic */ SelectProfileInteractorImpl a;

        public a(SelectProfileInteractorImpl selectProfileInteractorImpl) {
            this.a = selectProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends List<? extends RegisteredProfile>> apply(ListProfilesResult listProfilesResult) {
            ListProfilesResult listProfilesResult2 = listProfilesResult;
            if (listProfilesResult2 instanceof ListProfilesResult.Ok) {
                Observable just = Observable.just(((ListProfilesResult.Ok) listProfilesResult2).getProfiles());
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (listProfilesResult2 instanceof ListProfilesResult.Failure) {
                return SelectProfileInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((ListProfilesResult.Failure) listProfilesResult2).getMessage()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T, R> implements Function<List<? extends RegisteredProfile>, List<? extends SelectProfileField>> {
        public final /* synthetic */ SelectProfileInteractorImpl a;

        public b(SelectProfileInteractorImpl selectProfileInteractorImpl) {
            this.a = selectProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends SelectProfileField> apply(List<? extends RegisteredProfile> list) {
            List<? extends RegisteredProfile> list2 = list;
            List listOf = d.listOf(new SelectProfileField.Text(Long.MAX_VALUE, this.a.d.getSelectProfileMessage()));
            Intrinsics.checkNotNullExpressionValue(list2, "profiles");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            int i = 0;
            for (T t : list2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new SelectProfileField.Profile((long) i, t));
                i = i2;
            }
            return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) arrayList), (Iterable) d.listOf(new SelectProfileField.CreateProfile(9223372036854775806L, this.a.d.getCreateProfileMessage())));
        }
    }

    @Inject
    public SelectProfileInteractorImpl(@NotNull String str, @NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SelectProfileResourceProvider selectProfileResourceProvider) {
        Intrinsics.checkNotNullParameter(str, "hash");
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(selectProfileResourceProvider, "resourceProvider");
        this.a = str;
        this.b = profileApi;
        this.c = schedulersFactory3;
        this.d = selectProfileResourceProvider;
    }

    public static final Observable access$toErrorObservable(SelectProfileInteractorImpl selectProfileInteractorImpl, TypedError typedError) {
        Objects.requireNonNull(selectProfileInteractorImpl);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileInteractor
    @NotNull
    public Observable<List<SelectProfileField>> loadItems() {
        Observable<TypedResult<ListProfilesResult>> subscribeOn = this.b.listProfiles(this.a).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.listProfiles(hash)\n …scribeOn(schedulers.io())");
        Observable<List<SelectProfileField>> map = TypedObservablesKt.toTyped(subscribeOn).flatMap(new a(this)).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "api.listProfiles(hash)\n …ProfileItem\n            }");
        return map;
    }
}
