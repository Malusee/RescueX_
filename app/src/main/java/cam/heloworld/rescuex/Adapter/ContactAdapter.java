package cam.heloworld.rescuex.Adapter;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cam.heloworld.rescuex.Add_Friend;
import cam.heloworld.rescuex.R;


import static cam.heloworld.rescuex.R.id.contact_display_name;
import static cam.heloworld.rescuex.R.id.contact_display_number;
import static cam.heloworld.rescuex.R.id.number;


public class ContactAdapter extends CursorRecyclerViewAdapter<ContactAdapter.ContactViewHolder> {
    public ContactAdapter(Context context, Cursor cursor, String id){
        super(context, cursor, id);
    }

    TextView contact_name;
    TextView contactDisplayNumber;
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact,
                parent, false);
       final TextView contact_number=(TextView)view.findViewById(contact_display_number);
       final TextView contact_name=(TextView)view.findViewById(contact_display_name);
        contact_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=contact_number.getText().toString();
                String name=contact_name.getText().toString();
                Intent contIntent= new Intent(mContext.getApplicationContext(), Add_Friend.class );
                contIntent.putExtra("contacts_username",name);
                contIntent.putExtra("contact_number",number);
                contIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                mContext.getApplicationContext().startActivity(contIntent);
            }

        });
        return new ContactViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ContactViewHolder viewHolder, Cursor cursor) {
        //Now we can handle onBindViewHolder

        long contactId = getItemId(cursor.getPosition());
        //Setting the username
        String username = cursor.getString(cursor.getColumnIndex(
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                        ContactsContract.Contacts.DISPLAY_NAME_PRIMARY :
                        ContactsContract.Contacts.DISPLAY_NAME

        ));

        viewHolder.contactDisplayNameTextView.setText(username);

        // setting up the phone number
        @SuppressWarnings("unused")
         long contactNumber = getItemId(cursor.getPosition());
        String contact_no=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
       viewHolder.contactDisplayNumber.setText(contact_no);
        //Setting the photo

        long photoId = cursor.getLong(cursor.getColumnIndex(
                ContactsContract.Data.PHOTO_ID
        ));

        if (photoId != 0) {
            Uri contactUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,
                    contactId);
            Uri photoUri = Uri.withAppendedPath(contactUri, ContactsContract.Contacts.Photo
                    .CONTENT_DIRECTORY);

            viewHolder.contactDisplayImageView.setImageURI(photoUri);
        } else {
            viewHolder.contactDisplayImageView.setImageResource(R.drawable.prof_icon);
        }
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        ImageView contactDisplayImageView;
        TextView contactDisplayNameTextView;
        TextView contactDisplayNumber;

        public ContactViewHolder(View itemView) {
            super(itemView);
            contactDisplayImageView = (ImageView) itemView.findViewById(R.id.contact_display);
            contactDisplayNameTextView = (TextView) itemView.findViewById(contact_display_name);
            contactDisplayNumber=(TextView)itemView.findViewById(contact_display_number);

        }
    }
}
