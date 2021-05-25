package com.avito.android.in_app_calls.ui.call;

import androidx.lifecycle.Observer;
import com.avito.android.calls_shared.analytics.events.MicPermissionDialogGrantedEvent;
import com.avito.android.in_app_calls.permissions.CallPermissionsManager;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.permissions.PermissionState;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/avito/android/util/architecture_components/LiveDatasKt$observeNotNull$$inlined$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class CallFragment$bindCallView$$inlined$observeNotNull$2<T> implements Observer<T> {
    public final /* synthetic */ CallFragment a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CallPermissionsManager.PermissionRequest c;
        public final /* synthetic */ List d;
        public final /* synthetic */ CallFragment$bindCallView$$inlined$observeNotNull$2 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, CallPermissionsManager.PermissionRequest permissionRequest, List list, CallFragment$bindCallView$$inlined$observeNotNull$2 callFragment$bindCallView$$inlined$observeNotNull$2) {
            super(0);
            this.a = str;
            this.b = str2;
            this.c = permissionRequest;
            this.d = list;
            this.e = callFragment$bindCallView$$inlined$observeNotNull$2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if ((!m.isBlank(this.a)) && (!m.isBlank(this.b))) {
                this.e.a.getAnalytics().track(new MicPermissionDialogGrantedEvent(this.a, this.b));
            }
            if (this.c.getNeedShowSettings()) {
                CallFragment callFragment = this.e.a;
                callFragment.startActivity(callFragment.getIntentFactory().createAppSettingsIntent());
            } else {
                PermissionHelper access$getPermissionHelper$p = CallFragment.access$getPermissionHelper$p(this.e.a);
                Object[] array = this.d.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array;
                access$getPermissionHelper$p.requestPermissions(1, (String[]) Arrays.copyOf(strArr, strArr.length));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CallFragment$bindCallView$$inlined$observeNotNull$2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(boolean z, CallFragment$bindCallView$$inlined$observeNotNull$2 callFragment$bindCallView$$inlined$observeNotNull$2) {
            super(0);
            this.a = z;
            this.b = callFragment$bindCallView$$inlined$observeNotNull$2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.a) {
                this.b.a.getCallPresenter().onPermissionGranted(PermissionState.FOREVER_DENIED);
            } else {
                this.b.a.getCallPresenter().onPermissionGranted(PermissionState.DENIED);
            }
            return Unit.INSTANCE;
        }
    }

    public CallFragment$bindCallView$$inlined$observeNotNull$2(CallFragment callFragment) {
        this.a = callFragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3  */
    @Override // androidx.lifecycle.Observer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(T r10) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.in_app_calls.ui.call.CallFragment$bindCallView$$inlined$observeNotNull$2.onChanged(java.lang.Object):void");
    }
}
