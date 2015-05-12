package application.floc.event.eventfloc.Fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import application.floc.event.eventfloc.Activities.CategoryActivity;
import application.floc.event.eventfloc.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends android.support.v4.app.Fragment {

    private Button careersButton;
    private Button facultyButton;
    private Button interestsButton;
    private Button culturalButton;
    private Button foodButton;
    private Button freeFoodButton;
    private Button sportsButton;
    private Button fundraisersButton;
    private Button learningButton;
    private Button festivalsButton;
    private Button performingArtsButton;
    private Button politicalButton;

   // private String eventType;
//    private String[] mEventTypes = getResources().getStringArray(R.array.categories);


    public ExploreFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View rootView = inflater.inflate(R.layout.fragment_home_explore, container, false);

        careersButton = (Button)rootView.findViewById(R.id.categoryCareersButton);
        facultyButton = (Button)rootView.findViewById(R.id.categoryFacultyButton);
        interestsButton = (Button)rootView.findViewById(R.id.categoryInterestsButton);
        culturalButton = (Button)rootView.findViewById(R.id.categoryCulturalButton);
        foodButton = (Button)rootView.findViewById(R.id.categoryFoodButton);
        freeFoodButton = (Button)rootView.findViewById(R.id.categoryFreeFoodButton);
        sportsButton = (Button)rootView.findViewById(R.id.categorySportsButton);
        fundraisersButton = (Button)rootView.findViewById(R.id.categoryFundraisersButton);
        learningButton = (Button)rootView.findViewById(R.id.categoryLearningButton);
        festivalsButton = (Button)rootView.findViewById(R.id.categoryFestivalButton);
        performingArtsButton = (Button)rootView.findViewById(R.id.categoryPerformingArtsButton);
        politicalButton = (Button)rootView.findViewById(R.id.categoryPoliticalButton);

        View v = inflater.inflate(R.layout.fragment_home_explore_category, container, false);


        careersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Careers");
                String eventType = String.valueOf(R.string.category_careers);
                Log.d("BUTTON PRESSED: ", "Careers");
                toastMaker(careersButton, "Careers");

                //Start the activity
                startActivity(i);
            }
        });

        facultyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Faculty");
                String eventType = String.valueOf(R.string.category_faculty);

               // eventType = mEventTypes[1];
                Log.d("BUTTON PRESSED: ", "Faculty");
                toastMaker(facultyButton, "Faculty");

                //Start the activity
                startActivity(i);
            }
        });

        interestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Interests");
                String eventType = String.valueOf(R.string.category_interests);

               // eventType = mEventTypes[2];
                Log.d("BUTTON PRESSED: ", "Interests");
                toastMaker(interestsButton, "Interests");

                //Start the activity
                startActivity(i);
            }
        });

        culturalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Cultural");
                String eventType = String.valueOf(R.string.category_cultural);

                //eventType = mEventTypes[3];
                Log.d("BUTTON PRESSED: ", "Cultural");
                toastMaker(culturalButton, "Cultural");

                //Start the activity
                startActivity(i);
            }
        });

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Food");
                String eventType = String.valueOf(R.string.category_food);
               // eventType = mEventTypes[4];
                Log.d("BUTTON PRESSED: ", "Food");
                toastMaker(foodButton, "Food");

                //Start the activity
                startActivity(i);
            }
        });

        freeFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Free Food");
                String eventType = String.valueOf(R.string.category_free_food);
               // eventType = mEventTypes[5];
                Log.d("BUTTON PRESSED: ", "Free Food");
                toastMaker(freeFoodButton, "Free Food");

                //Start the activity
                startActivity(i);
            }
        });

        sportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Sports");
                String eventType = String.valueOf(R.string.category_sports);
               // eventType = mEventTypes[6];
                Log.d("BUTTON PRESSED: ", "Sports");
                toastMaker(sportsButton, "Sports");

                //Start the activity
                startActivity(i);
            }
        });

        fundraisersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Fundraiser");
                String eventType = String.valueOf(R.string.category_fundraiser);
               // eventType = mEventTypes[7];
                Log.d("BUTTON PRESSED: ","Fundraiser");
                toastMaker(fundraisersButton, "Fundraiser");

                //Start the activity
                startActivity(i);
            }
        });

        learningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Learning");
                String eventType = String.valueOf(R.string.category_learning);
               // eventType = mEventTypes[8];
                Log.d("BUTTON PRESSED: ", "Learning");
                toastMaker(learningButton, "Learning");

                //Start the activity
                startActivity(i);
            }
        });

        festivalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Festival");
                String eventType = String.valueOf(R.string.category_festivals);
               // eventType = mEventTypes[9];
                Log.d("BUTTON PRESSED: ", "Festival");
                toastMaker(festivalsButton, "Festival");

                //Start the activity
                startActivity(i);
            }
        });

        performingArtsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);
                i.putExtra(String.valueOf(R.string.event_type_extra),"Performing Arts");
                String eventType = String.valueOf(R.string.category_performing_arts);
               // eventType = mEventTypes[10];
                Log.d("BUTTON PRESSED: ", "Performing Arts");
                toastMaker(performingArtsButton, "Performing Arts");

                //Start the activity
                startActivity(i);
            }
        });

        politicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(view.getContext(), CategoryActivity.class);

                i.putExtra(String.valueOf(R.string.event_type_extra),"Political");
                String eventType = String.valueOf(R.string.category_political);
                //eventType = mEventTypes[11];
                Log.d("BUTTON PRESSED: ", "Political");
                toastMaker(politicalButton, "Political");

                //Start the activity
                startActivity(i);
            }
        });






        return rootView;
    }

    /**
     * Make a toast depending on a view.
     * @param v
     * @param category
     */
    private void toastMaker(View v, String category){
        //make toast
        Toast.makeText(v.getContext(), "You have pressed: " + category, Toast.LENGTH_LONG).show();

    }


}
