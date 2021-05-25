package com.avito.android.service.short_task.metrics;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001f\u0010\t\u001a\u0004\u0018\u00010\u00058B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0016\u0010\n\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapperImpl;", "Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapper;", "", "isHapticEnabled", "()Z", "Landroid/view/accessibility/AccessibilityManager;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "()Landroid/view/accessibility/AccessibilityManager;", "manager", "isVisualEnabled", "isTalkBackEnabled", "isAccessibilityEnabled", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class AccessibilityManagerWrapperImpl implements AccessibilityManagerWrapper {
    public final Lazy a;

    public static final class a extends Lambda implements Function0<AccessibilityManager> {
        public final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.a = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public AccessibilityManager invoke() {
            Object systemService = this.a.getSystemService("accessibility");
            if (!(systemService instanceof AccessibilityManager)) {
                systemService = null;
            }
            return (AccessibilityManager) systemService;
        }
    }

    @Inject
    public AccessibilityManagerWrapperImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = c.lazy(new a(context));
    }

    public final AccessibilityManager a() {
        return (AccessibilityManager) this.a.getValue();
    }

    @Override // com.avito.android.service.short_task.metrics.AccessibilityManagerWrapper
    public boolean isAccessibilityEnabled() {
        AccessibilityManager a3 = a();
        if (a3 != null) {
            return a3.isEnabled();
        }
        return false;
    }

    @Override // com.avito.android.service.short_task.metrics.AccessibilityManagerWrapper
    public boolean isHapticEnabled() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager a3 = a();
        return (a3 == null || (enabledAccessibilityServiceList = a3.getEnabledAccessibilityServiceList(2)) == null || enabledAccessibilityServiceList.isEmpty()) ? false : true;
    }

    @Override // com.avito.android.service.short_task.metrics.AccessibilityManagerWrapper
    public boolean isTalkBackEnabled() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager a3 = a();
        return (a3 == null || (enabledAccessibilityServiceList = a3.getEnabledAccessibilityServiceList(1)) == null || enabledAccessibilityServiceList.isEmpty()) ? false : true;
    }

    @Override // com.avito.android.service.short_task.metrics.AccessibilityManagerWrapper
    public boolean isVisualEnabled() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager a3 = a();
        return (a3 == null || (enabledAccessibilityServiceList = a3.getEnabledAccessibilityServiceList(8)) == null || enabledAccessibilityServiceList.isEmpty()) ? false : true;
    }
}
