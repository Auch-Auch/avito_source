package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JP\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\rR\u001c\u0010\u0013\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010\nR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\u0004R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\u0011¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileSettingsResult;", "", "Lcom/avito/android/remote/model/SimpleAction;", "component1", "()Lcom/avito/android/remote/model/SimpleAction;", "", "component2", "()Z", "Lcom/avito/android/remote/model/Banner;", "component3", "()Lcom/avito/android/remote/model/Banner;", "Lcom/avito/android/remote/model/Toggle;", "component4", "()Lcom/avito/android/remote/model/Toggle;", "", "Lcom/avito/android/remote/model/Widget;", "component5", "()Ljava/util/List;", "action", "canEnableProfile", "banner", "toggle", "widgets", "copy", "(Lcom/avito/android/remote/model/SimpleAction;ZLcom/avito/android/remote/model/Banner;Lcom/avito/android/remote/model/Toggle;Ljava/util/List;)Lcom/avito/android/remote/model/ExtendedProfileSettingsResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/Toggle;", "getToggle", "Z", "getCanEnableProfile", "Lcom/avito/android/remote/model/Banner;", "getBanner", "Lcom/avito/android/remote/model/SimpleAction;", "getAction", "Ljava/util/List;", "getWidgets", "<init>", "(Lcom/avito/android/remote/model/SimpleAction;ZLcom/avito/android/remote/model/Banner;Lcom/avito/android/remote/model/Toggle;Ljava/util/List;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileSettingsResult {
    @SerializedName("action")
    @Nullable
    private final SimpleAction action;
    @SerializedName("banner")
    @Nullable
    private final Banner banner;
    @SerializedName("canEnableProfile")
    private final boolean canEnableProfile;
    @SerializedName("toggle")
    @Nullable
    private final Toggle toggle;
    @SerializedName("widgets")
    @Nullable
    private final List<Widget> widgets;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.Widget> */
    /* JADX WARN: Multi-variable type inference failed */
    public ExtendedProfileSettingsResult(@Nullable SimpleAction simpleAction, boolean z, @Nullable Banner banner2, @Nullable Toggle toggle2, @Nullable List<? extends Widget> list) {
        this.action = simpleAction;
        this.canEnableProfile = z;
        this.banner = banner2;
        this.toggle = toggle2;
        this.widgets = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.ExtendedProfileSettingsResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtendedProfileSettingsResult copy$default(ExtendedProfileSettingsResult extendedProfileSettingsResult, SimpleAction simpleAction, boolean z, Banner banner2, Toggle toggle2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleAction = extendedProfileSettingsResult.action;
        }
        if ((i & 2) != 0) {
            z = extendedProfileSettingsResult.canEnableProfile;
        }
        if ((i & 4) != 0) {
            banner2 = extendedProfileSettingsResult.banner;
        }
        if ((i & 8) != 0) {
            toggle2 = extendedProfileSettingsResult.toggle;
        }
        if ((i & 16) != 0) {
            list = extendedProfileSettingsResult.widgets;
        }
        return extendedProfileSettingsResult.copy(simpleAction, z, banner2, toggle2, list);
    }

    @Nullable
    public final SimpleAction component1() {
        return this.action;
    }

    public final boolean component2() {
        return this.canEnableProfile;
    }

    @Nullable
    public final Banner component3() {
        return this.banner;
    }

    @Nullable
    public final Toggle component4() {
        return this.toggle;
    }

    @Nullable
    public final List<Widget> component5() {
        return this.widgets;
    }

    @NotNull
    public final ExtendedProfileSettingsResult copy(@Nullable SimpleAction simpleAction, boolean z, @Nullable Banner banner2, @Nullable Toggle toggle2, @Nullable List<? extends Widget> list) {
        return new ExtendedProfileSettingsResult(simpleAction, z, banner2, toggle2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtendedProfileSettingsResult)) {
            return false;
        }
        ExtendedProfileSettingsResult extendedProfileSettingsResult = (ExtendedProfileSettingsResult) obj;
        return Intrinsics.areEqual(this.action, extendedProfileSettingsResult.action) && this.canEnableProfile == extendedProfileSettingsResult.canEnableProfile && Intrinsics.areEqual(this.banner, extendedProfileSettingsResult.banner) && Intrinsics.areEqual(this.toggle, extendedProfileSettingsResult.toggle) && Intrinsics.areEqual(this.widgets, extendedProfileSettingsResult.widgets);
    }

    @Nullable
    public final SimpleAction getAction() {
        return this.action;
    }

    @Nullable
    public final Banner getBanner() {
        return this.banner;
    }

    public final boolean getCanEnableProfile() {
        return this.canEnableProfile;
    }

    @Nullable
    public final Toggle getToggle() {
        return this.toggle;
    }

    @Nullable
    public final List<Widget> getWidgets() {
        return this.widgets;
    }

    public int hashCode() {
        SimpleAction simpleAction = this.action;
        int i = 0;
        int hashCode = (simpleAction != null ? simpleAction.hashCode() : 0) * 31;
        boolean z = this.canEnableProfile;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        Banner banner2 = this.banner;
        int hashCode2 = (i5 + (banner2 != null ? banner2.hashCode() : 0)) * 31;
        Toggle toggle2 = this.toggle;
        int hashCode3 = (hashCode2 + (toggle2 != null ? toggle2.hashCode() : 0)) * 31;
        List<Widget> list = this.widgets;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ExtendedProfileSettingsResult(action=");
        L.append(this.action);
        L.append(", canEnableProfile=");
        L.append(this.canEnableProfile);
        L.append(", banner=");
        L.append(this.banner);
        L.append(", toggle=");
        L.append(this.toggle);
        L.append(", widgets=");
        return a.w(L, this.widgets, ")");
    }
}
