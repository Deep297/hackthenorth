package project.hackthenorth.com.hackthenorth;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Joyli on 2017-09-17.
 */

public class FragmentTransitionAnalysis extends FragmentActivity{
    public class blueScreen extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (savedInstanceState == null){
                getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, new AnalyticsFragment()).commit();}
        }
    }

}
