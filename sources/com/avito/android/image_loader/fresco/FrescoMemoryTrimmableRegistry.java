package com.avito.android.image_loader.fresco;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ForegroundStatusCallbacks;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b!\u0010\u000bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/image_loader/fresco/FrescoMemoryTrimmableRegistry;", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "Landroid/content/ComponentCallbacks2;", "Lcom/avito/android/util/ForegroundStatusCallbacks$Listener;", "Lcom/facebook/common/memory/MemoryTrimmable;", "trimmable", "", "registerMemoryTrimmable", "(Lcom/facebook/common/memory/MemoryTrimmable;)V", "unregisterMemoryTrimmable", "onLowMemory", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", FirebaseAnalytics.Param.LEVEL, "onTrimMemory", "(I)V", "appForegrounded", "appBackgrounded", "Lcom/facebook/common/memory/MemoryTrimType;", "trimType", AuthSource.SEND_ABUSE, "(Lcom/facebook/common/memory/MemoryTrimType;)V", "", AuthSource.BOOKING_ORDER, "Z", "isInForeground", "", "Ljava/util/Set;", "trimmables", "<init>", "image-loader-fresco_release"}, k = 1, mv = {1, 4, 2})
public final class FrescoMemoryTrimmableRegistry implements MemoryTrimmableRegistry, ComponentCallbacks2, ForegroundStatusCallbacks.Listener {
    public final Set<MemoryTrimmable> a = new LinkedHashSet();
    public boolean b;

    public final void a(MemoryTrimType memoryTrimType) {
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().trim(memoryTrimType);
        }
    }

    @Override // com.avito.android.util.ForegroundStatusCallbacks.Listener
    public void appBackgrounded() {
        this.b = false;
        a(MemoryTrimType.OnAppBackgrounded);
    }

    @Override // com.avito.android.util.ForegroundStatusCallbacks.Listener
    public void appForegrounded() {
        this.b = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@Nullable Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.b) {
            a(MemoryTrimType.OnSystemLowMemoryWhileAppInForeground);
        } else {
            a(MemoryTrimType.OnSystemLowMemoryWhileAppInBackground);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i != 15) {
            if (i == 40) {
                appBackgrounded();
            }
        } else if (this.b) {
            a(MemoryTrimType.OnSystemLowMemoryWhileAppInForeground);
        } else {
            a(MemoryTrimType.OnSystemLowMemoryWhileAppInBackground);
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void registerMemoryTrimmable(@NotNull MemoryTrimmable memoryTrimmable) {
        Intrinsics.checkNotNullParameter(memoryTrimmable, "trimmable");
        this.a.add(memoryTrimmable);
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void unregisterMemoryTrimmable(@NotNull MemoryTrimmable memoryTrimmable) {
        Intrinsics.checkNotNullParameter(memoryTrimmable, "trimmable");
        this.a.remove(memoryTrimmable);
    }
}
