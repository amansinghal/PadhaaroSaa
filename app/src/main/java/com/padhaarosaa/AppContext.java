package com.padhaarosaa;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.multidex.MultiDexApplication;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.firebase.client.Firebase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Created by gspl on 12/9/2015.
 */
public class AppContext extends MultiDexApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        Firebase.setAndroidContext(this);
        facebookHashKey();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }

    private void facebookHashKey() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.padhaarosaa", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashCode  = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                System.out.println("Print the hashKey for Facebook :"+hashCode);
                Log.e("KeyHash:", hashCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
