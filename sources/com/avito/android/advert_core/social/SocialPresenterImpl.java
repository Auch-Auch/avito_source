package com.avito.android.advert_core.social;

import a2.a.a.g.n.a;
import a2.a.a.g.n.b;
import a2.g.r.g;
import com.avito.android.advert_core.social.SocialPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertSharing;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInSocialManager;
import com.avito.android.social.SocialType;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social.button.SocialButton;
import com.avito.android.social.button.SocialInfo;
import com.avito.android.social.button.SocialInfoProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e00\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ#\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\fJ!\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J!\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001eH\u0002¢\u0006\u0004\b$\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010&R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/avito/android/advert_core/social/SocialPresenterImpl;", "Lcom/avito/android/advert_core/social/SocialPresenter;", "Lcom/avito/android/advert_core/social/SocialView;", "view", "", "attachView", "(Lcom/avito/android/advert_core/social/SocialView;)V", "Lcom/avito/android/advert_core/social/SocialPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert_core/social/SocialPresenter$Router;)V", "detachRouter", "()V", "detachView", "", "type", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "onSocialLoginResult", "(Ljava/lang/String;Ljava/lang/String;)V", "onSocialLoginError", "Lcom/avito/android/remote/model/AdvertSharing;", "sharing", "", "isRoundButtons", "setSharing", "(Lcom/avito/android/remote/model/AdvertSharing;Z)V", "Lcom/avito/android/advert_core/social/SocialShareListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInstantShareListener", "(Lcom/avito/android/advert_core/social/SocialShareListener;)V", "Lcom/avito/android/social/SharingManager;", "socialManager", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/social/SharingManager;)V", "advertSharing", "sharingManager", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/AdvertSharing;Lcom/avito/android/social/SharingManager;)Ljava/lang/String;", "Lcom/avito/android/advert_core/social/SocialView;", "Lcom/avito/android/remote/model/AdvertSharing;", "Lcom/avito/android/social/SocialTypeToStringMapper;", "h", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "", "e", "Ljava/util/List;", "sharingManagers", "c", "Lcom/avito/android/advert_core/social/SocialPresenter$Router;", "d", "Lcom/avito/android/advert_core/social/SocialShareListener;", "shareListener", "Lcom/avito/android/social/button/SocialInfoProvider;", "f", "Lcom/avito/android/social/button/SocialInfoProvider;", "socialInfoProvider", "<init>", "(Ljava/util/List;Lcom/avito/android/social/button/SocialInfoProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/social/SocialTypeToStringMapper;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SocialPresenterImpl implements SocialPresenter {
    public AdvertSharing a;
    public SocialView b;
    public SocialPresenter.Router c;
    public SocialShareListener d;
    public final List<SharingManager> e;
    public final SocialInfoProvider f;
    public final Analytics g;
    public final SocialTypeToStringMapper h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SocialType.values();
            int[] iArr = new int[9];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
            iArr[4] = 4;
            iArr[5] = 5;
            iArr[6] = 6;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.social.SharingManager> */
    /* JADX WARN: Multi-variable type inference failed */
    public SocialPresenterImpl(@NotNull List<? extends SharingManager> list, @NotNull SocialInfoProvider socialInfoProvider, @NotNull Analytics analytics, @NotNull SocialTypeToStringMapper socialTypeToStringMapper) {
        Intrinsics.checkNotNullParameter(list, "sharingManagers");
        Intrinsics.checkNotNullParameter(socialInfoProvider, "socialInfoProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper, "socialTypeToStringMapper");
        this.e = list;
        this.f = socialInfoProvider;
        this.g = analytics;
        this.h = socialTypeToStringMapper;
    }

    public static final void access$shareWithLogin(SocialPresenterImpl socialPresenterImpl, SignInSocialManager signInSocialManager) {
        Objects.requireNonNull(socialPresenterImpl);
        if (signInSocialManager.hasToken()) {
            socialPresenterImpl.b(signInSocialManager);
            SocialShareListener socialShareListener = socialPresenterImpl.d;
            if (socialShareListener != null) {
                socialShareListener.onSocialShare(signInSocialManager, true);
                return;
            }
            return;
        }
        SocialPresenter.Router router = socialPresenterImpl.c;
        if (router != null) {
            router.login(signInSocialManager);
        }
    }

    public final String a(AdvertSharing advertSharing, SharingManager sharingManager) {
        int ordinal = sharingManager.getType().ordinal();
        if (ordinal == 0) {
            return advertSharing.getFacebook();
        }
        if (ordinal == 2) {
            return advertSharing.getLiveJournal();
        }
        if (ordinal == 3) {
            return advertSharing.getMyMail();
        }
        if (ordinal == 4) {
            return advertSharing.getOdnoklassniki();
        }
        if (ordinal == 5) {
            return advertSharing.getTwitter();
        }
        if (ordinal != 6) {
            return null;
        }
        return advertSharing.getVkontakte();
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter
    public void attachRouter(@NotNull SocialPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter
    public void attachView(@NotNull SocialView socialView) {
        Intrinsics.checkNotNullParameter(socialView, "view");
        this.b = socialView;
    }

    public final void b(SharingManager sharingManager) {
        AdvertSharing advertSharing = this.a;
        if (advertSharing != null) {
            String a3 = a(advertSharing, sharingManager);
            if (a3 == null) {
                a3 = advertSharing.getUrl();
            }
            SocialPresenter.Router router = this.c;
            if (router != null) {
                router.share(sharingManager, a3, new a(this));
            }
        }
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter
    public void detachView() {
        this.b = null;
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter
    public void onSocialLoginError() {
        SocialView socialView = this.b;
        if (socialView != null) {
            socialView.showError();
        }
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter
    public void onSocialLoginResult(@Nullable String str, @Nullable String str2) {
        T t;
        boolean z;
        if (str == null || str2 == null) {
            SocialView socialView = this.b;
            if (socialView != null) {
                socialView.showError();
                return;
            }
            return;
        }
        SocialType mapToSocialType = this.h.mapToSocialType(str);
        Iterator<T> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getType() == mapToSocialType) {
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
            b(t2);
        }
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter
    public void setInstantShareListener(@Nullable SocialShareListener socialShareListener) {
        this.d = socialShareListener;
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter
    public void setSharing(@Nullable AdvertSharing advertSharing, boolean z) {
        if (advertSharing != null) {
            this.a = advertSharing;
            List<SharingManager> list = this.e;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                SocialInfo provide = this.f.provide(t, z);
                arrayList.add(new SocialButton(provide.getBackground(), provide.getIcon(), provide.getTintColor(), new b(t, this, z)));
            }
            SocialView socialView = this.b;
            if (socialView != null) {
                socialView.showButtons(arrayList);
            }
            List<SharingManager> list2 = this.e;
            ArrayList arrayList2 = new ArrayList();
            for (T t2 : list2) {
                T t3 = t2;
                SocialPresenter.Router router = this.c;
                if (router != null ? router.shouldRestoreShare(t3) : false) {
                    arrayList2.add(t2);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                SharingManager sharingManager = (SharingManager) it.next();
                AdvertSharing advertSharing2 = this.a;
                if (advertSharing2 != null) {
                    String a3 = a(advertSharing2, sharingManager);
                    if (a3 == null) {
                        a3 = advertSharing2.getUrl();
                    }
                    SocialPresenter.Router router2 = this.c;
                    if (router2 != null) {
                        router2.share(sharingManager, a3, new a(this));
                    }
                }
            }
        }
    }
}
