package com.avito.android.publish.infomodel_request;

import android.os.Bundle;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "isInitialRequest", "trackDraftResumed", "Lcom/avito/android/publish/infomodel_request/InfomodelRequestFragment;", "createInfomodelRequestFragment", "(ZZ)Lcom/avito/android/publish/infomodel_request/InfomodelRequestFragment;", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class InfomodelRequestFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(boolean z, boolean z2) {
            super(1);
            this.a = z;
            this.b = z2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putBoolean("is_initial_request", this.a);
            bundle2.putBoolean("track_draft_resumed", this.b);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final InfomodelRequestFragment createInfomodelRequestFragment(boolean z, boolean z2) {
        return (InfomodelRequestFragment) FragmentsKt.arguments$default(new InfomodelRequestFragment(), 0, new a(z, z2), 1, null);
    }
}
