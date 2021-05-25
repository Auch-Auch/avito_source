package com.avito.android.publish.publish_advert_request.data;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.publish.PublishedAdvertData;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PostAdvertResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010 J=\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepositoryImpl;", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "params", "Lcom/avito/android/publish/slots/contact_info/ContactsData;", "data", "", "draftId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/publish/PublishedAdvertData;", "postAdvert", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Lcom/avito/android/publish/slots/contact_info/ContactsData;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;", "cloudDataSource", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "c", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "<init>", "(Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAdvertRepositoryImpl implements PublishAdvertRepository {
    public final PublishAdvertDataSource a;
    public final PublishAnalyticsDataProvider b;
    public final CategoryParametersConverter c;
    public final TypedErrorThrowableConverter d;

    public static final class a<T, R> implements Function<PostAdvertResult, LoadingState<? super PublishedAdvertData>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PublishedAdvertData> apply(PostAdvertResult postAdvertResult) {
            PostAdvertResult postAdvertResult2 = postAdvertResult;
            Intrinsics.checkNotNullParameter(postAdvertResult2, "it");
            String id = postAdvertResult2.getPostedAdvert().getId();
            PostAdvertResult.Messages messages = postAdvertResult2.getMessages();
            String fees = messages != null ? messages.getFees() : null;
            boolean z = false;
            if (fees != null) {
                if (fees.length() > 0) {
                    z = true;
                }
            }
            DeepLink nextStepUri = postAdvertResult2.getNextStepUri();
            if (nextStepUri == null) {
                nextStepUri = new NoMatchLink();
            }
            return new LoadingState.Loaded(new PublishedAdvertData(id, z, nextStepUri));
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super PublishedAdvertData>> {
        public final /* synthetic */ PublishAdvertRepositoryImpl a;

        public b(PublishAdvertRepositoryImpl publishAdvertRepositoryImpl) {
            this.a = publishAdvertRepositoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PublishedAdvertData> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.d.convert(th2));
        }
    }

    public PublishAdvertRepositoryImpl(@NotNull PublishAdvertDataSource publishAdvertDataSource, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(publishAdvertDataSource, "cloudDataSource");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = publishAdvertDataSource;
        this.b = publishAnalyticsDataProvider;
        this.c = categoryParametersConverter;
        this.d = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.publish.publish_advert_request.data.PublishAdvertRepository
    @NotNull
    public Observable<LoadingState<PublishedAdvertData>> postAdvert(@NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters, @NotNull ContactsData contactsData, @Nullable String str) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(categoryParameters, "params");
        Intrinsics.checkNotNullParameter(contactsData, "data");
        Observable<R> onErrorReturn = this.a.postAdvert(this.c.convertToFieldMap(categoryParameters.getParametersExceptOwnedBySlots()), this.b.getSessionId(), this.c.convertToFieldMap(navigation), str).map(a.a).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "cloudDataSource.postAdve…onvert(it))\n            }");
        return onErrorReturn;
    }
}
