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

public class batubara_fasilitaslab extends AppCompatActivity {
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("batubara_fasilitas_lab");
    private TextView textView1, textView2, textView3, textView4;
    private ImageView iv_jasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batubara_fasilitaslab);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        iv_jasa = (ImageView)findViewById(R.id.iv_jasa);
    }

    @Override
    protected void onStart(){
        super.onStart();

        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String pelayanan = (String)dataSnapshot.child("distribusi_ukuran").getValue();
                String pelayanan1 = (String)dataSnapshot.child("fourier_transform").getValue();
                String pelayanan2 = (String)dataSnapshot.child("termal_simultan").getValue();

                textView1.setText(pelayanan);
                textView2.setText(pelayanan1);
                textView3.setText(pelayanan2);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        try{
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("batubara").child("batubara_lab1.PNG");
            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(batubara_fasilitaslab.this)
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
