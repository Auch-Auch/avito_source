package com.avito.android.shop.write_seller;

import a2.a.a.s2.e.a;
import a2.a.a.s2.e.b;
import a2.g.r.g;
import android.os.Bundle;
import android.util.Patterns;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.util.CharSequencesKt;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010,\u001a\u00020)\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\bR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001eR\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001eR\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010\u001e¨\u0006@"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerPresenterImpl;", "Lcom/avito/android/shop/write_seller/WriteSellerPresenter;", "Lcom/avito/android/shop/write_seller/WriteSellerView;", "view", "", "attachView", "(Lcom/avito/android/shop/write_seller/WriteSellerView;)V", "detachView", "()V", "Lcom/avito/android/shop/write_seller/WriteSellerRouter;", "router", "attachRouter", "(Lcom/avito/android/shop/write_seller/WriteSellerRouter;)V", "detachRouter", "Landroid/os/Bundle;", "state", "onSaveState", "(Landroid/os/Bundle;)V", "onSendClicked", "onBackClicked", "", "name", "onNameEntered", "(Ljava/lang/String;)V", "email", "onEmailEntered", "message", "onMessageEntered", "onProgressDialogCanceled", g.a, "Ljava/lang/String;", "shopId", "Lcom/avito/android/util/Formatter;", "", "k", "Lcom/avito/android/util/Formatter;", "errorFormatter", AuthSource.BOOKING_ORDER, "Lcom/avito/android/shop/write_seller/WriteSellerView;", "c", "Lcom/avito/android/shop/write_seller/WriteSellerRouter;", "Lcom/avito/android/shop/write_seller/WriteSellerPresenterResourceProvider;", "j", "Lcom/avito/android/shop/write_seller/WriteSellerPresenterResourceProvider;", "resourceProvider", "d", "Lcom/avito/android/shop/write_seller/WriteSellerInteractor;", "h", "Lcom/avito/android/shop/write_seller/WriteSellerInteractor;", "interactor", "f", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "e", "Lcom/avito/android/remote/model/ProfileInfo;", "profileInfo", "<init>", "(Ljava/lang/String;Lcom/avito/android/shop/write_seller/WriteSellerInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/shop/write_seller/WriteSellerPresenterResourceProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/remote/model/ProfileInfo;Landroid/os/Bundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class WriteSellerPresenterImpl implements WriteSellerPresenter {
    public Disposable a;
    public WriteSellerView b;
    public WriteSellerRouter c;
    public String d;
    public String e;
    public String f;
    public final String g;
    public final WriteSellerInteractor h;
    public final SchedulersFactory3 i;
    public final WriteSellerPresenterResourceProvider j;
    public final Formatter<Throwable> k;

    public WriteSellerPresenterImpl(@NotNull String str, @NotNull WriteSellerInteractor writeSellerInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull WriteSellerPresenterResourceProvider writeSellerPresenterResourceProvider, @NotNull Formatter<Throwable> formatter, @Nullable ProfileInfo profileInfo, @Nullable Bundle bundle) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(writeSellerInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(writeSellerPresenterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        this.g = str;
        this.h = writeSellerInteractor;
        this.i = schedulersFactory3;
        this.j = writeSellerPresenterResourceProvider;
        this.k = formatter;
        String str4 = "";
        String str5 = null;
        if (bundle == null || (str2 = bundle.getString("presenter_name_key")) == null) {
            str2 = profileInfo != null ? profileInfo.getName() : null;
            if (str2 == null) {
                str2 = str4;
            }
        }
        Intrinsics.checkNotNullExpressionValue(str2, "state?.getString(NAME_KE…ofileInfo?.name.orEmpty()");
        this.d = str2;
        if (bundle == null || (str3 = bundle.getString("presenter_email_key")) == null) {
            str3 = profileInfo != null ? profileInfo.getEmail() : null;
            if (str3 == null) {
                str3 = str4;
            }
        }
        Intrinsics.checkNotNullExpressionValue(str3, "state?.getString(EMAIL_K…fileInfo?.email.orEmpty()");
        this.e = str3;
        str5 = bundle != null ? bundle.getString("presenter_message_key") : str5;
        this.f = str5 != null ? str5 : str4;
    }

    public static final void access$onError(WriteSellerPresenterImpl writeSellerPresenterImpl, Throwable th) {
        WriteSellerView writeSellerView = writeSellerPresenterImpl.b;
        if (writeSellerView != null) {
            writeSellerView.hideProgress();
        }
        WriteSellerView writeSellerView2 = writeSellerPresenterImpl.b;
        if (writeSellerView2 != null) {
            writeSellerView2.showMessage(writeSellerPresenterImpl.k.format(th));
        }
    }

    public static final void access$onSuccess(WriteSellerPresenterImpl writeSellerPresenterImpl) {
        WriteSellerView writeSellerView = writeSellerPresenterImpl.b;
        if (writeSellerView != null) {
            writeSellerView.hideProgress();
        }
        WriteSellerView writeSellerView2 = writeSellerPresenterImpl.b;
        if (writeSellerView2 != null) {
            writeSellerView2.hideKeyboard();
        }
        WriteSellerView writeSellerView3 = writeSellerPresenterImpl.b;
        if (writeSellerView3 != null) {
            writeSellerView3.showMessage(writeSellerPresenterImpl.j.getMessageSuccessfullySent());
        }
        WriteSellerRouter writeSellerRouter = writeSellerPresenterImpl.c;
        if (writeSellerRouter != null) {
            writeSellerRouter.closeScreen();
        }
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenter
    public void attachRouter(@NotNull WriteSellerRouter writeSellerRouter) {
        Intrinsics.checkNotNullParameter(writeSellerRouter, "router");
        this.c = writeSellerRouter;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenter
    public void attachView(@NotNull WriteSellerView writeSellerView) {
        Intrinsics.checkNotNullParameter(writeSellerView, "view");
        this.b = writeSellerView;
        writeSellerView.setToolbar(this.j.getWriteEmail(), this.j.getIcAbBackNormal());
        WriteSellerView writeSellerView2 = this.b;
        if (writeSellerView2 != null) {
            writeSellerView2.setNameInputValue(this.d);
        }
        WriteSellerView writeSellerView3 = this.b;
        if (writeSellerView3 != null) {
            writeSellerView3.setEmailInputValue(this.e);
        }
        WriteSellerView writeSellerView4 = this.b;
        if (writeSellerView4 != null) {
            writeSellerView4.setMessageInputValue(this.f);
        }
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenter
    public void detachView() {
        this.b = null;
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = null;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView.Callback
    public void onBackClicked() {
        WriteSellerView writeSellerView = this.b;
        if (writeSellerView != null) {
            writeSellerView.hideKeyboard();
        }
        WriteSellerRouter writeSellerRouter = this.c;
        if (writeSellerRouter != null) {
            writeSellerRouter.closeScreen();
        }
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView.Callback
    public void onEmailEntered(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        this.e = str;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView.Callback
    public void onMessageEntered(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.f = str;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView.Callback
    public void onNameEntered(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.d = str;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView.Callback
    public void onProgressDialogCanceled() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = null;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenter
    public void onSaveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "state");
        bundle.putString("presenter_name_key", this.d);
        bundle.putString("presenter_email_key", this.e);
        bundle.putString("presenter_message_key", this.f);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerView.Callback
    public void onSendClicked() {
        boolean z;
        boolean z2 = false;
        boolean z3 = true;
        if (m.isBlank(this.d)) {
            WriteSellerView writeSellerView = this.b;
            if (writeSellerView != null) {
                writeSellerView.highlightNameError("");
            }
            z = true;
        } else {
            z = false;
        }
        if (m.isBlank(this.f)) {
            WriteSellerView writeSellerView2 = this.b;
            if (writeSellerView2 != null) {
                writeSellerView2.highlightMessageError("");
            }
            z = true;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(this.e).matches()) {
            WriteSellerView writeSellerView3 = this.b;
            if (writeSellerView3 != null) {
                writeSellerView3.highlightEmailError(this.j.getInputCorrectEmail());
            }
            z = true;
        }
        if (CharSequencesKt.getTrimmedLength(this.f) >= this.j.getFeedbackEmailMaxLength()) {
            z2 = true;
        }
        if (z2) {
            WriteSellerView writeSellerView4 = this.b;
            if (writeSellerView4 != null) {
                writeSellerView4.highlightMessageError(this.j.getExceedingMessageLengthError());
            }
        } else {
            z3 = z;
        }
        if (!z3 && this.a == null) {
            WriteSellerView writeSellerView5 = this.b;
            if (writeSellerView5 != null) {
                writeSellerView5.showProgress();
            }
            this.a = this.h.sendShopFeedback(this.g, this.d, this.e, this.f).subscribeOn(this.i.io()).observeOn(this.i.mainThread()).subscribe(new a(this), new b(this));
        }
    }
}
