package com.avito.android.bottom_navigation.ui.fragment;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public abstract class FragmentLifecycleEvent {
    @NotNull
    public final String a;
    @NotNull
    public final Fragment b;
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent$Create;", "Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent;", "", "tab", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Ljava/lang/String;Landroidx/fragment/app/Fragment;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Create extends FragmentLifecycleEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Create(@NotNull String str, @NotNull Fragment fragment) {
            super(str, fragment, "created", null);
            Intrinsics.checkNotNullParameter(str, "tab");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent$Destroy;", "Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent;", "", "tab", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Ljava/lang/String;Landroidx/fragment/app/Fragment;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Destroy extends FragmentLifecycleEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destroy(@NotNull String str, @NotNull Fragment fragment) {
            super(str, fragment, "destroyed", null);
            Intrinsics.checkNotNullParameter(str, "tab");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent$Start;", "Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent;", "", "tab", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Ljava/lang/String;Landroidx/fragment/app/Fragment;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Start extends FragmentLifecycleEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Start(@NotNull String str, @NotNull Fragment fragment) {
            super(str, fragment, "started", null);
            Intrinsics.checkNotNullParameter(str, "tab");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent$Stop;", "Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent;", "", "tab", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Ljava/lang/String;Landroidx/fragment/app/Fragment;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Stop extends FragmentLifecycleEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Stop(@NotNull String str, @NotNull Fragment fragment) {
            super(str, fragment, "stopped", null);
            Intrinsics.checkNotNullParameter(str, "tab");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }
    }

    public FragmentLifecycleEvent(String str, Fragment fragment, String str2, j jVar) {
        this.a = str;
        this.b = fragment;
        this.c = str2;
    }

    @NotNull
    public final String getAction() {
        return this.c;
    }

    @NotNull
    public final Fragment getFragment() {
        return this.b;
    }

    @NotNull
    public final String getTab() {
        return this.a;
    }
}
