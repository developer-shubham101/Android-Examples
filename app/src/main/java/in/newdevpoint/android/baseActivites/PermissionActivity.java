package in.newdevpoint.android.baseActivites;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public abstract class PermissionActivity extends AppCompatActivity {

    private final int REQUEST_PERMISSIONS = 4154;
    private String[] PERMISSIONS = listOfPermission();

    public void askPermission() {
        if (hasPermissions(PERMISSIONS)) {
            permissionGranted();
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_PERMISSIONS);

        }
    }

    protected abstract void permissionGranted();

    protected abstract String[] listOfPermission();

    public boolean hasPermissions(String... permissions) {
        if (permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS) {
            boolean allAllow = true;
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    allAllow = false;
                    break;
                }
            }
            if (allAllow) {
                permissionGranted();
            } else {
                permissionDeny();
            }
        }
    }

    protected abstract void permissionDeny();

}
