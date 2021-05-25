package com.avito.android.ui.adapter;

import a2.g.r.g;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010$\u001a\u00020!\u0012\b\b\u0002\u0010 \u001a\u00020\u0010\u0012\b\b\u0003\u0010,\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u001b\u0010\u0016\u001a\u00020\u00042\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u0010*\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u0012J\u0013\u0010\u001b\u001a\u00020\u0010*\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u0012R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010&R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010&¨\u00060"}, d2 = {"Lcom/avito/android/ui/adapter/AppendingAdapterHandler;", "Lcom/avito/android/ui/adapter/AppendingHandler;", "", "loadingRange", "", "setLoadingRange", "(I)V", "setAppendingFromTop", "()V", "setAppendingFromBottom", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "getAppendingView", "(Landroid/view/ViewGroup;)Landroid/view/View;", VKApiConst.POSITION, "", "isAppendingViewPosition", "(I)Z", "appendIfNeeded", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapterDelegate", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "getCount", "()I", AuthSource.BOOKING_ORDER, AuthSource.SEND_ABUSE, "Landroid/view/View;", "appendingView", "f", "Z", "reversed", "Lcom/avito/android/ui/adapter/AppendingListener;", "e", "Lcom/avito/android/ui/adapter/AppendingListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "c", "I", "Lcom/avito/android/ui/adapter/AppendingAdapter;", "d", "Lcom/avito/android/ui/adapter/AppendingAdapter;", "appendingAdapter", g.a, "appendingViewLayoutId", "direction", "<init>", "(Lcom/avito/android/ui/adapter/AppendingAdapter;Lcom/avito/android/ui/adapter/AppendingListener;ZI)V", "appending-list_release"}, k = 1, mv = {1, 4, 2})
public final class AppendingAdapterHandler implements AppendingHandler {
    public int a;
    public View b;
    public int c;
    public final AppendingAdapter d;
    public final AppendingListener e;
    public final boolean f;
    public final int g;

    public AppendingAdapterHandler(@NotNull AppendingAdapter appendingAdapter, @NotNull AppendingListener appendingListener, boolean z, @LayoutRes int i) {
        Intrinsics.checkNotNullParameter(appendingAdapter, "appendingAdapter");
        Intrinsics.checkNotNullParameter(appendingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d = appendingAdapter;
        this.e = appendingListener;
        this.f = z;
        this.g = i;
        this.a = 1;
    }

    public final boolean a(int i) {
        return i == 1;
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public void appendIfNeeded(int i) {
        if (this.e.canAppend()) {
            boolean z = false;
            if (this.e.canAppend()) {
                int count = this.d.getCount();
                if (i >= 0 && i < count) {
                    int i2 = this.c + 1;
                    if (!a(this.a) || !this.f ? !(!a(this.a) ? !b(this.a) || !this.f ? !b(this.a) || i >= i2 : i < count - i2 : i < count - i2) : i < i2) {
                        z = true;
                    }
                }
            }
            if (z) {
                this.e.onAppend();
            }
        }
    }

    public final boolean b(int i) {
        return i == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r0.getParent() != null) goto L_0x0012;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getAppendingView(@org.jetbrains.annotations.NotNull android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.view.View r0 = r3.b
            if (r0 == 0) goto L_0x0012
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0023
        L_0x0012:
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.g
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            r3.b = r4
        L_0x0023:
            android.view.View r4 = r3.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.ui.adapter.AppendingAdapterHandler.getAppendingView(android.view.ViewGroup):android.view.View");
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public int getCount() {
        return this.d.getCount();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.android.ui.adapter.AppendingHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAppendingViewPosition(int r4) {
        /*
            r3 = this;
            com.avito.android.ui.adapter.AppendingListener r0 = r3.e
            boolean r0 = r0.canAppend()
            r1 = 0
            if (r0 == 0) goto L_0x0048
            int r0 = r3.a
            boolean r0 = r3.a(r0)
            r2 = 1
            if (r0 == 0) goto L_0x0018
            boolean r0 = r3.f
            if (r0 == 0) goto L_0x0018
        L_0x0016:
            r0 = 0
            goto L_0x0045
        L_0x0018:
            int r0 = r3.a
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L_0x0028
            com.avito.android.ui.adapter.AppendingAdapter r0 = r3.d
            int r0 = r0.getCount()
        L_0x0026:
            int r0 = r0 - r2
            goto L_0x0045
        L_0x0028:
            int r0 = r3.a
            boolean r0 = r3.b(r0)
            if (r0 == 0) goto L_0x003b
            boolean r0 = r3.f
            if (r0 == 0) goto L_0x003b
            com.avito.android.ui.adapter.AppendingAdapter r0 = r3.d
            int r0 = r0.getCount()
            goto L_0x0026
        L_0x003b:
            int r0 = r3.a
            boolean r0 = r3.b(r0)
            if (r0 == 0) goto L_0x0044
            goto L_0x0016
        L_0x0044:
            r0 = -1
        L_0x0045:
            if (r4 != r0) goto L_0x0048
            r1 = 1
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.ui.adapter.AppendingAdapterHandler.isAppendingViewPosition(int):boolean");
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public void setAdapterDelegate(@NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
    }

    public final void setAppendingFromBottom() {
        this.a = 1;
    }

    public final void setAppendingFromTop() {
        this.a = 0;
    }

    public final void setLoadingRange(int i) {
        if (i >= 0) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("Loading range cannot be less than 0");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppendingAdapterHandler(AppendingAdapter appendingAdapter, AppendingListener appendingListener, boolean z, int i, int i2, j jVar) {
        this(appendingAdapter, appendingListener, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? R.layout.pending_view : i);
    }
}
