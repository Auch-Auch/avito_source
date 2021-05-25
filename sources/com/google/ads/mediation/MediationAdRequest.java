package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
@Deprecated
public class MediationAdRequest {
    public final Date a;
    public final AdRequest.Gender b;
    public final Set<String> c;
    public final boolean d;
    public final Location e;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.a = date;
        this.b = gender;
        this.c = set;
        this.d = z;
        this.e = location;
    }

    public Integer getAgeInYears() {
        if (this.a == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.a);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.a;
    }

    public AdRequest.Gender getGender() {
        return this.b;
    }

    public Set<String> getKeywords() {
        return this.c;
    }

    public Location getLocation() {
        return this.e;
    }

    public boolean isTesting() {
        return this.d;
    }
}
