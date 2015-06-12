package com.kinwae.myappportfolio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void appLunchButtonClicked(View view) {
        // found details on how to programmatically get android resources from
        // http://stackoverflow.com/questions/7493287/android-how-do-i-get-string-from-resources-using-its-name
        Button button = (Button)view;
        String buttonName = getResources().getResourceName(button.getId());
        // resource name will come in the format <package-name>:id/<name>
        // we need to get out the beginning of the string down to :id/
        int subStrStart = buttonName.indexOf(":") + ("id/".length() + 1);
        // each app button luncher ends with the _btn string
        int stopIndex = buttonName.lastIndexOf("_btn");

        String app = buttonName.substring(subStrStart, stopIndex);
        // apps defined in strings.xml have the suffix _app_name appended to their resource string name
        String appResourceName = app+"_app_name";

        int appname_id = getResources().getIdentifier(appResourceName, "string", getPackageName());

        String toastMessage;

        if (appname_id == 0){
            toastMessage = "Sorry could not find app to lunch";
        }
        else{
            toastMessage = "This button will launch my "+getResources().getString(appname_id).toUpperCase()+"!";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.show();
    }
}
