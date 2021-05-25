package com.avito.android.serp.adapter.warning;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/warning/SerpWarningItemPresenterImpl;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemPresenter;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemView;", "view", "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/warning/SerpWarningItemView;Lcom/avito/android/serp/adapter/warning/SerpWarningItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpWarningItemPresenterImpl implements SerpWarningItemPresenter {
    public final Lazy<SerpWarningItemListener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Action a;
        public final /* synthetic */ SerpWarningItemPresenterImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Action action, SerpWarningItemPresenterImpl serpWarningItemPresenterImpl) {
            super(0);
            this.a = action;
            this.b = serpWarningItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((SerpWarningItemListener) this.b.a.get()).onSerpWarningAction(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SerpWarningItemPresenterImpl a;
        public final /* synthetic */ SerpWarningItem b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SerpWarningItemPresenterImpl serpWarningItemPresenterImpl, SerpWarningItem serpWarningItem, int i) {
            super(0);
            this.a = serpWarningItemPresenterImpl;
            this.b = serpWarningItem;
            this.c = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((SerpWarningItemListener) this.a.a.get()).onSerpWarningClosed(this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SerpWarningItemPresenterImpl(@NotNull Lazy<SerpWarningItemListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        if ((r3.length() > 0) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.warning.SerpWarningItemView r9, @org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.warning.SerpWarningItem r10, int r11) {
        /*
            r8 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = r10.getTitle()
            r9.setMessage(r0)
            com.avito.android.remote.model.Image r1 = r10.getImage()
            if (r1 != 0) goto L_0x0019
            r0 = 0
            goto L_0x0024
        L_0x0019:
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 28
            r7 = 0
            com.avito.android.image_loader.Picture r0 = com.avito.android.image_loader.AvitoPictureKt.pictureOf$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x0024:
            r9.setImage(r0)
            java.util.List r0 = r10.getActions()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0034:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005c
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.avito.android.remote.model.Action r3 = (com.avito.android.remote.model.Action) r3
            java.lang.String r3 = r3.getTitle()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0055
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0051
            r3 = 1
            goto L_0x0052
        L_0x0051:
            r3 = 0
        L_0x0052:
            if (r3 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r4 = 0
        L_0x0056:
            if (r4 == 0) goto L_0x0034
            r1.add(r2)
            goto L_0x0034
        L_0x005c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r2 = 10
            int r2 = t6.n.e.collectionSizeOrDefault(r1, r2)
            r0.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x006b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0089
            java.lang.Object r2 = r1.next()
            com.avito.android.remote.model.Action r2 = (com.avito.android.remote.model.Action) r2
            com.avito.android.component.banner_card.BannerCard$Action r3 = new com.avito.android.component.banner_card.BannerCard$Action
            java.lang.String r4 = r2.getTitle()
            com.avito.android.serp.adapter.warning.SerpWarningItemPresenterImpl$a r5 = new com.avito.android.serp.adapter.warning.SerpWarningItemPresenterImpl$a
            r5.<init>(r2, r8)
            r3.<init>(r4, r5)
            r0.add(r3)
            goto L_0x006b
        L_0x0089:
            r9.setActions(r0)
            boolean r0 = r10.isCloseable()
            r9.setCloseButtonVisible(r0)
            com.avito.android.serp.adapter.warning.SerpWarningItemPresenterImpl$b r0 = new com.avito.android.serp.adapter.warning.SerpWarningItemPresenterImpl$b
            r0.<init>(r8, r10, r11)
            r9.setCloseClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.warning.SerpWarningItemPresenterImpl.bindView(com.avito.android.serp.adapter.warning.SerpWarningItemView, com.avito.android.serp.adapter.warning.SerpWarningItem, int):void");
    }
}
