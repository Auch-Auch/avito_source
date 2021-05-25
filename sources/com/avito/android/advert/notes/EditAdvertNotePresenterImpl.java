package com.avito.android.advert.notes;

import a2.a.a.f.y.e;
import a2.a.a.f.y.f;
import a2.a.a.f.y.i;
import a2.a.a.f.y.j;
import a2.a.a.f.y.k;
import a2.g.r.g;
import com.avito.android.advert.notes.EditAdvertNotePresenter;
import com.avito.android.advert.notes.di.AdvertDetailsNoteModule;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BI\b\u0007\u0012\b\b\u0001\u0010#\u001a\u00020\u001a\u0012\b\b\u0001\u0010)\u001a\u00020\u001a\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0001\u00101\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b2\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010%\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001cR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0010¨\u00064"}, d2 = {"Lcom/avito/android/advert/notes/EditAdvertNotePresenterImpl;", "Lcom/avito/android/advert/notes/EditAdvertNotePresenter;", "Lcom/avito/android/advert/notes/EditAdvertNoteView;", "view", "", "attachView", "(Lcom/avito/android/advert/notes/EditAdvertNoteView;)V", "detachView", "()V", "Lcom/avito/android/advert/notes/EditAdvertNotePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/notes/EditAdvertNotePresenter$Router;)V", "detachRouter", "", "l", "Z", "isFavorite", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "j", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoriteInteractor", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", "e", "Ljava/lang/String;", "newNote", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposableFavorite", "f", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.SEND_ABUSE, "disposableView", "d", "Lcom/avito/android/advert/notes/EditAdvertNotePresenter$Router;", g.a, "currentNote", "Lcom/avito/android/advert/notes/EditAdvertNoteInteractor;", "h", "Lcom/avito/android/advert/notes/EditAdvertNoteInteractor;", "interactor", "c", "Lcom/avito/android/advert/notes/EditAdvertNoteView;", "k", "isRestored", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert/notes/EditAdvertNoteInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/favorite/FavoriteAdvertsInteractor;ZZ)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class EditAdvertNotePresenterImpl implements EditAdvertNotePresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    public EditAdvertNoteView c;
    public EditAdvertNotePresenter.Router d;
    public String e;
    public final String f;
    public final String g;
    public final EditAdvertNoteInteractor h;
    public final SchedulersFactory3 i;
    public final FavoriteAdvertsInteractor j;
    public final boolean k;
    public final boolean l;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UpdateAdvertNoteResult.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
        }
    }

    @Inject
    public EditAdvertNotePresenterImpl(@AdvertDetailsNoteModule.AdvertId @NotNull String str, @AdvertDetailsNoteModule.AdvertNote @NotNull String str2, @NotNull EditAdvertNoteInteractor editAdvertNoteInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @AdvertDetailsNoteModule.IsRestored boolean z, @AdvertDetailsNoteModule.IsFavorite boolean z2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "currentNote");
        Intrinsics.checkNotNullParameter(editAdvertNoteInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "favoriteInteractor");
        this.f = str;
        this.g = str2;
        this.h = editAdvertNoteInteractor;
        this.i = schedulersFactory3;
        this.j = favoriteAdvertsInteractor;
        this.k = z;
        this.l = z2;
    }

    public static void a(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl, String str, boolean z, int i2) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            z = !Intrinsics.areEqual(editAdvertNotePresenterImpl.g, str);
        }
        EditAdvertNotePresenter.Router router = editAdvertNotePresenterImpl.d;
        if (router != null) {
            router.closeScreen(str, z);
        }
    }

    public static final boolean access$isDataChanged(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl, String str) {
        return !Intrinsics.areEqual(editAdvertNotePresenterImpl.g, str);
    }

    public static final void access$saveNote(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl, String str) {
        CompositeDisposable compositeDisposable = editAdvertNotePresenterImpl.a;
        Disposable subscribe = editAdvertNotePresenterImpl.h.updateNote(editAdvertNotePresenterImpl.f, str, m.isBlank(editAdvertNotePresenterImpl.g)).observeOn(editAdvertNotePresenterImpl.i.mainThread()).subscribe(new e(editAdvertNotePresenterImpl, str), new f(editAdvertNotePresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.updateNote(ad…}, { view?.showError() })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$updateFavoriteState(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl, String str) {
        CompositeDisposable compositeDisposable = editAdvertNotePresenterImpl.b;
        Disposable subscribe = editAdvertNotePresenterImpl.j.isFavorite(editAdvertNotePresenterImpl.f, editAdvertNotePresenterImpl.l).flatMap(new i(editAdvertNotePresenterImpl)).observeOn(editAdvertNotePresenterImpl.i.mainThread()).subscribe(new j(editAdvertNotePresenterImpl, str), k.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "favoriteInteractor.isFav… }, { /* do nothing */ })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert.notes.EditAdvertNotePresenter
    public void attachRouter(@NotNull EditAdvertNotePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.d = router;
    }

    @Override // com.avito.android.advert.notes.EditAdvertNotePresenter
    public void attachView(@NotNull EditAdvertNoteView editAdvertNoteView) {
        Intrinsics.checkNotNullParameter(editAdvertNoteView, "view");
        this.c = editAdvertNoteView;
        if (editAdvertNoteView != null) {
            CompositeDisposable compositeDisposable = this.a;
            Intrinsics.checkNotNull(editAdvertNoteView);
            Disposable subscribe = editAdvertNoteView.getNavigationClick().observeOn(this.i.mainThread()).subscribe(new a2.a.a.f.y.g(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "view!!.navigationClick\n …          }\n            }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            EditAdvertNoteView editAdvertNoteView2 = this.c;
            if (editAdvertNoteView2 != null) {
                CompositeDisposable compositeDisposable2 = this.a;
                Intrinsics.checkNotNull(editAdvertNoteView2);
                Disposable subscribe2 = editAdvertNoteView2.getTextChanged().observeOn(this.i.mainThread()).doOnNext(new s3(0, this)).subscribe(new s3(1, this));
                Intrinsics.checkNotNullExpressionValue(subscribe2, "view!!.textChanged\n     …hanged(it))\n            }");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
                editAdvertNoteView.showKeyboard();
                if (!this.k) {
                    editAdvertNoteView.showData(this.g);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("View is null".toString());
        }
        throw new IllegalArgumentException("View is null".toString());
    }

    @Override // com.avito.android.advert.notes.EditAdvertNotePresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.advert.notes.EditAdvertNotePresenter
    public void detachView() {
        this.a.clear();
        this.b.clear();
        this.c = null;
    }
}
