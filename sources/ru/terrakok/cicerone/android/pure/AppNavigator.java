package ru.terrakok.cicerone.android.pure;

import a2.b.a.a.a;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import java.util.LinkedList;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.BackTo;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;
public class AppNavigator implements Navigator {
    public final Activity a;
    public final FragmentManager b;
    public final int c;
    public LinkedList<String> d;

    public AppNavigator(Activity activity, int i) {
        this(activity, activity.getFragmentManager(), i);
    }

    public final void a(AppScreen appScreen, Intent intent, Bundle bundle) {
        if (intent.resolveActivity(this.a.getPackageManager()) != null) {
            this.a.startActivity(intent, bundle);
        } else {
            unexistingActivity(appScreen, intent);
        }
    }

    public void activityBack() {
        this.a.finish();
    }

    public void activityForward(Forward forward) {
        AppScreen appScreen = (AppScreen) forward.getScreen();
        Intent activityIntent = appScreen.getActivityIntent(this.a);
        if (activityIntent != null) {
            a(appScreen, activityIntent, createStartActivityOptions(forward, activityIntent));
        } else {
            fragmentForward(forward);
        }
    }

    public void activityReplace(Replace replace) {
        AppScreen appScreen = (AppScreen) replace.getScreen();
        Intent activityIntent = appScreen.getActivityIntent(this.a);
        if (activityIntent != null) {
            a(appScreen, activityIntent, createStartActivityOptions(replace, activityIntent));
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
        backToUnexisting((AppScreen) backTo.getScreen());
    }

    public void backToUnexisting(AppScreen appScreen) {
        this.b.popBackStack((String) null, 1);
        this.d.clear();
    }

    public Fragment createFragment(AppScreen appScreen) {
        Fragment fragment = appScreen.getFragment();
        if (fragment == null) {
            errorWhileCreatingScreen(appScreen);
        }
        return fragment;
    }

    public Bundle createStartActivityOptions(Command command, Intent intent) {
        return null;
    }

    public void errorWhileCreatingScreen(AppScreen appScreen) {
        StringBuilder L = a.L("Can't create a screen: ");
        L.append(appScreen.getScreenKey());
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
        AppScreen appScreen = (AppScreen) forward.getScreen();
        Fragment createFragment = createFragment(appScreen);
        FragmentTransaction beginTransaction = this.b.beginTransaction();
        setupFragmentTransaction(forward, this.b.findFragmentById(this.c), createFragment, beginTransaction);
        beginTransaction.replace(this.c, createFragment).addToBackStack(appScreen.getScreenKey()).commit();
        this.d.add(appScreen.getScreenKey());
    }

    public void fragmentReplace(Replace replace) {
        AppScreen appScreen = (AppScreen) replace.getScreen();
        Fragment createFragment = createFragment(appScreen);
        if (this.d.size() > 0) {
            this.b.popBackStack();
            this.d.removeLast();
            FragmentTransaction beginTransaction = this.b.beginTransaction();
            setupFragmentTransaction(replace, this.b.findFragmentById(this.c), createFragment, beginTransaction);
            beginTransaction.replace(this.c, createFragment).addToBackStack(appScreen.getScreenKey()).commit();
            this.d.add(appScreen.getScreenKey());
            return;
        }
        FragmentTransaction beginTransaction2 = this.b.beginTransaction();
        setupFragmentTransaction(replace, this.b.findFragmentById(this.c), createFragment, beginTransaction2);
        beginTransaction2.replace(this.c, createFragment).commit();
    }

    public void setupFragmentTransaction(Command command, Fragment fragment, Fragment fragment2, FragmentTransaction fragmentTransaction) {
    }

    public void unexistingActivity(AppScreen appScreen, Intent intent) {
    }

    public AppNavigator(Activity activity, FragmentManager fragmentManager, int i) {
        this.a = activity;
        this.b = fragmentManager;
        this.c = i;
    }
}
