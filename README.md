# SimpleDialog

⚡️A Simple,fast,Reliable library used for prompting alert dialog. ⚡️

⚡️A Single line of code can add a beautiful alert dialog in your app. ⚡️

<img src="https://github.com/a7mdragab/SimpleDialog/blob/master/simpledialog/src/main/res/drawable/dialog.png"
     alt=""
     width="400" height="650"
     style="float: left; margin-right: 10px;" />

+ ## Setup
Gradle dependency (recommended)

Add the following to your project level build.gradle:
``` 
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
``` 


Add this to your app build.gradle:
``` 
dependencies {
	implementation 'com.github.a7mdragab:SimpleDialog:1.0'
}
```

+ ## Documentation

To create custom dialog with minimum required properties
```
//Just mention the property you want to change only not all
SimpleDialog.Initialize(this,"This is Alert Dialog")
                .setAlertCallback(new SimpleDialog.AlertDialogCallback() {
                    @Override
                    public void onYesClicked() {
                        
                    }

                    @Override
                    public void onNoClicked() {

                    }

                    @Override
                    public void onCancelClicked() {

                    }
                }).Show();
```

To create custom dialog with full properties
```
//Just mention the property you want to change only not all
SimpleDialog.Initialize(this,"This is Alert Dialog")
                .setTitle("AlertDialog")
                .setCancelable(false)
                .setIcon(R.drawable.ic_menu_slideshow)
                .setNegativeButton("Noooooooooo")
                .setPositiveButton("Yeeeeeeeees")
                .setCancelButton("Cencel")
                .setAlertCallback(new SimpleDialog.AlertDialogCallback() {
                    @Override
                    public void onYesClicked() {
                        Toast.makeText(MainActivity.this, "Yes Clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNoClicked() {
                        Toast.makeText(MainActivity.this, "No Clicked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelClicked() {
                        Toast.makeText(MainActivity.this, "Cancel Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .Show();
```
