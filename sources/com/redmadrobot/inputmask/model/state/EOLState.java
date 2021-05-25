package com.redmadrobot.inputmask.model.state;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/EOLState;", "Lcom/redmadrobot/inputmask/model/State;", "", FirebaseAnalytics.Param.CHARACTER, "Lcom/redmadrobot/inputmask/model/Next;", "accept", "(C)Lcom/redmadrobot/inputmask/model/Next;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class EOLState extends State {
    public EOLState() {
        super(null);
    }

    @Override // com.redmadrobot.inputmask.model.State
    @Nullable
    public Next accept(char c) {
        return null;
    }

    @Override // com.redmadrobot.inputmask.model.State
    @NotNull
    public String toString() {
        return "EOL";
    }
}
