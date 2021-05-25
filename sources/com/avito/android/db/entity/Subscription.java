package com.avito.android.db.entity;
public class Subscription {
    public long a = -1;
    public String b;
    public String c;
    public String d;
    public int e;
    public long f;
    public long g;

    public int getCount() {
        return this.e;
    }

    public String getDescription() {
        return this.c;
    }

    public String getFilter() {
        return this.d;
    }

    public long getLastUpdateTime() {
        return this.f;
    }

    public long getLastViewTime() {
        return this.g;
    }

    public long getSubscriptionId() {
        return this.a;
    }

    public String getTitle() {
        return this.b;
    }

    public void setCount(int i) {
        this.e = i;
    }

    public void setDescription(String str) {
        this.c = str;
    }

    public void setFilter(String str) {
        this.d = str;
    }

    public void setLastUpdateTime(long j) {
        this.f = j;
    }

    public void setLastViewTime(long j) {
        this.g = j;
    }

    public void setSubscriptionId(long j) {
        this.a = j;
    }

    public void setTitle(String str) {
        this.b = str;
    }
}
