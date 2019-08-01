package com.pkltekmiragmail.blutekmira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class tambang extends YouTubeBaseActivity implements  YouTubePlayer.OnInitializedListener {
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("batubara_pelayanan");
    private TextView textView1, textView2, textView3, textView4;
    private ImageView iv_jasa;

    public static final String API_KEY = "AIzaSyAsq7vzUjUS4cwVWv2EICnLsr3GfVotaMo";
    public static final String VIDEO_ID = "tD0WnIriWWM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambang);

        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);

        Button btn1 = (Button)findViewById(R.id.tambang_jasa);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_jasa.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.tambang_desain);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_desain.class));
            }
        });

        Button btn3 = (Button)findViewById(R.id.tambang_pengeboran);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_pengeboran.class));
            }
        });

        Button btn4 = (Button)findViewById(R.id.tambang_kajian_geoteknik);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambanng_kajian_geoteknik.class));
            }
        });

        Button btn5 = (Button)findViewById(R.id.tambang_studi_hidrologi);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_studi_hidrologi.class));
            }
        });

        Button btn6 = (Button)findViewById(R.id.tambang_manajemen_lingkungan);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_manajemen.class));
            }
        });

        Button btn7 = (Button)findViewById(R.id.tambang_studi_rencana_reklamasi);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_studi_rencana_reklamasi.class));
            }
        });

        Button btn8 = (Button)findViewById(R.id.tambang_studi_kelayakan_tambang);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_studi_kelayakan.class));
            }
        });

        Button btn9 = (Button)findViewById(R.id.tambang_kajian_pertambangan_lainnya);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_kajian_pertambangan_lainnya.class));
            }
        });

        Button btn10 = (Button)findViewById(R.id.tambang_kerjasama_pengembangan);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_kerjasama_pengembang.class));
            }
        });

        Button btn11 = (Button)findViewById(R.id.tambang_peralatan_pendukung);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_peralatan_pendukung_lab.class));
            }
        });

        Button btn12 = (Button)findViewById(R.id.tambang_peralatan_pendukung_kegiatan_pertambangan);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_peralatan_pendukung.class));
            }
        });

        Button btn13 = (Button)findViewById(R.id.tambang_software);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_software_pendukung.class));
            }
        });

        Button btn14 = (Button)findViewById(R.id.tambang_mitra);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambang.this, tambang_mitra.class));
            }
        });
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        /** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
        }

        @Override
        public void onPlaying() {
        }

        @Override
        public void onSeekTo(int arg0) {
        }

        @Override
        public void onStopped() {
        }
    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
        }

        @Override
        public void onVideoStarted() {
        }
    };
}