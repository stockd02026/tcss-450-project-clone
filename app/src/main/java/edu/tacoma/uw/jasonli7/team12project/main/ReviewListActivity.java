package edu.tacoma.uw.jasonli7.team12project.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.tacoma.uw.jasonli7.team12project.R;

import edu.tacoma.uw.jasonli7.team12project.model.InfoHolder;
import edu.tacoma.uw.jasonli7.team12project.model.Review;

import java.util.List;

/**
 * An activity representing a list of Reviews. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ReviewDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ReviewListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchReviewAddFragment();
            }
        });

        if (findViewById(R.id.review_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.review_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void launchReviewAddFragment() {

            Intent intent = new Intent(this, AddReviewActivity.class);
            startActivity(intent);
/*        AddDeviceFragment addReviewFragment = new AddDeviceFragment();
        if (mTwoPane) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.review_detail_container, addReviewFragment).commit();

        } else {
            Intent intent = new Intent(this, ReviewDetailActivity.class);
            intent.putExtra(ReviewDetailActivity.ADD_Review, true);
            startActivity(intent);
        }*/

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, InfoHolder.InfoPass.getReviewList(), mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ReviewListActivity mParentActivity;
        private final List<Review> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Review item = (Review) view.getTag();
                InfoHolder.InfoPass.setmReview(item);
                if (mTwoPane) {
                    Bundle arguments = new Bundle();

                    arguments.putString(ReviewDetailFragment.ARG_ITEM_ID, item.getmUserName());
                    ReviewDetailFragment fragment = new ReviewDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.review_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ReviewDetailActivity.class);
                    intent.putExtra(ReviewDetailFragment.ARG_ITEM_ID, item.getmUserName());

                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(ReviewListActivity parent,
                                      List<Review> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.review_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getmUserName());
            holder.mContentView.setText(String.valueOf(mValues.get(position).getRate()).substring(0,3) + "/5");

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}