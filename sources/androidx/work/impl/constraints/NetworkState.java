package androidx.work.impl.constraints;

import androidx.annotation.NonNull;
public class NetworkState {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public NetworkState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        if (this.a == networkState.a && this.b == networkState.b && this.c == networkState.c && this.d == networkState.d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.a ? 1 : 0;
        if (this.b) {
            i += 16;
        }
        if (this.c) {
            i += 256;
        }
        return this.d ? i + 4096 : i;
    }

    public boolean isConnected() {
        return this.a;
    }

    public boolean isMetered() {
        return this.c;
    }

    public boolean isNotRoaming() {
        return this.d;
    }

    public boolean isValidated() {
        return this.b;
    }

    @NonNull
    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.a), Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }
}
