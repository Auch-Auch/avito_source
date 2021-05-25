package ru.terrakok.cicerone.android.support;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.LinkedList;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.BackTo;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;
public class SupportAppNavigator implements Navigator {
    public final Activity a;
    public final FragmentManager b;
    public final int c;
    public LinkedList<String> d;

    public SupportAppNavigator(FragmentActivity fragmentActivity, int i) {
        this(fragmentActivity, fragmentActivity.getSupportFragmentManager(), i);
    }

    public final void a(SupportAppScreen supportAppScreen, Intent intent, Bundle bundle) {
        if (intent.resolveActivity(this.a.getPackageManager()) != null) {
            this.a.startActivity(intent, bundle);
        } else {
            unexistingActivity(supportAppScreen, intent);
        }
    }

    public void activityBack() {
        this.a.finish();
    }

    public void activityForward(Forward forward) {
        SupportAppScreen supportAppScreen = (SupportAppScreen) forward.getScreen();
        Intent activityIntent = supportAppScreen.getActivityIntent(this.a);
        if (activityIntent != null) {
            a(supportAppScreen, activityIntent, createStartActivityOptions(forward, activityIntent));
        } else {
            fragmentForward(forward);
        }
    }

    public void activityReplace(Replace replace) {
        SupportAppScreen supportAppScreen = (SupportAppScreen) replace.getScreen();
        Intent activityIntent = supportAppScreen.getActivityIntent(this.a);
        if (activityIntent != null) {
            a(supportAppScreen, activityIntent, createStartActivityOptions(replace, activityIntent));
            this.a.finish();
            return;
        }
        fragmentReplace(replace);
    }

    public void applyCommand(Command command) {
        if (command instanceof Forward) {
            activityForward((Forward) command);
        } else if (command instanceof Replace) {
            activityReplace((Replace) command);
        } else if (command instanceof BackTo) {
            backTo((BackTo) command);
        } else if (command instanceof Back) {
            fragmentBack();
        }
    }

    @Override // ru.terrakok.cicerone.Navigator
    public void applyCommands(Command[] commandArr) {
        this.b.executePendingTransactions();
        this.d = new LinkedList<>();
        int backStackEntryCount = this.b.getBackStackEntryCount();
        for (int i = 0; i < backStackEntryCount; i++) {
            this.d.add(this.b.getBackStackEntryAt(i).getName());
        }
        for (Command command : commandArr) {
            applyCommand(command);
        }
    }

    public void backTo(BackTo backTo) {
        if (backTo.getScreen() == null) {
            this.b.popBackStack((String) null, 1);
            this.d.clear();
            return;
        }
        String screenKey = backTo.getScreen().getScreenKey();
        int indexOf = this.d.indexOf(screenKey);
        int size = this.d.size();
        if (indexOf != -1) {
            for (int i = 1; i < size - indexOf; i++) {
                this.d.removeLast();
            }
            this.b.popBackStack(screenKey, 0);
            return;
        }
        backToUnexisting((SupportAppScreen) backTo.getScreen());
    }

    public void backToUnexisting(SupportAppScreen supportAppScreen) {
        this.b.popBackStack((String) null, 1);
        this.d.clear();
    }

    public Fragment createFragment(SupportAppScreen supportAppScreen) {
        Fragment fragment = supportAppScreen.getFragment();
        if (fragment == null) {
            errorWhileCreatingScreen(supportAppScreen);
        }
        return fragment;
    }

    public Bundle createStartActivityOptions(Command command, Intent intent) {
        return null;
    }

    public void errorWhileCreatingScreen(SupportAppScreen supportAppScreen) {
        StringBuilder L = a.L("Can't create a screen: ");
        L.append(supportAppScreen.getScreenKey());
        throw new RuntimeException(L.toString());
    }

    public void fragmentBack() {
        if (this.d.size() > 0) {
            this.b.popBackStack();
            this.d.removeLast();
            return;
        }
        activityBack();
    }

    public void fragmentForward(Forward forward) {
        SupportAppScreen supportAppScreen = (SupportAppScreen) forward.getScreen();
        Fragment createFragment = createFragment(supportAppScreen);
        FragmentTransaction beginTransaction = this.b.beginTransaction();
        setupFragmentTransaction(forward, this.b.findFragmentById(this.c), createFragment, beginTransaction);
        beginTransaction.replace(this.c, createFragment).addToBackStack(supportAppScreen.getScreenKey()).commit();
        this.d.add(supportAppScreen.getScreenKey());
    }

    public void fragmentReplace(Replace replace) {
        SupportAppScreen supportAppScreen = (SupportAppScreen) replace.getScreen();
        Fragment createFragment = createFragment(supportAppScreen);
        if (this.d.size() > 0) {
            this.b.popBackStack();
            this.d.removeLast();
            FragmentTransaction beginTransaction = this.b.beginTransaction();
            setupFragmentTransaction(replace, this.b.findFragmentById(this.c), createFragment, beginTransaction);
            beginTransaction.replace(this.c, createFragment).addToBackStack(supportAppScreen.getScreenKey()).commit();
            this.d.add(supportAppScreen.getScreenKey());
            return;
        }
        FragmentTransaction beginTransaction2 = this.b.beginTransaction();
        setupFragmentTransaction(replace, this.b.findFragmentById(this.c), createFragment, beginTransaction2);
        beginTransaction2.replace(this.c, createFragment).commit();
    }

    public void setupFragmentTransaction(Command command, Fragment fragment, Fragment fragment2, FragmentTransaction fragmentTransaction) {
    }

    public void unexistingActivity(SupportAppScreen supportAppScreen, Intent intent) {
    }

    public SupportAppNavigator(FragmentActivity fragmentActivity, FragmentManager fragmentManager, int i) {
        this.a = fragmentActivity;
        this.b = fragmentManager;
        this.c = i;
    }
}
