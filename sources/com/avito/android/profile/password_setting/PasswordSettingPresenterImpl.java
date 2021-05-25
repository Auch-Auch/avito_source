package com.avito.android.profile.password_setting;

import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.password_setting.PasswordSettingPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preference;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00106\u001a\u000203\u0012\b\u0010>\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/avito/android/profile/password_setting/PasswordSettingPresenterImpl;", "Lcom/avito/android/profile/password_setting/PasswordSettingPresenter;", "Lcom/avito/android/profile/password_setting/PasswordSettingView;", "view", "", "attachView", "(Lcom/avito/android/profile/password_setting/PasswordSettingView;)V", "detachView", "()V", "Lcom/avito/android/profile/password_setting/PasswordSettingPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/password_setting/PasswordSettingPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "resultCode", "onAuthResult", "(I)V", "", "c", "Z", "passwordHidden", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/password_setting/PasswordSettingPresenter$Router;", "d", "buttonEnabled", "Lio/reactivex/disposables/Disposable;", "h", "Lio/reactivex/disposables/Disposable;", "settingPasswordDisposable", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile/password_setting/PasswordSettingView;", "", "e", "Ljava/lang/String;", Preference.PASSWORD, "Lcom/avito/android/profile/password_setting/PasswordSettingInteractor;", "i", "Lcom/avito/android/profile/password_setting/PasswordSettingInteractor;", "interactor", "Lcom/avito/android/dialog/DialogPresenter;", "j", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lcom/avito/android/util/SchedulersFactory;", "k", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/error_helper/ErrorHelper;", "l", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "f", "Ljava/lang/Boolean;", "restoredButtonState", "Lio/reactivex/disposables/CompositeDisposable;", a2.g.r.g.a, "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "state", "<init>", "(Lcom/avito/android/profile/password_setting/PasswordSettingInteractor;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/util/Kundle;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordSettingPresenterImpl implements PasswordSettingPresenter {
    public PasswordSettingView a;
    public PasswordSettingPresenter.Router b;
    public boolean c;
    public boolean d;
    public String e;
    public Boolean f;
    public final CompositeDisposable g;
    public Disposable h;
    public final PasswordSettingInteractor i;
    public final DialogPresenter j;
    public final SchedulersFactory k;
    public final ErrorHelper l;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Boolean bool) {
            int i = this.a;
            if (i == 0) {
                Boolean bool2 = bool;
                Boolean bool3 = ((PasswordSettingPresenterImpl) this.b).f;
                if (bool3 != null) {
                    PasswordSettingPresenterImpl.access$setButtonEnabled((PasswordSettingPresenterImpl) this.b, bool3.booleanValue());
                    ((PasswordSettingPresenterImpl) this.b).f = null;
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(bool2, "it");
                PasswordSettingPresenterImpl.access$setButtonEnabled((PasswordSettingPresenterImpl) this.b, bool2.booleanValue());
            } else if (i == 1) {
                Boolean bool4 = bool;
                Intrinsics.checkNotNullExpressionValue(bool4, "isHidden");
                ((PasswordSettingView) this.b).setPasswordInputHidden(bool4.booleanValue());
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public static final b d = new b(2);
        public static final b e = new b(3);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else if (i == 2) {
                Logs.error(th);
            } else if (i == 3) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                PasswordSettingPresenterImpl passwordSettingPresenterImpl = (PasswordSettingPresenterImpl) this.b;
                passwordSettingPresenterImpl.c = !passwordSettingPresenterImpl.c;
            } else if (i == 1) {
                PasswordSettingPresenterImpl.access$onAddButtonClick((PasswordSettingPresenterImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class d<T, R> implements Function<String, Boolean> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            return Boolean.valueOf(str2.length() > 0);
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ PasswordSettingPresenterImpl a;
        public final /* synthetic */ PasswordSettingView b;

        public e(PasswordSettingPresenterImpl passwordSettingPresenterImpl, PasswordSettingView passwordSettingView) {
            this.a = passwordSettingPresenterImpl;
            this.b = passwordSettingView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.b.hideKeyboard();
            PasswordSettingPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen();
            }
        }
    }

    public static final class f<T, R> implements Function<Unit, Boolean> {
        public final /* synthetic */ PasswordSettingPresenterImpl a;

        public f(PasswordSettingPresenterImpl passwordSettingPresenterImpl) {
            this.a = passwordSettingPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Boolean.valueOf(this.a.c);
        }
    }

    public static final class g<T> implements Consumer<String> {
        public final /* synthetic */ PasswordSettingPresenterImpl a;

        public g(PasswordSettingPresenterImpl passwordSettingPresenterImpl) {
            this.a = passwordSettingPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            PasswordSettingPresenterImpl passwordSettingPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            passwordSettingPresenterImpl.e = str2;
        }
    }

    @Inject
    public PasswordSettingPresenterImpl(@NotNull PasswordSettingInteractor passwordSettingInteractor, @NotNull DialogPresenter dialogPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorHelper errorHelper, @Nullable Kundle kundle) {
        String str;
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(passwordSettingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        this.i = passwordSettingInteractor;
        this.j = dialogPresenter;
        this.k = schedulersFactory;
        this.l = errorHelper;
        this.c = (kundle == null || (bool2 = kundle.getBoolean("password_hidden")) == null) ? true : bool2.booleanValue();
        this.d = (kundle == null || (bool = kundle.getBoolean("button_enabled")) == null) ? false : bool.booleanValue();
        this.e = (kundle == null || (str = kundle.getString(Preference.PASSWORD)) == null) ? "" : str;
        this.f = kundle != null ? kundle.getBoolean("button_enabled") : null;
        this.g = new CompositeDisposable();
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.h = empty;
    }

    public static final void access$handleLoadingState(PasswordSettingPresenterImpl passwordSettingPresenterImpl, LoadingState loadingState) {
        PasswordSettingView passwordSettingView;
        Objects.requireNonNull(passwordSettingPresenterImpl);
        if (loadingState instanceof LoadingState.Loading) {
            PasswordSettingView passwordSettingView2 = passwordSettingPresenterImpl.a;
            if (passwordSettingView2 != null) {
                passwordSettingView2.showButtonProgress();
            }
        } else if (loadingState instanceof LoadingState.Loaded) {
            String text = ((PasswordChangeResult) ((LoadingState.Loaded) loadingState).getData()).getText();
            PasswordSettingView passwordSettingView3 = passwordSettingPresenterImpl.a;
            if (passwordSettingView3 != null) {
                passwordSettingView3.hideButtonProgress();
            }
            PasswordSettingView passwordSettingView4 = passwordSettingPresenterImpl.a;
            if (passwordSettingView4 != null) {
                passwordSettingView4.hideKeyboard();
            }
            PasswordSettingPresenter.Router router = passwordSettingPresenterImpl.b;
            if (router != null) {
                router.leaveWithSuccessMessage(text);
            }
        } else if (loadingState instanceof LoadingState.Error) {
            PasswordSettingView passwordSettingView5 = passwordSettingPresenterImpl.a;
            if (passwordSettingView5 != null) {
                passwordSettingView5.hideButtonProgress();
            }
            TypedError error = ((LoadingState.Error) loadingState).getError();
            if (error instanceof ErrorResult.IncorrectData) {
                PasswordSettingView passwordSettingView6 = passwordSettingPresenterImpl.a;
                if (passwordSettingView6 != null) {
                    passwordSettingView6.setButtonEnabled(false);
                }
                passwordSettingPresenterImpl.d = false;
                for (Map.Entry<String, String> entry : ((ErrorResult.IncorrectData) error).getMessages().entrySet()) {
                    String value = entry.getValue();
                    if (Intrinsics.areEqual(entry.getKey(), Preference.PASSWORD) && (passwordSettingView = passwordSettingPresenterImpl.a) != null) {
                        passwordSettingView.showPasswordError(value);
                    }
                }
            } else if (error instanceof ErrorResult.ErrorDialog) {
                UserDialog userDialog = ((ErrorResult.ErrorDialog) error).getUserDialog();
                CompositeDisposable compositeDisposable = passwordSettingPresenterImpl.g;
                Disposable subscribe = passwordSettingPresenterImpl.j.showDialog(userDialog).subscribe(new a2.a.a.b2.g1.d(passwordSettingPresenterImpl), a2.a.a.b2.g1.e.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…error(it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (error instanceof ErrorResult.Unauthorized) {
                PasswordSettingPresenter.Router router2 = passwordSettingPresenterImpl.b;
                if (router2 != null) {
                    router2.navigateToAuth();
                }
            } else if (error instanceof ErrorResult.Unauthenticated) {
                PasswordSettingPresenter.Router router3 = passwordSettingPresenterImpl.b;
                if (router3 != null) {
                    router3.navigateToAuth();
                }
            } else {
                PasswordSettingView passwordSettingView7 = passwordSettingPresenterImpl.a;
                if (passwordSettingView7 != null) {
                    passwordSettingView7.showSnackbar(passwordSettingPresenterImpl.l.recycle(error));
                }
            }
        }
    }

    public static final void access$onAddButtonClick(PasswordSettingPresenterImpl passwordSettingPresenterImpl) {
        passwordSettingPresenterImpl.h.dispose();
        Disposable subscribe = passwordSettingPresenterImpl.i.setPassword(passwordSettingPresenterImpl.e).observeOn(passwordSettingPresenterImpl.k.mainThread()).subscribe(new a2.a.a.b2.g1.b(passwordSettingPresenterImpl), new a2.a.a.b2.g1.c(passwordSettingPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.setPassword(p…ycle(it)) }\n            )");
        passwordSettingPresenterImpl.h = subscribe;
    }

    public static final void access$setButtonEnabled(PasswordSettingPresenterImpl passwordSettingPresenterImpl, boolean z) {
        PasswordSettingView passwordSettingView = passwordSettingPresenterImpl.a;
        if (passwordSettingView != null) {
            passwordSettingView.setButtonEnabled(z);
        }
        passwordSettingPresenterImpl.d = z;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter
    public void attachRouter(@NotNull PasswordSettingPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter
    public void attachView(@NotNull PasswordSettingView passwordSettingView) {
        Intrinsics.checkNotNullParameter(passwordSettingView, "view");
        this.a = passwordSettingView;
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = passwordSettingView.getNavigationClicks().subscribe(new e(this, passwordSettingView), b.c);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks\n  …error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.g;
        Disposable subscribe2 = passwordSettingView.getPasswordIconClicks().doOnNext(new c(0, this)).map(new f(this)).startWith((Observable<R>) ((R) Boolean.valueOf(this.c))).subscribe(new a(1, passwordSettingView), b.d);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.passwordIconClicks\n…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.g;
        Disposable subscribe3 = passwordSettingView.getButtonClicks().mergeWith(passwordSettingView.getActionDoneClicks()).subscribe(new c(1, this), b.e);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.buttonClicks.mergeW…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.g;
        Disposable subscribe4 = passwordSettingView.getPasswordChanges().doOnNext(new g(this)).distinctUntilChanged().map(d.a).subscribe(new a(0, this), b.b);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.passwordChanges\n   …error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        passwordSettingView.setButtonEnabled(this.d);
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter
    public void detachView() {
        PasswordSettingView passwordSettingView = this.a;
        if (passwordSettingView != null) {
            passwordSettingView.onDestroyView();
        }
        this.g.clear();
        this.a = null;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter
    public void onAuthResult(int i2) {
        PasswordSettingPresenter.Router router;
        if (i2 != -1 && (router = this.b) != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("password_hidden", Boolean.valueOf(this.c)).putBoolean("button_enabled", Boolean.valueOf(this.d)).putString(Preference.PASSWORD, this.e);
    }
}
