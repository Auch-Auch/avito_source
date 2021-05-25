package com.avito.android.remote.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\tB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/IncomeResultV2;", "", "Lcom/avito/android/remote/model/IncomeResultV2$Income;", "income", "Lcom/avito/android/remote/model/IncomeResultV2$Income;", "getIncome", "()Lcom/avito/android/remote/model/IncomeResultV2$Income;", "<init>", "(Lcom/avito/android/remote/model/IncomeResultV2$Income;)V", "Income", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class IncomeResultV2 {
    @SerializedName("income")
    @Nullable
    private final Income income;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/IncomeResultV2$Income;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/IncomeResultV2$Income$Amount;", "amount", "Lcom/avito/android/remote/model/IncomeResultV2$Income$Amount;", "getAmount", "()Lcom/avito/android/remote/model/IncomeResultV2$Income$Amount;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/IncomeResultV2$Income$Amount;)V", "Amount", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Income {
        @SerializedName("amount")
        @NotNull
        private final Amount amount;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/IncomeResultV2$Income$Amount;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", FirebaseAnalytics.Param.CURRENCY, "getCurrency", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Amount {
            @SerializedName(FirebaseAnalytics.Param.CURRENCY)
            @NotNull
            private final String currency;
            @SerializedName("value")
            @NotNull
            private final String value;

            public Amount(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "value");
                Intrinsics.checkNotNullParameter(str2, FirebaseAnalytics.Param.CURRENCY);
                this.value = str;
                this.currency = str2;
            }

            @NotNull
            public final String getCurrency() {
                return this.currency;
            }

            @NotNull
            public final String getValue() {
                return this.value;
            }
        }

        public Income(@NotNull String str, @NotNull Amount amount2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(amount2, "amount");
            this.title = str;
            this.amount = amount2;
        }

        @NotNull
        public final Amount getAmount() {
            return this.amount;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    public IncomeResultV2(@Nullable Income income2) {
        this.income = income2;
    }

    @Nullable
    public final Income getIncome() {
        return this.income;
    }
}
