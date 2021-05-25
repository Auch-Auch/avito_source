package com.avito.android.social;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.SignInManager;
import com.avito.android.social.SocialActivityPresenter;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f\u0012\b\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/avito/android/social/SocialActivityPresenterImpl;", "Lcom/avito/android/social/SocialActivityPresenter;", "Lcom/avito/android/social/SocialActivityPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/social/SocialActivityPresenter$Router;)V", "detachRouter", "()V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "Lcom/avito/android/social/SocialType;", "type", "login", "(Lcom/avito/android/social/SocialType;)V", "logout", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)Z", "Lcom/avito/android/social/SignInManager$Result;", "result", "Lcom/avito/android/social/SignInManager;", "signInManager", AuthSource.SEND_ABUSE, "(Lcom/avito/android/social/SignInManager$Result;Lcom/avito/android/social/SignInManager;)Lkotlin/Unit;", "", "c", "Ljava/util/List;", "getSignInManagers", "()Ljava/util/List;", "signInManagers", "Lcom/avito/android/social/SocialActivityPresenter$Router;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/social/SocialType;", "socialType", "state", "<init>", "(Ljava/util/List;Landroid/os/Bundle;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class SocialActivityPresenterImpl implements SocialActivityPresenter {
    public SocialActivityPresenter.Router a;
    public SocialType b;
    @NotNull
    public final List<SignInManager> c;

    public static final class a extends Lambda implements Function1<SignInManager.Result, Unit> {
        public final /* synthetic */ SignInManager a;
        public final /* synthetic */ SocialActivityPresenterImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SignInManager signInManager, SocialActivityPresenterImpl socialActivityPresenterImpl, int i, int i2, Intent intent) {
            super(1);
            this.a = signInManager;
            this.b = socialActivityPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignInManager.Result result) {
            SignInManager.Result result2 = result;
            Intrinsics.checkNotNullParameter(result2, "it");
            this.b.a(result2, this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<SignInManager.Result, Unit> {
        public final /* synthetic */ SocialActivityPresenterImpl a;
        public final /* synthetic */ SignInManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SocialActivityPresenterImpl socialActivityPresenterImpl, SignInManager signInManager) {
            super(1);
            this.a = socialActivityPresenterImpl;
            this.b = signInManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignInManager.Result result) {
            SignInManager.Result result2 = result;
            Intrinsics.checkNotNullParameter(result2, "it");
            this.a.a(result2, this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.social.SignInManager> */
    /* JADX WARN: Multi-variable type inference failed */
    public SocialActivityPresenterImpl(@NotNull List<? extends SignInManager> list, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(list, "signInManagers");
        this.c = list;
        this.b = (SocialType) (bundle != null ? bundle.getSerializable(SocialActivity.SOCIAL_TYPE_PARAM) : null);
    }

    public final Unit a(SignInManager.Result result, SignInManager signInManager) {
        if (result instanceof SignInManager.Result.Success) {
            String token = signInManager.getToken();
            String email = signInManager.getEmail();
            if (token == null || token.length() == 0) {
                a(SignInManager.Result.Error.INSTANCE, signInManager);
            } else if (signInManager instanceof AppleSignInManager) {
                SocialActivityPresenter.Router router = this.a;
                if (router != null) {
                    router.leaveScreenWithSuccess(signInManager.getType(), token, email, ((AppleSignInManager) signInManager).getUser());
                }
            } else {
                SocialActivityPresenter.Router router2 = this.a;
                if (router2 != null) {
                    SocialActivityPresenter.Router.DefaultImpls.leaveScreenWithSuccess$default(router2, signInManager.getType(), token, email, null, 8, null);
                }
            }
            return Unit.INSTANCE;
        } else if (result instanceof SignInManager.Result.Error) {
            SocialActivityPresenter.Router router3 = this.a;
            if (router3 == null) {
                return null;
            }
            router3.leaveScreenWithError(signInManager.getType());
            return Unit.INSTANCE;
        } else if (result instanceof SignInManager.Result.Cancel) {
            SocialActivityPresenter.Router router4 = this.a;
            if (router4 == null) {
                return null;
            }
            router4.leaveScreen(signInManager.getType());
            return Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.social.SocialActivityPresenter
    public void attachRouter(@NotNull SocialActivityPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    @Override // com.avito.android.social.SocialActivityPresenter
    public void detachRouter() {
        this.a = null;
        for (T t : this.c) {
            if (!(t instanceof Closeable)) {
                t = null;
            }
            T t2 = t;
            if (t2 != null) {
                t2.close();
            }
        }
    }

    @NotNull
    public final List<SignInManager> getSignInManagers() {
        return this.c;
    }

    @Override // com.avito.android.social.SocialActivityPresenter
    public boolean handleActivityResult(int i, int i2, @Nullable Intent intent) {
        for (T t : this.c) {
            if (t.handleActivityResult(i, i2, intent, new a(t, this, i, i2, intent))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.social.SocialActivityPresenter
    public void login(@NotNull SocialType socialType) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(socialType, "type");
        Iterator<T> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getType() == socialType) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            this.b = t2.getType();
            SocialActivityPresenter.Router router = this.a;
            if (router != null) {
                router.login(t2, new b(this, t2));
            }
        }
    }

    @Override // com.avito.android.social.SocialActivityPresenter
    public void logout(@NotNull SocialType socialType) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(socialType, "type");
        Iterator<T> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getType() == socialType) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            t2.logout();
        }
    }

    @Override // com.avito.android.social.SocialActivityPresenter
    @NotNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(SocialActivity.SOCIAL_TYPE_PARAM, this.b);
        return bundle;
    }
}
