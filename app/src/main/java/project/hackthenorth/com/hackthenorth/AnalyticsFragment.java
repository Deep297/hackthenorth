package project.hackthenorth.com.hackthenorth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnalyticsFragment extends Fragment {

    public static AnalyticsFragment newInstance() {
        AnalyticsFragment fragment = new AnalyticsFragment();
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_analytics, container, false);
        Log.v("view", "view");

//        GraphView graph = (GraphView) view.findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
//                //String currentDateString = DateFormat.getDateTimeInstance().format(new Date());
//                new DataPoint(1, 20),
//                new DataPoint(1, 30),
//                new DataPoint(2, 50),
//                new DataPoint(3, 60),
//                new DataPoint(4, 40)
//        });
//        graph.addSeries(series);
        return view;
    }

}
