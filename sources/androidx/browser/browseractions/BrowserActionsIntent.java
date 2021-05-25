package androidx.browser.browseractions;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.browser.R;
import androidx.core.content.ContextCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l6.c.a.a;
import l6.c.a.b;
import l6.c.a.d;
import l6.c.a.e;
@Deprecated
public class BrowserActionsIntent {
    public static final String ACTION_BROWSER_ACTIONS_OPEN = "androidx.browser.browseractions.browser_action_open";
    public static final String EXTRA_APP_ID = "androidx.browser.browseractions.APP_ID";
    public static final String EXTRA_MENU_ITEMS = "androidx.browser.browseractions.extra.MENU_ITEMS";
    public static final String EXTRA_SELECTED_ACTION_PENDING_INTENT = "androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT";
    public static final String EXTRA_TYPE = "androidx.browser.browseractions.extra.TYPE";
    public static final int ITEM_COPY = 3;
    public static final int ITEM_DOWNLOAD = 2;
    public static final int ITEM_INVALID_ITEM = -1;
    public static final int ITEM_OPEN_IN_INCOGNITO = 1;
    public static final int ITEM_OPEN_IN_NEW_TAB = 0;
    public static final int ITEM_SHARE = 4;
    public static final String KEY_ACTION = "androidx.browser.browseractions.ACTION";
    public static final String KEY_ICON_ID = "androidx.browser.browseractions.ICON_ID";
    public static final String KEY_TITLE = "androidx.browser.browseractions.TITLE";
    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_CUSTOM_ITEMS = 5;
    public static final int URL_TYPE_AUDIO = 3;
    public static final int URL_TYPE_FILE = 4;
    public static final int URL_TYPE_IMAGE = 1;
    public static final int URL_TYPE_NONE = 0;
    public static final int URL_TYPE_PLUGIN = 5;
    public static final int URL_TYPE_VIDEO = 2;
    @NonNull
    public final Intent a;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface BrowserActionsItemId {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface BrowserActionsUrlType {
    }

    public BrowserActionsIntent(@NonNull Intent intent) {
        this.a = intent;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static List<ResolveInfo> getBrowserActionsIntentHandlers(@NonNull Context context) {
        return context.getPackageManager().queryIntentActivities(new Intent(ACTION_BROWSER_ACTIONS_OPEN, Uri.parse("https://www.example.com")), 131072);
    }

    @Nullable
    @Deprecated
    public static String getCreatorPackageName(@NonNull Intent intent) {
        return getUntrustedCreatorPackageName(intent);
    }

    @Nullable
    public static String getUntrustedCreatorPackageName(@NonNull Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(EXTRA_APP_ID);
        if (pendingIntent != null) {
            return pendingIntent.getCreatorPackage();
        }
        return null;
    }

    public static void launchIntent(@NonNull Context context, @NonNull Intent intent) {
        List<ResolveInfo> browserActionsIntentHandlers = getBrowserActionsIntentHandlers(context);
        if (browserActionsIntentHandlers == null || browserActionsIntentHandlers.size() == 0) {
            Uri data = intent.getData();
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(EXTRA_MENU_ITEMS);
            e eVar = new e(context, data, parcelableArrayListExtra != null ? parseBrowserActionItems(parcelableArrayListExtra) : null);
            View inflate = LayoutInflater.from(context).inflate(R.layout.browser_actions_context_menu_page, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.browser_actions_header_text);
            textView.setText(eVar.b.toString());
            textView.setOnClickListener(new d(eVar, textView));
            ListView listView = (ListView) inflate.findViewById(R.id.browser_actions_menu_items);
            listView.setAdapter((ListAdapter) new a(eVar.c, eVar.a));
            listView.setOnItemClickListener(eVar);
            b bVar = new b(eVar.a, (BrowserActionsFallbackMenuView) inflate.findViewById(R.id.browser_actions_menu_view));
            eVar.d = bVar;
            bVar.setContentView(inflate);
            eVar.d.show();
            return;
        }
        int i = 0;
        if (browserActionsIntentHandlers.size() == 1) {
            intent.setPackage(browserActionsIntentHandlers.get(0).activityInfo.packageName);
        } else {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com")), 65536);
            if (resolveActivity != null) {
                String str = resolveActivity.activityInfo.packageName;
                while (true) {
                    if (i >= browserActionsIntentHandlers.size()) {
                        break;
                    } else if (str.equals(browserActionsIntentHandlers.get(i).activityInfo.packageName)) {
                        intent.setPackage(str);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        ContextCompat.startActivity(context, intent, null);
    }

    public static void openBrowserAction(@NonNull Context context, @NonNull Uri uri) {
        launchIntent(context, new Builder(context, uri).build().getIntent());
    }

    @NonNull
    public static List<BrowserActionItem> parseBrowserActionItems(@NonNull ArrayList<Bundle> arrayList) {
        BrowserActionItem browserActionItem;
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = arrayList.get(i);
            String string = bundle.getString(KEY_TITLE);
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(KEY_ACTION);
            int i2 = bundle.getInt(KEY_ICON_ID);
            Uri uri = (Uri) bundle.getParcelable("androidx.browser.browseractions.ICON_URI");
            if (TextUtils.isEmpty(string) || pendingIntent == null) {
                throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            }
            if (i2 != 0) {
                browserActionItem = new BrowserActionItem(string, pendingIntent, i2);
            } else {
                browserActionItem = new BrowserActionItem(string, pendingIntent, uri);
            }
            arrayList2.add(browserActionItem);
        }
        return arrayList2;
    }

    @NonNull
    public Intent getIntent() {
        return this.a;
    }

    public static void openBrowserAction(@NonNull Context context, @NonNull Uri uri, int i, @NonNull ArrayList<BrowserActionItem> arrayList, @NonNull PendingIntent pendingIntent) {
        launchIntent(context, new Builder(context, uri).setUrlType(i).setCustomItems(arrayList).setOnItemSelectedAction(pendingIntent).build().getIntent());
    }

    public static final class Builder {
        public final Intent a = new Intent(BrowserActionsIntent.ACTION_BROWSER_ACTIONS_OPEN);
        public Context b;
        public Uri c;
        public int d = 0;
        public ArrayList<Bundle> e = new ArrayList<>();
        @Nullable
        public PendingIntent f = null;
        public List<Uri> g = new ArrayList();

        public Builder(@NonNull Context context, @NonNull Uri uri) {
            this.b = context;
            this.c = uri;
        }

        @NonNull
        public BrowserActionsIntent build() {
            this.a.setData(this.c);
            this.a.putExtra(BrowserActionsIntent.EXTRA_TYPE, this.d);
            this.a.putParcelableArrayListExtra(BrowserActionsIntent.EXTRA_MENU_ITEMS, this.e);
            this.a.putExtra(BrowserActionsIntent.EXTRA_APP_ID, PendingIntent.getActivity(this.b, 0, new Intent(), 0));
            PendingIntent pendingIntent = this.f;
            if (pendingIntent != null) {
                this.a.putExtra(BrowserActionsIntent.EXTRA_SELECTED_ACTION_PENDING_INTENT, pendingIntent);
            }
            BrowserServiceFileProvider.grantReadPermission(this.a, this.g, this.b);
            return new BrowserActionsIntent(this.a);
        }

        @NonNull
        public Builder setCustomItems(@NonNull ArrayList<BrowserActionItem> arrayList) {
            if (arrayList.size() <= 5) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (TextUtils.isEmpty(arrayList.get(i).getTitle()) || arrayList.get(i).getAction() == null) {
                        throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
                    }
                    ArrayList<Bundle> arrayList2 = this.e;
                    BrowserActionItem browserActionItem = arrayList.get(i);
                    Bundle bundle = new Bundle();
                    bundle.putString(BrowserActionsIntent.KEY_TITLE, browserActionItem.getTitle());
                    bundle.putParcelable(BrowserActionsIntent.KEY_ACTION, browserActionItem.getAction());
                    if (browserActionItem.getIconId() != 0) {
                        bundle.putInt(BrowserActionsIntent.KEY_ICON_ID, browserActionItem.getIconId());
                    }
                    if (browserActionItem.getIconUri() != null) {
                        bundle.putParcelable("androidx.browser.browseractions.ICON_URI", browserActionItem.getIconUri());
                    }
                    arrayList2.add(bundle);
                    if (arrayList.get(i).getIconUri() != null) {
                        this.g.add(arrayList.get(i).getIconUri());
                    }
                }
                return this;
            }
            throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
        }

        @NonNull
        public Builder setOnItemSelectedAction(@NonNull PendingIntent pendingIntent) {
            this.f = pendingIntent;
            return this;
        }

        @NonNull
        public Builder setUrlType(int i) {
            this.d = i;
            return this;
        }

        @NonNull
        public Builder setCustomItems(@NonNull BrowserActionItem... browserActionItemArr) {
            return setCustomItems(new ArrayList<>(Arrays.asList(browserActionItemArr)));
        }
    }
}
