package me.pankajadhyapak.realmexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import me.pankajadhyapak.realmexample.Models.Task;

public class NewTask extends AppCompatActivity  implements View.OnClickListener{

    EditText what ;
    CheckBox complete;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();







    }

    private void initViews() {

        this.what = (EditText) findViewById(R.id.editText);
        this.complete = (CheckBox) findViewById(R.id.checkBox);
        this.saveBtn = (Button) findViewById(R.id.saveBtn);
        this.saveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String what = this.what.getText().toString();
        Boolean complete = this.complete.isChecked();

        Toast.makeText(NewTask.this, what+"  is " + complete, Toast.LENGTH_SHORT).show();

        Task task = new Task();
        task.setName(what);
        task.setCompleted(complete);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm realm = Realm.getInstance(realmConfig);

        realm.beginTransaction();
        realm.copyToRealm(task);
        realm.commitTransaction();

        finish();



    }
}
