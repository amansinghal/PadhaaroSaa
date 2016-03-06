package com.padhaarosaa.ui.fragment;

import android.content.Intent;
import android.support.design.widget.Snackbar;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.padhaarosaa.R;
import com.padhaarosaa.core.fragment.BaseFragment;
import com.padhaarosaa.core.preference.Prefrences;
import com.padhaarosaa.core.rest.FirebaseConstants;

import butterknife.Bind;

/**
 * A placeholder fragment containing a simple view.
 */

public class MainActivityFragment extends BaseFragment
{
    @Bind(R.id.login_button)
    LoginButton loginButton;
    private CallbackManager callbackManager;

    public MainActivityFragment()
    {

    }

    @Override
    public void onFragmentReady()
    {
        fbLogin();
    }

    private void fbLogin()
    {
        loginButton.setReadPermissions("user_friends");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                // App code
                System.out.println(loginResult);
                FirebaseConstants.onFacebookAccessTokenChange(loginResult.getAccessToken(), new Firebase.AuthResultHandler()
                {
                    @Override
                    public void onAuthenticated(AuthData authData)
                    {
                        Prefrences.getWriteInstance(getActivity())
                                .putBoolean(Prefrences.PREF_IS_LOGGED_IN, true)
                                .putString(Prefrences.PREF_UID, authData.getToken())
                                .commit();
                        Snackbar.make(loginButton, "Login succeed", Snackbar.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError)
                    {

                    }
                });
            }

            @Override
            public void onCancel()
            {
                // App code
                System.out.println("cancel");
            }

            @Override
            public void onError(FacebookException exception)
            {
                // App code
                exception.printStackTrace();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public int getFragmentLayout()
    {
        return R.layout.fragment_main;
    }
}
