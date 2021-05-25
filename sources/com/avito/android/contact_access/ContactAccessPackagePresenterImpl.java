package com.avito.android.contact_access;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.parse.adapter.ContactAccessPackage;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u00100\u001a\u00020/\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010)¨\u00063"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessPackagePresenterImpl;", "Lcom/avito/android/contact_access/ContactAccessPackagePresenter;", "", "apply", "()V", "Lcom/avito/android/contact_access/ContactAccessPackageRouter;", "router", "attachRouter", "(Lcom/avito/android/contact_access/ContactAccessPackageRouter;)V", "Lcom/avito/android/contact_access/ContactAccessPackageView;", "subscriber", "subscribe", "(Lcom/avito/android/contact_access/ContactAccessPackageView;)V", "unsubscribe", "close", "detachRouter", "Landroid/os/Bundle;", "state", "onSaveState", "(Landroid/os/Bundle;)V", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "subscription", "Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", "c", "Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", "domainModel", "f", "Lcom/avito/android/contact_access/ContactAccessPackageRouter;", "Lcom/avito/android/contact_access/ContactAccessPackageInteractor;", g.a, "Lcom/avito/android/contact_access/ContactAccessPackageInteractor;", "interactor", "Lcom/avito/android/util/Formatter;", "", "h", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lio/reactivex/Scheduler;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Scheduler;", "io", "d", "Lcom/avito/android/contact_access/ContactAccessPackageView;", AuthSource.SEND_ABUSE, "mainThread", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/contact_access/ContactAccessPackageInteractor;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/SchedulersFactory;Landroid/os/Bundle;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessPackagePresenterImpl implements ContactAccessPackagePresenter {
    public final Scheduler a;
    public final Scheduler b;
    public ContactAccessPackage c;
    public ContactAccessPackageView d;
    public Disposable e;
    public ContactAccessPackageRouter f;
    public final ContactAccessPackageInteractor g;
    public final Formatter<Throwable> h;

    public static final class a<T> implements Consumer<SuccessResult> {
        public final /* synthetic */ ContactAccessPackagePresenterImpl a;

        public a(ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl) {
            this.a = contactAccessPackagePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SuccessResult successResult) {
            SuccessResult successResult2 = successResult;
            this.a.e = null;
            ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(successResult2, "it");
            ContactAccessPackagePresenterImpl.access$finishApplying(contactAccessPackagePresenterImpl, successResult2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ContactAccessPackagePresenterImpl a;

        public b(ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl) {
            this.a = contactAccessPackagePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.e = null;
            ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ContactAccessPackagePresenterImpl.access$error(contactAccessPackagePresenterImpl, th2);
        }
    }

    @Inject
    public ContactAccessPackagePresenterImpl(@NotNull ContactAccessPackageInteractor contactAccessPackageInteractor, @NotNull Formatter<Throwable> formatter, @NotNull SchedulersFactory schedulersFactory, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(contactAccessPackageInteractor, "interactor");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.g = contactAccessPackageInteractor;
        this.h = formatter;
        this.a = schedulersFactory.mainThread();
        this.b = schedulersFactory.io();
        this.c = bundle != null ? (ContactAccessPackage) bundle.getParcelable("key_cv_package") : null;
    }

    public static final void access$error(ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl, Throwable th) {
        ContactAccessPackageView contactAccessPackageView = contactAccessPackagePresenterImpl.d;
        if (contactAccessPackageView != null) {
            contactAccessPackageView.showMessage(contactAccessPackagePresenterImpl.h.format(th));
            ContactAccessPackageRouter contactAccessPackageRouter = contactAccessPackagePresenterImpl.f;
            if (contactAccessPackageRouter != null) {
                contactAccessPackageRouter.onClose();
                contactAccessPackageRouter.onUpdate();
            }
        }
    }

    public static final void access$finishApplying(ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl, SuccessResult successResult) {
        ContactAccessPackageView contactAccessPackageView = contactAccessPackagePresenterImpl.d;
        if (contactAccessPackageView != null) {
            String message = successResult.getMessage();
            if (message != null) {
                contactAccessPackageView.showMessage(message);
            }
            ContactAccessPackageRouter contactAccessPackageRouter = contactAccessPackagePresenterImpl.f;
            if (contactAccessPackageRouter != null) {
                contactAccessPackageRouter.onClose();
                contactAccessPackageRouter.onUpdate();
            }
        }
    }

    public static final void access$finishLoading(ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl, ContactAccessPackage contactAccessPackage) {
        ContactAccessPackageView contactAccessPackageView = contactAccessPackagePresenterImpl.d;
        if (contactAccessPackageView != null) {
            contactAccessPackageView.hideProgress();
            contactAccessPackageView.setContent(new PresentationCvPackageImpl(contactAccessPackage));
        }
    }

    @Override // com.avito.android.contact_access.ContactAccessPackagePresenter
    public void apply() {
        ContactAccessPackage contactAccessPackage = this.c;
        if (contactAccessPackage != null) {
            ContactAccessPackageView contactAccessPackageView = this.d;
            if (contactAccessPackageView != null) {
                contactAccessPackageView.showProgress();
            }
            Disposable disposable = this.e;
            if (disposable != null) {
                disposable.dispose();
            }
            this.e = this.g.applyPackage(contactAccessPackage.getUrl()).observeOn(this.a).subscribeOn(this.b).subscribe(new a(this), new b(this));
        }
    }

    @Override // com.avito.android.contact_access.ContactAccessPackagePresenter
    public void attachRouter(@Nullable ContactAccessPackageRouter contactAccessPackageRouter) {
        this.f = contactAccessPackageRouter;
    }

    @Override // com.avito.android.contact_access.ContactAccessPackagePresenter
    public void close() {
        ContactAccessPackageRouter contactAccessPackageRouter = this.f;
        if (contactAccessPackageRouter != null) {
            contactAccessPackageRouter.onClose();
        }
    }

    @Override // com.avito.android.contact_access.ContactAccessPackagePresenter
    public void detachRouter() {
        ContactAccessPackageRouter contactAccessPackageRouter = this.f;
        if (contactAccessPackageRouter != null) {
            contactAccessPackageRouter.onCancel();
        }
        this.f = null;
    }

    @Override // com.avito.android.contact_access.ContactAccessPackagePresenter
    public void onSaveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "state");
        bundle.putParcelable("key_cv_package", this.c);
    }

    @Override // com.avito.android.legacy_mvp.Presenter
    public void unsubscribe() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
        this.e = null;
    }

    public void subscribe(@NotNull ContactAccessPackageView contactAccessPackageView) {
        Intrinsics.checkNotNullParameter(contactAccessPackageView, "subscriber");
        this.d = contactAccessPackageView;
        ContactAccessPackage contactAccessPackage = this.c;
        if (contactAccessPackage == null) {
            if (contactAccessPackageView != null) {
                contactAccessPackageView.showProgress();
            }
            Disposable disposable = this.e;
            if (disposable != null) {
                disposable.dispose();
            }
            this.e = this.g.loadPackage().observeOn(this.a).subscribeOn(this.b).subscribe(new a2.a.a.h0.a(this), new a2.a.a.h0.b(this));
            return;
        }
        contactAccessPackageView.setContent(new PresentationCvPackageImpl(contactAccessPackage));
        contactAccessPackageView.hideProgress();
    }
}
