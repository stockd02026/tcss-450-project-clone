package edu.tacoma.uw.jasonli7.team12project.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import edu.tacoma.uw.jasonli7.team12project.R;
import edu.tacoma.uw.jasonli7.team12project.model.Device;
import edu.tacoma.uw.jasonli7.team12project.model.InfoHolder;
import edu.tacoma.uw.jasonli7.team12project.model.Review;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddReviewFragment extends Fragment {
    private AddReviewFragment.AddReviewListener mAddReviewListener;
    public interface AddReviewListener {
        public  void  addReview(Review review);
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddReviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseAddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddReviewFragment newInstance(String param1, String param2) {
        AddReviewFragment fragment = new AddReviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mAddReviewListener = (AddReviewListener) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_review, container
                , false);
        getActivity().setTitle("Signed in as: " +InfoHolder.InfoPass.getmEmail());



   /*     final EditText reviewIdEditText = v.findViewById(R.id.add_review);
          final EditText rateDevice = v.findViewById(R.id.editTextNumber);
        Button addButton = v.findViewById(R.id.btn_add_review);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String revEdit = reviewIdEditText.getText().toString();

                Device device = new Device(courseId, new ArrayList<Review>());
                if (mAddDeviceListener != null) {
                    mAddDeviceListener.addDevice(device);
                }
            }
        });*/
        return v;
    }
}