package com.avito.android.rating.user_contacts;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.rating.R;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.user_contacts.UserContactsView;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.data_source.DataSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b+\u0010,J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsViewImpl;", "Lcom/avito/android/rating/user_contacts/UserContactsView;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "dataSource", "", "setItems", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "show", "showEmptyState", "(Z)V", "", "message", "showMessage", "(Ljava/lang/String;)V", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "e", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "f", "Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "spanProvider", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "emptyState", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserContactsViewImpl implements UserContactsView {
    public final Resources a;
    public final RecyclerView b;
    public final ViewGroup c;
    public final View d;
    public final ResponsiveAdapterPresenter e;
    public final UserContactsSpanProvider f;

    public UserContactsViewImpl(@NotNull View view, @NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull ItemBinder itemBinder, @NotNull UserContactsSpanProvider userContactsSpanProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(userContactsSpanProvider, "spanProvider");
        this.d = view;
        this.e = responsiveAdapterPresenter;
        this.f = userContactsSpanProvider;
        Resources resources = view.getResources();
        this.a = resources;
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        View findViewById2 = view.findViewById(R.id.empty_state);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = (ViewGroup) findViewById2;
        AppBar.DefaultImpls.setNavigationIcon$default(new AppBarImpl(view, recyclerView, false, 4, null), com.avito.android.ui_components.R.drawable.ic_back_24, null, 2, null);
        Unit unit = Unit.INSTANCE;
        int integer = resources.getInteger(R.integer.user_contacts_column_count);
        ResponsiveRecyclerAdapter responsiveRecyclerAdapter = new ResponsiveRecyclerAdapter(responsiveAdapterPresenter, itemBinder);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), integer);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this, integer) { // from class: com.avito.android.rating.user_contacts.UserContactsViewImpl$$special$$inlined$apply$lambda$1
            public final /* synthetic */ UserContactsViewImpl e;
            public final /* synthetic */ int f;

            {
                this.e = r1;
                this.f = r2;
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                return this.e.f.getSpan(i, this.f);
            }
        });
        recyclerView.setAdapter(responsiveRecyclerAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new GridItemDecorator(integer, resources.getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.standard_padding), resources.getDimensionPixelSize(R.dimen.user_contact_item_column_padding)));
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        UserContactsView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsView
    public void setItems(@NotNull DataSource<RatingDetailsItem> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.e.onDataSourceChanged(dataSource);
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsView
    public void showEmptyState(boolean z) {
        Views.setVisible(this.c, z);
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.d, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
