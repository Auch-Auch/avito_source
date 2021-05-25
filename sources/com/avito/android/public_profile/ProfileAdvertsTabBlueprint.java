package com.avito.android.public_profile;

import androidx.fragment.app.Fragment;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.design.widget.tab.Tab;
import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.public_profile.ProfileAdvertsFragment;
import com.avito.android.public_profile.di.PublicProfileFragmentModule;
import com.avito.android.public_profile.ui.tab.TabItem;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\b\u0007\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0019\u001a\u00020\b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/avito/android/public_profile/ProfileAdvertsTabBlueprint;", "Lcom/avito/android/design/widget/tab/TabBlueprint;", "Lcom/avito/android/public_profile/ui/tab/TabItem;", "item", "Landroidx/fragment/app/Fragment;", "onCreateFragment", "(Lcom/avito/android/public_profile/ui/tab/TabItem;)Landroidx/fragment/app/Fragment;", "Lcom/avito/android/design/widget/tab/Tab;", "", "isRelevantItem", "(Lcom/avito/android/design/widget/tab/Tab;)Z", "", "e", "Ljava/lang/String;", "contextId", "Lcom/avito/android/analytics/screens/Screen;", "c", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/public_profile/ProfileAdvertsFragment$Factory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/public_profile/ProfileAdvertsFragment$Factory;", "fragmentFactory", "d", "Z", "isSubComponent", AuthSource.BOOKING_ORDER, "userKey", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/screens/Screen;ZLjava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileAdvertsTabBlueprint implements TabBlueprint<TabItem> {
    public final ProfileAdvertsFragment.Factory a = new ProfileAdvertsFragment.Factory();
    public final String b;
    public final Screen c;
    public final boolean d;
    public final String e;

    @Inject
    public ProfileAdvertsTabBlueprint(@PublicProfileFragmentModule.UserKey @NotNull String str, @ProfileAdvertsTab @NotNull Screen screen, @ProfileAdvertsTab boolean z, @PublicProfileFragmentModule.ContextId @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        this.b = str;
        this.c = screen;
        this.d = z;
        this.e = str2;
    }

    @Override // com.avito.android.design.widget.tab.TabBlueprint
    @Nullable
    public Fragment createFragment(@NotNull Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "item");
        return TabBlueprint.DefaultImpls.createFragment(this, tab);
    }

    @Override // com.avito.android.design.widget.tab.TabBlueprint
    public boolean isRelevantItem(@NotNull Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "item");
        return tab instanceof TabItem;
    }

    @Nullable
    public Fragment onCreateFragment(@NotNull TabItem tabItem) {
        Intrinsics.checkNotNullParameter(tabItem, "item");
        return this.a.create(this.b, tabItem.getShortcut(), this.c, this.d, tabItem.getPlaceholder(), this.e);
    }
}
