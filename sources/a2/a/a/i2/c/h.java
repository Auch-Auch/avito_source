package a2.a.a.i2.c;

import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class h<T> implements Consumer<LoadingState<? super Unit>> {
    public final /* synthetic */ ProfileDeliverySettingsViewModelImpl a;
    public final /* synthetic */ SwitcherItem b;

    public h(ProfileDeliverySettingsViewModelImpl profileDeliverySettingsViewModelImpl, SwitcherItem switcherItem) {
        this.a = profileDeliverySettingsViewModelImpl;
        this.b = switcherItem;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX DEBUG: Multi-variable search result rejected for r5v19, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b8  */
    @Override // io.reactivex.rxjava3.functions.Consumer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accept(com.avito.android.util.LoadingState<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            com.avito.android.util.LoadingState r5 = (com.avito.android.util.LoadingState) r5
            boolean r0 = r5 instanceof com.avito.android.util.LoadingState.Loading
            if (r0 == 0) goto L_0x001d
            com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl r5 = r4.a
            com.jakewharton.rxrelay3.PublishRelay r5 = com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl.access$getSwitcherLoadingStateRelay$p(r5)
            com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem r0 = r4.b
            java.lang.String r0 = r0.getStringId()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)
            r5.accept(r0)
            goto L_0x00df
        L_0x001d:
            boolean r0 = r5 instanceof com.avito.android.util.LoadingState.Loaded
            if (r0 == 0) goto L_0x00c6
            com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem r5 = r4.b
            boolean r0 = r5.isChecked()
            r1 = 1
            r0 = r0 ^ r1
            r5.setChecked(r0)
            com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl r5 = r4.a
            com.jakewharton.rxrelay3.PublishRelay r5 = com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl.access$getSwitcherLoadingStateRelay$p(r5)
            com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem r0 = r4.b
            java.lang.String r0 = r0.getStringId()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)
            r5.accept(r0)
            com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl r5 = r4.a
            androidx.collection.ArrayMap r5 = com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl.access$getAreSwitchersValueChanged$p(r5)
            com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem r0 = r4.b
            java.lang.String r0 = r0.getStringId()
            com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl r2 = r4.a
            androidx.collection.ArrayMap r2 = com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl.access$getAreSwitchersValueChanged$p(r2)
            com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem r3 = r4.b
            java.lang.String r3 = r3.getStringId()
            java.lang.Object r2 = r2.get(r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            r3 = 0
            if (r2 == 0) goto L_0x0067
            boolean r2 = r2.booleanValue()
            goto L_0x0068
        L_0x0067:
            r2 = 0
        L_0x0068:
            r2 = r2 ^ r1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r5.put(r0, r2)
            com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl r5 = r4.a
            androidx.collection.ArrayMap r5 = com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl.access$getAreSwitchersValueChanged$p(r5)
            java.util.Collection r5 = r5.values()
            java.lang.String r0 = "areSwitchersValueChanged.values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            boolean r0 = r5 instanceof java.util.Collection
            if (r0 == 0) goto L_0x008a
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x008a
            goto L_0x00a6
        L_0x008a:
            java.util.Iterator r5 = r5.iterator()
        L_0x008e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00a6
            java.lang.Object r0 = r5.next()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            java.lang.String r2 = "changed"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x008e
            goto L_0x00a7
        L_0x00a6:
            r1 = 0
        L_0x00a7:
            if (r1 == 0) goto L_0x00b8
            com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl r5 = r4.a
            com.avito.android.util.architecture_components.SingleLiveEvent r5 = r5.getActivityResultChanges()
            r0 = -1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5.setValue(r0)
            goto L_0x00df
        L_0x00b8:
            com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl r5 = r4.a
            com.avito.android.util.architecture_components.SingleLiveEvent r5 = r5.getActivityResultChanges()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r5.setValue(r0)
            goto L_0x00df
        L_0x00c6:
            boolean r5 = r5 instanceof com.avito.android.util.LoadingState.Error
            if (r5 == 0) goto L_0x00df
            com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl r5 = r4.a
            com.jakewharton.rxrelay3.PublishRelay r5 = com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl.access$getSwitcherLoadingStateRelay$p(r5)
            com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem r0 = r4.b
            java.lang.String r0 = r0.getStringId()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)
            r5.accept(r0)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.i2.c.h.accept(java.lang.Object):void");
    }
}
