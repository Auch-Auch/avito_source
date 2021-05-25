package com.avito.android.rating.user_contacts;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.RatingPublishLink;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.rating.details.adapter.loading.LoadingItem;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.user_contacts.UserContactsPresenter;
import com.avito.android.rating.user_contacts.action.UserContactAction;
import com.avito.android.rating.user_contacts.adapter.contact.ContactItem;
import com.avito.android.rating.user_contacts.adapter.info.InfoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.user_contacts.UserContactResultElement;
import com.avito.android.remote.model.user_contacts.UserContactsResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Uris;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010Y\u001a\u00020V\u0012\u0006\u0010P\u001a\u00020M\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020>0'\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010]\u001a\u00020Z\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u0002060'\u0012\b\u0010^\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b_\u0010`J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u001d\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c*\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c*\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002¢\u0006\u0004\b \u0010\u001fR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020#0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00105\u001a\u00020#2\u0006\u00101\u001a\u00020#8\u0002@BX\u000e¢\u0006\f\n\u0004\b2\u0010%\"\u0004\b3\u00104R\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002060'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010)R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010:R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020>0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010)R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010:R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010ORD\u0010U\u001a0\u0012\f\u0012\n R*\u0004\u0018\u00010#0# R*\u0017\u0012\f\u0012\n R*\u0004\u0018\u00010#0#\u0018\u00010Q¢\u0006\u0002\bS0Q¢\u0006\u0002\bS8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006a"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsPresenterImpl;", "Lcom/avito/android/rating/user_contacts/UserContactsPresenter;", "Lcom/avito/android/rating/user_contacts/UserContactsView;", "view", "", "attachView", "(Lcom/avito/android/rating/user_contacts/UserContactsView;)V", "Lcom/avito/android/rating/user_contacts/UserContactsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/user_contacts/UserContactsPresenter$Router;)V", "detachRouter", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "userKey", "message", "onRatingPublished", "(Ljava/lang/String;Ljava/lang/String;)V", "resetScores", AuthSource.SEND_ABUSE, "c", "Lkotlin/Function0;", "block", AuthSource.BOOKING_ORDER, "(Lkotlin/jvm/functions/Function0;)V", "", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "e", "(Ljava/util/List;)Ljava/util/List;", "d", "Ljava/util/List;", "items", "", "i", "Z", "isLoading", "Lio/reactivex/rxjava3/core/Observable;", "j", "Lio/reactivex/rxjava3/core/Observable;", "getChangesObservable", "()Lio/reactivex/rxjava3/core/Observable;", "changesObservable", "Lcom/avito/android/rating/user_contacts/UserContactsInteractor;", "k", "Lcom/avito/android/rating/user_contacts/UserContactsInteractor;", "interactor", "value", "h", "setHasChanges", "(Z)V", "hasChanges", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemNextPageAction;", VKApiConst.Q, "loadingItemShown", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "actionDisposables", "f", "Lcom/avito/android/rating/user_contacts/UserContactsView;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction;", "n", "actionStream", "Landroid/net/Uri;", "Landroid/net/Uri;", "nextPage", "Lio/reactivex/rxjava3/disposables/Disposable;", g.a, "Lio/reactivex/rxjava3/disposables/Disposable;", "loadDisposable", "Lcom/avito/android/error_helper/ErrorHelper;", "o", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "removeDisposables", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "changesRelay", "Lcom/avito/android/rating/user_contacts/UserContactsConverter;", "l", "Lcom/avito/android/rating/user_contacts/UserContactsConverter;", "converter", "Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "p", "Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "spanProvider", "state", "<init>", "(Lcom/avito/android/rating/user_contacts/UserContactsInteractor;Lcom/avito/android/rating/user_contacts/UserContactsConverter;Lcom/avito/android/util/SchedulersFactory3;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserContactsPresenterImpl implements UserContactsPresenter {
    public Uri a;
    public List<? extends RatingDetailsItem> b;
    public final CompositeDisposable c;
    public final CompositeDisposable d;
    public final BehaviorRelay<Boolean> e;
    public UserContactsView f;
    public Disposable g;
    public boolean h;
    public boolean i;
    @NotNull
    public final Observable<Boolean> j;
    public final UserContactsInteractor k;
    public final UserContactsConverter l;
    public final SchedulersFactory3 m;
    public final Observable<UserContactAction> n;
    public final ErrorHelper o;
    public final UserContactsSpanProvider p;
    public final Observable<LoadingItemNextPageAction> q;

    public static final class a implements Action {
        public final /* synthetic */ UserContactsPresenterImpl a;

        public a(UserContactsPresenterImpl userContactsPresenterImpl) {
            this.a = userContactsPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.i = false;
        }
    }

    public static final class b<T> implements Consumer<UserContactsResult> {
        public final /* synthetic */ UserContactsPresenterImpl a;

        public b(UserContactsPresenterImpl userContactsPresenterImpl) {
            this.a = userContactsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(UserContactsResult userContactsResult) {
            UserContactsResult userContactsResult2 = userContactsResult;
            UserContactsPresenterImpl userContactsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(userContactsResult2, "it");
            UserContactsPresenterImpl.access$handleSuccess(userContactsPresenterImpl, userContactsResult2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ UserContactsPresenterImpl a;

        public c(UserContactsPresenterImpl userContactsPresenterImpl) {
            this.a = userContactsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            UserContactsPresenterImpl userContactsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            UserContactsPresenterImpl.access$handleError(userContactsPresenterImpl, th2);
        }
    }

    public static final class d<T> implements Consumer<UserContactAction> {
        public final /* synthetic */ UserContactsPresenterImpl a;
        public final /* synthetic */ UserContactsPresenter.Router b;

        public d(UserContactsPresenterImpl userContactsPresenterImpl, UserContactsPresenter.Router router) {
            this.a = userContactsPresenterImpl;
            this.b = router;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(UserContactAction userContactAction) {
            List d;
            UserContactAction userContactAction2 = userContactAction;
            if (userContactAction2 instanceof UserContactAction.Rating) {
                UserContactAction.Rating rating = (UserContactAction.Rating) userContactAction2;
                DeepLink deepLink = rating.getItem().getDeepLink();
                if (deepLink != null) {
                    this.b.followDeepLink(UserContactsPresenterImpl.access$mixRating(this.a, deepLink, rating));
                }
            } else if (userContactAction2 instanceof UserContactAction.Remove) {
                UserContactsPresenterImpl.access$removeItem(this.a, ((UserContactAction.Remove) userContactAction2).getItem());
            } else if (userContactAction2 instanceof UserContactAction.Refresh) {
                UserContactsPresenterImpl userContactsPresenterImpl = this.a;
                List list = userContactsPresenterImpl.b;
                List list2 = null;
                if (!(list == null || (d = this.a.d(list)) == null || !(!d.isEmpty()))) {
                    list2 = d;
                }
                userContactsPresenterImpl.b = list2;
                this.a.c();
            }
        }
    }

    public static final class e<T> implements Consumer<LoadingItemNextPageAction> {
        public final /* synthetic */ UserContactsPresenterImpl a;

        public e(UserContactsPresenterImpl userContactsPresenterImpl) {
            this.a = userContactsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingItemNextPageAction loadingItemNextPageAction) {
            this.a.a = loadingItemNextPageAction.getNextPage();
            this.a.a();
        }
    }

    @Inject
    public UserContactsPresenterImpl(@NotNull UserContactsInteractor userContactsInteractor, @NotNull UserContactsConverter userContactsConverter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Observable<UserContactAction> observable, @NotNull ErrorHelper errorHelper, @NotNull UserContactsSpanProvider userContactsSpanProvider, @NotNull Observable<LoadingItemNextPageAction> observable2, @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(userContactsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(userContactsConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(observable, "actionStream");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(userContactsSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(observable2, "loadingItemShown");
        this.k = userContactsInteractor;
        this.l = userContactsConverter;
        this.m = schedulersFactory3;
        this.n = observable;
        this.o = errorHelper;
        this.p = userContactsSpanProvider;
        this.q = observable2;
        List<? extends RatingDetailsItem> list = null;
        this.a = kundle != null ? (Uri) kundle.getParcelable("next_page") : null;
        this.b = kundle != null ? kundle.getParcelableList("items") : list;
        this.c = new CompositeDisposable();
        this.d = new CompositeDisposable();
        BehaviorRelay<Boolean> create = BehaviorRelay.create();
        this.e = create;
        boolean booleanValue = (kundle == null || (bool = kundle.getBoolean("has_changes")) == null) ? false : bool.booleanValue();
        this.h = booleanValue;
        create.accept(Boolean.valueOf(booleanValue));
        Intrinsics.checkNotNullExpressionValue(create, "changesRelay");
        this.j = create;
    }

    public static final List access$filterAloneInfoItems(UserContactsPresenterImpl userContactsPresenterImpl, List list) {
        Objects.requireNonNull(userContactsPresenterImpl);
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!(((RatingDetailsItem) it.next()) instanceof InfoItem)) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return z ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    public static final void access$handleError(UserContactsPresenterImpl userContactsPresenterImpl, Throwable th) {
        List<? extends RatingDetailsItem> list = userContactsPresenterImpl.b;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        userContactsPresenterImpl.b = CollectionsKt___CollectionsKt.plus((Collection<? extends ErrorSnippetItem>) userContactsPresenterImpl.d(userContactsPresenterImpl.e(list)), new ErrorSnippetItem("error", userContactsPresenterImpl.o.recycle(th)));
        userContactsPresenterImpl.c();
    }

    public static final void access$handleSuccess(UserContactsPresenterImpl userContactsPresenterImpl, UserContactsResult userContactsResult) {
        List<? extends RatingDetailsItem> list;
        Objects.requireNonNull(userContactsPresenterImpl);
        userContactsPresenterImpl.a = userContactsResult.getNextPage();
        UserContactsConverter userContactsConverter = userContactsPresenterImpl.l;
        List<UserContactResultElement> elements = userContactsResult.getElements();
        if (elements == null) {
            elements = CollectionsKt__CollectionsKt.emptyList();
        }
        List<RatingDetailsItem> convert = userContactsConverter.convert(elements);
        if (!(!convert.isEmpty()) || userContactsPresenterImpl.a == null) {
            List<? extends RatingDetailsItem> list2 = userContactsPresenterImpl.b;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            list = CollectionsKt___CollectionsKt.plus((Collection) userContactsPresenterImpl.e(list2), (Iterable) convert);
        } else {
            List<? extends RatingDetailsItem> list3 = userContactsPresenterImpl.b;
            if (list3 == null) {
                list3 = CollectionsKt__CollectionsKt.emptyList();
            }
            List plus = CollectionsKt___CollectionsKt.plus((Collection) userContactsPresenterImpl.e(list3), (Iterable) convert);
            Uri uri = userContactsPresenterImpl.a;
            Intrinsics.checkNotNull(uri);
            list = CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingItem>) plus, new LoadingItem(uri));
        }
        userContactsPresenterImpl.b = list;
        userContactsPresenterImpl.c();
    }

    public static final DeepLink access$mixRating(UserContactsPresenterImpl userContactsPresenterImpl, DeepLink deepLink, UserContactAction.Rating rating) {
        Objects.requireNonNull(userContactsPresenterImpl);
        return deepLink instanceof RatingPublishLink ? RatingPublishLink.copy$default((RatingPublishLink) deepLink, null, null, false, false, rating.getItem().getItemId(), Integer.valueOf(rating.getRating()), rating.getItem().isAutoItem(), 15, null) : deepLink;
    }

    public static final void access$removeItem(UserContactsPresenterImpl userContactsPresenterImpl, ContactItem contactItem) {
        CompositeDisposable compositeDisposable = userContactsPresenterImpl.d;
        Disposable subscribe = userContactsPresenterImpl.k.removeContact(contactItem.getUserKey(), contactItem.getItemId()).observeOn(userContactsPresenterImpl.m.mainThread()).subscribe(a2.a.a.g2.d.b.a, a2.a.a.g2.d.c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.removeContact…       .subscribe({}, {})");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        userContactsPresenterImpl.b(new a2.a.a.g2.d.d(userContactsPresenterImpl, contactItem));
        userContactsPresenterImpl.c();
    }

    public final void a() {
        if (!this.i) {
            Disposable disposable = this.g;
            if (disposable != null) {
                disposable.dispose();
            }
            this.i = true;
            Uri uri = this.a;
            this.g = (uri == null ? this.k.getContactList() : this.k.getContactList(uri)).observeOn(this.m.mainThread()).doFinally(new a(this)).subscribe(new b(this), new c(this));
        }
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsPresenter
    public void attachRouter(@NotNull UserContactsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.n.subscribe(new d(this, router));
        Intrinsics.checkNotNullExpressionValue(subscribe, "actionStream.subscribe {…}\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = this.q.subscribe(new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "loadingItemShown.subscri…ndContactList()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        c();
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsPresenter
    public void attachView(@NotNull UserContactsView userContactsView) {
        Intrinsics.checkNotNullParameter(userContactsView, "view");
        this.f = userContactsView;
        if (this.b == null) {
            a();
        }
    }

    public final void b(Function0<Unit> function0) {
        List<? extends RatingDetailsItem> list = this.b;
        int i2 = 0;
        int size = list != null ? list.size() : 0;
        function0.invoke();
        List<? extends RatingDetailsItem> list2 = this.b;
        if (list2 != null) {
            i2 = list2.size();
        }
        int i3 = i2 - size;
        if (i3 != 0) {
            Uri uri = this.a;
            this.a = uri != null ? Uris.moveNextPageOffset(uri, i3) : null;
            this.h = true;
            this.e.accept(Boolean.TRUE);
        }
    }

    public final void c() {
        UserContactsView userContactsView = this.f;
        if (userContactsView != null) {
            List<? extends RatingDetailsItem> list = this.b;
            userContactsView.showEmptyState(list != null && list.isEmpty());
        }
        List<? extends RatingDetailsItem> list2 = this.b;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        ListDataSource listDataSource = new ListDataSource(list2);
        UserContactsView userContactsView2 = this.f;
        if (userContactsView2 != null) {
            userContactsView2.setItems(listDataSource);
        }
        this.p.onDataSourceChanged(listDataSource);
    }

    public final List<RatingDetailsItem> d(List<? extends RatingDetailsItem> list) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (!(t instanceof ErrorSnippetItem)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsPresenter
    public void detachRouter() {
        Disposable disposable = this.g;
        if (disposable != null) {
            disposable.dispose();
        }
        this.g = null;
        this.c.clear();
        this.d.clear();
    }

    public final List<RatingDetailsItem> e(List<? extends RatingDetailsItem> list) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (!(t instanceof LoadingItem)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsPresenter
    @NotNull
    public Observable<Boolean> getChangesObservable() {
        return this.j;
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsPresenter
    public void onRatingPublished(@NotNull String str, @Nullable String str2) {
        UserContactsView userContactsView;
        Intrinsics.checkNotNullParameter(str, "userKey");
        b(new a2.a.a.g2.d.a(this, str));
        c();
        if (str2 != null && (userContactsView = this.f) != null) {
            userContactsView.showMessage(str2);
        }
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("next_page", this.a).putParcelableList("items", this.b).putBoolean("has_changes", Boolean.valueOf(this.h));
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsPresenter
    public void resetScores() {
        c();
    }
}
