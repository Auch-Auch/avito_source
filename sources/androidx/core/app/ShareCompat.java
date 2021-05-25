package androidx.core.app;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    public static class IntentBuilder {
        @NonNull
        public final Context a;
        @NonNull
        public final Intent b;
        @Nullable
        public CharSequence c;
        @Nullable
        public ArrayList<String> d;
        @Nullable
        public ArrayList<String> e;
        @Nullable
        public ArrayList<String> f;
        @Nullable
        public ArrayList<Uri> g;

        public IntentBuilder(@NonNull Context context, @Nullable ComponentName componentName) {
            this.a = (Context) Preconditions.checkNotNull(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.b = action;
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
            action.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, componentName);
            action.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, componentName);
            action.addFlags(524288);
        }

        @NonNull
        public static IntentBuilder from(@NonNull Activity activity) {
            return new IntentBuilder((Context) Preconditions.checkNotNull(activity), activity.getComponentName());
        }

        public final void a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.b.putExtra(str, strArr);
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String str) {
            if (this.f == null) {
                this.f = new ArrayList<>();
            }
            this.f.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String str) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            this.e.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String str) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri uri) {
            Uri uri2 = (Uri) this.b.getParcelableExtra("android.intent.extra.STREAM");
            ArrayList<Uri> arrayList = this.g;
            if (arrayList == null && uri2 == null) {
                return setStream(uri);
            }
            if (arrayList == null) {
                this.g = new ArrayList<>();
            }
            if (uri2 != null) {
                this.b.removeExtra("android.intent.extra.STREAM");
                this.g.add(uri2);
            }
            this.g.add(uri);
            return this;
        }

        public final void b(@Nullable String str, @NonNull String[] strArr) {
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[(strArr.length + length)];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intent.putExtra(str, strArr2);
        }

        @NonNull
        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.c);
        }

        @NonNull
        public Intent getIntent() {
            ArrayList<String> arrayList = this.d;
            if (arrayList != null) {
                a("android.intent.extra.EMAIL", arrayList);
                this.d = null;
            }
            ArrayList<String> arrayList2 = this.e;
            if (arrayList2 != null) {
                a("android.intent.extra.CC", arrayList2);
                this.e = null;
            }
            ArrayList<String> arrayList3 = this.f;
            if (arrayList3 != null) {
                a("android.intent.extra.BCC", arrayList3);
                this.f = null;
            }
            ArrayList<Uri> arrayList4 = this.g;
            boolean z = true;
            if (arrayList4 == null || arrayList4.size() <= 1) {
                z = false;
            }
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.b.getAction());
            if (!z && equals) {
                this.b.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList5 = this.g;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    this.b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.b.putExtra("android.intent.extra.STREAM", this.g.get(0));
                }
                this.g = null;
            }
            if (z && !equals) {
                this.b.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<Uri> arrayList6 = this.g;
                if (arrayList6 == null || arrayList6.isEmpty()) {
                    this.b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.g);
                }
            }
            return this.b;
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] strArr) {
            this.b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] strArr) {
            this.b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] strArr) {
            if (this.d != null) {
                this.d = null;
            }
            this.b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String str) {
            this.b.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.b.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri uri) {
            if (!"android.intent.action.SEND".equals(this.b.getAction())) {
                this.b.setAction("android.intent.action.SEND");
            }
            this.g = null;
            this.b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String str) {
            this.b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence charSequence) {
            this.b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String str) {
            this.b.setType(str);
            return this;
        }

        public void startChooser() {
            this.a.startActivity(createChooserIntent());
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int i) {
            return setChooserTitle(this.a.getText(i));
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] strArr) {
            b("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] strArr) {
            b("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] strArr) {
            b("android.intent.extra.EMAIL", strArr);
            return this;
        }
    }

    public static class IntentReader {
        @NonNull
        public final Context a;
        @NonNull
        public final Intent b;
        @Nullable
        public final String c;
        @Nullable
        public final ComponentName d;
        @Nullable
        public ArrayList<Uri> e;

        public IntentReader(@NonNull Context context, @NonNull Intent intent) {
            this.a = (Context) Preconditions.checkNotNull(context);
            this.b = (Intent) Preconditions.checkNotNull(intent);
            String stringExtra = intent.getStringExtra(ShareCompat.EXTRA_CALLING_PACKAGE);
            this.c = stringExtra == null ? intent.getStringExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP) : stringExtra;
            this.d = ShareCompat.a(intent);
        }

        @NonNull
        public static IntentReader from(@NonNull Activity activity) {
            return new IntentReader((Context) Preconditions.checkNotNull(activity), activity.getIntent());
        }

        @Nullable
        public ComponentName getCallingActivity() {
            return this.d;
        }

        @Nullable
        public Drawable getCallingActivityIcon() {
            if (this.d == null) {
                return null;
            }
            try {
                return this.a.getPackageManager().getActivityIcon(this.d);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @Nullable
        public Drawable getCallingApplicationIcon() {
            if (this.c == null) {
                return null;
            }
            try {
                return this.a.getPackageManager().getApplicationIcon(this.c);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @Nullable
        public CharSequence getCallingApplicationLabel() {
            if (this.c == null) {
                return null;
            }
            PackageManager packageManager = this.a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.c, 0));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @Nullable
        public String getCallingPackage() {
            return this.c;
        }

        @Nullable
        public String[] getEmailBcc() {
            return this.b.getStringArrayExtra("android.intent.extra.BCC");
        }

        @Nullable
        public String[] getEmailCc() {
            return this.b.getStringArrayExtra("android.intent.extra.CC");
        }

        @Nullable
        public String[] getEmailTo() {
            return this.b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @Nullable
        public String getHtmlText() {
            String stringExtra = this.b.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence text = getText();
            if (text instanceof Spanned) {
                return Html.toHtml((Spanned) text);
            }
            return text != null ? Html.escapeHtml(text) : stringExtra;
        }

        @Nullable
        public Uri getStream() {
            return (Uri) this.b.getParcelableExtra("android.intent.extra.STREAM");
        }

        public int getStreamCount() {
            if (this.e == null && isMultipleShare()) {
                this.e = this.b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.e;
            if (arrayList != null) {
                return arrayList.size();
            }
            return this.b.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @Nullable
        public String getSubject() {
            return this.b.getStringExtra("android.intent.extra.SUBJECT");
        }

        @Nullable
        public CharSequence getText() {
            return this.b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @Nullable
        public String getType() {
            return this.b.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.b.getAction());
        }

        public boolean isShareIntent() {
            String action = this.b.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.b.getAction());
        }

        @Nullable
        public Uri getStream(int i) {
            if (this.e == null && isMultipleShare()) {
                this.e = this.b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.e;
            if (arrayList != null) {
                return arrayList.get(i);
            }
            if (i == 0) {
                return (Uri) this.b.getParcelableExtra("android.intent.extra.STREAM");
            }
            StringBuilder L = a.L("Stream items available: ");
            L.append(getStreamCount());
            L.append(" index requested: ");
            L.append(i);
            throw new IndexOutOfBoundsException(L.toString());
        }
    }

    @Nullable
    public static ComponentName a(@NonNull Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        return componentName == null ? (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP) : componentName;
    }

    public static void configureMenuItem(@NonNull MenuItem menuItem, @NonNull IntentBuilder intentBuilder) {
        ShareActionProvider shareActionProvider;
        ActionProvider actionProvider = menuItem.getActionProvider();
        if (!(actionProvider instanceof ShareActionProvider)) {
            shareActionProvider = new ShareActionProvider(intentBuilder.a);
        } else {
            shareActionProvider = (ShareActionProvider) actionProvider;
        }
        StringBuilder L = a.L(".sharecompat_");
        L.append(intentBuilder.a.getClass().getName());
        shareActionProvider.setShareHistoryFileName(L.toString());
        shareActionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(shareActionProvider);
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? a(intent) : callingActivity;
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        if (callingPackage != null || intent == null) {
            return callingPackage;
        }
        String stringExtra = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
        return stringExtra == null ? intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP) : stringExtra;
    }

    public static void configureMenuItem(@NonNull Menu menu, @IdRes int i, @NonNull IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        throw new IllegalArgumentException(a.Q2("Could not find menu item with id ", i, " in the supplied menu"));
    }
}
