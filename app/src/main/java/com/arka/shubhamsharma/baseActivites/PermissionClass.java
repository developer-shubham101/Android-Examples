package com.arka.shubhamsharma.baseActivites;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class PermissionClass {

    private final int REQUEST_PERMISSIONS = 4154;
    private PermissionRequire permissionRequire;
    private Activity activity;

    public PermissionClass(PermissionRequire permissionRequire, Activity activity) {
        this.permissionRequire = permissionRequire;
        this.activity = activity;
    }

    public void askPermission() {
        if (hasPermissions(this.permissionRequire.listOfPermission())) {
            this.permissionRequire.permissionGranted();
        } else {
            ActivityCompat.requestPermissions(activity, this.permissionRequire.listOfPermission(), REQUEST_PERMISSIONS);

        }
    }

    private boolean hasPermissions(String... permissions) {
        if (permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == REQUEST_PERMISSIONS) {
            boolean allAllow = true;
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    allAllow = false;
                    break;
                }
            }
            if (allAllow) {
                this.permissionRequire.permissionGranted();
            } else {
                this.permissionRequire.permissionDeny();
            }
        }
    }


    public interface PermissionRequire {
        void permissionDeny();

        void permissionGranted();

        String[] listOfPermission();
    }

}
