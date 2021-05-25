package com.avito.android.stories;

import com.avito.android.remote.StoriesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.StoriesResponse;
import com.avito.android.remote.model.Story;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.preferences.Preferences;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.y;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b0\u00101J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\t*\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/stories/StoriesInteractorImpl;", "Lcom/avito/android/stories/StoriesInteractor;", "Lcom/avito/android/remote/model/Location;", "location", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/stories/StoriesItem;", "loadStories", "(Lcom/avito/android/remote/model/Location;)Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/Story;", "stories", "", "updateStoriesViewedStatus", "(Ljava/util/List;)V", "", "id", "markStoryViewed", "(I)V", "", "isStoryViewed", "(I)Z", "resetLastUpdatedTimestamp", "()V", "", "", AuthSource.BOOKING_ORDER, "()Ljava/util/Set;", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/util/List;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/server_time/TimeSource;", "e", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/remote/StoriesApi;", "Lcom/avito/android/remote/StoriesApi;", "storiesApi", "<init>", "(Lcom/avito/android/remote/StoriesApi;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/server_time/TimeSource;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesInteractorImpl implements StoriesInteractor {
    public final StoriesApi a;
    public final Preferences b;
    public final TypedErrorThrowableConverter c;
    public final SchedulersFactory3 d;
    public final TimeSource e;

    public static final class a<T, R> implements Function<TypedResult<StoriesResponse>, ObservableSource<? extends StoriesResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends StoriesResponse> apply(TypedResult<StoriesResponse> typedResult) {
            TypedResult<StoriesResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                Observable just = Observable.just(((TypedResult.OfResult) typedResult2).getResult());
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                ErrorResult error = ofError.getError();
                if (error instanceof ErrorResult.NetworkIOError) {
                    return Observable.error(new IOException(ofError.getError().getMessage()));
                }
                if (error instanceof ErrorResult.Unauthorized) {
                    return Observable.error(new UnauthorizedException(new Throwable(ofError.getError().getMessage())));
                }
                return Observable.error(new RuntimeException(ofError.getError().getMessage()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T, R> implements Function<StoriesResponse, LoadingState<? super StoriesItem>> {
        public final /* synthetic */ StoriesInteractorImpl a;

        public b(StoriesInteractorImpl storiesInteractorImpl) {
            this.a = storiesInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super StoriesItem> apply(StoriesResponse storiesResponse) {
            StoriesResponse storiesResponse2 = storiesResponse;
            if (storiesResponse2.getStories().isEmpty()) {
                return new LoadingState.Error(new ErrorWithMessage.SimpleMessageError("Empty stories array"));
            }
            if (!StoriesInteractorImpl.access$getLastStoriesIds(this.a).containsAll(CollectionsKt___CollectionsKt.toSet(this.a.c(storiesResponse2.getStories())))) {
                this.a.resetLastUpdatedTimestamp();
                StoriesInteractorImpl.access$saveLastStories(this.a, storiesResponse2.getStories());
            } else {
                if (this.a.e.now() > StoriesInteractorKt.access$getSTORIES_LIFETIME_MILLIS$p() + StoriesInteractorImpl.access$getLastUpdatedTimestamp(this.a)) {
                    return new LoadingState.Error(new ErrorWithMessage.SimpleMessageError("Stories expired and hidden"));
                }
            }
            StoriesInteractorImpl storiesInteractorImpl = this.a;
            List access$sortByViewedStatus = StoriesInteractorImpl.access$sortByViewedStatus(storiesInteractorImpl, storiesInteractorImpl.a(storiesResponse2.getStories()));
            Story story = (Story) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) access$sortByViewedStatus);
            return new LoadingState.Loaded(new StoriesItem(null, 6, access$sortByViewedStatus, story != null ? story.getId() : null, 1, null));
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super StoriesItem>> {
        public final /* synthetic */ StoriesInteractorImpl a;

        public c(StoriesInteractorImpl storiesInteractorImpl) {
            this.a = storiesInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super StoriesItem> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public StoriesInteractorImpl(@NotNull StoriesApi storiesApi, @NotNull Preferences preferences, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(storiesApi, "storiesApi");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.a = storiesApi;
        this.b = preferences;
        this.c = typedErrorThrowableConverter;
        this.d = schedulersFactory3;
        this.e = timeSource;
    }

    public static final Set access$getLastStoriesIds(StoriesInteractorImpl storiesInteractorImpl) {
        Set<String> stringSet = storiesInteractorImpl.b.getStringSet(StoriesInteractorKt.LAST_STORIES_KEY);
        return stringSet != null ? stringSet : y.emptySet();
    }

    public static final long access$getLastUpdatedTimestamp(StoriesInteractorImpl storiesInteractorImpl) {
        return storiesInteractorImpl.b.getLong(StoriesInteractorKt.LAST_UPDATED_KEY, 0);
    }

    public static final void access$saveLastStories(StoriesInteractorImpl storiesInteractorImpl, List list) {
        storiesInteractorImpl.b.putStringSet(StoriesInteractorKt.LAST_STORIES_KEY, CollectionsKt___CollectionsKt.toSet(storiesInteractorImpl.c(list)));
    }

    public static final List access$sortByViewedStatus(StoriesInteractorImpl storiesInteractorImpl, List list) {
        Objects.requireNonNull(storiesInteractorImpl);
        return CollectionsKt___CollectionsKt.sortedWith(list, new Comparator<T>() { // from class: com.avito.android.stories.StoriesInteractorImpl$sortByViewedStatus$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(t.isViewed(), t2.isViewed());
            }
        });
    }

    public final List<Story> a(List<Story> list) {
        Set<String> b2 = b();
        for (T t : list) {
            if (b2.contains(t.getId())) {
                t.setViewed(Boolean.TRUE);
            }
        }
        return list;
    }

    public final Set<String> b() {
        Set<String> stringSet = this.b.getStringSet(StoriesInteractorKt.VIEWED_STORIES_KEY);
        return stringSet != null ? stringSet : y.emptySet();
    }

    public final List<String> c(List<Story> list) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        return arrayList;
    }

    @Override // com.avito.android.stories.StoriesInteractor
    public boolean isStoryViewed(int i) {
        return b().contains(String.valueOf(i));
    }

    @Override // com.avito.android.stories.StoriesInteractor
    @NotNull
    public Observable<LoadingState<StoriesItem>> loadStories(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Observable<R> onErrorReturn = this.a.getStories(location.getId().length() == 0 ? null : location.getId()).flatMap(a.a).subscribeOn(this.d.io()).map(new b(this)).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "storiesApi.getStories(cu…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.stories.StoriesInteractor
    public void markStoryViewed(int i) {
        Set<String> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(b());
        mutableSet.add(String.valueOf(i));
        Iterator<String> it = mutableSet.iterator();
        while (mutableSet.size() > 20) {
            it.next();
            it.remove();
        }
        this.b.putStringSet(StoriesInteractorKt.VIEWED_STORIES_KEY, mutableSet);
    }

    @Override // com.avito.android.stories.StoriesInteractor
    public void resetLastUpdatedTimestamp() {
        this.b.putLong(StoriesInteractorKt.LAST_UPDATED_KEY, this.e.now());
    }

    @Override // com.avito.android.stories.StoriesInteractor
    public void updateStoriesViewedStatus(@NotNull List<Story> list) {
        Intrinsics.checkNotNullParameter(list, "stories");
        a(list);
    }
}
