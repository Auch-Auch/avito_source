package com.avito.android.authorization.select_social.adapter;

import com.avito.android.authorization.select_social.adapter.SelectSocialField;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/select_social/adapter/SocialItemPresenterImpl;", "Lcom/avito/android/authorization/select_social/adapter/SocialItemPresenter;", "Lcom/avito/android/authorization/select_social/adapter/SocialItemView;", "view", "Lcom/avito/android/authorization/select_social/adapter/SelectSocialField$Social;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/authorization/select_social/adapter/SocialItemView;Lcom/avito/android/authorization/select_social/adapter/SelectSocialField$Social;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/authorization/select_social/adapter/SelectSocialField;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clickConsumer", "<init>", "(Lcom/jakewharton/rxrelay2/PublishRelay;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SocialItemPresenterImpl implements SocialItemPresenter {
    public final PublishRelay<SelectSocialField> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ SocialItemPresenterImpl a;
        public final /* synthetic */ SelectSocialField.Social b;

        public a(SocialItemPresenterImpl socialItemPresenterImpl, SelectSocialField.Social social) {
            this.a = socialItemPresenterImpl;
            this.b = social;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay2.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(this.b);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SocialItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SocialItemView socialItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = socialItemView;
            this.b = compositeDisposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.clear();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SocialItemPresenterImpl(@NotNull PublishRelay<SelectSocialField> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "clickConsumer");
        this.a = publishRelay;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.authorization.select_social.adapter.SocialItemView r3, @org.jetbrains.annotations.NotNull com.avito.android.authorization.select_social.adapter.SelectSocialField.Social r4, int r5) {
        /*
            r2 = this;
            java.lang.String r5 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            com.avito.android.remote.model.registration.ProfileSocial r5 = r4.getSocial()
            java.lang.String r5 = r5.getTitle()
            r3.bindText(r5)
            com.avito.android.remote.model.registration.ProfileSocial r5 = r4.getSocial()
            java.lang.String r5 = r5.getType()
            int r0 = r5.hashCode()
            r1 = 3260(0xcbc, float:4.568E-42)
            if (r0 == r1) goto L_0x0063
            r1 = 3305(0xce9, float:4.631E-42)
            if (r0 == r1) goto L_0x0058
            r1 = 3548(0xddc, float:4.972E-42)
            if (r0 == r1) goto L_0x004d
            r1 = 3765(0xeb5, float:5.276E-42)
            if (r0 == r1) goto L_0x0042
            r1 = 93029210(0x58b835a, float:1.3119748E-35)
            if (r0 == r1) goto L_0x0037
            goto L_0x006e
        L_0x0037:
            java.lang.String r0 = "apple"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x006e
            com.avito.android.component.info_block_verification.ConnectionLabel r5 = com.avito.android.component.info_block_verification.ConnectionLabel.APPLE
            goto L_0x006f
        L_0x0042:
            java.lang.String r0 = "vk"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x006e
            com.avito.android.component.info_block_verification.ConnectionLabel r5 = com.avito.android.component.info_block_verification.ConnectionLabel.VK
            goto L_0x006f
        L_0x004d:
            java.lang.String r0 = "ok"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x006e
            com.avito.android.component.info_block_verification.ConnectionLabel r5 = com.avito.android.component.info_block_verification.ConnectionLabel.OK
            goto L_0x006f
        L_0x0058:
            java.lang.String r0 = "gp"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x006e
            com.avito.android.component.info_block_verification.ConnectionLabel r5 = com.avito.android.component.info_block_verification.ConnectionLabel.GOOGLE_PLUS
            goto L_0x006f
        L_0x0063:
            java.lang.String r0 = "fb"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x006e
            com.avito.android.component.info_block_verification.ConnectionLabel r5 = com.avito.android.component.info_block_verification.ConnectionLabel.FACEBOOK
            goto L_0x006f
        L_0x006e:
            r5 = 0
        L_0x006f:
            if (r5 == 0) goto L_0x0076
            int r5 = r5.getImageRes()
            goto L_0x0077
        L_0x0076:
            r5 = 0
        L_0x0077:
            r3.setIcon(r5)
            io.reactivex.disposables.CompositeDisposable r5 = new io.reactivex.disposables.CompositeDisposable
            r5.<init>()
            com.avito.android.authorization.select_social.adapter.SocialItemPresenterImpl$b r0 = new com.avito.android.authorization.select_social.adapter.SocialItemPresenterImpl$b
            r0.<init>(r3, r5)
            r3.setUnbindListener(r0)
            io.reactivex.Observable r3 = r3.clicks()
            com.avito.android.authorization.select_social.adapter.SocialItemPresenterImpl$a r0 = new com.avito.android.authorization.select_social.adapter.SocialItemPresenterImpl$a
            r0.<init>(r2, r4)
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r0)
            java.lang.String r4 = "clicks().subscribe {\n   …ccept(item)\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.select_social.adapter.SocialItemPresenterImpl.bindView(com.avito.android.authorization.select_social.adapter.SocialItemView, com.avito.android.authorization.select_social.adapter.SelectSocialField$Social, int):void");
    }
}
