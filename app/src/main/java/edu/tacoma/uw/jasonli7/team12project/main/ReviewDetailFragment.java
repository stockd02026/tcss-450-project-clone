package edu.tacoma.uw.jasonli7.team12project.main;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.tacoma.uw.jasonli7.team12project.R;
import edu.tacoma.uw.jasonli7.team12project.model.Device;
import edu.tacoma.uw.jasonli7.team12project.model.DeviceContent;
import edu.tacoma.uw.jasonli7.team12project.model.InfoHolder;
import edu.tacoma.uw.jasonli7.team12project.model.Review;

/**
 * A fragment representing a single Review detail screen.
 * This fragment is either contained in a {@link ReviewListActivity}
 * in two-pane mode (on tablets) or a {@link ReviewDetailActivity}
 * on handsets.
 */
public class ReviewDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Review mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ReviewDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = InfoHolder.InfoPass.getmReview();

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getmUserName());
           // }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.review_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.review_detail)).setText(mItem.getmReview());
        }

        return rootView;
    }
}