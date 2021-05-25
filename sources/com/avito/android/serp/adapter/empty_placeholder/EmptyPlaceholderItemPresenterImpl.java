package com.avito.android.serp.adapter.empty_placeholder;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PlaceholderAction;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemPresenterImpl;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemPresenter;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView;", "view", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView;Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyPlaceholderItemPresenterImpl implements EmptyPlaceholderItemPresenter {
    public final Lazy<EmptyPlaceholderItemListener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PlaceholderAction a;
        public final /* synthetic */ EmptyPlaceholderItemPresenterImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PlaceholderAction placeholderAction, EmptyPlaceholderItemPresenterImpl emptyPlaceholderItemPresenterImpl, EmptyPlaceholderItem emptyPlaceholderItem) {
            super(0);
            this.a = placeholderAction;
            this.b = emptyPlaceholderItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeepLink uri = this.a.getUri();
            if (uri != null) {
                ((EmptyPlaceholderItemListener) this.b.a.get()).onFollowDeeplinkFromEmpty(uri);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public EmptyPlaceholderItemPresenterImpl(@NotNull Lazy<EmptyPlaceholderItemListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if ((r2.length() > 0) != false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView r6, @org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItem r7, int r8) {
        /*
            r5 = this;
            java.lang.String r8 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            java.lang.String r8 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.lang.String r8 = r7.getTitle()
            r6.setTitle(r8)
            java.lang.String r8 = r7.getSubtitle()
            r6.setSubtitle(r8)
            java.util.List r8 = r7.getActions()
            if (r8 == 0) goto L_0x0084
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0027:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x004f
            java.lang.Object r1 = r8.next()
            r2 = r1
            com.avito.android.remote.model.PlaceholderAction r2 = (com.avito.android.remote.model.PlaceholderAction) r2
            java.lang.String r2 = r2.getTitle()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0048
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0044
            r2 = 1
            goto L_0x0045
        L_0x0044:
            r2 = 0
        L_0x0045:
            if (r2 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            if (r3 == 0) goto L_0x0027
            r0.add(r1)
            goto L_0x0027
        L_0x004f:
            java.util.ArrayList r8 = new java.util.ArrayList
            r1 = 10
            int r1 = t6.n.e.collectionSizeOrDefault(r0, r1)
            r8.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x005e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0081
            java.lang.Object r1 = r0.next()
            com.avito.android.remote.model.PlaceholderAction r1 = (com.avito.android.remote.model.PlaceholderAction) r1
            com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView$Action r2 = new com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView$Action
            java.lang.String r3 = r1.getTitle()
            if (r3 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            java.lang.String r3 = ""
        L_0x0075:
            com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemPresenterImpl$a r4 = new com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemPresenterImpl$a
            r4.<init>(r1, r5, r7)
            r2.<init>(r3, r4)
            r8.add(r2)
            goto L_0x005e
        L_0x0081:
            r6.setActions(r8)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemPresenterImpl.bindView(com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView, com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItem, int):void");
    }
}
