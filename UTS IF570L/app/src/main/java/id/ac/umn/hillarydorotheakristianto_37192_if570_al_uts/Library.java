package id.ac.umn.hillarydorotheakristianto_37192_if570_al_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Objects;

public class Library extends AppCompatActivity {

    RecyclerView rvDaftarSound;
    LibraryAdapter mAdapter;
    LinkedList<SumberSound> daftarSound = new LinkedList<>();
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent mainIntent = getIntent();
        String login = mainIntent.getStringExtra("Nama");

        getSupportActionBar(). setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(login);

        Toast.makeText(Library.this,"Selamat Datang, " + login, Toast.LENGTH_LONG).show();

        isiDaftarSound();
        rvDaftarSound = (RecyclerView) findViewById(R.id.RV);
        mAdapter = new LibraryAdapter(this, daftarSound);
        rvDaftarSound.setAdapter(mAdapter);
        rvDaftarSound.setLayoutManager(new LinearLayoutManager(this));

        btnDelete = (Button) findViewById(R.id.btnDelete);
    }

    public void isiDaftarSound(){
        daftarSound.add(new SumberSound("Bubble & Foaming", "Bubbles and Foaming from Pouring Liquid", "android.resource://" + getPackageName() + "/" + R.raw.bubble));
        daftarSound.add(new SumberSound("Bells & Strings", "Ascending Bells & Strings", "android.resource://" + getPackageName() + "/" + R.raw.bell));
        daftarSound.add(new SumberSound("Dynamite Explosion", "Light Fuse with Dynamite and Explosion", "android.resource://" + getPackageName() + "/" + R.raw.dynamite));
        daftarSound.add(new SumberSound("Minion 1", "Minion Fire Alarm", "android.resource://" + getPackageName() + "/" + R.raw.minion_fire_alarm));
        daftarSound.add(new SumberSound("Minion 2", "Minion Laugh", "android.resource://" + getPackageName() + "/" + R.raw.minions_laugh));
        daftarSound.add(new SumberSound("Minion 3", "Minion Papoy", "android.resource://" + getPackageName() + "/" + R.raw.minions_papoy));
        daftarSound.add(new SumberSound("Voldemort", "Voldemort Laughing", "android.resource://" + getPackageName() + "/" + R.raw.voldemort_laughing));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent profileIntent = new Intent(Library.this, Profile.class);
            startActivity(profileIntent);
        } else{
            Intent homeIntent = new Intent(Library.this, MainActivity.class);
            startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}