package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    public final f a;
    public final g b;
    public final View c;
    public final Drawable d;
    public final FrameLayout e;
    public final ImageView f;
    public final FrameLayout g;
    public final ImageView h;
    public final int i;
    public ActionProvider j;
    public final DataSetObserver k;
    public final ViewTreeObserver.OnGlobalLayoutListener l;
    public ListPopupWindow m;
    public PopupWindow.OnDismissListener n;
    public boolean o;
    public int p;
    public boolean q;
    public int r;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {
        public static final int[] a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, a);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.a.notifyDataSetInvalidated();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ActivityChooserView.this.isShowingPopup()) {
                return;
            }
            if (!ActivityChooserView.this.isShown()) {
                ActivityChooserView.this.getListPopupWindow().dismiss();
                return;
            }
            ActivityChooserView.this.getListPopupWindow().show();
            ActionProvider actionProvider = ActivityChooserView.this.j;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(true);
            }
        }
    }

    public class c extends View.AccessibilityDelegate {
        public c(ActivityChooserView activityChooserView) {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
        }
    }

    public class d extends ForwardingListener {
        public d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStarted() {
            ActivityChooserView.this.showPopup();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStopped() {
            ActivityChooserView.this.dismissPopup();
            return true;
        }
    }

    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            int size;
            super.onChanged();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.a.getCount() > 0) {
                activityChooserView.e.setEnabled(true);
            } else {
                activityChooserView.e.setEnabled(false);
            }
            int f = activityChooserView.a.a.f();
            ActivityChooserModel activityChooserModel = activityChooserView.a.a;
            synchronized (activityChooserModel.a) {
                activityChooserModel.c();
                size = activityChooserModel.c.size();
            }
            if (f == 1 || (f > 1 && size > 0)) {
                activityChooserView.g.setVisibility(0);
                ResolveInfo g = activityChooserView.a.a.g();
                PackageManager packageManager = activityChooserView.getContext().getPackageManager();
                activityChooserView.h.setImageDrawable(g.loadIcon(packageManager));
                if (activityChooserView.r != 0) {
                    activityChooserView.g.setContentDescription(activityChooserView.getContext().getString(activityChooserView.r, g.loadLabel(packageManager)));
                }
            } else {
                activityChooserView.g.setVisibility(8);
            }
            if (activityChooserView.g.getVisibility() == 0) {
                activityChooserView.c.setBackgroundDrawable(activityChooserView.d);
            } else {
                activityChooserView.c.setBackgroundDrawable(null);
            }
        }
    }

    public class f extends BaseAdapter {
        public ActivityChooserModel a;
        public int b = 4;
        public boolean c;
        public boolean d;
        public boolean e;

        public f() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int f2 = this.a.f();
            if (!this.c && this.a.g() != null) {
                f2--;
            }
            int min = Math.min(f2, this.b);
            return this.e ? min + 1 : min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (!this.c && this.a.g() != null) {
                    i++;
                }
                return this.a.e(i);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (!this.e || i != getCount() - 1) ? 0 : 1;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.c || i != 0 || !this.d) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            int i = 0;
            if (view == activityChooserView.g) {
                activityChooserView.dismissPopup();
                ResolveInfo g = ActivityChooserView.this.a.a.g();
                ActivityChooserModel activityChooserModel = ActivityChooserView.this.a.a;
                synchronized (activityChooserModel.a) {
                    activityChooserModel.c();
                    List<ActivityChooserModel.ActivityResolveInfo> list = activityChooserModel.b;
                    int size = list.size();
                    while (true) {
                        if (i >= size) {
                            i = -1;
                            break;
                        } else if (list.get(i).resolveInfo == g) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                Intent b = ActivityChooserView.this.a.a.b(i);
                if (b != null) {
                    b.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(b);
                }
            } else if (view == activityChooserView.e) {
                activityChooserView.o = false;
                activityChooserView.a(activityChooserView.p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
            ActionProvider actionProvider = ActivityChooserView.this.j;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType == 0) {
                ActivityChooserView.this.dismissPopup();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.o) {
                    f fVar = activityChooserView.a;
                    if (!fVar.c) {
                        i++;
                    }
                    Intent b = fVar.a.b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(b);
                    }
                } else if (i > 0) {
                    ActivityChooserModel activityChooserModel = activityChooserView.a.a;
                    synchronized (activityChooserModel.a) {
                        activityChooserModel.c();
                        ActivityChooserModel.ActivityResolveInfo activityResolveInfo = activityChooserModel.b.get(i);
                        ActivityChooserModel.ActivityResolveInfo activityResolveInfo2 = activityChooserModel.b.get(0);
                        float f = activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f;
                        ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                        activityChooserModel.a(new ActivityChooserModel.HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f));
                    }
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.a(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.g) {
                if (activityChooserView.a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.o = true;
                    activityChooserView2.a(activityChooserView2.p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r13) {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserView.a(int):void");
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        return true;
    }

    public ActivityChooserModel getDataModel() {
        return this.a.a;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.m = listPopupWindow;
            listPopupWindow.setAdapter(this.a);
            this.m.setAnchorView(this);
            this.m.setModal(true);
            this.m.setOnItemClickListener(this.b);
            this.m.setOnDismissListener(this.b);
        }
        return this.m;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModel = this.a.a;
        if (activityChooserModel != null) {
            activityChooserModel.registerObserver(this.k);
        }
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModel = this.a.a;
        if (activityChooserModel != null) {
            activityChooserModel.unregisterObserver(this.k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.c.layout(0, 0, i4 - i2, i5 - i3);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        View view = this.c;
        if (this.g.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        f fVar = this.a;
        ActivityChooserView activityChooserView = ActivityChooserView.this;
        ActivityChooserModel activityChooserModel2 = activityChooserView.a.a;
        if (activityChooserModel2 != null && activityChooserView.isShown()) {
            activityChooserModel2.unregisterObserver(ActivityChooserView.this.k);
        }
        fVar.a = activityChooserModel;
        if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
            activityChooserModel.registerObserver(ActivityChooserView.this.k);
        }
        fVar.notifyDataSetChanged();
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.r = i2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.f.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.p = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider actionProvider) {
        this.j = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.q) {
            return false;
        }
        this.o = false;
        a(this.p);
        return true;
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new a();
        this.l = new b();
        this.p = 4;
        int[] iArr = R.styleable.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        this.p = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        g gVar = new g();
        this.b = gVar;
        View findViewById = findViewById(R.id.activity_chooser_view_content);
        this.c = findViewById;
        this.d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.default_activity_button);
        this.g = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i3 = R.id.image;
        this.h = (ImageView) frameLayout.findViewById(i3);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c(this));
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i3);
        this.f = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }
}
