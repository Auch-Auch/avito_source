package com.avito.android.theme_settings.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.theme_settings.analytics.ThemeSettingsEvent;
import com.avito.android.theme_settings.item.ThemeModeItemPresenter;
import com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R(\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModelImpl;", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "", "Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "refreshItems", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/avito/android/serp/adapter/SpannedItem;", "d", "Landroidx/lifecycle/MutableLiveData;", "itemChangesLiveData", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverter;", g.a, "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverter;", "converter", "Lcom/avito/android/lib/util/DarkThemeManager;", "f", "Lcom/avito/android/lib/util/DarkThemeManager;", "darkThemeManager", "Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;", "h", "Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;", "resourceProvider", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "getItemChanges", "()Landroidx/lifecycle/LiveData;", "itemChanges", "<init>", "(Lcom/avito/android/lib/util/DarkThemeManager;Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverter;Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeSettingsViewModelImpl extends ViewModel implements ThemeSettingsViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public final MutableLiveData<List<SpannedItem>> d;
    @NotNull
    public final LiveData<List<SpannedItem>> e;
    public final DarkThemeManager f;
    public final ThemeSettingsConverter g;
    public final ThemeSettingsResourceProvider h;
    public final Analytics i;

    public static final class a<T> implements Consumer<ThemeModeItemPresenter.Action> {
        public final /* synthetic */ ThemeSettingsViewModelImpl a;

        public a(ThemeSettingsViewModelImpl themeSettingsViewModelImpl) {
            this.a = themeSettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ThemeModeItemPresenter.Action action) {
            ThemeModeItemPresenter.Action action2 = action;
            if (action2 instanceof ThemeModeItemPresenter.Action.Activate) {
                ThemeModeItemPresenter.Action.Activate activate = (ThemeModeItemPresenter.Action.Activate) action2;
                ThemeSettingsViewModelImpl.access$changeMode(this.a, activate.getMode(), activate.getTargetState());
            }
        }
    }

    public ThemeSettingsViewModelImpl(@NotNull DarkThemeManager darkThemeManager, @NotNull ThemeSettingsConverter themeSettingsConverter, @NotNull ThemeSettingsResourceProvider themeSettingsResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(darkThemeManager, "darkThemeManager");
        Intrinsics.checkNotNullParameter(themeSettingsConverter, "converter");
        Intrinsics.checkNotNullParameter(themeSettingsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = darkThemeManager;
        this.g = themeSettingsConverter;
        this.h = themeSettingsResourceProvider;
        this.i = analytics;
        MutableLiveData<List<SpannedItem>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        this.e = mutableLiveData;
        refreshItems();
    }

    public static final void access$changeMode(ThemeSettingsViewModelImpl themeSettingsViewModelImpl, DarkThemeManager.Mode mode, boolean z) {
        ThemeSettingsEvent.Mode mode2;
        DarkThemeManager darkThemeManager = themeSettingsViewModelImpl.f;
        if (!z && themeSettingsViewModelImpl.h.isDarkTheme()) {
            mode = DarkThemeManager.Mode.DarkAlways.INSTANCE;
        } else if (!z && !themeSettingsViewModelImpl.h.isDarkTheme()) {
            mode = DarkThemeManager.Mode.LightAlways.INSTANCE;
        }
        darkThemeManager.setCurrentMode(mode);
        themeSettingsViewModelImpl.refreshItems();
        DarkThemeManager.Mode currentMode = themeSettingsViewModelImpl.f.getCurrentMode();
        if (Intrinsics.areEqual(currentMode, DarkThemeManager.Mode.LightAlways.INSTANCE)) {
            mode2 = ThemeSettingsEvent.Mode.LIGHT;
        } else if (Intrinsics.areEqual(currentMode, DarkThemeManager.Mode.DarkAlways.INSTANCE)) {
            mode2 = ThemeSettingsEvent.Mode.DARK;
        } else {
            mode2 = ThemeSettingsEvent.Mode.AUTO;
        }
        themeSettingsViewModelImpl.i.track(new ThemeSettingsEvent(mode2, ThemeSettingsEvent.Screen.SETTINGS));
    }

    @Override // com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModel
    @NotNull
    public LiveData<List<SpannedItem>> getItemChanges() {
        return this.e;
    }

    @Override // com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModel
    public void observeItemClicks(@NotNull Set<? extends ThemeModeItemPresenter> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.c.clear();
        CompositeDisposable compositeDisposable = this.c;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getActions());
        }
        Disposable subscribe = Observable.merge(arrayList).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.merge(itemPre…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
    }

    @Override // com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModel
    public void refreshItems() {
        DarkThemeManager.Mode currentMode = this.f.getCurrentMode();
        MutableLiveData<List<SpannedItem>> mutableLiveData = this.d;
        List<DarkThemeManager.Mode> availableModes = this.f.getAvailableModes();
        ArrayList<ThemeModeItemState> arrayList = new ArrayList(e.collectionSizeOrDefault(availableModes, 10));
        for (T t : availableModes) {
            arrayList.add(new ThemeModeItemState(t, Intrinsics.areEqual(t, currentMode)));
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (ThemeModeItemState themeModeItemState : arrayList) {
            arrayList2.add(this.g.convert(themeModeItemState));
        }
        mutableLiveData.setValue(arrayList2);
    }
}
