package com.pkltekmiragmail.blutekmira;

import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class mineral_pupuk_kiserit extends AppCompatActivity {
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("mineral_pupuk_kiserit");
    private TextView textView1, textView2, textView3, textView4;
    private ImageView iv_jasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mineral_pupuk_kiserit);

        textView1 = (TextView)findViewById(R.id.textView1);
        iv_jasa = (ImageView)findViewById(R.id.iv_jasa);
    }

    @Override
    protected void onStart(){
        super.onStart();

        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String pelayanan = (String)dataSnapshot.child("deskripsi").getValue();


                textView1.setText(pelayanan);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        try{
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("mineral").child("pupuk_kiserit.PNG");
            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(mineral_pupuk_kiserit.this)
                            .load(uri)
                            .into(iv_jasa);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }catch (Exception e){e.printStackTrace();}
    }
}
