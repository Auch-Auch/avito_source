package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;
import l6.b.d.k;
import l6.b.d.l;
import l6.b.d.m;
public class ListPopupWindow implements ShowableListMenu {
    public static Method G = null;
    public static Method H = null;
    public static Method I = null;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int WRAP_CONTENT = -2;
    public Runnable A;
    public final Handler B;
    public final Rect C;
    public Rect D;
    public boolean E;
    public PopupWindow F;
    public Context a;
    public ListAdapter b;
    public k c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public View p;
    public int q;
    public DataSetObserver r;
    public View s;
    public Drawable t;
    public AdapterView.OnItemClickListener u;
    public AdapterView.OnItemSelectedListener v;
    public final f w;
    public final e x;
    public final d y;
    public final b z;

    public class a extends ForwardingListener {
        public a(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            return ListPopupWindow.this;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    public class c extends DataSetObserver {
        public c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.F.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.B.removeCallbacks(listPopupWindow.w);
                ListPopupWindow.this.w.run();
            }
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.F) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.F.getWidth() && y >= 0 && y < ListPopupWindow.this.F.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.B.postDelayed(listPopupWindow.w, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.B.removeCallbacks(listPopupWindow2.w);
                return false;
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = ListPopupWindow.this.c;
            if (kVar != null && ViewCompat.isAttachedToWindow(kVar) && ListPopupWindow.this.c.getCount() > ListPopupWindow.this.c.getChildCount()) {
                int childCount = ListPopupWindow.this.c.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.o) {
                    listPopupWindow.F.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public void clearListSelection() {
        k kVar = this.c;
        if (kVar != null) {
            kVar.setListSelectionHidden(true);
            kVar.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new a(view);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.F.dismiss();
        View view = this.p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.p);
            }
        }
        this.F.setContentView(null);
        this.c = null;
        this.B.removeCallbacks(this.w);
    }

    @NonNull
    public k e(Context context, boolean z2) {
        return new k(context, z2);
    }

    @Nullable
    public View getAnchorView() {
        return this.s;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.F.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.F.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.D != null) {
            return new Rect(this.D);
        }
        return null;
    }

    public int getHeight() {
        return this.d;
    }

    public int getHorizontalOffset() {
        return this.f;
    }

    public int getInputMethodMode() {
        return this.F.getInputMethodMode();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    @Nullable
    public ListView getListView() {
        return this.c;
    }

    public int getPromptPosition() {
        return this.q;
    }

    @Nullable
    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.c.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.c.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.c.getSelectedItemPosition();
    }

    @Nullable
    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.c.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.F.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.i) {
            return 0;
        }
        return this.g;
    }

    public int getWidth() {
        return this.e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.m;
    }

    public boolean isInputMethodNotNeeded() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.E;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.F.isShowing();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if ((r12 == 66 || r12 == 23) == false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r12, @androidx.annotation.NonNull android.view.KeyEvent r13) {
        /*
            r11 = this;
            boolean r0 = r11.isShowing()
            r1 = 0
            if (r0 == 0) goto L_0x00aa
            r0 = 62
            if (r12 == r0) goto L_0x00aa
            l6.b.d.k r0 = r11.c
            int r0 = r0.getSelectedItemPosition()
            r2 = 23
            r3 = 66
            r4 = 1
            if (r0 >= 0) goto L_0x0022
            if (r12 == r3) goto L_0x001f
            if (r12 != r2) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            if (r0 != 0) goto L_0x00aa
        L_0x0022:
            l6.b.d.k r0 = r11.c
            int r0 = r0.getSelectedItemPosition()
            android.widget.PopupWindow r5 = r11.F
            boolean r5 = r5.isAboveAnchor()
            r5 = r5 ^ r4
            android.widget.ListAdapter r6 = r11.b
            r7 = 2147483647(0x7fffffff, float:NaN)
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r6 == 0) goto L_0x005b
            boolean r7 = r6.areAllItemsEnabled()
            if (r7 == 0) goto L_0x0040
            r8 = 0
            goto L_0x0046
        L_0x0040:
            l6.b.d.k r8 = r11.c
            int r8 = r8.lookForSelectablePosition(r1, r4)
        L_0x0046:
            if (r7 == 0) goto L_0x004e
            int r6 = r6.getCount()
            int r6 = r6 - r4
            goto L_0x0059
        L_0x004e:
            l6.b.d.k r7 = r11.c
            int r6 = r6.getCount()
            int r6 = r6 - r4
            int r6 = r7.lookForSelectablePosition(r6, r1)
        L_0x0059:
            r7 = r8
            r8 = r6
        L_0x005b:
            r6 = 19
            if (r5 == 0) goto L_0x0063
            if (r12 != r6) goto L_0x0063
            if (r0 <= r7) goto L_0x006b
        L_0x0063:
            r9 = 20
            if (r5 != 0) goto L_0x0077
            if (r12 != r9) goto L_0x0077
            if (r0 < r8) goto L_0x0077
        L_0x006b:
            r11.clearListSelection()
            android.widget.PopupWindow r12 = r11.F
            r12.setInputMethodMode(r4)
            r11.show()
            return r4
        L_0x0077:
            l6.b.d.k r10 = r11.c
            r10.setListSelectionHidden(r1)
            l6.b.d.k r10 = r11.c
            boolean r13 = r10.onKeyDown(r12, r13)
            if (r13 == 0) goto L_0x009c
            android.widget.PopupWindow r13 = r11.F
            r0 = 2
            r13.setInputMethodMode(r0)
            l6.b.d.k r13 = r11.c
            r13.requestFocusFromTouch()
            r11.show()
            if (r12 == r6) goto L_0x009b
            if (r12 == r9) goto L_0x009b
            if (r12 == r2) goto L_0x009b
            if (r12 == r3) goto L_0x009b
            goto L_0x00aa
        L_0x009b:
            return r4
        L_0x009c:
            if (r5 == 0) goto L_0x00a3
            if (r12 != r9) goto L_0x00a3
            if (r0 != r8) goto L_0x00aa
            return r4
        L_0x00a3:
            if (r5 != 0) goto L_0x00aa
            if (r12 != r6) goto L_0x00aa
            if (r0 != r7) goto L_0x00aa
            return r4
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public boolean onKeyPreIme(int i2, @NonNull KeyEvent keyEvent) {
        if (i2 != 4 || !isShowing()) {
            return false;
        }
        View view = this.s;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        } else if (keyEvent.getAction() != 1) {
            return false;
        } else {
            KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
            if (keyDispatcherState2 != null) {
                keyDispatcherState2.handleUpEvent(keyEvent);
            }
            if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
                return false;
            }
            dismiss();
            return true;
        }
    }

    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        boolean z2 = false;
        if (!isShowing() || this.c.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.c.onKeyUp(i2, keyEvent);
        if (onKeyUp) {
            if (i2 == 66 || i2 == 23) {
                z2 = true;
            }
            if (z2) {
                dismiss();
            }
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i2) {
        if (!isShowing()) {
            return false;
        }
        if (this.u == null) {
            return true;
        }
        k kVar = this.c;
        this.u.onItemClick(kVar, kVar.getChildAt(i2 - kVar.getFirstVisiblePosition()), i2, kVar.getAdapter().getItemId(i2));
        return true;
    }

    public void postShow() {
        this.B.post(this.A);
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner.g
    public void setAdapter(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.r;
        if (dataSetObserver == null) {
            this.r = new c();
        } else {
            ListAdapter listAdapter2 = this.b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.r);
        }
        k kVar = this.c;
        if (kVar != null) {
            kVar.setAdapter(this.b);
        }
    }

    public void setAnchorView(@Nullable View view) {
        this.s = view;
    }

    public void setAnimationStyle(@StyleRes int i2) {
        this.F.setAnimationStyle(i2);
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i2) {
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            this.e = rect.left + rect.right + i2;
            return;
        }
        setWidth(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z2) {
        this.m = z2;
    }

    public void setDropDownGravity(int i2) {
        this.l = i2;
    }

    public void setEpicenterBounds(@Nullable Rect rect) {
        this.D = rect != null ? new Rect(rect) : null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z2) {
        this.n = z2;
    }

    public void setHeight(int i2) {
        if (i2 >= 0 || -2 == i2 || -1 == i2) {
            this.d = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int i2) {
        this.f = i2;
    }

    public void setInputMethodMode(int i2) {
        this.F.setInputMethodMode(i2);
    }

    public void setListSelector(Drawable drawable) {
        this.t = drawable;
    }

    public void setModal(boolean z2) {
        this.E = z2;
        this.F.setFocusable(z2);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.u = onItemClickListener;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.v = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z2) {
        this.k = true;
        this.j = z2;
    }

    public void setPromptPosition(int i2) {
        this.q = i2;
    }

    public void setPromptView(@Nullable View view) {
        View view2;
        boolean isShowing = isShowing();
        if (isShowing && (view2 = this.p) != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.p);
            }
        }
        this.p = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i2) {
        k kVar = this.c;
        if (isShowing() && kVar != null) {
            kVar.setListSelectionHidden(false);
            kVar.setSelection(i2);
            if (kVar.getChoiceMode() != 0) {
                kVar.setItemChecked(i2, true);
            }
        }
    }

    public void setSoftInputMode(int i2) {
        this.F.setSoftInputMode(i2);
    }

    public void setVerticalOffset(int i2) {
        this.g = i2;
        this.i = true;
    }

    public void setWidth(int i2) {
        this.e = i2;
    }

    public void setWindowLayoutType(int i2) {
        this.h = i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v22, resolved type: android.widget.LinearLayout */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2 = true;
        if (this.c == null) {
            Context context = this.a;
            this.A = new l(this);
            k e2 = e(context, !this.E);
            this.c = e2;
            Drawable drawable = this.t;
            if (drawable != null) {
                e2.setSelector(drawable);
            }
            this.c.setAdapter(this.b);
            this.c.setOnItemClickListener(this.u);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new m(this));
            this.c.setOnScrollListener(this.y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.v;
            if (onItemSelectedListener != null) {
                this.c.setOnItemSelectedListener(onItemSelectedListener);
            }
            k kVar = this.c;
            View view = this.p;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i8 = this.q;
                if (i8 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(kVar, layoutParams);
                } else if (i8 == 1) {
                    linearLayout.addView(kVar, layoutParams);
                    linearLayout.addView(view);
                }
                int i9 = this.e;
                if (i9 >= 0) {
                    i7 = Integer.MIN_VALUE;
                } else {
                    i9 = 0;
                    i7 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i9, i7), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i2 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                kVar = linearLayout;
            } else {
                i2 = 0;
            }
            this.F.setContentView(kVar);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.F.getContentView();
            View view2 = this.p;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i2 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i10 = rect.top;
            i3 = rect.bottom + i10;
            if (!this.i) {
                this.g = -i10;
            }
        } else {
            this.C.setEmpty();
            i3 = 0;
        }
        boolean z3 = this.F.getInputMethodMode() == 2;
        View anchorView = getAnchorView();
        int i11 = this.g;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = H;
            if (method != null) {
                try {
                    i4 = ((Integer) method.invoke(this.F, anchorView, Integer.valueOf(i11), Boolean.valueOf(z3))).intValue();
                } catch (Exception unused) {
                }
            }
            i4 = this.F.getMaxAvailableHeight(anchorView, i11);
        } else {
            i4 = this.F.getMaxAvailableHeight(anchorView, i11, z3);
        }
        if (this.m || this.d == -1) {
            i5 = i4 + i3;
        } else {
            int i12 = this.e;
            if (i12 == -2) {
                int i13 = this.a.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.C;
                i6 = View.MeasureSpec.makeMeasureSpec(i13 - (rect2.left + rect2.right), Integer.MIN_VALUE);
            } else if (i12 != -1) {
                i6 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else {
                int i14 = this.a.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.C;
                i6 = View.MeasureSpec.makeMeasureSpec(i14 - (rect3.left + rect3.right), 1073741824);
            }
            int measureHeightOfChildrenCompat = this.c.measureHeightOfChildrenCompat(i6, 0, -1, i4 - i2, -1);
            if (measureHeightOfChildrenCompat > 0) {
                i2 += this.c.getPaddingBottom() + this.c.getPaddingTop() + i3;
            }
            i5 = measureHeightOfChildrenCompat + i2;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.F, this.h);
        if (!this.F.isShowing()) {
            int i15 = this.e;
            if (i15 == -1) {
                i15 = -1;
            } else if (i15 == -2) {
                i15 = getAnchorView().getWidth();
            }
            int i16 = this.d;
            if (i16 == -1) {
                i5 = -1;
            } else if (i16 != -2) {
                i5 = i16;
            }
            this.F.setWidth(i15);
            this.F.setHeight(i5);
            if (Build.VERSION.SDK_INT <= 28) {
                Method method2 = G;
                if (method2 != null) {
                    try {
                        method2.invoke(this.F, Boolean.TRUE);
                    } catch (Exception unused2) {
                    }
                }
            } else {
                this.F.setIsClippedToScreen(true);
            }
            this.F.setOutsideTouchable(!this.n && !this.m);
            this.F.setTouchInterceptor(this.x);
            if (this.k) {
                PopupWindowCompat.setOverlapAnchor(this.F, this.j);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method3 = I;
                if (method3 != null) {
                    try {
                        method3.invoke(this.F, this.D);
                    } catch (Exception unused3) {
                    }
                }
            } else {
                this.F.setEpicenterBounds(this.D);
            }
            PopupWindowCompat.showAsDropDown(this.F, getAnchorView(), this.f, this.g, this.l);
            this.c.setSelection(-1);
            if (!this.E || this.c.isInTouchMode()) {
                clearListSelection();
            }
            if (!this.E) {
                this.B.post(this.z);
            }
        } else if (ViewCompat.isAttachedToWindow(getAnchorView())) {
            int i17 = this.e;
            if (i17 == -1) {
                i17 = -1;
            } else if (i17 == -2) {
                i17 = getAnchorView().getWidth();
            }
            int i18 = this.d;
            if (i18 == -1) {
                if (!isInputMethodNotNeeded) {
                    i5 = -1;
                }
                if (isInputMethodNotNeeded) {
                    this.F.setWidth(this.e == -1 ? -1 : 0);
                    this.F.setHeight(0);
                } else {
                    this.F.setWidth(this.e == -1 ? -1 : 0);
                    this.F.setHeight(-1);
                }
            } else if (i18 != -2) {
                i5 = i18;
            }
            PopupWindow popupWindow = this.F;
            if (this.n || this.m) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.F.update(getAnchorView(), this.f, this.g, i17 < 0 ? -1 : i17, i5 < 0 ? -1 : i5);
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this.d = -2;
        this.e = -2;
        this.h = 1002;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = Integer.MAX_VALUE;
        this.q = 0;
        this.w = new f();
        this.x = new e();
        this.y = new d();
        this.z = new b();
        this.C = new Rect();
        this.a = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i2, i3);
        this.f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.i = true;
        }
        obtainStyledAttributes.recycle();
        l6.b.d.e eVar = new l6.b.d.e(context, attributeSet, i2, i3);
        this.F = eVar;
        eVar.setInputMethodMode(1);
    }
}
