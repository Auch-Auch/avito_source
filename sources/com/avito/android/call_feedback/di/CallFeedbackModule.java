package com.avito.android.call_feedback.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.call_feedback.CallFeedbackInteractor;
import com.avito.android.call_feedback.CallFeedbackPresenter;
import com.avito.android.call_feedback.list.item.CallFeedbackListItem;
import com.avito.android.call_feedback.list.item.CallFeedbackListItemBlueprint;
import com.avito.android.call_feedback.list.item.CallFeedbackListItemPresenter;
import com.avito.android.call_feedback.list.item.CallFeedbackListItemView;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitle;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitleBlueprint;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitlePresenter;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitleView;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/call_feedback/di/CallFeedbackModule;", "", "Lcom/jakewharton/rxrelay2/Relay;", "", "provideRelay$call_feedback_release", "()Lcom/jakewharton/rxrelay2/Relay;", "provideRelay", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemBlueprint;", "listItemBlueprint", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleBlueprint;", "listTitleBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$call_feedback_release", "(Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemBlueprint;Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideRecyclerViewAdapter$call_feedback_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideRecyclerViewAdapter", "provideAdapterPresenter$call_feedback_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "<init>", "()V", "Declarations", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class, Declarations.class})
public final class CallFeedbackModule {
    @NotNull
    public static final CallFeedbackModule INSTANCE = new CallFeedbackModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/call_feedback/di/CallFeedbackModule$Declarations;", "", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemView;", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItem;", "bindCallFeedbackListItemBlueprint", "(Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemPresenter$Impl;", "presenter", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemPresenter;", "bindCallFeedbackListItemPresenter", "(Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemPresenter$Impl;)Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemPresenter;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleBlueprint;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleView;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitle;", "bindCallFeedbackListTitleBlueprint", "(Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitlePresenter$Impl;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitlePresenter;", "bindCallFeedbackListTitlePresenter", "(Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitlePresenter$Impl;)Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitlePresenter;", "Lcom/avito/android/call_feedback/CallFeedbackInteractor$Impl;", "Lcom/avito/android/call_feedback/CallFeedbackInteractor;", "bindCallFeedbackInteractor", "(Lcom/avito/android/call_feedback/CallFeedbackInteractor$Impl;)Lcom/avito/android/call_feedback/CallFeedbackInteractor;", "Lcom/avito/android/call_feedback/CallFeedbackPresenter$Impl;", "Lcom/avito/android/call_feedback/CallFeedbackPresenter;", "bindCallFeedbackPresenter", "(Lcom/avito/android/call_feedback/CallFeedbackPresenter$Impl;)Lcom/avito/android/call_feedback/CallFeedbackPresenter;", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        CallFeedbackInteractor bindCallFeedbackInteractor(@NotNull CallFeedbackInteractor.Impl impl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<CallFeedbackListItemView, CallFeedbackListItem> bindCallFeedbackListItemBlueprint(@NotNull CallFeedbackListItemBlueprint callFeedbackListItemBlueprint);

        @PerActivity
        @Binds
        @NotNull
        CallFeedbackListItemPresenter bindCallFeedbackListItemPresenter(@NotNull CallFeedbackListItemPresenter.Impl impl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<CallFeedbackListTitleView, CallFeedbackListTitle> bindCallFeedbackListTitleBlueprint(@NotNull CallFeedbackListTitleBlueprint callFeedbackListTitleBlueprint);

        @PerActivity
        @Binds
        @NotNull
        CallFeedbackListTitlePresenter bindCallFeedbackListTitlePresenter(@NotNull CallFeedbackListTitlePresenter.Impl impl);

        @PerActivity
        @Binds
        @NotNull
        CallFeedbackPresenter bindCallFeedbackPresenter(@NotNull CallFeedbackPresenter.Impl impl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter$call_feedback_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ItemBinder provideItemBinder$call_feedback_release(@NotNull CallFeedbackListItemBlueprint callFeedbackListItemBlueprint, @NotNull CallFeedbackListTitleBlueprint callFeedbackListTitleBlueprint) {
        Intrinsics.checkNotNullParameter(callFeedbackListItemBlueprint, "listItemBlueprint");
        Intrinsics.checkNotNullParameter(callFeedbackListTitleBlueprint, "listTitleBlueprint");
        return new ItemBinder.Builder().registerItem(callFeedbackListItemBlueprint).registerItem(callFeedbackListTitleBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final RecyclerView.Adapter<?> provideRecyclerViewAdapter$call_feedback_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final Relay<String> provideRelay$call_feedback_release() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
