package com.example.onumis.olympics2016.athletes;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onumis.olympics2016.R;

/**
 * A fragment representing a single Athlete detail screen.
 * This fragment is either contained in a {@link AthleteListActivity}
 * in two-pane mode (on tablets) or a {@link AthleteDetailActivity}
 * on handsets.
 */
public class AthleteDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The Atheletes content this fragment is presenting.
     */
    private AthletesContent.Athlete mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AthleteDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the Atheletes content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = AthletesContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.athlete_detail, container, false);

        // Show the Atheletes content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.athlete_bio)).setText(mItem.bio);
            ((TextView) rootView.findViewById(R.id.athlete_age)).setText(mItem.age.toString());
            ((TextView) rootView.findViewById(R.id.athlete_modality)).setText(mItem.modality_id);
        }

        return rootView;
    }
}
