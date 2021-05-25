package com.avito.android.advert_core.advert;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\nR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\nR\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\n¨\u0006,"}, d2 = {"Lcom/avito/android/advert_core/advert/AdvertDetailsGroupViewImpl;", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupView;", "", "Lcom/avito/android/remote/model/AdvertParameters$Group;", "groups", "", "bind", "(Ljava/util/List;)V", "", g.a, "I", "valueSubTitleId", "h", "valueDescriptionId", "", "j", "Z", "isRedesign", "f", "valueTitleId", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "container", "e", "groupTitleId", "c", "Ljava/util/List;", "lastBoundGroups", "d", "dividerId", "i", "valueListItemId", "Landroid/view/View;", "view", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/view/View;Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGroupViewImpl implements AdvertDetailsGroupView {
    public final LayoutInflater a;
    public ViewGroup b;
    public List<AdvertParameters.Group> c = CollectionsKt__CollectionsKt.emptyList();
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final boolean j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsGroupsListener a;

        public a(AdvertDetailsGroupsListener advertDetailsGroupsListener) {
            this.a = advertDetailsGroupsListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AdvertDetailsGroupsListener advertDetailsGroupsListener = this.a;
            if (advertDetailsGroupsListener != null) {
                advertDetailsGroupsListener.onGroupsClick();
            }
        }
    }

    public AdvertDetailsGroupViewImpl(@NotNull View view, @Nullable AdvertDetailsGroupsListener advertDetailsGroupsListener, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.j = z;
        this.a = LayoutInflater.from(view.getContext());
        this.d = z ? R.layout.rds_divider_1_gray150 : com.avito.android.deprecated_design.R.layout.divider_1_0;
        this.e = z ? R.layout.rds_advert_group_title : R.layout.part_advert_group_title;
        this.f = z ? R.layout.rds_list_item_1_0_dense_title : R.layout.list_item_1_0_dense_title;
        this.g = z ? R.layout.rds_list_item_1_0_dense_subtitle : R.layout.list_item_1_0_dense_subtitle;
        this.h = z ? R.layout.rds_advert_group_value_description : R.layout.part_advert_group_value_description;
        this.i = z ? R.layout.rds_list_item_1_0_dense : R.layout.list_item_1_0_dense;
        View findViewById = view.findViewById(com.avito.android.advert_core.R.id.groups_stub);
        findViewById = findViewById == null ? view.findViewById(R.id.groups_container) : findViewById;
        if (findViewById instanceof ViewStub) {
            ViewStub viewStub = (ViewStub) findViewById;
            viewStub.setInflatedId(R.id.groups_container);
            View inflate = viewStub.inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            this.b = (ViewGroup) inflate;
        } else if (findViewById instanceof ViewGroup) {
            this.b = (ViewGroup) findViewById;
        }
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new a(advertDetailsGroupsListener));
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertDetailsGroupView
    public void bind(@Nullable List<AdvertParameters.Group> list) {
        boolean z;
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            if (list == null || list.isEmpty()) {
                Views.hide(viewGroup);
                viewGroup.removeAllViews();
                return;
            }
            if (list.size() == this.c.size()) {
                Iterator<T> it = list.iterator();
                int i2 = 0;
                loop0:
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    T next = it.next();
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    T t = next;
                    AdvertParameters.Group group = this.c.get(i2);
                    if ((!Intrinsics.areEqual(group.getTitle(), t.getTitle())) || group.getParameters().size() != t.getParameters().size()) {
                        break;
                    }
                    int i4 = 0;
                    for (T t2 : t.getParameters()) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        T t3 = t2;
                        AdvertParameters.Parameter parameter = group.getParameters().get(i4);
                        if ((!Intrinsics.areEqual(t3.getTitle(), parameter.getTitle())) || (!Intrinsics.areEqual(t3.getDescription(), parameter.getDescription()))) {
                            break loop0;
                        }
                        i4 = i5;
                    }
                    i2 = i3;
                }
            }
            z = false;
            if (!z) {
                viewGroup.removeAllViews();
                Views.show(viewGroup);
                if (!this.j) {
                    this.a.inflate(this.d, viewGroup, true);
                }
                for (AdvertParameters.Group group2 : list) {
                    if (this.j) {
                        this.a.inflate(this.d, viewGroup, true);
                    }
                    String title = group2.getTitle();
                    View inflate = this.a.inflate(this.e, viewGroup, false);
                    Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                    TextView textView = (TextView) inflate;
                    textView.setText(title);
                    viewGroup.addView(textView);
                    for (AdvertParameters.Parameter parameter2 : group2.getParameters()) {
                        String title2 = parameter2.getTitle();
                        List<String> subtitles = parameter2.getSubtitles();
                        View inflate2 = this.a.inflate(this.i, viewGroup, false);
                        Objects.requireNonNull(inflate2, "null cannot be cast to non-null type android.view.ViewGroup");
                        ViewGroup viewGroup2 = (ViewGroup) inflate2;
                        View inflate3 = this.a.inflate(this.f, viewGroup2, false);
                        Objects.requireNonNull(inflate3, "null cannot be cast to non-null type android.widget.TextView");
                        TextView textView2 = (TextView) inflate3;
                        textView2.setText(title2);
                        viewGroup2.addView(textView2);
                        for (String str : subtitles) {
                            View inflate4 = this.a.inflate(this.g, viewGroup2, false);
                            Objects.requireNonNull(inflate4, "null cannot be cast to non-null type android.widget.TextView");
                            TextView textView3 = (TextView) inflate4;
                            textView3.setText(str);
                            viewGroup2.addView(textView3);
                        }
                        viewGroup.addView(viewGroup2);
                        String description = parameter2.getDescription();
                        if (description != null) {
                            View inflate5 = this.a.inflate(this.h, viewGroup, false);
                            Objects.requireNonNull(inflate5, "null cannot be cast to non-null type android.widget.TextView");
                            TextView textView4 = (TextView) inflate5;
                            textView4.setText(description);
                            viewGroup.addView(textView4);
                        }
                    }
                }
                this.c = list;
            }
        }
    }
}
