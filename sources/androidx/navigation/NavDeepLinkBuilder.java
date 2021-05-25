package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.Iterator;
public final class NavDeepLinkBuilder {
    public final Context a;
    public final Intent b;
    public NavGraph c;
    public int d;
    public Bundle e;

    public static class a extends NavigatorProvider {
        public final Navigator<NavDestination> c = new C0114a(this);

        /* renamed from: androidx.navigation.NavDeepLinkBuilder$a$a  reason: collision with other inner class name */
        public class C0114a extends Navigator<NavDestination> {
            public C0114a(a aVar) {
            }

            @Override // androidx.navigation.Navigator
            @NonNull
            public NavDestination createDestination() {
                return new NavDestination("permissive");
            }

            @Override // androidx.navigation.Navigator
            @Nullable
            public NavDestination navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
                throw new IllegalStateException("navigate is not supported");
            }

            @Override // androidx.navigation.Navigator
            public boolean popBackStack() {
                throw new IllegalStateException("popBackStack is not supported");
            }
        }

        public a() {
            addNavigator(new NavGraphNavigator(this));
        }

        @Override // androidx.navigation.NavigatorProvider
        @NonNull
        public Navigator<? extends NavDestination> getNavigator(@NonNull String str) {
            try {
                return super.getNavigator(str);
            } catch (IllegalStateException unused) {
                return this.c;
            }
        }
    }

    public NavDeepLinkBuilder(@NonNull Context context) {
        this.a = context;
        if (context instanceof Activity) {
            this.b = new Intent(context, context.getClass());
        } else {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            this.b = launchIntentForPackage == null ? new Intent() : launchIntentForPackage;
        }
        this.b.addFlags(268468224);
    }

    public final void a() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this.c);
        NavDestination navDestination = null;
        while (!arrayDeque.isEmpty() && navDestination == null) {
            NavDestination navDestination2 = (NavDestination) arrayDeque.poll();
            if (navDestination2.getId() == this.d) {
                navDestination = navDestination2;
            } else if (navDestination2 instanceof NavGraph) {
                Iterator<NavDestination> it = ((NavGraph) navDestination2).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        if (navDestination != null) {
            this.b.putExtra("android-support-nav:controller:deepLinkIds", navDestination.b());
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.e3("navigation destination ", NavDestination.c(this.a, this.d), " is unknown to this NavController"));
    }

    @NonNull
    public PendingIntent createPendingIntent() {
        Bundle bundle = this.e;
        int i = 0;
        if (bundle != null) {
            int i2 = 0;
            for (String str : bundle.keySet()) {
                Object obj = this.e.get(str);
                i2 = (i2 * 31) + (obj != null ? obj.hashCode() : 0);
            }
            i = i2;
        }
        return createTaskStackBuilder().getPendingIntent((i * 31) + this.d, 134217728);
    }

    @NonNull
    public TaskStackBuilder createTaskStackBuilder() {
        if (this.b.getIntArrayExtra("android-support-nav:controller:deepLinkIds") != null) {
            TaskStackBuilder addNextIntentWithParentStack = TaskStackBuilder.create(this.a).addNextIntentWithParentStack(new Intent(this.b));
            for (int i = 0; i < addNextIntentWithParentStack.getIntentCount(); i++) {
                addNextIntentWithParentStack.editIntentAt(i).putExtra(NavController.KEY_DEEP_LINK_INTENT, this.b);
            }
            return addNextIntentWithParentStack;
        } else if (this.c == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link");
        } else {
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
    }

    @NonNull
    public NavDeepLinkBuilder setArguments(@Nullable Bundle bundle) {
        this.e = bundle;
        this.b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setComponentName(@NonNull Class<? extends Activity> cls) {
        return setComponentName(new ComponentName(this.a, cls));
    }

    @NonNull
    public NavDeepLinkBuilder setDestination(@IdRes int i) {
        this.d = i;
        if (this.c != null) {
            a();
        }
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setGraph(@NavigationRes int i) {
        return setGraph(new NavInflater(this.a, new a()).inflate(i));
    }

    @NonNull
    public NavDeepLinkBuilder setComponentName(@NonNull ComponentName componentName) {
        this.b.setComponent(componentName);
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setGraph(@NonNull NavGraph navGraph) {
        this.c = navGraph;
        if (this.d != 0) {
            a();
        }
        return this;
    }
}
