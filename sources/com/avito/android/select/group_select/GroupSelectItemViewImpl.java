package com.avito.android.select.group_select;

import a2.g.r.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.lib.design.toggle.Checkbox;
import com.avito.android.lib.design.toggle.OnStateChangedListener;
import com.avito.android.lib.design.toggle.State;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.select.R;
import com.avito.android.select.group_select.SelectableView;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.ViewGroupsKt;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107B\u0019\b\u0016\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b6\u0010:J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u00020\u00052\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010\u0004\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010%R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u0006;"}, d2 = {"Lcom/avito/android/select/group_select/GroupSelectItemViewImpl;", "Landroid/widget/LinearLayout;", "Lcom/avito/android/select/group_select/GroupSelectItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "setIndeterminate", "()V", "Lkotlin/Function1;", "Lcom/avito/android/lib/design/toggle/State;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectionStateListener", "(Lkotlin/jvm/functions/Function1;)V", "", "isSelected", "selectionListener", "addSelectOption", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "notify", "select", "(ZZ)V", PanelStateKt.PANEL_EXPANDED, "animate", "setExpanded", "isCollapsible", "setIsCollapsible", "(Z)V", "Lcom/avito/android/lib/design/toggle/Checkbox;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/toggle/Checkbox;", "checkbox", AuthSource.SEND_ABUSE, "Landroid/widget/LinearLayout;", TariffPackageInfoConverterKt.HEADER_STRING_ID, g.a, "Z", "isViewSelected", "h", "Lkotlin/jvm/functions/Function1;", "e", "itemsContainer", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "f", "isExpanded", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "icon", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectItemViewImpl extends LinearLayout implements GroupSelectItemView {
    public final LinearLayout a;
    public final Checkbox b;
    public final TextView c;
    public final ImageView d;
    public final LinearLayout e;
    public boolean f;
    public boolean g;
    public Function1<? super State, Unit> h;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                GroupSelectItemViewImpl groupSelectItemViewImpl = (GroupSelectItemViewImpl) this.b;
                groupSelectItemViewImpl.setExpanded(!groupSelectItemViewImpl.f, true);
            } else if (i == 1) {
                ((GroupSelectItemViewImpl) this.b).b.toggle();
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupSelectItemViewImpl(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.group_select_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.header);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.header)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.a = linearLayout;
        View findViewById2 = linearLayout.findViewById(R.id.checkbox);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "header.findViewById(R.id.checkbox)");
        Checkbox checkbox = (Checkbox) findViewById2;
        this.b = checkbox;
        View findViewById3 = linearLayout.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "header.findViewById(R.id.title)");
        this.c = (TextView) findViewById3;
        View findViewById4 = linearLayout.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "header.findViewById(R.id.icon)");
        ImageView imageView = (ImageView) findViewById4;
        this.d = imageView;
        View findViewById5 = findViewById(R.id.items_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.items_container)");
        this.e = (LinearLayout) findViewById5;
        imageView.setOnClickListener(new a(0, this));
        linearLayout.setOnClickListener(new a(1, this));
        checkbox.setOnStateChangedListener(new OnStateChangedListener(this) { // from class: com.avito.android.select.group_select.GroupSelectItemViewImpl.3
            public final /* synthetic */ GroupSelectItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.toggle.OnStateChangedListener
            public void onStateChanged(@NotNull Checkbox checkbox2, @NotNull State state) {
                Intrinsics.checkNotNullParameter(checkbox2, "checkbox");
                Intrinsics.checkNotNullParameter(state, "currentState");
                if (state == State.CHECKED) {
                    SelectableView.DefaultImpls.select$default(this.a, true, false, 2, null);
                } else if (state == State.UNCHECKED) {
                    SelectableView.DefaultImpls.select$default(this.a, false, false, 2, null);
                }
                Function1 function1 = this.a.h;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(state);
                }
            }
        });
    }

    @Override // com.avito.android.select.group_select.GroupSelectItemView
    public void addSelectOption(@NotNull String str, boolean z, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function1, "selectionListener");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GroupSelectOption groupSelectOption = new GroupSelectOption(context);
        groupSelectOption.setTitle(str);
        groupSelectOption.select(z, false);
        groupSelectOption.setSelectionListener(function1);
        this.e.addView(groupSelectOption);
    }

    @Override // com.avito.android.select.group_select.GroupSelectItemView, com.avito.android.select.group_select.SelectableView
    public void select(boolean z, boolean z2) {
        if (this.g != z || this.b.isIndeterminate()) {
            this.g = z;
            this.b.setChecked(z);
            Iterator<View> children = ViewGroupsKt.getChildren(this.e);
            while (children.hasNext()) {
                View next = children.next();
                if (next instanceof SelectableView) {
                    ((SelectableView) next).select(z, z2);
                }
            }
        }
    }

    @Override // com.avito.android.select.group_select.GroupSelectItemView
    public void setExpanded(boolean z, boolean z2) {
        int i;
        boolean z3 = this.f;
        if (z3 != z) {
            boolean z4 = !z3;
            this.f = z4;
            this.d.setRotation(z4 ? 180.0f : 0.0f);
            int i2 = -2;
            if (z2) {
                if (this.f) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    LinearLayout linearLayout = this.e;
                    ViewParent parent = getParent();
                    Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
                    linearLayout.measure(View.MeasureSpec.makeMeasureSpec(((View) parent).getWidth(), 1073741824), makeMeasureSpec);
                    i = this.e.getMeasuredHeight();
                } else {
                    i = 0;
                }
                ViewParent parent2 = getParent();
                Objects.requireNonNull(parent2, "null cannot be cast to non-null type android.view.View");
                ((View) parent2).getLayoutParams().height = -2;
                ValueAnimator ofInt = ValueAnimator.ofInt(this.e.getHeight(), i);
                Intrinsics.checkNotNullExpressionValue(ofInt, "animator");
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new a2.a.a.m2.l.a(this));
                ofInt.start();
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            if (!this.f) {
                i2 = 0;
            }
            layoutParams.height = i2;
            this.e.requestLayout();
        }
    }

    @Override // com.avito.android.select.group_select.GroupSelectItemView
    public void setIndeterminate() {
        this.b.setIndeterminate(true);
        this.g = false;
    }

    @Override // com.avito.android.select.group_select.GroupSelectItemView
    public void setIsCollapsible(boolean z) {
        Views.setVisible(this.d, z);
    }

    @Override // com.avito.android.select.group_select.GroupSelectItemView
    public void setSelectionStateListener(@Nullable Function1<? super State, Unit> function1) {
        this.h = function1;
    }

    @Override // com.avito.android.select.group_select.GroupSelectItemView
    public void setTitle(@Nullable String str) {
        this.c.setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupSelectItemViewImpl(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.group_select_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.header);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.header)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.a = linearLayout;
        View findViewById2 = linearLayout.findViewById(R.id.checkbox);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "header.findViewById(R.id.checkbox)");
        Checkbox checkbox = (Checkbox) findViewById2;
        this.b = checkbox;
        View findViewById3 = linearLayout.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "header.findViewById(R.id.title)");
        this.c = (TextView) findViewById3;
        View findViewById4 = linearLayout.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "header.findViewById(R.id.icon)");
        ImageView imageView = (ImageView) findViewById4;
        this.d = imageView;
        View findViewById5 = findViewById(R.id.items_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.items_container)");
        this.e = (LinearLayout) findViewById5;
        imageView.setOnClickListener(new a(0, this));
        linearLayout.setOnClickListener(new a(1, this));
        checkbox.setOnStateChangedListener(new OnStateChangedListener(this) { // from class: com.avito.android.select.group_select.GroupSelectItemViewImpl.3
            public final /* synthetic */ GroupSelectItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.toggle.OnStateChangedListener
            public void onStateChanged(@NotNull Checkbox checkbox2, @NotNull State state) {
                Intrinsics.checkNotNullParameter(checkbox2, "checkbox");
                Intrinsics.checkNotNullParameter(state, "currentState");
                if (state == State.CHECKED) {
                    SelectableView.DefaultImpls.select$default(this.a, true, false, 2, null);
                } else if (state == State.UNCHECKED) {
                    SelectableView.DefaultImpls.select$default(this.a, false, false, 2, null);
                }
                Function1 function1 = this.a.h;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(state);
                }
            }
        });
    }
}
