package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import java.util.Objects;
public class ShareActionProvider extends ActionProvider {
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    public int d = 4;
    public final b e = new b();
    public final Context f;
    public String g = DEFAULT_SHARE_HISTORY_FILE_NAME;
    public OnShareTargetSelectedListener h;
    public ActivityChooserModel.OnChooseActivityListener i;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    public class a implements ActivityChooserModel.OnChooseActivityListener {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.h;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
            return false;
        }
    }

    public class b implements MenuItem.OnMenuItemClickListener {
        public b() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            Intent b = ActivityChooserModel.d(shareActionProvider.f, shareActionProvider.g).b(menuItem.getItemId());
            if (b == null) {
                return true;
            }
            String action = b.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                Objects.requireNonNull(ShareActionProvider.this);
                b.addFlags(134742016);
            }
            ShareActionProvider.this.f.startActivity(b);
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f = context;
    }

    public final void a() {
        if (this.h != null) {
            if (this.i == null) {
                this.i = new a();
            }
            ActivityChooserModel d2 = ActivityChooserModel.d(this.f, this.g);
            ActivityChooserModel.OnChooseActivityListener onChooseActivityListener = this.i;
            synchronized (d2.a) {
                d2.m = onChooseActivityListener;
            }
        }
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.d(this.f, this.g));
        }
        TypedValue typedValue = new TypedValue();
        this.f.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.f, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel d2 = ActivityChooserModel.d(this.f, this.g);
        PackageManager packageManager = this.f.getPackageManager();
        int f2 = d2.f();
        int min = Math.min(f2, this.d);
        for (int i2 = 0; i2 < min; i2++) {
            ResolveInfo e2 = d2.e(i2);
            subMenu.add(0, i2, i2, e2.loadLabel(packageManager)).setIcon(e2.loadIcon(packageManager)).setOnMenuItemClickListener(this.e);
        }
        if (min < f2) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i3 = 0; i3 < f2; i3++) {
                ResolveInfo e3 = d2.e(i3);
                addSubMenu.add(0, i3, i3, e3.loadLabel(packageManager)).setIcon(e3.loadIcon(packageManager)).setOnMenuItemClickListener(this.e);
            }
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.h = onShareTargetSelectedListener;
        a();
    }

    public void setShareHistoryFileName(String str) {
        this.g = str;
        a();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                intent.addFlags(134742016);
            }
        }
        ActivityChooserModel d2 = ActivityChooserModel.d(this.f, this.g);
        synchronized (d2.a) {
            if (d2.f != intent) {
                d2.f = intent;
                d2.l = true;
                d2.c();
            }
        }
    }
}
