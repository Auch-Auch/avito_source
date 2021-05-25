package com.avito.android.user_adverts.tab_screens.converters;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;", "", "Lcom/avito/android/remote/model/SerpElement;", "list", "Lio/reactivex/Observable;", "Lcom/avito/android/serp/adapter/SerpItem;", "convert", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverter;", "itemConverter", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverter;Lcom/avito/android/util/SchedulersFactory;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserItemConverterImpl implements UserItemConverter {
    public final UserElementItemConverter a;
    public final SchedulersFactory b;

    public static final class a<V> implements Callable<List<? extends SerpItem>> {
        public final /* synthetic */ UserItemConverterImpl a;
        public final /* synthetic */ List b;

        public a(UserItemConverterImpl userItemConverterImpl, List list) {
            this.a = userItemConverterImpl;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends SerpItem> call() {
            return UserItemConverterImpl.access$convert(this.a, this.b);
        }
    }

    @Inject
    public UserItemConverterImpl(@NotNull UserElementItemConverter userElementItemConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(userElementItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = userElementItemConverter;
        this.b = schedulersFactory;
    }

    public static final List access$convert(UserItemConverterImpl userItemConverterImpl, List list) {
        return userItemConverterImpl.a.convert(list);
    }

    @Override // com.avito.android.user_adverts.tab_screens.converters.UserItemConverter
    @NotNull
    public Observable<List<SerpItem>> convert(@NotNull List<? extends SerpElement> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Observable<List<SerpItem>> subscribeOn = Observable.fromCallable(new a(this, list)).subscribeOn(this.b.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable.fromCallable …schedulers.computation())");
        return subscribeOn;
    }
}
