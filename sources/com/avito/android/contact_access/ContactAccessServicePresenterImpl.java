package com.avito.android.contact_access;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ContactAccessService;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Formatter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.NetworkException;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.LegacyAttributedTextFormatter;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020706\u0012\u0006\u0010+\u001a\u00020(\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b;\u0010<J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0019\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R(\u00102\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,8\u0006@BX\u000e¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000207068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/avito/android/contact_access/ContactAccessServicePresenterImpl;", "Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "", "retry", "()V", "Lcom/avito/android/contact_access/ContactAccessServiceView;", "subscriber", "subscribe", "(Lcom/avito/android/contact_access/ContactAccessServiceView;)V", "unsubscribe", "onContinueClicked", "Lcom/avito/android/contact_access/ContactAccessServiceRouter;", "router", "attachRouter", "(Lcom/avito/android/contact_access/ContactAccessServiceRouter;)V", "detachRouter", "close", "onIncompleteRegisterFinished", "Landroid/os/Bundle;", "state", "onSaveState", "(Landroid/os/Bundle;)V", "load", "Lcom/avito/android/remote/model/text/AttributedText;", "legal", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/text/AttributedText;)V", "e", "Lcom/avito/android/contact_access/ContactAccessServiceRouter;", "Lcom/avito/android/util/text/LegacyAttributedTextFormatter;", "Lcom/avito/android/util/text/LegacyAttributedTextFormatter;", "textFormatter", "Lio/reactivex/disposables/Disposable;", "d", "Lio/reactivex/disposables/Disposable;", "subscription", "Lcom/avito/android/contact_access/ContactAccessServiceInteractor;", "f", "Lcom/avito/android/contact_access/ContactAccessServiceInteractor;", "contactAccessServiceInteractor", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/model/ContactAccessService;", "<set-?>", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/ContactAccessService;", "getDomainModel", "()Lcom/avito/android/remote/model/ContactAccessService;", "domainModel", "c", "Lcom/avito/android/contact_access/ContactAccessServiceView;", "view", "Lcom/avito/android/util/Formatter;", "", g.a, "Lcom/avito/android/util/Formatter;", "errorFormatter", "<init>", "(Lcom/avito/android/contact_access/ContactAccessServiceInteractor;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/SchedulersFactory;Landroid/os/Bundle;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessServicePresenterImpl implements ContactAccessServicePresenter {
    public final LegacyAttributedTextFormatter a = new LegacyAttributedTextFormatter();
    @Nullable
    public ContactAccessService b;
    public ContactAccessServiceView c;
    public Disposable d;
    public ContactAccessServiceRouter e;
    public final ContactAccessServiceInteractor f;
    public final Formatter<Throwable> g;
    public final SchedulersFactory h;

    public static final class a<T> implements Consumer<LoadingState<? super ContactAccessService>> {
        public final /* synthetic */ ContactAccessServicePresenterImpl a;

        public a(ContactAccessServicePresenterImpl contactAccessServicePresenterImpl) {
            this.a = contactAccessServicePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super ContactAccessService> loadingState) {
            LoadingState<? super ContactAccessService> loadingState2 = loadingState;
            this.a.d = null;
            if (loadingState2 instanceof LoadingState.Error) {
                ContactAccessServiceRouter contactAccessServiceRouter = this.a.e;
                if (contactAccessServiceRouter != null) {
                    contactAccessServiceRouter.showIncompleteRegister();
                }
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.b = (ContactAccessService) loaded.getData();
                ContactAccessServicePresenterImpl.access$finish(this.a, (ContactAccessService) loaded.getData());
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ContactAccessServicePresenterImpl a;

        public b(ContactAccessServicePresenterImpl contactAccessServicePresenterImpl) {
            this.a = contactAccessServicePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.d = null;
            ContactAccessServicePresenterImpl contactAccessServicePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ContactAccessServicePresenterImpl.access$error(contactAccessServicePresenterImpl, th2);
        }
    }

    public static final class c implements OnDeepLinkClickListener {
        public final /* synthetic */ ContactAccessServicePresenterImpl a;

        public c(ContactAccessServicePresenterImpl contactAccessServicePresenterImpl) {
            this.a = contactAccessServicePresenterImpl;
        }

        @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
        public final void onDeepLinkClick(@NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            ContactAccessServiceRouter contactAccessServiceRouter = this.a.e;
            if (contactAccessServiceRouter != null) {
                contactAccessServiceRouter.onActionRequest(deepLink);
            }
        }
    }

    @Inject
    public ContactAccessServicePresenterImpl(@NotNull ContactAccessServiceInteractor contactAccessServiceInteractor, @NotNull Formatter<Throwable> formatter, @NotNull SchedulersFactory schedulersFactory, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(contactAccessServiceInteractor, "contactAccessServiceInteractor");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.f = contactAccessServiceInteractor;
        this.g = formatter;
        this.h = schedulersFactory;
        this.b = bundle != null ? (ContactAccessService) bundle.getParcelable("key_package_service") : null;
    }

    public static final void access$error(ContactAccessServicePresenterImpl contactAccessServicePresenterImpl, Throwable th) {
        ContactAccessServiceView contactAccessServiceView = contactAccessServicePresenterImpl.c;
        if (contactAccessServiceView == null) {
            return;
        }
        if (th instanceof NetworkException) {
            contactAccessServiceView.networkError();
        } else {
            contactAccessServiceView.serverError(contactAccessServicePresenterImpl.g.format(th));
        }
    }

    public static final void access$finish(ContactAccessServicePresenterImpl contactAccessServicePresenterImpl, ContactAccessService contactAccessService) {
        ContactAccessServiceView contactAccessServiceView = contactAccessServicePresenterImpl.c;
        if (contactAccessServiceView != null) {
            contactAccessServiceView.hideProgress();
            contactAccessServiceView.setContent(new PresentationAccessServiceModelImpl(contactAccessService));
            contactAccessServicePresenterImpl.a(contactAccessService.getLegal());
        }
    }

    public final void a(AttributedText attributedText) {
        c cVar = new c(this);
        if (attributedText == null) {
            ContactAccessServiceView contactAccessServiceView = this.c;
            if (contactAccessServiceView != null) {
                contactAccessServiceView.setUpLegalTextView(null);
                return;
            }
            return;
        }
        attributedText.setOnDeepLinkClickListener(cVar);
        ContactAccessServiceView contactAccessServiceView2 = this.c;
        if (contactAccessServiceView2 != null) {
            contactAccessServiceView2.setUpLegalTextView(this.a.format(attributedText));
        }
    }

    @Override // com.avito.android.contact_access.ContactAccessServicePresenter
    public void attachRouter(@Nullable ContactAccessServiceRouter contactAccessServiceRouter) {
        this.e = contactAccessServiceRouter;
    }

    @Override // com.avito.android.contact_access.ContactAccessServicePresenter
    public void close() {
        ContactAccessServiceRouter contactAccessServiceRouter = this.e;
        if (contactAccessServiceRouter != null) {
            contactAccessServiceRouter.close();
        }
    }

    @Override // com.avito.android.contact_access.ContactAccessServicePresenter
    public void detachRouter() {
        this.e = null;
    }

    @Nullable
    public final ContactAccessService getDomainModel() {
        return this.b;
    }

    public final void load() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        Scheduler mainThread = this.h.mainThread();
        this.d = this.f.loadService().observeOn(mainThread).subscribeOn(this.h.io()).subscribe(new a(this), new b(this));
    }

    @Override // com.avito.android.contact_access.ContactAccessServicePresenter
    public void onContinueClicked() {
        ContactAccessServiceRouter contactAccessServiceRouter;
        Action action;
        ContactAccessService contactAccessService = this.b;
        DeepLink deepLink = (contactAccessService == null || (action = contactAccessService.getAction()) == null) ? null : action.getDeepLink();
        if (deepLink != null && (contactAccessServiceRouter = this.e) != null) {
            contactAccessServiceRouter.onActionRequest(deepLink);
        }
    }

    @Override // com.avito.android.contact_access.ContactAccessServicePresenter
    public void onIncompleteRegisterFinished() {
        retry();
    }

    @Override // com.avito.android.contact_access.ContactAccessServicePresenter
    public void onSaveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "state");
        bundle.putParcelable("key_package_service", this.b);
    }

    @Override // com.avito.android.contact_access.ContactAccessServicePresenter
    public void retry() {
        if (this.b == null) {
            ContactAccessServiceView contactAccessServiceView = this.c;
            if (contactAccessServiceView != null) {
                contactAccessServiceView.showProgress();
            }
            load();
        }
    }

    @Override // com.avito.android.legacy_mvp.Presenter
    public void unsubscribe() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
        this.d = null;
    }

    public void subscribe(@NotNull ContactAccessServiceView contactAccessServiceView) {
        Intrinsics.checkNotNullParameter(contactAccessServiceView, "subscriber");
        this.c = contactAccessServiceView;
        ContactAccessService contactAccessService = this.b;
        if (contactAccessService == null) {
            contactAccessServiceView.showProgress();
            load();
            return;
        }
        contactAccessServiceView.setContent(new PresentationAccessServiceModelImpl(contactAccessService));
        a(contactAccessService.getLegal());
    }
}
