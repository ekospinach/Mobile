package fingertech.mobileclientgky;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private LinearLayout myLinearLayout;
    private ImageView GambarIV;
    private TextView TitleEventTV;
    private TextView JudulEventTV;
    private TextView TitleTanggalTV;
    private TextView JudulTanggalTV;
    private TextView TitleWaktuTV;
    private TextView JudulWaktuTV;
    private TextView TitleKeteranganTV;
    private TextView IsiKeteranganTV;
    private Button SelengkapnyaBtn;
    private View rootView;

    // Controller cont = new Controller();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventFragment newInstance(String param1, String param2) {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        /*cont.viewEvent();
        Log.d("Events ", cont.getArrData().toString());*/
    }

//    @Override
//    public void onActivityCreated (Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        generateEventContent();
//    }

    public void generateEventContent() {
//        try{
//        Controller C = new Controller();
//        C.viewEvent();
//        JSONArray dataArr2 = C.Viewer.arr;
//        Controller.Viewer.execute(Controller.url);
//        JSONArray dataArr = Controller.Viewer.arr;
            String x = "{\"data\":[{\"judul\":\"event judul\",\"tanggal\":\"2015-05-05\",\"keterangan\":\"event keterangan\",\"gambarevent\":\"event.jpg\"},{\"judul\":\"event judul2\",\"tanggal\":\"2015-05-05\",\"keterangan\":\"event keterangan2\",\"gambarevent\":\"event2.jpg\"}]}";
//            JSONArray data = new JSONArray(x);
//            JSONArray data = result.getJSONArray("data");
//            int dataLength = data.length();
//            JSONObject temp = null;
            String judul, tanggal, keterangan, linkGambar;

            //add LInearLayout
            myLinearLayout=(LinearLayout)rootView.findViewById(R.id.container_event);
            //add LayoutParams
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            myLinearLayout.setOrientation(LinearLayout.VERTICAL);
            params.setMargins(0, 10, 20, 0);

            LinearLayout rowLayout = new LinearLayout(getActivity());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);

            //buat linear layout vertical utk menampung kata2
            LinearLayout colLayout = new LinearLayout(getActivity());
            colLayout.setOrientation(LinearLayout.VERTICAL);
            colLayout.setPadding(0,10,10,0);

            LinearLayout subRowLayout = new LinearLayout(getActivity());
            subRowLayout.setOrientation(LinearLayout.HORIZONTAL);

            int dataLength = 3;

            LinearLayout.LayoutParams parameter = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            Display display = getActivity().getWindowManager().getDefaultDisplay();
            int image_width = display.getWidth()/3;
            int image_height = (int) (display.getHeight()/4.3);

            int colorWhite = Color.WHITE;

            // Generate konten Event dalam loop for
            for (int i=0; i<dataLength; i++){
//                temp = data.getJSONObject(i);
//                judul = temp.getString("judul");
//                tanggal = temp.getString("tanggal");
//                keterangan = temp.getString("keterangan");
//                linkGambar = temp.getString("gambarevent");
                judul = "ini judul loh";
                tanggal = "25 Mei 2015";
                keterangan = "debugging aplikasi android";
                linkGambar = "www.com";

                //add image View
                GambarIV = new ImageView(getActivity());
                GambarIV.setBackgroundColor(923423432);
//                GambarIV.setPadding(0,10,10,0);
                GambarIV.setMinimumWidth(image_width);
                GambarIV.setMinimumHeight(image_height);
                GambarIV.setMaxHeight(image_height);
                GambarIV.setMaxWidth(image_width);
                GambarIV.setLayoutParams(params);
                rowLayout.addView(GambarIV);

                //add text View TitleEventTV
                TitleEventTV = new TextView(getActivity());
                TitleEventTV.setText("Event: ");
                TitleEventTV.setLayoutParams(params);
                TitleEventTV.setTextColor(colorWhite);
                subRowLayout.addView(TitleEventTV);
                //add text View JudulEventTV
                JudulEventTV = new TextView(getActivity());
                JudulEventTV.setText(judul);
                JudulEventTV.setLayoutParams(params);
                subRowLayout.addView(JudulEventTV);
                colLayout.addView(subRowLayout);
                subRowLayout = new LinearLayout(getActivity());

                //add text View TitleTanggalTV
                TitleTanggalTV = new TextView(getActivity());
                TitleTanggalTV.setText("Tanggal: ");
                TitleTanggalTV.setTextColor(colorWhite);
                TitleTanggalTV.setLayoutParams(params);
                subRowLayout.addView(TitleTanggalTV);
                //add text View JudulTanggalTV
                JudulTanggalTV= new TextView(getActivity());
                JudulTanggalTV.setText(tanggal);
                JudulTanggalTV.setLayoutParams(params);
                subRowLayout.addView(JudulTanggalTV);
                colLayout.addView(subRowLayout);
                subRowLayout = new LinearLayout(getActivity());

                //add text View TitleWaktuTV
                TitleWaktuTV = new TextView(getActivity());
                TitleWaktuTV.setText("Waktu: ");
                TitleWaktuTV.setTextColor(colorWhite);
                TitleWaktuTV.setLayoutParams(params);
                subRowLayout.addView(TitleWaktuTV);
                //add text View JudulWaktuTV
                JudulWaktuTV = new TextView(getActivity());
                JudulWaktuTV.setText(tanggal);
                JudulWaktuTV.setLayoutParams(params);
                subRowLayout.addView(JudulWaktuTV);
                colLayout.addView(subRowLayout);
                subRowLayout = new LinearLayout(getActivity());

                //add text View TitleKeteranganTV
                TitleKeteranganTV = new TextView(getActivity());
                TitleKeteranganTV.setText("Keterangan: ");
                TitleKeteranganTV.setTextColor(colorWhite);
                TitleKeteranganTV.setLayoutParams(params);
                subRowLayout.addView(TitleKeteranganTV);
                //add text View IsiKeteranganTV
                IsiKeteranganTV = new TextView(getActivity());
                if (keterangan.length()>80) {
                    keterangan = keterangan.substring(0, 80);
                    keterangan = keterangan + "...";
                }
                IsiKeteranganTV.setText(keterangan);
                IsiKeteranganTV.setLayoutParams(params);
                colLayout.addView(subRowLayout);
                subRowLayout = new LinearLayout(getActivity());

                //add selengkapnya button
                SelengkapnyaBtn = new Button(getActivity());
                SelengkapnyaBtn.setText("Selengkapnya");
                SelengkapnyaBtn.setLayoutParams(params);
                SelengkapnyaBtn.setBackgroundColor(0);
                subRowLayout.addView(SelengkapnyaBtn);
                colLayout.addView(subRowLayout);

                if (i!=dataLength) {
                    rowLayout.addView(colLayout);
                    myLinearLayout.addView(rowLayout);
                    rowLayout = new LinearLayout(getActivity());
                    colLayout = new LinearLayout(getActivity());
                    colLayout.setOrientation(LinearLayout.VERTICAL);
                    subRowLayout = new LinearLayout(getActivity());
                }
            }
//        } catch(JSONException e){e.printStackTrace();}
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_event, container, false);
        generateEventContent();
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_event, container, false);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
