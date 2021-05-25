package com.avito.android.profile_phones.phones_list;

import a2.a.a.c2.f.k;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.PhoneManagementLink;
import com.avito.android.profile_phones.analytics.event.AddPhoneClickedEvent;
import com.avito.android.profile_phones.analytics.event.PhoneClickedEvent;
import com.avito.android.profile_phones.phones_list.PhonesListViewModel;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b4\u00105J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u0005J\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u0005R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010&R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel;", "", "refresh", "()V", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "phone", "onPhoneClicked", "(Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState;", "phoneItemsState", "()Landroidx/lifecycle/LiveData;", "onCleared", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;", "action", "handlePhoneAction", "(Ljava/lang/String;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;)V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction;", "routingActions", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "snackbars", "message", "onPhoneActionSuccess", "(Ljava/lang/String;)V", "onAppBarActionClick", "c", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", g.a, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingActionsData", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "e", "snackbarData", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "listData", "d", "messageDisposable", "Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;", "h", "Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;", "interactor", "<init>", "(Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;Lcom/avito/android/analytics/Analytics;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesListViewModelImpl extends ViewModel implements PhonesListViewModel {
    public Disposable c;
    public Disposable d;
    public final SingleLiveEvent<String> e = new SingleLiveEvent<>();
    public final MutableLiveData<PhonesListViewModel.ListState> f = new MutableLiveData<>();
    public final SingleLiveEvent<PhonesListViewModel.RoutingAction> g = new SingleLiveEvent<>();
    public final PhonesListInteractor h;
    public final Analytics i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhoneManagementLink.ActionType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
        }
    }

    public static final class a<T> implements Consumer<List<? extends PhoneListItem>> {
        public final /* synthetic */ PhonesListViewModelImpl a;

        public a(PhonesListViewModelImpl phonesListViewModelImpl) {
            this.a = phonesListViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends PhoneListItem> list) {
            List<? extends PhoneListItem> list2 = list;
            MutableLiveData mutableLiveData = this.a.f;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            mutableLiveData.postValue(new PhonesListViewModel.ListState.Loaded(list2));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ PhonesListViewModelImpl a;

        public b(PhonesListViewModelImpl phonesListViewModelImpl) {
            this.a = phonesListViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.f.postValue(new PhonesListViewModel.ListState.Error(PhonesListViewModel.ErrorType.ListLoadingError.INSTANCE));
        }
    }

    public PhonesListViewModelImpl(@NotNull PhonesListInteractor phonesListInteractor, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(phonesListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = phonesListInteractor;
        this.i = analytics;
        c();
    }

    public final void c() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f.setValue(PhonesListViewModel.ListState.Loading.INSTANCE);
        this.c = this.h.getPhonesList().subscribe(new a(this), new b(this));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x0122 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.avito.android.deep_linking.links.PhoneManagementLink] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r4 < 11) goto L_0x004f;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // com.avito.android.profile_phones.phones_list.PhonesListViewModel
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handlePhoneAction(@org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull com.avito.android.profile_phones.phones_list.list_item.PhoneListItem.Action r11) {
        /*
        // Method dump skipped, instructions count: 369
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile_phones.phones_list.PhonesListViewModelImpl.handlePhoneAction(java.lang.String, com.avito.android.profile_phones.phones_list.list_item.PhoneListItem$Action):void");
    }

    @Override // com.avito.android.profile_phones.phones_list.PhonesListViewModel
    public void onAppBarActionClick() {
        this.i.track(new AddPhoneClickedEvent());
        this.g.postValue(PhonesListViewModel.RoutingAction.OpenPhoneAddScreen.INSTANCE);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.d;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    @Override // com.avito.android.profile_phones.phones_list.PhonesListViewModel
    public void onPhoneActionSuccess(@Nullable String str) {
        if (str != null) {
            Disposable disposable = this.d;
            if (disposable != null) {
                disposable.dispose();
            }
            this.d = Single.timer(600, TimeUnit.MILLISECONDS).subscribe(new k(this, str));
        }
        c();
    }

    @Override // com.avito.android.profile_phones.phones_list.PhonesListViewModel
    public void onPhoneClicked(@NotNull PhoneListItem phoneListItem) {
        Intrinsics.checkNotNullParameter(phoneListItem, "phone");
        Analytics analytics = this.i;
        String phone = phoneListItem.getPhone();
        boolean isVerified = phoneListItem.isVerified();
        int advertsCount = phoneListItem.getAdvertsCount();
        PhonesListViewModel.ListState value = this.f.getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type com.avito.android.profile_phones.phones_list.PhonesListViewModel.ListState.Loaded");
        analytics.track(new PhoneClickedEvent(phone, isVerified, advertsCount, Math.max(((PhonesListViewModel.ListState.Loaded) value).getList().size() - 1, 0)));
        if (!phoneListItem.getActions().isEmpty()) {
            this.g.setValue(new PhonesListViewModel.RoutingAction.OpenActionsSheet(phoneListItem.getPhone(), phoneListItem.getActions()));
        }
    }

    @Override // com.avito.android.profile_phones.phones_list.PhonesListViewModel
    @NotNull
    public LiveData<PhonesListViewModel.ListState> phoneItemsState() {
        return this.f;
    }

    @Override // com.avito.android.profile_phones.phones_list.PhonesListViewModel
    public void refresh() {
        c();
    }

    @Override // com.avito.android.profile_phones.phones_list.PhonesListViewModel
    @NotNull
    public SingleLiveEvent<PhonesListViewModel.RoutingAction> routingActions() {
        return this.g;
    }

    @Override // com.avito.android.profile_phones.phones_list.PhonesListViewModel
    @NotNull
    public SingleLiveEvent<String> snackbars() {
        return this.e;
    }
}
