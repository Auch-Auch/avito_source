package com.facebook.referrals;

import java.util.Collections;
import java.util.List;
public class ReferralResult {
    public final List<String> a;

    public ReferralResult(List<String> list) {
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((ReferralResult) obj).a);
    }

    public List<String> getReferralCodes() {
        return Collections.unmodifiableList(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
