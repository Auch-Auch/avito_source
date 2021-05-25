package com.avito.android.publish;

import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Profile;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.sumsub.sns.R2;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b*\u0010+J1\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR$\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/publish/ContactsDataSourceImpl;", "Lcom/avito/android/publish/ContactsDataSource;", "Lkotlin/Function1;", "Lcom/avito/android/publish/slots/contact_info/ContactsData;", "", "contactsDataChange", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "prepareContactsData", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "profileObservable", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "e", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "performanceTracker", "value", "getContactsData", "()Lcom/avito/android/publish/slots/contact_info/ContactsData;", "setContactsData", "(Lcom/avito/android/publish/slots/contact_info/ContactsData;)V", "contactsData", "Lcom/avito/android/publish/ProfileSourceInteractor;", "c", "Lcom/avito/android/publish/ProfileSourceInteractor;", "profileSource", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/publish/PublishViewModel;", "getPublishViewModel", "()Lcom/avito/android/publish/PublishViewModel;", "setPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "contactsDataChanges", "<init>", "(Lcom/avito/android/publish/ProfileSourceInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ContactsDataSourceImpl implements ContactsDataSource {
    public final List<Function1<ContactsData, Unit>> a = new ArrayList();
    public Observable<LoadingState<Unit>> b;
    public final ProfileSourceInteractor c;
    public final SchedulersFactory d;
    public final PublishDetailsTracker e;
    public PublishViewModel publishViewModel;

    public static final class a<T, R> implements Function<Profile, ContactsData> {
        public final /* synthetic */ ContactsDataSourceImpl a;

        public a(ContactsDataSourceImpl contactsDataSourceImpl) {
            this.a = contactsDataSourceImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ContactsData apply(Profile profile) {
            Profile profile2 = profile;
            Intrinsics.checkNotNullParameter(profile2, "it");
            return ContactsDataSourceImpl.access$createContactsDataFromProfile(this.a, profile2);
        }
    }

    public static final class b<T, R> implements Function<ContactsData, ContactsData> {
        public final /* synthetic */ ContactsDataSourceImpl a;

        public b(ContactsDataSourceImpl contactsDataSourceImpl) {
            this.a = contactsDataSourceImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ContactsData apply(ContactsData contactsData) {
            ContactsData contactsData2 = contactsData;
            Intrinsics.checkNotNullParameter(contactsData2, "data");
            for (T t : this.a.a) {
                t.invoke(contactsData2);
            }
            return contactsData2;
        }
    }

    public static final class c<T> implements Consumer<ContactsData> {
        public final /* synthetic */ ContactsDataSourceImpl a;

        public c(ContactsDataSourceImpl contactsDataSourceImpl) {
            this.a = contactsDataSourceImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ContactsData contactsData) {
            this.a.getPublishViewModel().setContactsData(contactsData);
            this.a.e.trackProfileLoaded();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ContactsDataSourceImpl a;

        public d(ContactsDataSourceImpl contactsDataSourceImpl) {
            this.a = contactsDataSourceImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.e.trackProfileLoadError();
        }
    }

    public static final class e<T, R> implements Function<ContactsData, LoadingState<? super Unit>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Unit> apply(ContactsData contactsData) {
            Intrinsics.checkNotNullParameter(contactsData, "it");
            return new LoadingState.Loaded(Unit.INSTANCE);
        }
    }

    public ContactsDataSourceImpl(@NotNull ProfileSourceInteractor profileSourceInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishDetailsTracker publishDetailsTracker) {
        Intrinsics.checkNotNullParameter(profileSourceInteractor, "profileSource");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "performanceTracker");
        this.c = profileSourceInteractor;
        this.d = schedulersFactory;
        this.e = publishDetailsTracker;
    }

    public static final ContactsData access$createContactsDataFromProfile(ContactsDataSourceImpl contactsDataSourceImpl, Profile profile) {
        Objects.requireNonNull(contactsDataSourceImpl);
        String phone = profile.getPhone();
        if (phone == null) {
            phone = "";
        }
        return new ContactsData(phone, profile.getName(), profile.getEmail(), profile.getManager(), profile.getAvatar(), profile.isShop(), profile.getType().isCompany(), profile.isIncomplete(), profile.isPro(), null, false, null, null, R2.styleable.MockView_mock_labelBackgroundColor, null);
    }

    @Override // com.avito.android.publish.ContactsDataSource
    @Nullable
    public ContactsData getContactsData() {
        PublishViewModel publishViewModel2 = this.publishViewModel;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel2.getContactsData();
    }

    @NotNull
    public final PublishViewModel getPublishViewModel() {
        PublishViewModel publishViewModel2 = this.publishViewModel;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel2;
    }

    @Override // com.avito.android.publish.ContactsDataSource
    @NotNull
    public Observable<LoadingState<Unit>> prepareContactsData(@Nullable Function1<? super ContactsData, Unit> function1) {
        PublishViewModel publishViewModel2 = this.publishViewModel;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        if (publishViewModel2.getContactsData() != null) {
            Observable<LoadingState<Unit>> just = Observable.just(new LoadingState.Loaded(Unit.INSTANCE));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(LoadingState.Loaded(Unit))");
            return just;
        }
        if (function1 != null) {
            this.a.add(function1);
        }
        this.e.startProfileLoading();
        if (this.b == null) {
            this.b = this.c.getProfile().map(new a(this)).map(new b(this)).observeOn(this.d.mainThread()).toObservable().doOnNext(new c(this)).doOnError(new d(this)).map(e.a).share();
        }
        Observable<LoadingState<Unit>> observable = this.b;
        Intrinsics.checkNotNull(observable);
        return observable;
    }

    @Override // com.avito.android.publish.ContactsDataSource
    public void setContactsData(@Nullable ContactsData contactsData) {
        PublishViewModel publishViewModel2 = this.publishViewModel;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel2.setContactsData(contactsData);
    }

    public final void setPublishViewModel(@NotNull PublishViewModel publishViewModel2) {
        Intrinsics.checkNotNullParameter(publishViewModel2, "<set-?>");
        this.publishViewModel = publishViewModel2;
    }
}
