package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+BK\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010$\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u0006\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0003\"\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001f\u001a\u00020\u001e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0019\u0010!\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010 ¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/WizardParameter;", "Lcom/avito/android/remote/model/CategoryModel;", "buildRootParameter", "()Lcom/avito/android/remote/model/WizardParameter;", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "parent", "", "setupParentLinks", "(Ljava/util/List;Lcom/avito/android/remote/model/WizardParameter;)V", "Lcom/avito/android/remote/model/Navigation;", "navigation", "findNodeByNavigation", "(Lcom/avito/android/remote/model/Navigation;)Lcom/avito/android/remote/model/WizardParameter;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "children", "Ljava/util/List;", "getChildren", "()Ljava/util/List;", "Lcom/avito/android/remote/model/WizardParameter;", "getParent", "setParent", "(Lcom/avito/android/remote/model/WizardParameter;)V", "", "isRoot", "()Z", "hasChildren", "Z", "getHasChildren", "", "title", "description", "rootNavigation", "isCrossVertical", "<init>", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Navigation;Ljava/lang/Boolean;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class WizardParameter extends CategoryModel {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<WizardParameter> CREATOR = Parcels.creator(WizardParameter$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<WizardParameter> children;
    private final boolean hasChildren;
    @Nullable
    private WizardParameter parent;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/WizardParameter$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/WizardParameter;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WizardParameter(Navigation navigation, String str, String str2, List list, Navigation navigation2, Boolean bool, int i, j jVar) {
        this(navigation, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : navigation2, (i & 32) != 0 ? null : bool);
    }

    private final WizardParameter buildRootParameter() {
        setupParentLinks(this.children, this);
        return this;
    }

    private final void setupParentLinks(List<WizardParameter> list, WizardParameter wizardParameter) {
        for (T t : list) {
            t.parent = wizardParameter;
            if (t.hasChildren) {
                setupParentLinks(t.children, t);
            }
        }
    }

    @Override // com.avito.android.remote.model.CategoryModel, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final WizardParameter findNodeByNavigation(@NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        return Intrinsics.areEqual(navigation, getNavigation()) ? this : (WizardParameter) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(this.children), new Function1<WizardParameter, WizardParameter>(navigation) { // from class: com.avito.android.remote.model.WizardParameter$findNodeByNavigation$1
            public final /* synthetic */ Navigation $navigation;

            {
                this.$navigation = r1;
            }

            @Nullable
            public final WizardParameter invoke(@NotNull WizardParameter wizardParameter) {
                Intrinsics.checkNotNullParameter(wizardParameter, VKApiUserFull.RelativeType.CHILD);
                return wizardParameter.findNodeByNavigation(this.$navigation);
            }
        }));
    }

    @NotNull
    public final List<WizardParameter> getChildren() {
        return this.children;
    }

    public final boolean getHasChildren() {
        return this.hasChildren;
    }

    @Nullable
    public final WizardParameter getParent() {
        return this.parent;
    }

    public final boolean isRoot() {
        return this.parent == null;
    }

    public final void setParent(@Nullable WizardParameter wizardParameter) {
        this.parent = wizardParameter;
    }

    @Override // com.avito.android.remote.model.CategoryModel, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(getNavigation(), i);
        parcel.writeString(getTitle());
        parcel.writeString(getDescription());
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.children, 0, 2, null);
        parcel.writeParcelable(getRootNavigation(), i);
        ParcelsKt.writeOptBoolean(parcel, Boolean.valueOf(isVerticalChange()));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WizardParameter(@NotNull Navigation navigation, @NotNull String str, @Nullable String str2, @NotNull List<WizardParameter> list, @Nullable Navigation navigation2, @Nullable Boolean bool) {
        super(navigation, str, str2, navigation2, bool);
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "children");
        this.children = list;
        buildRootParameter();
        this.hasChildren = !list.isEmpty();
    }
}
