package com.avito.android.advert.item.sellerprofile;

import a2.g.r.g;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.avito.android.advert_details.R;
import com.avito.android.component.profile_snippet.AdvertSellerAvatarRenderer;
import com.avito.android.component.profile_snippet.ProfileSnippet;
import com.avito.android.component.profile_snippet.ProfileSnippetData;
import com.avito.android.component.profile_snippet.ProfileSnippetImpl;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SellerVerification;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020\u0012¢\u0006\u0004\b-\u0010.J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bRD\u0010\u0011\u001a0\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00030\u0003 \r*\u0017\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\f¢\u0006\u0002\b\u000e0\f¢\u0006\u0002\b\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0019\u001a\n \r*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u00020\u001e8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0013\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0014R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileViewImpl;", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;", "Lio/reactivex/rxjava3/core/Observable;", "", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/component/profile_snippet/ProfileSnippetData;", "data", "", "isClickable", "showProfileSnippet", "(Lcom/avito/android/component/profile_snippet/ProfileSnippetData;Z)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "f", "Lcom/jakewharton/rxrelay3/PublishRelay;", "profileShowRelay", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "sellerProfileSnippetRoot", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "Landroid/view/LayoutInflater;", "d", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", g.a, "Lkotlin/Lazy;", "()Landroid/view/ViewGroup;", "sellerSnippetContainer", "Lcom/avito/android/component/profile_snippet/AdvertSellerAvatarRenderer;", "e", "Lcom/avito/android/component/profile_snippet/AdvertSellerAvatarRenderer;", "avatarRenderer", "h", "sellerSnippetView", "Lcom/avito/android/component/profile_snippet/ProfileSnippet;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/component/profile_snippet/ProfileSnippet;", "profileSnippetView", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSellerProfileViewImpl implements AdvertSellerProfileView {
    public View a;
    public ProfileSnippet b;
    public final Context c;
    public final LayoutInflater d;
    public final AdvertSellerAvatarRenderer e = new AdvertSellerAvatarRenderer();
    public final PublishRelay<Unit> f = PublishRelay.create();
    public final Lazy g = c.lazy(new a(this));
    public final View h;

    public static final class a extends Lambda implements Function0<ViewGroup> {
        public final /* synthetic */ AdvertSellerProfileViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertSellerProfileViewImpl advertSellerProfileViewImpl) {
            super(0);
            this.a = advertSellerProfileViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewGroup invoke() {
            View view;
            if (this.a.h instanceof ViewStub) {
                View inflate = ((ViewStub) this.a.h).inflate();
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                view = (ViewGroup) inflate;
            } else {
                view = this.a.h;
            }
            View findViewById = view.findViewById(R.id.contacts_container);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            return (ViewGroup) findViewById;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertSellerProfileViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AdvertSellerProfileViewImpl advertSellerProfileViewImpl, ProfileSnippetData profileSnippetData, boolean z) {
            super(0);
            this.a = advertSellerProfileViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.f;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public AdvertSellerProfileViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "sellerSnippetView");
        this.h = view;
        Context context = view.getContext();
        this.c = context;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        this.d = from;
    }

    public final ViewGroup a() {
        return (ViewGroup) this.g.getValue();
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerProfileView
    @NotNull
    public Observable<Unit> profileClicks() {
        PublishRelay<Unit> publishRelay = this.f;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "profileShowRelay");
        return publishRelay;
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerProfileView
    public void showProfileSnippet(@NotNull ProfileSnippetData profileSnippetData, boolean z) {
        SellerVerification.VerificationItem internal;
        SellerVerification.VerificationItem external;
        Intrinsics.checkNotNullParameter(profileSnippetData, "data");
        int i = R.layout.advert_details_profile_snippet;
        View view = this.a;
        if (view == null) {
            view = this.d.inflate(i, a(), false);
        }
        this.a = view;
        ProfileSnippet profileSnippet = this.b;
        if (profileSnippet == null) {
            Intrinsics.checkNotNullExpressionValue(view, "sellerProfileSnippetRoot");
            profileSnippet = new ProfileSnippetImpl(view, this.e);
        }
        this.b = profileSnippet;
        profileSnippet.setTitle(profileSnippetData.getTitle());
        SellerVerification verification = profileSnippetData.getVerification();
        Picture picture = null;
        String title = (verification == null || (external = verification.getExternal()) == null) ? null : external.getTitle();
        if (title == null) {
            title = profileSnippetData.getSubtitle();
        }
        profileSnippet.setSubtitle(title);
        SellerVerification verification2 = profileSnippetData.getVerification();
        profileSnippet.setVerification((verification2 == null || (internal = verification2.getInternal()) == null) ? null : internal.getTitle());
        profileSnippet.setSummary(profileSnippetData.getSummary());
        ProfileSnippet.DefaultImpls.setContact$default(profileSnippet, profileSnippetData.getContactTitle(), null, 2, null);
        Image avatar = profileSnippetData.getAvatar();
        if (avatar != null) {
            picture = AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null);
        }
        profileSnippet.setAvatar(picture, profileSnippetData.getIconType());
        profileSnippet.setRating(profileSnippetData.getRatingScore(), true, profileSnippetData.getRatingText());
        if (z) {
            profileSnippet.setOnClickListener(new b(this, profileSnippetData, z));
        }
        if (a().getChildCount() == 0) {
            a().addView(view);
        }
    }
}
