package com.chhavi.appathon2016.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.chhavi.appathon2016.Extras.Appointment;
import com.chhavi.appathon2016.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Future#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Future extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Future() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Future.
     */
    // TODO: Rename and change types and number of parameters
    public static Future newInstance(String param1, String param2) {
        Future fragment = new Future();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_future, container, false);

        ListView appointmentList = (ListView)view.findViewById(R.id.appointment_listview);

        List<Appointment> appointments = new ArrayList<Appointment>();


            appointments.add(new Appointment("Wednesday, 2nd March", "10 am", "12 pm", "Ronald"));
            appointments.add(new Appointment("Wednesday, 2nd March", "1 pm", "2 pm", "Smith"));
            appointments.add(new Appointment("Thursday, 3rd March", "11 am", "11 30 am", "Rebecca"));
            appointments.add(new Appointment("Friday, 4th March", "5 pm", "6 pm", "Michael"));
            appointments.add(new Appointment("Sunday, 6th March", "7 pm", "9 pm", "Philip"));


        FutureListAdapter adapter = new FutureListAdapter(getActivity(), appointments);
        appointmentList.setAdapter(adapter);

        return view;
    }


    public class FutureListAdapter extends ArrayAdapter<Appointment>{

        Context context;
        List<Appointment> appointments;
        public FutureListAdapter(Context context, List<Appointment> objects) {
            super(context, 0, objects);
            this.context = context;
            this.appointments = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           View view = LayoutInflater.from(context).inflate(R.layout.appointment_list_item, parent, false);

            Appointment appointment = appointments.get(position);
            TextView date = (TextView)view.findViewById(R.id.date_text);
            TextView start_time = (TextView)view.findViewById(R.id.start_text);
            TextView end_time = (TextView)view.findViewById(R.id.end_text);
            TextView client_name = (TextView)view.findViewById(R.id.client_text);

            date.setText(appointment.getDate());
            start_time.setText(appointment.getStart_time());
            end_time.setText(appointment.getEnd_time());
            client_name.setText(appointment.getClient_name());
            return view;
        }

        @Override
        public int getCount() {
            return appointments.size();
        }
    }

}
