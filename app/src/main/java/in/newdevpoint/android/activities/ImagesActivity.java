package in.newdevpoint.android.activities;

import android.Manifest;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;


import in.newdevpoint.android.R;
import in.newdevpoint.android.baseActivites.ImagePickerActivity;
import in.newdevpoint.android.baseActivites.ImagePickerClass;
import in.newdevpoint.android.baseActivites.PermissionClass;

public class ImagesActivity extends ImagePickerActivity implements PermissionClass.PermissionRequire, ImagePickerClass.ImagePickerMethod {

    private ImageView[] imageViewList = new ImageView[10];
    private int itemClicked = 0;
    private PermissionClass permissionClass;
    private ImagePickerClass imagePickerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);


        permissionClass = new PermissionClass(this, this);
        imagePickerClass= new ImagePickerClass(this,this);
        imageViewList[0] = findViewById(R.id.upload_image);
        imageViewList[1] = findViewById(R.id.upload_image1);
        imageViewList[2] = findViewById(R.id.upload_image2);
        imageViewList[3] = findViewById(R.id.upload_image3);
        imageViewList[4] = findViewById(R.id.upload_image4);
        imageViewList[5] = findViewById(R.id.upload_image5);
        imageViewList[6] = findViewById(R.id.upload_image6);
        imageViewList[7] = findViewById(R.id.upload_image7);
        imageViewList[8] = findViewById(R.id.upload_image8);
        imageViewList[9] = findViewById(R.id.upload_image9);


        View.OnClickListener onClickListener = v -> {
            switch (v.getId()) {
                case R.id.upload_image:
                    itemClicked = 1;
                    break;
                case R.id.upload_image2:
                    itemClicked = 2;
                    break;
                case R.id.upload_image3:
                    itemClicked = 3;
                    break;
                case R.id.upload_image4:
                    itemClicked = 4;
                    break;
                case R.id.upload_image5:
                    itemClicked = 5;
                    break;
                case R.id.upload_image6:
                    itemClicked = 6;
                    break;
                case R.id.upload_image7:
                    itemClicked = 7;
                    break;
                case R.id.upload_image8:
                    itemClicked = 8;
                    break;
                case R.id.upload_image9:
                    itemClicked = 9;
                    break;
            }

            permissionClass.askPermission();

        };

        for (ImageView anImageViewList : imageViewList) {
            anImageViewList.setOnClickListener(onClickListener);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imagePickerClass.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionClass.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void fileUrl(String url) {
        imageViewList[itemClicked].setImageBitmap(BitmapFactory.decodeFile(url));
    }

    @Override
    public void permissionGranted() {
        openPicker();
    }

    @Override
    public String[] listOfPermission() {

        return new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};

    }

    @Override
    public void permissionDeny() {

    }
}

