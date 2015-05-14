package application.floc.event.eventfloc.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import application.floc.event.eventfloc.Adapters.eventItemAdapter;
import application.floc.event.eventfloc.DatabaseQueries;
import application.floc.event.eventfloc.EventsClasses.Event;
import application.floc.event.eventfloc.R;

/**
 * Created by Vanessa on 11/05/2015.
 */
public class CategoryActivity extends ActionBarActivity {
    DatabaseQueries dq = new DatabaseQueries(this);
    private ArrayList<Event> eventDetails;
    public String typeSearchTerm;
    private ListView lv1;
    private int currentUser;
    public static final String EXTRA_EVENT_ID = "event_id";
    private static final SimpleDateFormat parseTime = new SimpleDateFormat("hh:mm a");



    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


       // Intent i = getIntent();
       //typeSearchTerm = i.getStringExtra(String.valueOf(R.string.event_type_extra));
       // Log.d("Search Term", typeSearchTerm);


        //TRY TO FILL THE ARRAYLIST WITH ALL EVENTS
        DatabaseQueries dq = new DatabaseQueries(this);
        try {
            //eventDetails = dq.getAllEventsCategory(typeSearchTerm);
            eventDetails = dq.getAllEvents();
            Log.d("ARRAY SIZE", eventDetails.size() + "");

        } catch (ParseException e) {
            e.printStackTrace();
        }


        lv1 = (ListView)findViewById(R.id.categoryListView);

        lv1.setAdapter(new eventItemAdapter(this, eventDetails));
        Log.d("debug", 20 + "");

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                Event e = (Event) o;
                // Intent i = new Intent(CategoryActivity.this, EventItemActivity.class);
                Toast.makeText(CategoryActivity.this, "This event starts at " + parseTime.format(e.getEventStartTime()), Toast.LENGTH_LONG).show();
                Log.d("EVENT HAS", e.getEventName());
                Log.d(" EVENT ID", String.valueOf(e.getEventID()));
                // i.putExtra(EXTRA_EVENT_ID, e.getEventID() + "");

               // startActivity(i);


            }
        });

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            DatabaseQueries dq = new DatabaseQueries(CategoryActivity.this);

            @Override
            public boolean onItemLongClick(final AdapterView<?> arg0, View arg1,
                                           final int position, long arg3) {

                Object o = lv1.getItemAtPosition(position);
                final Event e = (Event) o;

                //Toast.makeText(CategoryActivity.this, "Delete " + parseTime.format(e.getEventStartTime()), Toast.LENGTH_SHORT).show();



                AlertDialog.Builder alert = new AlertDialog.Builder(CategoryActivity.this);
                alert.setMessage("Are you sure you want to delete this \"" + e.getEventName() +"\" ?");
                Log.d("asdasd", "" + e.getEventID());
                alert.setCancelable(false);
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("sdgthrjh", "" + e.getEventID());
                        dq.deleteEvent(e.getEventID());

                        //remove the item on the list and refresh the list

                       lv1.invalidateViews();
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                alert.show();


                return true;

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id== R.id.action_add) {
            Intent i = new Intent(this, CategoryActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }





}
