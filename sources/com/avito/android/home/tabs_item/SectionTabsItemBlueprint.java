package com.avito.android.home.tabs_item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.R;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/avito/android/home/tabs_item/SectionTabsItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/home/tabs_item/SectionTabsItemView;", "Lcom/avito/android/home/tabs_item/SectionTabsItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "component1", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "Lcom/avito/android/util/preferences/Preferences;", "defaultPreferences", "copy", "(Lcom/avito/konveyor/blueprint/ItemPresenter;Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/home/tabs_item/SectionTabsItemBlueprint;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "c", "Lcom/avito/android/util/preferences/Preferences;", "<init>", "(Lcom/avito/konveyor/blueprint/ItemPresenter;Lcom/avito/android/util/preferences/Preferences;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTabsItemBlueprint implements ItemBlueprint<SectionTabsItemView, SectionTabsItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.section_tabs_item, new a(this));
    @NotNull
    public final ItemPresenter<SectionTabsItemView, SectionTabsItem> b;
    public final Preferences c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, BaseViewHolder> {
        public final /* synthetic */ SectionTabsItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SectionTabsItemBlueprint sectionTabsItemBlueprint) {
            super(2);
            this.a = sectionTabsItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public BaseViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new SectionTabsItemViewImpl(view2, this.a.c);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.konveyor.blueprint.ItemPresenter<? super com.avito.android.home.tabs_item.SectionTabsItemView, ? super com.avito.android.home.tabs_item.SectionTabsItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public SectionTabsItemBlueprint(@NotNull ItemPresenter<? super SectionTabsItemView, ? super SectionTabsItem> itemPresenter, @NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(itemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(preferences, "defaultPreferences");
        this.b = itemPresenter;
        this.c = preferences;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.home.tabs_item.SectionTabsItemBlueprint */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SectionTabsItemBlueprint copy$default(SectionTabsItemBlueprint sectionTabsItemBlueprint, ItemPresenter itemPresenter, Preferences preferences, int i, Object obj) {
        if ((i & 1) != 0) {
            itemPresenter = sectionTabsItemBlueprint.getPresenter();
        }
        if ((i & 2) != 0) {
            preferences = sectionTabsItemBlueprint.c;
        }
        return sectionTabsItemBlueprint.copy(itemPresenter, preferences);
    }

    @NotNull
    public final ItemPresenter<SectionTabsItemView, SectionTabsItem> component1() {
        return getPresenter();
    }

    @NotNull
    public final SectionTabsItemBlueprint copy(@NotNull ItemPresenter<? super SectionTabsItemView, ? super SectionTabsItem> itemPresenter, @NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(itemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(preferences, "defaultPreferences");
        return new SectionTabsItemBlueprint(itemPresenter, preferences);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SectionTabsItemBlueprint)) {
            return false;
        }
        SectionTabsItemBlueprint sectionTabsItemBlueprint = (SectionTabsItemBlueprint) obj;
        return Intrinsics.areEqual(getPresenter(), sectionTabsItemBlueprint.getPresenter()) && Intrinsics.areEqual(this.c, sectionTabsItemBlueprint.c);
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SectionTabsItemView, SectionTabsItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return this.a;
    }

    public int hashCode() {
        ItemPresenter<SectionTabsItemView, SectionTabsItem> presenter = getPresenter();
        int i = 0;
        int hashCode = (presenter != null ? presenter.hashCode() : 0) * 31;
        Preferences preferences = this.c;
        if (preferences != null) {
            i = preferences.hashCode();
        }
        return hashCode + i;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof SectionTabsItem;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SectionTabsItemBlueprint(presenter=");
        L.append(getPresenter());
        L.append(", defaultPreferences=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
