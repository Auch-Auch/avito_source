package com.avito.android.publish;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000f\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001cR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0001\u000f\u001d\u001e\u001f !\"#$%&'()*+¨\u0006,"}, d2 = {"Lcom/avito/android/publish/RoutingAction;", "", "", AuthSource.SEND_ABUSE, "Z", "getLogStepOpening", "()Z", "logStepOpening", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "getScreenTransfer", "()Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "screenTransfer", "BackToStep", "CancelPublish", BaseAnalyticKt.ANALYTIC_ACTION_EDIT, "InfomodelRequest", "LeavePublish", "Premoderation", "Pretend", "Publish", "ToAuth", "ToCategoriesSuggestions", "ToDetailsParams", "ToInputVin", "ToSelect", "ToWizard", "UnexpectedError", "Lcom/avito/android/publish/RoutingAction$ToDetailsParams;", "Lcom/avito/android/publish/RoutingAction$ToInputVin;", "Lcom/avito/android/publish/RoutingAction$ToSelect;", "Lcom/avito/android/publish/RoutingAction$ToWizard;", "Lcom/avito/android/publish/RoutingAction$ToCategoriesSuggestions;", "Lcom/avito/android/publish/RoutingAction$InfomodelRequest;", "Lcom/avito/android/publish/RoutingAction$Pretend;", "Lcom/avito/android/publish/RoutingAction$Premoderation;", "Lcom/avito/android/publish/RoutingAction$Publish;", "Lcom/avito/android/publish/RoutingAction$Edit;", "Lcom/avito/android/publish/RoutingAction$BackToStep;", "Lcom/avito/android/publish/RoutingAction$LeavePublish;", "Lcom/avito/android/publish/RoutingAction$CancelPublish;", "Lcom/avito/android/publish/RoutingAction$UnexpectedError;", "Lcom/avito/android/publish/RoutingAction$ToAuth;", "publish_release"}, k = 1, mv = {1, 4, 2})
public abstract class RoutingAction {
    public final boolean a;
    @Nullable
    public final ScreenTransfer b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/RoutingAction$BackToStep;", "Lcom/avito/android/publish/RoutingAction;", "", "c", "I", "getStepIndex", "()I", "stepIndex", "", "logStepOpening", "<init>", "(IZ)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class BackToStep extends RoutingAction {
        public final int c;

        public BackToStep(int i, boolean z) {
            super(z, (ScreenTransfer) null, 2);
            this.c = i;
        }

        public final int getStepIndex() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$CancelPublish;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class CancelPublish extends RoutingAction {
        @NotNull
        public static final CancelPublish INSTANCE = new CancelPublish();

        public CancelPublish() {
            super(false, (ScreenTransfer) null, 3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$Edit;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Edit extends RoutingAction {
        @NotNull
        public static final Edit INSTANCE = new Edit();

        public Edit() {
            super(false, (ScreenTransfer) null, 3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/RoutingAction$InfomodelRequest;", "Lcom/avito/android/publish/RoutingAction;", "", "component1", "()Z", "isInitial", "copy", "(Z)Lcom/avito/android/publish/RoutingAction$InfomodelRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Z", "<init>", "(Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class InfomodelRequest extends RoutingAction {
        public final boolean c;

        public InfomodelRequest(boolean z) {
            super(false, (ScreenTransfer) null, 3);
            this.c = z;
        }

        public static /* synthetic */ InfomodelRequest copy$default(InfomodelRequest infomodelRequest, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = infomodelRequest.c;
            }
            return infomodelRequest.copy(z);
        }

        public final boolean component1() {
            return this.c;
        }

        @NotNull
        public final InfomodelRequest copy(boolean z) {
            return new InfomodelRequest(z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof InfomodelRequest) && this.c == ((InfomodelRequest) obj).c;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.c;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isInitial() {
            return this.c;
        }

        @NotNull
        public String toString() {
            return a.B(a.L("InfomodelRequest(isInitial="), this.c, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$LeavePublish;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class LeavePublish extends RoutingAction {
        @NotNull
        public static final LeavePublish INSTANCE = new LeavePublish();

        public LeavePublish() {
            super(false, (ScreenTransfer) null, 3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$Premoderation;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Premoderation extends RoutingAction {
        @NotNull
        public static final Premoderation INSTANCE = new Premoderation();

        public Premoderation() {
            super(false, (ScreenTransfer) null, 3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$Pretend;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Pretend extends RoutingAction {
        @NotNull
        public static final Pretend INSTANCE = new Pretend();

        public Pretend() {
            super(false, (ScreenTransfer) null, 3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$Publish;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Publish extends RoutingAction {
        @NotNull
        public static final Publish INSTANCE = new Publish();

        public Publish() {
            super(false, (ScreenTransfer) null, 3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$ToAuth;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ToAuth extends RoutingAction {
        @NotNull
        public static final ToAuth INSTANCE = new ToAuth();

        public ToAuth() {
            super(false, (ScreenTransfer) null, 3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$ToCategoriesSuggestions;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ToCategoriesSuggestions extends RoutingAction {
        @NotNull
        public static final ToCategoriesSuggestions INSTANCE = new ToCategoriesSuggestions();

        public ToCategoriesSuggestions() {
            super(true, (ScreenTransfer) null, 2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/RoutingAction$ToDetailsParams;", "Lcom/avito/android/publish/RoutingAction;", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "screenTransfer", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ToDetailsParams extends RoutingAction {
        public ToDetailsParams(@Nullable ScreenTransfer screenTransfer) {
            super(true, screenTransfer, (j) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$ToInputVin;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ToInputVin extends RoutingAction {
        @NotNull
        public static final ToInputVin INSTANCE = new ToInputVin();

        public ToInputVin() {
            super(true, (ScreenTransfer) null, 2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$ToSelect;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ToSelect extends RoutingAction {
        @NotNull
        public static final ToSelect INSTANCE = new ToSelect();

        public ToSelect() {
            super(true, (ScreenTransfer) null, 2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/RoutingAction$ToWizard;", "Lcom/avito/android/publish/RoutingAction;", "", "Lcom/avito/android/remote/model/Navigation;", "d", "Ljava/util/List;", "getLeaves", "()Ljava/util/List;", "leaves", "c", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "()Lcom/avito/android/remote/model/Navigation;", "navigation", "<init>", "(Lcom/avito/android/remote/model/Navigation;Ljava/util/List;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ToWizard extends RoutingAction {
        @NotNull
        public final Navigation c;
        @Nullable
        public final List<Navigation> d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ToWizard(@NotNull Navigation navigation, @Nullable List<Navigation> list) {
            super(true, (ScreenTransfer) null, 2);
            Intrinsics.checkNotNullParameter(navigation, "navigation");
            this.c = navigation;
            this.d = list;
        }

        @Nullable
        public final List<Navigation> getLeaves() {
            return this.d;
        }

        @NotNull
        public final Navigation getNavigation() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/RoutingAction$UnexpectedError;", "Lcom/avito/android/publish/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnexpectedError extends RoutingAction {
        @NotNull
        public static final UnexpectedError INSTANCE = new UnexpectedError();

        public UnexpectedError() {
            super(false, (ScreenTransfer) null, 3);
        }
    }

    public RoutingAction(boolean z, ScreenTransfer screenTransfer, int i) {
        int i2 = i & 2;
        this.a = (i & 1) != 0 ? false : z;
        this.b = null;
    }

    public final boolean getLogStepOpening() {
        return this.a;
    }

    @Nullable
    public final ScreenTransfer getScreenTransfer() {
        return this.b;
    }

    public RoutingAction(boolean z, ScreenTransfer screenTransfer, j jVar) {
        this.a = z;
        this.b = screenTransfer;
    }
}
