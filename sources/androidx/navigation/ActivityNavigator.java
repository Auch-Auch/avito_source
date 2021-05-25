package androidx.navigation;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Navigator.Name("activity")
public class ActivityNavigator extends Navigator<Destination> {
    public Context a;
    public Activity b;

    @NavDestination.ClassType(Activity.class)
    public static class Destination extends NavDestination {
        public Intent j;
        public String k;

        public Destination(@NonNull NavigatorProvider navigatorProvider) {
            this(navigatorProvider.getNavigator(ActivityNavigator.class));
        }

        @Override // androidx.navigation.NavDestination
        public boolean e() {
            return false;
        }

        @Nullable
        public final String getAction() {
            Intent intent = this.j;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        @Nullable
        public final ComponentName getComponent() {
            Intent intent = this.j;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        @Nullable
        public final Uri getData() {
            Intent intent = this.j;
            if (intent == null) {
                return null;
            }
            return intent.getData();
        }

        @Nullable
        public final String getDataPattern() {
            return this.k;
        }

        @Nullable
        public final Intent getIntent() {
            return this.j;
        }

        @Nullable
        public final String getTargetPackage() {
            Intent intent = this.j;
            if (intent == null) {
                return null;
            }
            return intent.getPackage();
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            setTargetPackage(string);
            String string2 = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                setComponentName(new ComponentName(context, string2));
            }
            setAction(obtainAttributes.getString(R.styleable.ActivityNavigator_action));
            String string3 = obtainAttributes.getString(R.styleable.ActivityNavigator_data);
            if (string3 != null) {
                setData(Uri.parse(string3));
            }
            setDataPattern(obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern));
            obtainAttributes.recycle();
        }

        @NonNull
        public final Destination setAction(@Nullable String str) {
            if (this.j == null) {
                this.j = new Intent();
            }
            this.j.setAction(str);
            return this;
        }

        @NonNull
        public final Destination setComponentName(@Nullable ComponentName componentName) {
            if (this.j == null) {
                this.j = new Intent();
            }
            this.j.setComponent(componentName);
            return this;
        }

        @NonNull
        public final Destination setData(@Nullable Uri uri) {
            if (this.j == null) {
                this.j = new Intent();
            }
            this.j.setData(uri);
            return this;
        }

        @NonNull
        public final Destination setDataPattern(@Nullable String str) {
            this.k = str;
            return this;
        }

        @NonNull
        public final Destination setIntent(@Nullable Intent intent) {
            this.j = intent;
            return this;
        }

        @NonNull
        public final Destination setTargetPackage(@Nullable String str) {
            if (this.j == null) {
                this.j = new Intent();
            }
            this.j.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        @NonNull
        public String toString() {
            ComponentName component = getComponent();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                String action = getAction();
                if (action != null) {
                    sb.append(" action=");
                    sb.append(action);
                }
            }
            return sb.toString();
        }

        public Destination(@NonNull Navigator<? extends Destination> navigator) {
            super(navigator);
        }
    }

    public static final class Extras implements Navigator.Extras {
        public final int a;
        public final ActivityOptionsCompat b;

        public static final class Builder {
            public int a;
            public ActivityOptionsCompat b;

            @NonNull
            public Builder addFlags(int i) {
                this.a = i | this.a;
                return this;
            }

            @NonNull
            public Extras build() {
                return new Extras(this.a, this.b);
            }

            @NonNull
            public Builder setActivityOptions(@NonNull ActivityOptionsCompat activityOptionsCompat) {
                this.b = activityOptionsCompat;
                return this;
            }
        }

        public Extras(int i, @Nullable ActivityOptionsCompat activityOptionsCompat) {
            this.a = i;
            this.b = activityOptionsCompat;
        }

        @Nullable
        public ActivityOptionsCompat getActivityOptions() {
            return this.b;
        }

        public int getFlags() {
            return this.a;
        }
    }

    public ActivityNavigator(@NonNull Context context) {
        this.a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    public static void applyPopAnimationsToPendingTransition(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:popEnterAnim", -1);
            int intExtra2 = intent.getIntExtra("android-support-navigation:ActivityNavigator:popExitAnim", -1);
            if (intExtra != -1 || intExtra2 != -1) {
                if (intExtra == -1) {
                    intExtra = 0;
                }
                if (intExtra2 == -1) {
                    intExtra2 = 0;
                }
                activity.overridePendingTransition(intExtra, intExtra2);
            }
        }
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        Activity activity = this.b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public Destination createDestination() {
        return new Destination(this);
    }

    @Nullable
    public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intent intent;
        int intExtra;
        if (destination.getIntent() != null) {
            Intent intent2 = new Intent(destination.getIntent());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String dataPattern = destination.getDataPattern();
                if (!TextUtils.isEmpty(dataPattern)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(dataPattern);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + dataPattern);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z = extras instanceof Extras;
            if (z) {
                intent2.addFlags(((Extras) extras).getFlags());
            }
            if (!(this.a instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.b;
            int i = 0;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination.getId());
            if (navOptions != null) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", navOptions.getPopEnterAnim());
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", navOptions.getPopExitAnim());
            }
            if (z) {
                ActivityOptionsCompat activityOptions = ((Extras) extras).getActivityOptions();
                if (activityOptions != null) {
                    ContextCompat.startActivity(this.a, intent2, activityOptions.toBundle());
                } else {
                    this.a.startActivity(intent2);
                }
            } else {
                this.a.startActivity(intent2);
            }
            if (navOptions == null || this.b == null) {
                return null;
            }
            int enterAnim = navOptions.getEnterAnim();
            int exitAnim = navOptions.getExitAnim();
            if (enterAnim == -1 && exitAnim == -1) {
                return null;
            }
            if (enterAnim == -1) {
                enterAnim = 0;
            }
            if (exitAnim != -1) {
                i = exitAnim;
            }
            this.b.overridePendingTransition(enterAnim, i);
            return null;
        }
        StringBuilder L = a.L("Destination ");
        L.append(destination.getId());
        L.append(" does not have an Intent set.");
        throw new IllegalStateException(L.toString());
    }
}
