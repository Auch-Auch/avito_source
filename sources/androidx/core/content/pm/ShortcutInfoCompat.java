package androidx.core.content.pm;

import a2.b.a.a.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class ShortcutInfoCompat {
    public Context a;
    public String b;
    public Intent[] c;
    public ComponentName d;
    public CharSequence e;
    public CharSequence f;
    public CharSequence g;
    public IconCompat h;
    public boolean i;
    public Person[] j;
    public Set<String> k;
    public boolean l;
    public int m;

    public static class Builder {
        public final ShortcutInfoCompat a;

        public Builder(@NonNull Context context, @NonNull String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.a = shortcutInfoCompat;
            shortcutInfoCompat.a = context;
            shortcutInfoCompat.b = str;
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (!TextUtils.isEmpty(this.a.e)) {
                ShortcutInfoCompat shortcutInfoCompat = this.a;
                Intent[] intentArr = shortcutInfoCompat.c;
                if (intentArr != null && intentArr.length != 0) {
                    return shortcutInfoCompat;
                }
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName componentName) {
            this.a.d = componentName;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.a.i = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> set) {
            this.a.k = set;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence charSequence) {
            this.a.g = charSequence;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat iconCompat) {
            this.a.h = iconCompat;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] intentArr) {
            this.a.c = intentArr;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.a.l = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person person) {
            return setPersons(new Person[]{person});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] personArr) {
            this.a.j = personArr;
            return this;
        }

        @NonNull
        public Builder setRank(int i) {
            this.a.m = i;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence charSequence) {
            this.a.e = charSequence;
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean z) {
            this.a.l = z;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.a = shortcutInfoCompat2;
            shortcutInfoCompat2.a = shortcutInfoCompat.a;
            shortcutInfoCompat2.b = shortcutInfoCompat.b;
            Intent[] intentArr = shortcutInfoCompat.c;
            shortcutInfoCompat2.c = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.d = shortcutInfoCompat.d;
            shortcutInfoCompat2.e = shortcutInfoCompat.e;
            shortcutInfoCompat2.f = shortcutInfoCompat.f;
            shortcutInfoCompat2.g = shortcutInfoCompat.g;
            shortcutInfoCompat2.h = shortcutInfoCompat.h;
            shortcutInfoCompat2.i = shortcutInfoCompat.i;
            shortcutInfoCompat2.l = shortcutInfoCompat.l;
            shortcutInfoCompat2.m = shortcutInfoCompat.m;
            Person[] personArr = shortcutInfoCompat.j;
            if (personArr != null) {
                shortcutInfoCompat2.j = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.k != null) {
                shortcutInfoCompat2.k = new HashSet(shortcutInfoCompat.k);
            }
        }

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            Person[] personArr;
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.a = shortcutInfoCompat;
            shortcutInfoCompat.a = context;
            shortcutInfoCompat.b = shortcutInfo.getId();
            Intent[] intents = shortcutInfo.getIntents();
            shortcutInfoCompat.c = (Intent[]) Arrays.copyOf(intents, intents.length);
            shortcutInfoCompat.d = shortcutInfo.getActivity();
            shortcutInfoCompat.e = shortcutInfo.getShortLabel();
            shortcutInfoCompat.f = shortcutInfo.getLongLabel();
            shortcutInfoCompat.g = shortcutInfo.getDisabledMessage();
            shortcutInfoCompat.k = shortcutInfo.getCategories();
            PersistableBundle extras = shortcutInfo.getExtras();
            if (extras == null || !extras.containsKey("extraPersonCount")) {
                personArr = null;
            } else {
                int i = extras.getInt("extraPersonCount");
                personArr = new Person[i];
                int i2 = 0;
                while (i2 < i) {
                    StringBuilder L = a.L("extraPerson_");
                    int i3 = i2 + 1;
                    L.append(i3);
                    personArr[i2] = Person.fromPersistableBundle(extras.getPersistableBundle(L.toString()));
                    i2 = i3;
                }
            }
            shortcutInfoCompat.j = personArr;
            this.a.m = shortcutInfo.getRank();
        }
    }

    public Intent a(Intent intent) {
        Intent[] intentArr = this.c;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.e.toString());
        if (this.h != null) {
            Drawable drawable = null;
            if (this.i) {
                PackageManager packageManager = this.a.getPackageManager();
                ComponentName componentName = this.d;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.h.addToShortcutIntent(intent, drawable, this.a);
        }
        return intent;
    }

    @Nullable
    public ComponentName getActivity() {
        return this.d;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.k;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.h;
    }

    @NonNull
    public String getId() {
        return this.b;
    }

    @NonNull
    public Intent getIntent() {
        Intent[] intentArr = this.c;
        return intentArr[intentArr.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] intentArr = this.c;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.f;
    }

    public int getRank() {
        return this.m;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.e;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.a, this.b).setShortLabel(this.e).setIntents(this.c);
        IconCompat iconCompat = this.h;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon(this.a));
        }
        if (!TextUtils.isEmpty(this.f)) {
            intents.setLongLabel(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            intents.setDisabledMessage(this.g);
        }
        ComponentName componentName = this.d;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.k;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.m);
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.j;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                while (i2 < length) {
                    personArr2[i2] = this.j[i2].toAndroidPerson();
                    i2++;
                }
                intents.setPersons(personArr2);
            }
            intents.setLongLived(this.l);
        } else {
            PersistableBundle persistableBundle = new PersistableBundle();
            Person[] personArr3 = this.j;
            if (personArr3 != null && personArr3.length > 0) {
                persistableBundle.putInt("extraPersonCount", personArr3.length);
                while (i2 < this.j.length) {
                    StringBuilder L = a.L("extraPerson_");
                    int i3 = i2 + 1;
                    L.append(i3);
                    persistableBundle.putPersistableBundle(L.toString(), this.j[i2].toPersistableBundle());
                    i2 = i3;
                }
            }
            persistableBundle.putBoolean("extraLongLived", this.l);
            intents.setExtras(persistableBundle);
        }
        return intents.build();
    }
}
