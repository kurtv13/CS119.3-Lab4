package com.kurtbautista.lab4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Student on 6/30/2016.
 */
public class FoodReviewAdapter extends BaseAdapter {

    private Activity context;
    private ArrayList<FoodReview> foodReviews;

    public FoodReviewAdapter(Activity context, ArrayList<FoodReview> foodReviews)
    {
        this.context = context;
        this.foodReviews = foodReviews;
    }

    @Override
    public int getCount() {
        return foodReviews.size();
    }

    @Override
    public Object getItem(int i) {
        return foodReviews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = context.getLayoutInflater().inflate(R.layout.food_row, null);

        ImageView img = (ImageView)v.findViewById(R.id.imageView);
        TextView name = (TextView)v.findViewById(R.id.reviewByText);
        TextView price = (TextView)v.findViewById(R.id.foodPriceText);
        CheckBox[] rating = new CheckBox[] {(CheckBox)v.findViewById(R.id.oneCheckBox), (CheckBox)v.findViewById(R.id.twoCheckBox),
                (CheckBox)v.findViewById(R.id.threeCheckBox), (CheckBox)v.findViewById(R.id.fourCheckBox), (CheckBox)v.findViewById(R.id.fiveCheckBox)};
        Button description = (Button)v.findViewById(R.id.descriptionButton);
        Button edit = (Button)v.findViewById(R.id.editButton);
        Button delete = (Button)v.findViewById(R.id.deleteButton);

        FoodReview review = foodReviews.get(i);

        //img.setImageResource();
        name.setText(review.getUser());
        price.setText("Php " + review.getPrice());
        for(int x = 0; x < review.getRating(); x++)
        {
            rating[x].setChecked(true);
        }

        description.setTag(i);
        edit.setTag(i);
        delete.setTag(i);

        return v;

        //return null;
    }
}