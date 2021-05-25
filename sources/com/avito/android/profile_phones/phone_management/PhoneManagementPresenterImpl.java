package com.avito.android.profile_phones.phone_management;

import a2.a.a.c2.e.d;
import a2.a.a.c2.e.e;
import a2.a.a.c2.e.f;
import a2.a.a.c2.e.h;
import a2.g.r.g;
import com.avito.android.code_confirmation.CodeAlreadyConfirmedException;
import com.avito.android.code_confirmation.Source;
import com.avito.android.code_confirmation.di.CodeConfirmationSource;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenter;
import com.avito.android.profile_phones.phone_management.di.FromProfile;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Strings;
import com.avito.android.util.TypedResultException;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010K\u001a\u00020H\u0012\b\b\u0001\u0010E\u001a\u00020\u0019\u0012\b\b\u0001\u0010B\u001a\u00020\u0003\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bM\u0010NJ#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0016\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00198B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010.R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010&R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00038B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010&R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010&R\u0016\u0010E\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010G\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006O"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenterImpl;", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter;", "", "", "messages", "", AuthSource.BOOKING_ORDER, "(Ljava/util/Map;)V", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementView;", "view", "attachView", "(Lcom/avito/android/profile_phones/phone_management/PhoneManagementView;)V", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "phone", "onPhoneConfirmed", "(Ljava/lang/String;)V", "", "verified", "", "itemsCount", "setStartPhone", "(Ljava/lang/String;ZI)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile_phones/phone_management/PhoneManagementView;", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractor;", "k", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractor;", "interactor", "f", "Ljava/lang/String;", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "c", "()Z", "isAttachPhone", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter$Router;", "e", "startPhone", "h", "I", "i", "Ljava/util/Map;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementResourceProvider;", "l", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementResourceProvider;", "resourceProvider", "()Ljava/lang/String;", "src", "j", "confirmedPhone", "p", "source", "o", "Z", "isFromProfile", g.a, "disposables", "Lcom/avito/android/error_helper/ErrorHelper;", "n", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "state", "<init>", "(Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractor;Lcom/avito/android/profile_phones/phone_management/PhoneManagementResourceProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/error_helper/ErrorHelper;ZLjava/lang/String;Lcom/avito/android/util/Kundle;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneManagementPresenterImpl implements PhoneManagementPresenter {
    public PhoneManagementView a;
    public PhoneManagementPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public String e;
    public String f;
    public boolean g;
    public int h;
    public Map<String, String> i;
    public String j;
    public final PhoneManagementInteractor k;
    public final PhoneManagementResourceProvider l;
    public final SchedulersFactory m;
    public final ErrorHelper n;
    public final boolean o;
    public final String p;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ PhoneManagementPresenterImpl a;
        public final /* synthetic */ PhoneManagementView b;

        public a(PhoneManagementPresenterImpl phoneManagementPresenterImpl, PhoneManagementView phoneManagementView) {
            this.a = phoneManagementPresenterImpl;
            this.b = phoneManagementView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.b.hideKeyboard();
            PhoneManagementPresenterImpl.access$cancelScreen(this.a);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ PhoneManagementPresenterImpl a;

        public b(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
            this.a = phoneManagementPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            PhoneManagementPresenterImpl.access$onConfirmPhone(this.a);
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ PhoneManagementPresenterImpl a;

        public c(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
            this.a = phoneManagementPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            PhoneManagementPresenterImpl phoneManagementPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            phoneManagementPresenterImpl.f = str2;
            PhoneManagementPresenterImpl.access$checkButtonState(this.a);
        }
    }

    @Inject
    public PhoneManagementPresenterImpl(@NotNull PhoneManagementInteractor phoneManagementInteractor, @NotNull PhoneManagementResourceProvider phoneManagementResourceProvider, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorHelper errorHelper, @FromProfile boolean z, @CodeConfirmationSource @NotNull String str, @Nullable Kundle kundle) {
        Map<String, String> emptyMap;
        Integer num;
        Boolean bool;
        Intrinsics.checkNotNullParameter(phoneManagementInteractor, "interactor");
        Intrinsics.checkNotNullParameter(phoneManagementResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(str, "source");
        this.k = phoneManagementInteractor;
        this.l = phoneManagementResourceProvider;
        this.m = schedulersFactory;
        this.n = errorHelper;
        this.o = z;
        this.p = str;
        String str2 = null;
        String string = kundle != null ? kundle.getString("start_phone") : null;
        String str3 = "";
        this.e = string == null ? str3 : string;
        String string2 = kundle != null ? kundle.getString("phone") : null;
        this.f = string2 != null ? string2 : str3;
        int i2 = 0;
        this.g = (kundle == null || (bool = kundle.getBoolean("verified")) == null) ? false : bool.booleanValue();
        if (!(kundle == null || (num = kundle.getInt("items_count")) == null)) {
            i2 = num.intValue();
        }
        this.h = i2;
        this.i = (kundle == null || (emptyMap = kundle.getNonNullStringMap("messages")) == null) ? r.emptyMap() : emptyMap;
        this.j = kundle != null ? kundle.getString("confirmed_phone") : str2;
    }

    public static final void access$cancelScreen(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        PhoneManagementPresenter.Router router = phoneManagementPresenterImpl.b;
        if (router != null) {
            router.leaveScreen(false);
        }
    }

    public static final void access$checkButtonState(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        PhoneManagementView phoneManagementView = phoneManagementPresenterImpl.a;
        if (phoneManagementView != null) {
            phoneManagementView.setButtonEnabled(Strings.isPhone(phoneManagementPresenterImpl.f));
        }
    }

    public static final void access$clearFieldErrors(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        Objects.requireNonNull(phoneManagementPresenterImpl);
        phoneManagementPresenterImpl.i = r.emptyMap();
    }

    public static final void access$handleCodeRequested(PhoneManagementPresenterImpl phoneManagementPresenterImpl, CodeInfo codeInfo) {
        PhoneManagementPresenter.Router router = phoneManagementPresenterImpl.b;
        if (router != null) {
            router.openCodeConfirmation(phoneManagementPresenterImpl.f, codeInfo.getText(), codeInfo.getTimeout(), codeInfo.getLength(), phoneManagementPresenterImpl.a());
        }
    }

    public static final void access$handleRequestError(PhoneManagementPresenterImpl phoneManagementPresenterImpl, Throwable th) {
        List<Action> actions;
        Action action;
        PhoneManagementView phoneManagementView;
        Objects.requireNonNull(phoneManagementPresenterImpl);
        if (th instanceof CodeAlreadyConfirmedException) {
            phoneManagementPresenterImpl.onPhoneConfirmed(((CodeAlreadyConfirmedException) th).getInfo().getLogin());
        } else if (th instanceof TypedResultException) {
            TypedError errorResult = ((TypedResultException) th).getErrorResult();
            if (errorResult instanceof ErrorResult.IncorrectData) {
                phoneManagementPresenterImpl.b(((ErrorResult.IncorrectData) errorResult).getMessages());
            } else if (errorResult instanceof TypedError.ErrorMap) {
                phoneManagementPresenterImpl.b(((TypedError.ErrorMap) errorResult).getMessages());
            } else if (errorResult instanceof ErrorResult.ErrorDialog) {
                UserDialog userDialog = ((ErrorResult.ErrorDialog) errorResult).getUserDialog();
                if (userDialog.getActions() == null || (actions = userDialog.getActions()) == null || !(!actions.isEmpty())) {
                    PhoneManagementView phoneManagementView2 = phoneManagementPresenterImpl.a;
                    if (phoneManagementView2 != null) {
                        phoneManagementView2.showUserDialog(userDialog.getTitle(), userDialog.getMessage());
                        return;
                    }
                    return;
                }
                List<Action> actions2 = userDialog.getActions();
                if (actions2 != null && (action = (Action) CollectionsKt___CollectionsKt.first((List<? extends Object>) actions2)) != null && (phoneManagementView = phoneManagementPresenterImpl.a) != null) {
                    phoneManagementView.showUserDialog(userDialog.getTitle(), userDialog.getMessage(), action.getTitle(), new a2.a.a.c2.e.a(phoneManagementPresenterImpl, action), new a2.a.a.c2.e.b(phoneManagementPresenterImpl));
                }
            } else {
                PhoneManagementView phoneManagementView3 = phoneManagementPresenterImpl.a;
                if (phoneManagementView3 != null) {
                    phoneManagementView3.showError(phoneManagementPresenterImpl.n.recycle(errorResult));
                }
            }
        } else {
            PhoneManagementView phoneManagementView4 = phoneManagementPresenterImpl.a;
            if (phoneManagementView4 != null) {
                phoneManagementView4.showUnknownError();
            }
        }
    }

    public static final void access$handleRequestStarted(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        PhoneManagementView phoneManagementView = phoneManagementPresenterImpl.a;
        if (phoneManagementView != null) {
            phoneManagementView.hideKeyboard();
            phoneManagementView.showProgress();
            phoneManagementView.hidePhoneError();
        }
    }

    public static final void access$onConfirmPhone(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        CompositeDisposable compositeDisposable = phoneManagementPresenterImpl.c;
        Disposable subscribe = phoneManagementPresenterImpl.k.requestCode(phoneManagementPresenterImpl.f, phoneManagementPresenterImpl.a()).firstOrError().observeOn(phoneManagementPresenterImpl.m.mainThread()).doOnSubscribe(new a2.a.a.c2.e.c(phoneManagementPresenterImpl)).doOnTerminate(new d(phoneManagementPresenterImpl)).subscribe(new e(phoneManagementPresenterImpl), new f(phoneManagementPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.requestCode(p…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$onPhoneReplaced(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        PhoneManagementPresenter.Router router = phoneManagementPresenterImpl.b;
        if (router != null) {
            router.leaveScreen(true);
        }
    }

    public final String a() {
        boolean z = true;
        if ((this.p.length() > 0) && !this.o) {
            return this.p;
        }
        if ((this.p.length() == 0) && !this.o) {
            return Source.MESSENGER_PHONE_VERIFICATION;
        }
        if (this.e.length() != 0) {
            z = false;
        }
        return (!z || !this.o) ? Source.PHONE_CHANGE : Source.PHONE_ADD;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter
    public void attachRouter(@NotNull PhoneManagementPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        String str = this.j;
        if (str != null) {
            onPhoneConfirmed(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachView(@org.jetbrains.annotations.NotNull com.avito.android.profile_phones.phone_management.PhoneManagementView r4) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.a = r4
            if (r4 == 0) goto L_0x0091
            boolean r0 = r3.o
            if (r0 != 0) goto L_0x0036
            java.lang.String r0 = r3.e
            int r0 = r0.length()
            r1 = 0
            if (r0 <= 0) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = r3.f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0024
            r1 = 1
        L_0x0024:
            if (r1 == 0) goto L_0x0036
            r0 = 43
            java.lang.StringBuilder r0 = a2.b.a.a.a.I(r0)
            java.lang.String r1 = r3.e
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0038
        L_0x0036:
            java.lang.String r0 = r3.f
        L_0x0038:
            com.avito.android.profile_phones.phone_management.PhoneManagementView r1 = r3.a
            if (r1 == 0) goto L_0x003f
            r1.setPhone(r0)
        L_0x003f:
            int r0 = r3.h
            if (r0 <= 0) goto L_0x0050
            com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider r1 = r3.l
            java.lang.String r2 = r3.e
            java.lang.String r0 = r1.phoneUsedInAdverts(r2, r0)
            java.lang.String r1 = r3.e
            r4.showText(r0, r1)
        L_0x0050:
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.i
            r3.b(r0)
            com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider r0 = r3.l
            boolean r1 = r3.c()
            if (r1 == 0) goto L_0x0062
            java.lang.String r0 = r0.attachPhoneNumberTitle()
            goto L_0x0066
        L_0x0062:
            java.lang.String r0 = r0.replacePhoneNumberTitle()
        L_0x0066:
            r4.setTitle(r0)
            com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider r0 = r3.l
            boolean r1 = r3.c()
            if (r1 == 0) goto L_0x0076
            java.lang.String r0 = r0.phoneNumberHint()
            goto L_0x007a
        L_0x0076:
            java.lang.String r0 = r0.newPhoneNumberHint()
        L_0x007a:
            r4.setPhoneHint(r0)
            com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider r0 = r3.l
            boolean r1 = r3.c()
            if (r1 == 0) goto L_0x008a
            java.lang.String r0 = r0.attachButtonText()
            goto L_0x008e
        L_0x008a:
            java.lang.String r0 = r0.replaceButtonText()
        L_0x008e:
            r4.setButtonText(r0)
        L_0x0091:
            com.avito.android.profile_phones.phone_management.PhoneManagementView r0 = r3.a
            if (r0 == 0) goto L_0x009e
            java.lang.String r1 = r3.f
            boolean r1 = com.avito.android.util.Strings.isPhone(r1)
            r0.setButtonEnabled(r1)
        L_0x009e:
            io.reactivex.disposables.CompositeDisposable r0 = r3.d
            io.reactivex.Observable r1 = r4.navigationClicks()
            com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl$a r2 = new com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl$a
            r2.<init>(r3, r4)
            io.reactivex.disposables.Disposable r1 = r1.subscribe(r2)
            java.lang.String r2 = "view.navigationClicks().… cancelScreen()\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r0, r1)
            io.reactivex.disposables.CompositeDisposable r0 = r3.d
            io.reactivex.Observable r1 = r4.buttonClicks()
            com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl$b r2 = new com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl$b
            r2.<init>(r3)
            io.reactivex.disposables.Disposable r1 = r1.subscribe(r2)
            java.lang.String r2 = "view.buttonClicks().subscribe { onConfirmPhone() }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r0, r1)
            io.reactivex.disposables.CompositeDisposable r0 = r3.d
            io.reactivex.Observable r4 = r4.phoneChanges()
            com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl$c r1 = new com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl$c
            r1.<init>(r3)
            io.reactivex.disposables.Disposable r4 = r4.subscribe(r1)
            java.lang.String r1 = "view.phoneChanges().subs…ckButtonState()\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl.attachView(com.avito.android.profile_phones.phone_management.PhoneManagementView):void");
    }

    public final void b(Map<String, String> map) {
        PhoneManagementView phoneManagementView;
        this.i = map;
        if ((!map.isEmpty()) && (phoneManagementView = this.a) != null) {
            phoneManagementView.showPhoneError((String) CollectionsKt___CollectionsKt.first(map.values()));
        }
    }

    public final boolean c() {
        return (this.e.length() == 0) || !this.o;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter
    public void onPhoneConfirmed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.j = str;
        if (this.b != null) {
            this.j = null;
            if (c()) {
                PhoneManagementPresenter.Router router = this.b;
                if (router != null) {
                    router.leaveScreen(true);
                    return;
                }
                return;
            }
            String str2 = this.e;
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = this.k.replacePhone(str2, str).observeOn(this.m.mainThread()).doOnSubscribe(new a2.a.a.c2.e.g(this)).doOnTerminate(new x3(0, this)).subscribe(new x3(1, this), new h(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.replacePhone(…Error(it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("start_phone", this.e).putString("phone", this.f).putBoolean("verified", Boolean.valueOf(this.g)).putInt("items_count", Integer.valueOf(this.h)).putStringMap("messages", this.i).putString("confirmed_phone", this.j);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter
    public void setStartPhone(@NotNull String str, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.e = str;
        this.g = z;
        this.h = i2;
    }
}
