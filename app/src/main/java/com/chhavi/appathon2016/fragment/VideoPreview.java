package com.chhavi.appathon2016.fragment;

import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.chhavi.appathon2016.Extras.Appointment;
import com.chhavi.appathon2016.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chhavi on 28/2/16.
 */
public class VideoPreview extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean pausing = false;;

    String stringPath = "/sdcard/samplevideo.3gp";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public VideoPreview() {
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
        View view =  inflater.inflate(R.layout.video_preview_volunteer, container, false);
        String SrcPath = "/sdcard/user_video.mp4";

        VideoView myVideoView = (VideoView)view.findViewById(R.id.myvideoview);
        myVideoView.setVideoPath(SrcPath);
        myVideoView.setMediaController(new MediaController(getActivity()));
        myVideoView.requestFocus();
        myVideoView.start();

        return view;
    }
}
