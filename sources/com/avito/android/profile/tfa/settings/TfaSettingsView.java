package com.avito.android.profile.tfa.settings;

import com.avito.android.deep_linking.links.DeepLink;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile/tfa/settings/TfaSettingsView;", "", "", "message", "", "showSnackbar", "(Ljava/lang/String;)V", "", "isEnabled", "setToggleEnabled", "(Z)V", "isChecked", "showToggleChecked", "warning", "bindWarning", "Lio/reactivex/rxjava3/core/Observable;", "getNavigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "getSwitcherChanges", "switcherChanges", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLinkClicks", "linkClicks", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface TfaSettingsView {
    void bindWarning(@Nullable String str);

    @NotNull
    Observable<DeepLink> getLinkClicks();

    @NotNull
    Observable<Unit> getNavigationClicks();

    @NotNull
    Observable<Boolean> getSwitcherChanges();

    void setToggleEnabled(boolean z);

    void showSnackbar(@NotNull String str);

    void showToggleChecked(boolean z);
}
