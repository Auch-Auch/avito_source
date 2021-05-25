package com.avito.android.section;

import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.RecommendationSectionScrollMaxPosEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.SectionItemPresenter;
import com.avito.android.section.di.SectionModule;
import com.avito.android.section.title.SectionTitleItemPresenter;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001$B%\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b'\u0010(J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/section/SectionItemPresenterImpl;", "Lcom/avito/android/section/SectionItemPresenter;", "Lcom/avito/android/section/SectionItemView;", "view", "Lcom/avito/android/section/SectionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/section/SectionItemView;Lcom/avito/android/section/SectionItem;I)V", "", "id", "firstCompletelyVisibleItemPosition", "lastVisibleItemPosition", "onCurrentPositionChanged", "(Ljava/lang/String;II)V", "invalidateState", "()V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "sendAnalytics", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/section/title/SectionTitleItemPresenter;", "c", "Lcom/avito/android/section/title/SectionTitleItemPresenter;", "titlePresenter", "", "Lcom/avito/android/section/SectionItemPresenterImpl$a;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "maxScrollPositions", AuthSource.SEND_ABUSE, "Landroid/os/Bundle;", "state", "<init>", "(Lcom/avito/android/section/title/SectionTitleItemPresenter;Lcom/avito/android/analytics/Analytics;Landroid/os/Bundle;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionItemPresenterImpl implements SectionItemPresenter {
    public final Bundle a;
    public final Map<String, a> b;
    public final SectionTitleItemPresenter c;
    public final Analytics d;

    public static final class a {
        @NotNull
        public final String a;
        public int b;

        public a(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "context");
            this.a = str;
            this.b = i;
        }
    }

    @Inject
    public SectionItemPresenterImpl(@NotNull SectionTitleItemPresenter sectionTitleItemPresenter, @NotNull Analytics analytics, @SectionModule.SavedState @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(sectionTitleItemPresenter, "titlePresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.c = sectionTitleItemPresenter;
        this.d = analytics;
        this.a = bundle == null ? new Bundle() : bundle;
        this.b = new LinkedHashMap();
    }

    @Override // com.avito.android.section.SectionItemPresenter
    public void invalidateState() {
        this.a.clear();
        sendAnalytics();
    }

    @Override // com.avito.android.section.SectionItemPresenter
    public void onCurrentPositionChanged(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.a.putInt(str, i);
        Bundle bundle = this.a;
        bundle.putInt(str + "LAST_VISIBLE_ITEM", i2);
        a aVar = this.b.get(str);
        if (aVar != null) {
            aVar.b = Math.max(aVar.b, i2);
        }
    }

    @Override // com.avito.android.section.SectionItemPresenter
    @NotNull
    public Bundle onSaveState() {
        return this.a;
    }

    @Override // com.avito.android.section.SectionItemPresenter
    public void sendAnalytics() {
        for (Map.Entry<String, a> entry : this.b.entrySet()) {
            a value = entry.getValue();
            int i = value.b;
            if (i > -1) {
                this.d.track(new RecommendationSectionScrollMaxPosEvent(value.a, i));
                value.b = -1;
            }
        }
    }

    public void viewAttached(@NotNull SectionItemView sectionItemView, int i) {
        Intrinsics.checkNotNullParameter(sectionItemView, "view");
        SectionItemPresenter.DefaultImpls.viewAttached(this, sectionItemView, i);
    }

    public void viewDetached(@NotNull SectionItemView sectionItemView, int i) {
        Intrinsics.checkNotNullParameter(sectionItemView, "view");
        SectionItemPresenter.DefaultImpls.viewDetached(this, sectionItemView, i);
    }

    public void bindView(@NotNull SectionItemView sectionItemView, @NotNull SectionItem sectionItem, int i) {
        boolean z;
        T t;
        boolean z2;
        Intrinsics.checkNotNullParameter(sectionItemView, "view");
        Intrinsics.checkNotNullParameter(sectionItem, "item");
        Iterator<T> it = sectionItem.getItems().iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            if (!(t2 instanceof AdvertItem) || t2.getViewType() != SerpViewType.BIG) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (t == null) {
            z = false;
        }
        if (z) {
            sectionItemView.setupViewForLargeItems();
        } else {
            sectionItemView.setupViewForSmallItems();
        }
        ListDataSource listDataSource = new ListDataSource(sectionItem.getItems());
        sectionItemView.getAdapterPresenter().onDataSourceChanged(listDataSource);
        sectionItemView.getFavoritesPresenter().onDataSourceChanged(listDataSource);
        sectionItemView.getViewedAdvertsPresenter().onDataSourceChanged(listDataSource);
        sectionItemView.getFavoritesPresenter().attachView(sectionItemView);
        sectionItemView.getViewedAdvertsPresenter().attachView(sectionItemView);
        sectionItemView.onDataSourceChanged();
        this.c.bindView(sectionItemView, sectionItem, i);
        sectionItemView.setTag(sectionItem.getStringId());
        sectionItemView.setCurrentPosition(this.a.getInt(sectionItem.getStringId(), 0));
        String context = sectionItem.getContext();
        if (context != null && !this.b.containsKey(sectionItem.getStringId())) {
            Bundle bundle = this.a;
            String stringId = sectionItem.getStringId();
            this.b.put(sectionItem.getStringId(), new a(context, bundle.getInt(stringId + "LAST_VISIBLE_ITEM")));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SectionItemPresenterImpl(SectionTitleItemPresenter sectionTitleItemPresenter, Analytics analytics, Bundle bundle, int i, j jVar) {
        this(sectionTitleItemPresenter, analytics, (i & 4) != 0 ? null : bundle);
    }
}
