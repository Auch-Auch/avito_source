package com.avito.android.publish.add_advert;

import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.util.Collections;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.loading_state.LoadingProgress;
import com.avito.android.util.loading_state.SimpleMessageError;
import com.avito.android.util.loading_state.TypedError;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
import ru.avito.component.floating_add_advert.AdvertShortcut;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/avito/android/publish/add_advert/AddAdvertInteractorImpl;", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/loading_state/LoadingProgress;", "", "Lru/avito/component/floating_add_advert/AdvertShortcut;", "getAdvertShortcutsLoadingProgress", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "getAdvertShortcuts", "()Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Maybe;", AuthSource.SEND_ABUSE, "()Lio/reactivex/rxjava3/core/Maybe;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Single;", "apiSource", "Ljava/util/List;", "cache", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/remote/PublishApi;", "publishApi", "<init>", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AddAdvertInteractorImpl implements AddAdvertInteractor {
    public List<AdvertShortcut> a;
    public final Single<List<AdvertShortcut>> b;
    public final SchedulersFactory3 c;
    public final TypedErrorThrowableConverter d;

    public static final class a<T, R> implements Function<WizardParameter, List<? extends AdvertShortcut>> {
        public final /* synthetic */ AddAdvertInteractorImpl a;

        public a(AddAdvertInteractorImpl addAdvertInteractorImpl) {
            this.a = addAdvertInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends AdvertShortcut> apply(WizardParameter wizardParameter) {
            List<WizardParameter> children = wizardParameter.getChildren();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(children, 10));
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                arrayList.add(AddAdvertInteractorImpl.access$toAdvertShortcut(this.a, it.next()));
            }
            return arrayList;
        }
    }

    public static final class b<T> implements Consumer<List<? extends AdvertShortcut>> {
        public final /* synthetic */ AddAdvertInteractorImpl a;

        public b(AddAdvertInteractorImpl addAdvertInteractorImpl) {
            this.a = addAdvertInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends AdvertShortcut> list) {
            this.a.a = list;
        }
    }

    public static final class c<T, R> implements Function<List<? extends AdvertShortcut>, LoadingProgress<? super List<? extends AdvertShortcut>>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingProgress<? super List<? extends AdvertShortcut>> apply(List<? extends AdvertShortcut> list) {
            return new LoadingProgress.Loaded(list);
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingProgress<? super List<? extends AdvertShortcut>>> {
        public final /* synthetic */ AddAdvertInteractorImpl a;

        public d(AddAdvertInteractorImpl addAdvertInteractorImpl) {
            this.a = addAdvertInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingProgress<? super List<? extends AdvertShortcut>> apply(Throwable th) {
            Throwable th2 = th;
            AddAdvertInteractorImpl addAdvertInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingProgress.Error(AddAdvertInteractorImpl.access$toTypedError(addAdvertInteractorImpl, th2));
        }
    }

    public AddAdvertInteractorImpl(@NotNull PublishApi publishApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "typedErrorThrowableConverter");
        this.c = schedulersFactory3;
        this.d = typedErrorThrowableConverter;
        Single<R> flatMap = publishApi.getRootWizardParameters().flatMap(AddAdvertInteractorImpl$$special$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Single<R> doOnSuccess = flatMap.map(new a(this)).doOnSuccess(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "publishApi\n        .getR…oOnSuccess { cache = it }");
        this.b = doOnSuccess;
    }

    public static final AdvertShortcut access$toAdvertShortcut(AddAdvertInteractorImpl addAdvertInteractorImpl, WizardParameter wizardParameter) {
        String str;
        Objects.requireNonNull(addAdvertInteractorImpl);
        AdvertPublicationLink advertPublicationLink = new AdvertPublicationLink(wizardParameter.getNavigation());
        String title = wizardParameter.getTitle();
        Integer categoryId = wizardParameter.getNavigation().getCategoryId();
        if (categoryId != null && categoryId.intValue() == 1) {
            str = "transport";
        } else if (categoryId != null && categoryId.intValue() == 4) {
            str = "nedvizhimost";
        } else if (categoryId != null && categoryId.intValue() == 110) {
            str = "rabota";
        } else {
            str = (categoryId != null && categoryId.intValue() == 113) ? "uslugi" : "general";
        }
        return new AdvertShortcut(title, str, advertPublicationLink, wizardParameter.getNavigation());
    }

    public static final TypedError access$toTypedError(AddAdvertInteractorImpl addAdvertInteractorImpl, Throwable th) {
        com.avito.android.remote.error.TypedError convert = addAdvertInteractorImpl.d.convert(th);
        if (convert instanceof ErrorWithMessage.NetworkError) {
            return new SimpleMessageError(((ErrorWithMessage.NetworkError) convert).getMessage());
        }
        if (convert instanceof ErrorWithMessage.SimpleMessageError) {
            return new SimpleMessageError(((ErrorWithMessage.SimpleMessageError) convert).getMessage());
        }
        return new TypedError();
    }

    public final Maybe<List<AdvertShortcut>> a() {
        if (Collections.isNullOrEmpty(this.a)) {
            Maybe<List<AdvertShortcut>> empty = Maybe.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "Maybe.empty()");
            return empty;
        }
        Maybe<List<AdvertShortcut>> just = Maybe.just(this.a);
        Intrinsics.checkNotNullExpressionValue(just, "Maybe.just(cache)");
        return just;
    }

    @Override // ru.avito.component.floating_add_advert.AddAdvertInteractor
    @NotNull
    public Single<List<AdvertShortcut>> getAdvertShortcuts() {
        return a2.b.a.a.a.e2(this.c, a().switchIfEmpty(this.b), "getCached()\n            …n(schedulersFactory.io())");
    }

    @Override // ru.avito.component.floating_add_advert.AddAdvertInteractor
    @NotNull
    public Observable<LoadingProgress<List<AdvertShortcut>>> getAdvertShortcutsLoadingProgress() {
        return a2.b.a.a.a.a2(this.c, a().switchIfEmpty(this.b).toObservable().map(c.a).startWith(Observable.just(new LoadingProgress.Loading())).onErrorReturn(new d(this)), "getCached()\n        .swi…n(schedulersFactory.io())");
    }
}
