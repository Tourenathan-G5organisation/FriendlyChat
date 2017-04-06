package com.google.firebase.udacity.friendlychat;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Toure Nathan on 4/6/2017.
 */
public class ListAdpater extends FirebaseListAdapter<FriendlyMessage> {

    public ListAdpater(Activity activity, Class modelClass, int modelLayout, DatabaseReference ref) {
        super(activity, modelClass, modelLayout, ref);
    }


    @Override
    protected void populateView(View view, FriendlyMessage message, int position) {

        ImageView photoImageView = (ImageView) view.findViewById(R.id.photoImageView);
        TextView messageTextView = (TextView) view.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) view.findViewById(R.id.nameTextView);


        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            messageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);
        } else {
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());

    }
}
